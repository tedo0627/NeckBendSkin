package tedo.skin.main.direction;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Left {

	public static void putInLeft(BufferedImage image, BufferedImage write) {
		BufferedImage portion = new BufferedImage(8, 8, image.getType());
		for (int y = 0; y < 8; y++) {
			for (int x = 8; x < 16; x++) {
				portion.setRGB(x - 8, y, image.getRGB(x, y));
			}
		}

		BufferedImage out = new BufferedImage(8, 8, image.getType());
		AffineTransform at = new AffineTransform();
		at.setToRotation(Math.toRadians(-90), 4, 4);
		at.translate(0, 0);
		out.createGraphics().drawImage(portion, at, null);

		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				write.setRGB(x, y + 8, out.getRGB(x, y));
			}
		}
	}
	public static void putOutLeft(BufferedImage image, BufferedImage write) {
		BufferedImage portion = new BufferedImage(8, 8, image.getType());
		for (int y = 0; y < 8; y++) {
			for (int x = 40; x < 48; x++) {
				portion.setRGB(x - 40, y, image.getRGB(x, y));
			}
		}

		BufferedImage out = new BufferedImage(8, 8, image.getType());
		AffineTransform at = new AffineTransform();
		at.setToRotation(Math.toRadians(-90), 4, 4);
		at.translate(0, 0);
		out.createGraphics().drawImage(portion, at, null);

		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				write.setRGB(x + 32, y + 8, out.getRGB(x, y));
			}
		}
	}
}
