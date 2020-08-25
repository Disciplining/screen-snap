package com.lyx;

import cn.hutool.cron.CronUtil;

public class Main
{
	public static void main(String[] args)
	{
		CronUtil.start(true);
		CronUtil.setMatchSecond(true);

		while (true)
		{
		}
	}
}