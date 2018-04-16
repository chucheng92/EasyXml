package com.rannn.jdom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * JDOM解析xml
 *
 * @author 哓哓
 */
public class JDOMTest {
    public static void main(String[] args) {
        // 进行对books.xml的JDOM解析
        // 1.创建一个SAXBuilder的对象
        SAXBuilder saxBuilder = new SAXBuilder();
        InputStream in = null;
        try {
            // 2.创建一个输入流，加载xml文件
            in = new FileInputStream("src/main/resources/books.xml");
            // 3.通过saxBuilder的build方法将输入流加载至saxBuilder
            Document document = saxBuilder.build(in);
            // 4.通过document对象获取根节点
            Element rootElement = document.getRootElement();
            // 5. 获取根节点下子节点集合
            List<Element> bookList = rootElement.getChildren();
            // 6.遍历
            for (Element book : bookList) {
                System.out.println("===开始解析第" + (bookList.indexOf(book) + 1) + "本书===");
                // 解析book的属性
                List<Attribute> attributes = book.getAttributes();
                // 遍历attributes（针对不清楚属性名和属性个数）
                for (Attribute attribute : attributes) {
                    System.out.println("属性名：" + attribute.getName() + " " + "属性值：" + attribute.getValue());
                }
                // 对book子节点名和节点值遍历
                List<Element> bookChilds = book.getChildren();
                for (Element child : bookChilds) {
                    System.out.println("节点名：" + child.getName() + " " + "节点值：" + child.getValue());
                }
                System.out.println("===结束解析第" + (bookList.indexOf(book) + 1) + "本书===");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
