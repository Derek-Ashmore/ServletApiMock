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
import java.util.Properties;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;

/**
 * Mock implementation for javax.servlet.FilterConfig.
 * @author D. Ashmore
 *
 */
public class MockFilterConfig implements FilterConfig {
    
	private String filterName = "MockFilter";
    private Properties initParms = new Properties();

    /* (non-Javadoc)
     * @see javax.servlet.FilterConfig#getFilterName()
     */
    public String getFilterName() {
         return filterName;
    }

    /* (non-Javadoc)
     * @see javax.servlet.FilterConfig#getInitParameter(java.lang.String)
     */
    public String getInitParameter(String parm) {
        return initParms.getProperty(parm);
    }
    
    public void addInitParameter(String parm, String value) {
        initParms.setProperty(parm, value);
    }
    
    public void removeInitParameter(String parm) {
    	initParms.remove(parm);
    }

    /* (non-Javadoc)
     * @see javax.servlet.FilterConfig#getInitParameterNames()
     */
    public Enumeration getInitParameterNames() {
        return initParms.keys();
    }

    /* (non-Javadoc)
     * @see javax.servlet.FilterConfig#getServletContext()
     */
    public ServletContext getServletContext() {
        throw new UnsupportedOperationException("getServletContext() not yet supported");
    }

	protected void setFilterName(String filterName) {
		this.filterName = filterName;
	}

}
