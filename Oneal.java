package Object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;
import Graphics.ImageList;

public class Oneal {
	public int loc_x;
	public int loc_y;
	public int speed;
	protected boolean isRun = true;
	protected boolean LEFT = false, RIGHT = false, UP = false, DOWN = false;
	protected int chosee = 1;
	public boolean isDie = false;;
	protected int[] animation = { -1, -1, -1, -1 }; // left right up down

	public Oneal(int x, int y, int speed) {
		this.loc_x = x;
		this.loc_y = y;
		this.speed = speed;
	}

	public void move(int[][] map) {
		if (LEFT == false && RIGHT == false && UP == false && DOWN == false) {
			Random random = new Random();
			chosee = random.nextInt() % 4;
			if (chosee == 0)
				LEFT = true;
			else if (chosee == 1)
				RIGHT = true;
			else if (chosee == 2)
				UP = true;
			else
				DOWN = true;
		}

		if (LEFT) {
			this.loc_x -= speed;// left
			animation[0]++;
			animation[1] = -1;
			animation[2] = -1;
			animation[3] = -1;
			if (isMove(this, map) == false) {
				this.loc_x += speed;
				LEFT = false;
			}

		} else if (RIGHT) {
			this.loc_x += speed; // right
			animation[0] = -1;
			animation[1]++;
			animation[2] = -1;
			animation[3] = -1;
			if (isMove(this, map) == false) {
				this.loc_x -= speed;
				RIGHT = false;
			}
		}

		else if (UP) {
			this.loc_y -= speed;// up
			animation[0] = -1;
			animation[1] = -1;
			animation[2]++;
			animation[3] = -1;
			if (isMove(this, map) == false) {
				this.loc_y += speed;
				UP = false;
			}
		} else if (DOWN) {
			this.loc_y += speed;// down
			animation[0] = -1;
			animation[1] = -1;
			animation[2] = -1;
			animation[3]++;
			if (isMove(this, map) == false) {
				this.loc_y -= speed;
				DOWN = false;

			}
		}
	}

	public boolean isMove(Oneal oneal, int[][] map) {
		int x_left = (int) Math.floor(oneal.loc_x / 40.0);
		int x_right = (int) Math.ceil(oneal.loc_x / 40.0);
		int y_down = (int) Math.floor(oneal.loc_y / 40.0);
		int y_up = (int) Math.ceil(oneal.loc_y / 40.0);
		if (map[y_up][x_right] == '#' || map[y_up][x_right] == '*' || map[y_up][x_right] == 'c')
			return false;
		else if (map[y_up][x_left] == '#' || map[y_up][x_left] == '*' || map[y_up][x_left] == 'c')
			return false;
		else if (map[y_down][x_left] == '#' || map[y_down][x_left] == '*' || map[y_down][x_left] == 'c')
			return false;
		else if (map[y_down][x_right] == '#' || map[y_down][x_right] == '*' || map[y_down][x_right] == 'c')
			return false;
		else
			return true;

	}

	protected BufferedImage oneal_left1 = ImageList.oneal_left1;
	protected BufferedImage oneal_left2 = ImageList.oneal_left2;
	protected BufferedImage oneal_left3 = ImageList.oneal_left3;
	protected BufferedImage oneal_right2 = ImageList.oneal_right2;
	protected BufferedImage oneal_right3 = ImageList.oneal_right3;
	protected BufferedImage oneal_right1 = ImageList.oneal_right1;

	public void draw(Graphics2D g2, Oneal oneal, int[][] map) {
		BufferedImage image;
		if(oneal.isDie==false) {
			move(map);
			if (oneal.animation[0] >= 0 && oneal.animation[0] % 12 < 4)
				image = oneal_left1;
			else if (oneal.animation[0] >= 0 && oneal.animation[0] % 12 < 8)
				image = oneal_left2;
			else if (oneal.animation[0] >= 0 && oneal.animation[0] % 12 < 12)
				image = oneal_left3;
			else if (oneal.animation[1] >= 0 && oneal.animation[1] % 12 < 4)
				image = oneal_right2;
			else if (oneal.animation[1] >= 0 && oneal.animation[1] % 12 < 8)
				image = oneal_right3;
			else if (oneal.animation[1] >= 0 && oneal.animation[1] % 12 < 12)
				image = oneal_right1;
			else if (oneal.animation[2] >= 0 && oneal.animation[2] % 12 < 4)
				image = oneal_left1;
			else if (oneal.animation[2] >= 0 && oneal.animation[2] % 12 < 8)
				image = oneal_left2;
			else if (oneal.animation[2] >= 0 && oneal.animation[2] % 12 < 12)
				image = oneal_left3;
			else if (oneal.animation[3] >= 0 && oneal.animation[3] % 12 < 4)
				image = oneal_right1;
			else if (oneal.animation[3] >= 0 && oneal.animation[3] % 12 < 8)
				image = oneal_right2;
			else
				image = oneal_right3;
			g2.drawImage(image, oneal.loc_x, oneal.loc_y, 40, 40, null);
		}
	}
}
