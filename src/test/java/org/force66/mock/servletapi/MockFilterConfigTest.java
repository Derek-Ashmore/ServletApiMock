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

public class MockFilterConfigTest {
	
	MockFilterConfig config;

	@Before
	public void setUp() throws Exception {
		config = new MockFilterConfig();
	}

	@Test
	public void testBasic() throws Exception {
		config.setFilterName("foo");
		Assert.assertTrue("foo".equals(config.getFilterName()));
		
		Assert.assertTrue(!config.getInitParameterNames().hasMoreElements());
		config.addInitParameter("fu", "bar");
		Assert.assertTrue(config.getInitParameterNames().hasMoreElements());
		Assert.assertTrue("bar".equals(config.getInitParameter("fu")));
		
		config.removeInitParameter("fu");
		Assert.assertTrue(!config.getInitParameterNames().hasMoreElements());
	}

}
