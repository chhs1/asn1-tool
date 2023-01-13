/*******************************************************************************
 * Copyright (C) 2023 Fred D7e (https://github.com/yafred)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package com.yafred.asn1.test.ASN;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import com.yafred.asn1.runtime.ASNValueReader;
import com.yafred.asn1.runtime.ASNValueWriter;

import java.util.BitSet;
import java.util.Arrays;

import org.junit.Test;

import g_013.MyEnumeratedList;
import g_013.MyEnumeratedList2;
import g_013.MyEnumeration;
import g_013.MyBitstring;
import g_013.MyBitstringList;
import g_013.MyOctetStringList;
import g_013.MyIntegerList;
import g_013.MyStringList;


public class TestGeneratedCode_013 {

	@Test
	public void test_1() throws Exception {
		String asnValue = "{\r\n" + 
				"  1,\r\n" + 
				"  ten,\r\n" + 
				"  twenty\r\n" + 
				"}";
				
    	InputStream inputStream = new ByteArrayInputStream(asnValue.getBytes(StandardCharsets.UTF_8));
    	ASNValueReader asnValueReader = new ASNValueReader(inputStream);
    	
    	MyIntegerList decodedPdu = MyIntegerList.readPdu(asnValueReader);

		assertNotNull(decodedPdu.getValue());
		assertEquals(3, decodedPdu.getValue().size());
		assertEquals(Integer.valueOf(1), decodedPdu.getValue().get(0));		
		assertEquals(Integer.valueOf(10), decodedPdu.getValue().get(1));		
		assertEquals(Integer.valueOf(20), decodedPdu.getValue().get(2));
		
		StringWriter stringWriter = new StringWriter(100);
		ASNValueWriter asnValueWriter = new ASNValueWriter(new PrintWriter(stringWriter));
		MyIntegerList.writePdu(decodedPdu, asnValueWriter);
		
		assertEquals(asnValue.replaceAll("\\s+",""), stringWriter.toString().replaceAll("\\s+",""));  		
	}
	
	@Test
	public void test_2() throws Exception {
		String asnValue = "{\r\n" + 
				"  \"one\",\r\n" + 
				"  \"two\"\r\n" + 
				"}";
				
    	InputStream inputStream = new ByteArrayInputStream(asnValue.getBytes(StandardCharsets.UTF_8));
    	ASNValueReader asnValueReader = new ASNValueReader(inputStream);
    	
    	MyStringList decodedPdu = MyStringList.readPdu(asnValueReader);

		assertNotNull(decodedPdu.getValue());
		assertEquals(2, decodedPdu.getValue().size());
		assertEquals("one", decodedPdu.getValue().get(0));		
		assertEquals("two", decodedPdu.getValue().get(1));		
		
		StringWriter stringWriter = new StringWriter(100);
		ASNValueWriter asnValueWriter = new ASNValueWriter(new PrintWriter(stringWriter));
		MyStringList.writePdu(decodedPdu, asnValueWriter);
		
		assertEquals(asnValue.replaceAll("\\s+",""), stringWriter.toString().replaceAll("\\s+",""));  		
	}
	
	@Test
	public void test_3() throws Exception {
		String asnValue = "{\r\n" + 
				"  '0a0b'H,\r\n" + 
				"  '0102'H\r\n" + 
				"}";
				
    	InputStream inputStream = new ByteArrayInputStream(asnValue.getBytes(StandardCharsets.UTF_8));
    	ASNValueReader asnValueReader = new ASNValueReader(inputStream);
    	
    	MyOctetStringList decodedPdu = MyOctetStringList.readPdu(asnValueReader);

		assertNotNull(decodedPdu.getValue());
		assertEquals(2, decodedPdu.getValue().size());
		assertTrue(Arrays.equals(new byte[] { 0x0a, 0x0b }, decodedPdu.getValue().get(0)));		
		assertTrue(Arrays.equals(new byte[] { 0x01, 0x02 }, decodedPdu.getValue().get(1)));		

		StringWriter stringWriter = new StringWriter(100);
		ASNValueWriter asnValueWriter = new ASNValueWriter(new PrintWriter(stringWriter));
		MyOctetStringList.writePdu(decodedPdu, asnValueWriter);
		
		assertEquals(asnValue.replaceAll("\\s+",""), stringWriter.toString().replaceAll("\\s+",""));  		
	}
	
	@Test
	public void test_4() throws Exception {
		BitSet item1 = new BitSet();
		item1.set(MyBitstring.ARTIST);
		item1.set(MyBitstring.CLERK);
		item1.set(4);
		BitSet item2 = new BitSet();
		item2.set(MyBitstring.EDITOR);
		item2.set(MyBitstring.PUBLISHER);
		item2.set(4);

		String asnValue = "{\r\n" + 
				"  '10101'B,\r\n" + 
				"  '01011'B \r\n" + 
				"}";
				
    	InputStream inputStream = new ByteArrayInputStream(asnValue.getBytes(StandardCharsets.UTF_8));
    	ASNValueReader asnValueReader = new ASNValueReader(inputStream);
    	
    	MyBitstringList decodedPdu = MyBitstringList.readPdu(asnValueReader);

		assertNotNull(decodedPdu.getValue());
		assertEquals(2, decodedPdu.getValue().size());
		assertTrue(Arrays.equals(item1.toByteArray(), decodedPdu.getValue().get(0).toByteArray()));		
		assertTrue(Arrays.equals(item2.toByteArray(), decodedPdu.getValue().get(1).toByteArray()));		

		StringWriter stringWriter = new StringWriter(100);
		ASNValueWriter asnValueWriter = new ASNValueWriter(new PrintWriter(stringWriter));
		MyBitstringList.writePdu(decodedPdu, asnValueWriter);
		
		assertEquals(asnValue.replaceAll("\\s+",""), stringWriter.toString().replaceAll("\\s+",""));  		
	}	

	@Test
	public void test_5() throws Exception {
		BitSet item1 = new BitSet();
		item1.set(MyBitstring.ARTIST);
		item1.set(MyBitstring.CLERK);
		BitSet item2 = new BitSet();
		item2.set(MyBitstring.EDITOR);
		item2.set(MyBitstring.PUBLISHER);

		String asnValue = "{\r\n" + 
				"  { clerk, artist },\r\n" + 
				"  { editor, publisher }\r\n" + 
				"}";
				
    	InputStream inputStream = new ByteArrayInputStream(asnValue.getBytes(StandardCharsets.UTF_8));
    	ASNValueReader asnValueReader = new ASNValueReader(inputStream);
    	
    	MyBitstringList decodedPdu = MyBitstringList.readPdu(asnValueReader);

		assertNotNull(decodedPdu.getValue());
		assertEquals(2, decodedPdu.getValue().size());
		assertTrue(Arrays.equals(item1.toByteArray(), decodedPdu.getValue().get(0).toByteArray()));		
		assertTrue(Arrays.equals(item2.toByteArray(), decodedPdu.getValue().get(1).toByteArray()));		

		StringWriter stringWriter = new StringWriter(100);
		ASNValueWriter asnValueWriter = new ASNValueWriter(new PrintWriter(stringWriter));
		MyBitstringList.writePdu(decodedPdu, asnValueWriter);
		
		assertEquals(asnValue.replaceAll("\\s+",""), stringWriter.toString().replaceAll("\\s+",""));  		
	}
	
	@Test
	public void test_6() throws Exception {

		String asnValue = "{\r\n" + 
				"  apple,\r\n" + 
				"  banana\r\n" + 
				"}";
				
    	InputStream inputStream = new ByteArrayInputStream(asnValue.getBytes(StandardCharsets.UTF_8));
    	ASNValueReader asnValueReader = new ASNValueReader(inputStream);
    	
    	MyEnumeratedList decodedPdu = MyEnumeratedList.readPdu(asnValueReader);

		assertNotNull(decodedPdu.getValue());
		assertEquals(2, decodedPdu.getValue().size());
		assertEquals(MyEnumeration.Enum.APPLE, decodedPdu.getValue().get(0));	
		assertEquals(MyEnumeration.Enum.BANANA, decodedPdu.getValue().get(1));				

		StringWriter stringWriter = new StringWriter(100);
		ASNValueWriter asnValueWriter = new ASNValueWriter(new PrintWriter(stringWriter));
		MyEnumeratedList.writePdu(decodedPdu, asnValueWriter);
		
		assertEquals(asnValue.replaceAll("\\s+",""), stringWriter.toString().replaceAll("\\s+",""));  		
	}

	@Test
	public void test_7() throws Exception {

		String asnValue = "{\r\n" + 
				"  apple,\r\n" + 
				"  orange\r\n" + 
				"}";
				
    	InputStream inputStream = new ByteArrayInputStream(asnValue.getBytes(StandardCharsets.UTF_8));
    	ASNValueReader asnValueReader = new ASNValueReader(inputStream);
    	
    	MyEnumeratedList decodedPdu = new MyEnumeratedList();
    	MyEnumeratedList.read(decodedPdu, asnValueReader);

		assertNotNull(decodedPdu.getValue());
		assertEquals(1, decodedPdu.getValue().size());
		assertEquals(MyEnumeration.Enum.APPLE, decodedPdu.getValue().get(0));	
		// Extensible: we don't understand orange but no exception
	}
	
	@Test
	public void test_8() throws Exception {

		String asnValue = "{\r\n" + 
				"  apple,\r\n" + 
				"  orange\r\n" + 
				"}";
				
    	InputStream inputStream = new ByteArrayInputStream(asnValue.getBytes(StandardCharsets.UTF_8));
    	ASNValueReader asnValueReader = new ASNValueReader(inputStream);
    	
    	MyEnumeratedList2 decodedPdu = new MyEnumeratedList2();
    	
    	boolean hasException = false;
    	
    	try {
    		MyEnumeratedList2.read(decodedPdu, asnValueReader);
    	}
    	catch(Exception e) {
    		hasException = true;
    	}

		assertTrue(hasException);	
		// Not extensible: we don't understand orange and we throw an exception
	}
}