package com.schoolo2o.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	/**
	 * 
	 * MD5 哈希函数(对字符串哈希) 调用方式：String md5String = MD5.md5("password".getBytes())
	 * 
	 * @param plainByte
	 * 
	 * @param num
	 * 
	 * @return
	 */

	public static String md5(byte[] plainByte) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainByte);
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 
	 * MD5 哈希函数(对文件哈希)
	 * 
	 * @param path
	 * 
	 * @return
	 */

	public static StringBuilder fileMd5(String path) {

		StringBuilder sb = new StringBuilder();

		StringBuilder noAlgorithm = new StringBuilder(
				"无MD5算法，这可能是你的JDK/JRE版本太低");

		StringBuilder fileNotFound = new StringBuilder("未找到文件，请重新定位文件路径");

		StringBuilder IOerror = new StringBuilder("文件流输入错误");

		try {

			MessageDigest md5 = MessageDigest.getInstance("MD5");

			File file = new File(path);

			FileInputStream fs = new FileInputStream(file);
			BufferedInputStream bi = new BufferedInputStream(fs);
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			byte[] b = new byte[bi.available()];
			int i;

			while ((i = bi.read(b, 0, b.length)) != -1) {
			}
			md5.update(b);

			for (byte by : md5.digest())
				sb.append(String.format("%02X", by));

			bo.close();

			bi.close();

		} catch (NoSuchAlgorithmException e) {

			return noAlgorithm;

		} catch (FileNotFoundException e) {

			return fileNotFound;

		} catch (IOException e) {

			return IOerror;

		}

		return sb;

	}
}
