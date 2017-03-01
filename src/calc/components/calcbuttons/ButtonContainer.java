package calc.components.calcbuttons;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import calc.components.calcbuttons.action.DivideButtonActionListener;
import calc.components.calcbuttons.action.EqualButtonActionListener;
import calc.components.calcbuttons.action.MinusButtonActionListener;
import calc.components.calcbuttons.action.MultiplyButtonActionListener;
import calc.components.calcbuttons.action.PlusButtonActionListener;
import calc.components.calcbuttons.button.CalcButton;

public class ButtonContainer extends JPanel {
	private static final long serialVersionUID = 8916696814880272367L;
	/**
	 *  ボタン配列の定義
	 *  2次元配列の添字に沿った箇所へ、各ボタンを配置する
	 */
	private static final String[][] BTNS = {
		{"CE","C","<","÷"},
		{"7","8","9","x"},
		{"4","5","6","-"},
		{"1","2","3","+"},
		{"±","0",".","="}
	};

	/** 
	 *  アクションの定義
	 *  上記ボタン配列の添字に合わせて、ボタン毎のアクションクラスを定義する
	 */
	private static final ActionListener[][] ACTIONS = {
		{
			null,
			null,
			null,
			new DivideButtonActionListener()
		},{
			null,
			null,
			null,
			new MultiplyButtonActionListener()
		},{
			null,
			null,
			null,
			new MinusButtonActionListener()
		},{
			null,
			null,
			null,
			new PlusButtonActionListener()
		},{
			null,
			null,
			null,
			new EqualButtonActionListener()
		}
	};
	
	public ButtonContainer(){
		setBackground(Color.ORANGE);
		
		GridLayout layout = new GridLayout(0,4);
		setLayout(layout);
		
		/* 各ボタンの初期化 */
		initButton();
	}
	
	/**
	 *  各ボタンの初期化
	 */
	private void initButton() {
		for(int i = 0; i < BTNS.length; i++) {
			for(int j = 0; j < BTNS[i].length; j++) {
				CalcButton btn = new CalcButton();
				// イベント処理を追加
				btn.addActionListener(ACTIONS[i][j]);
				// ボタン名を設定
				btn.setText(BTNS[i][j]);
			    add(btn);
			}
		}
	}
}
