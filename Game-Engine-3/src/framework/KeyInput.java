package framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;

import objects.Bullet;
import window.Handler;

public class KeyInput extends KeyAdapter{
	Handler handler; //instantiates handler (see it for explanation)
	private Bullet bullet;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for (GameObject tempObject: handler.object) {
//		for (int i = 0; i <handler.object.size(); i++) {
//			GameObject tempObject = handler.object.get(i);
			
			if (tempObject != null && tempObject.getId() == ObjectId.Player) {
				if (key == KeyEvent.VK_D) tempObject.setVelX(5);
				if (key == KeyEvent.VK_A) tempObject.setVelX(-5);
				if (key == KeyEvent.VK_W && !tempObject.isJumping()) {
					tempObject.setJumping(true);
					tempObject.setVelY(-20);
				}
				if (key == KeyEvent.VK_SPACE) {
						if (tempObject.isFrontFacing())
							handler.object.add(new Bullet(tempObject.getX(),tempObject.getY(),16,16,10,ObjectId.Bullet));
							//issue adding during iteration
						else
							handler.object.add(new Bullet(tempObject.getX(),tempObject.getY(),16,16,-10,ObjectId.Bullet));
							//same as above
				}
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
//		System.out.println(handler.object.size()+"ok");
//		System.out.println(temp.size()+"tk");
//		Iterator<GameObject> iter = handler.object.iterator();
//		while (iter.hasNext()) {
//			GameObject tempObject = iter.next();
//			
//			if (tempObject.getId() == ObjectId.Player) {
//				if (key == KeyEvent.VK_D) tempObject.setVelX(5);
//				if (key == KeyEvent.VK_A) tempObject.setVelX(-5);
//				if (key == KeyEvent.VK_W && !tempObject.isJumping()) {
//					tempObject.setJumping(true);
//					tempObject.setVelY(-20);
//				}
//				if (key == KeyEvent.VK_SPACE) {
//					try {
//						if (tempObject.isFrontFacing())
//							handler.addObject(new Bullet(tempObject.getX(),tempObject.getY(),16,16,5,ObjectId.Bullet));
//							//issue adding during iteration
//						else
//							handler.addObject(new Bullet(tempObject.getX(),tempObject.getY(),16,16,- 5,ObjectId.Bullet));
//							//same as above
//					} catch (Exception e1) {
//						
//					}
//				}
//			}
//		}
//		handler.object.addAll(bulletQueue);
//		if (bullet != null) {
//			handler.addObject(bullet);
//		}
		
		
//		for (int i = 0; i < handler.object.size(); i++) {
//			GameObject tempObject = handler.object.get(i);
//			if (tempObject.getId() == ObjectId.Player) {
//				if (key == KeyEvent.VK_D) tempObject.setVelX(5);
//				if (key == KeyEvent.VK_A) tempObject.setVelX(-5);
//				if (key == KeyEvent.VK_W && !tempObject.isJumping()) {
//					tempObject.setJumping(true);
//					tempObject.setVelY(-20);
//				}
//				if (key == KeyEvent.VK_SPACE) {
//						if (tempObject.isFrontFacing())
//							handler.addObject(new Bullet(tempObject.getX(),tempObject.getY(),16,16,5,ObjectId.Bullet));
//						else
//							handler.addObject(new Bullet(tempObject.getX(),tempObject.getY(),16,16,- 5,ObjectId.Bullet));
//				}
//			}
//		}
		
		if (key == KeyEvent.VK_ESCAPE)
			System.exit(1);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (GameObject tempObject: handler.object) {
//		for (int i = 0; i <handler.object.size(); i++) {
//			GameObject tempObject = handler.object.get(i);
			if (tempObject != null && tempObject.getId() == ObjectId.Player) {
				if (key == KeyEvent.VK_D) tempObject.setVelX(0);
				if (key == KeyEvent.VK_A) tempObject.setVelX(0);
				if (key == KeyEvent.VK_W) tempObject.setFalling(true);
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
//		System.out.println(handler.object.size()+"ko");
//		System.out.println(temp.size()+"kt");
//		Iterator<GameObject> iter = handler.object.iterator();
//		while (iter.hasNext()) {
//			GameObject tempObject = iter.next();
//			
//			
//		}
//		for (int i = 0; i < handler.object.size(); i++) {
//			GameObject tempObject = handler.object.get(i);
//			if (tempObject.getId() == ObjectId.Player) {
//				if (key == KeyEvent.VK_D) tempObject.setVelX(5);
//				if (key == KeyEvent.VK_A) tempObject.setVelX(-5);
//			}
//		}
		
		if (key == KeyEvent.VK_ESCAPE)
			System.exit(1);
	}
}