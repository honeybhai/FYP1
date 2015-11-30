<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<t:template1>

        <div class="title-sitemap grid-12">
          <h1 class="grid-6"><i>&#xf016;</i>products</h1>
          
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
                    <th>Product Id</th>
                    <th>Archive</th>
                  </tr>
                </thead>
                <tbody>
                   
				   <c:set var="count" value="0" scope="page"/>
                   <c:forEach items="${itemList}" var="item">
                    <tr>
                   		<c:set var="count" value="${count + 1}" scope="page"/>
                  		<td><c:out value="${count}"/></td>
                    	<td>${item.itemName}</td>
                    	<td>${item.itemId}</td>
                    	<td><div class="btn btn-menu btn-small btn-submit">Manage<i class="right"></i>
                      <!-- Menu -->
                      <div class="menu menu-bottom-left">
                        <ul>
                          <li>
                            <a href="${pageContext.request.contextPath}/viewProduct.bnu?itemId=${item.itemId}">
                              <div class="menu-icon"><!-- Empty --></div>
                              <div class="menu-title" >
                                View
                              </div>
                            </a>
                          </li>
                          <li>
                            <a href="${pageContext.request.contextPath}/addNewProduct.bnu?itemId=${item.itemId}">
                              <div class="menu-icon"><!-- Empty --></div>
                              <div class="menu-title">
                                Edit
                              </div>
                            </a>
                          </li>
                          <li>
                            <a href="${pageContext.request.contextPath}/advertiseProduct.bnu?itemId=${item.itemId}">
                              <div class="menu-icon"><!-- Empty --></div>
                              <div class="menu-title">
                                Advertise
                              </div>
                            </a>
                          </li>
                          <!-- Separator -->
                          <li class="separator"></li>
                          <li>
                            <a href="${pageContext.request.contextPath}/deleteProduct.bnu?itemId=${item.itemId}">
                              <div class="menu-icon"><!-- Empty --></div>
                              <div class="menu-title">
                                Delete
                              </div>
                            </a>
                          </li>
                        </ul>
                      </div>
                    </div></td>
                  </tr>
                    </c:forEach>
                    
                  
                </tbody>
              </table>
            </div>
          </div>
        </div>
       </div>
</t:template1>