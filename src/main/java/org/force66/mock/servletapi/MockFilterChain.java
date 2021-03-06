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

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.Validate;

/**
 * Mock implementation for javax.servlet.FilterChain.
 * @author D. Ashmore
 *
 */
public class MockFilterChain implements FilterChain {
    
    private RuntimeException runtimeException = null;
    private IOException ioException = null;
    private ServletException servletException = null;
    
    private byte[] outputData = null;
    private String contentType = null;
    
    private long sleepTimeInMillis = 0;

    public void doFilter(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
    	Validate.notNull(request, "Null request not allowed.");
    	Validate.notNull(response, "Null response not allowed.");
    	
        if (this.runtimeException != null) {
            throw this.runtimeException;
        }
        if (this.ioException != null) {
            throw this.ioException;
        }
        if (this.servletException != null) {
            throw this.servletException;
        }
        
        try {Thread.sleep(sleepTimeInMillis);}
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        if (contentType != null) {
            response.setContentType(contentType);
        }
        if (outputData != null) {
            response.setContentLength(outputData.toString().length());
            response.getOutputStream().write(outputData);
        }
        
        if (response.getOutputStream() != null) {
            response.getOutputStream().flush();
            response.getOutputStream().close();
        }

    }

    public void setRuntimeException(RuntimeException runtimeException) {
        this.runtimeException = runtimeException;
    }

    public void setIoException(IOException ioException) {
        this.ioException = ioException;
    }

    public void setServletException(ServletException servletException) {
        this.servletException = servletException;
    }

    public long getSleepTimeInMillis() {
        return sleepTimeInMillis;
    }

    public void setSleepTimeInMillis(long sleepTimeInMillis) {
        this.sleepTimeInMillis = sleepTimeInMillis;
    }

    public byte[] getOutputData() {
        return outputData;
    }

    public void setOutputData(byte[] outputData) {
        this.outputData = outputData;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }


}
