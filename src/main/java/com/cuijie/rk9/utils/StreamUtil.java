package com.cuijie.rk9.utils;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class StreamUtil {

		/**
		 * 
		 * @Title: closeAll 
		 * @Description: 批量关闭流，参数能传无限个,
		 * 例如传入FileInputStream对象、JDBC中Connection对象
		 * 都可以关闭。
		 * @param closeables
		 * @return: void
		 */
	public static void closeAll(Closeable... closeables) {
		
		//TODO
		if(closeables!=null) {
			for (Closeable closeable : closeables) {
				try {
					closeable.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		
		}
	/**
	 * 
	 * @Title: copy 
	 * @Description: 拷贝流，将InputStream流拷到OutputStream，可以用于快速读与文件、上传下载，为了提高性能，需要使用缓冲。
	 * @param src
	 * @param out
	 * @param isCloseInputStream
	 * @param isCloseOutputStream
	 * @throws IOException
	 * @return: void
	 */
	
	public static void copy(InputStream src, OutputStream out, boolean isCloseInputStream, boolean isCloseOutputStream)  throws IOException{
		//TODO
		
		byte[] b=new byte[1024];
		int i=0;
		while((i=src.read(b))!=-1) {
			out.write(b, 0, b.length);
		}
		if(isCloseInputStream=true) {
			src.close();
		}else {
			
		}
		if(isCloseOutputStream=true) {
			out.close();
		}else {
			
		}
		
		
		
		
		}
	
	/**
	 * 
	 * @Title: readTextFile 
	 * @Description: 传入一个文本文件对象，默认为UTF-8编码，返回该文件内容，
	 * 要求方法内部调用上面第2个方法拷贝流，结束后第1个方法关闭流
	 * @param src
	 * @return
	 * @throws IOException
	 * @return: String
	 */
	public static String readTextFile(InputStream src) throws IOException{
		//TODO
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] b=new byte[1024];
		int i=0;
		while((i=src.read(b))!=-1) {
			outputStream.write(b);
		}
		closeAll(src,outputStream);
		return outputStream.toString("UTF-8");
		}
	/**
	 * 
	 * @Title: readTextFile 
	 * @Description: 传入文本文件对象，返回该文件内容(3分)，
	 * 并且要求内部调用上面第3个方法
	 * @param txtFile
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @return: String
	 */
	public static String readTextFile(File txtFile) throws FileNotFoundException, IOException{
		//TODO
		 return readTextFile(new FileInputStream(txtFile));
		
		}
	/**
	 * 
	 * @Title: readStringFromSystemIn 
	 * @Description: 用于控制台提示。例如“请输出您的姓名：”，
	 * 然后用户输入姓名后回车，* 方法开始执行并读取姓名。
	 * @param message
	 * @return
	 * @return: String
	 */
	public static String readStringFromSystemIn(String message){
		
	Scanner sc=	new Scanner(System.in);
	System.out.println(message);
	String next = sc.next();
	message+=next;
		
		return message.substring(message.indexOf(":")+1);
		
		}
	/**
	 * 
	 * @Title: readIntFromSystemIn 
	 * @Description: 参数message：用于控制台提示。例如“请输出您的年龄：”，然后用户输入年龄后回车，
	 * * 方法开始执行并读取年龄，如何用户输出的不是数字，或是空值（直接回车），则继续提示输入
	 * @param message
	 * @return
	 * @return: int
	 */
	public static int readIntFromSystemIn(String message){
		//TODO
		Scanner sc=	new Scanner(System.in);
		
		System.out.println(message);
		int nextInt = sc.nextInt();
		
		message+=nextInt;
		String string = message.substring(message.indexOf(":"));
		
		String reg="/^[0-9]+/";
		if(string!=null&& reg.matches(string)) {
			return Integer.valueOf(string);
		}else {
			readIntFromSystemIn(message);
		}
		return 0;
	

		}
	
	
	
	
}
