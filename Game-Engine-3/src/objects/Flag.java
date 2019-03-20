package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import window.Handler;
import framework.GameObject;
import framework.ObjectId;

public class Flag extends GameObject {

	private Handler handler;
	
	public Flag(float x, float y, float w, float h, Handler hand,ObjectId id) {
		super(x, y, w, h, id);
		handler = hand;
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y, (int)width, (int)height);
	}

	@Override
	protected void collision(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean collidesWith(GameObject o) {
		// TODO Auto-generated method stub
		return false;
	}

}
