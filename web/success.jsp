<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    <body style="background-color: white">
                
        <h3><bean:message key="welcome.heading"/></h3>
        <p><bean:message key="welcome.message"/></p>
        <table border="0">
            <tbody>
                <tr>
                    <td>Your name:</td>
                    <td><bean:write name="LoginForm" property="name" /></td>
                </tr>
                <tr>
                    <td>Your email:</td>
                    <td><bean:write name="LoginForm" property="email" /></td>
                </tr>
            </tbody>
        </table>
        <html:link action="/excel"> excel output </html:link>
    </body>
</html:html>
