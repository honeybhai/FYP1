<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template1>

	<div class="title-sitemap grid-12">
		<h1 class="grid-6">
			<i>&#xf016;</i>${sender.userName}
		</h1>

	</div>
	</header>
	
	<c:forEach items="${messageList}" var="message">
		
		<c:set value="${message.senderUserId} " var="senderId"></c:set>
		<c:set value="${sender.userId} " var="senderId1"></c:set>
		<c:if test="${senderId1 != senderId}">
			<div class="grid-8">
				<div class="grid-12">
					<div
						class="widget widget-radius widget-fill-yellow widget-no-border"
						style="float: right;">
						<div class="widget-body">
							<p class="typo no-margin">
								<i class="i i-left"></i>${message.message}
							</p>
						</div>
					</div>
				</div>
			</div>
			
		</c:if>	
		<c:if test="${senderId1 eq senderId}" >
			<div class="grid-8" >
				<div class="grid-12">
					<div
						class="widget widget-radius widget-fill-green widget-no-border"
						style="float: left;">
						<div class="widget-body">
							<p class="typo no-margin">
								<i class="i i-left"></i>${message.message}
							</p>
						</div>
					</div>
				</div>
			</div>
		</c:if>
	</c:forEach>
	<div class="grid-8">
          <div class="widget">
            <header class="widget-header">
              <div class="widget-header-icon"></div>
              <h3 class="widget-header-title">Reply</h3>
            </header>
            <div class="widget-body">
              <ul class="discussion">
                <li class="disc-reply">
                  <spring:form action="${pageContext.request.contextPath}/replyMessage.bnu"  modelAttribute="message">
                    <spring:hidden path="receiverRole" value="${sender.role}"/>
                    <spring:hidden path="receiverUserId" value="${sender.userId}"/>
      
                    
                    
                    <spring:input  cssClass="form form-full" path="message"/>
                  </spring:form>
                </li>
              </ul>
            </div>
          </div>
        </div>
</t:template1>
