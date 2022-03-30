import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Rhythm {
	public static ArrayList<Integer> makeRhythm(int topHalf, int bottomHalf, int isShort) {
		
		ArrayList<Integer> possibleR = new ArrayList<Integer>();
		for (int i = 0; i < topHalf*4; i++) {
			possibleR.add(25);
		}
		for (int i = 0; i < possibleR.size(); i++) {
			int current = possibleR.get(i);
			int last = possibleR.get(possibleR.size()-1);
			if (current == last) {
				
			}
			Random rand = new Random();
			if (rand.nextInt(5) != 1) {
				
				possibleR.add(i, (possibleR.get(i) + last));
				possibleR.remove(i+1);
				possibleR.remove(last);
				
			}
		}
		return possibleR;
	}
}
