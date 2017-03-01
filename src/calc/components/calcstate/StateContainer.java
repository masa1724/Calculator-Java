package calc.components.calcstate;

import java.awt.Color;

import javax.swing.JPanel;

import calc.components.calcstate.label.CalcResultLabel;
import calc.components.calcstate.label.CalcWorkLabel;

public class StateContainer extends JPanel {
	private static final long serialVersionUID = 8916696814880272367L;
	
	/** �v�Z���ʂ�\�������� */
	public static CalcResultLabel lblCalcResult = new CalcResultLabel();
	/** �v�Z�r���̏�Ԃ�\�������� */
	public static CalcWorkLabel lblCalcWork = new CalcWorkLabel();
	
	public StateContainer(){
		setLayout(null);
		
		setBackground(Color.GREEN);
		setSize(500,200);
	}
}
