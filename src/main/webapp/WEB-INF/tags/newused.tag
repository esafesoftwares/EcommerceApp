<%@ attribute name="productCondition" type="java.lang.Boolean" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose><c:when test="${productCondition}">New</c:when><c:otherwise>Used</c:otherwise></c:choose>
