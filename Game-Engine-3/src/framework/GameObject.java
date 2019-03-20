package framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
/**
 * @author Chris
 * Every physical object in the game has to extend this.
 * Has the basic fields and get/set methods, is expanded by 
 * whatever various objects.
 * gO = gameObject
 */
public abstract class GameObject {
	protected float x, y, width, height; //coordinates to draw from; basis of gO's existence
	protected boolean falling = true, jumping = false;//tells when to allow gOs to do actions
	protected boolean frontFacing = true; //tells which direction this gO is facing
	// above can be replaced with int if more than two directions needed
	protected ObjectId id; //id given from an enum to id gOs
	protected float velX = 0, velY = 0; //movement physics
	
	public GameObject (float x, float y, float w, float h, ObjectId id) {
		this.x = x;
		this.y = y;
		this.id = id;
		width = w;
		height = h;
	}
	
	public abstract void tick(LinkedList<GameObject> object); //tick = advance by one gameSecond
	protected abstract void collision(LinkedList<GameObject> object);
	public abstract boolean collidesWith(GameObject o);
	public abstract void render(Graphics g); //drawing method
	public abstract Rectangle getBounds(); //whole rect (hitBox) 
	
	///////////////////////////////////////
	//              Getters/Setters
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setX(float x) {
		this.x = x;		
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelX(float velX) {
		this.velX = velX;		
	}

	public void setVelY(float velY) {
		this.velY = velY;		
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	
	public ObjectId getId() {
		return id;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public boolean isFrontFacing() {
		return frontFacing;
	}
	
	public boolean equals(GameObject o) {
		return x == o.x && y == o.y && id == o.id;
	}

}
