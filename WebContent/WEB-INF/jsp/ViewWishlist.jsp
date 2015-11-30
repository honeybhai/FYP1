<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<t:template1>

        <div class="title-sitemap grid-12">
          <h1 class="grid-6"><i>&#xf016;</i>Wishlist</h1>
          
        </div>
      </header>
      <div class="data grid-12" style="min-height: 700px">
        <div class="grid-12">
          <div class="widget">
            <header class="widget-header">
              <div class="widget-header-icon"></div>
              <h3 class="widget-header-title">All Products</h3>
            </header>
            <div class="widget-body">
              <table class="tables">
                <thead>
                  <tr>
                    <th><i class="i"></i></th>
                    <th>Product Name</th>
					<th></th>
					<th></th>
                  </tr>
                </thead>
                <tbody>
                   
				   <c:set var="count" value="0" scope="page"/>
                   <c:forEach items="${wishlist}" var="item">
                    <tr>
                   		<c:set var="count" value="${count + 1}" scope="page"/>
                  		<td><c:out value="${count}"/></td>
                    	<td>${item.item.itemName}</td>
                    	<td><a href="${pageContext.request.contextPath}/viewProduct.bnu?itemId=${item.item.itemId}"><div class="btn btn-info">View<i class="right"></i></div></a></td>
                 		<td><a href="${pageContext.request.contextPath}/deleteFromWishlist.bnu?wishlistId=${item.wishlistId}"><div class="btn btn-error"><i></i>delete</div></a></td>
                  </tr>
                    </c:forEach>
                    
                  
                </tbody>
              </table>
            </div>
          </div>
        </div>
       </div>
</t:template1>