package com.alex.designpattern.adapter.caradapter;

public class PoliceCarAdapter extends CarController{
	private PoliceSound sound;
	private PoliceLamp lamp;

	public PoliceCarAdapter(){
		this.sound = new PoliceSound();
		this.lamp = new PoliceLamp();
	}

	public PoliceCarAdapter(PoliceSound sound, PoliceLamp lamp){
		this.sound = sound;
		this.lamp = lamp;
	}

	public PoliceSound getSound() {
		return sound;
	}

	public void setSound(PoliceSound sound) {
		this.sound = sound;
	}

	public PoliceLamp getLamp() {
		return lamp;
	}

	public void setLamp(PoliceLamp lamp) {
		this.lamp = lamp;
	}

	@Override
	public void phonate() {
		sound.alarmSound();
	}

	@Override
	public void twinkle() {
		lamp.alarmLamp();
	}
}
