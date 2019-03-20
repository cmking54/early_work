package window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import objects.Block;
import objects.Flag;
import objects.Player;
import framework.GameObject;
import framework.HandlerInterface;
import framework.ObjectId;

public class Handler implements HandlerInterface{
	public LinkedList<GameObject> object = new LinkedList<GameObject> ();
	
	private Camera cam;
	private BufferedImage[] images;
	
	public Handler(Camera cam) {
		this.cam = cam;
		BufferedImageLoader loader = new BufferedImageLoader();
		String[] img = {"level_1.png","level_2.png"};
		images = new BufferedImage[img.length];
		for (int i = 0; i < img.length; i++) {
			images[i] = loader.loadImage(img[i]);
		}
	}

	public void tick() {
//		LinkedQueue<GameObject> temp = new LinkedQueue<GameObject>();
//		while (!object.isEmpty()) {
//			tempObject = object.dequeue();
//			
//			if (tempObject != null)
//			tempObject.tick(this);
//			
//			temp.enqueue(tempObject);
//		} object = temp;
//		System.out.println(object.size()+"oht");
//		System.out.println(temp.size()+"tht");
//		int index = 0;
//		while (index < object.size()) {
//			tempObject = object.dequeue();
//			
//			object.enqueue(tempObject);			
//			index++;
//		}
//		
//		for (GameObject o: object) {
//			if (o != null)
//				o.tick(this);
//		}
		
		for (int i = 0; i <object.size(); i++) {
			GameObject tempObject = object.get(i);
		    tempObject.tick(object);
		}
	}
	
	public void render(Graphics g) {
//		LinkedQueue<GameObject> temp = new LinkedQueue<GameObject>();
//		while (!object.isEmpty()) {
//			tempObject = object.dequeue();
//			
//			if (tempObject != null)
//				tempObject.render(g);
//			
//			temp.enqueue(tempObject);
//		} object = temp;
//		System.out.println(object.size()+"ohr");
//		System.out.println(temp.size()+"thr");
		
		for (GameObject tempObject: object) {
//		for (int i = 0; i < object.size(); i++) {
			//System.out.print(i);
//			tempObject = object.get(i);
			if (tempObject != null)
				tempObject.render(g);
		}
	}
	
	private void clearLevel() {
		object.clear();
	}
	
	public void loadImageLevel (BufferedImage image) {//probably needs to be made abstract?
		int w = image.getWidth();
		int h = image.getHeight();

		  System.out.println(w+" "+h);

		for (int xx = 0; xx < h; xx++) {
			for (int yy = 0; yy < w; yy++) {
				int pixel = image.getRGB(xx,yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;

				if (red == 255 && green == 255 && blue == 255) object.add(new Block(xx*32,yy*32,32f,32f,1,this,ObjectId.Block));
				if (red == 0 && green == 0 && blue == 255) object.add(new Player(xx*32,yy*32,48f,48f,this,cam,ObjectId.Player));
				if (red == 255 && green == 216 && blue == 0) object.add(new Flag(xx*32,yy*32,32f,32f,this, ObjectId.Flag));
			}
		}
	}
	
	public void setLevel() {
		clearLevel();
		System.out.println(object.size());
		if (cam != null) //{
			cam.setX(0);
		loadImageLevel(images[Game.LEVEL]);
		System.out.println(object.size());
		Game.LEVEL++;	
		//}
	}
//	public void createLevel() {
//		for (int a = 0; a < Game.WIDTH*2; a += 32)
//			addObject(new Block(a, Game.HEIGHT-32, ObjectId.Block));
//		for (int l = 0; l < Game.HEIGHT; l += 32) {
//			addObject(new Block(0, l, ObjectId.Block));
////			addObject(new Block(Game.WIDTH/2, l, ObjectId.Block));
//		}
//		for (int m = Game.WIDTH/2; m < Game.WIDTH+32; m += 32)
//			addObject(new Block(m, Game.HEIGHT*3/4-15,ObjectId.Block));
//	}

	@Override
	public void addObject(GameObject o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isOccupied(GameObject o) {
		// TODO Auto-generated method stub
		return false;
	}
}
