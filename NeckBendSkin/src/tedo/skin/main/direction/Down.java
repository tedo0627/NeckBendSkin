package tedo.skin.main.direction;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Down {

	public static void putInDown(BufferedImage image, BufferedImage write) {
		BufferedImage portion = new BufferedImage(8, 8, image.getType());
		for (int y = 8; y < 16; y++) {
			for (int x = 0; x < 8; x++) {
				portion.setRGB(x, y - 8, image.getRGB(x, y));
			}
		}

		BufferedImage out = new BufferedImage(8, 8, image.getType());
		AffineTransform at = new AffineTransform();
		at.setToRotation(Math.toRadians(-270), 4, 4);
		at.translate(0, 0);
		out.createGraphics().drawImage(portion, at, null);

		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				write.setRGB(x + 16, y, out.getRGB(7 - x, y));
			}
		}
	}

	public static void putOutDown(BufferedImage image, BufferedImage write) {
		BufferedImage portion = new BufferedImage(8, 8, image.getType());
		for (int y = 8; y < 16; y++) {
			for (int x = 32; x < 40; x++) {
				portion.setRGB(x - 32, y - 8, image.getRGB(x, y));
			}
		}

		BufferedImage out = new BufferedImage(8, 8, image.getType());
		AffineTransform at = new AffineTransform();
		at.setToRotation(Math.toRadians(-270), 4, 4);
		at.translate(0, 0);
		out.createGraphics().drawImage(portion, at, null);

		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				write.setRGB(x + 48, y, out.getRGB(7 - x, y));
			}
		}
	}
}
