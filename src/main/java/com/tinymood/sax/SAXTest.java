package com.tinymood.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * SAX解析xml
 * @author 哓哓
 *
 */
public class SAXTest {
	public static void main(String[] args) {
		// 获取一个SAXParserFactory的实例
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			// 通过factory获取SAXParser的实例
			SAXParser parser = factory.newSAXParser();
			// 创建Handler对象
			SAXParserHandler handler = new SAXParserHandler();
			parser.parse("src/main/resources/books.xml", handler);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
