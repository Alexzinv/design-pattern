package com.alex.designpattern.builder.computer;

public class Laptop extends ComputerBuilder{
	@Override
	public void buildCpu() {
		computer.setCpu("Intel");
	}

	@Override
	public void buildMemory() {
		computer.setMemory(16);
	}

	@Override
	public void buildHardware() {
		computer.setHardware(512);
	}

	@Override
	public void buildMainBoard() {
		computer.setMainBoard("MSI");
	}

	@Override
	public void buildMonitor() {
		computer.setMonitor("AOC");
	}
}
