package com.alex.designpattern.mediator.customermanagementwindow;

/**
 * @author Alex
 */
public class ComboBox extends Component {
	@Override
	public void update() {
		System.out.println("combo box" + name + " update ...");
	}

	public void select(){
		System.out.println("combo box" + name + " checked");
	}
}
