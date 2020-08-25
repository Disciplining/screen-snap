package com.lyx;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Test
{
	public static void captureScreen(String fileName) throws Exception
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		robot.mouseMove(12, 14);
		ImageIO.write(image, "png", new File(fileName));
	}

	public static void main(String[] args) throws Exception
	{
		String pic = "D:/a.png";
		captureScreen(pic);
		System.out.println(pic);
	}
}