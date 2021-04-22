package unl.cse;

import java.util.ArrayList;
import java.util.List;

public class Pattern {
	
	public static List<String> _sequence = new ArrayList<>();
	
	
	public static int patternLength(List<String> g) {
		int patternLength = 0;
		for (int i = 0; i < g.size(); i++) {
			for (int j = i +1; j < g.size(); j++) {
				if (g.get(i).equals(g.get(j))) {
					patternLength = j - i;
					break;
				}
			}
		}
		return patternLength;
	}
	
	
	
	

}
