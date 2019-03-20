package framework;

import java.awt.image.BufferedImage;

import window.BufferedImageLoader;

public class Texture {
	
	private SpriteSheet pfms, pbms, pfjs, pbjs, pffs, pbfs, bs;
	private BufferedImage block_sheet = null;
	private BufferedImage[] player_sheets = new BufferedImage[6];
	
	public BufferedImage[] blocks = new BufferedImage[2];
	public BufferedImage[] player = new BufferedImage[18];

	
	
	public Texture() {
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			block_sheet = loader.loadImage("minecraft_block_sheet.png");
			player_sheets[0] = loader.loadImage("player_for_run.png");
			player_sheets[1] = loader.loadImage("player_back_run.png");
			player_sheets[2] = loader.loadImage("player_for_jump.png");
			player_sheets[3] = loader.loadImage("player_back_jump.png");
			player_sheets[4] = loader.loadImage("player_for_fall.png");
			player_sheets[5] = loader.loadImage("player_back_fall.png");
		} catch (Exception e) { e.printStackTrace(); }
		
		bs = new SpriteSheet(block_sheet);
		pfms = new SpriteSheet(player_sheets[0]);
		pbms = new SpriteSheet(player_sheets[1]);
		pfjs = new SpriteSheet(player_sheets[2]);
		pbjs = new SpriteSheet(player_sheets[3]);
		pffs = new SpriteSheet(player_sheets[4]);
		pbfs = new SpriteSheet(player_sheets[5]);
		
		
		getTextures();
	}
	
	private void getTextures() {
		blocks[0] = bs.grabImage(1, 1, 32, 32); //dirt
		blocks[1] = bs.grabImage(3, 1, 32, 32); //grass
												//forward
		player[0] = pfms.grabImage(1, 1, 25, 24); //idle
		player[1] = pfms.grabImage(2, 1, 25, 24); //begin run
		player[2] = pfms.grabImage(3, 1, 26, 24); //mid run
		player[3] = pfms.grabImage(4, 1, 25, 24); //slow down
												//backwards
		player[4] = pbms.grabImage(4, 1, 25, 24); //idle
		player[5] = pbms.grabImage(3, 1, 25, 24); //begin run
		player[6] = pbms.grabImage(2, 1, 24, 24); //mid run
		player[7] = pbms.grabImage(1, 1, 25, 24); //slow down
		
		player[8] = pfjs.grabImage(1, 1, 28, 24); //start jump
		player[9] = pfjs.grabImage(2, 1, 28, 24); //ascend
		
		player[10] = pbjs.grabImage(2, 1, 28, 24); //start jump
		player[11] = pbjs.grabImage(1, 1, 28, 24); //ascend
		
		player[12] = pffs.grabImage(2, 1, 27, 24); //descend
		player[13] = pffs.grabImage(3, 1, 30, 24); //hit
		player[14] = pffs.grabImage(1, 1, 30, 24); //slide
		
		player[15] = pffs.grabImage(2, 1, 27, 24); //descend
		player[16] = pffs.grabImage(1, 1, 30, 24); //hit
		player[17] = pffs.grabImage(3, 1, 30, 24); //slide
		
		
	}
}