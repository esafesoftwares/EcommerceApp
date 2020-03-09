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
            <h1>Add Customer Details</h1>

            <p class="lead">Fill the below information to place the order:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/cart/submitForm"
                      metod="post" modelAttribute="order1"> 
                      <div class="form-group">
            <label for="name">Customer Name</label>
            <form:input path="customerName" id="name" class="form-Control"/>
            <form:errors path="customerName" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="address">Customer Address</label>
            <form:input path="customerAddress" id="address" class="form-Control"/>
            <form:errors path="customerAddress" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="phone">Customer PhoneNumber</label>
            <form:input path="customerPhone" id="phone" class="form-Control"/>
            <form:errors path="customerPhone" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="email">Customer Email Id</label>
            <form:input path="customerEmail" id="email" class="form-Control"/>
            <form:errors path="customerEmail" cssClass="error"/>
        </div>
              <br>
              <br>                  
        <input type="submit" value="Submit" class="btn btn-primary" />  
         <a href="<c:url value="/cart/viewCartItems" />" class="btn btn-primary">Cancel</a>
       
    </form:form> 
       
        <br><br>
       
       </div></div>
       </html>
       