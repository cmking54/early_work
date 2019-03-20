package window;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	
	public Window (int w, int h, String title, Game g) {
		g.setPreferredSize(new Dimension(w,h));
		g.setMaximumSize(new Dimension(w,h));
		g.setMinimumSize(new Dimension(w,h));
		
		JFrame f = new JFrame(title);
		f.add(g);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		//f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		g.start();
	}
}
