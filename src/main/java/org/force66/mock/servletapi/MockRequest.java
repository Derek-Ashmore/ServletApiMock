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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

import org.apache.commons.collections4.iterators.IteratorEnumeration;

/**
 * Mock implementation for javax.servlet.http.HttpServletRequest
 * @author D. Ashmore
 *
 */
public class MockRequest implements HttpServletRequest {
    
    Map<String,Object> attributeMap = new HashMap<String,Object>();
    Map<String,String> parameterMap = new HashMap<String,String>();
    Map<String,String> headerMap = new HashMap<String,String>();
    
    HttpSession session= new MockSession();
    String requestURI = "/myApp/jmu";
    String pathInfo = "/jmu";
    String contextPath = "/myApp";
    String method = "get";
    
    public MockRequest() {
    	this.init();
    }
    
    /**
     * Re-initializes request
     */
    public void init() {
    	attributeMap = new HashMap<String,Object>();
    	parameterMap = new HashMap<String,String>();
    	headerMap = new HashMap<String,String>();
    }
    
    public void setUri(String contextPath, String pathInfo) {
    	this.contextPath = prependHash(contextPath);
    	this.pathInfo = prependHash(pathInfo);
    	requestURI = this.contextPath + this.pathInfo;
    }
    
    protected String prependHash(String value) {
    	if (value == null)   return "/";
    	if (value != null && value.startsWith("/"))   return value;
    	return "/"+value;
    }

    public Object getAttribute(String key) {
        return attributeMap.get(key);
    }
    
    public Enumeration getAttributeNames() {
         return new IteratorEnumeration(attributeMap.keySet().iterator());
    }

    public String getCharacterEncoding() {
        throw new UnsupportedOperationException("getCharacterEncoding() not supported");
    }

    public int getContentLength() {
    	throw new UnsupportedOperationException("getContentLength() not supported");
    }

    public String getContentType() {
    	throw new UnsupportedOperationException("getContentType() not supported");
    }

    public ServletInputStream getInputStream() throws IOException {
    	throw new UnsupportedOperationException("getInputStream() not supported");
    }

    public String getLocalAddr() {
    	throw new UnsupportedOperationException("getLocalAddr() not supported");
    }

    public String getLocalName() {
    	throw new UnsupportedOperationException("getLocalName() not supported");
    }

    public int getLocalPort() {
    	throw new UnsupportedOperationException("getLocalPort() not supported");
    }

    public Locale getLocale() {
    	throw new UnsupportedOperationException("getLocale() not supported");
    }

    public Enumeration getLocales() {
    	throw new UnsupportedOperationException("getLocales() not supported");
    }

    public String getParameter(String arg0) {
        return this.parameterMap.get(arg0);
    }

    public Map getParameterMap() {
        return this.parameterMap;
    }

    public Enumeration getParameterNames() {
        return new IteratorEnumeration(this.parameterMap.keySet().iterator());
    }

    public String[] getParameterValues(String arg0) {
    	throw new UnsupportedOperationException("getParameterValues() not supported");
    }

    public String getProtocol() {
    	throw new UnsupportedOperationException("getProtocol() not supported");
    }

    public BufferedReader getReader() throws IOException {
    	throw new UnsupportedOperationException("getReader() not supported");
    }

    public String getRealPath(String arg0) {
    	throw new UnsupportedOperationException("getRealPath() not supported");
    }

    public String getRemoteAddr() {
    	throw new UnsupportedOperationException("getRemoteAddr() not supported");
    }

    public String getRemoteHost() {
    	throw new UnsupportedOperationException("getRemoteHost() not supported");
    }

    public int getRemotePort() {
    	throw new UnsupportedOperationException("getRemotePort() not supported");
    }

    public RequestDispatcher getRequestDispatcher(String arg0) {
    	throw new UnsupportedOperationException("getRequestDispatcher() not supported");
    }

    public String getScheme() {
    	throw new UnsupportedOperationException("getScheme() not supported");
    }

    public String getServerName() {
    	throw new UnsupportedOperationException("getServerName() not supported");
    }

    public int getServerPort() {
    	throw new UnsupportedOperationException("getServerPort() not supported");
    }

    public boolean isSecure() {
    	throw new UnsupportedOperationException("isSecure() not supported");
    }

    public void removeAttribute(String key) {
        attributeMap.remove(key);

    }

    public void setAttribute(String key, Object value) {
        attributeMap.put(key, value);

    }
    
    public void removePArameter(String key) {
    	parameterMap.remove(key);

    }

    public void setParameter(String key, String value) {
    	parameterMap.put(key, value);

    }

    public void setCharacterEncoding(String arg0)
            throws UnsupportedEncodingException {
    	throw new UnsupportedOperationException("setCharacterEncoding() not supported");

    }

    public String getAuthType() {
    	throw new UnsupportedOperationException("getAuthType() not supported");
    }

    public String getContextPath() {
        return contextPath;
    }

    public Cookie[] getCookies() {
    	throw new UnsupportedOperationException("getCookies() not supported");
    }

    public long getDateHeader(String arg0) {
    	throw new UnsupportedOperationException("getDateHeader() not supported");
    }

    public String getHeader(String header) {
        return headerMap.get(header);
    }
    
    public void setHeader(String header, String value) {
    	headerMap.put(header, value);
    }

    public Enumeration getHeaderNames() {
    	throw new UnsupportedOperationException("getHeaderNames() not supported");
    }

    public Enumeration getHeaders(String arg0) {
    	throw new UnsupportedOperationException("getHeaders() not supported");
    }

    public int getIntHeader(String arg0) {
    	throw new UnsupportedOperationException("getIntHeader() not supported");
    }

    public String getMethod() {
        return method;
    }
    
    public void setMethod(String method) {
        this.method = method;
    }

    public String getPathInfo() {
        return pathInfo;
    }

    public String getPathTranslated() {
    	throw new UnsupportedOperationException("getPathTranslated() not supported");
    }

    public String getQueryString() {
    	throw new UnsupportedOperationException("getQueryString() not supported");
    }

    public String getRemoteUser() {
    	throw new UnsupportedOperationException("getRemoteUser() not supported");
    }

    public String getRequestURI() {
        return requestURI;
    }

    public StringBuffer getRequestURL() {
    	throw new UnsupportedOperationException("getRequestURL() not supported");
    }

    public String getRequestedSessionId() {
    	throw new UnsupportedOperationException("getRequestedSessionId() not supported");
    }

    public String getServletPath() {
    	throw new UnsupportedOperationException("getServletPath() not supported");
    }

    public HttpSession getSession() {
        return session;
    }

    public HttpSession getSession(boolean arg0) {
         return session;
    }

    public Principal getUserPrincipal() {
    	throw new UnsupportedOperationException("getUserPrincipal() not supported");
    }

    public boolean isRequestedSessionIdFromCookie() {
    	throw new UnsupportedOperationException("isRequestedSessionIdFromCookie() not supported");
    }

    public boolean isRequestedSessionIdFromURL() {
    	throw new UnsupportedOperationException("isRequestedSessionIdFromURL() not supported");
    }

    public boolean isRequestedSessionIdFromUrl() {
    	throw new UnsupportedOperationException("isRequestedSessionIdFromUrl() not supported");
    }

    public boolean isRequestedSessionIdValid() {
    	throw new UnsupportedOperationException("isRequestedSessionIdValid() not supported");
    }

    public boolean isUserInRole(String arg0) {
    	throw new UnsupportedOperationException("isUserInRole() not supported");
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

	public long getContentLengthLong() {
		throw new UnsupportedOperationException("getContentLengthLong() not supported");
	}

	public ServletContext getServletContext() {
		throw new UnsupportedOperationException("getServletContext() not supported");
	}

	public AsyncContext startAsync() throws IllegalStateException {
		throw new UnsupportedOperationException("startAsync() not supported");
	}

	public AsyncContext startAsync(ServletRequest servletRequest,
			ServletResponse servletResponse) throws IllegalStateException {
		throw new UnsupportedOperationException("startAsync() not supported");
	}

	public boolean isAsyncStarted() {
		throw new UnsupportedOperationException("isAsyncStarted() not supported");
	}

	public boolean isAsyncSupported() {
		return false;
	}

	public AsyncContext getAsyncContext() {
		throw new UnsupportedOperationException("getAsyncContext() not supported");
	}

	public DispatcherType getDispatcherType() {
		throw new UnsupportedOperationException("getDispatcherType() not supported");
	}

	public String changeSessionId() {
		throw new UnsupportedOperationException("changeSessionId() not supported");
	}

	public boolean authenticate(HttpServletResponse response)
			throws IOException, ServletException {
		throw new UnsupportedOperationException("authenticate() not supported");
	}

	public void login(String username, String password) throws ServletException {
		throw new UnsupportedOperationException("login() not supported");
		
	}

	public void logout() throws ServletException {
		throw new UnsupportedOperationException("logout() not supported");
		
	}

	public Collection<Part> getParts() throws IOException, ServletException {
		throw new UnsupportedOperationException("getParts() not supported");
	}

	public Part getPart(String name) throws IOException, ServletException {
		throw new UnsupportedOperationException("getPart() not supported");
	}

	public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass)
			throws IOException, ServletException {
		throw new UnsupportedOperationException("upgrade() not supported");
	}

	public void setPathInfo(String pathInfo) {
		this.pathInfo = pathInfo;
	}

}
