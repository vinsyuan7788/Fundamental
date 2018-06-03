package com.java.se.conclusion.xml;

/**
 * 	This is a class to test XML
 *  
 * 	There are 2 ways to parse XML:
 *  -- DOM (Document Object Model): assign a tree structure inside the memory and encapsulate tags, attributes and texts into node objects
 *     -- Pros: convenient for add, update, delete and query operations
 *     -- Cons: cause memory overflow if the file is too big
 *  -- SAX (Simple APIs for XML): event-driven; read and parse line-by-line; return the object when parse an object
 *     -- Pros: convenient for query operation; never cause memory overflow
 *     -- Cons: do not allow add, update and delete operations
 *     
 *  SAX event-driven: parsing is event, and parsing different elements will trigger different methods. Particularly:
 *  -- When parsing start elements (e.g., <p> in <p>Hello World!</p>), auto-execute "startElement()" method
 *  -- When parsing texts (e.g., "Hello World!" in <p>Hello World!</p>), auto-execute "character()" method
 *  -- When parsing end elements (e.g., </p> in <p>Hello World!</p>), auto-execute "endElement()" method
 *  -- Above-mentioned methods are declared in "org.xml.sax.helpers.DefaultHandler"
 *  
 *  There are several choices of APIs to parse XML:
 *  -- Jaxp: provided by Sun corporation and belong to JavaSE (javax.xml.parsers)
 *     -- For both DOM and SAX
 *  -- Dom4j: provided by Dom4j (previously belong to Jdom) and MOST COMMONLY USED
 *     -- For both DOM and SAX
 *     
 * @author VinceYuan
 *
 */
public class TestXML {

}
