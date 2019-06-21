<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:hasBindErrors name="student">
	<c:forEach var="error" items="${errors.allErrors}">
		<b><spring:message message="${error}" /></b>
		<br />
	</c:forEach>
    </spring:hasBindErrors>