package com.lec.robot.v3_추상화;

public abstract class Robot {
	public String name;
	public int qty;
	
	public Robot(String name, int qty) {
		super();
		this.name = name;
		this.qty = qty;
	}
	
	public void shape() {System.out.println(this.name + "Robot 입니다. 팔 , 다리 ,몸통이 있습니다.");}
	public void actionWalk() {System.out.println(this.name + " 걸을 수 있습니다.");}
	public void actionRun() {System.out.println(this.name + " 달릴 수 있습니다.");}
	
	//추상메서드
	//추상메서드를 쓰려면 클래스도 추상 클래스여야 한다.
	// actionFly, actionMissile, actionSword
	
	public abstract void actionFly();
	
	public abstract void actionMissile();
	
	public abstract void actionSword();
	
	
}
