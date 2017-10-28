package tedo.skin.main.direction;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Back {

	public static void putInBack(BufferedImage image, BufferedImage write) {
		BufferedImage portion = new BufferedImage(8, 8, image.getType());
		for (int y = 8; y < 16; y++) {
			for (int x = 24; x < 32; x++) {
				portion.setRGB(x - 24, y - 8, image.getRGB(x, y));
			}
		}

		BufferedImage out = new BufferedImage(8, 8, image.getType());
		AffineTransform at = new AffineTransform();
		at.setToRotation(Math.toRadians(-90), 4, 4);
		at.translate(0, 0);
		out.createGraphics().drawImage(portion, at, null);

		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				write.setRGB(x + 24, y + 8, out.getRGB(x, y));
			}
		}
	}

	public static void putOutBack(BufferedImage image, BufferedImage write) {
		BufferedImage portion = new BufferedImage(8, 8, image.getType());
		for (int y = 8; y < 16; y++) {
			for (int x = 56; x < 64; x++) {
				portion.setRGB(x - 56, y - 8, image.getRGB(x, y));
			}
		}

		BufferedImage out = new BufferedImage(8, 8, image.getType());
		AffineTransform at = new AffineTransform();
		at.setToRotation(Math.toRadians(-90), 4, 4);
		at.translate(0, 0);
		out.createGraphics().drawImage(portion, at, null);

		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				write.setRGB(x + 56, y + 8, out.getRGB(x, y));
			}
		}
	}
}
