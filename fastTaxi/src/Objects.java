

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class Objects 
{
	protected int x, y, width, height;
	protected ImageIcon image;
	protected ArrayList<BufferedImage> stateImages;
	
	public Objects(int x, int y, int w, int h, String path)
	{
		this.setX(x);
		this.setY(y);
		setWidth(w);
		setHeight(h);
		if(path != null && !path.isEmpty() ) 
		{
			setImage(new ImageIcon(path));
		}
	}

	public int getX() 
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
		
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight() 
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public abstract void update();

	public abstract void render(Graphics g);

	public Image getImage() 
	{
		return image.getImage();
	}

	public void setImage(ImageIcon image)
	{
		this.image = image;
	}
}
