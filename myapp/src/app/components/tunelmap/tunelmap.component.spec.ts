import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TunelMapComponent } from './tunelmap.component';

describe('TunelMapComponent', () => {
  let component: TunelMapComponent;
  let fixture: ComponentFixture<TunelMapComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TunelMapComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TunelMapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
