package calc.logic;

import java.util.regex.Pattern;

public class Calc2 {
	/** 現在の計算結果 */
	private int result = 0;
	/** 入力中の数値*/
	private StringBuffer workNum = new StringBuffer();	
	/** 入力された計算式*/
	private StringBuffer formula = new StringBuffer();	
	
	/** 最後に入力された文字が演算子か判定 */
	private boolean inputSign = false;
	/** 数値がスタック済みか判定 */
	private boolean stacked = false;
	
	private String currentSign = "";
	
	private static final String SIGN_PLUS = "+";
	private static final String SIGN_MINUS = "-";
	private static final String SIGN_MULTIPLY = "x";
	private static final String SIGN_DIVIDE = "÷";
	
	/**
	 * 入力された数字を「入力中の数字」に追加する。
	 */
	public void input(String num) {
        if(!Pattern.compile("^[0-9]*$").matcher(num).find()) {
			throw new NumberFormatException();
		}
        
		// 数値がスタックない場合に呼ばれた場合、エラーにする
		//if(stacked) throw new IllegalArgumentException("数値が既にスタックされています。");
		
		if(workNum.length() != 0 && inputSign) {
			formula.append(workNum).append(currentSign).append(num);
			result = Integer.parseInt(workNum.toString());
			clear();
		}

		workNum.append(num);
		
		inputSign = false;	
	}
	
	/**
	 * 計算に使用する演算子を + に切り替える。<br>
	 * また、数字2つと演算子の組み合わせが入力済みの場合、計算を行う
	 */
	public void plus() {
		
		if(!stacked && workNum.length() != 0 && !inputSign)
			stacked = true;
		
		// 数値のスタックがない状態で呼ばれた場合、何もしない
		if(!stacked) return;
		
		// 前回入力されたキーが演算子の場合は、切り替えのみ行う
		if (inputSign) {
			currentSign = SIGN_PLUS;
			return;
		}
		
		// スタックされている数字と入力中の数値を基に計算を行う 
		calc();
		
		// 現在入力されている演算子を + に切り替える
		currentSign = SIGN_PLUS;
		
		// 演算子入力フラグを設定
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
	 * 現在入力されている数字を返却する
	 * @return 入力された計算式
	 */
	public String getWorkNumber() {
		return workNum.toString();
	}
	
	/**
	 * 入力された計算式を返却する
	 * @return 入力された計算式
	 */
	public String getFormula() {
		return formula.toString();
	}
	
	/**
	 * 現在までの計算結果を返却する
	 * @return 計算結果
	 */
	public int getResult() {
		return result;
	}
	
	/**
	 * 現在まで入力された計算式、数字全てをクリアする
	 */
	public void clearEntry() {
		result = 0;
		inputSign = false;
		stacked = false;
		workNum = new StringBuffer();
		formula = new StringBuffer();
	}

	/**
	 * 現在入力されている数字をクリアする
	 */
	public void clear() {
		workNum = new StringBuffer();
	}
	
	/**
	 * 現在入力されている数字の末尾1文字を削除する。<br>
	 * (数字が未入力の場合、何も行わない)
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
