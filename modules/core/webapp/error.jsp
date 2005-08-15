<%--
 /*
* Copyright 2004,2005 The Apache Software Foundation.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*
*
*/

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<html>
  <head><title>Error !</title></head>
  <body>
  <jsp:include page="include/header.inc"></jsp:include>
  <table>
  <tr>
  <td align="center">An error has occured!. Please check the details below</td>
  </tr>
  <tr>
  <td align="center"><%=exception.getMessage()%></td>
  </tr>
  </table>
<jsp:include page="include/footer.inc"></jsp:include>
</body>
</html>