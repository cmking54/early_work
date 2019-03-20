package objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import window.Game;
import window.Handler;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;

public class Block extends GameObject{
	Texture tex = Game.getInstance();
	private int type;
	public Block(float x, float y, float w, float h, int type, Handler handler, ObjectId id) {
		super(x, y, h, w, id);
		this.setType(type);
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		//no update needed, background;
	}

	@Override
	public void render(Graphics g) {
		if (type == 0) //dirt block
			g.drawImage(tex.blocks[0], (int)x, (int)y, null);
		if (type == 1) //grass block
			g.drawImage(tex.blocks[1], (int)x, (int)y, null);
//		g.setColor(Color.WHITE);
//		g.drawRect((int)x,(int)y,width,height);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,(int)width,(int)height);
	}

	@Override
	public float getWidth() {
		return width;
	}

//	public void setWidth(int width) {
//		this.width = width;
//	}

	@Override
	public float getHeight() {
		return height;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

//	public void setHeight(int height) {
//		this.height = height;
//	}
}

	