

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input implements MouseMotionListener, MouseListener 
{
	private ObjectHandler gameObjs;
	
	public static Input mouse = new Input();
	
	private Input(ObjectHandler h) 
	{
		setGameObjs(h);
	}
	
	private Input()
	{
		gameObjs = null;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		if(gameObjs != null)
		{
			for(int i = 0; i < gameObjs.getGameObjs().size(); i++) 
			{
				if(gameObjs.getGameObjAt(i) instanceof Image) 
				{
					
				}else if(gameObjs.getGameObjAt(i) instanceof OrderOncoming)
				{
					
				}else
				{
					if(((Button)gameObjs.getGameObjAt(i)).checkBoundsHover(e.getX(), e.getY())) {
						((Button)gameObjs.getGameObjAt(i)).setClicked();
					}
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		if(gameObjs != null) 
		{
			
		}
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		if(gameObjs != null) 
		{
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		if(gameObjs != null) 
		{
			for(int i = 0; i < gameObjs.getGameObjs().size(); i++)
			{
				if(gameObjs.getGameObjAt(i) instanceof Image)
				{
				}else if(gameObjs.getGameObjAt(i) instanceof OrderOncoming)
				{
					
				}else 
				{
					((Button)gameObjs.getGameObjAt(i)).checkBoundsPressed(e.getX(), e.getY());
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if(gameObjs != null) 
		{
			for(int i = 0; i < gameObjs.getGameObjs().size(); i++) 
			{
				if(gameObjs.getGameObjAt(i) instanceof Image)
				{
					
				}else if(gameObjs.getGameObjAt(i) instanceof OrderOncoming)
				{
					
				}else 
				{
					if(((Button)gameObjs.getGameObjAt(i)).checkBoundsHover(e.getX(), e.getY()))
					{
						((Button)gameObjs.getGameObjAt(i)).setState(1);
					}
				}
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) 
	{
		if(gameObjs != null) 
		{
			
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		if(gameObjs != null) 
		{
			for(int i = 0; i < gameObjs.getGameObjs().size(); i++) 
			{
				if(gameObjs.getGameObjAt(i) instanceof Image) 
				{
				}else if(gameObjs.getGameObjAt(i) instanceof OrderOncoming)
				{
					
				}else {
					((Button)gameObjs.getGameObjAt(i)).checkBoundsHover(e.getX(), e.getY());
				}
			}
		}
	}

	public ObjectHandler getGameObjs() 
	{
		return gameObjs;
	}

	public void setGameObjs(ObjectHandler gameObjs) 
	{
		this.gameObjs = gameObjs;
	}

}
