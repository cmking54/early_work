package framework;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public interface HandlerInterface {
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	public void tick();
	public void addObject(GameObject o);
	public boolean isOccupied(GameObject o);
	public void render(Graphics g);
	public void loadImageLevel(BufferedImage image);
	public void setLevel();
}
