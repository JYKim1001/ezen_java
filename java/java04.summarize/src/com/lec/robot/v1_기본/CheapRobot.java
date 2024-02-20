package com.lec.robot.v1_기본;

public class CheapRobot {

	public int qty;
	
	public CheapRobot(int qty) {
		super();
		this.qty = qty;
		
	}
	
	public void shape() {System.out.println("CheapRobot 입니다. 팔 , 다리 ,몸통이 있습니다.");}
	public void actionWalk() {System.out.println("걸을 수 있습니다.");}
	public void actionRun() {System.out.println("달릴 수 있습니다.");}
	public void actionFly() {System.out.println("날 수 없습니다.");}
	public void actionMissile() {System.out.println("미사일 쏠 수 가 없어습니다.");}
	public void actionSword() {System.out.println("검이 없습니다.");}
	
	
	
	
	
	
}
