package Object_to_Object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Graphics.ImageList;
import Object.Bomb;
import Object.Bomber;

public class Bomber_to_Enemy {
	public void isDie(Bomber bomber) {
		for(int i=0;i<bomber.enemy.ballooms.size();i++) {
			if(bomber.enemy.ballooms.get(i).loc_x > bomber.loc_x-40 && bomber.enemy.ballooms.get(i).loc_x < bomber.loc_x+40    &&    bomber.enemy.ballooms.get(i).loc_y > bomber.loc_y-40 && bomber.enemy.ballooms.get(i).loc_y < bomber.loc_y+40 )
				bomber.isDie = true;
			if(bomber.loc_x > bomber.enemy.ballooms.get(i).loc_x-40 && bomber.loc_x < bomber.enemy.ballooms.get(i).loc_x+40    &&    bomber.loc_y > bomber.enemy.ballooms.get(i).loc_y-40 && bomber.loc_y < bomber.enemy.ballooms.get(i).loc_y+40 )
				bomber.isDie = true;
		}
		for(int i=0;i<bomber.enemy.oneals.size();i++) {
			if(bomber.enemy.oneals.get(i).loc_x > bomber.loc_x-40 && bomber.enemy.oneals.get(i).loc_x < bomber.loc_x+40    &&    bomber.enemy.oneals.get(i).loc_y > bomber.loc_y-40 && bomber.enemy.oneals.get(i).loc_y < bomber.loc_y+40 )
				bomber.isDie = true;
			if(bomber.loc_x > bomber.enemy.oneals.get(i).loc_x-40 && bomber.loc_x < bomber.enemy.oneals.get(i).loc_x+40    &&    bomber.loc_y > bomber.enemy.oneals.get(i).loc_y-40 && bomber.loc_y < bomber.enemy.oneals.get(i).loc_y+40 )
				bomber.isDie = true;
		}
	}
	
	
	
	
	
	// size la 40 nhung ve len avatar chi co khoang 30 con lai la khung nen
	ImageList imageList = new ImageList();
	BufferedImage player_dead1= imageList.player_dead1;
	BufferedImage player_dead2= imageList.player_dead2;
	BufferedImage player_dead3= imageList.player_dead3;
	
	public void draw(Graphics2D g2, Bomber bomber) {
		
		if(System.currentTimeMillis()-bomber.deadTime<330)
			g2.drawImage(player_dead1, bomber.loc_x, bomber.loc_y, 40, 40, null);
		else if(System.currentTimeMillis()-bomber.deadTime<660)
			g2.drawImage(player_dead2, bomber.loc_x, bomber.loc_y, 40, 40, null);
		else if(System.currentTimeMillis()-bomber.deadTime<1000)
		{
			g2.drawImage(player_dead3, bomber.loc_x, bomber.loc_y, 40, 40, null);
		}
	}
}
