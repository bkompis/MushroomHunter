<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" dynamic-attributes="attr" %>
<%@attribute name="listName" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>

<c:set var="forests_path" value="forests"/>

<select name="item">
    <c:forEach items="${forests}" var="forest">
        <option value="${forest.name}">${forest.name}</option>
    </c:forEach>
</select>
