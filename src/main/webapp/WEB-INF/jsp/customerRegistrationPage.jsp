<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/template/header.jsp" %>
<html>
<head>  
<style>  
.error{color:red}  
</style>  
</head>  

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer Registration Page</h1>

            <p class="lead">Fill the below information to Create New Account:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/customerRegistrationPage1" method="post" modelAttribute="customer1"> 
                    
        <div class="form-group">
            <label for="name">User Name</label>
            <form:input path="userName" id="name" class="form-Control"/>
            <form:errors path="userName" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="pass">Password</label>
            <form:password path="password" id="pass" class="form-Control"/>
            <form:errors path="password" cssClass="error"/>
        </div>
         <div class="form-group">
            <label for="custname">Customer Name</label>
            <form:input path="customerName" id="custname" class="form-Control"/>
            <form:errors path="customerName" cssClass="error"/>
        </div>
         <div class="form-group">
            <label for="custEmail">Customer Email</label>
            <form:input path="customerEmail" id="custEmail" class="form-Control"/>
            <form:errors path="customerEmail" cssClass="error"/>
        </div>
         <div class="form-group">
            <label for="phone">Customer PhoneNumber</label>
            <form:input path="phoneNumber" id="phone" class="form-Control"/>
            <form:errors path="phoneNumber" cssClass="error"/>
        </div>
        <br><br>
        <input type="submit" value="submit"  class="btn btn-primary">
        <input type="reset" value="reset"  class="btn btn-primary"">
        </form:form>
</div>
</div>


        <%@include file="/WEB-INF/template/footer.jsp" %>