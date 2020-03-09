<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/template/header2.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>

                    <p>All the selected products in your shopping cart</p>
                </div>
            </div>
        </section>
	
	
	 <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
             <th>Action</th>
			<th> Product Id</th>
			<th> Product Name</th>
			<th>Product Image</th>
			<th>Unit Price</th>
			<th>Quantity</th>
			<th>Sub Total</th>
		</tr>
            </thead>
    
		<c:set var="total" value="0"></c:set>
		<c:forEach var="item" items="${sessionScope.cart }">
		
			<c:set var="total"
				value="${total + item.product.productPrice * item.quantity }"></c:set>
			<tr style="width:100%">
				<td align="center"><a
					href="${pageContext.request.contextPath }/cart/remove/${item.product.productId }"
					onclick="return confirm('Are you sure you wnat to remove the Product?')">Remove</a></td>
				<td>${item.product.productId }</td>
				<td>${item.product.productName }</td>
				<td><img src="<c:url value="/resources/${item.product.productId}/${item.product.productId}png1.png"/>" alt="image"
                              width="100"/></td>
				<td>${item.product.productPrice }</td>
				<td>
				 ${item.quantity}</td>
				<td>
				${item.product.productPrice * item.quantity }
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="right">Total</td>
			<td>${total}</td>
		</tr>
	</table>
	<br>
	<br>
	<a href="<c:url value="/cart/customerInformation" />">Click Here to Give Customer/OrderDetails</a>
	<br>
	<br>
	<a href="${pageContext.request.contextPath }/productList">Continue
		Shopping</a>


        
<%@include file="/WEB-INF/template/footer.jsp" %>