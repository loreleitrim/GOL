package unl.cse;

public class Main {
	
	public static void main (String args[]) {
		GOL p = GOL.makeGOLonRing(" O   ");
		int t = 0;
		do {
			System.out.println("" + p.toString());
			p.next();
			t++;
		} while (t < 10);
	}

}
