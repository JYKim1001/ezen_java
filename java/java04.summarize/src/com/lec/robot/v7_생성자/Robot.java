package com.lec.robot.v7_생성자;

import com.lec.robot.v4_인터페이스.inter.InterFly;
import com.lec.robot.v4_인터페이스.inter.InterMissile;
import com.lec.robot.v4_인터페이스.inter.InterSword;

public class Robot {

	InterFly fly;
	InterMissile missile;
	InterSword sword;
	
	public String name;
	public int qty;
	
	public Robot( String name, int qty, InterFly fly, InterMissile missile, InterSword sword) {
		super();
		this.name = name; 
		this.qty = qty;   
		this.fly = fly;
		this.missile = missile;
		this.sword = sword;
		
		
	}
	
	//일반 메서드 (공통 기능)
	public void shape() {System.out.println(this.name+"Robot 입니다. 팔, 다리, 몸통이 있습니다.");}
	public void actionWalk() {System.out.println("걸을 수가 있습니다.");}
	public void actionRun() {System.out.println("달릴 수가 있습니다.");}
	
	
	//개별 기능
	public void actionFly() {fly.Fly();}
	public void actionMissile() {missile.missile();}
	public void actionSword() {sword.Sword();}

	
	//생산공장
	public void productRobot() {
		shape();
		actionWalk();
		actionRun();
		actionFly();
		actionMissile();
		actionSword();
		System.out.println(this.toString() + "\n");
		
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + "의 재고 수량 = " + this.qty;
	}
	
	
	
	
	
	
	
	
	
}
