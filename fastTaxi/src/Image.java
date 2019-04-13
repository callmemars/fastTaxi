

import java.awt.Graphics;

public class Image extends Objects
{
	public Image(int x, int y, int w, int h, String path) {
		super(x, y, w, h, path);
	}

	@Override
	public void update() 
	{
	}

	@Override
	public void render(Graphics g)
	{
		g.drawImage(this.getImage(), this.getX(), this.getY(), null);
		//ImageDrawer.drawScaledImage(this.getImage(), Main.canvasInstance, g);
	}
}
