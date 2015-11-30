<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!-- Main Container -->
  <div class="container">
    <!-- Sidebar -->
    <aside class="sidebar">
      <!-- .sidebar-mobile .sidebar-reduce -->
      <!-- Logo and Reduce Sidebar -->
      <div class="logo-reduce-sidebar">
        <div class="logo">
          <a href="index.html">
            <img class="logo-sidebar-big" src="media/acura-logo.png" alt="acura-logo">
            <img class="logo-sidebar-small" src="media/acura-logo-small.png" alt="acura-logo">
          </a>
        </div>
        <div class="reduce-sidebar">&#xf0c9;</div>
      </div>
      <!-- Sidebar Nav -->
      <nav class="nav-sidebar">
        <ul>
          <li>
            <a title="Dashboard" href="index.html" class="sidebar-small tipsy-w">
              <span class="icon">&#xf132;</span>
            </a>
            <a href="${pageContext.request.contextPath}/welcome.bnu" class="sidebar-big">
              <span class="icon">&#xf132;</span>
              Home
            </a>
          </li>
          
          
            
         
          <!--<li>
            <a href="#">
              Empty
            </a>
          </li>-->
        </ul>
      </nav>
      <!-- Announcement Widget -->
      
      <!-- Social Widget -->
		<div class="sidebar-widget">
        <h4 class="widget-title"><span>&#xf0ac;</span>Get in Touch</h4>
        <div class="facebook-twitter">
          <a href="http://facebook.com/abdul.hannan.se" id="facebook">
            <span>&#xf082;</span>
            Facebook
          </a>
          <a href="http://twitter.com/Mitgux" id="twitter">
            <span>&#xf099;</span>
            Twitter
          </a>
          
        </div>
        <span class="social-indication">Getting in touch with us!</span>
      </div>
      <!-- Ads Widget -->
      
    </aside>
    <!-- Contents -->
    <div class="contents">
      <!-- Header -->
      <header class="header grid-12">
        <!-- Mobide Header -->
        <div class="grid-12 mobile-header">
          <!-- Logo -->
          <div class="logo-mh">
            <a href="index.html">
              <img src="media/acura-logo-small.png" alt="acura-logo">
            </a>
          </div>
          <!-- Reduce -->
          <div class="reduce-sidebar-mh">&#xf0c9;</div>
        </div>
        <!-- Search and Top Nav-->
        <div class="search-top-nav grid-8">
          <!-- Search -->
          <div class="search">
            <spring:form action="${pageContext.request.contextPath}/searchInput.bnu" >
              <input type="text" name="searchInput" id="livesearch" placeholder="Live Search">
              <input type="submit" value="&#xf002;">
            </spring:form>
            <!-- Live Search -->
            <div class="live-search">
              <ul>
                <li>
                  <a href="#">
                    <img src="media/ls1.jpg" alt="preview" class="live-search-thumb">
                    <h4 class="typo">Aspernatur sapiente unde</h4>
                    <p class="typo light no-margin">Reprehenderit eaque illo aspernatur <span class="h">sapiente</span> unde consequuntur quod deserunt maxime vel ...</p>
                  </a>
                </li>
                <li>
                  <a href="#">
                    <img src="media/ls2.jpg" alt="preview" class="live-search-thumb">
                    <h4 class="typo">Eaque illo aspernatur sapiente</h4>
                    <p class="typo light no-margin">Adipisicing <span class="h">elit</span> Mollitia reprehenderit eaque illo aspernatur sapiente unde consequuntur quod deserunt maxime vel ...</p>
                  </a>
                </li>
                <li>
                  <a href="#">
                    <h4 class="typo">Lorem ipsum dolor sit amet.</h4>
                    <p class="typo light no-margin">Lorem ipsum dolor sit amet, consectetur <spna class="h">adipisicing</spna> elit. Mollitia reprehenderit eaque illo aspernatur sapiente unde consequuntur quod deserunt maxime vel ...</p>
                  </a>
                </li>
                <li class="live-search-separator">...</li>
                <li class="live-search-more">
                  <a href="#">
                    See more
                  </a>
                </li>
              </ul>
            </div>
          </div>
          <!-- Top Navigation -->
          
        </div>
        <!-- User -->
        <div class="top-user grid-4">
          <!-- User Avatar -->
          <div class="user-avatar">
            <img src="media/top-avatar.png" alt="avatar">
          </div>
          <!-- User Data -->
          <div class="user-data">
            <h4><a href="#">${sessionScope["userName"]}</a></h4>
            <h6>${sessionScope["userRole"]}</h6>
            <!-- User Notifications -->
            <ul class="user-notifications">
              <li id="u-top-logs-toggle">&#xf0ac;<span>5</span></li>
              <li id="u-top-msg-toggle">&#xf003;<span>13</span></li>
            </ul>
            <!-- User Options -->
            <ul class="user-options">
              <li>
                <div id="u-s-icon" class="btn btn-menu btn-small btn-transparent btn-o-icon"><i>&#xf013;</i>
                  <!-- Menu -->
                  <div class="menu menu-bottom-right">
                    <ul>
                      <li>
                        <a href="#">
                          <div class="menu-icon"><!-- Empty --></div>
                          <div class="menu-title">
                            Edit Profile
                          </div>
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <div class="menu-icon"><!-- Empty --></div>
                          <div class="menu-title">
                            Settings
                          </div>
                        </a>
                      </li>
                      <li>
                        <a href="#" id="lock-s">
                          <div class="menu-icon">&#xf023;</div>
                          <div class="menu-title">
                            Lock Screen
                          </div>
                        </a>
                      </li>
                      <li>
                        <a href="${pageContext.request.contextPath}/logout.bnu">
                          <div class="menu-icon"><!-- Empty --></div>
                          <div class="menu-title">
                            Logout
                          </div>
                        </a>
                      </li>
                    </ul>
                  </div>
                </div>
              </li>
            </ul>
          </div>
          <div class="user-message-content">
            <a href="#" class="u-single-mesg">
              <img src="media/chat/u1.jpg" alt="aaa">
              <h5>Joseph Moore</h5>
              <p>Lorem ipsum dolor sit amet ...</p>
              <span><i class="i i-left i-small">&#xf00c;</i>12, August</span>
            </a>
            <a href="#" class="u-single-mesg">
              <img src="media/chat/u2.jpg" alt="aaa">
              <h5>Holly Roberts</h5>
              <p>Nostrum quidem eaque tempora ea totam ...</p>
              <span><i class="i i-left i-small">&#xf112;</i>11, July</span>
            </a>
          </div>
          <div class="user-logs-content">
            <a href="#" class="u-single-mesg">
              <i>&#xf03e;</i>
              <p><strong>Stephen</strong> Add new picture</p>
              <span>12, August</span>
            </a>
            <a href="#" class="u-single-mesg">
              <i>&#xf0e5;</i>
              <p><strong>Rose</strong> Add new comments</p>
              <span>11, July</span>
            </a>
            <a href="#" class="u-single-mesg">
              <i>&#xf07a;</i>
              <p><strong>Thomas</strong> Buy your latest item</p>
              <span>10, July</span>
            </a>
          </div>
        </div>
        <!-- Hidden Stats -->
        <div class="grid-12 hidden-top-stats">
          <!-- Multiple Axis -->
          <div class="grid-12">
            <div class="widget widget-no-border">
              <div class="widget-body no-padding">
                <div class="h-m-s"></div>
              </div>
            </div>
          </div>
        </div>
        <!-- Popular Page -->
        <div class="top-buttons grid-12">
          <div class="grid-2">
            <a href="${pageContext.request.contextPath}/viewBuyerProfile.bnu">
              <div class="data-icon" style="color: #ED303C;">&#xf135;</div>
              <div class="data-info">
                <h4>Profile</h4>
                <h5><span class="s-down">&#xf0d7; 12%</span>Page View</h5>
              </div>
            </a>
          </div>
          <div class="grid-2">
            <a href="${pageContext.request.contextPath}/viewWishlist.bnu">
              <div class="data-icon" style="color: #95CFB7;">&#xf07a;</div>
              <div class="data-info">
                <h4>WishList</h4>
                <h5><span class="s-up">&#xf0d8; 23%</span></h5>
              </div>
            </a>
          </div>
          <div class="grid-2">
            <a href="${pageContext.request.contextPath}/addNewProduct.bnu">
              <div class="data-icon" style="color: #00A8C6;">&#xf0f6;</div>
              <div class="data-info">
                <h4>Manage</h4>
                <h5><span class="i-stars">&#xf005;</span> Wish List</h5>
              </div>
            </a>
          </div>
          <div class="grid-2">
            <a href="${pageContext.request.contextPath}/viewMessages.bnu">
              <div class="data-icon" style="color: #FF823A;">&#xf0e0;</div>
              <div class="data-info">
                <h4>Inbox</h4>
                <h5><span class="msg-count">17</span>New Msgs</h5>
              </div>
            </a>
          </div>
          <div class="grid-4 custom-contents-top">
            <a class="lightbox-block" href="media/lightbox/img1.jpg" data-lightbox="image2" title="Some Statistics">
              <img src="media/lightbox/thumb-3.png" alt="thumb3">
            </a>
            <h4 class="typo">Custom Contents</h4>
            <p class="typo">Make any contents for your clients</p>
          </div>
        </div>
        <!-- Title & Sitemap -->
        
      