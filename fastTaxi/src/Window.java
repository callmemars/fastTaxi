

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class Window
{
	public static Dimension size;
	
	public Window(Main c, int w, int h) 
	{
		size = new Dimension(w, h);
		//c.getFrame().setPreferredSize(size);
		//c.getFrame().setMaximumSize(size);
		//c.getFrame().setMinimumSize(size);
		c.getFrame().setSize(size);
		c.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.getFrame().setResizable(false);
		c.getFrame().setLocationRelativeTo(null);
		c.getFrame().setSize(getFrameToScreenRatio(c.getFrame()));
		//this.makeFrameFullSize(c.getFrame());
		c.getFrame().addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				c.stop();
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//c.getFrame().pack();
		c.getFrame().setVisible(true);
		c.start();
	}
	
	private Dimension getFrameToScreenRatio(Frame aFrame)
	{
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		double w = dimension.getWidth() / aFrame.getWidth();
		double h = dimension.getHeight() / aFrame.getHeight();
		dimension.setSize(dimension.getWidth()/w,dimension.getHeight()/h);
		return dimension;
	}
	
	private void makeFrameFullSize(JFrame aFrame)
	{
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    aFrame.setSize(screenSize.width, screenSize.height);
	}
	
	public Dimension getSize()
	{
		return size;
	}
}
