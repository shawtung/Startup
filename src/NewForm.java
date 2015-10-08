import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Shaw on 2015/9/22.
 */
public class NewForm implements ActionListener {
	public static void main(String[] args) {
		JFrame frame = new JFrame("E");
		frame.setContentPane(new NewForm().outterPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

	public JButton button1;
	private JButton button2;
	private JButton button3;
	private JPanel outterPanel;
	private JPanel upperPanel;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JTextArea textArea3;
	private JTextField textField1;
	private JSpinner spinner1;

	public void actionPerformed(ActionEvent e) {


	}


}
