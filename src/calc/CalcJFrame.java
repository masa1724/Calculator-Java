package calc;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

import calc.components.calcbuttons.ButtonContainer;
import calc.components.calcstate.StateContainer;

public class CalcJFrame extends JFrame {
	private static final long serialVersionUID = -2132155943729532341L;
	
	public CalcJFrame() {
		// 各コンポーネントの初期化
		
		/* フレームの初期化 */
		// タイトル
		setTitle("電卓");
		// 幅・高さ
		//setSize(500, 450);
		// 中央表示
		setLocationRelativeTo(null);
		// 右上のXボタンを押した際、アプリを終了させる
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		/** 計算結果等を表示するエリア */
		StateContainer sc = new StateContainer();
		//sc.setLocation(0,0);
	    layout.putConstraint(SpringLayout.NORTH, sc, 0, SpringLayout.NORTH, this);
	    layout.putConstraint(SpringLayout.WEST, sc, 0, SpringLayout.WEST, this);
	    
		
		/** 各計算ボタンを表示するエリア */
		ButtonContainer bc = new ButtonContainer();
		//bc.setLocation(0,150);]
	    layout.putConstraint(SpringLayout.NORTH, bc, 0, SpringLayout.NORTH, sc);
	    layout.putConstraint(SpringLayout.WEST, bc, 0, SpringLayout.SOUTH, sc);
	    
	    add(sc);
		add(bc);
		
		// アイコンを設定
		//ImageIcon icon = new ImageIcon("./icon.png");
		//setIconImage(icon.getImage());
		
		//GridLayout grid = new GridLayout();
		//setLayout(grid);
		
		// 幅をコンポーネントに合わせて自動調整
		pack();
	}
}
