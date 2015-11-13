import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Shaw on 2015/10/18.
 */

public class MyMouseAdapter {
	static ArrayList<Point> points = new ArrayList<>();

	public static void main(String[] args) {


		JFrame jf = new JFrame("draw") {
			@Override
			public void paint(Graphics g) {
				Iterator i = points.iterator();
				while (i.hasNext()) {
					Point p = (Point) i.next();
					g.setColor(Color.BLACK);
					g.fillOval(p.x, p.y, 3, 3);
				}
			}
		};

		jf.setLayout(null);
		jf.setSize(600, 800);
		jf.setBackground(new Color(204, 204, 255));
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				points.add(new Point(e.getX(), e.getY()));
				((JFrame) e.getSource()).repaint();
			}
		});


	}
}



