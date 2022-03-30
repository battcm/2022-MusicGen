import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pitch {
	private Pitch() {
		throw new IllegalStateException("Utility class");
	}

	public static int[] pitchEncoder(List<String> scale) {
		int[] a = new int[8];
		for (int i = 0; i < scale.size(); i++) {
			for (int j = 0; j < scale.get(i).length(); j++) {
				char current = scale.get(i).charAt(j);
				if (current == 'A') {
					a[i] = -3;
				} else if (current == 'B') {
					a[i] = -2;
				} else if (current == 'C') {
					a[i] = -1;
				} else if (current == 'D') {
					a[i] = 0;
				} else if (current == 'E') {
					a[i] = 1;
				} else if (current == 'F') {
					a[i] = 2;
				} else if (current == 'G') {
					a[i] = 3;
				} else if (current == 'b')
					a[i] = a[i] + 100;
			}
		}

		return a;
	}

	public static List<String> makeScale(String tonic, String mode) {
		HashMap<Integer, String> notes = new HashMap<>();
		int a = 0;
		for (int i = 0; i < 2; i++) {
			notes.put(a, ("Ab"));
			notes.put(a + 1, ("A"));
			notes.put(a + 2, ("Bb"));
			notes.put(a + 3, ("B"));
			notes.put(a + 4, ("C"));
			notes.put(a + 5, ("Db"));
			notes.put(a + 6, ("D"));
			notes.put(a + 7, ("Eb"));
			notes.put(a + 8, ("E"));
			notes.put(a + 9, ("F"));
			notes.put(a + 10, ("Gb"));
			notes.put(a + 11, ("G"));
			a += 12;
		}
		List<String> scale = new ArrayList<>();
		for (int i = 0; i < notes.size(); i++) {
			if (notes.get(i).equals(tonic)) {
				if (mode.equals("minor")) {
					scale.add(tonic);
					scale.add(notes.get(i + 2));
					scale.add(notes.get(i + 3));
					scale.add(notes.get(i + 5));
					scale.add(notes.get(i + 7));
					scale.add(notes.get(i + 8));
					scale.add(notes.get(i + 10));
					scale.add(notes.get(i + 12));
				} else {
					scale.add(tonic);
					scale.add(notes.get(i + 2));
					scale.add(notes.get(i + 4));
					scale.add(notes.get(i + 5));
					scale.add(notes.get(i + 7));
					scale.add(notes.get(i + 9));
					scale.add(notes.get(i + 11));
					scale.add(notes.get(i + 12));

				}
				break;
			}
		}
		return scale;

	}

	public static int[] makePitch(String tonic, String mode) {
		List<String> scale = makeScale(tonic, mode);
		return pitchEncoder(scale);
	}

}
