package calc.components.calcstate.label;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CalcWorkLabel extends JLabel {
	private static final long serialVersionUID = 3003938610764154650L;
	
	public CalcWorkLabel() {
		
		setText("BBBBBBBBBBB");
		
		// 幅・高さ
		setSize(100,50);
		
		// テキストを右寄せ
		setHorizontalAlignment(SwingConstants.LEFT);
	}

}
