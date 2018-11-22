package Object_to_Object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Graphics.ImageList;
import Object.Bomb;
import Object.Bomber;

public class bomb_to_Enemy {
	public void isDie_LEFT(Bomber bomber, Bomb bomb) { // enmery so voi bom
		
		for(int i=0;i<bomber.enemy.ballooms.size();i++) {
			if(bomber.enemy.ballooms.get(i).loc_x > bomb.loc_x-bomb.superFlame*40-30 && bomber.enemy.ballooms.get(i).loc_x < bomb.loc_x+30 && bomber.enemy.ballooms.get(i).loc_y > bomb.loc_y-40 &&  bomber.enemy.ballooms.get(i).loc_y < bomb.loc_y+40)
				bomber.enemy.ballooms.get(i).isDie = true;
		}
		
		for(int i=0;i<bomber.enemy.oneals.size();i++) {
			if(bomber.enemy.oneals.get(i).loc_x > bomb.loc_x-bomb.superFlame*40-30 && bomber.enemy.oneals.get(i).loc_x < bomb.loc_x+30 && bomber.enemy.oneals.get(i).loc_y > bomb.loc_y-40 &&  bomber.enemy.oneals.get(i).loc_y < bomb.loc_y+40)
				bomber.enemy.oneals.get(i).isDie = true;
		}
		
	}
public void isDie_RIGHT(Bomber bomber, Bomb bomb) { // enmery so voi bom
		
		for(int i=0;i<bomber.enemy.ballooms.size();i++) {
			if(bomber.enemy.ballooms.get(i).loc_x > bomb.loc_x-30 && bomber.enemy.ballooms.get(i).loc_x < bomb.loc_x+bomb.superFlame*40+30 && bomber.enemy.ballooms.get(i).loc_y > bomb.loc_y-40 &&  bomber.enemy.ballooms.get(i).loc_y < bomb.loc_y+40)
				bomber.enemy.ballooms.get(i).isDie = true;
		}
		
		for(int i=0;i<bomber.enemy.oneals.size();i++) {
			if(bomber.enemy.oneals.get(i).loc_x > bomb.loc_x-30 && bomber.enemy.oneals.get(i).loc_x < bomb.loc_x+bomb.superFlame*40+30 && bomber.enemy.oneals.get(i).loc_y > bomb.loc_y-40 &&  bomber.enemy.oneals.get(i).loc_y < bomb.loc_y+40)
				bomber.enemy.oneals.get(i).isDie = true;
		}
		
	}
public void isDie_UP(Bomber bomber, Bomb bomb) { // enmery so voi bom
	
	for(int i=0;i<bomber.enemy.ballooms.size();i++) {
		 if(bomber.enemy.ballooms.get(i).loc_y > bomb.loc_y-bomb.superFlame*40-30 && bomber.enemy.ballooms.get(i).loc_y < bomb.loc_y+30 && bomber.enemy.ballooms.get(i).loc_x > bomb.loc_x-40 &&  bomber.enemy.ballooms.get(i).loc_x < bomb.loc_x+40)
			bomber.enemy.ballooms.get(i).isDie = true;
	}
	
	for(int i=0;i<bomber.enemy.oneals.size();i++) {
		 if(bomber.enemy.oneals.get(i).loc_y > bomb.loc_y-bomb.superFlame*40-30 && bomber.enemy.oneals.get(i).loc_y < bomb.loc_y+30 && bomber.enemy.oneals.get(i).loc_x > bomb.loc_x-40 && bomber.enemy.oneals.get(i).loc_x < bomb.loc_x+40)
			bomber.enemy.oneals.get(i).isDie = true;
	}
	
}
public void isDie_DOWN(Bomber bomber, Bomb bomb) { // enmery so voi bom
	
	for(int i=0;i<bomber.enemy.ballooms.size();i++) {
		 if(bomber.enemy.ballooms.get(i).loc_y > bomb.loc_y-30 && bomber.enemy.ballooms.get(i).loc_y < bomb.loc_y+bomb.superFlame*40+30 && bomber.enemy.ballooms.get(i).loc_x > bomb.loc_x-40 &&  bomber.enemy.ballooms.get(i).loc_x < bomb.loc_x+40)
			bomber.enemy.ballooms.get(i).isDie = true;
	}
	
	for(int i=0;i<bomber.enemy.oneals.size();i++) {
		 if(bomber.enemy.oneals.get(i).loc_y > bomb.loc_y-30 && bomber.enemy.oneals.get(i).loc_y < bomb.loc_y+bomb.superFlame*40+30 && bomber.enemy.oneals.get(i).loc_x > bomb.loc_x-40 && bomber.enemy.oneals.get(i).loc_x < bomb.loc_x+40)
			bomber.enemy.oneals.get(i).isDie = true;
	}
	
}
	// size anh la 40 nhung avatar chir chiem 30/40
	
	BufferedImage balloom_dead= ImageList.balloom_dead;
	BufferedImage oneal_dead= ImageList.oneal_dead;
	
	public void draw(Graphics2D g2, Bomber bomber) {
		for(int i=0;i<bomber.enemy.ballooms.size();i++) {
			if(bomber.enemy.ballooms.get(i).isDie==true)
				g2.drawImage(balloom_dead, bomber.enemy.ballooms.get(i).loc_x, bomber.enemy.ballooms.get(i).loc_y, 40, 40, null);
		}
		for(int i=0;i<bomber.enemy.oneals.size();i++) {
			if(bomber.enemy.oneals.get(i).isDie==true)
				g2.drawImage(oneal_dead, bomber.enemy.oneals.get(i).loc_x, bomber.enemy.oneals.get(i).loc_y, 40, 40, null);
		}
	}
	
	
	public void update(Bomber bomber) {
		for(int i=0;i<bomber.enemy.ballooms.size();i++) {
			if(bomber.enemy.ballooms.get(i).isDie==true)
				bomber.enemy.ballooms.remove(i);
		}
		for(int i=0;i<bomber.enemy.oneals.size();i++) {
			if(bomber.enemy.oneals.get(i).isDie==true)
				bomber.enemy.oneals.remove(i);
		}
	}

}
