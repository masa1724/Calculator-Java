package calc.components.calcbuttons.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calc.components.calcstate.StateContainer;

public class PlusButtonActionListener implements ActionListener {
	// ボタン押下時に下記メソッドが呼ばれる
	public void actionPerformed(ActionEvent e){
		System.out.println("onclick plus button");
		
		String workText = StateContainer.lblCalcWork.getText();
		StateContainer.lblCalcResult.setText(workText + "+");
	}
}
