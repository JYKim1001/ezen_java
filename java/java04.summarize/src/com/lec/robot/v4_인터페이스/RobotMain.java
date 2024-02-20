package com.lec.robot.v4_인터페이스;

import com.lec.robot.v4_인터페이스.impl.Fly;
import com.lec.robot.v4_인터페이스.impl.FlyNo;
import com.lec.robot.v4_인터페이스.impl.MissileNo;
import com.lec.robot.v4_인터페이스.impl.SwordLaser;
import com.lec.robot.v4_인터페이스.impl.SwordNo;


public class RobotMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("=== Robot V4.0 (인터페이스) ===");
		System.out.println();
		
		
		CheapRobot cheapRobot = new CheapRobot("Cheap", 10);
		cheapRobot.actionWalk();
		cheapRobot.actionRun();
		cheapRobot.setFly(new FlyNo());
		cheapRobot.actionFly();
		cheapRobot.setMissile(new MissileNo());
		cheapRobot.actionMissile();
		cheapRobot.setSword(new SwordNo());
		cheapRobot.actionSword();
		System.out.println(cheapRobot.name + "Robot의 재고수량 = " + cheapRobot.qty);
		
		System.out.println();
		
		StandardRobot standardRobot = new StandardRobot("Standard",10);
		standardRobot.actionWalk();
		standardRobot.actionRun();
		standardRobot.setFly(new Fly());
		standardRobot.actionFly();
		standardRobot.setMissile(new MissileNo());
		standardRobot.actionMissile();
		standardRobot.setSword(new SwordLaser());
		standardRobot.actionSword();
		System.out.println(standardRobot.name + "Robot의 재고 수량 = " + standardRobot.qty);
		
		System.out.println();
		
		SuperRobot superRobot = new SuperRobot("Super", 10);
		superRobot.actionWalk();
		superRobot.actionRun();
		superRobot.setFly(new Fly());
		superRobot.actionFly();
		superRobot.setMissile(new MissileNo());
		superRobot.actionMissile();
		superRobot.setSword(new SwordLaser());
		superRobot.actionSword();
		System.out.println(superRobot.name + "Robot의 재고 수량 = " + superRobot.qty);
		
		
		
	}

}
