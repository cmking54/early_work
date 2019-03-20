package objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import window.Animation;
import window.Camera;
import window.Game;
import window.Handler;
import framework.GameObject;
import framework.HandlerInterface;
import framework.ObjectId;
import framework.Texture;

public class Player extends GameObject{
	
	private float gravity = 0.5f;
	private final int TERMINAL_VELOCITY = 10;
	
	Texture tex = Game.getInstance();
	
	private Animation playerForWalk, playerBackWalk, playerJump;
	private Animation currAnimation;
	private BufferedImage currImage;
	private boolean jumpStarted;
	private boolean fallEnded;
	private Handler handler;
	
	private Camera cam;
	
	public Player(float x, float y, float w, float h, Handler handler, Camera c, ObjectId id) {
		super(x, y, w, h, id);
		this.handler = handler;
		playerForWalk = new Animation(3,  tex.player[1], 
											tex.player[2],
									 		tex.player[3]);
		playerBackWalk = new Animation(3, tex.player[5], 
											tex.player[6],
											tex.player[7]);
		playerJump = new Animation(1, tex.player[8],
										tex.player[8],
										tex.player[8],
										tex.player[8]);
		currAnimation = null;
		currImage = tex.player[0];
		frontFacing = true;
		jumpStarted = false;
		fallEnded = false;
		cam = c;
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		x += velX;
		y += velY;
		if (velX < 0) frontFacing = false;
		else if (velX > 0) frontFacing = true;
		if (falling || jumping) {
			velY += gravity;
			if (velY > 0) {
				falling = true;
				jumpStarted = false;
			}
			if (velY > TERMINAL_VELOCITY)
				velY = TERMINAL_VELOCITY;
		}
		collision(handler.object);
		if (currAnimation != null)
			currAnimation.runAnimation();
	}
	
	protected void collision(LinkedList<GameObject> object) {
		System.out.println("in collision");
		if (handler==null) System.out.println("problem");

		if (handler.object.size() == 0) System.out.println("no object");
	//	for (GameObject tempObject: handler.object) {
		for (int i = 0; i <handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			System.out.println(tempObject.getId());
			if (tempObject != null) {
				if (tempObject.getId() == ObjectId.Block) {
					if (getBounds().intersects(tempObject.getBounds())) {
						y = tempObject.getY() - height;
						//					System.out.println(y + "+" + height + "=?=" + getBounds().y + "+" + getBounds().height);
						velY = 0;
						falling = false;
						jumping = false;
					} else {
						falling = true;
					}
					if (getBoundsTop().intersects(tempObject.getBounds())) {
						y = tempObject.getY() + 36;
						velY = 0;
					}
					if (getBoundsRight().intersects(tempObject.getBounds())) {
						x = tempObject.getX() - 48; //nums needed???
					}
					if (getBoundsLeft().intersects(tempObject.getBounds())) {
						x = tempObject.getX() + 32; //nums needed???
					}				
				} else if (tempObject.getId() == ObjectId.Flag)	{
					// SWITCH LEVEL
					if (getBounds().intersects(tempObject.getBounds())) {
						handler.setLevel();
					}
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
//		System.out.println(handler.object.size()+"op");
//		System.out.println(temp.size()+"tp");
	}
	@Override
	public void render(Graphics g) {
//		System.out.println("jump:" + jumping + " fall:" + falling);
		if (jumping) {
			currAnimation = playerJump;
			playerJump.drawAnimation(g, x, y, width+10, height);
//			currAnimation = null;
//			fallEnded = false;
//			if (frontFacing) {
//				currImage = tex.player[9];
//				if (!jumpStarted) {
//					currImage = tex.player[8];
//					jumpStarted = true;
//				}
//			} else {
//				currImage = tex.player[11];
//				if (!jumpStarted) {
//					currImage = tex.player[10];
//					jumpStarted = true;
//				}
//			}
		} 
//		else if (falling) {
//			currAnimation = null;
//			jumpStarted = false;
//			if (frontFacing) {
//				currImage = tex.player[12];
//				if (!fallEnded) {
//					currImage = tex.player[14];
//					fallEnded = true;
//				}
//			} else {
//				currImage = tex.player[15];
//				if (!fallEnded) {
//					currImage = tex.player[17];
//					fallEnded = true;
//				}
//			}
//		} 
		else {
			if (velX > 0) {
				currAnimation = playerForWalk;
				playerForWalk.drawAnimation(g, x, y, width+10, height);
//				frontFacing = true;
			} else if (velX < 0) {
				currAnimation = playerBackWalk;
				playerBackWalk.drawAnimation(g, x, y, width+10, height);
//				frontFacing = false;
			} else {
				currAnimation = null;
				if (frontFacing)
					currImage = tex.player[0];
				else
					currImage = tex.player[4];
			}
		}
		if (currAnimation == null)
			g.drawImage(currImage, (int)x, (int)y, (int)width+10, (int)height, null);
//		g.setColor(Color.blue);                   //semi-arb.
//		g.fillRect((int)x, (int)y, (int)width, (int)height);
//		
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.setColor(Color.YELLOW);
//		g2d.draw(getBounds());
//		g2d.setColor(Color.RED);
//		g2d.draw(getBoundsRight());
//		g2d.setColor(Color.black);
//		g2d.draw(getBoundsLeft());
//		g2d.setColor(Color.green);
//		g2d.draw(getBoundsTop());
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)(x+width/4), (int)(y+(height/2)), (int)(width/2), (int)(height/2));
	}
	public Rectangle getBoundsTop() {
		return new Rectangle((int)(x+width/4), (int)(y), (int)(width/2), (int)(height/2));
	}
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)(x), (int)(y+width/16), (int)(width/8), (int)(height*7/8));
	}
	public Rectangle getBoundsRight() {
		return new Rectangle((int)(x+width*7/8), (int)(y+width/16), (int)(width/8), (int)(height*7/8));
	}

	@Override
	public boolean collidesWith(GameObject o) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
