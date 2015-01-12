package com.schoolo2o.utils;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * 文档工具类
 * 
 * @author hengyi
 * 
 */
public class DOMUtils {

	static final int wdFormatPDF = 17;

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
		ActiveXComponent app = null;
		Dispatch doc = null;
		String toFilePath = "";
		try {
			app = new ActiveXComponent("Word.Application");
			app.setProperty("Visible", new Variant(false));
			Dispatch docs = app.getProperty("Documents").toDispatch();

			toFilePath = wordPath2PdfPath(wordPath);

			doc = Dispatch.call(docs, "Open", wordPath).toDispatch();

			File tofile = new File(toFilePath);
			if (tofile.exists()) {
				tofile.delete();
			}
			Dispatch.call(doc, "SavaAs", toFilePath, wdFormatPDF);
			long end = System.currentTimeMillis();

		} catch (Exception e) {
			System.out.println("对不起，此转换工作只能在windows环境下执行，万恶的巨硬。。。。。。。");
			e.printStackTrace();
		} finally {
			Dispatch.call(doc, "Close", false);
			System.out.println("文档关闭");
			if (app != null) {
				app.invoke("Quit", new Variant[] {});
			}

			ComThread.Release();
		}
		return toFilePath;
	}

	private static String wordPath2PdfPath(String wordPath) {
		String[] strs = wordPath.split("\\.");
		return strs[0] + ".pdf";

	}

}
