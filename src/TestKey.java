import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Shaw on 2015/10/18.
 */
public class TestKey {

	public static void main(String[] args) {
		new KeyFrame().launchFrame();
	}

}

class KeyFrame extends JFrame {

	public void launchFrame() {
		setSize(200, 200);
		setLocation(300, 300);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.print(e.getKeyChar());
				System.out.println(e.getKeyLocation());
			}
		});
	}

}
