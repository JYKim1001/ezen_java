package com.lec.robot.v4_인터페이스;

import com.lec.robot.v4_인터페이스.inter.InterFly;
import com.lec.robot.v4_인터페이스.inter.InterMissile;
import com.lec.robot.v4_인터페이스.inter.InterSword;

public class StandardRobot extends Robot {

	InterFly fly;
	InterMissile missile;
	InterSword sword;
	
	public void setFly(InterFly fly) {this.fly = fly;}

	public void setMissile(InterMissile missile) {
		this.missile = missile;
	}

	public void setSword(InterSword sword) {
		this.sword = sword;
	}

	public StandardRobot(String name, int qty) {
		super(name, qty);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionFly() {
		fly.Fly();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionMissile() {
		// TODO Auto-generated method stub
		missile.missile();	
	}

	@Override
	public void actionSword() {
		// TODO Auto-generated method stub
		sword.Sword();
	}
	
	

}
