import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class SheetMusicViewer {

	private void driverMain() {
		final String frameTitle = "Music by Carson Batt";
		final int frameWidth = 1000;
		final int frameHeight = 600;
		final int frameXLoc = 100;
		final int frameYLoc = 200;

		JFrame frame = new JFrame();
		frame.setTitle(frameTitle);
		frame.setSize(frameWidth, frameHeight);
		frame.setLocation(frameXLoc, frameYLoc);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JComponent sheetMusicComponent = new SheetMusicComponent();
		frame.add(sheetMusicComponent);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SheetMusicViewer sheetMusicViewer = new SheetMusicViewer();
		sheetMusicViewer.driverMain();
	} // main
}
