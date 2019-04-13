

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Button extends Objects 
{
	private int state;
	private boolean[] clickStates;
	private int index;			// index of click state
	private int checkIndex;

	public Button(int x, int y, int w, int h, String path)
	{
		super(x, y, w, h, path);
		state = 0;
		clickStates = new boolean[2];
		index = 0;
		checkIndex = index;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update()
	
	{
		
	}
	
	public boolean checkClicked()
	{
		boolean state = false;
		
		if(checkIndex != -1)	state = clickStates[checkIndex];
		
		checkIndex = -1;
				
		return state;
	}
	
	public void setClicked()
	{
		clickStates[index] = true;
		if(index == 1)	clickStates[0] = false;
		else			clickStates[1] = false;
		checkIndex = index;
		
		index++;
		if(index > 1)	index = 0;
		
	}
	
	public void setState(int s) 
	{
		state = s;
	}
	
	public boolean checkBoundsHover(int x, int y)
	{
		boolean state = false;
		
		if(x > this.getX() && x < (this.getX() + this.getWidth()) && y > this.getY() && y < (this.getY() + this.getHeight()))
		{
			state = true;
			this.state = 1;
		}else {
			this.state = 0;
		}
		
		return state;
	}
	
	public boolean checkBoundsPressed(int x, int y)
	{
		boolean state = false;
		
		if(x > this.getX() && x < (this.getX() + this.getWidth()) && y > this.getY() && y < (this.getY() + this.getHeight()))
		{
			state = true;
			this.state = 2;
		}else {
			this.state = 0;
		}
		
		return state;
	}

	@Override
	public void render(Graphics g)
	{
		switch(state) 
		{
		case 0:// idle
			g.drawImage(this.getImage(), this.getX(), this.getY(), null);
			//ImageDrawer.drawScaledImage(this.getImage(), Main.canvasInstance, g);
			break;
		case 1:// hover
			g.drawImage(this.getImage(), this.getX()+3, this.getY()-3, null);
			//ImageDrawer.drawScaledImage(this.getImage(), Main.canvasInstance, g);
			break;
		case 2:// clicked
			g.drawImage(this.getImage(), this.getX(), this.getY(), null);
			//ImageDrawer.drawScaledImage(this.getImage(), Main.canvasInstance, g);
			break;
		}
	}
	
}
