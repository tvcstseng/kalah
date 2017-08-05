import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KalahGameComponent } from './kalah-game.component';

describe('KalahGameComponent', () => {
  let component: KalahGameComponent;
  let fixture: ComponentFixture<KalahGameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KalahGameComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KalahGameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
