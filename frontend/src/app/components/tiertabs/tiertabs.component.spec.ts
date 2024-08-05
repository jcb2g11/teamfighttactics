import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TiertabsComponent } from './tiertabs.component';

describe('TiertabsComponent', () => {
  let component: TiertabsComponent;
  let fixture: ComponentFixture<TiertabsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TiertabsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TiertabsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
