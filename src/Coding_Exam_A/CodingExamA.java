package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		Color c = Color.BLACK;
		int numRobots = Integer.parseInt(JOptionPane.showInputDialog("How many robots do you wish to display?"));
		String color = JOptionPane.showInputDialog("Input color of each shape here (red, green, or blue)");
		color = color.toLowerCase();
		if (color.toLowerCase().equals("red")) {
			c = Color.red;
		}
		if (color.toLowerCase().equals("green")) {
			c = Color.green;
		}
		if (color.toLowerCase().equals("ble")) {
			c = Color.blue;
		}
		int numSides = Integer.parseInt(JOptionPane.showInputDialog("How many sides do you wish to draw?"));
		Robot [] robots = new Robot[numRobots];
		for (int i = 0; i < robots.length; i++) {
			robots[i] = new Robot((i + 1) * 130, 150);
			robots[i].setPenColor(c);
		}
		Thread [] threads = new Thread[numRobots];
		for (int i = 0; i < numRobots; i++) {
			Robot r = robots[i];
			threads[i] = new Thread(()->{
				for (int j = 0; j < numSides; j++) {
					r.penDown();
					r.setSpeed(30);
					r.move(70);
					r.turn(360/numSides);
				}
			});
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
	}
}
