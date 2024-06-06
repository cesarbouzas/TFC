package com.ontimize.hr.model.core.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ontimize.hr.api.core.exceptions.*;
import com.ontimize.hr.model.core.tools.TypeCodes.type;
import com.ontimize.jee.common.db.SQLStatementBuilder;
import com.ontimize.jee.common.dto.EntityResult;



@Component
public class ControlFields {

	private static final String HELP_KEY_INFO = "help_info";
	private Map<String, type> fields;
	private List<String> restricted;
	private List<String> required;
	private List<String> roleUsersRestrictions;
	private boolean optional;
	private boolean noEmptyList;
	private boolean noWildcard;
	private boolean allowBasicExpression;
	private boolean allowHelpCommand;
	private boolean controlPermissionsActive;
	private String detailsMsg = "";



	@Autowired
	ValidateFields vF;



	public ControlFields() {
//		reset();
	}

	public void reset() {
		fields = new HashMap<String, type>();
		restricted = new ArrayList<>();
		required = new ArrayList<>();
		optional = true;
		noEmptyList = true; // solo para las Listas no los HashMap
		noWildcard = true;
		allowBasicExpression = true;
		allowHelpCommand = true;


	}

	

	public void setAllowBasicExpression(boolean allowBasicExpression) {
		this.allowBasicExpression = allowBasicExpression;
	}

	public void setControlPermissionsActive(boolean controlPermissionsActive) {
		this.controlPermissionsActive = controlPermissionsActive;
	}


	public void addBasics(Map<String, type> fields) {
		this.fields.putAll(fields);
	}

	public void addBasics(Map<String, type>... arrayfields) {
		for (Map<String, type> fields : arrayfields) {
			this.fields.putAll(fields);
		}
	}

	public void setRequired(List<String> requiredFields) {
		this.required = requiredFields;
	}

	public void setRestricted(List<String> restrictedFields) {
		this.restricted = restrictedFields;
	}

	public void setOptional(boolean optional) {
		this.optional = optional;
	}

	public boolean isNoEmptyList() {
		return noEmptyList;
	}

	public void setNoEmptyList(boolean noEmptyList) {
		this.noEmptyList = noEmptyList;
	}

	public boolean isNoWildcard() {
		return noWildcard;
	}

	public void setNoWildcard(boolean noWildcard) {
		this.noWildcard = noWildcard;
	}

	/**
	 * 
	 * @param keyMap
	 * @throws MissingFieldsException
	 * @throws RestrictedFieldException
	 * @throws InvalidFieldsException
	 * @throws InvalidFieldsValuesException
	 * @throws LiadaPardaException
	 * @throws InfoValidateException
	 */
	@SuppressWarnings("static-access")
	public void validate(Map<String, Object> keyMap) throws MissingFieldsException, RestrictedFieldException,
			InvalidFieldsException, InvalidFieldsValuesException, LiadaPardaException, InfoValidateException {

		if (keyMap == null) {
			throw new MissingFieldsException(ErrorMessage.NO_NULL_DATA);
		}

		// no podemos hacer este metodo, porque
//		if( !allowBasicExpression && keyMap.containsKey(SQLStatementBuilder.ExtendedSQLConditionValuesProcessor.EXPRESSION_KEY)) {		
//			throw new InvalidFieldsException(ErrorMessage.NO_BASIC_EXPRESSION);
//		}
		if (allowHelpCommand && keyMap.containsKey(HELP_KEY_INFO)) {
			throw new InfoValidateException(infoValidateMapER());
		}
		for (String key : required) {
			if (!keyMap.containsKey(key)) {
				throw new MissingFieldsException(ErrorMessage.REQUIRED_FIELD + key);
			}
		}

		for (String key : restricted) {
			if (keyMap.containsKey(key)) {
				throw new RestrictedFieldException(ErrorMessage.INVALID_FIELD + key);
			}
		}

		if (!optional && required.isEmpty()) {
			throw new LiadaPardaException(ErrorMessage.INTERNAL_CAGADA);
		} else {
			if (!optional && (required.size() != keyMap.size())) {
				throw new InvalidFieldsException(ErrorMessage.ALLOWED_FIELDS + required.toString());
			}
		}

//validar typos y valores
		for (String key : keyMap.keySet()) {
			boolean validType = false;
			detailsMsg = "";
			if (fields.containsKey(key)) {// valida que exista en los fields
				if (keyMap.get(key) == null) {
					throw new MissingFieldsException(ErrorMessage.NO_NULL_VALUE + key);
				}

				switch (fields.get(key)) {
				case TEXT:
					validType = ((keyMap.get(key) instanceof String));
					break;

				case NO_EMPTY_TEXT:
					if ((keyMap.get(key) instanceof String)) {
						if (((String) keyMap.get(key)).isEmpty()) {
							detailsMsg = ErrorMessage.STRING_EMPTY;
						} else {
							validType = true;
						}
					}
					break;

				case NO_EMPTY_STRING:
					if ((keyMap.get(key) instanceof String)) {
						if (((String) keyMap.get(key)).isEmpty()) {
							detailsMsg = ErrorMessage.STRING_EMPTY;
						} else if (((String) keyMap.get(key)).length() > 255) {
							detailsMsg = ErrorMessage.STRING_TOO_LONG;
						} else {
							validType = true;
						}
					}
					break;

				case STRING:
					if ((keyMap.get(key) instanceof String)) {
						if (((String) keyMap.get(key)).length() > 255) {
							detailsMsg = ErrorMessage.STRING_TOO_LONG;
						} else {
							validType = true;
						}
					}
					break;

				case NO_EMPTY_SMALL_STRING:
					if ((keyMap.get(key) instanceof String)) {
						if (((String) keyMap.get(key)).isEmpty()) {
							detailsMsg = ErrorMessage.STRING_EMPTY;
						} else if (((String) keyMap.get(key)).length() > 50) {
							detailsMsg = ErrorMessage.SMALL_STRING_TOO_LONG;
						} else {
							validType = true;
						}
					}
					break;

				case SMALL_STRING:
					if ((keyMap.get(key) instanceof String)) {
						if (((String) keyMap.get(key)).length() > 50) {
							detailsMsg = ErrorMessage.SMALL_STRING_TOO_LONG;
						} else {
							validType = true;
						}
					}
					break;

				case INTEGER:
					validType = ((keyMap.get(key) instanceof Integer));
					break;

				case LONG:
					validType = (keyMap.get(key) instanceof Integer || keyMap.get(key) instanceof Long);
					break;

				case DOUBLE:
					validType = (keyMap.get(key) instanceof Integer || keyMap.get(key) instanceof Long
							|| keyMap.get(key) instanceof Double);
					break;

				case PRICE:
					if (keyMap.get(key) instanceof Integer || keyMap.get(key) instanceof Double) {
						try {
							vF.formatprice(keyMap.get(key));
							validType = true;
						} catch (InvalidFieldsValuesException e) {
							detailsMsg = e.getMessage();
						}
					}
					break;

				case CREDIT_CARD:
					if (keyMap.get(key) instanceof Long) {
						try {
							vF.invalidCreditCard((Long) keyMap.get(key));
							validType = true;
						} catch (InvalidFieldsValuesException e) {
							detailsMsg = e.getMessage();
						}
					}
					break;

				case EXPIRATION_DATE:
					if ((keyMap.get(key) instanceof String)) {
						try {
							vF.validDateExpiry((String) keyMap.get(key));
							validType = true;
						} catch (InvalidFieldsValuesException e) {
							detailsMsg = e.getMessage();
						}
					}
					break;

				case PHONE:
					validType = ((keyMap.get(key) instanceof String) && vF.isPhone((String) keyMap.get(key)));
					break;

				

				case DATETIME:// diferenciar al devolver los datos
				case DATE:
					if ((keyMap.get(key) instanceof String)) {
						keyMap.replace(key, vF.stringToDate((String) keyMap.get(key)));
						validType = true;
					} else if ((keyMap.get(key) instanceof Date)) {
						validType = true;
					}
					break;

				case EMAIL:
					validType = ((keyMap.get(key) instanceof String) && vF.checkMail((String) keyMap.get(key)));
					break;

				case DNI:
					if ((keyMap.get(key) instanceof String) && vF.isDNI((String) keyMap.get(key))) {
						keyMap.replace(key, ((String) keyMap.get(key)).toUpperCase());
						validType = true;
					}
					break;

				case INTEGER_UNSIGNED:
					if ((keyMap.get(key) instanceof Integer)) {
						try {
							vF.NegativeNotAllowed((Integer) keyMap.get(key));
							validType = true;
						} catch (InvalidFieldsValuesException e) {
							detailsMsg = e.getMessage();
						}
					}
					break;

				case BOOLEAN:
					validType = ((keyMap.get(key) instanceof Integer) && vF.isBoolean((Integer) keyMap.get(key)));
					break;

				
				default:
					throw new InvalidFieldsValuesException(ErrorMessage.WRONG_TYPE + key);
				}

				if (!validType) {
					throw new InvalidFieldsValuesException(ErrorMessage.WRONG_TYPE + key + ErrorMessage.REQUIRED_TYPE
							+ fields.get(key) + " " + detailsMsg);
				}

				// STRING, INTEGER, INTEGER_UNSIGNED, LONG, LONG_UNSIGNED, DOUBLE,
				// DOUBLE_UNSIGNED, PRICE, EMAIL, CREDIT_CARD,
				// PHONE, DATE, DATETIME, ACTION, BOOLEAN, COUNTRY

			} else {
				if (allowBasicExpression
						&& key.equals(SQLStatementBuilder.ExtendedSQLConditionValuesProcessor.EXPRESSION_KEY)) {
					// TODO comprobamos contenido de basic expresion....
				} else {
					throw new InvalidFieldsException(ErrorMessage.INVALID_FIELD + key);
				}
			}
		}}
		// permisos

	

	/**
	 * Para validar atributos de vuelta. Ignora los valores.
	 * 
	 * @param columns Lista de camos a validar
	 * @throws MissingFieldsException
	 * @throws RestrictedFieldException
	 * @throws LiadaPardaException
	 * @throws InvalidFieldsException
	 * @throws InfoValidateException
	 */
	public void validate(List<String> columns) throws MissingFieldsException, RestrictedFieldException,
			LiadaPardaException, InvalidFieldsException, InfoValidateException {

		if (columns == null) {
			throw new MissingFieldsException(ErrorMessage.NO_NULL_DATA);
		}

		if (allowHelpCommand && columns.contains(HELP_KEY_INFO)) {
			throw new InfoValidateException(infoValidateListER());
		}
		if (noEmptyList) {
			int minimuSize = 1;

			if (noWildcard && columns.contains("*")) {
				minimuSize++;
			}

			if (columns.size() < minimuSize) {
				throw new MissingFieldsException(ErrorMessage.REQUIRED_MINIMUM_COLUMS);
			}

			for (String key : required) {
				if (!columns.contains(key)) {
					throw new MissingFieldsException(ErrorMessage.REQUIRED_COLUMN + key);
				}
			}

			for (String key : restricted) {
				if (columns.contains(key)) {
					throw new RestrictedFieldException(ErrorMessage.INVALID_COLUM + key);
				}
			}

			if (!optional && required.isEmpty()) {
				throw new LiadaPardaException(ErrorMessage.INTERNAL_CAGADA);
			} else {
				if (!optional && (required.size() != columns.size())) {
					throw new InvalidFieldsException(ErrorMessage.ALLOWED_COLUMSS + required.toString());
				}
			}

			for (String key : columns) {
				if (!fields.containsKey(key)) {
					throw new InvalidFieldsException(ErrorMessage.INVALID_COLUM + key);
				}
			}
		} else { // si tiene que ser lista vacía;
			if (noWildcard && columns.contains("*")) {
				columns.remove("*");
			}
			if (columns.size() > 0) {
				throw new InvalidFieldsException(ErrorMessage.NO_ALLOW_COLUMS);
			} else {
				columns.add("null"); // para saltarse los filtros de ontimize
			}
		}
	}

	public String infoValidateList() {
		StringBuilder info = new StringBuilder();
		Set<String> infoValid = (fields.keySet());
		infoValid.removeAll(restricted);

		info.append("\n---------------------\n");
		info.append("Colums info: ");
		info.append("\t\nValid fields: \n\t\t" + infoValid);
		info.append("\t\nRequired fields: \n\t\t" + required.toString());
		info.append("\t\nAllow Optional fields: " + optional);
		info.append("\t\nAllow Empty List: " + !noEmptyList);
		info.append("\n---------------------\n");

		return info.toString();
	}

	public EntityResult infoValidateListER() {
		List<String> infoValid;
		if (!optional) {
			infoValid = required;
		} else {
			infoValid = new ArrayList<>(fields.keySet());
			infoValid.removeAll(restricted);
		}
		return new EntityResultWrong(new HashMap<String, Object>() {
			{
				put("Columns info", new HashMap<String, Object>() {
					{
						put("Valid columns", infoValid);
						put("Required columns", required);
//						put("Allow Optional columns", optional);
						put("WARNING", "Remove columm '" + HELP_KEY_INFO + "' to disable this result");
					}
				});
			}
		});
	}

	public EntityResult infoValidateMapER() {
		EntityResult eR = new EntityResultWrong();

		HashMap<String, Object> infoValid = new HashMap<>();
		infoValid.putAll(fields);
		infoValid.keySet().removeAll(restricted);

		if (!optional) {
			infoValid.keySet().removeIf(t -> !required.contains(t));
		}
		return new EntityResultWrong(new HashMap<String, Object>() {
			{
				put("Fields info", new HashMap<String, Object>() {
					{
						put("Valid fields", infoValid);
						put("Required fields", required);
//						put("Allow Optional fields", optional);
//						put("Allow BasicExpressions", allowBasicExpression);
						put("WARNING", "Remove field '" + HELP_KEY_INFO + "' to disable this result");
					}
				});
			}
		});

	}

	public String infoValidateMap() {
		StringBuilder info = new StringBuilder();

		HashMap<String, Object> infoValid = new HashMap<>();
		infoValid.putAll(fields);
		infoValid.keySet().removeAll(restricted);

		info.append("\n---------------------\n");
		info.append("Fields info:");
		info.append("\n\tValid fields/types: \n\t\t" + infoValid.toString());
		info.append("\n\tRequired fields: \n\t\t" + required.toString());
		info.append("\n\tAllow Optional fields: " + optional);
		info.append("\n\tAllow BasicExpressions: " + allowBasicExpression);
		info.append("\n---------------------\n");
		return info.toString();
	}



}