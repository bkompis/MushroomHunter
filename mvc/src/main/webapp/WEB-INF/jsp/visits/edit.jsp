<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="Edit visit">
<jsp:attribute name="body">
  <c:set var="end" value="visits"/>

    <form:form method="post" action="${pageContext.request.contextPath}/${end}/edit/${visitEdit.id}"
               modelAttribute="visitEdit" cssClass="form-horizontal">

        <div class="form-group ${note_error?'has-error':''}">
            <form:label path="note" cssClass="col-sm-2 control-label">Visit note</form:label>
            <div class="col-sm-10">
                <form:input path="note" cssClass="form-control"/>
                <form:errors path="note" cssClass="help-block"/>
            </div>
        </div>

        <div class="form-group ${forest_error?'has-error':''}">
            <form:label path="forest" cssClass="col-sm-2 control-label">Forest</form:label>
            <select name="forests">
                <c:forEach items="${forests}" var="forest">
                    <option value="${forest.name}">${forest.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group ${mushrooms_error?'has-error':''}">
            <form:label path="mushrooms" cssClass="col-sm-2 control-label">Mushrooms found</form:label>
            <select name="mushrooms" multiple="multiple">
                <c:forEach items="${mushrooms}" var="mushroom">
                    <option value="${mushroom.name}">${mushroom.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group ${date_error?'has-error':''}">
            <form:label path="mushrooms" cssClass="col-sm-2 control-label">Date of visit</form:label>
            <div class="col-sm-10">
                <form:input path="date" cssClass="form-control"/>
                <form:errors path="date" cssClass="help-block"/>
            </div>
        </div>

      <button class="btn btn-primary" type="submit">Update Visit</button>
    </form:form>

  <button class="btn"
          onclick="location.href='${pageContext.request.contextPath}/${end}'">
      Return
  </button>

</jsp:attribute>
</my:pagetemplate>