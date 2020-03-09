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
            <h1>Add Account</h1>

            <p class="lead">Fill the below information to Create New Account:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/addAccount" method="post" modelAttribute="account1"> 
                    
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
            <label for="status">Status</label>
            <form:select path="active" id="status" class="form-Control">  
        <form:option value="1" label="Active"/> 
         <form:option value="0" label="Inactive"/> 
            </form:select>
               <form:errors path="active" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="role"> User Role</label>
            <form:input path="userRole" id="role" class="form-Control"/>
            <form:errors path="userRole" cssClass="error"/>
        </div>
        <br><br>
        <input type="submit" value="submit" class="btn btn-primary">
        <input type="reset" value="reset" class="btn btn-primary">
        </form:form>
</div>
</div>


        <%@include file="/WEB-INF/template/footer.jsp" %>