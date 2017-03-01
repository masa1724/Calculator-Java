package main;

import calc.CalcJFrame;
import calc.logic.Calc;

public class Main {
	public static void main(String[] args) {

		CalcJFrame calc = new CalcJFrame();
		calc.setVisible(true);
		
		//calcTest();
	}
	
	public static void calcTest() {
		Calc calc = new Calc();
		calc.input("1");
		calc.plus();
		calc.minus();
		calc.input("3");
		calc.divide();
		System.out.println(calc.toString());
	}
}
