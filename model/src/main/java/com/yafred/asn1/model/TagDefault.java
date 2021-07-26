/*******************************************************************************
 * Copyright (C) 2021 Fred D7e (https://github.com/yafred)
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
package com.yafred.asn1.model;

/**
 * Tagging default of a module
 * @see ModuleDefinition
 */
public class TagDefault  {
    public static final TagDefault EXPLICIT_TAGS = new TagDefault();
    public static final TagDefault IMPLICIT_TAGS = new TagDefault();
    public static final TagDefault AUTOMATIC_TAGS = new TagDefault();

    private TagDefault() {
    }

    @Override
	public String toString() {
        if (this == EXPLICIT_TAGS) {
            return "EXPLICIT";
        } else if (this == IMPLICIT_TAGS) {
            return "IMPLICIT";
        } else if (this == AUTOMATIC_TAGS) {
            return "AUTOMATIC";
        } else {
            return ""; // cannot occur
        }
    }
}
