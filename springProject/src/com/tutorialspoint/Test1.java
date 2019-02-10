package com.tutorialspoint;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Test1 {

	private static String directory = "D:\\disk_workspace\\learningSpring\\learningSpring\\springProject\\WebContent\\file";
	private static String copyFile = "C:\\Users\\bny91\\OneDrive\\바탕 화면\\picture\\KakaoTalk_20181225_200926770.jpg";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInputStream input = null;
		FileOutputStream output = null;

		File file = new File(copyFile);

		String year = "";
		String month = "";
		String dir = directory;

		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		year = String.valueOf(cal.get(Calendar.YEAR));
		month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		if (month.length() < 2) {
			month = "0" + month;
		}

		String[] dateArr = { year, month };

		for (int i = 0; i < dateArr.length; i++) {
			dir += File.separator + dateArr[i];
			File newFile = new File(dir);

			while (!newFile.isDirectory()) {
				newFile.mkdir();
			}
		}

		try {
			input = new FileInputStream(file);
			output = new FileOutputStream(dir + File.separator + file.getName());

			int readBuffer = 0;
			byte[] buffer = new byte[512];
			while ((readBuffer = input.read(buffer)) != -1) {
				output.write(buffer, 0, readBuffer);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("파일 복사 완료");

	}

}
