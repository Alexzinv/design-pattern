package com.alex.designpattern.adapter.caradapter;

public class AmbulanceCarAdapter extends CarController{
	private AmbulanceSound sound;
	private AmbulanceLamp lamp;

	public AmbulanceCarAdapter(){}

	public AmbulanceCarAdapter(AmbulanceSound sound, AmbulanceLamp lamp){
		this.sound = sound;
		this.lamp = lamp;
	}

	public AmbulanceSound getSound() {
		return sound;
	}

	public void setSound(AmbulanceSound sound) {
		this.sound = sound;
	}

	public AmbulanceLamp getLamp() {
		return lamp;
	}

	public void setLamp(AmbulanceLamp lamp) {
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
