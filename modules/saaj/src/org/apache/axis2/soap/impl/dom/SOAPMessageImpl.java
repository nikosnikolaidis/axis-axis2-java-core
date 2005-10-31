/*
 * Copyright 2004,2005 The Apache Software Foundation.
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

package org.apache.axis2.soap.impl.dom;

import org.apache.axis2.om.OMElement;
import org.apache.axis2.om.OMNode;
import org.apache.axis2.om.OMXMLParserWrapper;
import org.apache.axis2.om.impl.OMOutputImpl;
import org.apache.axis2.om.impl.dom.DocumentImpl;
import org.apache.axis2.soap.SOAPEnvelope;
import org.apache.axis2.soap.SOAPMessage;
import org.apache.axis2.soap.SOAPProcessingException;

import javax.xml.stream.XMLStreamException;

public class SOAPMessageImpl extends DocumentImpl implements SOAPMessage {

    public SOAPMessageImpl() {
    }

    public SOAPMessageImpl(SOAPEnvelope envelope, OMXMLParserWrapper parserWrapper) {
    	this(parserWrapper);
    	this.setSOAPEnvelope(envelope);
    }

    public SOAPMessageImpl(OMXMLParserWrapper parserWrapper) {
        super(parserWrapper);
    }


    public SOAPEnvelope getSOAPEnvelope() throws SOAPProcessingException {
        return (SOAPEnvelope) getOMDocumentElement();
    }

    public void setSOAPEnvelope(SOAPEnvelope envelope) throws SOAPProcessingException {
    	if(this.getDocumentElement() != null) {
    		this.replaceChild(this.getDocumentElement(), (SOAPEnvelopeImpl)envelope);
    	} else {
    		this.appendChild((SOAPEnvelopeImpl)envelope);
    	}
    }

    public void setOMDocumentElement(OMElement rootElement) {
        throw new UnsupportedOperationException("This is not allowed. Use set SOAPEnvelope instead");
    }

    public void addChild(OMNode child) {
        throw new UnsupportedOperationException("Can not add normal children to SOAP envelope. Use setSOAPEnvelope()");
    }


    public void setFirstChild(OMNode firstChild) {
        throw new UnsupportedOperationException("This is not allowed. Use set SOAPEnvelope instead");
    }

    protected void serialize(OMOutputImpl omOutput, boolean cache, boolean includeXMLDeclaration) throws XMLStreamException {
        if (cache) {
            ((OMElement)this.ownerNode.getDocumentElement()).serialize(omOutput);
        } else {
        	((OMElement)this.ownerNode.getDocumentElement()).serializeAndConsume(omOutput);
        }
    }
}
