package com.java.se.conclusion.xml.dom4j.util;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.java.se.common.utils.StringUtils;

/**
 * 	This is a class to implement DOM4J utility methods
 * 
 * @author VinceYuan
 *
 */
public class Dom4jUtils {

	/*------------------------------------- DOM4J for DOM --------------------------------------------*/
	/**
	 * 	This is a method to return a XML document instance
	 *  -- This document instance will contain a tree structure for DOM and allow parsing line-by-line for SAX
	 * @param filePath
	 * @return
	 */
	public static Document getDocument(String filePath) {
		
		try {
			/*	Return the document object	*/
			return new SAXReader().read(filePath);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		/*	If there is any exception, return null	*/
		return null;
	}
	
	/**
	 * 	This is a method to write back the XML file
	 * @param document
	 * @param path
	 */
	public static void writeBack(Document document, String filePath) {
		
		/*	Declare a null references for necessary stream	*/
		XMLWriter xmlWriter = null;
		
		try {
			/*	Initialize a stream to write back the XML file	*/
			xmlWriter = new XMLWriter(new FileOutputStream(filePath), OutputFormat.createPrettyPrint());
			xmlWriter.write(document);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				/*	Close the stream	*/
				if (xmlWriter != null) xmlWriter.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * 	This is a method to get names, attributes and text values of elements
	 * @param document
	 * @param tagName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getInformationOfElements(Document document, String tagName) {
		
		/*	Initialize a string buffer and a string list  */
		List<String> stringList = new ArrayList<>();
		
		/*	Append the names and attributes of tags  */
		List<Element> elementList = document.getRootElement().elements(tagName);
		for (int i = 0; i < elementList.size(); i++) {
			stringList.add(getInformationOfElement(elementList.get(i)));
		}
		
		/*	Return the string list	*/
		return stringList;
	}
	
	/**
	 * 	This is a method to get the name, attributes and text value of an element
	 * @param element
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getInformationOfElement(Element element) {
		
		/*	Initialize a string buffer  */
		StringBuffer stringBuffer = new StringBuffer("<" + element.getName());
		
		/*	Append the node name and attributes	 */
		if (element.getNodeType() == Element.ELEMENT_NODE && element.attributeCount() != 0) {
			List<Attribute> attributeList = element.attributes();
			for (int j = 0; j < attributeList.size(); j++) {
				Attribute attribute = attributeList.get(j);
				stringBuffer.append(" " + attribute.getName() + "=\"" + attribute.getValue() + "\"");
			}
		}
		
		/*	Append the text values	*/
		stringBuffer.append(">" + element.getStringValue() + "</" + element.getName() + ">");
		
		/*	Return a string from the string buffer	*/
		return stringBuffer.toString();
	}
	
	/**
	 * 	This is a method to create an element with text under a parent element 
	 * @param parentElement
	 * @param elementName
	 * @param elementText
	 * @return
	 */
	public static Element appendElement(Element parentElement, String elementName, String elementText) {
		 
		Element childElement = parentElement.addElement(elementName);
		if (elementText != null) childElement.setText(elementText);
		return childElement;
	}
	
	/**
	 * 	This is a method to update the text of an element
	 * @param element
	 * @param text
	 */
	public static void updateElementText(Element element, String text) {
		if (element.getNodeType() == Element.ELEMENT_NODE) element.setText(text);
	}
	
	/**
	 * 	This is a method to remove an element
	 * @param element
	 */
	public static void removeElement(Element element) {
		if (element.getNodeType() == Element.ELEMENT_NODE) element.getParent().remove(element);
	}
	
	/**
	 * 	This is a method to traverse an element recursively
	 * @param element
	 * @param level
	 */
	@SuppressWarnings("unchecked")
	public static void traverseElement(Element element, int level) {
		
		if (element.getNodeType() == Node.ELEMENT_NODE) {
			System.out.println(StringUtils.appendIndents(level) + "<" + element.getName() + ">");
			List<Element> childElements = element.elements();
			for (int i = 0; i < childElements.size(); i++) {
				traverseElement(childElements.get(i), level + 1);
			}
		}
	}
	
	/*------------------------------------- DOM4J for XPath --------------------------------------------*/
	/**
	 * 	This is a method to get names, attributes and text values of elements by XPath
	 * @param document
	 * @param tagName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getInformationOfElementsByXPath(Document document, String xpath) {
		
		/*	Initialize a string buffer and a string list  */
		List<String> stringList = new ArrayList<>();
		
		/*	Append the names and attributes of tags  */
		List<Node> nodeList = document.selectNodes(xpath);
		for (int i = 0; i < nodeList.size(); i++) {
			Node node = nodeList.get(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				stringList.add(getInformationOfElement((Element)node));
			}
		}
		
		/*	Return the string list	*/
		return stringList;
	}
}
