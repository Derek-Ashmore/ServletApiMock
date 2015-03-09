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

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MockFilterChainTest {
	
	MockFilterChain filterChain;
	MockRequest request;
	MockResponse response;

	@Before
	public void setUp() throws Exception {
		filterChain = new MockFilterChain();
		request = new MockRequest();
		response = new MockResponse();
	}

	@Test
	public void testBasic() throws Exception {
		Assert.assertTrue(doFilter(null, null) != null);
		Assert.assertTrue(doFilter(request, null) != null);
		Assert.assertTrue(doFilter(null, response) != null);
		Assert.assertTrue(doFilter(request, response) == null);
		
		RuntimeException runEx = new RuntimeException("crap");
		filterChain.setRuntimeException(runEx);
		Assert.assertTrue(runEx.equals(doFilter(request, response)) );
		filterChain.setRuntimeException(null);
		
		IOException ioEx = new IOException("crap");
		filterChain.setIoException(ioEx);
		Assert.assertTrue(ioEx.equals(doFilter(request, response)) );
		filterChain.setIoException(null);
		
		ServletException sEx = new ServletException("crap");
		filterChain.setServletException(sEx);
		Assert.assertTrue(sEx.equals(doFilter(request, response)) );
		filterChain.setServletException(null);
		
		filterChain.setContentType("text/html");
		filterChain.doFilter(request, response);
		Assert.assertTrue("text/html".equals(response.getContentType()));
		Assert.assertTrue(response.streamWasFlushed());
		Assert.assertTrue(response.streamWasClosed());
		response.init();
		
		filterChain.setOutputData("Derek".getBytes());
		filterChain.doFilter(request, response);
		Assert.assertTrue("text/html".equals(response.getContentType()));
		Assert.assertTrue("Derek".equals(response.getResponseContent()));
		Assert.assertTrue(response.streamWasFlushed());
		Assert.assertTrue(response.streamWasClosed());
		response.init();
	}
	
	private Throwable doFilter(ServletRequest request, ServletResponse response) {
		try {filterChain.doFilter(request, response);}
		catch (Exception e) {
			return e;
		}
		
		return null;
	}

}
