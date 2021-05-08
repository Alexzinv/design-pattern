package com.alex.designpattern.mediator.customermanagementwindow;

/**
 * @author Alex
 */
public abstract class Component {

	/**
	 * 中介者
	 */
	protected Mediator mediator;
	protected String name;

	public void setMediator(Mediator mediator){
		this.mediator = mediator;
	}

	public void change(){
		mediator.componentChanged(this);
	}

	/**
	 * 更新内容
	 */
	public abstract void update();

	public Mediator getMediator() {
		return mediator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
