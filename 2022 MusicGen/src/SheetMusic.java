import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class SheetMusic {
	private int note;
	private int duration;
	private int cornerX;
	private int cornerY;
	private int noteWidth;
	private int noteHeight;
	private int noteCount;
	private boolean flat;

	public SheetMusic(int noteValue, int duration, int noteCount, boolean flat) {
		this.note = noteValue;
		this.noteCount = noteCount;
		this.cornerX = 150 + (80 * noteCount);
		this.cornerY = 130 - (10 * note);
		this.noteWidth = 30;
		this.noteHeight = 20;
		this.flat = flat;
		this.duration = duration;
	}

	private void drawNote(Graphics2D g2) {
		if (duration < 400) {
			if (cornerY < 130) {
				g2.drawLine(cornerX, cornerY + (noteHeight / 2), cornerX, cornerY + 80);
			} else {
				g2.drawLine(cornerX + noteWidth, cornerY + (noteHeight / 2), cornerX + noteWidth, cornerY - 80);
			}
		}
		if (duration < 200) {
			g2.fillOval(cornerX, cornerY, noteWidth, noteHeight);
		} else {
			g2.drawOval(cornerX, cornerY, noteWidth, noteHeight);
		}

	}

	private void drawFlat(Graphics2D g2) {
		g2.drawLine(cornerX - 30, cornerY + noteHeight, cornerX - 30, cornerY - 30);
		g2.drawArc(cornerX - 30, cornerY, 20, 20, 0, 180);
		g2.drawLine(cornerX - 10, cornerY + (noteHeight / 2), cornerX - 30, cornerY + noteHeight);
	}

	private void drawLedgerLines(Graphics2D g2) {
		int n = cornerY;
		int i = 0;
		while (n < 80 || n > 180) {
			if (n > 180) {
				if (n / 10 % 2 == 0) {
					g2.drawLine(cornerX - 5, cornerY - (i * 20), cornerX + noteWidth + 5, cornerY - (i * 20));
				} else {
					g2.drawLine(cornerX - 5, cornerY + 10 - (i * 20), cornerX + noteWidth + 5, cornerY + 10 - (i * 20));
				}
				n -= 20;
			} else {
				if (n / 10 % 2 != 0) {
					g2.drawLine(cornerX - 5, cornerY + 10 + (i * 20), cornerX + noteWidth + 5, cornerY + 10 + (i * 20));
				} else {
					g2.drawLine(cornerX - 5, cornerY + 20 + (i * 20), cornerX + noteWidth + 5, cornerY + 20 + (i * 20));
				}
				n += 20;
			}
			i++;
		}
	}

	private void drawBar(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.drawLine(20, 100, 960, 100);
		g2.drawLine(20, 120, 960, 120);
		g2.drawLine(20, 140, 960, 140);
		g2.drawLine(20, 160, 960, 160);
		g2.drawLine(20, 180, 960, 180);
		g2.drawLine(20, 100, 20, 180);
		g2.drawLine(960, 100, 960, 180);
		g2.drawLine(940, 100, 940, 180);
	} // drawBird

	public void drawOn(Graphics2D g2) {
		drawBar(g2);
		drawNote(g2);
		drawLedgerLines(g2);
		if (flat) {
			drawFlat(g2);
		}
	} // drawOn

}