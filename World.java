package unl.cse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {
	
	public static List<GOL> GOLDensityOnChain(int alive, int dead) {
		Random random = new Random();
		List<GOL> g = new ArrayList<>();
		for (int i = 0; i < 1; i++) {
			String cells = "";
			String newOrder = "";
			for (int j = 0; j < alive; j++) {
				cells += "O";
			}
			for (int j = 0; j < dead; j++) {
				cells += " ";
			}
			
			int size = cells.length();
			for (int j = 0; j < size; j++) {
				int grabCell = random.nextInt(cells.length());
				newOrder+= cells.substring(grabCell, grabCell+1);
				String temp = cells.substring(0, grabCell);
				String temp2 = cells.substring(grabCell+1);
				cells = temp + temp2;
			}
			
			GOL chain = GOL.makeGOLonChain(newOrder);
			g.add(chain);
		}
		return g;
	}
	
	public static List<GOL> GOLDensityOnRing(int alive, int dead) {
		Random random = new Random();
		List<GOL> g = new ArrayList<>();
		for (int i = 0; i < 1; i++) {
			String cells = "";
			String newOrder = "";
			for (int j = 0; j < alive; j++) {
				cells += "O";
			}
			for (int j = 0; j < dead; j++) {
				cells += " ";
			}
			
			int size = cells.length();
			for (int j = 0; j < size; j++) {
				int grabCell = random.nextInt(cells.length());
				newOrder+= cells.substring(grabCell, grabCell+1);
				String temp = cells.substring(0, grabCell);
				String temp2 = cells.substring(grabCell+1);
				cells = temp + temp2;
			}
			
			GOL ring = GOL.makeGOLonRing(newOrder);
			g.add(ring);
		}
		return g;
		
		
	}
	
	public static void main(String args[]) {
		List<GOL> g = GOLDensityOnChain(2, 2);
		for (int i = 0; i < g.size(); i++) {
			int t = 0;
			do {
				System.out.println("" + g.get(i).toString());
				Pattern._sequence.add(g.get(i).toString());
				g.get(i).next();
				t++;
			} while (t < 300);
		}
		int patternLength = Pattern.patternLength(Pattern._sequence);
		System.out.println(patternLength);

		
	}
	
	
	
	

}
