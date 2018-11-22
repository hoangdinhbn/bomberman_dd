package Object_to_Object;

import Object.Bomber;

public class Bomber_to_Item {
	
	public void to_Item(Bomber bomber, int [][] map) {
		player_toBomb(bomber, map);
		player_toFlame(bomber, map);
		player_toSpeed(bomber, map);
		player_toPortal(bomber, map);
	}
	public void player_toBomb(Bomber bomber, int [][] map) {
		int x_left =(int) Math.floor( bomber.loc_x/40.0); // floor tron xuong
		int x_right = (int) Math.ceil( bomber.loc_x/40.0);	//  celi tron len
		int y_up = (int) Math.floor( bomber.loc_y/40.0);
		int y_down = (int) Math.ceil( bomber.loc_y/40.0);
		if((bomber.UP == true || bomber.RIGHT == true) && map[y_up][x_right] == 'b') {
			map[y_up][x_right] = ' ';
			for(int i=0;i < bomber.item.bombItems.size();i++) {
				if(bomber.item.bombItems.get(i).loc_x == x_right*40 && bomber.item.bombItems.get(i).loc_y == y_up*40 ) {
					bomber.item.bombItems.remove(i);
					if(bomber.number_of_bombs<3)
						bomber.number_of_bombs ++;
					break;
				}
			}
		}
		else if((bomber.DOWN == true || bomber.LEFT == true) && map[y_down][x_left] == 'b') {
			map[y_down][x_left] = ' ';
			for(int i=0;i < bomber.item.bombItems.size();i++) {
				if(bomber.item.bombItems.get(i).loc_x == x_left*40 && bomber.item.bombItems.get(i).loc_y == y_down*40 ) {
					bomber.item.bombItems.remove(i);
					if(bomber.number_of_bombs<3)
						bomber.number_of_bombs ++;
					break;
				}
			}
		}
	}
	
	
	public void player_toFlame(Bomber bomber, int [][] map) {
		int x_left =(int) Math.floor( bomber.loc_x/40.0); // floor tron xuong
		int x_right = (int) Math.ceil( bomber.loc_x/40.0);	//  celi tron len
		int y_up = (int) Math.floor( bomber.loc_y/40.0);
		int y_down = (int) Math.ceil( bomber.loc_y/40.0);
		if((bomber.UP == true || bomber.RIGHT == true)   && map[y_up][x_right] == 'f') {
			map[y_up][x_right] = ' ';
			for(int i=0;i < bomber.item.flameItems.size();i++) {
				if(bomber.item.flameItems.get(i).loc_x == x_right*40 && bomber.item.flameItems.get(i).loc_y == y_up*40 ) {
					bomber.item.flameItems.remove(i);
					if(bomber.superFlame<3)
						bomber.superFlame ++;
					break;
				}
			}
		}
		else if((bomber.DOWN == true || bomber.LEFT == true) && map[y_down][x_left] == 'f') {
			map[y_down][x_left] = ' ';
			for(int i=0;i < bomber.item.flameItems.size();i++) {
				if(bomber.item.flameItems.get(i).loc_x == x_left*40 && bomber.item.flameItems.get(i).loc_y == y_down*40 ) {
					bomber.item.flameItems.remove(i);
					if(bomber.superFlame<3)
						bomber.superFlame ++;
					break;
				}
			}
		}
	}
	
	public void player_toSpeed(Bomber bomber, int [][] map) {
		int x_left =(int) Math.floor( bomber.loc_x/40.0); // floor tron xuong
		int x_right = (int) Math.ceil( bomber.loc_x/40.0);	//  celi tron len
		int y_up = (int) Math.floor( bomber.loc_y/40.0);
		int y_down = (int) Math.ceil( bomber.loc_y/40.0);
		if((bomber.UP == true || bomber.RIGHT == true) && map[y_up][x_right] == 's' ) {
			map[y_up][x_right] = ' ';
			for(int i=0;i < bomber.item.speedItems.size();i++) {
				if(bomber.item.speedItems.get(i).loc_x == x_right*40 && bomber.item.speedItems.get(i).loc_y == y_up*40 ) {
					bomber.item.speedItems.remove(i);
					if(bomber.speed<9)
						bomber.speed +=2;
					break;
				}
			}
		}
		else if((bomber.DOWN == true || bomber.LEFT == true) && map[y_down][x_left] == 's') {
			map[y_down][x_left] = ' ';
			for(int i=0;i < bomber.item.speedItems.size();i++) {
				if(bomber.item.speedItems.get(i).loc_x == x_left*40 && bomber.item.speedItems.get(i).loc_y == y_down*40 ) {
					bomber.item.speedItems.remove(i);
					if(bomber.speed<9)
						bomber.speed +=2;
					break;
				}
			}
		}
	}
	
	public void player_toPortal(Bomber bomber, int [][] map) {
		int x_left =(int) Math.floor( bomber.loc_x/40.0); // floor tron xuong
		int x_right = (int) Math.ceil( bomber.loc_x/40.0);	//  celi tron len
		int y_up = (int) Math.floor( bomber.loc_y/40.0);
		int y_down = (int) Math.ceil( bomber.loc_y/40.0);
		if((bomber.UP == true || bomber.RIGHT == true) && map[y_up][x_right] == 'x' ) {
			for(int i=0;i < bomber.item.portals.size();i++) {
				if(bomber.item.portals.get(i).loc_x == x_right*40 && bomber.item.portals.get(i).loc_y == y_up*40 ) {
					bomber.WIN = true;
					break;
				}
			}
		}
		else if((bomber.DOWN == true || bomber.LEFT == true) && map[y_down][x_left] == 'x') {
			for(int i=0;i < bomber.item.portals.size();i++) {
				if(bomber.item.portals.get(i).loc_x == x_left*40 && bomber.item.portals.get(i).loc_y == y_down*40 ) {
					bomber.WIN = true;
					break;
				}
			}
		}
	}
}
