package unl.cse;

public class Main {
	
	public static void main (String args[]) {
		GOL p = GOL.makeGOLonRing(5);

		int t = 0;
		do {
			System.out.println("" + p.toString());
			Pattern._sequence.add(p.toString());
			p.next();
			t++;
		} while (t < 15);
		
		int patternLength = Pattern.patternLength(Pattern._sequence);
	
		
    	System.out.println(patternLength);
    	
    	
	}

}
