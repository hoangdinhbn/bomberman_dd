package Object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Framework.LoadMap;
import Graphics.ImageList;
import Item.Item;
import Object_to_Object.Bomber_to_Enemy;
import Object_to_Object.Bomber_to_Item;

public class Bomber {
	public int loc_x = 0, loc_y = 0;
	public int point = 0;
	public int speed = 5;
	protected int[] animation = { -1, -1, -1, 0 }; // up-down-left-right
	public LoadMap loadMap = new LoadMap();
	public Item item = new Item(this.loadMap);
	public Enemy enemy = new Enemy();
	public ArrayList<Bomb> bombs = new ArrayList<Bomb>();
	public int number_of_bombs = 1;
	public int superFlame = 1;
	public boolean LEFT = false, RIGHT = false, UP = false, DOWN = false;
	public boolean WIN = false;
	public boolean LOSE = false;
	public boolean isBomb = false; // co dang dung tren bomb ko
	public boolean isDie = false;
	public long deadTime;
	Bomber_to_Enemy bomber_to_Enemy = new Bomber_to_Enemy();

	public Bomber() {
		for (int i = 0; i < loadMap.row; i++) {
			for (int j = 0; j < loadMap.column; j++) {
				if (loadMap.map[i][j] == 'p') {
					loc_x = j * 40;
					loc_y = i * 40;
				}
			}
		}
	}

	public void putBoml(Bomber bomber, int[][] map) {
		if (bomber.bombs.size() < bomber.number_of_bombs
				&& bomber.loadMap.map[(int) Math.round(bomber.loc_y / 40.0)][(int) Math
						.round(bomber.loc_x / 40.0)] != 'c') { // day la size luc chua them bomb
			bomber.bombs.add(new Bomb(bomber));
			bomber.isBomb = true;
		}
	}

	public void deleteBoml(Bomber bomber) {
		if (bomber.bombs.size() > 0 && bomber.bombs.get(0).isExploded) { // day la size luc chua them bomb
			bomber.loadMap.map[bomber.bombs.get(0).loc_y / 40][bomber.bombs.get(0).loc_x / 40] = ' ';
			bomber.bombs.remove(0);
		}
	}

	public void move(Bomber bomber, int[][] map) {

		if (bomber.isDie == false) {
			if (LEFT) {
				if (bomber.loc_y % 40 > 32 || bomber.loc_y % 40 > (40 - 2 * speed))
					bomber.loc_y = (bomber.loc_y / 40) * 40 + 40;
				else if (bomber.loc_y % 40 < 2 || bomber.loc_y % 40 < 2 * speed)
					bomber.loc_y = (bomber.loc_y / 40) * 40;
				if (bomber.loc_x % 40 < speed && bomber.loc_x % 40 != 0)
					bomber.loc_x = bomber.loc_x / 40 * 40;
				bomber.loc_x -= bomber.speed; // left
				bomber.animation[0] = -1;
				bomber.animation[1] = -1;
				bomber.animation[2]++;
				bomber.animation[3] = -1;
				if (isMove(bomber) == false)
					bomber.loc_x += bomber.speed;
			} else if (RIGHT) {
				if (bomber.loc_x % 40 > 40 - speed && bomber.loc_x % 40 != 0)
					bomber.loc_x = bomber.loc_x / 40 * 40 + 40;
				bomber.loc_x += bomber.speed; // right
				if (bomber.loc_y % 40 > 32 || bomber.loc_y % 40 > (40 - 2 * speed))
					bomber.loc_y = (bomber.loc_y / 40) * 40 + 40;
				else if (bomber.loc_y % 40 < 2 || bomber.loc_y % 40 < 2 * speed)
					bomber.loc_y = (bomber.loc_y / 40) * 40;
				bomber.animation[0] = -1;
				bomber.animation[1] = -1;
				bomber.animation[2] = -1;
				bomber.animation[3]++;
				if (isMove(bomber) == false)
					bomber.loc_x -= bomber.speed;
			}

			else if (UP) {
				if (bomber.loc_y % 40 < speed && bomber.loc_y % 40 != 0)
					bomber.loc_y = bomber.loc_y / 40 * 40;
				bomber.loc_y -= bomber.speed; // up
				if (bomber.loc_x % 40 > 32 || bomber.loc_x % 40 > (40 - 2 * speed))
					bomber.loc_x = (bomber.loc_x / 40) * 40 + 40;
				else if (bomber.loc_x % 40 < 2 || bomber.loc_x % 40 < 2 * speed)
					bomber.loc_x = (bomber.loc_x / 40) * 40;
				bomber.animation[0]++;
				bomber.animation[1] = -1;
				bomber.animation[2] = -1;
				bomber.animation[3] = -1;
				if (isMove(bomber) == false)
					bomber.loc_y += bomber.speed;
			} else if (DOWN) {
				if (bomber.loc_y % 40 > 40 - speed && bomber.loc_y % 40 != 0)
					bomber.loc_y = bomber.loc_y / 40 * 40 + 40;
				bomber.loc_y += bomber.speed; // down
				if (bomber.loc_x % 40 > 32 || bomber.loc_x % 40 > (40 - 2 * speed))
					bomber.loc_x = (bomber.loc_x / 40) * 40 + 40;
				else if (bomber.loc_x % 40 < 2 || bomber.loc_x % 40 < 2 * speed)
					bomber.loc_x = (bomber.loc_x / 40) * 40;
				bomber.animation[0] = -1;
				bomber.animation[1]++;
				bomber.animation[2] = -1;
				bomber.animation[3] = -1;
				if (isMove(bomber) == false)
					bomber.loc_y -= bomber.speed;
			}
		}
	}

	public void notHit() {
		LEFT = false;
		RIGHT = false;
		UP = false;
		DOWN = false;
	}

	public boolean isMove(Bomber bomber) {
		int[][] map = bomber.loadMap.map;
		int x_left = (int) Math.floor(bomber.loc_x / 40.0);
		int x_right = (int) Math.ceil(bomber.loc_x / 40.0);
		int y_up = (int) Math.floor(bomber.loc_y / 40.0);
		int y_down = (int) Math.ceil(bomber.loc_y / 40.0);
		if (map[y_up][x_right] != 'c' && map[y_down][x_left] != 'c' && map[y_up][x_left] != 'c'
				&& map[y_down][x_right] != 'c') {
			bomber.isBomb = false;
		}
		if (this.enemy.ballooms.size() != 0 || this.enemy.oneals.size() != 0) {
			if (map[y_up][x_right] == '#' || map[y_up][x_right] == '*' || map[y_up][x_right] == 'x')
				return false;
			else if (map[y_up][x_left] == '#' || map[y_up][x_left] == '*' || map[y_up][x_left] == 'x')
				return false;
			else if (map[y_down][x_left] == '#' || map[y_down][x_left] == '*' || map[y_down][x_left] == 'x')
				return false;
			else if (map[y_down][x_right] == '#' || map[y_down][x_right] == '*' || map[y_down][x_right] == 'x')
				return false;

		}
		if (bomber.isBomb == false) {
			if (map[y_up][x_right] == '#' || map[y_up][x_right] == 'c' || map[y_up][x_right] == '*')
				return false;
			else if (map[y_up][x_left] == '#' || map[y_up][x_left] == 'c' || map[y_up][x_left] == '*')
				return false;
			else if (map[y_down][x_left] == '#' || map[y_down][x_left] == 'c' || map[y_down][x_left] == '*')
				return false;
			else if (map[y_down][x_right] == '#' || map[y_down][x_right] == 'c' || map[y_down][x_right] == '*')
				return false;
		} else {
			if (map[y_up][x_right] == '#' || map[y_up][x_right] == '*')
				return false;
			else if (map[y_up][x_left] == '#' || map[y_up][x_left] == '*')
				return false;
			else if (map[y_down][x_left] == '#' || map[y_down][x_left] == '*')
				return false;
			else if (map[y_down][x_right] == '#' || map[y_down][x_right] == '*')
				return false;
		}
		return true;

	}

	public void Bomber_to_Item(Bomber bomber, int[][] map) {
		Bomber_to_Item bomber_to_Item = new Bomber_to_Item();
		bomber_to_Item.to_Item(bomber, map);
	}

	protected BufferedImage player_up = ImageList.player_up;
	protected BufferedImage player_up_1 = ImageList.player_up_1;
	protected BufferedImage player_up_2 = ImageList.player_up_2;
	protected BufferedImage player_down = ImageList.player_down;
	protected BufferedImage player_down_1 = ImageList.player_down_1;
	protected BufferedImage player_down_2 = ImageList.player_down_2;
	protected BufferedImage player_left = ImageList.player_left;
	protected BufferedImage player_left_1 = ImageList.player_left_1;
	protected BufferedImage player_left_2 = ImageList.player_left_2;
	protected BufferedImage player_right = ImageList.player_right;
	protected BufferedImage player_right_1 = ImageList.player_right_1;
	protected BufferedImage player_right_2 = ImageList.player_right_2;
	BufferedImage player_dead1 = ImageList.player_dead1;
	BufferedImage player_dead2 = ImageList.player_dead2;
	BufferedImage player_dead3 = ImageList.player_dead3;

	public void draw(Graphics2D g2, Bomber bomber) {
		BufferedImage image;
		bomber_to_Enemy.isDie(bomber);
		if (bomber.isDie == false) {
			if (bomber.animation[0] >= 0 && bomber.animation[0]%4 < 1)
				image = player_up;
			else if (bomber.animation[0] >= 0 && bomber.animation[0]%4 < 2)
				image = player_up_1;
			else if (bomber.animation[0] >= 0 && bomber.animation[0]%4 < 3)
				image = player_up_2;
			else if (bomber.animation[0] >= 0 && bomber.animation[0]%4 < 4)
				image = player_up_1;
			else if (bomber.animation[1] >= 0 && bomber.animation[1]%4 < 1)
				image = player_down;
			else if (bomber.animation[1] >= 0 && bomber.animation[1]%4 < 2)
				image = player_down_1;
			else if (bomber.animation[1] >= 0 && bomber.animation[1]%4 < 3)
				image = player_down_2;
			else if (bomber.animation[1] >= 0 && bomber.animation[1]%4 < 4)
				image = player_down_1;
			else if (bomber.animation[2] >= 0 && bomber.animation[2]%4 < 1)
				image = player_left;
			else if (bomber.animation[2] >= 0 && bomber.animation[2]%4 < 2)
				image = player_left_1;
			else if (bomber.animation[2] >= 0 && bomber.animation[2]%4 < 3)
				image = player_left_2;
			else if (bomber.animation[2] >= 0 && bomber.animation[2]%4 < 4)
				image = player_left_1;
			else if (bomber.animation[3] >= 0 && bomber.animation[3]%4 < 1)
				image = player_right;
			else if (bomber.animation[3] >= 0 && bomber.animation[3]%4 < 2)
				image = player_right_1;
			else if (bomber.animation[3] >= 0 && bomber.animation[3]%4 < 3)
				image = player_right_2;
			else
				image = player_right_1;
			g2.drawImage(image, bomber.loc_x, bomber.loc_y, 40, 40, null);
			bomber.deadTime = System.currentTimeMillis();
		} else {
			if (System.currentTimeMillis() - bomber.deadTime < 330)
				g2.drawImage(player_dead1, bomber.loc_x, bomber.loc_y, 40, 40, null);
			else if (System.currentTimeMillis() - bomber.deadTime < 660)
				g2.drawImage(player_dead2, bomber.loc_x, bomber.loc_y, 40, 40, null);
			else if (System.currentTimeMillis() - bomber.deadTime < 1000)
				g2.drawImage(player_dead3, bomber.loc_x, bomber.loc_y, 40, 40, null);
			else
				bomber.LOSE = true;
		}
	}

}
