<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="Register new Visit">
<jsp:attribute name="body">

    <form:form method="post" action="${pageContext.request.contextPath}/visits/create/"
               modelAttribute="registerVisit" cssClass="form-horizontal">

        <div class="form-group ${firstName_error?'has-error':''}">
            <form:label path="note" cssClass="col-sm-2 control-label">Note</form:label>
            <div class="col-sm-10">
                <form:input path="note" cssClass="form-control"/>
                <form:errors path="note" cssClass="help-block"/>
            </div>
        </div>

        <div class="form-group ${firstName_error?'has-error':''}">
            <form:label path="forest" cssClass="col-sm-2 control-label">Forest</form:label>
            <div class="col-sm-10">
                <form:input path="forest" cssClass="form-control"/>
                <form:errors path="forest" cssClass="help-block"/>
            </div>
        </div>

        <div class="form-group ${firstName_error?'has-error':''}">
            <select name="types" size="5">
                <c:forEach items="${report.list}" var="type">
                    <option value="${type}">${type}</option>
                </c:forEach>
            </select>
        </div>

        <pre>
            <my:forest_template listName="forests"/>
        </pre>

      <button class="btn btn-primary" type="submit">Register new visit</button>
    </form:form>

</jsp:attribute>
</my:pagetemplate>