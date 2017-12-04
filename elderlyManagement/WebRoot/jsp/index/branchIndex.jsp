<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>

<head>
<c:import url="/jsp/util/animeMove.jsp"></c:import>
    <!-- Basic -->
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <title>官网</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="">

    <!-- Bootstrap Styles -->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/jsp/index/css/bootstrap.css" media="screen">
    <!-- Awesome Icons Styles -->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/jsp/index/css/font-awesome.css" media="screen">
    <!-- Awesome Icons Styles -->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/jsp/index/css/et-line.css" media="screen">
    <!-- Css Styles -->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/jsp/index/style.css" media="screen">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/jsp/index/style-portfolio.css" media="screen">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/jsp/index/css/pro-bars.min.css" media="screen">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/jsp/index/css/animate.min.css" media="screen">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/jsp/index/css/rotator.css" media="screen">
    <!-- Google Font Styles -->
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Montserrat+Subrayada:700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Oxygen:400,700,300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Nothing+You+Could+Do' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>

    <!-- Support for HTML5 -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <![endif]-->

    <!-- Enable media queries on older bgeneral_rowsers -->
    <!--[if lt IE 9]>
    <script src="js/respond.min.js"></script>  <![endif]-->

</head>
<body id="custom">

    <div class="animationload">
    <div class="loader">Loading...</div>
    </div>

    <div class="makeborder-top"></div>
    <div class="makeborder-bottom"></div>
    <div class="makeborder-left"></div>
    <div class="makeborder-right"></div>

   <!--  <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <form id="searchform" role="form">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <input type="text" class="form-control" placeholder="What you are looking for?">
                </form>
            </div>
        </div>
    </div> -->

    <div id="wrapper">
        <div class="container">
            <header id="Home" class="header">
                <div class="menu-wrapper">
                    <nav id="navigation" class="navbar navbar-default" role="navigation">
                        <div class="navbar-inner">
                            <div class="navbar-header">
                                <a id="brand" class="navbar-brand" href="${pageContext.request.contextPath }/branch/index.action"><img src="${pageContext.request.contextPath }/jsp/index/images/logo.png" alt="Law"></a>
                            </div>
                            <div class="navbar-collapse collapse">
                                <ul class="nav navbar-nav navbar-right" id="nav">
                                    <li class="current"><a href="#Home" title="">主页</a></li>
                                    <li><a href="${pageContext.request.contextPath }/product/mallIndex" title="商城">商城</a></li>
                                    <li><a href="${pageContext.request.contextPath }/jsp/edu/index.jsp" title="">教育中心</a></li>
                                    <li><a href="${pageContext.request.contextPath }/health/activity" title="">健康中心</a></li>
                                    <li><a href="${pageContext.request.contextPath }/user/oneUser" title="">${user.username }的个人中心</a></li>
                                    <li><a href="${pageContext.request.contextPath }/logReg/logout" title="">安全退出</a></li>
                                </ul>
                            </div><!-- end navbar-collapse collapse -->
                        </div><!-- nav -->
                    </nav><!-- end navigation -->
                </div><!-- menu wrapper -->
            </header><!-- end header -->
        </div><!-- end container -->
        <div id="page_header">
            <div id="parallax" class="parallax bgback bg" style="background-image: url('${pageContext.request.contextPath }/jsp/index/images/5.jpg');" data-stellar-background-ratio="0.6" data-stellar-vertical-offset="20"></div>


            <div class="container text-center header-part">
               <h2 class="header-text">哈哈 <span class="rotate">哈哈 </span> 哈哈  哈哈 哈哈<span class="rotate"> 哈哈 </span></h2>

                <div class="angle-down">
                    <a href="#Case_Area">
                      <i class="fa fa-angle-double-down fa-4x wow animated fadeInDown" data-wow-iteration="infinite" ></i>
                    </a>
                </div>
            </div>
        </div><!-- end page_header -->

        <div class="white-wrapper">
        <div class="container">

            <div class="tagline makepadding clearfix">
                <h1><span>Hello!</span> We Design Stunning Products.</h1>
                <p class="lead">We are a <span>Law</span> team working together to craft awesome websites, realise brand identities, design for<br> print and capture visual imagery through quality.</p>
            </div><!-- end tagline -->
        </div>
        
        
        <div id="Case_Area">
                <div class="wow animated fadeInLeft">
                <div class="title text-center ">
                    <h3 class="title-text">精彩活动</h3>
                    <hr>
                    <em class="lead" >健康不是一切，但没有健康就没有一切. </em>
                </div><br>
            </div>
            <div class="container pm-containerPadding-top-80 pm-containerPadding-bottom-40">
                <div class="row">

                   
				<c:forEach items="${activities }" var="activitie" varStatus="status">
				
					 <!-- Column 1 -->

                    <div class="col-lg-4 col-md-4 col-sm-12 wow fadeInUp animated" data-wow-delay="0.3s" data-wow-offset="50" data-wow-duration="1s">
                        <div class="block-one block">
                            <img src="${pageContext.request.contextPath }/jsp/index/images/icon1.png" width="200" class="img-responsive pm-inline" alt="icon" />

                            <h6 class="pm-column-title">${activitie.activityname }</h6>
                            <div class="caret-down"><i class="fa fa-caret-down"></i></div>
                                <p>${activitie.introduction }.</p>
                            <div class="btn-blk"><a href="#" class="pm-rounded-btn">去围观</a></div>

                        </div>
                    </div>
                    <!-- Column 1 end -->
				</c:forEach>

                </div>
            </div>
        </div>
   <div  style="height: 50px"></div>     
        
            <div id="Practice_Area">
            <div class="container">
                <div class="title text-center">
                    <h3 class="title-text">热销产品</h3>
                    <em class="lead"> 品质护航 购物无忧</em>
                    <hr>
                </div>

                <div class="row">
				<c:forEach items="${productCustoms }" var="product" varStatus="status">
	                <div class="portfolio-items">
	                    <div class="item-blog col-lg-4 col-md-4 col-sm-6 col-xs-12">
	                    <ul>
	                        <li class="img_item">
	                            <div class="caption8 ctn_blue">
	                                <h3>${product.productname }</h3>
	                                <p>${product.description }.</p>
	                                <a href="${pageContext.request.contextPath }/product/productInfo?id=${product.productid }" class="pf_button green">详细</a>
	                            </div>
	                            <img class="img-responsive"  src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${product.picture }" alt="" style="min-height: 350px; max-height: 350px;"/>
	                            <%-- <img class="img-responsive"  src="${pageContext.request.contextPath }/jsp/index/images/1.jpg" alt="" /> --%>
	                        </li>
	                    </ul>
	                        </div>
	                    </div><!-- End of .portfolio-items -->

                   </c:forEach>
                </div><!-- end row -->
            </div><!-- end portfolio_wrapper -->
            </div>
<div  style="height: 60px"></div>

            <!-- FAQ -->

            <div id="faq">
                <div class="container">
                    <div class="title text-center">
                        <h3 class="title-text faq-text">0.0.0.0.0.0..0</h3>
                        <hr>
                        <em class="lead" >介绍语</em>
                    </div>



                <div class="col-md-6 col-sm-12 col-xs-12 wow animated zoomIn">
                    <h3 class="title-panel text-center">心灵鸡汤</h3><hr>
                 
                    
                    <c:forEach items="${heartCustoms }" var="heartCustom" varStatus="status">
					
							<div class="panel panel-default">
								<div class="panel-heading clickable">
									<h3 class="panel-title">${heartCustom.title }</h3>
									<span class="pull-right "><i
										class="glyphicon glyphicon-chevron-up"></i>
									</span>
								</div>
								<div class="panel-body">
									<p>${heartCustom.context }.</p>
								</div>
							</div>

					</c:forEach>
                  
                </div>
                <div class="col-md-6 col-sm-12 col-xs-12 wow animated zoomIn">
                    <h3 class="title-panel text-center">养生小常识</h3><hr>
                    	
				<c:forEach items="${commonsenseCustoms }" var="commonsenseCustom" varStatus="status">

						<div class="panel panel-default">
							<div class="panel-heading clickable">
								<h3 class="panel-title">${commonsenseCustom.title }</h3>
								<span class="pull-right "><i
									class="glyphicon glyphicon-chevron-up"></i>
								</span>
							</div>
							<div class="panel-body">
								<p>${commonsenseCustom.context }.</p>
							</div>
						</div>
				</c:forEach>
                    
                </div>
            </div>
            </div>
            <!--End Faq -->
        

        
        <!-- Contact -->

            <div id="contact">
                <div class="title text-center">
                    <h3 class="title-text">关于我们</h3>

                    <em class="lead">为了更好的服务，您一定要联系我们.</em>
                    <hr>
                </div>
            </div>
            <div class="wow animated zoomIn" data-wow-delay="1s" style="margin-bottom: -8px;">
                
            </div>

            <footer class="footer">
                <div class="container">
                    <div class="widget col-lg-3 col-md-3 col-sm-6 col-xs-12">
                        <div class="title">
                            <h3>孝和 <span>简介</span></h3>
                        </div>
                        <p>孝和集团简介孝和集团简介孝和集团简介孝和集团简介孝和集团简介孝和集团简介孝和集团简介孝和集团简介孝和集团简介孝和集团简介孝和集团简介孝和集团简介孝和集团简介孝和集团简介孝和集团简介</p>
                    </div><!-- end widget -->

                    <div class="widget col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <div class="title">
                            <h3>您有什么宝贵的意见请发送给我们</h3>
                        </div>
                        <div class="contact_widget row">
                            <div id="message"></div>
                            <form id="contactform" action="" name="contactform" method="post">
                                <!-- <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                    <input type="text" name="name" id="name" required="required" class="form-control" placeholder="Name">
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                    <input type="text" name="email" id="email" required="required" class="form-control" placeholder="Email Address">
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                    <input type="text" name="subject" id="subject" required="required" class="form-control" placeholder="Subject">
                                </div> -->

                                <div class="clearfix"></div>

                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <textarea class="form-control" name="comments" required="required" id="comments" rows="6" placeholder="在这里输入您宝贵的意见"></textarea>
                                </div>

                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <button type="button" value="" id="button" onclick='sendMessage()' class="btn btn-lg btn-primary">发送</button>
                                </div>
                            </form>
                        </div> <!-- end contact_widget -->
                    </div><!-- end widget -->

                    <div class="widget col-lg-3 col-md-3 col-sm-6 col-xs-12">
                        <div class="title">
                            <h3>联系我们</h3>
                        </div>
                        <ul class="contact_details">
                            <li><i class="fa fa-map-marker"></i> <span>贵州省</span></li>
                            <li><i class="fa fa-mobile-phone"></i> <span>(+ 00) 1-714-252-0026</span></li>
                            <li><i class="fa fa-envelope"></i> <span>xiaohe@XXX.com</span></li>
                        </ul>
                        <!-- <div class="social pull-left">
                            <span><a title="Twitter" href="#"><i class="fa fa-twitter"></i></a></span>
                            <span><a title="Facebook" href="#"><i class="fa fa-facebook"></i></a></span>
                            <span><a title="Google Plus" href="#"><i class="fa fa-google-plus"></i></a></span>
                            <span><a title="Skype" href="#"><i class="fa fa-skype"></i></a></span>
                            <span><a title="Linkedin" href="#"><i class="fa fa-linkedin"></i></a></span>
                            <span><a title="Youtube" href="#"><i class="fa fa-youtube"></i></a></span>
                            <span><a title="Pinterest" href="#"><i class="fa fa-pinterest"></i></a></span>
                        </div> --><!-- end social -->
                    </div><!-- end widget -->
                </div><!-- end container -->
            </footer><!-- end footer -->
        </div>
    </div>

            <!-- Main Scripts-->
            <script src="${pageContext.request.contextPath }/jsp/js/jquery.js"></script>
            <%-- <script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script> --%>
            <script src="${pageContext.request.contextPath }/jsp/index/js/bootstrap.js"></script>
            <script src="${pageContext.request.contextPath }/jsp/index/js/custom.js"></script>
            <script src="${pageContext.request.contextPath }/jsp/index/js/jquery.nav.js"></script>
            <script src="${pageContext.request.contextPath }/jsp/index/js/wow.min.js"></script>
            <script src="${pageContext.request.contextPath }/jsp/index/js/rotator.js"></script>

            <script type="text/javascript">
                          $('a').click(function(){
                        $('html, body').animate({
                            scrollTop: $( $.attr(this, 'href') ).offset().top
                        }, 500);
                        return false;
                    });
            </script>
            <script>
                $(document).ready(function() {
                  $('#nav').onePageNav();

                  $('.do').click(function(e) {
                    $('#section-4').append('<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>');
                    e.preventDefault();
                  });
                });
            </script>
            <script type="text/javascript">$(document).on('click', '.panel-heading span.clickable', function (e) {
                var $this = $(this);
                if (!$this.hasClass('panel-collapsed')) {
                    $this.parents('.panel').find('.panel-body').slideUp();
                    $this.addClass('panel-collapsed');
                    $this.find('i').removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');
                } else {
                    $this.parents('.panel').find('.panel-body').slideDown();
                    $this.removeClass('panel-collapsed');
                    $this.find('i').removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-up');
                }
            });
            $(document).on('click', '.panel div.clickable', function (e) {
                var $this = $(this);
                if (!$this.hasClass('panel-collapsed')) {
                    $this.parents('.panel').find('.panel-body').slideUp();
                    $this.addClass('panel-collapsed');
                    $this.find('i').removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');
                } else {
                    $this.parents('.panel').find('.panel-body').slideDown();
                    $this.removeClass('panel-collapsed');
                    $this.find('i').removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-up');
                }
            });
            $(document).ready(function () {
                $('.panel-heading span.clickable').click();
                $('.panel div.clickable').click();
            });
        </script>
        <script>
            new WOW().init();
        </script>
        <script type="text/javascript">
            $(".rotate").textrotator({
            animation: "flip", // You can pick the way it animates when rotating through words. Options are dissolve (default), fade, flip, flipUp, flipCube, flipCubeUp and spin.
            separator: ",", // If you don't want commas to be the separator, you can define a new separator (|, &, * etc.) by yourself using this field.
            speed: 3000 // How many milliseconds until the next word show.
            });
        </script>
        <script type="text/javascript">
          // Close the navbar if collapsed (small screen) when clicking on a menu link
          // From edit 2 on
          // http://stackoverflow.com/questions/14203279/bootstrap-close-responsive-menu-on-click/23171593#23171593
          $(function () {
            $('.navbar-collapse ul li a:not(.dropdown-toggle)').bind('click touchstart', function () {
              $('.navbar-toggle:visible').click();
            });
          });
        </script>
        
        <script type="text/javascript">
        	function sendMessage(){
        	alert(1);
        	var message= $("#comments").val();
        		$.ajax({
        		
        			type:"post",
        			contentType:"application/json;charset=utf-8",
        			url:"${pageContext.request.contextPath }/branch/sendMessage.action",
        			//data:'messagecontext:'+message,
        			data:'{"messagecontext"'+':'+'"'+message+'"}',
        			success:function(data,status){
        				alert(data.messagecontext);
        				alert(status);
        			}
        		
        		});
        	 }
        
        </script>
</body>
</html>
