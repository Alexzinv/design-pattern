package com.alex.designpattern.mediator.customermanagementwindow;

/**
 * @author Alex
 */
public class Client {
	public static void main(String[] args) {
		ConcreteMediator mediator = new ConcreteMediator();
		Button button = new Button();
		SelectList list = new SelectList();
		ComboBox box = new ComboBox();
		TextBox textBox = new TextBox();

		mediator.setButton(button);
		mediator.setList(list);
		mediator.setBox(box);
		mediator.setTextBox(textBox);

		button.setName("button1");
		list.setName("sdfafa");
		box.setName("_fdsad_fsd_");
		textBox.setName("T_e_x_t");

		button.setMediator(mediator);
		button.change();
	}
}
