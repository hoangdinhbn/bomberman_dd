package Object_to_Object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Graphics.ImageList;
import Object.Bomb;
import Object.Bomber;

public class Bomb_to_Bomber {
	public void isDie_LEFT(Bomber bomber, Bomb bomb) {
		if(bomber.loc_x > bomb.loc_x-bomb.superFlame*40-30 && bomber.loc_x < bomb.loc_x+30 && bomber.loc_y > bomb.loc_y-40 && bomber.loc_y < bomb.loc_y+40)
			bomber.isDie = true;
	}
	public void isDie_RIGHT(Bomber bomber, Bomb bomb) {
		if(bomber.loc_x > bomb.loc_x-30 && bomber.loc_x < bomb.loc_x+bomb.superFlame*40+30 && bomber.loc_y > bomb.loc_y-40 && bomber.loc_y < bomb.loc_y+40)
			bomber.isDie = true;
	}
	public void isDie_UP(Bomber bomber, Bomb bomb) {
		 if(bomber.loc_y > bomb.loc_y-bomb.superFlame*40-40 && bomber.loc_y < bomb.loc_y+40 && bomber.loc_x > bomb.loc_x-40 && bomber.loc_x < bomb.loc_x+40)
			bomber.isDie = true;
	}
	public void isDie_DOWN(Bomber bomber, Bomb bomb) {
		 if(bomber.loc_y > bomb.loc_y-40 && bomber.loc_y < bomb.loc_y+bomb.superFlame*40+40 && bomber.loc_x > bomb.loc_x-40 && bomber.loc_x < bomb.loc_x+40)
			bomber.isDie = true;
	}
	// size la 40 nhung ve len avatar chi co khoang 30 con lai la khung nen
	ImageList imageList = new ImageList();
	BufferedImage player_dead1= imageList.player_dead1;
	BufferedImage player_dead2= imageList.player_dead2;
	BufferedImage player_dead3= imageList.player_dead3;
	
	
}
