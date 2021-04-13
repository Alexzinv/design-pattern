package com.alex.designpattern.decorator.visual;

public class ComponentDecorator extends VisualComponent {

	protected VisualComponent visualComponent;

	public VisualComponent getVisualComponent() {
		return visualComponent;
	}

	public void setVisualComponent(VisualComponent visualComponent) {
		this.visualComponent = visualComponent;
		this.name = visualComponent.name + "_decorator";
	}

	@Override
	public void display() {
		visualComponent.display();
	}
}
