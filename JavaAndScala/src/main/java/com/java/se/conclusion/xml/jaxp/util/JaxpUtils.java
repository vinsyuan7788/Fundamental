package com.java.se.conclusion.xml.jaxp.util;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.helpers.DefaultHandler;

import com.java.se.common.utils.StringUtils;

/**
 * 	This is a class to implement JAXP (Java APIs for XML Parsing) utility methods
 * 
 * @author VinceYuan
 *
 */
public class JaxpUtils {

	/*------------------------------------- JAXP for DOM --------------------------------------------*/
	/**
	 * 	This is a method to return a XML document instance
	 * @param path
	 * @return
	 */
	public static Document getDocument(String filePath) {
		
		try {
			/*	Return the XML document instance  */
			return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(filePath);
		} catch (Exception e) {
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
		
		try {
			TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), new StreamResult(filePath));	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	This is a method to get names, attributes and text values of elements
	 * @param document
	 * @param tagName
	 * @return
	 */
	public static List<String> getInformationOfElements(Document document, String tagName) {
		
		/*	Initialize a string buffer and a string list  */
		List<String> stringList = new ArrayList<>();
		
		/*	Append the names and attributes of tags  */
		NodeList elementList = document.getElementsByTagName(tagName);
		for (int i = 0; i < elementList.getLength(); i++) {
			stringList.add(getInformationOfElement(elementList.item(i)));
		}
		
		/*	Return the string list	*/
		return stringList;
	}
	
	/**
	 * 	This is a method to get the name, attributes and text value of an element
	 * @param element
	 * @return
	 */
	public static String getInformationOfElement(Node element) {
		
		/*	Initialize a string buffer  */
		StringBuffer stringBuffer = new StringBuffer("<" + element.getNodeName());
		
		/*	Append the node name and attributes	 */
		if (element.getNodeType() == Node.ELEMENT_NODE && element.hasAttributes()) {
			NamedNodeMap attributeMap = element.getAttributes();
			for (int j = 0; j < attributeMap.getLength(); j++) {
				Node attribute = attributeMap.item(j);
				stringBuffer.append(" " + attribute.getNodeName() + "=\"" + attribute.getTextContent() + "\"");
			}
		}
		
		/*	Append the text values	*/
		stringBuffer.append(">" + element.getTextContent() + "</" + element.getNodeName() + ">");
		
		/*	Return a string from the string buffer	*/
		return stringBuffer.toString();
	}
	
	/**
	 * 	This is a method to create an element with text under a parent element 
	 * @param document
	 * @param parentElement
	 * @param elementName
	 * @param elementText
	 * @return
	 */
	public static Node appendElement(Document document, Node parentElement, String elementName, String elementText) {
		 
		Element childElement = document.createElement(elementName);
		Text childElementText = document.createTextNode(elementText);
		if (childElementText != null) childElement.appendChild(childElementText);
		parentElement.appendChild(childElement);
		return childElement;
	}

	/**
	 * 	This is a method to update the text of an element
	 * @param element
	 * @param string
	 */
	public static void updateElementText(Node element, String text) {
		if (element.getNodeType() == Node.ELEMENT_NODE) element.setTextContent(text);
	}
	
	/**
	 * 	This is a method to remove an element
	 * @param element
	 */
	public static void removeElement(Node element) {
		if (element.getNodeType() == Node.ELEMENT_NODE) element.getParentNode().removeChild(element);
	}
	
	/**
	 * 	This is a method to traverse an element recursively
	 * @param element
	 * @param level
	 */
	public static void traverseElement(Node element, int level) {
		
		if (element.getNodeType() == Node.ELEMENT_NODE) {
			System.out.println(StringUtils.appendIndents(level) + "<" + element.getNodeName() + ">");
			NodeList childElements = element.getChildNodes();
			for (int i = 0; i < childElements.getLength(); i++) {
				traverseElement(childElements.item(i), level + 1);
			}
		}
	}
	
	/*------------------------------------- JAXP for SAX --------------------------------------------*/
	/**
	 * 	This is a method to parse the XML file
	 * @param filePath
	 */
	public static void parseFile(String filePath, DefaultHandler defaultHandler) {
		try {
			SAXParserFactory.newInstance().newSAXParser().parse(filePath, defaultHandler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
