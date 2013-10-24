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
	overflow: hidden;
}

.page {
	min-height: 100%;
	height: auto !important;
	height: 100%;
	background-color: #9d261d;
	background-image: url("../images/background4.jpg");
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

.scrollMore button {
	display: inline-block;
	padding: 0px 9px;
	margin-right: 4px;
	border-radius: 3px;
	border: solid 1px #32373b;
	background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#565b5f),
		to(#3e4347));
	background: -moz-linear-gradient(0% 0% 270deg, #565b5f, #3e4347);
	box-shadow: inset 0px 1px 1px rgba(255, 255, 255, .1), 0px 1px 3px
		rgba(0, 0, 0, .1);
	font-size: .875em;
	font-weight: bold;
	text-decoration: none;
	color: #ababab;
	text-shadow: 0px 1px 0px rgba(0, 0, 0, .5);
}

.scrollMore button:hover {
	background: #3d4f5d;
	background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#547085),
		to(#3d4f5d));
	background: -moz-linear-gradient(0% 0% 270deg, #547085, #3d4f5d);
}

.scrollMore button.active {
	border: none;
	background: #2f3237;
	box-shadow: inset 0px 0px 8px rgba(0, 0, 0, .5), 0px 1px 0px
		rgba(255, 255, 255, .1);
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

			<div class="scrollMore" id="scrollMore"
				style="margin-left: 10%; margin-right: 10%;">
				<script type="text/javascript">
					addPageButtonCollection("#scrollMore", "${pageCount}");
				</script>

				<div class="jCarouselLite" id="jCarouselLite"
					style="position: relative; top: 85px; margin-left: 220px;">
					<ul id="scrollMoreUl">
					</ul>
				</div>
				<img src="../images/table.jpg"
					style="width: 100%; position: relative; top: -243px;"></img>
			</div>

			<!-- Search input-->
			<div class="search"
				style="position: relative; top: -200px; left: 250px;">
				<div class="searchElements">
					<input id="searchauthor" name="searchauthor" placeholder="Author"
						class="input-xlarge search-query" type="text"
						style="margin-top: 5px; margin-bottom: 10px;"> 
						
					<input id="searchname" name="searchname" placeholder="Book Name"
						class="input-xlarge search-query" type="text"
						style="margin-top: 5px; margin-bottom: 10px;"> 
						
					<select id="selecttag" name="selecttag" class="input-xlarge"
						style="margin-top: 5px; margin-bottom: 10px;">
						<option> select tag </option>
						<c:forEach var="tag" items="${tags}">
							<option> ${tag.getValue()} </option>
						</c:forEach>
					</select> 
					
					<select id="selectgenre" name="selectgenre" class="input-xlarge"
						style="margin-top: 5px; margin-bottom: 10px;">
						<option> select genre  </option>
						<c:forEach var="genre" items="${genres}">
							<option> ${genre.getValue()} </option>
						</c:forEach>
					</select>
					<input type="submit" class="btn" id="searchBtn" value="Search" style="margin-top: 5px; margin-bottom: 10px;">
				</div>
			</div>
			<!-- Search input-->

		</div>
	</div>

	<div id="book_modal" class="modal hide fade" style="width: 555px;">
		<div class="modal-header" id="book-header"></div>
		<div class="modal-body" id="book-body"></div>
	</div>



	<script type="text/javascript">

		$("#searchBtn").bind("click", searchBookFunc);
		
		function searchBookFunc() {
			$.post(window.location + "?searchBook=" 
					+ $("#searchauthor").val() + "_-_" + $("#searchname").val() + "_-_" + $("#selecttag").val() + "_-_" + $("#selectgenre").val(), 
					callbackSearchBookFunc);
		}
		
		function callbackSearchBookFunc(data) {
			
		}
	
		var alreadyDownloadPages = new Array();

		$.post(window.location + "?page=0" + "&adp=" // dynamic
				+ alreadyDownloadPages, ajaxCheck); // create
		var previous_page = 1; // first
		$("#scrollMore .1").addClass('active'); // page

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

		// -------------------------- Create page -------------------------------------- //
		var button = new Array(); // page button
		for (var i = 1; i <= "${pageCount}"; i++) {
			button.push(".scrollMore ." + i);
		}
		addPageLiCollection("#scrollMoreUl", "${pageCount}");

		$(".scrollMore .jCarouselLite").jCarouselLite(
				{
					btnNext : ".scrollMore .next",
					btnPrev : ".scrollMore .prev",
					btnGo : button,
					circular : false,
					scroll : 1,
					visible : 1,
					afterEnd : function(a, to, btnGo) {
						if (previous_page != ($(a[0]).index() + 1)) {
							$("#scrollMore ." + previous_page).removeClass(
									'active');
							$("#scrollMore ." + ($(a[0]).index() + 1))
									.addClass('active');
							previous_page = ($(a[0]).index() + 1);
						}
						$.post(window.location + "?page=" + $(a[0]).index()
								+ "&adp=" + alreadyDownloadPages, ajaxCheck);
					}
				});

		function ajaxCheck(data) { // dynamic create page[i]
			if (data == "") {
				return;
			}
			var a = data.split(';');

			for (var i = 1; i < a.length - 1; i++) {
				var temp = a[i].split(':');
				document.getElementById('li' + a[0]).innerHTML += '<a data-toggle="modal"><img src="' + temp[2] + '" width="168" height="263" class="jcarousel_img" data-id="' + temp[1] + '"></a>';
			}

			alreadyDownloadPages.push(a[0]);
		};
		// -------------------------- Create page -------------------------------------- //

		// ---------------------- handler for img ----------------------------- //
		$(document).on("click", ".jcarousel_img", function() {
			var id_book = $(this).data('id');
			$.post(window.location + "?id_book=" + id_book, ajaxModalBook);
		});

		$(document).on("click", ".img-polaroid", function() {
			var id_book = $(this).data('id');
			$.post(window.location + "?id_book=" + id_book, ajaxModalBook);
		});
		// ---------------------- handler for img ----------------------------- //

		// ----------------------- Create modal window -------------------------------------- //
		function ajaxModalBook(data) {
			if (data == "") {
				return;
			}
			var a = data.split(';'); // name ; author_1, ..... ; img_1, .., .. ; tag_1, ..... ,; id:fullUserName:comment_-_ .......... ,; id; count;
			$(".modal-header")
					.append(
							"<h2 style=\"margin-top: 5px; margin-bottom: 5px;margin-top: 5px; margin-bottom: 5px;\">"
									+ a[0] + "</h2>");

			var authors = a[1].split(',');
			for (var i = 0; i < authors.length - 1; i++) {
				$(".modal-header").append(authors[i] + " ");
			}

			$(".modal-body").append(
					"<img src=\"" + a[2].split(',')[0]
							+ "\" width=\"168\" height=\"263\">");
			$(".modal-body").append(
					"<img src=\"" + a[2].split(',')[1]
							+ "\" width=\"168\" height=\"263\">");
			$(".modal-body").append(
					"<img src=\"" + a[2].split(',')[2]
							+ "\" width=\"168\" height=\"263\">");

			if ("${user_privileged}" < 2) { // btn to take book
				$(".modal-body")
						.append(
								"<input type=\"submit\" class=\"btn\" id=\"takeBtn\" value=\"Take\" style=\"position: absolute; top:290px; right:30px;\">");

				$(".modal-body")
						.append(
								"<div class=\"text\" id=\"bookCount\" style=\"position: absolute; top:295px; right:100px;\"> Current count: "
										+ a[6] + "</div>");

				$("#takeBtn").bind("click", a[5], takeBookFunc);
			}

			$(".modal-body").append("<h4>Tags</h4>");
			var tags = a[3].split(',');
			for (var i = 0; i < tags.length - 1; i++) {
				$(".modal-body")
						.append(
								"<spawn style=\"color:blue\">#" + tags[i]
										+ " </spawn>");
			}

			$(".modal-body").append("<h5>Comments</h5>");
			var comments = a[4].split('_-_');
			for (var i = 0; i < comments.length - 1; i++) {
				$(".modal-body")
						.append(
								"<div id=\"comment"
										+ comments[i].split(':')[0]
										+ "\"><hr style=\"margin-top: 5px; margin-bottom: 5px;\"><b>"
										+ comments[i].split(':')[1]
										+ "</b><br>"
										+ comments[i].split(':')[2] + "</div>");

				if ("${user_privileged}" == 0) { // del comment for admin
					$("#comment" + comments[i].split(':')[0]).prepend(
							"<button type=\"button\" class=\"close\" data-id=\""
									+ comments[i].split(':')[0]
									+ "\">×</button>");
				}
			}
			if ("${user_privileged}" < 3) { // add comment not for all
				$(".modal-body")
						.append(
								"<hr style=\"margin-top: 5px; margin-bottom: 5px;\" id=\"comment_bottom\"><h5>Add comments</h5>");
				$(".modal-body")
						.append(
								"<div><input id=\"newComment\" type=\"text\" placeholder=\"New Comment\" style=\"margin:0px;\"><br><input type=\"submit\" class=\"btn\" id=\"addCommentBtn\" value=\"Send\" style=\"margin-top:5px; margin-bottom:10px;\"><br> </div>");

				$("#addCommentBtn").bind("click", a[5], addCommentFunc);
			}

			$("#book_modal").modal('show');
		};
		// ----------------------- Create modal window -------------------------------------- //

		// ----------------------- Clean modal window -------------------------------------- //
		$("#book_modal").on('hidden', function() {
			$('#book-header').empty();
			$('#book-body').empty();
		});
		// ----------------------- Clean modal window -------------------------------------- //

		// ----------------------- Add comment -------------------------------------- //
		function addCommentFunc(event) {
			if ($("#newComment").val() == "")
				return;

			$.post(window.location + "?add_new_comment=" + event.data
					+ "_-_${user_id}_-_" + $("#newComment").val(),
					callbackAddCommentFunc);
		};

		function callbackAddCommentFunc(data) {
			if (data == "")
				return;

			$(
					"<div id=\"comment" + data + "\"><hr style=\"margin-top: 5px; margin-bottom: 5px;\"><b>${user_name}</b><br>"
							+ $("#newComment").val() + "</div>").insertBefore(
					"#comment_bottom");

			if ("${user_privileged}" == 0) { // del comment for admin
				$("#comment" + data)
						.prepend(
								"<button type=\"button\" class=\"close\" data-id=\""
								+ data
								+ "\">×</button>");
			}
			$("#newComment").val("");

		};
		// ----------------------- Add comment -------------------------------------- //	

		// ----------------------- Delete comment -------------------------------------- //
		$(document).on(
				"click",
				".close",
				function() {
					var id_comment = $(this).data('id');
					$.post(window.location + "?delete_comment=" + id_comment,
							callbackDeleteCommentFunc);
				});

		function callbackDeleteCommentFunc(data) {
			if (data == "")
				return;
			$("#comment" + data).remove();
		};
		// ----------------------- Delete comment -------------------------------------- //

		function takeBookFunc(event) {
			$.post(window.location + "?take_book=" + event.data
					+ "_-_${user_id}", callbackTakeBookFunc);
		}

		function callbackTakeBookFunc(data) {
			if (data == "")
				return;

			document.getElementById("bookCount").innerHTML = "Current count: "
					+ data;
		}
	</script>
</body>
</html>

