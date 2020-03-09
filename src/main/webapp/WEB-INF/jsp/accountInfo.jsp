<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/template/header.jsp" %>
  
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
        <h3>AccountInfo</h3>
        
            
        </div>
        <h2>
        <ul>
           <li>User Name: ${pageContext.request.userPrincipal.name}</li>
           <li>Role:
               <ul>
                   <c:forEach items="${userDetails.authorities}" var="auth">
                       <li>${auth.authority }</li>
                   </c:forEach>
               </ul>
           </li>
       </ul>
</h2>
</div>
</div>
        <%@include file="/WEB-INF/template/footer.jsp" %>