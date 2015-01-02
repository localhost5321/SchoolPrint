package com.schoolo2o.utils;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ooo.connector.BootstrapSocketConnector;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.sun.star.beans.XPropertySet;
import com.sun.star.lang.XComponent;
import com.sun.star.lang.XMultiServiceFactory;
import com.sun.star.style.NumberingType;
import com.sun.star.text.XText;
import com.sun.star.text.XTextContent;
import com.sun.star.text.XTextDocument;
import com.sun.star.text.XTextField;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;

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
		try {
			XWPFDocument doc = new XWPFDocument(
					POIXMLDocument.openPackage(filepath));
			return doc.getProperties().getExtendedProperties()
					.getUnderlyingProperties().getPages();
		} catch (IOException e) {
			e.printStackTrace();
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
				return countWordPage(filePath);
			} else if (str.contains("pdf")) {
				// 计算pdf页码
				return getPageCountPDF(filePath);
			}
		}
		return 0;
	}

	public static int countWordPage(String filePath) {
		try {
			// get the remote office component context
			XComponentContext xContext = null;

			String oooExeFolder = "/usr/lib/libreoffice/program/";
			// String oooExeFolder = "/opt/openoffice.org3/program/";
			System.out.println("Connecting ...");

			xContext = BootstrapSocketConnector.bootstrap(oooExeFolder);
			System.out.println("Connected to a running office ...");

			// get the remote office service manager
			com.sun.star.lang.XMultiComponentFactory xMCF = xContext
					.getServiceManager();

			Object oDesktop = xMCF.createInstanceWithContext(
					"com.sun.star.frame.Desktop", xContext);

			com.sun.star.frame.XComponentLoader xCompLoader = (com.sun.star.frame.XComponentLoader) UnoRuntime
					.queryInterface(com.sun.star.frame.XComponentLoader.class,
							oDesktop);

			java.io.File sourceFile = new java.io.File(filePath);
			StringBuffer sLoadUrl = new StringBuffer("file:///");
			sLoadUrl.append(sourceFile.getCanonicalPath().replace('\\', '/'));

			com.sun.star.beans.PropertyValue[] propertyValue = new com.sun.star.beans.PropertyValue[1];
			propertyValue[0] = new com.sun.star.beans.PropertyValue();
			propertyValue[0].Name = "Hidden";
			propertyValue[0].Value = new Boolean(true);

			XComponent oDocToStore = xCompLoader.loadComponentFromURL(
					sLoadUrl.toString(), "_blank", 0, propertyValue);
			XTextDocument mxDoc = (XTextDocument) UnoRuntime.queryInterface(
					XTextDocument.class, oDocToStore);
			XMultiServiceFactory mxDocFactory = (XMultiServiceFactory) UnoRuntime
					.queryInterface(XMultiServiceFactory.class, mxDoc);

			XTextField xtf = (com.sun.star.text.XTextField) UnoRuntime
					.queryInterface(
							XTextField.class,
							mxDocFactory
									.createInstance("com.sun.star.text.TextField.PageCount"));

			XTextContent xtc = (com.sun.star.text.XTextContent) UnoRuntime
					.queryInterface(XTextField.class, xtf);

			XPropertySet pageCountPS = (XPropertySet) UnoRuntime
					.queryInterface(XPropertySet.class, xtc);

			pageCountPS.setPropertyValue("NumberingType", new Short(
					NumberingType.NATIVE_NUMBERING));

			XText xText = mxDoc.getText();
			xText.insertTextContent(mxDoc.getText().getEnd(), xtc, false);

			String result = xtf.getAnchor().getString();
			// System.out.println("debug:" + result);
			mxDoc.dispose();
			return Integer.parseInt(result);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

}
