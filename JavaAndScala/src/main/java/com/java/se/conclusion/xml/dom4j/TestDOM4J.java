package com.java.se.conclusion.xml.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import com.java.se.common.utils.CollectionUtils;
import com.java.se.conclusion.xml.dom4j.util.Dom4jUtils;

/**
 * 	This is a class to test DOM4J for DOM and XPath
 * 
 * @author VinceYuan
 *
 */
public class TestDOM4J {

	/*	Necessary instance variables	*/
	private String filePath;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestDOM4J testDOM4J = new TestDOM4J();
		testDOM4J.testPreparation();
		System.out.println("Here tests DOM:");
		testDOM4J.testDOM();
		System.out.println("\nHere tests XPath:");
		testDOM4J.testXPath();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		filePath = "src/main/java/com/java/se/conclusion/xml/dom4j/common/sergeant_config.xml";
	}
	
	/**
	 * 	Test DOM by DOM4J
	 */
	private void testDOM() {
		
		/*	Do the add, update, remove and query operation	*/
		Document document = Dom4jUtils.getDocument(filePath);
		List<String> informationOfElements = Dom4jUtils.getInformationOfElements(document, "bean");
		System.out.println("Names, attributes and text values of elements:\n" + CollectionUtils.toString(informationOfElements));
		Element beanElement = (Element) document.getRootElement().elements("bean").get(0);
		System.out.println("\nName, attributes and text value of the element:\n" + Dom4jUtils.getInformationOfElement(beanElement));
		Element element = Dom4jUtils.appendElement(beanElement, "grade", "A");
		Dom4jUtils.updateElementText(element, "S");
		Dom4jUtils.removeElement(element);
		Dom4jUtils.writeBack(document, filePath);

		/*	Traverse an element	 */
		System.out.println("\nThe element structure:");
		Dom4jUtils.traverseElement(beanElement, 0);
	}
	
	/**
	 * 	Test XPath by DOM4J
	 */
	private void testXPath() {
		
		Document document = Dom4jUtils.getDocument(filePath);
		List<String> informationOfElements = Dom4jUtils.getInformationOfElementsByXPath(document, "//bean");
		System.out.println("Names, attributes and text values of elements:\n" + CollectionUtils.toString(informationOfElements));
		informationOfElements = Dom4jUtils.getInformationOfElementsByXPath(document, "//firstName");
		System.out.println("\nNames, attributes and text values of elements:\n" + CollectionUtils.toString(informationOfElements));
	}
}
