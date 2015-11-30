<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>

<t:template1>

	<div class="title-sitemap grid-12">
		<h1 class="grid-6">
			<i>&#xf016;</i>Product Info
		</h1>

	</div>
	</header>
	<div class="data grid-12" style="min-height: 700px">

		<div class="grid-6">
			<div class="widget widget-no-border">
				<div class="widget-body no-padding">

					<table class="tables table-bordered table-pricing">
						<thead>
							<tr>
								<th style="min-width: 200px;">Product Info</th>

							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Item Name<strong>${item.itemName}</strong></td>

							</tr>
							<tr>
								<td>Category<strong>${category.categoryName}</strong></td>
							</tr>
							<c:forEach items="${productOptionList}" var="productOption">
								<tr>
									<td>${productOption.categoryAttribute.categoryAttributeName}<strong>${productOption.attributeOption
											} </strong></td>

								</tr>
							</c:forEach>
							<tr>
								<td>Price<strong>${item.price}</strong></td>

							</tr>

						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<div class="grid-6">
			<div class="widget">
				<header class="widget-header">
					<div class="widget-header-icon"></div>
					<h3 class="widget-header-title">Contents Slider</h3>
				</header>

				<div class="widget-body">
					<div class="bx-wrapper" style="max-width: 400px;">
						<div class="bx-viewport"
							style="width: 100%; overflow: hidden; position: relative; height: 200px;">
							<ul class="bxslider"
								style="width: 615%; position: relative; -webkit-transition: 0s; transition: 0s; -webkit-transform: translate3d(-800px, 0, 0);">
								<li
									style="float: left; list-style: none; position: relative; width: 400px;"
									class="bx-clone"><img
									src="http://placebox.es/400/200/d97fEE/f1f1f1/"></li>
								<li
									style="float: left; list-style: none; position: relative; width: 400px;"><img
									src="http://placebox.es/400/200/d97f19/f1f1f1/?timestamp=1387210605274"></li>
								<li
									style="float: left; list-style: none; position: relative; width: 400px;"><img
									src="http://placebox.es/400/200/d97fBB/f1f1f1/"></li>
								<li
									style="float: left; list-style: none; position: relative; width: 400px;"><img
									src="http://placebox.es/400/200/d97fAA/f1f1f1/"></li>
								<li
									style="float: left; list-style: none; position: relative; width: 400px;"><img
									src="http://placebox.es/400/200/d97fEE/f1f1f1/"></li>
								<li
									style="float: left; list-style: none; position: relative; width: 400px;"
									class="bx-clone"><img
									src="http://placebox.es/400/200/d97f19/f1f1f1/?timestamp=1387210605274"></li>
							</ul>
						</div>
						<div class="bx-controls bx-has-pager bx-has-controls-direction">
							<div class="bx-pager bx-default-pager">
								<div class="bx-pager-item">
									<a href="" data-slide-index="0" class="bx-pager-link">1</a>
								</div>
								<div class="bx-pager-item">
									<a href="" data-slide-index="1" class="bx-pager-link active">2</a>
								</div>
								<div class="bx-pager-item">
									<a href="" data-slide-index="2" class="bx-pager-link">3</a>
								</div>
								<div class="bx-pager-item">
									<a href="" data-slide-index="3" class="bx-pager-link">4</a>
								</div>
							</div>
							<div class="bx-controls-direction">
								<a class="bx-prev" href="">Prev</a><a class="bx-next" href="">Next</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="grid-6">
			<div class="widget widget-no-border">
				<div class="widget-body no-padding">
					<table class="tables table-bordered table-pricing">
						<thead>
							<tr>
								<th style="min-width: 200px;">Seller Info</th>

							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Seller Name<strong>${seller.sellerFirstName}</strong></td>

							</tr>
							<tr>
								<td>Seller Phone <strong>${seller.sellerMobile}</strong></td>

							</tr>
							<tr>
								<td>Seller Address<strong>${seller.sellerLocation}</strong></td>

							</tr>


						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="grid-12 widget-separator fbt no-border">
			<h5 class="typo">Actions</h5>
			<!-- Block Buttons -->
			<c:if test='${not empty sessionScope["buyerId"]}'>
				<a
					href="${pageContext.request.contextPath}/addToWishlist.bnu?itemId=${item.itemId}"><div
						class="btn btn-block btn-success">
						<i></i>Add to wish List
					</div></a>
			</c:if>

			<div class="btn btn-block btn-info">
				<i></i>Report this product
			</div>
			<a
				href="${pageContext.request.contextPath}/viewThread.bnu?userId=${seller.userId}"><div
					class="btn btn-block btn-info">
					<i>&#xf003;</i>send messgae
				</div></a>
		</div>

		<div class="grid-12">
			<div class="widget">
				<header class="widget-header">
					<div class="widget-header-icon"></div>
					<h3 class="widget-header-title">Discussions</h3>
				</header>
				<div class="widget-body">
					<ul class="discussion">
						<c:forEach var="comment" items="${commentList}">
							<li>
								<div class="disc-head">
									<img class="disc-avatar" src="media/chat/u2.jpg" alt="avatar">
									<h4 class="disc-user">
										${comment.buyer.buyerName}
										<div class="btn btn-badge btn-tiny btn-success">VIP</div>
									</h4>
									<div
										class="disc-options btn-o-icon btn-transparent btn btn-menu">
										<i></i>
										<!-- Menu -->
										<div class="menu menu-bottom-right">
											<ul>

												<li><a href="">
														<div class="menu-icon">&#xf0a5;</div>
														<div class="menu-title">Report</div>
												</a></li>
												<li><a href="#">
														<div class="menu-icon"></div>
														<div class="menu-title">Delete</div>
												</a></li>

											</ul>
										</div>
									</div>
								</div>

								<div class="disc-content">
									<p class="typo">${comment.comment}</p>
									<div class="disc-time">23 Jan 2013 @ 14:44:24</div>
								</div>
							</li>
						</c:forEach>
						<c:if test='${not empty sessionScope["userId"]}'>
							<li class="disc-reply"><spring:form
									action="${pageContext.request.contextPath}/addComment.bnu?itemId=${item.itemId}">
									<img src="media/chat/u1.jpg" alt="avatar">
									<input type="text" name="comment" class="form form-full"
										placeholder="message ..">
								</spring:form></li>
						</c:if>

					</ul>
				</div>
			</div>
		</div>
	</div>

</t:template1>
