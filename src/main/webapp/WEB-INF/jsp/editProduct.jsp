<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>

            <p class="lead">Fill the below information to add a product:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/productInventory/editProduct" method="post">
        <form:input type="hidden" path="productId" id="productId" class="form-Control" value="${product.productId}"/>
        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="productName" id="name" class="form-Control"/>
        </div>

       <div class="form-group">
            <label for="category">Category</label>
            <form:select path="productCategory" id="category" class="form-Control">  
        <form:option value="Instrument" label="Instrument"/> 
         <form:option value="Recorder" label="Recorder"/> 
          <form:option value="Accessory" label="Accessory"/> 
            </form:select>
               <form:errors path="productCategory" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="productDescription" id="description" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <form:input path="productPrice" id="price" class="form-Control"/>
        </div>

       <div class="form-group">
            <label for="condition">Condition</label>
            <form:select path="productCondition" id="condition" class="form-Control">  
        <form:option value="1" label="New"/> 
         <form:option value="0" label="Used"/> 
            </form:select>
            
            <form:errors path="productCondition" id="condition" cssClass="error"/>
                                                             
        </div> 
        <div class="form-group">
            <label for="status">Status</label>
            <form:select path="productStatus" id="status" class="form-Control">  
        <form:option value="1" label="Active"/> 
         <form:option value="0" label="Inactive"/> 
            </form:select>
               <form:errors path="productStatus" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="unitInStock">Unit In Stock</label>
            <form:input path="unitInStock" id="unitInStock" class="form-Control"/>
        </div>

         <div class="form-group">
            <label for="manufacture">Manufacturer</label>
            <form:select path="productManufacturer" id="manufacture" class="form-Control">  
        <form:option value="Nokia" label="Nokia"/> 
         <form:option value="Fender" label="Fender"/> 
          <form:option value="Samsung" label="Samsung"/> 
          <form:option value="TMT" label="TMT"/> 
            </form:select>
              
        </div>

        
        <br><br>
        <input type="submit" value="submit"  class="btn btn-primary">
        <a href="<c:url value="/admin/productInventory" />"  class="btn btn-primary">Cancel</a>
        </form:form>


        <%@include file="/WEB-INF/template/footer.jsp" %>