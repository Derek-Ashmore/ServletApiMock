# ServletApiMock
*** Under Construction ***  This is a testing library that provides mocks for the Servlet API.

Basically, using EasyMock or Mockito to mock commonly used objects, like those in the servlet api, is a real pain.  I've developed this library over a period of years for my other projects and copied selected portions of it around.  I'm tired of doing that and just want to "include" it in future projects.

I haven't released it previously as it is primitive.  It only contains features that I've personally needed for my projects and isn't yet a complete solution.  There are far too many 'UnsupportedOperationExceptions' for comfort.

The following Servlet-api interfaces are mocked:  
| Class                      | Implemented Interface	              |  
| -------------------------- | -------------------------------------- |  
| MockFilterChain            | javax.servlet.FilterChain              |  
| MockFilterConfig           | javax.servlet.FilterConfig             |  
| MockRequest                | javax.servlet.HttpServletRequest       |  
| MockResponse               | javax.servlet.HttpServletResponse      |  
| MockServletOutputStream    | javax.servlet.ServletOutputStream      |  
| MockSession                | javax.servlet.HttpSession              |  
