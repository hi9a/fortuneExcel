<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="excel.title"/></title>
        <html:base/>
    </head>
    <body style="background-color: white">
        <h3><bean:message key="excel.heading"/></h3>
        <p><bean:message key="excel.message"/></p>
        <html:form action="/excelOutput">
            <table border="0">
                <tbody>
                    <tr>
                        <td>おなまえ:</td>
                        <td><html:text property="name" value="name"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><html:submit value="占う" /></td>
                    </tr>
                </tbody>
            </table>
        </html:form>
    </body>
</html:html>
