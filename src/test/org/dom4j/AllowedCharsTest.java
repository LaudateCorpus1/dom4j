package org.dom4j;

import junit.framework.TestCase;

/**
 * @author Filip Jirsák
 */
public class AllowedCharsTest extends TestCase{

    public void testLocalName() {
        QName.get("element");
        QName.get(":element");
        QName.get("elem:ent");
    }

    public void testLocalNameFail() {
        try {
            QName.get("!element");
            fail("Expected exception IllegalArgumentException.class but none occured")
        } catch (IllegalArgumentException.class){}
    }

    public void testQname() {
        try {
            QName.get("element", "http://example.com/namespace");
            QName.get("ns:element", "http://example.com/namespace");
            fail("Expected exception IllegalArgumentException.class but none occured")
        } catch (IllegalArgumentException.class){}
    }

    public void testQnameFail1() {
        try {
            QName.get("ns:elem:ent", "http://example.com/namespace");
            fail("Expected exception IllegalArgumentException.class but none occured")
        } catch (IllegalArgumentException.class){}
    }

    public void testQnameFail2() {
        try {
            QName.get(":nselement", "http://example.com/namespace");
            fail("Expected exception IllegalArgumentException.class but none occured")
        } catch (IllegalArgumentException.class){}
    }

    public void testCreateElementLT() {
        try {
            DocumentHelper.createElement("element<name");
            fail("Expected exception IllegalArgumentException.class but none occured")
        } catch (IllegalArgumentException.class){}
    }

    public void testCreateElementGT() {
        try {
            DocumentHelper.createElement("element>name");
            fail("Expected exception IllegalArgumentException.class but none occured")
        } catch (IllegalArgumentException.class){}
    }

    public void testCreateElementAmpersand() {
        try {
            DocumentHelper.createElement("element&name");
            fail("Expected exception IllegalArgumentException.class but none occured")
        } catch (IllegalArgumentException.class){}
    }

    public void testAddElement() {
        try {
            Element root = DocumentHelper.createElement("root");
            root.addElement("element>name");
            fail("Expected exception IllegalArgumentException.class but none occured")
        } catch (IllegalArgumentException.class){}
    }

    public void testAddElementQualified() {
        try {
            Element root = DocumentHelper.createElement("root");
            root.addElement("element>name", "http://example.com/namespace");
            fail("Expected exception IllegalArgumentException.class but none occured")
        } catch (IllegalArgumentException.class){}
    }

    public void testAddElementQualifiedPrefix() {
        try {
            Element root = DocumentHelper.createElement("root");
            root.addElement("ns:element>name", "http://example.com/namespace");
            fail("Expected exception IllegalArgumentException.class but none occured")
        } catch (IllegalArgumentException.class){}
    }

    public void testAddElementPrefix() {
        try {
            Element root = DocumentHelper.createElement("root");
            root.addElement("ns>:element", "http://example.com/namespace");
            fail("Expected exception IllegalArgumentException.class but none occured")
        } catch (IllegalArgumentException.class){}
    }

    //TODO It is illegal to create element or attribute with namespace prefix and empty namespace IRI.
    //See https://www.w3.org/TR/2006/REC-xml-names11-20060816/#scoping
}
