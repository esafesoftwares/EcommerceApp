<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/template/header1.jsp" %>

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
             <th>Option</th>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
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
				<td><img src="<c:url value="/resources/images2/${item.product.productId}.png" /> " alt="image"
                             style="width:20%;height:5%"/></td>
				<td><input type="text" id="price" name="price" class="form-control input-number" value="${item.product.productPrice }"></td>
				<td>
				 
                                        <div class="input-group">
                                    <span class="input-group-btn">
                                        <button type="button" class="quantity-left-minus btn btn-danger btn-number"  data-type="minus" data-field="">
                                          <span class="glyphicon glyphicon-minus"></span>
                                        </button>
                                    </span>
                                    <input type="text" id="${item.quantity}" name="quantity" class="form-control input-number" value="${item.quantity}">
                                    <span class="input-group-btn">
                                        <button type="button" class="quantity-right-plus btn btn-success btn-number" data-type="plus" data-field="">
                                            <span class="glyphicon glyphicon-plus"></span>
                                        </button>
                                    </span>
                                </div>
                       
	</td>
				
				<td>
				<input type="text" id="subtotal" name="subtotal" class="form-control input-number" value="${item.product.productPrice * item.quantity }">
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="right">Total</td>
			<td><input type="text" id="total" name="total" class="form-control input-number" value="${total}"/></td>
		</tr>
	</table>
	<br>
	<br>
	<a href="<c:url value="/cart/customerInformation" />">Give the detail to CheckOut product from Cart</a>
	<br>
	<br>
	<a href="${pageContext.request.contextPath }/productList">Continue
		Shopping</a>


        
<%@include file="/WEB-INF/template/footer.jsp" %>