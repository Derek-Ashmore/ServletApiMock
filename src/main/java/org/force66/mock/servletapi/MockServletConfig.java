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

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.commons.collections4.iterators.IteratorEnumeration;

/**
 * javax.servlet.ServletConfig
 * @author D. Ashmore
 *
 */
public class MockServletConfig implements ServletConfig {
	
	private String servletName;
	private Map<String,String> initParmMap = new HashMap<String,String>();
	private ServletContext servletContext;
	
	public MockServletConfig() {
		init();
	}
	
	public void init() {
		servletName="testServlet";
		initParmMap = new HashMap<String,String>();
		servletContext = new MockServletContext();
	}

	public String getServletName() {
		return servletName;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public String getInitParameter(String name) {
		return initParmMap.get(name);
	}

	public Enumeration<String> getInitParameterNames() {

		return new IteratorEnumeration<String>(initParmMap.keySet().iterator());
	}
	
	public Map<String, String> getInitParmMap() {
		return initParmMap;
	}

	public void setServletName(String servletName) {
		this.servletName = servletName;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
