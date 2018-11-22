package Object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Graphics.ImageList;
import Object_to_Object.Bomb_to_Bomber;
import Object_to_Object.Bomb_to_Brick;
import Object_to_Object.bomb_to_Enemy;

public class Bomb extends Thread {
	public int loc_x, loc_y;
	public long time = 5000; // thoi gian ton tai
	public long time_begin;
	public long time_end;
	public boolean isExploded = false;
	public int superFlame;
	Bomber bomber = new Bomber();
	BufferedImage image;
	Bomb_to_Brick bomb_to_Brick = new Bomb_to_Brick();
	Bomb_to_Bomber bomb_to_Bomber = new Bomb_to_Bomber();
	bomb_to_Enemy bomb_to_Enemy = new bomb_to_Enemy();

	public Bomb(Bomber bomber) {
		this.loc_x = 40 * (int) Math.round(bomber.loc_x / 40.0);
		this.loc_y = 40 * (int) Math.round(bomber.loc_y / 40.0);
		bomber.loadMap.map[loc_y / 40][loc_x / 40] = 'c';
		this.bomber = bomber;
		superFlame = bomber.superFlame;
		time_begin = System.currentTimeMillis();

	}

	public void draw(Graphics2D g2, Bomb bomb) {
		time_end = System.currentTimeMillis();
		if (time_end - time_begin < 660)
			image = bomb_2;
		else if (time_end - time_begin < 1330)
			image = bomb_1;
		else if (time_end - time_begin < 2000)
			image = bomb_0;
		else if (time_end - time_begin < 2660)
			image = bomb_2;
		else if (time_end - time_begin < 3330)
			image = bomb_1;
		else if (time_end - time_begin < 4000)
			image = bomb_0;
		else if (time_end - time_begin < 4330) {

			for (int i = 1; i <= superFlame; i++) { // left
				if (bomber.loadMap.map[loc_y / 40][loc_x / 40 - i] == '#')
					break;
				else if (bomber.loadMap.map[loc_y / 40][loc_x / 40 - i] == '*') {
					bomb_to_Brick.draw(g2, loc_x - 40 * i, loc_y);
					break;
				}
				bomb_to_Enemy.isDie_LEFT(bomber, bomb);
				bomb_to_Bomber.isDie_LEFT(bomber, bomb);
				if (i != superFlame)
					image = explosion_horizontal2;
				else
					image = explosion_horizontal_left_last2;
				g2.drawImage(image, bomb.loc_x - 40 * i, bomb.loc_y, 40, 40, null);
			}

			for (int i = 1; i <= superFlame; i++) { // right
				if (bomber.loadMap.map[loc_y / 40][loc_x / 40 + i] == '#')
					break;
				else if (bomber.loadMap.map[loc_y / 40][loc_x / 40 + i] == '*') {
					bomb_to_Brick.draw(g2, loc_x + 40 * i, loc_y);
					break;
				}
				bomb_to_Enemy.isDie_RIGHT(bomber, bomb);
				bomb_to_Bomber.isDie_RIGHT(bomber, bomb);
				if (i != superFlame)
					image = explosion_horizontal2;
				else
					image = explosion_horizontal_right_last2;
				g2.drawImage(image, bomb.loc_x + 40 * i, bomb.loc_y, 40, 40, null);
			}

			for (int i = 1; i <= superFlame; i++) { // up
				if (bomber.loadMap.map[loc_y / 40 - i][loc_x / 40] == '#')
					break;
				else if (bomber.loadMap.map[loc_y / 40 - i][loc_x / 40] == '*') {
					bomb_to_Brick.draw(g2, loc_x, loc_y - 40 * i);
					break;
				}
				bomb_to_Enemy.isDie_UP(bomber, bomb);
				bomb_to_Bomber.isDie_UP(bomber, bomb);
				if (i != superFlame)
					image = explosion_vertical2;
				else
					image = explosion_vertical_top_last2;
				g2.drawImage(image, bomb.loc_x, bomb.loc_y - i * 40, 40, 40, null);
			}
			for (int i = 1; i <= superFlame; i++) { // down
				if (bomber.loadMap.map[loc_y / 40 + i][loc_x / 40] == '#')
					break;
				else if (bomber.loadMap.map[loc_y / 40 + i][loc_x / 40] == '*') {
					bomb_to_Brick.draw(g2, loc_x, loc_y + 40 * i);
					break;
				}
				bomb_to_Enemy.isDie_DOWN(bomber, bomb);
				bomb_to_Bomber.isDie_DOWN(bomber, bomb);
				if (i != superFlame)
					image = explosion_vertical2;
				else
					image = explosion_vertical_down_last2;
				g2.drawImage(image, bomb.loc_x, bomb.loc_y + i * 40, 40, 40, null);
			}
			// Xu li bomb cho nay
			bomb_to_Enemy.draw(g2, bomber);

			image = bomb_exploded2;
		}

		else if (time_end - time_begin < 4666) {
			for (int i = 1; i <= superFlame; i++) { // left
				if (bomber.loadMap.map[loc_y / 40][loc_x / 40 - i] == '#')
					break;
				else if (bomber.loadMap.map[loc_y / 40][loc_x / 40 - i] == '*') {
					bomb_to_Brick.draw1(g2, loc_x - 40 * i, loc_y);
					break;
				}
				bomb_to_Enemy.isDie_LEFT(bomber, bomb);
				bomb_to_Bomber.isDie_LEFT(bomber, bomb);
				if (i != superFlame)
					image = explosion_horizontal1;
				else
					image = explosion_horizontal_left_last1;
				g2.drawImage(image, bomb.loc_x - 40 * i, bomb.loc_y, 40, 40, null);
			}

			for (int i = 1; i <= superFlame; i++) { // right
				if (bomber.loadMap.map[loc_y / 40][loc_x / 40 + i] == '#')
					break;
				else if (bomber.loadMap.map[loc_y / 40][loc_x / 40 + i] == '*') {
					bomb_to_Brick.draw1(g2, loc_x + 40 * i, loc_y);
					break;
				}
				bomb_to_Enemy.isDie_RIGHT(bomber, bomb);
				bomb_to_Bomber.isDie_RIGHT(bomber, bomb);
				if (i != superFlame)
					image = explosion_horizontal1;
				else
					image = explosion_horizontal_right_last1;
				g2.drawImage(image, bomb.loc_x + 40 * i, bomb.loc_y, 40, 40, null);
			}

			for (int i = 1; i <= superFlame; i++) { // up
				if (bomber.loadMap.map[loc_y / 40 - i][loc_x / 40] == '#')
					break;
				else if (bomber.loadMap.map[loc_y / 40 - i][loc_x / 40] == '*') {
					bomb_to_Brick.draw1(g2, loc_x, loc_y - 40 * i);
					break;
				}
				bomb_to_Enemy.isDie_UP(bomber, bomb);
				bomb_to_Bomber.isDie_UP(bomber, bomb);
				if (i != superFlame)
					image = explosion_vertical1;
				else
					image = explosion_vertical_top_last1;
				g2.drawImage(image, bomb.loc_x, bomb.loc_y - i * 40, 40, 40, null);
			}
			for (int i = 1; i <= superFlame; i++) { // down
				if (bomber.loadMap.map[loc_y / 40 + i][loc_x / 40] == '#')
					break;
				else if (bomber.loadMap.map[loc_y / 40 + i][loc_x / 40] == '*') {
					bomb_to_Brick.draw1(g2, loc_x, loc_y + 40 * i);
					break;
				}
				bomb_to_Enemy.isDie_DOWN(bomber, bomb);
				bomb_to_Bomber.isDie_DOWN(bomber, bomb);
				if (i != superFlame)
					image = explosion_vertical1;
				else
					image = explosion_vertical_down_last1;
				g2.drawImage(image, bomb.loc_x, bomb.loc_y + i * 40, 40, 40, null);
			}
			bomb_to_Enemy.draw(g2, bomber);
			image = bomb_exploded1;
		}

		else {
			for (int i = 1; i <= superFlame; i++) { // left
				if (bomber.loadMap.map[loc_y / 40][loc_x / 40 - i] == '#')
					break;
				else if (bomber.loadMap.map[loc_y / 40][loc_x / 40 - i] == '*') {
					bomb_to_Brick.draw2(g2, loc_x - 40 * i, loc_y);
					bomb_to_Brick.update(loc_y / 40, loc_x / 40 - i, bomber);
					break;
				}
				bomb_to_Enemy.isDie_LEFT(bomber, bomb);
				bomb_to_Bomber.isDie_LEFT(bomber, bomb);
				if (i != superFlame)
					image = explosion_horizontal;
				else
					image = explosion_horizontal_left_last;
				g2.drawImage(image, bomb.loc_x - 40 * i, bomb.loc_y, 40, 40, null);
			}

			for (int i = 1; i <= superFlame; i++) { // right
				if (bomber.loadMap.map[loc_y / 40][loc_x / 40 + i] == '#')
					break;
				else if (bomber.loadMap.map[loc_y / 40][loc_x / 40 + i] == '*') {
					bomb_to_Brick.draw2(g2, loc_x + 40 * i, loc_y);
					bomb_to_Brick.update(loc_y / 40, loc_x / 40 + i, bomber);
					break;
				}
				bomb_to_Enemy.isDie_RIGHT(bomber, bomb);
				bomb_to_Bomber.isDie_RIGHT(bomber, bomb);
				if (i != superFlame)
					image = explosion_horizontal;
				else
					image = explosion_horizontal_right_last;
				g2.drawImage(image, bomb.loc_x + 40 * i, bomb.loc_y, 40, 40, null);
			}

			for (int i = 1; i <= superFlame; i++) { // up
				if (bomber.loadMap.map[loc_y / 40 - i][loc_x / 40] == '#')
					break;
				else if (bomber.loadMap.map[loc_y / 40 - i][loc_x / 40] == '*') {
					bomb_to_Brick.draw2(g2, loc_x, loc_y - 40 * i);
					bomb_to_Brick.update(loc_y / 40 - i, loc_x / 40, bomber);
					break;
				}
				bomb_to_Enemy.isDie_UP(bomber, bomb);
				bomb_to_Bomber.isDie_UP(bomber, bomb);
				if (i != superFlame)
					image = explosion_vertical;
				else
					image = explosion_vertical_top_last;
				g2.drawImage(image, bomb.loc_x, bomb.loc_y - i * 40, 40, 40, null);
			}
			for (int i = 1; i <= superFlame; i++) { // down
				if (bomber.loadMap.map[loc_y / 40 + i][loc_x / 40] == '#')
					break;
				else if (bomber.loadMap.map[loc_y / 40 + i][loc_x / 40] == '*') {
					bomb_to_Brick.draw2(g2, loc_x, loc_y + 40 * i);
					bomb_to_Brick.update(loc_y / 40 + i, loc_x / 40, bomber);
					break;
				}
				bomb_to_Enemy.isDie_DOWN(bomber, bomb);
				bomb_to_Bomber.isDie_DOWN(bomber, bomb);
				if (i != superFlame)
					image = explosion_vertical;
				else
					image = explosion_vertical_down_last;
				g2.drawImage(image, bomb.loc_x, bomb.loc_y + i * 40, 40, 40, null);
			}
			bomb_to_Enemy.draw(g2, bomber);
			bomb_to_Enemy.update(bomber);
			image = bomb_exploded;
			this.isExploded = true;
		}

		g2.drawImage(image, bomb.loc_x, bomb.loc_y, 40, 40, null);

	}

	protected BufferedImage bomb_0 = ImageList.bomb;
	protected BufferedImage bomb_1 = ImageList.bomb_1;
	protected BufferedImage bomb_2 = ImageList.bomb_2;
	protected BufferedImage bomb_exploded = ImageList.bomb_exploded;
	protected BufferedImage bomb_exploded1 = ImageList.bomb_exploded1;
	protected BufferedImage bomb_exploded2 = ImageList.bomb_exploded2;
	protected BufferedImage explosion_horizontal2 = ImageList.explosion_horizontal2;
	protected BufferedImage explosion_horizontal1 = ImageList.explosion_horizontal1;
	protected BufferedImage explosion_horizontal = ImageList.explosion_horizontal;
	protected BufferedImage explosion_horizontal_left_last = ImageList.explosion_horizontal_left_last;
	protected BufferedImage explosion_horizontal_left_last1 = ImageList.explosion_horizontal_left_last1;
	protected BufferedImage explosion_horizontal_left_last2 = ImageList.explosion_horizontal_left_last2;
	protected BufferedImage explosion_horizontal_right_last = ImageList.explosion_horizontal_right_last;
	protected BufferedImage explosion_horizontal_right_last1 = ImageList.explosion_horizontal_right_last1;
	protected BufferedImage explosion_horizontal_right_last2 = ImageList.explosion_horizontal_right_last2;
	protected BufferedImage explosion_vertical = ImageList.explosion_vertical;
	protected BufferedImage explosion_vertical1 = ImageList.explosion_vertical1;
	protected BufferedImage explosion_vertical2 = ImageList.explosion_vertical2;
	protected BufferedImage explosion_vertical_down_last = ImageList.explosion_vertical_down_last;
	protected BufferedImage explosion_vertical_down_last1 = ImageList.explosion_vertical_down_last1;
	protected BufferedImage explosion_vertical_down_last2 = ImageList.explosion_vertical_down_last2;
	protected BufferedImage explosion_vertical_top_last = ImageList.explosion_vertical_top_last;
	protected BufferedImage explosion_vertical_top_last1 = ImageList.explosion_vertical_top_last1;
	protected BufferedImage explosion_vertical_top_last2 = ImageList.explosion_vertical_top_last2;
}
