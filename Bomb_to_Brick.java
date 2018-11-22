package Object_to_Object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Framework.LoadMap;
import Graphics.ImageList;
import Object.Bomber;

public class Bomb_to_Brick {
	ImageList imageList = new ImageList();
	protected BufferedImage brick_exploded = imageList.brick_exploded;
	protected BufferedImage brick_exploded1 = imageList.brick_exploded1;
	protected BufferedImage brick_exploded2 = imageList.brick_exploded2;

	public void update(int x, int y, Bomber bomber) {
		bomber.loadMap.map[x][y] = ' ';
		for (int i = 0; i < bomber.item.bombItems.size(); i++) {
			if (bomber.item.bombItems.get(i).loc_x / 40 == y && bomber.item.bombItems.get(i).loc_y / 40 == x) {
				bomber.loadMap.map[x][y] = 'b';
				bomber.item.bombItems.get(i).ishide = false;
			}
		}
		for (int i = 0; i < bomber.item.speedItems.size(); i++) {
			if (bomber.item.speedItems.get(i).loc_x / 40 == y && bomber.item.speedItems.get(i).loc_y / 40 == x) {
				bomber.loadMap.map[x][y] = 's';
				bomber.item.speedItems.get(i).ishide = false;
			}
		}
		for (int i = 0; i < bomber.item.flameItems.size(); i++) {
			if (bomber.item.flameItems.get(i).loc_x / 40 == y && bomber.item.flameItems.get(i).loc_y / 40 == x) {
				bomber.loadMap.map[x][y] = 'f';
				bomber.item.flameItems.get(i).ishide = false;
			}
		}
		for (int i = 0; i < bomber.item.portals.size(); i++) {
			if (bomber.item.portals.get(i).loc_x / 40 == y && bomber.item.portals.get(i).loc_y / 40 == x) {
				bomber.loadMap.map[x][y] = 'x';
				bomber.item.portals.get(i).ishide = false;
			}
		}
	}

	public void draw(Graphics2D g2, int loc_x, int loc_y) {
		g2.drawImage(brick_exploded, loc_x, loc_y, 40, 40, null);
	}

	public void draw1(Graphics2D g2, int loc_x, int loc_y) {
		g2.drawImage(brick_exploded1, loc_x, loc_y, 40, 40, null);
	}

	public void draw2(Graphics2D g2, int loc_x, int loc_y) {
		g2.drawImage(brick_exploded2, loc_x, loc_y, 40, 40, null);
	}

}
