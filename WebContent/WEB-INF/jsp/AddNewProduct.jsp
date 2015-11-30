<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<t:template1>
	
      
	<div class="title-sitemap grid-12">
		<h1 class="grid-6">
			<i>&#xf016;</i>Home
		</h1>

	</div>
	</header>
	<div class="grid-7">
          <div class="widget">
            <header class="widget-header">
              <div class="widget-header-icon"></div>
              <h3 class="widget-header-title">Add New Product </h3>
            </header>
            <div class="widget-body no-padding">
              <spring:form action="${pageContext.request.contextPath}/saveNewProduct.bnu" modelAttribute="item" >
              <div class="widget-separator grid-12">
                <h5 class="typo">Product Name</h5>
                <spring:input cssClass="form form-full" path="itemName" title="itemName"/>
              </div>
              
              <div class="widget-separator grid-4">
                <h5 class="typo">${name3}</h5>
                
                <select class="form form-full" name="brand">
                  <c:forEach items="${brand}" var="b">
                  	<option value="${b.attributeOption}" >${b.attributeOption}</option>
                  </c:forEach>
                </select>
              </div>
              <div class="widget-separator grid-4">
                <h5 class="typo">${name4}</h5>
                <select class="form form-full" name="screen">
                  <c:forEach items="${screen}" var="s">
                  	<option  value="${s.attributeOption}">${s.attributeOption}</option>
                  </c:forEach>
                </select>
              </div>
              <div class="widget-separator grid-4">
                <h5 class="typo">${name5}</h5>
                <select class="form form-full" name="processor">
                  <c:forEach items="${processor}" var="p">
                  	<option  value="${p.attributeOption}">${p.attributeOption}</option>
                  </c:forEach>
                 
                </select>
              </div>
              <div class="widget-separator grid-12 c-r-p">
                <h5 class="typo">${name1}</h5>
                <h5 class="typo inline">yes</h5><div class="radio"><span><input name="bluetooth" value="yes" type="radio" class="uniform"></span></div>
              	<h5 class="typo inline">no</h5><div class="radio"><span><input name="bluetooth" value="no" type="radio" class="uniform"></span></div>
              </div>
              <div class="widget-separator grid-12 c-r-p">
                <h5 class="typo">${name2}</h5>
                <h5 class="typo inline">yes</h5><div class="radio"><span><input name="wifi"  value="yes" type="radio" class="uniform"></span></div>
              	<h5 class="typo inline">no</h5><div class="radio"><span><input name="wifi" value="no" type="radio" class="uniform"></span></div>
              </div>
              <div class="widget-separator grid-12">
                <h5 class="typo">Price</h5>
                <spring:input cssClass="form form-full" value=""  path="price"/>
              </div>
              <div class="widget-separator no-border grid-12">
                <input type="submit" value="Submit" class="btn btn-submit btn-3d btn-small">
              </div>
              </spring:form>
            </div>
          </div>
        </div>
	
</t:template1>
