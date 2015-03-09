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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MockServletOutputStreamTest {
	
	MockServletOutputStream outputStream;

	@Before
	public void setUp() throws Exception {
		outputStream = new MockServletOutputStream();
	}

	@Test
	public void testBasic() throws Exception{
		testInitState();
		
		outputStream.write("foo".getBytes());
		Assert.assertTrue( "foo".equals(outputStream.asString()));
		
		outputStream.init();
		testInitState();
		
		outputStream.write("b".getBytes()[0]);
		Assert.assertTrue( "b".equals(outputStream.asString()));
		
		outputStream.init();
		testInitState();
		
		outputStream.write("foo".getBytes(), 1, 1);
		Assert.assertTrue( "o".equals(outputStream.asString()));
		
		outputStream.init();
		testInitState();
		
		outputStream.flush();
		Assert.assertTrue( !outputStream.wasClosed());
		Assert.assertTrue( outputStream.wasFlushed());
		Assert.assertTrue( "".equals(outputStream.asString()));
		
		outputStream.close();
		Assert.assertTrue( outputStream.wasClosed());
		Assert.assertTrue( outputStream.wasFlushed());
		Assert.assertTrue( "".equals(outputStream.asString()));
	}

	protected void testInitState() {
		Assert.assertTrue( !outputStream.wasClosed());
		Assert.assertTrue( !outputStream.wasFlushed());
		Assert.assertTrue( "".equals(outputStream.asString()));
	}

}
