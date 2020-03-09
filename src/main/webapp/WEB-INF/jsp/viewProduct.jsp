<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>

            <p class="lead">Here is the detail information of the product!</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                 <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide home-image"
                 src="<c:url value="/resources/${product.productId}/${product.productId}png1.png" />"
                  width="100" alt="First slide">
                  </div>
        <div class="item">
            <img class="second-slide home-image"
                 src="<c:url value="/resources/${product.productId}/${product.productId}png2.png" />"
                   width="100" alt="Second slide">

        </div>
        <div class="item">
            <img class="third-slide home-image"
                 src="<c:url value="/resources/${product.productId}/${product.productId}png3.png" />"
                    width="100" alt="Third slide">

            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

                <div class="col-md-5">
                   <p>
                       <strong>Name</strong> : ${product.productName}
                    </p>
                    <p>
                       <strong>Description</strong> : ${product.productDescription}
                    </p>
                    <p>
                       <strong>Manufacturer</strong> : ${product.productManufacturer}
                    </p>
                    <p>
                        <strong>Category</strong> : ${product.productCategory}
                    </p>
                    <p>
                        <strong>Condition</strong> : ${product.productCondition}
                    </p>
                    <p>
                        <strong>Price</strong> : ${product.productPrice} USD
                    </p>
                   
                </div>
            </div>
        </div>

</div>
</div>

        <%@include file="/WEB-INF/template/footer.jsp" %>