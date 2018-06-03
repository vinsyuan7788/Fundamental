package com.java.se.conclusion.xml.jaxp;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.java.se.common.utils.CollectionUtils;
import com.java.se.conclusion.xml.jaxp.util.JaxpUtils;

/**
 * 	This is a class to test JAXP for DOM and SAX
 * 
 * 	JAXP SAX parsing:
 *  -- Instantiate a DefaultHandler object to enable the XML parsing
 *  -- Override "startElement()", "characters()", "endElement()" methods particularly
 *     -- When parsing start elements (e.g., <p> in <p>Hello World!</p>), auto-execute "startElement()" method
 *     -- When parsing texts (e.g., "Hello World!" in <p>Hello World!</p>), auto-execute "character()" method
 *     -- When parsing end elements (e.g., </p> in <p>Hello World!</p>), auto-execute "endElement()" method
 * 
 * @author VinceYuan
 *
 */
public class TestJAXP {

	/*	Necessary instance variables	*/
	private String filePath;
	
	/**
	 * 	This is a main method for execution
	 * @param args
	 */
	public static void main(String[] args) {
		TestJAXP testJAXP = new TestJAXP();
		testJAXP.testPreparation();
		System.out.println("Here tests DOM:");
		testJAXP.testDOM();
		System.out.println("\nHere tests SAX:");
		testJAXP.testSAX();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		filePath = "src/main/java/com/java/se/conclusion/xml/jaxp/common/sergeant_config.xml";
	}
	
	/**
	 * 	Test DOM by JAXP
	 */
	private void testDOM() {

		/*	Do the add, update, remove and query operation	*/
		Document document = JaxpUtils.getDocument(filePath);
		List<String> infomrationOfElements = JaxpUtils.getInformationOfElements(document, "bean");
		System.out.println("Names, attributes and text values of elements:\n" + CollectionUtils.toString(infomrationOfElements));
		Node beanElement = document.getElementsByTagName("bean").item(0);
		System.out.println("\nName, attributes and text value of the element:\n" + JaxpUtils.getInformationOfElement(beanElement));
		Node element = JaxpUtils.appendElement(document, beanElement, "grade", "A");
		JaxpUtils.updateElementText(element, "S");
		JaxpUtils.removeElement(element);
		JaxpUtils.writeBack(document, filePath);

		/*	Traverse an element	 */
		System.out.println("\nThe element structure:");
		JaxpUtils.traverseElement(beanElement, 0);
	}
	
	/**
	 * 	Test SAX by JAXP
	 */
	private void testSAX() {
		
		/*	Parse the whole XML file	*/
		System.out.println("The XML file:");
		JaxpUtils.parseFile(filePath, new DefaultHandler() {
			
			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				System.out.print(new String(ch, start, length));
			}

			@Override
			public void endElement(String url, String localName, String qName) throws SAXException {
				System.out.print("</" + qName + ">");
			}

			@Override
			public void startElement(String url, String localName, String qName, Attributes attributes) throws SAXException {
				System.out.print("<" + qName + ">");
			}
		});
		
		/*	Get the text of specific elements	*/
		System.out.println("\n\nThe values of <firstName>:");
		JaxpUtils.parseFile(filePath, new DefaultHandler() {
			
			/*	Necessary instance variables	*/
		    public boolean flag = false;
			
			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				if (flag == true) System.out.println(new String(ch, start, length)); 
			}

			@Override
			public void endElement(String uri, String localName, String qName) throws SAXException {
				if (qName == "firstName" || qName.equals("firstName")) flag = false;
			}

			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				if (qName == "firstName" || qName.equals("firstName")) flag = true;
			}
		});
	
		/*	Get the text of a specific element	*/
		System.out.println("\nThe value of 1st <firstName>:");
		JaxpUtils.parseFile(filePath, new DefaultHandler() {
			
			/*	Necessary instance variables	*/
		    public boolean flag = false;
		    public int index = 0;
			
			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				if (flag == true && index == 1) System.out.println(new String(ch, start, length)); 
			}

			@Override
			public void endElement(String uri, String localName, String qName) throws SAXException {
				if (qName == "firstName" || qName.equals("firstName")) {
					flag = false;
					index++;
				}
			}

			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				if (qName == "firstName" || qName.equals("firstName")) {
					flag = true;
					index++;
				}
			}
		});
	}
}
