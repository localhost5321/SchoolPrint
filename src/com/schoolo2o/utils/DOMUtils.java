package com.schoolo2o.utils;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;

import com.qoppa.word.WordDocument;

/**
 * 文档工具类
 * 
 * @author hengyi
 * 
 */
public class DOMUtils {

	/**
	 * PDF页数
	 * 
	 * @param filepath
	 * @return
	 */
	public static int getPageCountPDF(String filepath) {
		try {
			PDDocument doc = PDDocument.load(new File(filepath));
			return doc.getNumberOfPages();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * word文档页数
	 * 
	 * @param filepath
	 * @return
	 */
	public static int getPageCountWord(String filepath) {
		String pdfPath = word2pdf(filepath);
		if (!pdfPath.equals("")) {
			return getPageCountPDF(pdfPath);
		}
		return 0;
	}

	/**
	 * 自行判断文档类型进而计算页码数
	 * 
	 * @param filePath
	 * @return
	 */
	public static int getPageCount(String filePath) {
		Pattern pattern = Pattern.compile("\\.\\w+$");
		Matcher matcher = pattern.matcher(filePath);
		if (matcher.find()) {
			String str = matcher.group();
			if (str.contains("doc")) {
				// 计算word页码
				return getPageCountWord(filePath);
			} else if (str.contains("pdf")) {
				// 计算pdf页码
				return getPageCountPDF(filePath);
			}
		}
		return 0;
	}

	/**
	 * word转换为pdf
	 * 
	 * @param wordPath
	 * @return pdfPath
	 */
	public static String word2pdf(String wordPath) {
		WordDocument wordDocument;
		String pdfPath = "";
		try {
			wordDocument = new WordDocument(wordPath);
			// 构造新的pdf文件名
			String[] strs = wordPath.split("\\.");
			pdfPath = strs[0] + ".pdf";
			wordDocument.saveAsPDF(pdfPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pdfPath;
	}
}
