package com.cuijie.rk9.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class StreamUtilTest {

	@Test
	public void testCloseAll() throws IOException {
		FileInputStream fileInputStream = new FileInputStream(new File("D:\\1.txt"));
		fileInputStream.read();
		
		StreamUtil.closeAll(fileInputStream);
	}

	@Test
	public void testCopy() throws IOException {
		FileInputStream fileInputStream = new FileInputStream(new File("D:\\1.txt"));
		
		FileOutputStream outputStream = new FileOutputStream(new File("D:\\2.txt"));
		StreamUtil.copy(fileInputStream, outputStream, true, true);
	}

	@Test
	public void testReadTextFileInputStream() throws IOException {
		FileInputStream fileInputStream = new FileInputStream(new File("D:\\1.txt"));

		StreamUtil.readTextFile(fileInputStream);
	}

	@Test
	public void testReadTextFileFile() throws IOException {
		FileInputStream fileInputStream = new FileInputStream(new File("D:\\1.txt"));

		StreamUtil.readTextFile(fileInputStream);
	}

	@Test
	public void testReadStringFromSystemIn() {
		
		String readStringFromSystemIn = StreamUtil.readStringFromSystemIn("请输入您的姓名:");
		System.out.println(readStringFromSystemIn);
	}

	@Test
	public void testReadIntFromSystemIn() {
		String readStringFromSystemIn = StreamUtil.readStringFromSystemIn("请输入您的年龄:");
		System.out.println(readStringFromSystemIn);
		
		
	}

}
