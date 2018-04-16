package com.rannn.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {
	int bookIndex = 0;
	/**
	 * 用来遍历xml文件元素的开始标签
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if (qName.equals("book")) {
			// 开始解析book属性
			bookIndex++;
			System.out.println("====下面开始遍历第" + bookIndex + "本书的内容====");
			// 已知属性名
//			String value = attributes.getValue("id");
//			System.out.println("book的属性值是："+value);
			// 不知道属性名和属性的个数
			int num = attributes.getLength();
			for (int i = 0; i < num; i++) {
				System.out.print("book元素的第"+(i+1)+"个属性名是："+attributes.getQName(i));
				System.out.println(" 属性值是："+attributes.getValue(i));
			}
		} else if (!qName.equals("book") && !qName.equals("bookstore")) {
			System.out.print("节点名是："+qName+" ");
		}
	}
	
	/**
	 * 用来遍历xml文件元素的结束标签
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		// 判断是否针对一本书已经遍历结束
		if (qName.equals("book")) {
			System.out.println("====结束遍历" + bookIndex + "本书的内容====");
		}
	}
	
	/**
	 * 用来标识解析开始
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("SAX解析开始");
	}
	
	/**
	 * 用来标识解析结束
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("SAX解析结束");
	}
	
	/**
	 * 
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		String value = new String(ch, start, length);
		if (!value.trim().equals("")) {
			System.out.println("节点值是："+value);
		}
	}
}
