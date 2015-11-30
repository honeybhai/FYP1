
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<t:template1>

	<div class="title-sitemap grid-12">
		<h1 class="grid-6">
			<i>&#xf016;</i>Advertisements
		</h1>

	</div>
	</header>
	<c:set var="i" value="0" scope="page" />
	<c:forEach    var="l" items="${ advertisementList}">
		<c:set var="i" value="${i+ 1}" scope="page"/>
		<c:if test="${i<5}">
			
				<a href="${pageContext.request.contextPath}/viewProduct.bnu?itemId=${l.itemId}">
					<div class="grid-3">
						<div class="widget w-g widget-no-border" id="a${i}">
							<div class="widget-body">
								<p class="typo no-margin"><b>${l.item.itemName}</b></p><p class="typo no-margin"><mark>Price-   ${l.item.price}</mark></p>
							</div>
						</div>
					</div>
				</a>
			
					
		</c:if>
	</c:forEach>
	
	
</t:template1>
