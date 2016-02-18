package com.tinymood.dom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTest {
	public static void main(String[] args) {
		// 创建DocumentBuilderFactory对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 创建DocumentBuilder对象
		try {
			// 创建DocumentBuilder对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 通过DocumentBuilder对象的parse方法加载xml
			Document document = db.parse("src/main/resources/books.xml");
			// 获取所有book节点的集合
			NodeList bookList = document.getElementsByTagName("book");
			// 通过NodeList的getLength方法获取bookList的长度
			System.out.println("一共有"+bookList.getLength()+"本书");
			
			// 保存books.xml的数据结构
			List<Book> books = new ArrayList<>(bookList.getLength());
			for (int i = 0; i<bookList.getLength(); i++) {
				books.add(new Book());
			}
			
			// 遍历每一个book节点
			for (int i=0; i<bookList.getLength(); i++) {
				System.out.println("====下面开始遍历第"+(i+1)+"本书的内容====");
				
//				// 情况1 前提:不知道属性名 遍历属性名和属性值
//				//通过item方法获取一个book节点
//				Node book = bookList.item(i);
//				// 获取book节点的所有属性的集合
//				NamedNodeMap attrs = book.getAttributes();
//				System.out.println("第"+(i+1)+"本书共有"+attrs.getLength()+"个属性");
//				// 遍历book的属性
//				for (int j=0; j<attrs.getLength(); j++) {
//					// 通过item方法获取book节点的属性
//					Node attr = attrs.item(j);
//					// 获取属性名
//					attr.getNodeName();
//					System.out.print("属性名："+attr.getNodeName());
//					// 获取属性值
//					attr.getNodeValue();
//					System.out.println(" 属性值："+attr.getNodeValue());
//				}
				
				//情况2 前提:已知book节点有且只能有1个id属性
				Element book = (Element)bookList.item(i);
				String attrValue = book.getAttribute("id");
				
				// 保存数据结构
				System.out.println("id属性的属性值为"+attrValue);
				books.get(i).setId(Integer.parseInt(attrValue));
				
				// 解析book节点的子节点
				NodeList childNodes = book.getChildNodes();
				// 遍历childNodes获取每个节点的节点名和节点值
				System.out.println("第"+(i+1)+"本书共有"+childNodes.getLength()+"个子节点");
				for (int j = 0; j < childNodes.getLength(); j++) {
					// 获取所有节点名
					childNodes.item(j).getNodeName();
					// 输出子节点的名字
//					System.out.println(childNodes.item(j).getNodeName());
					// 区分text类型的node和element类型的node
					if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
						// 获取element类型节点名
						childNodes.item(j).getNodeName();
						System.out.print("第"+(j+1)+"个节点名是："+ childNodes.item(j).getNodeName());
						
						// 保存数据结构
						if (childNodes.item(j).getNodeName().equals("name")) {
							books.get(i).setName(childNodes.item(j).getFirstChild().getNodeValue());
						} else if (childNodes.item(j).getNodeName().equals("author")) {
							books.get(i).setAuthor(childNodes.item(j).getFirstChild().getNodeValue());
						} else if (childNodes.item(j).getNodeName().equals("year")) {
							books.get(i).setYear(childNodes.item(j).getFirstChild().getNodeValue());
						} else if (childNodes.item(j).getNodeName().equals("price")) {
							books.get(i).setPrice(Integer.parseInt(childNodes.item(j).getFirstChild().getNodeValue()));
						} else if (childNodes.item(j).getNodeName().equals("language")) {
							books.get(i).setLanguage(childNodes.item(j).getFirstChild().getNodeValue());
						}
						
						// 获取element类型节点值 方法1
						childNodes.item(j).getFirstChild().getNodeValue();
						System.out.println(" 节点值是："+childNodes.item(j).getFirstChild().getNodeValue());
						
						// 获取element类型节点值 方法2
//						childNodes.item(j).getTextContent();
//						System.out.println(" 节点值是："+childNodes.item(j).getTextContent());
					}
				}
				System.out.println("====结束遍历第"+(i+1)+"本书的内容====");
			}
			
			for (Book book : books) {
				System.out.println(book);
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
