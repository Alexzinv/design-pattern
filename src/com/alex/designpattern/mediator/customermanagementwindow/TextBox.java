package com.alex.designpattern.mediator.customermanagementwindow;

/**
 * @author Alex
 */
public class TextBox extends Component {

	public void setText(String s){
		System.out.println("text box " + name + " setting text: " + s);
	}

	@Override
	public void update() {
		System.out.println("text box " + name +" update ...");
	}
}
