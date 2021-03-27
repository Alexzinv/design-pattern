package com.alex.designpattern.builder.computer;

public class PC extends ComputerBuilder{
	@Override
	public void buildCpu() {
		computer.setCpu("AMD");
	}

	@Override
	public void buildMemory() {
		computer.setMemory(32);
	}

	@Override
	public void buildHardware() {
		computer.setHardware(1024);
	}

	@Override
	public void buildMainBoard() {
		computer.setMainBoard("ROG");
	}

	@Override
	public void buildMonitor() {
		computer.setMonitor("Philps");
	}
}
