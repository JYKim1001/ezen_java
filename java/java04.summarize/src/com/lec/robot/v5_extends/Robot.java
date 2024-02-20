package com.lec.robot.v5_extends;

import com.lec.robot.v4_인터페이스.inter.InterFly;
import com.lec.robot.v4_인터페이스.inter.InterMissile;
import com.lec.robot.v4_인터페이스.inter.InterSword;

public class Robot {

	InterFly fly;
	InterMissile missile;
	InterSword sword;
	

	public String name;
	public int qty;
	
	public Robot(String name, int qty) {
		super();
		this.name = name;
		this.qty = qty;	
	}
	
	//일반 메서드
	public void shape() {System.out.println(this.name+"Robot 입니다. 팔, 다리, 몸통이 있습니다.");}
	public void actionWalk() {System.out.println("걸을 수가 있습니다.");}
	public void actionRun() {System.out.println("달릴 수가 있습니다.");}
	
	
	//Setter
	public void setFly(InterFly fly) {this.fly = fly;}
	public void setMissile(InterMissile missile) {this.missile = missile;}
	public void setSword(InterSword sword) {this.sword = sword;}
	
	
	public void actionFly() {fly.Fly();}


	public void actionMissile() {missile.missile();}


	public void actionSword() {sword.Sword();}
	
	
	
	
	
	
	
	
	
	
}