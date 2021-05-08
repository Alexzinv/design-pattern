package com.alex.designpattern.mediator.customermanagementwindow;

import org.junit.Test;

/**
 * @author Alex
 */
public class ConcreteMediator extends Mediator {

	private Button button;
	private SelectList list;
	private TextBox textBox;
	private ComboBox box;

	@Override
	public void componentChanged(Component c) {
		if(c.getName().equals(button.getName())){
			System.out.println("点击button: " + button.getName());
			list.update();
			textBox.update();
			box.update();
		}else if(c.getName().equals(list.getName())){
			System.out.println("选中select list: " + list.getName());
			box.update();
			textBox.setText(list.getName() + "~~");
		}else if(c.getName().equals(box.getName())){
			System.out.println("选中Combo box: " + box.getName());
			list.select();
			textBox.setText(box.getName() + "!!");
		}
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public SelectList getList() {
		return list;
	}

	public void setList(SelectList list) {
		this.list = list;
	}

	public TextBox getTextBox() {
		return textBox;
	}

	public void setTextBox(TextBox textBox) {
		this.textBox = textBox;
	}

	public ComboBox getBox() {
		return box;
	}

	public void setBox(ComboBox box) {
		this.box = box;
	}
}
