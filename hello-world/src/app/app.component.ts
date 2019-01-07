import { Component } from '@angular/core';

/*
  Component directive - this decorator defines the AppComponent
  class to be a component (reusable portion of the view)
*/
@Component({
  // tag name for the custom HTML element representing this component
  selector: 'app-root',
  // where is the template?
  templateUrl: './app.component.html',
  // stylesheets used in this component
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'this is new value for my title which is interpolated onto my view';
}
