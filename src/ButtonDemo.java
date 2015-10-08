import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Shaw on 2015/9/22.
 */
public class ButtonDemo extends JPanel implements ActionListener {

	protected JButton bl;

	public ButtonDemo() {
		bl = new JButton("");
		this.add(bl);
		bl.setLayout(null);
		bl.setVisible(true);
		bl.setBounds(300, 300, 300, 300);
//		bl.setVerticalTextPosition(AbstractButton.CENTER);
//		bl.setHorizontalTextPosition(AbstractButton.CENTER);
		bl.setBorderPainted(false);
		bl.setActionCommand("disable");
		bl.setBackground(new Color(64, 128, 192));
		bl.setMnemonic(KeyEvent.VK_Q);
		bl.addActionListener(this);
		bl.setToolTipText("what will happen?");
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		Color a = new Color(64, 128, 192);
		Color b = new Color(128, 192, 0);
		Color c = new Color(192, 0, 64);
		Color d = new Color(0, 64, 128);

		bl.setBackground(new Color(
						(bl.getBackground().getRed() + 64) % 256,
						(bl.getBackground().getGreen() + 64) % 256,
						(bl.getBackground().getBlue() + 64) % 256
						)
		);

	}

	public static void createAndShowGUI() {
		JFrame frame = new JFrame("test sample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ButtonDemo newContentPane = new ButtonDemo();
		newContentPane.setOpaque(true);
		newContentPane.setSize(500, 300);

		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
