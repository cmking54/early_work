package window;

import framework.GameObject;
	
/**
 * @author Chris
 * The view seen by the user
 *
 */
public class Camera {
	
	private float x, y;
	
	public Camera (float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick(GameObject player) {
		// uses an algorithm called twean
		// snaps on the player per Gs
		x = -player.getX() + Game.WIDTH/2; //only x bound
	}
	////////////////////////////////////////
	//              get/set               //
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
