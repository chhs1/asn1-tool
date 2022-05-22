/*******************************************************************************
 * Copyright (C) 2022 Fred D7e (https://github.com/yafred)
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
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import com.yafred.asn1.runtime.ASNValueReader;
import com.yafred.asn1.runtime.ASNValueWriter;

import org.junit.Test;

import g_014.Audience;



public class TestGeneratedCode_014 {

	@Test
	public void test_1() throws Exception {
		String asnValue = "{\r\n" + 
				"  {\r\n" + 
				"    last-name \"Doe\",\r\n" + 
				"    first-name \"John\",\r\n" + 
				"    age 35\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    last-name \"Dalton\",\r\n" + 
				"    first-name \"Joe\",\r\n" + 
				"    age 30\r\n" + 
				"  }\r\n" + 
				"}";
				
    	InputStream inputStream = new ByteArrayInputStream(asnValue.getBytes(StandardCharsets.UTF_8));
    	ASNValueReader asnValueReader = new ASNValueReader(inputStream);
    	
    	Audience decodedPdu = Audience.readPdu(asnValueReader);

		assertNotNull(decodedPdu.getValue());
		assertEquals(2, decodedPdu.getValue().size());
		assertEquals("Doe", decodedPdu.getValue().get(0).getLastName());		
		assertEquals("Joe", decodedPdu.getValue().get(1).getFirstName());		

		StringWriter stringWriter = new StringWriter(100);
		ASNValueWriter asnValueWriter = new ASNValueWriter(new PrintWriter(stringWriter));
		Audience.writePdu(decodedPdu, asnValueWriter);
		
		assertEquals(asnValue.replaceAll("\\s+",""), stringWriter.toString().replaceAll("\\s+","")); 
	}
	
	@Test
	public void test_2() throws Exception {
		String asnValue = "{}";
				
    	InputStream inputStream = new ByteArrayInputStream(asnValue.getBytes(StandardCharsets.UTF_8));
    	ASNValueReader asnValueReader = new ASNValueReader(inputStream);
    	
    	Audience decodedPdu = Audience.readPdu(asnValueReader);

		assertNotNull(decodedPdu.getValue());
		assertEquals(0, decodedPdu.getValue().size());
		
		StringWriter stringWriter = new StringWriter(100);
		ASNValueWriter asnValueWriter = new ASNValueWriter(new PrintWriter(stringWriter));
		Audience.writePdu(decodedPdu, asnValueWriter);
		
		assertEquals(asnValue.replaceAll("\\s+",""), stringWriter.toString().replaceAll("\\s+","")); 		
	}

}