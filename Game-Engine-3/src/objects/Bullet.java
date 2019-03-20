package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import window.Handler;

import framework.GameObject;
import framework.HandlerInterface;
import framework.ObjectId;

public class Bullet extends GameObject {

	public Bullet(float x, float y, float w, float h, int velX, ObjectId id) {
		super(x, y, w, h, id);
		this.velX = velX;
		
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		x += velX;
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, (int)width, (int)height);
	}

//	@Override
//	protected void collision(Handler handler) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public boolean collidesWith(GameObject o) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public void tick(LinkedList<GameObject> object) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	protected void collision(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		
	}

}
