package com.alex.designpattern.builder.computer;

public class Computer {
	private String cpu;
	private int memory;
	private int hardware;
	private String mainBoard;
	private String monitor;

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public int getHardware() {
		return hardware;
	}

	public void setHardware(int hardware) {
		this.hardware = hardware;
	}

	public String getMainBoard() {
		return mainBoard;
	}

	public void setMainBoard(String mainboard) {
		this.mainBoard = mainboard;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	@Override
	public String toString() {
		return "Computer{" +
				"cpu='" + cpu + '\'' +
				", memory=" + memory +
				", hardware=" + hardware +
				", mainBoard='" + mainBoard + '\'' +
				", monitor='" + monitor + '\'' +
				'}';
	}
}
