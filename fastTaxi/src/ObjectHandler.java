

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectHandler
{
	private ArrayList<Objects> gameObj;
	
	public ObjectHandler() 
	{
		setGameObj(new ArrayList<Objects>());
	}
	
	public void addGameObject(Objects obj)
	{
		gameObj.add(obj);
	}
	
	/**
	 * Removes base on the type, first occurance of it
	 * @param obj
	 */
	public void removeGameObject(Objects obj)
	{
		for(int i = 0; i < gameObj.size(); i++) 
		{
			gameObj.remove(i);
			i = gameObj.size();
		}
	}
	
	public boolean exist(Objects obj) 
	{
		return gameObj.contains(obj);
	}
	
	public void clearAll() 
	{
		gameObj.clear();
	}
	
	public Objects getGameObjAt(int i)
	{
		return gameObj.get(i);
	}

	public ArrayList<Objects> getGameObjs() 
	{
		return gameObj;
	}

	public void setGameObj(ArrayList<Objects> gameObj) 
	{
		this.gameObj = gameObj;
	}
	

	/**
	 * removes instance of the object
	 * @param obj
	 */
	public void removeGameObjectCompare(Objects obj) 
	{
		gameObj.remove(obj);
	}
	
	public void update()
	{
		for(int i = 0; i < gameObj.size(); i++)
		{
			gameObj.get(i).update();
		}
	}

	public void render(Graphics g)
	{
		for(int i = 0; i < gameObj.size(); i++)
		{
			gameObj.get(i).render(g);
		}
	}
}
