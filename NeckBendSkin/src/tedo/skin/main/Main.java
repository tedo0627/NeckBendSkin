package tedo.skin.main;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tedo.skin.main.direction.Back;
import tedo.skin.main.direction.Down;
import tedo.skin.main.direction.Front;
import tedo.skin.main.direction.Left;
import tedo.skin.main.direction.Right;
import tedo.skin.main.direction.Top;

public class Main {

	public static void main(String[] args) {
		showDialog();
		System.exit(0);
	}

	public static void showDialog(){
		FileDialog dialog = new FileDialog((Frame) null, "首を曲げるスキンのファイルを選択してください", FileDialog.LOAD);
		dialog.setFile("*.png");
		dialog.setVisible(true);
		if (dialog.getDirectory() == null) {
			return;
		}

		String filePath = dialog.getDirectory() + dialog.getFile();
		BufferedImage image;
		try {
			image =ImageIO.read(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		int width = image.getWidth();
		int height = image.getHeight();
		BufferedImage write = new BufferedImage(width, height, image.getType());
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				write.setRGB(x, y, image.getRGB(x, y));
			}
		}

		Top.putInTop(image, write);
		Down.putInDown(image, write);
		Front.putInFront(image, write);
		Back.putInBack(image, write);
		Right.putInRight(image, write);
		Left.putInLeft(image, write);

		Top.putOutTop(image, write);
		Down.putOutDown(image, write);
		Front.putOutFront(image, write);
		Back.putOutBack(image, write);
		Right.putOutRight(image, write);
		Left.putOutLeft(image, write);

		dialog = new FileDialog((Frame) null, "保存先を選択してください", FileDialog.SAVE);
		dialog.setFile("*.png");
		dialog.setVisible(true);
		if (dialog.getDirectory() == null) {
			return;
		}

		filePath = dialog.getDirectory() + dialog.getFile();

		try {
			ImageIO.write(write, "png", new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
