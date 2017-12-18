<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" dynamic-attributes="attr" %>
<%@attribute name="listName" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<select name="mushrooms" multiple="multiple">
    <c:forEach items="${mushrooms}" var="mushroom">
        <option value="${mushroom.name}">${mushroom.name}</option>
    </c:forEach>
</select>

