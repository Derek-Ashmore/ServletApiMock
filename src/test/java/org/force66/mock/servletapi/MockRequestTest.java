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

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MockRequestTest {
	
	MockRequest request;

	@Before
	public void setUp() throws Exception {
		request = new MockRequest();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBasic() throws Exception {
		request.setRequestURI("/foo");
		Assert.assertTrue("/foo".equals(request.getRequestURI()));
		
		request.setMethod("post");
		Assert.assertTrue("post".equals(request.getMethod()));
		
		request.setUri("/context", "/path");
		Assert.assertTrue("/context".equals(request.getContextPath()));
		Assert.assertTrue("/path".equals(request.getPathInfo()));
		Assert.assertTrue("/context/path".equals(request.getRequestURI()));
		
		Assert.assertTrue( !request.getAttributeNames().hasMoreElements());
		request.setAttribute("fu", "bar");
		Assert.assertTrue( request.getAttributeNames().hasMoreElements());
		Assert.assertTrue("bar".equals(request.getAttribute("fu")));
		
		request.removeAttribute("fu");
		Assert.assertTrue( !request.getAttributeNames().hasMoreElements());
		
		request.setHeader("fu", "bar");
		Assert.assertTrue("bar".equals(request.getHeader("fu")));
	}
	
	@Test
	public void testPrependHash() throws Exception {
		Assert.assertTrue("/".equals(request.prependHash(null)));
		Assert.assertTrue("/".equals(request.prependHash("")));
		Assert.assertTrue("/foo".equals(request.prependHash("foo")));
	}

}
