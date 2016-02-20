package com.tinymood.dom4j;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DOM4JTest {
	public static void main(String[] args) {
		// 解析books.xml
		// 创建SAXReader的对象
		SAXReader reader = new SAXReader();
		try {
			// 通过SAXReader的read方法加载xml文件并获取document对象
			Document document = reader.read(new File("src/main/resources/books.xml"));
			// 获取根节点
			Element bookStore = document.getRootElement();
			// 获取迭代器
			Iterator<Element> it = bookStore.elementIterator();
			//  遍历
			while (it.hasNext()) {
				System.out.println("===========开始遍历某本书==========");
				Element book = it.next();
				// 获取book的属性名和属性值
				List<Attribute> bookAttrs = book.attributes();
				for (Attribute attr : bookAttrs) {
					System.out.println("属性名：" + attr.getName() + " 属性值：" + attr.getValue());
				}
				Iterator<Element> itt = book.elementIterator();
				while (itt.hasNext()) {
					Element bookChild = itt.next();
					System.out.println("节点名：" + bookChild.getName() + " 节点值：" + bookChild.getStringValue());
				}
				System.out.println("===========结束遍历某本书===========");
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
