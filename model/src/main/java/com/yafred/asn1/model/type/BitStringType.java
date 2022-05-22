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
package com.yafred.asn1.model.type;

import java.util.ArrayList;

import com.yafred.asn1.model.NamedNumber;
import com.yafred.asn1.model.Tag;
import com.yafred.asn1.model.TagClass;
import com.yafred.asn1.model.Type;


public class BitStringType extends Type {

	private ArrayList<NamedNumber> namedBitList = null;
	
	public BitStringType() {
    }

	public BitStringType(ArrayList<NamedNumber> namedBitList) {
        this.namedBitList = namedBitList;
    }

    public void setNamedBitList(ArrayList<NamedNumber> namedBitList) {
        this.namedBitList = namedBitList;
    }

    public ArrayList<NamedNumber> getNamedBitList() {
		return namedBitList;
	}

	@Override
	public boolean isBitStringType() {
        return true;
    }

    @Override
	public Tag getUniversalTag() {
        return new Tag(Integer.valueOf(3), TagClass.UNIVERSAL_TAG, null);
    }
    
	@Override
	public String getName() {
		return ("BIT STRING");
	}
}
