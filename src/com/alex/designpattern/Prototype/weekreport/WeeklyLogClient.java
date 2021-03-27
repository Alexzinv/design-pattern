package com.alex.designpattern.Prototype.weekreport;

public class WeeklyLogClient {
	public static void main(String[] args) {
		Attachment attachment = new Attachment("工作报告");
		WeeklyLog weeklyLog = new WeeklyLog();
		weeklyLog.setAttachment(attachment);
		weeklyLog.setName("la");
		weeklyLog.setDate("2021-1-1");
		weeklyLog.setContent("dsafsaf");

		WeeklyLog weeklyLog1 = (WeeklyLog) weeklyLog.clone();
		System.out.println(weeklyLog + "|" + weeklyLog1);

		WeeklyLog weeklyLog2 = weeklyLog.deepClone();
		System.out.println(weeklyLog + "|" + weeklyLog2);
	}
}
