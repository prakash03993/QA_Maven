package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.junit.Assert;

public class FileReaderManager {
	private static FileInputStream fileInputStream;
	private static Properties property;

	private static void setupProperty() {
		File file = new File(
				"C:\\Users\\user\\eclipse-workspace\\NaukriProject\\src\\main\\resources\\TestDate.Properties");

		try {
			fileInputStream = new FileInputStream(file);
			property = new Properties();
			property.load(fileInputStream);

		} catch (FileNotFoundException e) {
			Assert.fail("error occurs during file loading");
		} catch (Exception e) {
			Assert.fail("Error occurs during file reading");
		}
	}

	public static String getDataProperty(String value) {
		setupProperty();
		String data = property.getProperty(value);
		return data;
	}
	public static void main(String[] args) {

		System.out.println(getDataProperty("browser"));
	}

}
