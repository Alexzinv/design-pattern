package com.alex.designpattern.builder.computer;

public class ComputerController {
	public Computer construct(ComputerBuilder cb){
		cb.buildCpu();
		cb.buildMemory();
		cb.buildHardware();
		cb.buildMainBoard();
		if(cb.isMonitor()){
			cb.buildMonitor();
		}
		return cb.create();
	}
}
