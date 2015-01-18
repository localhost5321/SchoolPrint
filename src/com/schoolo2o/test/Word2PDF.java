package com.schoolo2o.test;

import com.schoolo2o.utils.DOMUtils;

public class Word2PDF {

	public static void main(String[] argv) {
		String wordPdf = "D:\\Users\\EclipseLib\\apache-tomcat-7.0.53\\webapps\\SchoolPrint\\2015\\01\\18\\doc\\c718adfbbd2ac665166c65c52e30af24.doc";

		String str = DOMUtils.word2pdf(wordPdf);

		System.out.println(str);

		// String wordPath =
		// "D://Users//EclipseLib//apache-tomcat-7.0.53//webapps//SchoolPrint//2015//01//18//doc//ac66ae219686bdefdbf42e972339d362.doc";
		// String pdfPath = DOMUtils.wordPath2PdfPath(wordPath);
		// System.out.println(pdfPath);
	}
}
