package Object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;
import Graphics.ImageList;

public class Balloom {
	public int loc_x;
	public int loc_y;
	public int speed;
	protected boolean isRun = true;
	protected boolean LEFT = false, RIGHT = false, UP = false, DOWN = false;
	protected int chosee = 1;
	public boolean isDie = false;
	protected int[] animation = { -1, -1, -1, -1 }; // left right up down

	public Balloom(int x, int y, int speed) {
		this.loc_x = x;
		this.loc_y = y;
		this.speed = speed;
	}

	public void move(int[][] map) {
		if (LEFT == false && RIGHT == false && UP == false && DOWN == false) {
			Random random = new Random();
			// random.
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

	public boolean isMove(Balloom balloom, int[][] map) {
		int x_left = (int) Math.floor(balloom.loc_x / 40.0);
		int x_right = (int) Math.ceil(balloom.loc_x / 40.0);
		int y_down = (int) Math.floor(balloom.loc_y / 40.0);
		int y_up = (int) Math.ceil(balloom.loc_y / 40.0);
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

	protected BufferedImage balloom_left1 = ImageList.balloom_left1;
	protected BufferedImage balloom_left2 = ImageList.balloom_left2;
	protected BufferedImage balloom_left3 = ImageList.balloom_left3;
	protected BufferedImage balloom_right2 = ImageList.balloom_right2;
	protected BufferedImage balloom_right3 = ImageList.balloom_right3;
	protected BufferedImage balloom_right1 = ImageList.balloom_right1;

	public void draw(Graphics2D g2, Balloom balloom, int[][] map) {
		BufferedImage image;
		if (balloom.isDie == false) {
			move(map);
			if (balloom.animation[0] >= 0 && balloom.animation[0] % 12 < 4)
				image = balloom_left1;
			else if (balloom.animation[0] >= 0 && balloom.animation[0] % 12 < 8)
				image = balloom_left2;
			else if (balloom.animation[0] >= 0 && balloom.animation[0] % 12 < 12)
				image = balloom_left3;
			else if (balloom.animation[1] >= 0 && balloom.animation[1] % 12 < 4)
				image = balloom_right2;
			else if (balloom.animation[1] >= 0 && balloom.animation[1] % 12 < 8)
				image = balloom_right3;
			else if (balloom.animation[1] >= 0 && balloom.animation[1] % 12 < 12)
				image = balloom_right1;
			else if (balloom.animation[2] >= 0 && balloom.animation[2] % 12 < 4)
				image = balloom_left1;
			else if (balloom.animation[2] >= 0 && balloom.animation[2] % 12 < 8)
				image = balloom_left2;
			else if (balloom.animation[2] >= 0 && balloom.animation[2] % 12 < 12)
				image = balloom_left3;
			else if (balloom.animation[3] >= 0 && balloom.animation[3] % 12 < 4)
				image = balloom_right1;
			else if (balloom.animation[3] >= 0 && balloom.animation[3] % 12 < 8)
				image = balloom_right2;
			else
				image = balloom_right3;
			g2.drawImage(image, balloom.loc_x, balloom.loc_y, 40, 40, null);
		}

	}
}
