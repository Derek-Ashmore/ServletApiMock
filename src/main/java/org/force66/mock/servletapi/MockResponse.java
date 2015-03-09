/*
 * This software is licensed under the Apache License, Version 2.0
 * (the "License") agreement; you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.force66.mock.servletapi;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Mock implementation of javax.servlet.http.HttpServletResponse
 * @author D. Ashmore
 *
 */
public class MockResponse implements HttpServletResponse {
    
    private String contentType;
    private MockServletOutputStream outputStream ;
    private int contentLength;
    
    public MockResponse() {
    	this.init();
    }
    
    public void init() {
    	outputStream = new MockServletOutputStream();
    	contentType = null;
    	contentLength = 0;
    }
    
    public boolean streamWasFlushed() {
    	return outputStream.wasFlushed();
    }
    
    public boolean streamWasClosed() {
    	return outputStream.wasClosed();
    }
    
    public MockServletOutputStream getMockServletOutputStream() {
        return (MockServletOutputStream)outputStream;
    }

    public void flushBuffer() throws IOException {
        throw new UnsupportedOperationException("flushBuffer() not supported");

    }
    
    public String getResponseContent() {
    	return getMockServletOutputStream().asString().toString();
    }

    public int getBufferSize() {
    	throw new UnsupportedOperationException("flushBuffer() not supported");
    }

    public String getCharacterEncoding() {
        return Charset.defaultCharset().name();
    }

    public String getContentType() {
         return contentType;
    }

    public Locale getLocale() {
    	throw new UnsupportedOperationException("flushBuffer() not supported");
    }

    public ServletOutputStream getOutputStream() throws IOException {
        return outputStream;
    }

    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(new OutputStreamWriter(outputStream));
    }

    public boolean isCommitted() {
    	throw new UnsupportedOperationException("isCommitted() not supported");
    }

    public void reset() {
    	throw new UnsupportedOperationException("reset() not supported");

    }

    public void resetBuffer() {
    	throw new UnsupportedOperationException("resetBuffer() not supported");

    }

    public void setBufferSize(int arg0) {
    	throw new UnsupportedOperationException("setBufferSize() not supported");

    }

    public void setCharacterEncoding(String arg0) {
    	throw new UnsupportedOperationException("setCharacterEncoding() not supported");

    }

    public void setContentLength(int arg0) {
    	this.contentLength = arg0;

    }

    public void setContentType(String contentType) {
        this.contentType = contentType;

    }

    public void setLocale(Locale arg0) {
    	throw new UnsupportedOperationException("setLocale() not supported");

    }

    public void addCookie(Cookie arg0) {
    	throw new UnsupportedOperationException("addCookie() not supported");

    }

    public void addDateHeader(String arg0, long arg1) {
    	throw new UnsupportedOperationException("addDateHeader() not supported");

    }

    public void addHeader(String arg0, String arg1) {
    	throw new UnsupportedOperationException("addHeader() not supported");

    }

    public void addIntHeader(String arg0, int arg1) {
    	throw new UnsupportedOperationException("addIntHeader() not supported");

    }

    public boolean containsHeader(String arg0) {
    	throw new UnsupportedOperationException("containsHeader() not supported");
    }

    public String encodeRedirectURL(String arg0) {
    	throw new UnsupportedOperationException("encodeRedirectURL() not supported");
    }

    public String encodeRedirectUrl(String arg0) {
    	throw new UnsupportedOperationException("encodeRedirectUrl() not supported");
    }

    public String encodeURL(String arg0) {
    	throw new UnsupportedOperationException("encodeURL() not supported");
    }

    public String encodeUrl(String arg0) {
    	throw new UnsupportedOperationException("encodeUrl() not supported");
    }

    public void sendError(int arg0) throws IOException {
    	throw new UnsupportedOperationException("sendError() not supported");

    }

    public void sendError(int arg0, String arg1) throws IOException {
    	throw new UnsupportedOperationException("sendError() not supported");

    }

    public void sendRedirect(String arg0) throws IOException {
    	throw new UnsupportedOperationException("sendRedirect() not supported");

    }

    public void setDateHeader(String arg0, long arg1) {
    	throw new UnsupportedOperationException("setDateHeader() not supported");

    }

    public void setHeader(String arg0, String arg1) {
    	throw new UnsupportedOperationException("setHeader() not supported");

    }

    public void setIntHeader(String arg0, int arg1) {
    	throw new UnsupportedOperationException("setIntHeader() not supported");

    }

    public void setStatus(int arg0) {
    	throw new UnsupportedOperationException("setStatus() not supported");

    }

    public void setStatus(int arg0, String arg1) {
    	throw new UnsupportedOperationException("setStatus() not supported");

    }

	public void setContentLengthLong(long len) {
		throw new UnsupportedOperationException("setContentLengthLong() not supported");
		
	}

	public int getStatus() {
		throw new UnsupportedOperationException("getStatus() not supported");
	}

	public String getHeader(String name) {
		throw new UnsupportedOperationException("getHeader() not supported");
	}

	public Collection<String> getHeaders(String name) {
		throw new UnsupportedOperationException("getHeaders() not supported");
	}

	public Collection<String> getHeaderNames() {
		throw new UnsupportedOperationException("getHeaderNames() not supported");
	}

	public int getContentLength() {
		return contentLength;
	}

}
