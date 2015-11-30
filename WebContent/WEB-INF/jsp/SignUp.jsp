<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template1>

        <div class="title-sitemap grid-12">
          <h1 class="grid-6"><i>&#xf016;</i>Home</h1>
          
        </div>
      </header>
      <div class="grid-6">
          <div class="widget">
            <header class="widget-header">
              <div class="widget-header-icon"></div>
              <h3 class="widget-header-title">Sign-Up Form</h3>
            </header>
            <div class="widget-body no-padding">
              <spring:form action="${pageContext.request.contextPath}/trySignUp.bnu" modelAttribute="user" >
              <div class="widget-separator grid-6">
                <h5 class="typo">First Name</h5>
                <spring:input path="userName" cssClass="form form-full"/>
              </div>
              <div class="widget-separator grid-6">
                <h5 class="typo">Last Name</h5>
                <input type="text" name="lastName" value="" placeholder="Lewis" class="form form-full">
              </div>
              <div class="widget-separator grid-6">
                <h5 class="typo">Mobile</h5>
                <div class="field-icon field-icon-full field-icon-left">
                  <i class="i"></i>
                  <input type="text" name="mobile" value="" class="form form-full" placeholder="03154343113">
                </div>
              </div>
              <div class="widget-separator grid-6">
                <h5 class="typo">Email</h5>
                <div class="field-icon field-icon-full field-icon-left">
                  <i class="i"></i>
                  <spring:input path="userEmail" cssClass="form form-full" />
                </div>
              </div>
              <div class="widget-separator grid-6">
                <h5 class="typo">Password</h5>
                <spring:password path="password" cssClass="form form-full"/>
              </div>
              <div class="widget-separator grid-6">
                <h5 class="typo">Re-enter Password</h5>
                <input type="password" name="rpassword" value="" placeholder="" class="form form-full">
              </div>
              
              <div  class="widget-separator grid-6">
                <h5 class="typo">Category</h5>
                <select name="category" class="form form-full" >
                  <option value="buyer">Buyer</option>
                  <option value="mobile">Mobile Seller</option>
                  <option value="laptop">Laptop Seller</option>
                  <option value="desktop">Desktop Seller</option>
                  <option value="auto">Cars Dealer</option>
                </select>
              </div>
              <div class="widget-separator grid-6">
                <h5 class="typo">Address</h5>
                <div class="field-icon field-icon-full field-icon-left">
                  <i class="i"></i>
                  <input type="text" name="address" value="" class="form form-full" placeholder="joher town">
                </div>
              </div>
              <div class="widget-separator no-border grid-12">
                <input type="submit" value="Join Us" class="btn btn-submit btn-3d btn-small">
              </div>
              </spring:form>
            </div>
          </div>
        </div>
</t:template1>     