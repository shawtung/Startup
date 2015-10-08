import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;

/**
 * Created by Shaw on 2015/9/21.
 */
public class EmptyJFrame extends JFrame {

	public static final Color[] colorArray = {new Color(255, 255, 255), new Color(192, 192, 192), new Color(128, 128, 128), new Color(64, 64, 64), new Color(0, 0, 0), new Color(255, 0, 0), new Color(255, 175, 175), new Color(255, 200, 0), new Color(255, 255, 0), new Color(0, 255, 0), new Color(255, 0, 255), new Color(0, 255, 255), new Color(0, 0, 255)};

//	JPanel jPanel = new JPanel();


	private JButton jButton1;
	private JButton jButton2;
	private JTextField jTF1;
	private JTextField jTF2;

	EmptyJFrame() {
		initGUI();
		addComp_JButton1();
		addComp_JButton2();
		addComp_JTF1();
		addComp_JTF2();
		pack();
	}

	private void initGUI() {
		setTitle("whosyourdaddy");
		setVisible(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		setVisible(true);
		setLayout(new BorderLayout(5, 5));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	private void addComp_JButton1() {

		jButton1 = new JButton();
		jButton1.setBackground(new Color(0, 127, 255));
		jButton1.setMnemonic(KeyEvent.VK_Q);
		jButton1.addActionListener(new ActionListener() {
			int i;

			@Override
			public void actionPerformed(ActionEvent e) {
				i = (++i) % colorArray.length;
				jButton1.setBackground(colorArray[i]);
			}
		});
		jButton1.setBorderPainted(false);
		jButton1.setMargin(new Insets(100, 100, 100, 100));
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.add("Center", jButton1);
	}

	private void addComp_JButton2() {
		jButton2 = new JButton("CLOSE");
		jButton2.setActionCommand("disable");
		jButton2.addActionListener((e) -> System.exit(0));
		jButton2.setBorderPainted(false);
		jButton2.setMargin(new Insets(100, 100, 100, 100));

		this.add("East", jButton2);
	}

	private void addComp_JTF1() {
		jTF1 = new JTextField();
		jTF1.setSize(300, 100);
		this.add("North", jTF1);
		jTF1.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				jTF2.setText(jTF1.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				jTF2.setText(jTF1.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				jTF2.setText(jTF1.getText());
			}
		});

	}

	private void addComp_JTF2() {
		jTF2 = new JTextField();
		jTF2.setEditable(false);
		this.add("South", jTF2);
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {EmptyJFrame ejf = new EmptyJFrame();});
	}


}
