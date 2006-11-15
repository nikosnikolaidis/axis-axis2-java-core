/*
 * Copyright 2004,2005 The Apache Software Foundation.
 * Copyright 2006 International Business Machines Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.axis2.jaxws.message.util;

import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;

/**
 * ResettableReader
 * A resettable XMLStreamReader.  
 * @see org.apache.axis2.jaxws.util.Reader
 */
public class ResettableReader extends Reader {

	OMElement omElement = null;
	
	/** 
	 * Create resettable XMLStreamReader
	 * @param reader
	 * @param resettable
	 */
	public ResettableReader(XMLStreamReader reader) {
		super(reader, true);
		StAXOMBuilder builder = new StAXOMBuilder(reader);  
		omElement = builder.getDocumentElement();
		reset();
	}

	/* (non-Javadoc)
	 * @see org.apache.axis2.jaxws.message.util.Reader#newReader()
	 */
	@Override
	protected XMLStreamReader newReader() {
		return omElement.getXMLStreamReader();
	}

}
