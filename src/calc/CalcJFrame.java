package calc;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

import calc.components.calcbuttons.ButtonContainer;
import calc.components.calcstate.StateContainer;

public class CalcJFrame extends JFrame {
	private static final long serialVersionUID = -2132155943729532341L;
	
	public CalcJFrame() {
		// �e�R���|�[�l���g�̏�����
		
		/* �t���[���̏����� */
		// �^�C�g��
		setTitle("�d��");
		// ���E����
		//setSize(500, 450);
		// �����\��
		setLocationRelativeTo(null);
		// �E���X�{�^�����������ہA�A�v�����I��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		/** �v�Z���ʓ���\������G���A */
		StateContainer sc = new StateContainer();
		//sc.setLocation(0,0);
	    layout.putConstraint(SpringLayout.NORTH, sc, 0, SpringLayout.NORTH, this);
	    layout.putConstraint(SpringLayout.WEST, sc, 0, SpringLayout.WEST, this);
	    
		
		/** �e�v�Z�{�^����\������G���A */
		ButtonContainer bc = new ButtonContainer();
		//bc.setLocation(0,150);]
	    layout.putConstraint(SpringLayout.NORTH, bc, 0, SpringLayout.NORTH, sc);
	    layout.putConstraint(SpringLayout.WEST, bc, 0, SpringLayout.SOUTH, sc);
	    
	    add(sc);
		add(bc);
		
		// �A�C�R����ݒ�
		//ImageIcon icon = new ImageIcon("./icon.png");
		//setIconImage(icon.getImage());
		
		//GridLayout grid = new GridLayout();
		//setLayout(grid);
		
		// �����R���|�[�l���g�ɍ��킹�Ď�������
		pack();
	}
}
