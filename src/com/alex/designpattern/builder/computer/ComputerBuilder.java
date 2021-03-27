package com.alex.designpattern.builder.computer;

public abstract class ComputerBuilder {
	protected Computer computer = new Computer();

	public abstract void buildCpu();

	public abstract void buildMemory();

	public abstract void buildHardware();

	public abstract void buildMainBoard();

	public abstract void buildMonitor();

	public boolean isMonitor(){
		return true;
	}

	protected Computer create(){
		return computer;
	}
}
