package framework;

import java.awt.image.BufferedImage;
	
/**
 * @author Chris
 * Processes a image (preferably a model sheet) to 
 * retrieve the image from each cell based on row 
 * and column.
 */
public class SpriteSheet {
	private BufferedImage image;
	
	public SpriteSheet(BufferedImage image) {
		this.image = image;
	}
	
	public BufferedImage grabImage(int col, int row, int width, int height) {
		 BufferedImage img = image.getSubimage((col * width) - width, (row * height) - height, width, height);
		                                         //which column//          //which row//
		 return img;
	}
}
