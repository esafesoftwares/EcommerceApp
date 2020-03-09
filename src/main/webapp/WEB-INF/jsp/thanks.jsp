<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/template/header.jsp" %>
  
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
        <h1> Order Details</h1>
        Name :<p class="lead">${order1.customerName} </p>
        Email Id :<p class="lead">${order1.customerEmail} </p>
        Phone Number :<p class="lead">${order1.customerPhone} </p>
        </div>
            <h3>Thank You For Shopping     
                     
            <span class="glyphicon glyphicon-thumbs-up"></span>
            <span class="glyphicon glyphicon-thumbs-up"></span>
            <span class="glyphicon glyphicon-thumbs-up"></span></h3>
            <br>
            <br>
 <a href="${pageContext.request.contextPath }/productList">Continue
		Shopping</a>
           
        </div>
        </div>
       
<%@include file="/WEB-INF/template/footer.jsp" %>