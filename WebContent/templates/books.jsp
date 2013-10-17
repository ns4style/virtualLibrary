<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="hibernateMappingClass.Book"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Books</title>

<script type="text/javascript" src="../bootstrap/js/jquery.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.js"></script>
<script type="text/javascript"
	src="../bootstrap/js/jcarousellite_1.0.1.js"></script>
<script type="text/javascript"
	src="../bootstrap/js/jcarousellite_1.0.1.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bookshelper.js"></script>

<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap.css" />

</head>

<body>

	<style>
html,body {
	height: 100%;
	width: 100%;
	margin: 0px;
	padding: 0px;
}

.page {
	min-height: 100%;
	height: auto !important;
	height: 100%;
	background-color: #9d261d;
	background-image: url("../images/background3.jpg");
}

.wrap {
	padding-top: 40px;
	padding-bottom: 120px;
}

.carousel-caption {
	position: absolute;
	left: 0;
	right: 0;
	bottom: 0;
	padding: 0px;
	background: #333333;
	background: rgba(0, 0, 0, 0.75);
}

.carousel-caption h4 {
	font-family: Helvetica, sans-serif;
	font-size: 11px;
	text-align: center;
}

.randomBooksJCarouselLite {
	margin-top: 20px;
	margin-bottom: 20px;
	margin-left: auto;
	margin-right: auto;
}

.img-polaroid {
	padding: 4px;
	background-color: #000;
	border: 1px solid #000;
	border: 1px solid rgba(0, 0, 0, 0.2);
	-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
	-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
}

.jcarousel_img {
	margin-left: 10px;
	margin-right: 10px;
}
;
</style>

	<div class="page">
		<div class="wrap" id="wrap">
			<div class="navbar navbar-inverse navbar-fixed-top">
				<div class="navbar-inner">
					<div class="container">
						<a class="btn btn-navbar" data-toggle="collapse"
							data-target=".nav-collapse"> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
						</a> <a class="brand">Home</a>
						<div class="nav-collapse collapse">
							<ul class="nav">
								<li><a href="/Library/books">Books</a></li>
								<li><a href="">Authors</a></li>
								<li><a href="">About</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<!-- random carousel -->
			<div class="randomBooksJCarouselLite">
				<ul id="ul_randomBooksJCarouselLite">
					<c:forEach var="book" items="${books}" varStatus="i_book">

						<script type="text/javascript">
							var book_array = new Array();
							book_array.push("${book.getId()}");
							book_array.push("${i_book.index}");
							book_array.push("${book.getName()}");
						</script>

						<c:forEach var="image" items="${book.getImages()}">

							<script type="text/javascript">
								book_array.push("${image.getPath()}");
							</script>

						</c:forEach>

						<script type="text/javascript">
							$("#ul_randomBooksJCarouselLite").append(
									createBootstrapCarousel(book_array));
						</script>

					</c:forEach>
				</ul>
			</div>

			<div class="scrollMore" id="scrollMore">
				<script type="text/javascript">
					addPageButtonCollection("#scrollMore", ${pageCount});
				</script>

				<img src="../images/table.png" width="1000"></img>

				<div class="jCarouselLite" id="jCarouselLite">
					<ul id="scrollMoreUl">
					</ul>
				</div>
			</div>
		</div>

		<div id="book_modal" class="modal hide fade">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h3>Modal header</h3>
			</div>
			<div class="modal-body">
				<p>some content</p>
				<input type="text" name="bookId" id="bookId" value="" />
			</div>
			<div class="modal-footer">
				<a href="#" class="btn">Close</a> <a href="#"
					class="btn btn-primary">Save changes</a>
			</div>
		</div>

		<script type="text/javascript">
		
		var alreadyDownloadPages = new Array();
		$.post(window.location + "?page=0" + "&adp=" + alreadyDownloadPages, ajaxCheck);
		

		$('.carousel').each(function() {
			$(this).carousel({
				interval : Math.random() * 8000 + 4000
			});
		});

		$(function() {
			$(".randomBooksJCarouselLite").jCarouselLite({
				auto : 3000,
				speed : 1000,
				circular : true,
				visible : 7,
				hoverPause : true
			});
		});

		var button = new Array();
		for (var i=1; i<=${pageCount}; i++) {
			button.push(".scrollMore ." + i);
		}

		addPageLiCollection("#scrollMoreUl", ${pageCount});
		$(".scrollMore .jCarouselLite").jCarouselLite(
				{
					btnNext : ".scrollMore .next",
					btnPrev : ".scrollMore .prev",
					btnGo : button,
					circular : false,
					scroll : 1,
					visible : 1,
					afterEnd : function(a, to, btnGo) {
						$.post(window.location + "?page=" + $(a[0]).index() + "&adp=" + alreadyDownloadPages,
								ajaxCheck);
					}
				});
		
		function ajaxCheck(data) {
			if (data == "") {
				return;
			}
			var a = data.split(';');
			
			for (var i = 1; i < a.length-1; i++) {
				var temp = a[i].split(':');
				document.getElementById('li'+ a[0]).innerHTML += '<a data-target="#book_modal" data-toggle="modal"><img src="' + temp[2] + '" width="168" height="263" class="jcarousel_img" data-id="' + temp[1] + '"></a>';				
			}
			
			alreadyDownloadPages.push(a[0]);
		}
		
		$(document).on("click", ".jcarousel_img", function () {
		     var myBookId = $(this).data('id');
		     $(".modal-body #bookId").val(myBookId);
		});
		
		$(document).on("click", ".img-polaroid", function () {
		     var id_book = $(this).data('id');
		     $(".modal-body #bookId").val(id_book);
		});
		
		
		</script>
</body>
</html>

