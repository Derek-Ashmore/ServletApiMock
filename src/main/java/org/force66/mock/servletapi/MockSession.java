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

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.apache.commons.collections4.iterators.IteratorEnumeration;


/**
 * Mock implementation for javax.servlet.http.HttpSession
 * @author D. Ashmore
 *
 */
public class MockSession implements HttpSession {
    
    Map<String,Object> attributeMap;
    Map<String,Object> valueMap;
    long creationTime;
    
    public MockSession() {
    	init();
    }
    
    /**
     * Re-initializes the mock session.
     */
    public void init() {
    	attributeMap = new HashMap<String,Object>();
    	valueMap = new HashMap<String,Object>();
    	creationTime = System.currentTimeMillis();
    }
 
    public Object getAttribute(String attr) {
        return attributeMap.get(attr);
    }

    public Enumeration getAttributeNames() {
        return new IteratorEnumeration(attributeMap.keySet().iterator());
    }

    public long getCreationTime() {
        return creationTime;
    }

    public String getId() {
        throw new UnsupportedOperationException("getId() not supported");
    }

    public long getLastAccessedTime() {
    	throw new UnsupportedOperationException("getLastAccessedTime() not supported");
    }

    public int getMaxInactiveInterval() {
    	throw new UnsupportedOperationException("getMaxInactiveInterval() not supported");
    }

    public ServletContext getServletContext() {
    	throw new UnsupportedOperationException("getServletContext() not supported");
    }

    public HttpSessionContext getSessionContext() {
    	throw new UnsupportedOperationException("getSessionContext() not supported");
    }

    public Object getValue(String key) {
        return valueMap.get(key);
    }

    public String[] getValueNames() {
        return valueMap.keySet().toArray(new String[0]);
    }

    public void invalidate() {
    	throw new UnsupportedOperationException("invalidate() not supported");

    }

    public boolean isNew() {
    	throw new UnsupportedOperationException("isNew() not supported");
    }

    public void putValue(String key, Object value) {
        valueMap.put(key, value);

    }

    public void removeAttribute(String key) {
        attributeMap.remove(key);

    }

    public void removeValue(String key) {
        valueMap.remove(key);

    }

    public void setAttribute(String key, Object value) {
        attributeMap.put(key, value);

    }

    public void setMaxInactiveInterval(int arg0) {
    	throw new UnsupportedOperationException("setMaxInactiveInterval() not supported");

    }

}
