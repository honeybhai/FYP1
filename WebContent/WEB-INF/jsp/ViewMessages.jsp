<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template1>

        <div class="title-sitemap grid-12">
          <h1 class="grid-6"><i>&#xf016;</i>Home</h1>
          
        </div>
      </header>
      <div class="grid-12">
          <div class="widget">
            <header class="widget-header">
              <div class="widget-header-icon"></div>
              <h3 class="widget-header-title">Simple Table</h3>
            </header>
            <div class="widget-body">
              <table class="tables">
              	<thead>
              		<tr>
              			<th>#</th>
              			<th>Name</th>
              			
              			<th></th>
              			<th></th>
              		</tr>
              	</thead>
                <tbody>
                	<c:set var="count" value="0" scope="page"/>
                	<c:forEach items="${userList}" var="user">
                		<tr>	
                			<c:set var="count" value="${count + 1}" scope="page"/>
	                		<td><c:out value="${count}"/></td>
		                    <td>${user.user.userName}</td>
		                    
		                    <td><a href="${pageContext.request.contextPath}/viewThread.bnu?userId=${user.user.userId}"><div class="btn btn-small">View Conversation</div></a></td>
		                  	<td><a href="${pageContext.request.contextPath}/deleteThread.bnu?userId=${user.user.userId}"><div class="btn btn-small btn-error">Delete Conversation</div></a></td>	
                		</tr>
                	</c:forEach>
                  
                  
                </tbody>
              </table>
              
            </div>
            
            
          </div>
        </div>
</t:template1>     