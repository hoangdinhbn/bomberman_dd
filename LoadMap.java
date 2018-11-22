package Framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LoadMap {
	public int lever, row, column;
	public int[][] map = new int[100][100];

	public LoadMap() {
		try {
			File file = new File("Target/Map/map_lever1");
			if (!file.exists())
				System.out.println("File not found");
			FileReader fr = new FileReader(file);
			Scanner sc = new Scanner(file);
			lever = sc.nextInt();
			row = sc.nextInt();
			column = sc.nextInt();
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					try {
						map[i][j] = fr.read();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (map[i][j] < ' ' || map[i][j] > 'z' || map[0][0] != '#')
						j--;

				}
			}
		} catch (FileNotFoundException e) {
		}
	}
}
