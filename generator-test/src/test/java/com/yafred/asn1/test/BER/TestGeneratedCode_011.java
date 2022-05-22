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
package com.yafred.asn1.test.BER;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import g_011.CardType;
import g_011.CreditCard;
import g_011.Crooked;
import g_011.PaymentMethod;


public class TestGeneratedCode_011 {
	TestHelper testHelper = new TestHelper();

	@Test
	public void test_1() throws Exception {
		PaymentMethod pdu = new PaymentMethod();
		pdu.setCheck("012345678901234");
		
		String expectedHexa = "80 0f 30 31 32 33 34 35 36 37 38 39 30 31 32 33 34";
		testHelper.writePdu(pdu, PaymentMethod.class, expectedHexa);
		
		// decode
		PaymentMethod decodedPdu = (PaymentMethod) testHelper.readPdu(PaymentMethod.class, PaymentMethod.class, expectedHexa);
		assertNotNull(decodedPdu.getCheck());
		assertEquals(decodedPdu.getCheck(), pdu.getCheck());
	}
	
	
	@Test
	public void test_2() throws Exception {
		Crooked pdu = new Crooked();
		pdu.setName("bob");
		
		String expectedHexa = "61 05 16 03 62 6f 62";
		testHelper.writePdu(pdu, Crooked.class, expectedHexa);
		
		// decode
		Crooked decodedPdu = (Crooked) testHelper.readPdu(Crooked.class, Crooked.class, expectedHexa);
		assertNotNull(decodedPdu.getName());
		assertEquals(decodedPdu.getName(), pdu.getName());
	}
	
	
	@Test
	public void test_3() throws Exception {
		PaymentMethod pdu = new PaymentMethod();
		CreditCard credit_card = new CreditCard();
		credit_card.setType(CardType.Enum.CB);
		credit_card.setNumber("01234567890123456789");
		credit_card.setExpiryDate("042018");
		pdu.setCreditCard(credit_card);
		
		String expectedHexa = "a1 21 80 01 00 81 14 30 31 32 33 34 35 36 37 38 39 30 31 32 33 34 35 36 37 38 39 82 06 30 34 32 30 31 38";
		testHelper.writePdu(pdu, PaymentMethod.class, expectedHexa);
		
		// decode
		PaymentMethod decodedPdu = (PaymentMethod) testHelper.readPdu(PaymentMethod.class, PaymentMethod.class, expectedHexa);
		assertNotNull(decodedPdu.getCreditCard());
		assertEquals(decodedPdu.getCreditCard().getNumber(), pdu.getCreditCard().getNumber());
		assertEquals(decodedPdu.getCreditCard().getExpiryDate(), pdu.getCreditCard().getExpiryDate());
		assertEquals(decodedPdu.getCreditCard().getType(), pdu.getCreditCard().getType());
	}
		
	@Test
	public void test_4() throws Exception {
		PaymentMethod pdu = new PaymentMethod();
		pdu.setCash(new Object());
		
		String expectedHexa = "82 00";
		testHelper.writePdu(pdu, PaymentMethod.class, expectedHexa);
		
		// decode
		PaymentMethod decodedPdu = (PaymentMethod) testHelper.readPdu(PaymentMethod.class, PaymentMethod.class, expectedHexa);
		assertNotNull(decodedPdu.getCash());
	}
	
	
}

