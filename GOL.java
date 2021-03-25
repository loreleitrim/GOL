
package unl.cse;

import java.util.ArrayList;
import java.util.Random;

public class GOL {

private ArrayList<String> _cells = new ArrayList<String>();

       public GOL (String s) {
              for (int i = 0; i < s.length(); i++) {
                     _cells.add(i, s.substring(i, i+1));
                     }
              }
        
      public GOL (int n) {
              for (int i = 0; i < n; i++) {
                     String cell = "O ";
                     Random random = new Random();
                     int select = random.nextInt(cell.length());
                     _cells.add(i, String.valueOf(cell.charAt(select)));
              }
       }
   
    public String toString() {
              String a = "";
              for (String cell : _cells) {
                     a = a + cell;
              }
              return a;
       }
   
    public GOL next() {
              ArrayList<String> B = new ArrayList<String>();
              for (int i = 0; i < _cells.size(); i++) {
                     int neighborCount = 0;
                     if (i == 0) {
                            if (_cells.get(i+1).equals("O")) {
                                   neighborCount++;
                            }
                     }
                     else if (i == _cells.size() - 1) {
                            if (_cells.get(i-1).equals("O")) {
                                   neighborCount++;
                            }
                     }
                     else {
                            if (_cells.get(i+1).equals("O")) {
                                   neighborCount++;
                            }
                            if (_cells.get(i-1).equals("O")) {
                                   neighborCount++;
                            }
                     }
                     if (neighborCount == 0 || neighborCount == 2) {
                            B.add(i, " ");
                     }
                     else {
                            B.add(i, "O");
                     }
              }
              for (int i = 0; i < B.size(); i++) {
                     _cells.set(i, B.get(i));
              }
              return null;
       }

       public static void main (String args[]) {
              GOL x = new GOL("OOO O O O OOO   O   O");
              int t = 0;
              do {
                     System.out.println("" + x.toString());
                     x.next();
                     t++;
              }while (t < 10);
       }
}
