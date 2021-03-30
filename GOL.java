package unl.cse;

import java.util.Random;
import java.util.ArrayList;

public class GOL {

	private static ArrayList<String> _cells = new ArrayList<String>();
	private static Integer _ring;
	private static int _numCells;

	private GOL(String s) {
		for (int i = 0; i < s.length(); i++) {
			_cells.add(i, s.substring(i, i + 1));
		}
	}
	
	public static GOL makeGOLonChain(String s) {
		_ring = null;
		GOL x = new GOL(s);
		return x;
	}
	
	public static GOL makeGOLonRing(String s) {
		_ring = 0;
		GOL x = new GOL(s);
		return x;
	}
	
	private GOL(int n) {
		n = _numCells;
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			String cell = "O ";
			int select = random.nextInt(cell.length());
			_cells.add(i, String.valueOf(cell.charAt(select)));
		}
		
	}

	public static GOL makeGOLonChain(int n) {
		_ring = null;
		_numCells = n;
		GOL x = new GOL(n);
		return x;
	}
	
	public static GOL makeGOLonRing(int n) {
		_ring = 0;
		_numCells = n;
		GOL x = new GOL(n);
		return x;
	}

	public String toString() {
		String a = "";
		if (_ring == null) {
			a += "[";
		}
		else {
			a += "(";
		}
		for (String cell : _cells) {
			a = a + cell;
		}
		if (_ring == null) {
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
				if (_ring != null) {
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
				if (_ring != null) {
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

		
		GOL p = makeGOLonRing("  O   ");
		int t = 0;
		do {
			System.out.println("" + p.toString());
			p.next();
			t++;
		} while (t < 10);
	}
}
