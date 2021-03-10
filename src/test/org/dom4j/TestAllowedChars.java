package org.dom4j;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * @author Filip Jirsák
 */
public class TestAllowedChars extends AbstractTestCase {

    public static void main( String[] args ) {
        TestRunner.run( suite() );
    }

    public static Test suite() {
        return new TestSuite( TestAllowedChars.class );
    }

    public TestAllowedChars(String name) {
        super(name);
    }

    public void testLocalName() {
        QName qName1 = QName.get("element");
        QName qName2 = QName.get(":element");
        QName qName3 = QName.get("elem:ent");

        assertEquals("element", qName1.getName());
        assertEquals(":element", qName2.getName());
        assertEquals("elem:ent", qName3.getName());
    }

    public void testLocalNameFail() {
        try {
            QName.get("!element");
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    public void testQname() {
        QName.get("element", "http://example.com/namespace");
        QName.get("ns:element", "http://example.com/namespace");
        assertTrue(true);
    }

    public void testQnameFail1() {
        try {
            QName.get("ns:elem:ent", "http://example.com/namespace");
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    public void testQnameFail2() {
        try {
            QName.get(":nselement", "http://example.com/namespace");
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    public void testCreateElementLT() {
        try {
            DocumentHelper.createElement("element<name");
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    public void testCreateElementGT() {
        try {
            DocumentHelper.createElement("element>name");
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    public void testCreateElementAmpersand() {
        try {
            DocumentHelper.createElement("element&name");
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    public void testAddElement() {
        try {
            Element root = DocumentHelper.createElement("root");
            root.addElement("element>name");
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    public void testAddElementQualified() {
        try {
            Element root = DocumentHelper.createElement("root");
            root.addElement("element>name", "http://example.com/namespace");
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    public void testAddElementQualifiedPrefix() {
        try {
            Element root = DocumentHelper.createElement("root");
            root.addElement("ns:element>name", "http://example.com/namespace");
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    public void testAddElementPrefix() {
        try {
            Element root = DocumentHelper.createElement("root");
            root.addElement("ns>:element", "http://example.com/namespace");
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    //TODO It is illegal to create element or attribute with namespace prefix and empty namespace IRI.
    //See https://www.w3.org/TR/2006/REC-xml-names11-20060816/#scoping
}
