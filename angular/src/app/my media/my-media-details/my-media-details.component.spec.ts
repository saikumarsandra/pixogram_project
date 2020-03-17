import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyMediaDetailsComponent } from './my-media-details.component';

describe('MyMediaDetailsComponent', () => {
  let component: MyMediaDetailsComponent;
  let fixture: ComponentFixture<MyMediaDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyMediaDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyMediaDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
