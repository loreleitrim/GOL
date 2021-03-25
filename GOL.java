package unl.cse;

import java.util.ArrayList;
import java.util.Random;

public class GOL {

	private ArrayList<String> _cells = new ArrayList<String>();
	private ArrayList<ArrayList<String>> _ringCells = new ArrayList<ArrayList<String>>();

	public GOL(int n, Integer x) {
		Random random = new Random();
		int select = 0;
		String cell = "O ";

		int place1 = n / 2;
		int place2 = n / 2;

		if (x == null) {
			for (int i = 0; i < n; i++) {
				select = random.nextInt(cell.length());
				_cells.add(i, String.valueOf(cell.charAt(select)));
			}
			_ringCells.add(0, _cells);

		} else if (n % 2 == 0) {
			for (int i = 0; i < (n / 4) + 1; i++) {
				for (int k = 0; k < n; k++) {
					_cells.add(k, " ");
				}

				// top half of ring

				if (i == 0) {
					select = random.nextInt(cell.length());
					_cells.set(place1, String.valueOf(cell.charAt(select)));
					place1--;
					place2++;
					_ringCells.add(i, _cells);
				} else {
					select = random.nextInt(cell.length());
					_cells.set(place2, String.valueOf(cell.charAt(select)));
					select = random.nextInt(cell.length());
					_cells.set(place1, String.valueOf(cell.charAt(select)));
					place1--;
					place2++;
					_ringCells.add(i, _cells);
				}
			}

			// bottom half of ring
			if (n % 4 == 0) {
				for (int i = (n / 4) + 1; i < (n / 2); i++) {
					place1 += 2;
					place2 -= 2;
					for (int k = 0; k < n; k++) {
						_cells.add(k, " ");
					}
					select = random.nextInt(cell.length());
					_cells.set(place2, String.valueOf(cell.charAt(select)));
					select = random.nextInt(cell.length());
					_cells.set(place1, String.valueOf(cell.charAt(select)));
					_ringCells.add(i, _cells);
					place1++;
					place2--;
				}
			} else {
				place1++;
				place2--;
				for (int i = n / 4; i < (n / 2) - 1; i++) {
					for (int k = 0; k < n; k++) {
						_cells.add(k, " ");
					}
					select = random.nextInt(cell.length());
					_cells.set(place2, String.valueOf(cell.charAt(select)));
					select = random.nextInt(cell.length());
					_cells.set(place1, String.valueOf(cell.charAt(select)));
					place1++;
					place2--;
					_ringCells.add(i, _cells);
				}
			}
			// last cell
			for (int k = 0; k < n; k++) {
				_cells.add(k, " ");
			}
			select = random.nextInt(cell.length());
			_cells.set(place1, String.valueOf(cell.charAt(select)));
			_ringCells.add((n / 2), _cells);
		} else {
			throw new IllegalArgumentException("Enter an even value\n");
		}
	}

	public GOL(String s, Integer x) {
		int n = s.length();
		int count = 0;
		int place1 = n / 2;
		int place2 = n / 2;

		if (x == null) {
			for (int i = 0; i < s.length(); i++) {
				_cells.add(i, s.substring(i, i + 1));
			}
			_ringCells.add(0, _cells);
		} else if (n % 2 == 0) {

			// top half of ring
			for (int i = 0; i < (n / 4) + 1; i++) {
				for (int k = 0; k < n; k++) {
					_cells.add(k, " ");
				}
				if (i == 0) {
					_cells.set(place1, s.substring(count, count + 1));
					place1--;
					place2++;
					count++;
					_ringCells.add(i, _cells);
				} else {
					_cells.set(place2, s.substring(count, count + 1));
					count++;
					_cells.set(place1, s.substring(count, count + 1));
					place1--;
					place2++;
					count++;
					_ringCells.add(i, _cells);
				}

			}

			if (n % 4 == 0) {
				// bottom half of ring
				for (int i = (n / 4) + 1; i < (n / 2); i++) {
					place1 += 2;
					place2 -= 2;
					for (int k = 0; k < n; k++) {
						_cells.add(k, " ");
					}
					_cells.set(place2, s.substring(count, count + 1));
					count++;
					_cells.set(place1, s.substring(count, count + 1));
					_ringCells.add(i, _cells);
					count++;
					place1++;
					place2--;
				}

			}

			else {

				// bottom half of ring
				place1++;
				place2--;
				for (int i = n / 4; i < (n / 2) - 1; i++) {
					for (int k = 0; k < n; k++) {
						_cells.add(k, " ");
					}
					_cells.set(place2, s.substring(count, count + 1));
					count++;
					_cells.set(place1, s.substring(count, count + 1));
					count++;
					place1++;
					place2--;
					_ringCells.add(i, _cells);
				}
			}

			// last cell
			for (int k = 0; k < n; k++) {
				_cells.add(k, " ");
			}
			_cells.set(place1, s.substring(s.length() - 1));
			_ringCells.add((n / 2), _cells);

		} else {
			throw new IllegalArgumentException("Enter an even value\n");

		}

	}

	public String toString() {
		String a = "";

		for (ArrayList<String> cells : _ringCells) {
			String b = "";
			for (String cell : cells) {
				b += cell;
			}
			a += b + "\n";
		}

		return a;
	}

	public GOL next() {
		ArrayList<String> B = new ArrayList<String>();
		ArrayList<ArrayList<String>> bRingCells = new ArrayList<ArrayList<String>>();
		int neighborCount = 0;
		int place1 = 0;
		int place2 = 0;
		// this is for when it's in a line
		if (_ringCells.size() == 1) {
			for (int i = 0; i < _cells.size(); i++) {
				if (i == 0) {
					if (_cells.get(i + 1).equals("O")) {
						neighborCount++;
					}

				} else if (i == _cells.size() - 1) {
					if (_cells.get(i - 1).equals("O")) {
						neighborCount++;
					}
				} else {
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
		}
		// this is for the ring
		else {
			int n = _ringCells.get(0).size();
			place1 = n / 2;
			place2 = n / 2;
			
			if (n % 4 == 0) {
				// check top half on left side
				for (int i = 0; i < (_ringCells.size() / 4)-1; i++) {
					//checks first cell
					if (i == 0) {

						if (_ringCells.get(i + 1).get(place1-1).equals("O")) {
							neighborCount++;
						}
						if (_ringCells.get(i + 1).get(place1+1).equals("O")) {
							neighborCount++;
						}
					} else {
						place2 -= 2;

						if (_ringCells.get(i - 1).get(place1).equals("O")) {
							neighborCount++;
							
						}if (_ringCells.get(i + 1).get(place2).equals("O")) {
							neighborCount++;
						}
					}
					for (int k = 0; k < n; k++) {
						B.add(k, " ");
					}
					if (neighborCount == 1) {
						B.set(place1, "O");
						bRingCells.add(i, B);
					}
					place1--;
					place2--;
				}
				//checks top half on right side
				place1 = n/2;
				place2 = n/2;
				place2+=2;
				for (int i = 1; i < (_ringCells.size() / 4); i++) {
					//checks outermost right cell
					if (i == _ringCells.size()/4 -1) {
						if (_ringCells.get(i-1).get(n-2).equals("O")) {
							neighborCount++;
						}
						if(_ringCells.get(i+1).get(n-2).equals("O")) {
							neighborCount++;
						}
					}
					if(_ringCells.get(i -1).get(place1).equals("O")) {
						neighborCount++;
					}
					if(_ringCells.get(i+1).get(place2).equals("O")) {
						neighborCount++;
					}
					for (int k = 0; k < n; k++) {
						B.set(k, " ");
					}
					if (neighborCount == 1) {
						B.set(place1, "O");
					}						
					bRingCells.add(i, B);
					place1++;
					place2++;
				}
				//checks bottom half on left side
				place1= 1;
				place2 = 2;
				for (int i = (_ringCells.size()/4) -1; i < _ringCells.size()-1; i++) {
					//checks the outermost left cell
					if (i == (_ringCells.size()/4)-1) {
						if (_ringCells.get(i-1).get(place1).equals("O")) {
							neighborCount++;
						}
						if (_ringCells.get(i+1).get(place1).equals("O")) {
							neighborCount++;
						}
						place1--;
					}
					else {
						if (_ringCells.get(i-1).get(place1).equals("O")) {
							neighborCount++;
						}
						if(_ringCells.get(i+1).get(place2).equals("O")) {
							neighborCount++;
						}
						for (int k = 0; k < n; k++) {
							B.set(k, " ");
						}
						if (neighborCount == 1) {
							B.set(place1 + 1, "O");
						}
						bRingCells.add(i, B);
						place1++;
						place2++;
						
					}
				}
				
				//checks bottom half on right side
				place1 = n +1;
				place2 = n -1;
				for (int i = (_ringCells.size()/4); i < _ringCells.size(); i++) {
					//checks last cell
					if (i == _ringCells.size()-1) {
						if (_ringCells.get(i-1).get(n/2+1).equals("O")) {
							neighborCount++;
						}
						if (_ringCells.get(i-1).get(n/2-1).equals("O")) {
							neighborCount++;
						}
					}
					else {
						if (_ringCells.get(i-1).get(place1).equals("O")) {
							neighborCount++;
						}
						if (_ringCells.get(i+1).get(place2).equals("O")) {
							neighborCount++;
						}
						for (int k = 0; k < n; k++) {
							B.set(k, " ");
						}
						if (neighborCount == 1) {
							B.set(place1 + 1, "O");
						}
						bRingCells.add(i, B);
						place1--;
						place2--;
					}
				}
			}
		}

		return null;
	}

	public static void main(String args[]) {
		GOL g = new GOL(8, null);
		System.out.println("Test");
		System.out.print("" + g.toString());
		g.next();
		System.out.println("" + g.toString());
		GOL x = new GOL("OOOOOO", null);
		System.out.print("" + x.toString());
		x.next();
		System.out.println("" + x.toString());
		GOL y = new GOL("OOOOOO", 1);
		System.out.println("" + y.toString());

	}
}

