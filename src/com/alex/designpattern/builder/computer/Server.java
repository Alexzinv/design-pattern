package com.alex.designpattern.builder.computer;

public class Server extends ComputerBuilder{
	@Override
	public void buildCpu() {
		computer.setCpu("Intel");
	}

	@Override
	public void buildMemory() {
		computer.setMemory(128);
	}

	@Override
	public void buildHardware() {
		computer.setHardware(102400);
	}

	@Override
	public void buildMainBoard() {
		computer.setMainBoard("MSI");
	}

	@Override
	public void buildMonitor() {
	}

	@Override
	public boolean isMonitor() {
		return false;
	}
}
