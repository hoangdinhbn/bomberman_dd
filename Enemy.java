package Object;

import java.util.ArrayList;

import Framework.LoadMap;

public class Enemy {
	protected int speed = 1;
	protected boolean Running = true;
	protected int loc_x = 40, loc_y = 40;
	LoadMap loadMap = new LoadMap();

	public ArrayList<Balloom> ballooms = new ArrayList<Balloom>();
	public ArrayList<Oneal> oneals = new ArrayList<Oneal>();

	public Enemy() {
		for (int i = 0; i < loadMap.row; i++) {
			for (int j = 0; j < loadMap.column; j++) {
				if (loadMap.map[i][j] == '1') {
					loc_x = j * 40;
					loc_y = i * 40;
					this.ballooms.add(new Balloom(loc_x, loc_y, speed));
				} else if (loadMap.map[i][j] == '2') {
					loc_x = j * 40;
					loc_y = i * 40;
					this.oneals.add(new Oneal(loc_x, loc_y, speed));
				}
			}
		}
	}
}
