package com.lec.robot.v6_method;

import com.lec.robot.v4_인터페이스.impl.Fly;
import com.lec.robot.v4_인터페이스.impl.FlyNo;
import com.lec.robot.v4_인터페이스.impl.MissileNo;
import com.lec.robot.v4_인터페이스.impl.MissileYes;
import com.lec.robot.v4_인터페이스.impl.SwordLaser;
import com.lec.robot.v4_인터페이스.impl.SwordNo;
import com.lec.robot.v4_인터페이스.impl.SwordWood;
import com.lec.robot.v4_인터페이스.inter.InterFly;
import com.lec.robot.v4_인터페이스.inter.InterMissile;
import com.lec.robot.v4_인터페이스.inter.InterSword;

public class RobotMain {

	public static void main(String[] args) {
		
		System.out.println("=== Robot V6.0 (common method) ===");
		System.out.println();
		
		makeRobot(new CheapRobot("Cheap", 10) , new FlyNo(), new MissileNo() , new SwordNo() );
		
		makeRobot(new StandardRobot("Standard", 10) , new Fly(), new MissileNo() , new SwordWood());
		
		makeRobot(new SuperRobot("Super", 10) , new Fly() , new MissileYes(), new SwordLaser());
		
		
	}

	private static void makeRobot(Robot robot, InterFly fly , InterMissile missile , InterSword sword) {
		System.out.println(robot.getClass());
	
		
		robot.shape();
		robot.actionWalk();
		robot.actionRun();
		robot.setFly(fly);
		robot.actionFly();
		robot.setMissile(missile);
		robot.actionMissile();
		robot.setSword(sword);
		robot.actionSword();
		
		System.out.println(robot.name + "Robot 의 재고 수량 = " + robot.qty);
		System.out.println();
	}
	

}
