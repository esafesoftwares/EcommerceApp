<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/template/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
response.setIntHeader("Refresh", 5);
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Products</h1>

            <p class="lead">Checkout all the awesome products available now!</p>
        </div>

	 <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
            
			<th>Product Name</th>
			<th>Product Image</th> 
			
			<th>Product Condition</th>
			<th> Product Price</th>
			
			<th>Product Details</th>
			<th>Buy Now</th>
		</tr>
            </thead>            <c:forEach items="${products}" var="product">
                <tr>
                    
                    <td>${product.productName}</td>
                    
                    
                    <td>
                   <img src="<c:url value="/resources/${product.productId}/${product.productId}png1.png"/>" alt="image"
                              width="100"/></td>
            
      
                    <td>
                   
<tags:newused productCondition="${product.productCondition}"/>
                    
                   </td>
                    <td>${product.productPrice}</td>
                    
                    <td><a href="<spring:url value="/productList/viewProduct/${product.productId}" />"
                    ><span class="glyphicon glyphicon-info-sign"></span></a></td>
                     
                    <td><a href="${pageContext.request.contextPath }/cart/buy/${product.productId}">
                    Buy Now</a></td>
                </tr>
            </c:forEach>
        </table>
        </div>
        </div>

<%@include file="/WEB-INF/template/footer.jsp" %>