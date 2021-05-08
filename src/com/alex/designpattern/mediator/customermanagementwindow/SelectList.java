package com.alex.designpattern.mediator.customermanagementwindow;

/**
 * @author Alex
 */
public class SelectList extends Component {
	@Override
	public void update() {
		System.out.println("select list" + name + " update ...");
	}

	public void select(){
		System.out.println("select list" + name + " checked");
	}
}
