package window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import framework.GameObject;
import framework.HandlerInterface;
import framework.KeyInput;
import framework.ObjectId;
import framework.Texture;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 6968053136413161446L;
	private boolean running = false;
	private Thread thread;

	public static int WIDTH, HEIGHT;
//
//	private BufferedImage level = null, stars = null;
	static BufferedImage[] images;
	
	public static int LEVEL = 0;

	Handler handler;

	Camera cam;

	static Texture tex;

	// GameObject object;
	// 
//	public Game () {
//		WIDTH = getWidth();
//		HEIGHT = getHeight();
////		
////		init(i);
//	}
//	 
	public void init() {
		//basically the constructor of the class
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		tex = new Texture(); //create first to avoid complications
		
//		BufferedImage level_1 = loader.loadImage("level_1.png"); // loading the level
//		BufferedImage level_2 = loader.loadImage("level_2.png");
		//BufferedImage stars = loader.loadImage("stars.png"); //loading clouds
		
		cam = new Camera(0,0);
		String[] i = {"level_1.png","level_2.png"};
		handler = new Handler(cam);
		handler.setLevel();
		//handler.addObject(new Player(100,100,ObjectId.Player));
		//handler.createLevel();
		this.addKeyListener(new KeyInput(handler));
	}

	public synchronized void start() {
		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}
	@Override
	public void run() {
		
//		init(i);
		init();
		this.requestFocus();
		//////////////////////////////
		//not mine, copy-pasted
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				//	    System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}

	private void tick() {
		handler.tick();
		if (cam != null) {
			for (GameObject tempObject: handler.object) {
//			for (int i = 0; i <handler.object.size(); i++) {
//				GameObject tempObject = handler.object.get(i);
				if (tempObject != null && tempObject.getId() == ObjectId.Player)
					cam.tick(tempObject);
			}
		}
//		LinkedQueue<GameObject> temp = new LinkedQueue<GameObject>();
//		while (!handler.object.isEmpty()) {
//			GameObject tempObject = handler.object.dequeue();
//			
//			
//			
//			temp.enqueue(tempObject);
//		} handler.object = temp;
//		System.out.println(handler.object.size()+"ogt");
//		System.out.println(temp.size()+"tgt");
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		///////////////////////////////////////
		//DRAW IN HERE, deals with background//
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		//g.drawImage(stars, 0, 0, getWidth(), getHeight(), null);
		if (cam != null) 
			g2d.translate(cam.getX(), cam.getY()); // begin of cam
		// anything between the camera's begin and end
		// will be affected by the camera
		handler.render(g);
		//
		if (cam != null)
			g2d.translate(-cam.getX(), -cam.getY());// end of cam
		///////////////////////////////////////
		g.dispose();
		bs.show();
	}

	public static Texture getInstance() {
		return tex;
	}
	public static void main(String[] args) {
		new Window(800,600,"Test",new Game()); //game window established w/ game
	}
}
