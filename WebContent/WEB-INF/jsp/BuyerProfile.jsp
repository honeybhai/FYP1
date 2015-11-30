<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template1>
<div class="title-sitemap grid-12">
          <h1 class="grid-6"><i>&#xf016;</i>Profile</h1>
          
</div>
</header>
<div class="data grid-12" style="min-height: 700px">
        <h3 class="typo">Full Name</h3>	
        <blockquote class="typo" cite="http://loripsum.net">
                  ${buyerName}
        </blockquote>
        <h3 class="typo">Mobile Number</h3>	
        <blockquote class="typo" cite="http://loripsum.net">
                  ${buyerMobile}
        </blockquote>
        <h3 class="typo">Email Address</h3>	
      	 <blockquote class="typo" cite="http://loripsum.net">
                  ${buyerEmail}
        </blockquote>
        
      </div>
      
</t:template1>