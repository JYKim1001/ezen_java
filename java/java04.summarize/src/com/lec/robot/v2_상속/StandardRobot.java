package com.lec.robot.v2_상속;

public class StandardRobot extends Robot {

	public StandardRobot(String name, int qty) {
		super(name, qty);
	
	}

	public void actionFly() {System.out.println("날 수 없습니다.");}
	public void actionMissile() {System.out.println("미사일 쏠 수 가 있습니다.");}
	public void actionSword() {System.out.println("목검이 있습니다.");}
	
}
