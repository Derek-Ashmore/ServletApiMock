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

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

/**
 * Mock implementation for javax.servlet.ServletOutputStream.
 * @author D. Ashmore
 *
 */
public class MockServletOutputStream extends ServletOutputStream {
    
    private ByteArrayOutputStream outputStream;
    private boolean wasFlushed;
    private boolean wasClosed;
    
    public MockServletOutputStream() {
    	this.init();
    }
    
    /**
     * Re-initializes the output stream
     */
    public void init() {
    	wasFlushed = false;
    	wasClosed = false;
    	outputStream = new ByteArrayOutputStream();
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);

    }
    
    public byte[] getBytes() {
        return outputStream.toByteArray();
    }
    
    public String asString() {
    	return outputStream.toString();
    }

	@Override
	public boolean isReady() {
		return true;
	}

	@Override
	public void setWriteListener(WriteListener writeListener) {
		
	}

	@Override
	public void write(byte[] b) throws IOException {
		super.write(b);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		outputStream.write(b, off, len);
	}

	@Override
	public void flush() throws IOException {
		wasFlushed = true;
		outputStream.flush();
	}
	
	public boolean wasFlushed() {
		return wasFlushed;
	}

	@Override
	public void close() throws IOException {
		wasClosed = true;
		outputStream.close();
	}
	
	public boolean wasClosed() {
		return wasClosed;
	}

}
