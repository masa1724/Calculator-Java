package calc.logic;

import java.util.regex.Pattern;

public class Calc2 {
	/** ���݂̌v�Z���� */
	private int result = 0;
	/** ���͒��̐��l*/
	private StringBuffer workNum = new StringBuffer();	
	/** ���͂��ꂽ�v�Z��*/
	private StringBuffer formula = new StringBuffer();	
	
	/** �Ō�ɓ��͂��ꂽ���������Z�q������ */
	private boolean inputSign = false;
	/** ���l���X�^�b�N�ς݂����� */
	private boolean stacked = false;
	
	private String currentSign = "";
	
	private static final String SIGN_PLUS = "+";
	private static final String SIGN_MINUS = "-";
	private static final String SIGN_MULTIPLY = "x";
	private static final String SIGN_DIVIDE = "��";
	
	/**
	 * ���͂��ꂽ�������u���͒��̐����v�ɒǉ�����B
	 */
	public void input(String num) {
        if(!Pattern.compile("^[0-9]*$").matcher(num).find()) {
			throw new NumberFormatException();
		}
        
		// ���l���X�^�b�N�Ȃ��ꍇ�ɌĂ΂ꂽ�ꍇ�A�G���[�ɂ���
		//if(stacked) throw new IllegalArgumentException("���l�����ɃX�^�b�N����Ă��܂��B");
		
		if(workNum.length() != 0 && inputSign) {
			formula.append(workNum).append(currentSign).append(num);
			result = Integer.parseInt(workNum.toString());
			clear();
		}

		workNum.append(num);
		
		inputSign = false;	
	}
	
	/**
	 * �v�Z�Ɏg�p���鉉�Z�q�� + �ɐ؂�ւ���B<br>
	 * �܂��A����2�Ɖ��Z�q�̑g�ݍ��킹�����͍ς݂̏ꍇ�A�v�Z���s��
	 */
	public void plus() {
		
		if(!stacked && workNum.length() != 0 && !inputSign)
			stacked = true;
		
		// ���l�̃X�^�b�N���Ȃ���ԂŌĂ΂ꂽ�ꍇ�A�������Ȃ�
		if(!stacked) return;
		
		// �O����͂��ꂽ�L�[�����Z�q�̏ꍇ�́A�؂�ւ��̂ݍs��
		if (inputSign) {
			currentSign = SIGN_PLUS;
			return;
		}
		
		// �X�^�b�N����Ă��鐔���Ɠ��͒��̐��l����Ɍv�Z���s�� 
		calc();
		
		// ���ݓ��͂���Ă��鉉�Z�q�� + �ɐ؂�ւ���
		currentSign = SIGN_PLUS;
		
		// ���Z�q���̓t���O��ݒ�
		inputSign = true;
	}
	
	public void minus() {		
		if(!stacked && workNum.length() != 0 && !inputSign)
			stacked = true;
		
		if(!stacked) return;
		
		if (inputSign) {
			currentSign = SIGN_MINUS;
			return;
		}
		
		if (workNum.length() >= 1) 
			calc();
		
		currentSign = SIGN_MINUS;
		inputSign = true;
	}

	public void multiply() {		
		if(!stacked && workNum.length() != 0 && !inputSign)
			stacked = true;
		
		if(!stacked) return;
		
		if (inputSign) {
			currentSign = SIGN_MULTIPLY;
			return;
		}
		
		if (workNum.length() >= 1) 
			calc();
		
		currentSign = SIGN_MULTIPLY;
		inputSign = true;
	}
	
	public void divide() {			
		if(!stacked && workNum.length() != 0 && !inputSign)
			stacked = true;
		
		if(!stacked) return;
		
		if (inputSign) {
			currentSign = SIGN_DIVIDE;
			return;
		}
		
		if (workNum.length() >= 1) 
			calc();
		
		currentSign = SIGN_DIVIDE;
		inputSign = true;
	}
	
	/** */
	private void calc() {
		switch (currentSign) {
		case SIGN_PLUS:
			result += Integer.parseInt(workNum.toString());
			formula.append(SIGN_PLUS).append(workNum.toString());
			break;
		case SIGN_MINUS:
			result -= Integer.parseInt(workNum.toString());
			formula.append(SIGN_MINUS).append(workNum.toString());
			break;
		case SIGN_MULTIPLY:
			result *= Integer.parseInt(workNum.toString());
			formula.append(SIGN_MULTIPLY).append(workNum.toString());
			break;
		case SIGN_DIVIDE:
			result /= Integer.parseInt(workNum.toString());
			formula.append(SIGN_DIVIDE).append(workNum.toString());
			break;
		default:
			break;
		}
	}

	/**
	 * ���ݓ��͂���Ă��鐔����ԋp����
	 * @return ���͂��ꂽ�v�Z��
	 */
	public String getWorkNumber() {
		return workNum.toString();
	}
	
	/**
	 * ���͂��ꂽ�v�Z����ԋp����
	 * @return ���͂��ꂽ�v�Z��
	 */
	public String getFormula() {
		return formula.toString();
	}
	
	/**
	 * ���݂܂ł̌v�Z���ʂ�ԋp����
	 * @return �v�Z����
	 */
	public int getResult() {
		return result;
	}
	
	/**
	 * ���݂܂œ��͂��ꂽ�v�Z���A�����S�Ă��N���A����
	 */
	public void clearEntry() {
		result = 0;
		inputSign = false;
		stacked = false;
		workNum = new StringBuffer();
		formula = new StringBuffer();
	}

	/**
	 * ���ݓ��͂���Ă��鐔�����N���A����
	 */
	public void clear() {
		workNum = new StringBuffer();
	}
	
	/**
	 * ���ݓ��͂���Ă��鐔���̖���1�������폜����B<br>
	 * (�����������͂̏ꍇ�A�����s��Ȃ�)
	 */
	public void delete() {
		if(workNum.length() != 0)
			workNum.deleteCharAt(workNum.length()-1);
	}
	
	public String toString() {
		return "[workNum:" + workNum.toString() + ", " +
				"[formula:" + formula.toString() + ", " +
		        "result:" + result + "]";
	}
}
