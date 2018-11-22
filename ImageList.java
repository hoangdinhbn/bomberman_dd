package Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageList {
	public static BufferedImage 	grass;
	public static BufferedImage 	wall;
	public static BufferedImage 	layer_right_1;
	public static BufferedImage 	balloom_left_1;
	public static BufferedImage 	oneal_left1;
	public static BufferedImage 	powerup_bombs;
	public static BufferedImage 	powerup_flames;
	public static BufferedImage		powerup_speed;
	public static BufferedImage		brick;
	public static BufferedImage		portal;
	public static BufferedImage		player_up;
	public static BufferedImage		player_up_1;
	public static BufferedImage  	player_up_2;
	public static BufferedImage  	player_down;
	public static BufferedImage  	player_down_1;
	public static BufferedImage  	player_down_2;
	public static BufferedImage  	player_left;
	public static BufferedImage  	player_left_1;
	public static BufferedImage  	player_left_2;
	public static BufferedImage  	player_right;
	public static BufferedImage  	player_right_1;
	public static BufferedImage  	player_right_2;
	public static BufferedImage  	balloom_left1;
	public static BufferedImage  	balloom_left2;
	public static BufferedImage  	balloom_left3;
	public static BufferedImage  	balloom_right2;
	public static BufferedImage  	balloom_right3;
	public static BufferedImage  	balloom_right1;
	public static BufferedImage  	oneal_left2;
	public static BufferedImage  	oneal_left3;
	public static BufferedImage  	oneal_right2;
	public static BufferedImage  	oneal_right3;
	public static BufferedImage  	oneal_right1;
	public static BufferedImage  	bomb;
	public static BufferedImage  	bomb_1;
	public static BufferedImage  	bomb_2;
	public static BufferedImage  	bomb_exploded;
	public static BufferedImage  	bomb_exploded1;
	public static BufferedImage  	bomb_exploded2;
	public static BufferedImage  	explosion_horizontal_left_last;
	public static BufferedImage  	explosion_horizontal_left_last1;
	public static BufferedImage  	explosion_horizontal_left_last2;
	public static BufferedImage  	explosion_horizontal_right_last;
	public static BufferedImage  	explosion_horizontal_right_last1;
	public static BufferedImage  	explosion_horizontal_right_last2;
	public static BufferedImage  	explosion_horizontal;
	public static BufferedImage  	explosion_horizontal1;
	public static BufferedImage  	explosion_horizontal2;
	public static BufferedImage  	explosion_vertical;
	public static BufferedImage  	explosion_vertical1;
	public static BufferedImage  	explosion_vertical2;
	public static BufferedImage  	explosion_vertical_top_last;
	public static BufferedImage  	explosion_vertical_top_last1;
	public static BufferedImage  	explosion_vertical_top_last2;
	public static BufferedImage  	explosion_vertical_down_last;
	public static BufferedImage  	explosion_vertical_down_last1;
	public static BufferedImage  	explosion_vertical_down_last2;
	public static BufferedImage  	brick_exploded;
	public static BufferedImage  	brick_exploded1;
	public static BufferedImage  	brick_exploded2;
	public static BufferedImage  	player_dead1;
	public static BufferedImage  	player_dead2;
	public static BufferedImage  	player_dead3;
	public static BufferedImage  	oneal_dead;
	public static BufferedImage  	balloom_dead;
	public static BufferedImage  	game_over;
	public static BufferedImage  	you_win;
//	public static BufferedImage  	;
//	public static BufferedImage  	;
	

	public ImageList() {
		try {
			you_win							= ImageIO.read(new File("Target/icon/you_win.jpg"));
			game_over						= ImageIO.read(new File("Target/icon/game_over.png"));
			balloom_dead					= ImageIO.read(new File("Target/icon/balloom_dead.png"));
			oneal_dead						= ImageIO.read(new File("Target/icon/oneal_dead.png"));
			player_dead1					= ImageIO.read(new File("Target/icon/player_dead1.png"));
			player_dead2					= ImageIO.read(new File("Target/icon/player_dead2.png"));
			player_dead3					= ImageIO.read(new File("Target/icon/player_dead3.png"));
			brick_exploded1					= ImageIO.read(new File("Target/icon/brick_exploded1.png"));
			brick_exploded2					= ImageIO.read(new File("Target/icon/brick_exploded2.png"));
			brick_exploded					= ImageIO.read(new File("Target/icon/brick_exploded.png"));
			explosion_vertical_down_last	= ImageIO.read(new File("Target/icon/explosion_vertical_down_last.png"));
			explosion_vertical_down_last1	= ImageIO.read(new File("Target/icon/explosion_vertical_down_last1.png"));
			explosion_vertical_down_last2	= ImageIO.read(new File("Target/icon/explosion_vertical_down_last2.png"));
			explosion_vertical_top_last		= ImageIO.read(new File("Target/icon/explosion_vertical_top_last.png"));
			explosion_vertical_top_last1	= ImageIO.read(new File("Target/icon/explosion_vertical_top_last1.png"));
			explosion_vertical_top_last2		= ImageIO.read(new File("Target/icon/explosion_vertical_top_last2.png"));
			explosion_vertical 		= ImageIO.read(new File("Target/icon/explosion_vertical.png"));
			explosion_vertical1 		= ImageIO.read(new File("Target/icon/explosion_vertical1.png"));
			explosion_vertical2 		= ImageIO.read(new File("Target/icon/explosion_vertical2.png"));
			explosion_horizontal	= ImageIO.read(new File("Target/icon/explosion_horizontal.png"));
			explosion_horizontal1	= ImageIO.read(new File("Target/icon/explosion_horizontal1.png"));
			explosion_horizontal2	= ImageIO.read(new File("Target/icon/explosion_horizontal2.png"));
			explosion_horizontal_right_last = ImageIO.read(new File("Target/icon/explosion_horizontal_right_last.png"));
			explosion_horizontal_right_last1 = ImageIO.read(new File("Target/icon/explosion_horizontal_right_last1.png"));
			explosion_horizontal_right_last2 = ImageIO.read(new File("Target/icon/explosion_horizontal_right_last2.png"));
			explosion_horizontal_left_last = ImageIO.read(new File("Target/icon/explosion_horizontal_left_last.png"));
			explosion_horizontal_left_last1 = ImageIO.read(new File("Target/icon/explosion_horizontal_left_last1.png"));
			explosion_horizontal_left_last2 = ImageIO.read(new File("Target/icon/explosion_horizontal_left_last2.png"));
			bomb_exploded		= ImageIO.read(new File("Target/icon/bomb_exploded.png"));
			bomb_exploded1		= ImageIO.read(new File("Target/icon/bomb_exploded1.png"));
			bomb_exploded2		= ImageIO.read(new File("Target/icon/bomb_exploded2.png"));
			bomb				= ImageIO.read(new File("Target/icon/bomb.png"));
			bomb_1				= ImageIO.read(new File("Target/icon/bomb_1.png"));
			bomb_2				= ImageIO.read(new File("Target/icon/bomb_2.png"));
			grass 				= ImageIO.read(new File("Target/icon/grass.png"));
		 	wall			 	= ImageIO.read(new File("Target/icon/wall.png"));
		 	brick 				= ImageIO.read(new File("Target/icon/brick.png"));
			portal 				= ImageIO.read(new File("Target/icon/portal.png"));
			layer_right_1 		= ImageIO.read(new File("Target/icon/portal.png"));
			balloom_left_1		= ImageIO.read(new File("Target/icon/balloom_left1.png"));
			powerup_bombs 		= ImageIO.read(new File("Target/icon/powerup_bombs.png"));
			powerup_flames		= ImageIO.read(new File("Target/icon/powerup_flames.png"));
			powerup_speed		= ImageIO.read(new File("Target/icon/powerup_speed.png"));
			player_up			= ImageIO.read(new File("Target/icon/player_up.png"));
			player_up_1			= ImageIO.read(new File("Target/icon/player_up_1.png"));
			player_up_2			 = ImageIO.read(new File("Target/icon/player_up_2.png"));
			player_down			 = ImageIO.read(new File("Target/icon/player_down.png"));
			player_down_1		 = ImageIO.read(new File("Target/icon/player_down_1.png"));
			player_down_2		 = ImageIO.read(new File("Target/icon/player_down_2.png"));
			player_left			 = ImageIO.read(new File("Target/icon/player_left.png"));
			player_left_1		 = ImageIO.read(new File("Target/icon/player_left_1.png"));
			player_left_2		 = ImageIO.read(new File("Target/icon/player_left_2.png"));
			player_right		 = ImageIO.read(new File("Target/icon/player_right.png"));
			player_right_1		 = ImageIO.read(new File("Target/icon/player_right_1.png"));
			player_right_2		 = ImageIO.read(new File("Target/icon/player_right_2.png"));
			balloom_left1		 = ImageIO.read(new File("Target/icon/balloom_left1.png"));
			balloom_left2		 = ImageIO.read(new File("Target/icon/balloom_left2.png"));
			balloom_left3		 = ImageIO.read(new File("Target/icon/balloom_left3.png"));
			balloom_right2 = ImageIO.read(new File("Target/icon/balloom_right2.png"));
			balloom_right3 = ImageIO.read(new File("Target/icon/balloom_right3.png"));
			balloom_right1 = ImageIO.read(new File("Target/icon/balloom_right1.png"));
			oneal_left1 = ImageIO.read(new File("Target/icon/oneal_left1.png"));
			oneal_left2 = ImageIO.read(new File("Target/icon/oneal_left2.png"));
			oneal_left3 = ImageIO.read(new File("Target/icon/oneal_left3.png"));
			oneal_right2 = ImageIO.read(new File("Target/icon/oneal_right2.png"));
			oneal_right3 = ImageIO.read(new File("Target/icon/oneal_right3.png"));
			oneal_right1 = ImageIO.read(new File("Target/icon/oneal_right1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
