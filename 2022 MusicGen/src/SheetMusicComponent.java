
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import javax.swing.JComponent;

public class SheetMusicComponent extends JComponent {
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		try {
			randomize("C", "major", g2);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	} // paintComponent

	public static void randomize(String tonic, String mode, Graphics g) throws NoSuchAlgorithmException {
		Random rand = SecureRandom.getInstanceStrong();
		Graphics2D g2 = (Graphics2D) g;
		boolean flat;
		int noteValue = 0;
		int[] a = Pitch.makePitch(tonic, mode);

		for (int i = 0; i < a.length; i++) {
			flat = false;
			noteValue = a[rand.nextInt(a.length)];
			if (noteValue >= 10) {
				noteValue = noteValue - 100;
				flat = true;
			}
			SheetMusic music = new SheetMusic(noteValue, i / 2, i, flat);
			music.drawOn(g2);
		}
	}

} // SheetMusicComponent
