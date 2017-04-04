package utils;

import java.io.FileOutputStream;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4JUtils {
	private static String dbFilePath = "";
	static{
		ClassLoader cl = Dom4JUtils.class.getClassLoader();
		URL url = cl.getResource("users.xml");
		dbFilePath = url.getPath();//得到真实路径
//		System.out.println(dbFilePath);
	}
	public static Document getDocument() throws DocumentException{
		SAXReader reader = new SAXReader();
		return reader.read(dbFilePath);
	}
	/**
	 * 将document对象写回xml文件。
	 * @param document document对象
	 * @throws Exception 
	 */
	public static void writer2xml(Document document) throws Exception{
		XMLWriter writer = new XMLWriter(new FileOutputStream(dbFilePath), OutputFormat.createPrettyPrint());
		writer.write(document);
		writer.close();
	}
}
