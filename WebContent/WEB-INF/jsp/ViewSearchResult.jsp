<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template1>
        <div class="title-sitemap grid-12">
          <h1 class="grid-6"><i>&#xf016;</i>Search Results</h1>
          
        </div>
      </header>
      <div class="data grid-12" style="min-height: 700px">
        <div class="grid-12">
          <div class="widget">
            <header class="widget-header">
              <div class="widget-header-icon"></div>
              <h3 class="widget-header-title">Table without border</h3>
            </header>
            <div class="widget-body">
              <table class="tables no-border">
                <thead>
                  <tr>
                    <th><i class="i"></i></th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Action</th>
                  </tr>
                </thead>
                <tbody>
		        
		        	
		        	<c:if test="${not empty itemList}">
		        		<c:forEach items="${itemList}" var="item">
		        			<tr>
		                   		<td>1</td>
		                   	 	<td>${item.itemName }</td>
		                    	<td>items</td>
		                    	<td><a href="${pageContext.request.contextPath}/viewProduct.bnu?itemId=${item.itemId}"><div class="btn btn-small" >View Item</div></a></td>
                  			</tr>
		        		</c:forEach>
		        	</c:if>
		        	<c:if test="${not empty categoryList}">
		        		<c:forEach items="${categoryList}" var="item">
		        			<tr>
		                   		<td>1</td>
		                   	 	<td>${item.categoryName}</td>
		                    	<td>Category</td>
		                    	<td><div class="btn btn-small">View Category</div></td>
                  			</tr>
		        		</c:forEach>
		        	</c:if>
		        	<c:if test="${not empty sellerList}">
		        		<c:forEach items="${sellerList}" var="item">
		        			<tr>
		                   		<td>1</td>
		                   	 	<td>${item.sellerFirstName } ${item.sellerLastName}</td>
		                    	<td>Seller</td>
		                    	<td><a href="${pageContext.request.contextPath}/viewProducts.bnu?sellerId=${item.sellerId}"><div class="btn btn-small">View Seller</div></td>
                  			</tr>
		        		</c:forEach>
		        	</c:if>
		        
		       
                  
             
                </tbody>
              </table>
            </div>
          </div>
        </div>
       </div>
</t:template1>     