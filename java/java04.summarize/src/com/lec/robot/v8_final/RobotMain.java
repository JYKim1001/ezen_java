package com.lec.robot.v8_final;

import com.lec.robot.v4_인터페이스.impl.Fly;
import com.lec.robot.v4_인터페이스.impl.FlyNo;
import com.lec.robot.v4_인터페이스.impl.MissileNo;
import com.lec.robot.v4_인터페이스.impl.MissileYes;
import com.lec.robot.v4_인터페이스.impl.SwordLaser;
import com.lec.robot.v4_인터페이스.impl.SwordNo;
import com.lec.robot.v4_인터페이스.impl.SwordWood;
import com.lec.robot.v7_생성자.CheapRobot;
import com.lec.robot.v7_생성자.Robot;
import com.lec.robot.v7_생성자.StandardRobot;
import com.lec.robot.v7_생성자.SuperRobot;

public class RobotMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=== Robot V8.0 (다형성) ===");
		System.out.println();
		
		Robot robot = null;
		
		robot = new CheapRobot("Cheap", 10, new FlyNo(), new MissileNo(), new SwordNo());
		robot.productRobot();
		
		robot = new StandardRobot("Standard", 4, new Fly(), new MissileYes(), new SwordWood());
		robot.productRobot();
		
		robot = new SuperRobot("Super", 5, new Fly(), new MissileYes(), new SwordLaser());
		robot.productRobot();
		
	}

}