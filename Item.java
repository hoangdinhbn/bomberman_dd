package Item;

import java.util.ArrayList;
import Framework.LoadMap;

public  class Item {
	protected int loc_x;
	protected int loc_y;
	protected boolean Show;
	public ArrayList<BombItem> bombItems = new ArrayList<BombItem>();
	public ArrayList<FlameItem> flameItems = new ArrayList<FlameItem>();
	public ArrayList<SpeedItem> speedItems = new ArrayList<SpeedItem>();
	public ArrayList<Portal> portals = new ArrayList<Portal>();
	
	
	public Item(LoadMap loadMap) {
		for(int i=0;i<loadMap.row;i++) {
			for(int j=0;j<loadMap.column;j++) {
				if(loadMap.map[i][j] == 'b') {
					loc_x = j*40;
					loc_y = i*40;
					this.bombItems.add(new BombItem(loc_x, loc_y));
					loadMap.map[i][j] = '*';
				}
				else if(loadMap.map[i][j] == 'f') {
					loc_x = j*40;
					loc_y = i*40;
					this.flameItems.add(new FlameItem(loc_x, loc_y));
					loadMap.map[i][j] = '*';
				}
				else if(loadMap.map[i][j] == 's') {
					loc_x = j*40;
					loc_y = i*40;
					this.speedItems.add(new SpeedItem(loc_x, loc_y));
					loadMap.map[i][j] = '*';
				}
				else if(loadMap.map[i][j] == 'x') {
					loc_x = j*40;
					loc_y = i*40;
					this.portals.add(new Portal(loc_x, loc_y));
					loadMap.map[i][j] = '*';
				}
			}	
		}			
}
	
	
	
}
