package calc.components.calcbuttons.button;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class CalcButton extends JButton {
	private static final long serialVersionUID = -2944425578459494325L;
	
	public CalcButton() {
		// 幅・高さ
		//setSize(50, 50);
				
		// テキストを中央揃え
		setHorizontalAlignment(SwingConstants.CENTER);
		
		setFont(new Font("Arial", Font.PLAIN, 10));
	}
}
