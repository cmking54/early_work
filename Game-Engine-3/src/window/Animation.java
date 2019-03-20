package window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {
	
	private int speed, frames, index = 0, count = 0;
	private BufferedImage[] images;
	private BufferedImage currentImg;
	
	public Animation(int speed, BufferedImage... args) {
		this.speed = speed;
		images = new BufferedImage[args.length];
		int idx = 0;
		for (BufferedImage i: args) {
			images[idx] = i;
			idx++;
		}
		frames = args.length;
	}
	
	public void runAnimation() {
		index++;
		if (index > speed) {
			index = 0;
			nextFrame();
		}
	}
	public void nextFrame() {
		for (int i = 0; i < frames; i++) {
			if (count == i)
				currentImg = images[i];
		}
		
		count++;
		
		if (count > frames)
			count = 0;
	}
	public void drawAnimation(Graphics g, float x, float y) {
		g.drawImage(currentImg, (int)x, (int)y, null);
	}
	public void drawAnimation(Graphics g, float x, float y, float scaleX, float scaleY) {
		g.drawImage(currentImg, (int)x, (int)y, (int)scaleX, (int)scaleY, null);
	}
}
