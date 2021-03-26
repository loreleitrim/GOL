package unl.cse;

import java.util.Random;
import java.util.ArrayList;

public class GOL {

	private ArrayList<String> _cells = new ArrayList<String>();
	private Integer ring;

	public GOL(String s, Integer x) {
		for (int i = 0; i < s.length(); i++) {
			_cells.add(i, s.substring(i, i + 1));
		}
		if (x == null) {
			ring = null;
		}
		else {
			ring = 0;
		}
	}

	public GOL(int n, Integer x) {
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			String cell = "O ";
			int select = random.nextInt(cell.length());
			_cells.add(i, String.valueOf(cell.charAt(select)));
		}
		if (x == null) {
			ring = null;
		}
		else {
			ring = 0;
		}
	}

	public String toString() {
		String a = "";
		if (ring == null) {
			a += "[";
		}
		else {
			a += "(";
		}
		for (String cell : _cells) {
			a = a + cell;
		}
		if (ring == null) {
			a += "]";
		}
		else {
			a += ")";
		}
		
		return a;
	}

	public GOL next() {
		ArrayList<String> B = new ArrayList<String>();
		for (int i = 0; i < _cells.size(); i++) {
			int neighborCount = 0;
			//checks first cell
			if (i == 0) {
				if (_cells.get(i + 1).equals("O")) {
					neighborCount++;
				}
				if (ring != null) {
					if (_cells.get(_cells.size()-1).equals("O")) {
						neighborCount++;
					}
				}
			} 
			//checks last cell
			else if (i == _cells.size() - 1) {
				if (_cells.get(i - 1).equals("O")) {
					neighborCount++;
				}
				if (ring != null) {
					if (_cells.get(0).equals("O")) {
						neighborCount++;
					}
				}
			} 
			//middle cells
			else {
				if (_cells.get(i + 1).equals("O")) {
					neighborCount++;
				}
				if (_cells.get(i - 1).equals("O")) {
					neighborCount++;
				}
			}
			if (neighborCount == 0 || neighborCount == 2) {
				B.add(i, " ");
			} else {
				B.add(i, "O");
			}
		}
		for (int i = 0; i < B.size(); i++) {
			_cells.set(i, B.get(i));
		}
		return null;
	}

	public static void main(String args[]) {
//		GOL x = new GOL("OO O ", 1);
//		int t = 0;
//		do {
//			System.out.println("" + x.toString());
//			x.next();
//			t++;
//		} while (t < 10);
		
		GOL p = new GOL(6, 1);
		int t = 0;
		do {
			System.out.println("" + p.toString());
			p.next();
			t++;
		} while (t < 10);
	}
}
