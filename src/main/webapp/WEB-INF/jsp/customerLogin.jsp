<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/template/header.jsp" %>
  
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
        <h3> Customer Login Page</h3>
        
            <p class="lead">Enter Registered PhoneNumber and Password</p>
        </div>
        <c:if test="${param.error == 'true'}">
           <div style="color: red; margin: 10px 0px;">
 
               Login Failed!!!<br /> 
               ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
 
           </div>
       </c:if>

        <form:form action="${pageContext.request.contextPath}/j_spring_security_check" method="POST" modelAttribute="customer1"> 
                    
        <div class="form-group">
            <label for="name">Entered Registered PhoneNumber</label>
            <form:input path="userName" id="name" class="form-Control"/>
     </div>
        <div class="form-group">
            <label for="pass">Password</label>
            <form:input path="password" id="pass" class="form-Control"/>
           </div>
        <br><br>
        <input type="submit" value="submit" class="btn btn-primary">
        <input type="reset" value="reset" class="btn btn-primary">
        </form:form>
        <span class="error-message">${error }</span>
        <br>
        <br>
        <p class="lead">New Customer?
        <a href="<c:url value="/customerRegistrationPage" />" class="btn btn-primary">
        Click Here</a></p>
       
        </div>
        </div>
        <%@include file="/WEB-INF/template/footer.jsp" %>