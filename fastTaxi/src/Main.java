

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends Canvas implements Runnable 
{
	private Thread t;
	private boolean running;
	private String gameName;
	private Window window;
	private JFrame uber;
	public static Canvas canvasInstance;
	
	
	// CREATE objects and data here
	public static Image city = new Image(0,70, 0, 0, "philly2.png");
	public static Button node1 = new Button(13, 80, 30, 30, "n1.png");
	public static Button node2 = new Button(211, 82, 30, 30, "n2.png");
	public static Button node3 = new Button(463, 80, 30, 30, "n3.png");
	public static Button node4 = new Button(4, 202, 30, 30, "n4.png");
	public static Button node5 = new Button(206, 201, 30, 30, "n5.png");
	public static Button node6 = new Button(10, 262, 30, 30, "n6.png");
	public static Button node7 = new Button(212, 264, 30, 30, "n7.png");
	public static Button node8 = new Button(464, 263, 30, 30, "n8.png");
	public static Button node9 = new Button(7, 318, 30, 30, "n9.png");
	public static Button node10 = new Button(209, 319, 30, 30, "n10.png");
	public static Button node11 = new Button(465, 319, 30, 30, "n11.png");
	public static Button node12 = new Button(7, 374, 30, 30, "n12.png");
	public static Button node13 = new Button(205, 376, 30, 30, "n13.png");
	public static Button node14 = new Button(7, 423, 30, 30, "n14.png");
	public static Button node15 = new Button(202, 422, 30, 30, "n15.png");
	public static Button node16 = new Button(462, 423, 30, 30, "n16.png");
	public static Button order = new Button(355, 500, 120, 30, "callUIdle.png");
	//public static OrderOncoming driverConfirm = new OrderOncoming(280, 450, 200, 100, 500, "driverSign.png");
	public static ObjectHandler oh = new ObjectHandler();
	
	
	public static String whereYouAt = "Where you at: ";
	public static String whereYouGo = "Where you going: ";
	public static boolean where = false;
	
	public static int you = 0;
	public static int going = 0;
	
	/////////////////////////////////////
	
	
	
	public Main(String name, int w, int h) 
	{
		this.gameName = name;
		uber = new JFrame(name);
		init();
		window = new Window(this, w, h);
	}
	
	public static void main(String[] args) 
	{
		Main uber = new Main("Uber", 500, 600);
		Main.canvasInstance = uber;
	}
	
	public void init() 
	{
		this.addMouseListener(Input.mouse);
		this.addMouseMotionListener(Input.mouse);
		uber.add(this);
		
		// Do stuff here
		ShortPath.setup();
		
		oh.addGameObject(city);
		oh.addGameObject(node1);
		oh.addGameObject(node2);
		oh.addGameObject(node3);
		oh.addGameObject(node4);
		oh.addGameObject(node5);
		oh.addGameObject(node6);
		oh.addGameObject(node7);
		oh.addGameObject(node8);
		oh.addGameObject(node9);
		oh.addGameObject(node10);
		oh.addGameObject(node11);
		oh.addGameObject(node12);
		oh.addGameObject(node13);
		oh.addGameObject(node14);
		oh.addGameObject(node15);
		oh.addGameObject(node16);
		oh.addGameObject(order);
		//oh.addGameObject(driverConfirm);
		
		Input.mouse.setGameObjs(oh);
		//////////////////////
	}
	
	@Override
	public void run() 
	{
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running) 
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) 
			{
				update();
				delta--;
			}
			
			if(running) 
			{
				render();
			}
			
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) 
			{
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		
		stop();
	}
	
	public synchronized void start() 
	{
		t = new Thread(this);
		running = true;
		t.start();
	}
	
	public synchronized void stop()
	{
		try {
			t.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void disposeGame() {
		uber.dispose();
	}
	
	public void update() 
	{
		// Logic Goes Here
		if(order.checkClicked()) 
		{
			System.out.println("you: " + you + " going: " + going);
			List<Vertex> list = ShortPath.getShortest(you, going);
			String nodesTaken = "";
			
			for(Vertex v : list) 
			{
				nodesTaken += v.name + " ";
			}
			
			JOptionPane.showMessageDialog(this.getFrame(), nodesTaken);
		}
		
		if(!where) 
		{
			if(node1.checkClicked()) 
			{
				you = 0;
				where = true;
			}else if(node2.checkClicked()) 
			{
				you = 1;
				where = true;
			}else if(node3.checkClicked()) 
			{
				you = 2;
				where = true;
			}else if(node4.checkClicked())
			{
				you = 3;
				where = true;
			}else if(node5.checkClicked())
			{
				you = 4;
				where = true;
			}else if(node6.checkClicked()) 
			{
				you = 5;
				where = true;
			}else if(node7.checkClicked())
			{
				you = 6;
				where = true;
			}else if(node8.checkClicked())
			{
				you = 7;
				where = true;
			}else if(node9.checkClicked())
			{
				you = 8;
				where = true;
			}else if(node10.checkClicked())
			{
				you = 9;
				where = true;
			}else if(node11.checkClicked())
			{
				you = 10;
				where = true;
			}else if(node12.checkClicked()) 
			{
				you = 11;
				where = true;
			}else if(node13.checkClicked())
			{
				you = 12;
				where = true;
			}else if(node14.checkClicked())
			{
				you = 13;
				where = true;
			}else if(node15.checkClicked())
			{
				you = 14;
				where = true;
			}else if(node16.checkClicked()) 
			{
				you = 15;
				where = true;
			}
		}else {
			if(node1.checkClicked())
			{
				going = 0;
				where = false;
			}else if(node2.checkClicked())
			{
				going = 1;
				where = false;
			}else if(node3.checkClicked()) 
			{
				going = 2;
				where = false;
			}else if(node4.checkClicked())
			{
				going = 3;
				where = false;
			}else if(node5.checkClicked()) 
			{
				going = 4;
				
				where = false;
			}else if(node6.checkClicked())
			{
				going = 5;
				where = false;
			}else if(node7.checkClicked())
			{
				going = 6;
				where = false;
			}else if(node8.checkClicked())
			{
				going = 7;
				where = false;
			}else if(node9.checkClicked())
			{
				going = 8;
				where = false;
			}else if(node10.checkClicked()) 
			{
				going = 9;
				where = false;
			}else if(node11.checkClicked()) 
			{
				going = 10;
				where = false;
			}else if(node12.checkClicked())
			{
				going = 11;
				where = false;
			}else if(node13.checkClicked())
			{
				going = 12;
				where = false;
			}else if(node14.checkClicked())
			{
				going = 13;
				where = false;
			}else if(node15.checkClicked()) 
			{
				going = 14;
				where = false;
			}else if(node16.checkClicked())
			{
				going = 15;
				where = false;
			}
		}
		
		
		whereYouAt = "Where you at: " + (you+1);
		whereYouGo = "Where you going: " + (going+1);
		//////////////////////////////////////////////
	}
	
	public void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, window.getSize().width, window.getSize().height);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 16));
		g.drawString("Click a node on where you at then", 100,  20);
		g.drawString("Click a node on where your going", 100,  40);
		
		oh.render(g);
		
		g.drawString(whereYouAt, 10, 500);
		g.drawString(whereYouGo, 10, 520);
		
		bs.show();
		g.dispose();
	}
	
	public JFrame getFrame()
	{
		return uber;
	}
	
	public String getGameName()
	{
		return gameName;
	}

	public void setGameName(String gameName)
	{
		this.gameName = gameName;
	}
}
