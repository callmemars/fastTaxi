import java.awt.Graphics;

public class OrderOncoming extends Objects 
{
	private Button confirm;

	public OrderOncoming(int x, int y, int w, int h, int sW, String path) {
		super(x, y, w, h, path);
	}

	@Override
	public void update() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) 
	{
		// TODO Auto-generated method stub
		g.drawImage(this.getImage(), this.x, this.y, null);
	}

}
