$(document)
		.ready(
				function() {
					$('#genres').on('show', showListGenres);
					$('#genres').on('hidden', hideListGenres);
					$('#tags').on('show', showListTags);
					$('#tags').on('hidden', hideListTags);
					$('#authorsModal').on('show', showListAuthorsModal);
					$('#authorsModal').on('hidden', hideListAuthorsModal);
					$('#news').on('show', showListNews);
					$('#news').on('hidden', hideListNews);
					$('#books').on('show', showListBooks);
					$('#books').on('hidden', hideListBooks);
					$('#bookEditDetail').on('hidden', hideListDetailBooks);
					$('#userEditDetail').on('hidden', hideListDetailUsers);
					$('#userbooksDetail').on('hidden', hideListDetailUserBooks);
					$('#users').on('show', showListUsers);
					$('#users').on('hidden', hideListUsers);
					// Functions of Genres
					function showListGenres(e) {
						$.post("admin?action=showListGenres", ajaxShowGenres);
					}
					;

					function hideListGenres(e) {
						$('#genres-body').empty();
					}
					;

					function ajaxShowGenres(data) {
						var arrayOfGenres = data.split(' ');
						var i;
						var newElem = '<table id="headTableGenre" class="table table-bordered"><thead><tr><th>Id</th><th>Genre</th><th>Edit</th><th>Delete</th></tr></thead></table>';
						$('#genres-body').append(newElem);
						newElem = '<tbody id="tableGenre"></tbody>';
						$('#headTableGenre').append(newElem);
						for (i = 0; i < arrayOfGenres.length; i++) {
							newElem = '<tr><td>'
									+ (i + 1)
									+ '</td><td style="width:90%; padding-bottom:0px; padding-top:5px" id="'
									+ arrayOfGenres[i]
									+ '">'
									+ arrayOfGenres[i]
									+ '</td><td><button id="'
									+ arrayOfGenres[i]
									+ '"name="editButton" class="btn btn-info">Edit</button></td><td><button id="'
									+ arrayOfGenres[i]
									+ '" name="deleteButton" class="btn btn-danger">Delete</button></td></tr>';
							$('#tableGenre').append(newElem);
						}
						$("button[name*='editButton']")
								.bind("click", editGenre);
						$("button[name*='deleteButton']").bind("click",
								deleteGenre);
						newElem = '<tr><td>'
								+ (i + 1)
								+ '</td><td style="width:90%; padding-bottom:0px; padding-top:5px" id="newGenre"><input id="newGenre" type="text" placeholder="New Genre"><button id="newGenre" name="newGenre" class="btn btn-success pull-right">Add</button></td><td></td><td></td></tr>';
						$('#tableGenre').append(newElem);
						$("button[name*='newGenre']").bind("click", addGenre);
					}
					;

					function addGenre(e) {
						var val = $('input#newGenre').val();
						if (val == "") {
							alert("Error of input");
							return;
						}
						$.post("admin?action=addGenre&name=" + val,
								ajaxAddGenre);
					}
					;

					function ajaxAddGenre(data) {
						var e;
						hideListGenres(e);
						showListGenres(e);
					}
					;

					function deleteGenre(e) {
						$.post("admin?action=deleteGenre&name="
								+ e.currentTarget.id, ajaxDeleteGenre);
					}

					function ajaxDeleteGenre(data) {
						var e;
						hideListGenres(e);
						showListGenres(e);
					}
					;

					function editGenre(e) {
						$("button[name*='editButton']").attr('disabled', true);
						$("button[name*='deleteButton']")
								.attr('disabled', true);
						var data = $('td#' + e.currentTarget.id).html();
						$('td#' + e.currentTarget.id).empty();
						var newElem = '<input id="'
								+ e.currentTarget.id
								+ '" type="text" placeholder="'
								+ e.currentTarget.id
								+ '"><button id="'
								+ e.currentTarget.id
								+ '" name="cancelChangeGenreButton" class="btn btn-danger pull-right">Back</button><button id="'
								+ e.currentTarget.id
								+ '" name="changeGenreButton" class="btn btn-success pull-right" style="margin-right:2px">OK</button>';
						$('td#' + e.currentTarget.id).append(newElem);
						$("button[name*='cancelChangeGenreButton']").bind(
								"click", data, cancelEditGenre);
						$("button[name*='changeGenreButton']").bind("click",
								editGenreEvent);
					}
					;

					function cancelEditGenre(e) {
						$('td#' + e.currentTarget.id).empty();
						$('td#' + e.currentTarget.id).append(e.data);
						$("button[name*='editButton']").removeAttr('disabled');
						$("button[name*='deleteButton']")
								.removeAttr('disabled');
					}
					;

					function editGenreEvent(e) {
						var val = $('input#' + e.currentTarget.id).val();
						if (val == "") {
							alert("Error of input");
							return;
						}
						$.post("admin?action=editGenre&oldname="
								+ e.currentTarget.id + "&newname=" + val,
								ajaxEditGenre);
					}
					;

					function ajaxEditGenre(data) {
						var e;
						hideListGenres(e);
						showListGenres(e);
					}
					;
					// Functions of Tags
					function showListTags(e) {
						$.post("admin?action=showListTags", ajaxShowTags);
					}
					;

					function hideListTags(e) {
						$('#tags-body').empty();
					}
					;
					function ajaxShowTags(data) {
						var arrayOfTags = data.split(' ');
						var i;
						var newElem = '<table id="headTableTags" class="table table-bordered"><thead><tr><th>Id</th><th>Tag</th><th>Edit</th><th>Delete</th></tr></thead></table>';
						$('#tags-body').append(newElem);
						newElem = '<tbody id="tableTag"></tbody>';
						$('#headTableTags').append(newElem);
						for (i = 0; i < arrayOfTags.length; i++) {
							newElem = '<tr><td>'
									+ (i + 1)
									+ '</td><td style="width:90%; padding-bottom:0px; padding-top:5px" id="'
									+ arrayOfTags[i]
									+ '">'
									+ arrayOfTags[i]
									+ '</td><td><button id="'
									+ arrayOfTags[i]
									+ '"name="editButton" class="btn btn-info">Edit</button></td><td><button id="'
									+ arrayOfTags[i]
									+ '" name="deleteButton" class="btn btn-danger">Delete</button></td></tr>';
							$('#tableTag').append(newElem);
						}
						$("button[name*='editButton']").bind("click", editTag);
						$("button[name*='deleteButton']").bind("click",
								deleteTag);
						newElem = '<tr><td>'
								+ (i + 1)
								+ '</td><td style="width:90%; padding-bottom:0px; padding-top:5px" id="newTag"><input id="newTag" type="text" placeholder="New Tag"><button id="newTag" name="newTag" class="btn btn-success pull-right">Add</button></td><td></td><td></td></tr>';
						$('#tableTag').append(newElem);
						$("button[name*='newTag']").bind("click", addTag);
					}
					;

					function editTag(e) {
						$("button[name*='editButton']").attr('disabled', true);
						$("button[name*='deleteButton']")
								.attr('disabled', true);
						var data = $('td#' + e.currentTarget.id).html();
						$('td#' + e.currentTarget.id).empty();
						var newElem = '<input id="'
								+ e.currentTarget.id
								+ '" type="text" placeholder="'
								+ e.currentTarget.id
								+ '"><button id="'
								+ e.currentTarget.id
								+ '" name="cancelChangeTagButton" class="btn btn-danger pull-right">Back</button><button id="'
								+ e.currentTarget.id
								+ '" name="changeTagButton" class="btn btn-success pull-right" style="margin-right:2px">OK</button>';
						$('td#' + e.currentTarget.id).append(newElem);
						$("button[name*='cancelChangeTagButton']").bind(
								"click", data, cancelEditTag);
						$("button[name*='changeTagButton']").bind("click",
								editTagEvent);
					}
					;

					function cancelEditTag(e) {
						$('td#' + e.currentTarget.id).empty();
						$('td#' + e.currentTarget.id).append(e.data);
						$("button[name*='editButton']").removeAttr('disabled');
						$("button[name*='deleteButton']")
								.removeAttr('disabled');
					}
					;

					function editTagEvent(e) {
						var val = $('input#' + e.currentTarget.id).val();
						if (val == "") {
							alert("Error of input");
							return;
						}
						$.post("admin?action=editTag&oldname="
								+ e.currentTarget.id + "&newname=" + val,
								ajaxEditTag);
					}
					;

					function ajaxEditTag(data) {
						var e;
						hideListTags(e);
						showListTags(e);
					}
					;

					function deleteTag(e) {
						$.post("admin?action=deleteTag&name="
								+ e.currentTarget.id, ajaxDeleteTag);
					}
					;

					function ajaxDeleteTag(data) {
						var e;
						hideListTags(e);
						showListTags(e);
					}
					;

					function addTag(e) {
						var val = $('input#newTag').val();
						if (val == "") {
							alert("Error of input");
							return;
						}
						$.post("admin?action=addTag&name=" + val, ajaxAddTag);
					}

					function ajaxAddTag(data) {
						var e;
						hideListTags(e);
						showListTags(e);
					}
					// Functions of Authors

					function showListAuthorsModal(e) {
						$.post("admin?action=showListAuthorsModal",
								ajaxShowAuthorsModal);
					}
					;

					function hideListAuthorsModal(e) {
						$('#authorsModal-body').empty();
					}
					;
					function ajaxShowAuthorsModal(data) {
						var arrayOfAuthorsModal = data.split(' ');
						var i;
						var newElem = '<table id="headTableAuthorsModal" class="table table-bordered"><thead><tr><th>Id</th><th>Author</th><th>Edit</th><th>Delete</th></tr></thead></table>';
						$('#authorsModal-body').append(newElem);
						newElem = '<tbody id="tableAuthorsModal"></tbody>';
						$('#headTableAuthorsModal').append(newElem);
						for (i = 0; i < arrayOfAuthorsModal.length; i++) {
							newElem = '<tr><td>'
									+ (i + 1)
									+ '</td><td style="width:90%; padding-bottom:0px; padding-top:5px" id="'
									+ arrayOfAuthorsModal[i]
									+ '">'
									+ arrayOfAuthorsModal[i].split('_')[0]
									+ ' '
									+ arrayOfAuthorsModal[i].split('_')[1]
									+ '</td><td><button id="'
									+ arrayOfAuthorsModal[i]
									+ '"name="editButton" class="btn btn-info">Edit</button></td><td><button id="'
									+ arrayOfAuthorsModal[i]
									+ '"name="deleteButton" class="btn btn-danger">Delete</button></td></tr>';
							$('#tableAuthorsModal').append(newElem);
						}
						$("button[name*='editButton']").bind("click",
								editAuthorsModal);
						$("button[name*='deleteButton']").bind("click",
								deleteAuthorsModal);
						newElem = '<tr><td>'
								+ (i + 1)
								+ '</td><td style="width:90%; padding-bottom:0px; padding-top:5px" id="newAuthorsModal"><input id="newAuthorsModal" type="text" placeholder="New Author"><button id="newAuthorsModal" name="newAuthorsModal" class="btn btn-success pull-right">Add</button></td><td></td><td></td></tr>';
						$('#tableAuthorsModal').append(newElem);
						$("button[name*='newAuthorsModal']").bind("click",
								addAuthorsModal);
					}
					;

					function editAuthorsModal(e) {
						$("button[name*='editButton']").attr('disabled', true);
						$("button[name*='deleteButton']")
								.attr('disabled', true);
						var data = $('td#' + e.currentTarget.id).html();
						$('td#' + e.currentTarget.id).empty();
						var newElem = '<input id="'
								+ e.currentTarget.id
								+ '" type="text" placeholder="'
								+ e.currentTarget.id.split("_")[0]
								+ " "
								+ e.currentTarget.id.split("_")[1]
								+ '"><button id="'
								+ e.currentTarget.id
								+ '" name="cancelChangeAuthorsModalButton" class="btn btn-danger pull-right">Back</button><button id="'
								+ e.currentTarget.id
								+ '" name="changeAuthorsModalButton" class="btn btn-success pull-right" style="margin-right:2px">OK</button>';
						$('td#' + e.currentTarget.id).append(newElem);
						$("button[name*='cancelChangeAuthorsModalButton']")
								.bind("click", data, cancelEditAuthorsModal);
						$("button[name*='changeAuthorsModalButton']").bind(
								"click", editAuthorsModalEvent);
					}
					;

					function cancelEditAuthorsModal(e) {
						$('td#' + e.currentTarget.id).empty();
						$('td#' + e.currentTarget.id).append(e.data);
						$("button[name*='editButton']").removeAttr('disabled');
						$("button[name*='deleteButton']")
								.removeAttr('disabled');
					}
					;

					function editAuthorsModalEvent(e) {
						var val = $('input#' + e.currentTarget.id).val();
						if (val.split(" ").length != 2) {
							alert("Error of input");
							return;
						}
						var names = val.split(" ");
						$.post("admin?action=editAuthorsModal&oldname="
								+ e.currentTarget.id + "&newname=" + names[0]
								+ '_' + names[1], ajaxEditAuthorsModal);
					}
					;

					function ajaxEditAuthorsModal(data) {
						var e;
						hideListAuthorsModal(e);
						showListAuthorsModal(e);
					}
					;

					function deleteAuthorsModal(e) {
						$.post("admin?action=deleteAuthorsModal&name="
								+ e.currentTarget.id, ajaxDeleteAuthorsModal);
					}
					;

					function ajaxDeleteAuthorsModal(data) {
						var e;
						hideListAuthorsModal(e);
						showListAuthorsModal(e);
					}
					;

					function addAuthorsModal(e) {
						var val = $('input#newAuthorsModal').val();
						if (val.split(" ").length != 2) {
							alert("Error of input");
							return;
						}
						$.post("admin?action=addAuthorsModal&name=" + val,
								ajaxAddAuthorsModal);
					}

					function ajaxAddAuthorsModal(data) {
						var e;
						hideListAuthorsModal(e);
						showListAuthorsModal(e);
					}
					;

					// NEWS

					function showListNews(e) {
						$.post("admin?action=showListNews", ajaxShowNews);
					}
					;

					function hideListNews(e) {
						$('#news-body').empty();
					}
					;
					function ajaxShowNews(data) {
						var arrayOfNews = data.split('_-_');
						var i, k = 0;
						var newElem = '<table id="headTableNews" class="table table-bordered"><thead><tr><th>Id</th><th>News</th><th>Edit</th><th>Delete</th></tr></thead></table>';
						$('#news-body').append(newElem);
						newElem = '<tbody id="tableNews"></tbody>';
						$('#headTableNews').append(newElem);
						for (i = 0; i < arrayOfNews.length; i += 2, k++) {
							newElem = '<tr><td>'
									+ (k + 1)
									+ '</td><td style="width:90%; padding-bottom:0px; padding-top:5px" id="'
									+ arrayOfNews[i]
									+ '">'
									+ arrayOfNews[i + 1]
									+ '</td><td><button id="'
									+ arrayOfNews[i]
									+ '"name="editButton" class="btn btn-info">Edit</button></td><td><button id="'
									+ arrayOfNews[i]
									+ '" name="deleteButton" class="btn btn-danger">Delete</button></td></tr>';
							$('#tableNews').append(newElem);
						}
						$("button[name*='editButton']").bind("click",
								arrayOfNews, editNews);
						$("button[name*='deleteButton']").bind("click",
								arrayOfNews, deleteNews);
						newElem = '<tr><td>'
								+ (k + 1)
								+ '</td><td style="width:90%; padding-bottom:0px; padding-top:5px" id="newNews"><input id="newNews" type="text" placeholder="New News"><button id="newNews" name="newNews" class="btn btn-success pull-right">Add</button></td><td></td><td></td></tr>';
						$('#tableNews').append(newElem);
						$("button[name*='newNews']").bind("click", addNews);
					}
					;

					function editNews(e) {
						var i;
						$("button[name*='editButton']").attr('disabled', true);
						$("button[name*='deleteButton']")
								.attr('disabled', true);
						var data = $('td#' + e.currentTarget.id).html();
						$('td#' + e.currentTarget.id).empty();
						for (i = 0; i < e.data.length; i++)
							if (e.data[i] == e.currentTarget.id)
								break;
						var newElem = '<input id="correctNews" type="text" placeholder="'
								+ e.data[++i]
								+ '"><button id="'
								+ e.currentTarget.id
								+ '" name="cancelChangeNewsButton" class="btn btn-danger pull-right">Back</button><button id="'
								+ e.currentTarget.id
								+ '" name="changeNewsButton" class="btn btn-success pull-right" style="margin-right:2px">OK</button>';
						$('td#' + e.currentTarget.id).append(newElem);
						$("button[name*='cancelChangeNewsButton']").bind(
								"click", data, cancelEditNews);
						$("button[name*='changeNewsButton']").bind("click",
								e.data, editNewsEvent);
					}
					;

					function cancelEditNews(e) {
						$('td#' + e.currentTarget.id).empty();
						$('td#' + e.currentTarget.id).append(e.data);
						$("button[name*='editButton']").removeAttr('disabled');
						$("button[name*='deleteButton']")
								.removeAttr('disabled');
					}
					;

					function editNewsEvent(e) {
						var val = $('input#correctNews').val();
						if (val == "") {
							alert("Error of input");
							return;
						}
						for (i = 0; i < e.data.length; i++)
							if (e.data[i] == e.currentTarget.id)
								break;
						$.post("admin?action=editNews&oldname=" + e.data[++i]
								+ "&newname=" + val, ajaxEditNews);
					}
					;

					function ajaxEditNews(data) {
						var e;
						hideListNews(e);
						showListNews(e);
					}
					;

					function deleteNews(e) {
						for (i = 0; i < e.data.length; i++)
							if (e.data[i] == e.currentTarget.id)
								break;
						$.post("admin?action=deleteNews&name=" + e.data[++i],
								ajaxDeleteNews);
					}
					;

					function ajaxDeleteNews(data) {
						var e;
						hideListNews(e);
						showListNews(e);
					}
					;

					function addNews(e) {
						var val = $('input#newNews').val();
						if (val == "") {
							alert("Error of input");
							return;
						}
						$.post("admin?action=addNews&name=" + val, ajaxAddNews);
					}

					function ajaxAddNews(data) {
						var e;
						hideListNews(e);
						showListNews(e);
					}

					// BOOOOOOOOOOOKS

					function showListBooks(e) {
						$.post("admin?action=showListBooks", ajaxShowBooks);
					}
					;

					function hideListBooks(e) {
						$('#books-body').empty();
					}
					;

					function ajaxShowBooks(data) {
						var arrayOfTemp = data.split('_-_');
						var arrayOfId = new Array(), arrayOfNames = new Array();
						for (i = 0; i < arrayOfTemp.length; i += 2) {
							arrayOfId[i / 2] = arrayOfTemp[i];
							arrayOfNames[i / 2] = arrayOfTemp[i + 1];
						}
						var i;
						var newElem = '<table id="headTableBooks" class="table table-bordered"><thead><tr><th>Id</th><th>Book</th><th>Edit</th><th>Delete</th></tr></thead></table>';
						$('#books-body').append(newElem);
						newElem = '<tbody id="tableBooks"></tbody>';
						$('#headTableBooks').append(newElem);
						for (i = 0; i < arrayOfNames.length; i++) {
							newElem = '<tr><td>'
									+ (i + 1)
									+ '</td><td style="width:90%; padding-bottom:0px; padding-top:5px" id="'
									+ arrayOfId[i]
									+ '">'
									+ arrayOfNames[i]
									+ '</td><td><button id="'
									+ arrayOfId[i]
									+ '"name="editButton" class="btn btn-info">Edit</button></td><td><button id="'
									+ arrayOfId[i]
									+ '" name="deleteButton" class="btn btn-danger">Delete</button></td></tr>';
							$('#tableBooks').append(newElem);
						}
						$("button[name*='editButton']").bind("click",
								arrayOfTemp, editBooks);
						$("button[name*='deleteButton']").bind("click",
								arrayOfTemp, deleteBooks);
						newElem = '<tr><td>'
								+ (i + 1)
								+ '</td><td style="width:90%; padding-bottom:15px; padding-top:5px"><button id="newBook" name="newBook" class="btn btn-success">Add</button></td><td></td><td></td></tr>';
						$('#tableBooks').append(newElem);
						$("button[name*='newBook']").bind("click", addBook);
					}
					;

					function hideListDetailBooks() {
						$('#bookEditDetail-header').empty();
						$('#bookEditDetail-body').empty();
						$("button[name*='editButton']").removeAttr('disabled');
						$("button[name*='deleteButton']")
								.removeAttr('disabled');
						$.post("admin?action=pleaseDeleteAllTrash", ajaxClear);
					}
					
					function ajaxClear(){
						
					}

					function createFormBook() {
						var newElem = '<p>Name of Book:</p></div><div><input id="bookName" type="text">';
						$('#bookEditDetail-body').append(newElem);
						newElem = '<p> Edit genres of book</p></div><div id="selectedGenres"><div class="btn-group pull-left"><a class="btn dropdown-toggle" data-toggle="dropdown" href="#">Add Genre <span class="caret"></span></a><ul class="dropdown-menu" id="ListOfGenresOfBooks"></ul></div></div>';
						$('#bookEditDetail-body').append(newElem)
						newElem = '<br><br><br><div><p> Edit tags of book</p></div><div id="selectedTags"><div class="btn-group pull-left"><a class="btn dropdown-toggle" data-toggle="dropdown" href="#">Add Tag <span class="caret"></span></a><ul class="dropdown-menu" id="ListOfTagsOfBooks"></ul></div></div>';
						$('#bookEditDetail-body').append(newElem);
						newElem = '<br/><br/><br/><div><p> Edit authors of book</p></div><div id="selectedAuthors"><div class="btn-group pull-left"><a class="btn dropdown-toggle" data-toggle="dropdown" href="#">Add Author <span class="caret"></span></a><ul class="dropdown-menu" id="ListOfAuthorsOfBooks"></ul></div></div>';
						$('#bookEditDetail-body').append(newElem);
						$.post("admin?action=showListGenres", ajaxShowGenresInBook);
						$.post("admin?action=showListTags", ajaxShowTagsInBook);
						$.post("admin?action=showListAuthorsModal", ajaxShowAuthorsModalInBook);
						newElem=' <iframe id="rFrame" name="rFrame" style="display: none"></iframe>';
						$('#bookEditDetail-body').append(newElem);
						$('#rFrame').load(photoWasDownload);
						newElem='<br><br><br> <form action="admin?action=getPhoto" target="rFrame" method="POST" enctype="multipart/form-data"> <input type="file" name="photo1"/> <input type="submit" value="Load"> </form>';
						$('#bookEditDetail-body').append(newElem);
						newElem='<br><br><br> <form action="admin?action=getPhoto" target="rFrame" method="POST" enctype="multipart/form-data"> <input type="file" name="photo2"/> <input type="submit" value="Load"> </form>';
						$('#bookEditDetail-body').append(newElem);
						newElem='<br><br><br> <form action="admin?action=getPhoto" target="rFrame" method="POST" enctype="multipart/form-data"> <input type="file" name="photo3"/> <input type="submit" value="Load"> </form>';
						$('#bookEditDetail-body').append(newElem);
					}
					
					function photoWasDownload(data){
						var text = window.frames["rFrame"].document.body.innerHTML;
						text=text.substring(9,15);
						if(text=='photo1'){
							$('#photo1img').attr('src','images/tempphoto1.jpg');
						}
						if(text=='photo2'){
							$('#photo2img').attr('src','images/tempphoto2.jpg');
						}
						if(text=='photo3'){
							$('#photo3img').attr('src','images/tempphoto3.jpg');
						}
					}
					
					function ajaxShowGenresInBook(data){
						var arrayOfGenres = data.split(' ');
						for (i=0;i<arrayOfGenres.length;i++){
							newElem='<li name="genre" id="'+arrayOfGenres[i]+'">'+arrayOfGenres[i]+'</li>';
							$('#ListOfGenresOfBooks').append(newElem);
						}
						$("li[name*='genre']").bind("click",clickGenreElement);
					}
					
					function clickGenreElement(e){
						var newElem='<div id="'+e.currentTarget.id+'" class="btn-group pull-left"><button class="btn">'+e.currentTarget.id+'</button><button class="btn" id="'+e.currentTarget.id+'" name="DeleteGenreButton">x</button></div>';
						$('#selectedGenres').prepend(newElem);
						$("button[name*='DeleteGenreButton']").bind("click",clickDeleteGenreButton);
					}
					
					function clickDeleteGenreButton(e){
						$('div#'+e.currentTarget.id).remove();
					}
					
					function ajaxShowTagsInBook(data){
						var arrayOfTags = data.split(' ');
						for (i=0;i<arrayOfTags.length;i++){
							newElem='<li name="tag" id="'+arrayOfTags[i]+'">'+arrayOfTags[i]+'</li>';
							$('#ListOfTagsOfBooks').append(newElem);
						}
						$("li[name*='tag']").bind("click",clickTagElement);
					}
					
					function clickTagElement(e){
						var newElem='<div id="'+e.currentTarget.id+'" class="btn-group pull-left"><button class="btn">'+e.currentTarget.id+'</button><button class="btn" id="'+e.currentTarget.id+'" name="DeleteTagButton">x</button></div>';
						$('#selectedTags').prepend(newElem);
						$("button[name*='DeleteTagButton']").bind("click",clickDeleteTagButton);
					}
					
					function clickDeleteTagButton(e){
						$('div#'+e.currentTarget.id).remove();
					}
					
					function ajaxShowAuthorsModalInBook(data){
						var arrayOfAuthors = data.split(' ');
						for (i=0;i<arrayOfAuthors.length;i++){
							newElem='<li name="author" id="'+arrayOfAuthors[i]+'">'+arrayOfAuthors[i].split('_')[0]+' '+arrayOfAuthors[i].split('_')[1]+'</li>';
							$('#ListOfAuthorsOfBooks').append(newElem);
						}
						$("li[name*='author']").bind("click",clickAuthorElement);
					}
					
					function clickAuthorElement(e){
						var newElem='<div id="'+e.currentTarget.id+'" class="btn-group pull-left"><button class="btn">'+e.currentTarget.id+'</button><button class="btn" id="'+e.currentTarget.id+'" name="DeleteAuthorButton">x</button></div>';
						$('#selectedAuthors').prepend(newElem);
						$("button[name*='DeleteAuthorButton']").bind("click",clickDeleteAuthorButton);
					}
					
					function clickDeleteAuthorButton(e){
						$('div#'+e.currentTarget.id).remove();
					}

					function addBook(e) {
						$("button[name*='editButton']").attr('disabled', true);
						$("button[name*='deleteButton']")
								.attr('disabled', true);
						createFormBook();
						var newElem = '<br/><br/><br/><button class="btn btn-success" name="addBookDetailButton">Add</button><button class="btn btn-danger" name="cancelEditBookDetailButton">Back</button>';
						$('#bookEditDetail-body').append(newElem);
						$("button[name*='addBookDetailButton']").bind("click",addBookDetailButtonEvent);
						$("button[name*='cancelEditBookDetailButton']").bind("click",cancelEditBookDetailButton);
						newElem = '<h2>Add Book</h2>';
						$('#bookEditDetail-header').append(newElem);
						newElem="<img id='photo1img' src='' width=\"110\" height=\"70\">";
						$("input[name*='photo1']").before(newElem);
						newElem="<img id='photo2img' src='' width=\"110\" height=\"70\">";
						$("input[name*='photo2']").before(newElem);
						newElem="<img id='photo3img' src='' width=\"110\" height=\"70\">";
						$("input[name*='photo3']").before(newElem);
						$('#bookEditDetail').modal('show');
					}

					function editBooks(e) {
						var i;
						$("button[name*='editButton']").attr('disabled', true);
						$("button[name*='deleteButton']")
								.attr('disabled', true);
						createFormBook();
						var newElem = '<br/><br/><br/><button class="btn btn-success" name="editBookDetailButton">Edit</button><button class="btn btn-danger" name="cancelEditBookDetailButton">Back</button>';
						$('#bookEditDetail-body').append(newElem);
						$("button[name*='editBookDetailButton']").bind("click",editBookDetailButtonEvent);
						$("button[name*='cancelEditBookDetailButton']").bind("click",cancelEditBookDetailButton);
						for (i = 0; i < e.data.length; i++)
							if (e.data[i] == e.currentTarget.id)
								break;
						$.post("admin?action=listAttrofBook&id="+e.currentTarget.id, ajaxLoadAttrs);
						newElem = '<div id="'+e.data[i]+'"><h2>Edit "'+ e.data[++i]+'"</h2><div>';
						$('#bookEditDetail-header').append(newElem);
						$('#bookName').val(e.data[i]);
						$('#bookEditDetail').modal('show');
					}
					
					function ajaxLoadAttrs(data){
						var newElem;
						var temp=data.split("!#!");
						var arrayOfGenres=temp[0].split("_-_");
						var arrayOfTags=temp[1].split("_-_");
						var arrayOfAuthors=temp[2].split("_-_");
						var arrayOfImages=temp[3].split("_-_");
						var i;
						for (i=0;i<arrayOfGenres.length-1;i++){
							newElem='<div id="'+arrayOfGenres[i]+'" class="btn-group pull-left"><button class="btn">'+arrayOfGenres[i]+'</button><button class="btn" id="'+arrayOfGenres[i]+'" name="DeleteGenreButton">x</button></div>';
							$('#selectedGenres').prepend(newElem);
						}
						$("button[name*='DeleteGenreButton']").bind("click",clickDeleteGenreButton);
						
						for (i=0;i<arrayOfTags.length-1;i++){
							newElem='<div id="'+arrayOfTags[i]+'" class="btn-group pull-left"><button class="btn">'+arrayOfTags[i]+'</button><button class="btn" id="'+arrayOfTags[i]+'" name="DeleteTagButton">x</button></div>';
							$('#selectedTags').prepend(newElem);
						}
						$("button[name*='DeleteTagButton']").bind("click",clickDeleteTagButton);
						
						for (i=0;i<arrayOfAuthors.length-1;i++){
							newElem='<div id="'+arrayOfAuthors[i]+'" class="btn-group pull-left"><button class="btn">'+arrayOfAuthors[i]+'</button><button class="btn" id="'+arrayOfAuthors[i]+'" name="DeleteAuthorButton">x</button></div>';
							$('#selectedAuthors').prepend(newElem);
						}
						$("button[name*='DeleteAuthorButton']").bind("click",clickDeleteAuthorButton);
						for (i=0;i<3;i++){
							arrayOfImages[i]=arrayOfImages[i].substring(3);
						}
						newElem="<img id='photo1img' src='"+arrayOfImages[0]+"' width=\"110\" height=\"70\">";
						$("input[name*='photo1']").before(newElem);
						newElem="<img id='photo2img' src='"+arrayOfImages[1]+"' width=\"110\" height=\"70\">";
						$("input[name*='photo2']").before(newElem);
						newElem="<img id='photo3img' src='"+arrayOfImages[2]+"' width=\"110\" height=\"70\">";
						$("input[name*='photo3']").before(newElem);
						newElem="<input type='hidden' name='listOfNamesImages' value='"+arrayOfImages[0]+" "+arrayOfImages[1]+" "+arrayOfImages[2]+"'>";
						$('#bookEditDetail-body').append(newElem);		
					}
					

					function editBookDetailButtonEvent(e){
						var genres = $('#selectedGenres').children();
						var genresString="";
						genres.length--;
						for (i=0;i<genres.length;i++){
							genresString+=genres[i].id+" ";
						}
						genresString=genresString.substring(0, genresString.length-1);
						var tags = $('#selectedTags').children();
						var tagsString="";
						tags.length--;
						for (i=0;i<tags.length;i++){
							tagsString+=tags[i].id+" ";
						}
						tagsString=tagsString.substring(0, tagsString.length-1);
						var authors = $('#selectedAuthors').children();
						var authorsString="";
						authors.length--;
						for (i=0;i<authors.length;i++){
							authorsString+=authors[i].id+" ";
						}
						authorsString=authorsString.substring(0, authorsString.length-1);
						var idbook=$('#bookEditDetail-header').children();
						if ((genres.length==0) ||(tags.length==0) ||(authors.length==0) ||($('#bookName').val()=="")){
							alert("Error.Missing data");
							return;
						}
						var str=$("input[name*='listOfNamesImages']").val();
						$.post("admin",{action : "editDetailBook",bookId  : idbook[0].id, name : $('#bookName').val(), genres : genresString , tags : tagsString, authors :  authorsString, images : str },cancelAddBookDetailButton);	
					}
					
					function addBookDetailButtonEvent(e){
						var genres = $('#selectedGenres').children();
						var genresString="";
						genres.length--;
						for (i=0;i<genres.length;i++){
							genresString+=genres[i].id+" ";
						}
						genresString=genresString.substring(0, genresString.length-1);
						var tags = $('#selectedTags').children();
						var tagsString="";
						tags.length--;
						for (i=0;i<tags.length;i++){
							tagsString+=tags[i].id+" ";
						}
						tagsString=tagsString.substring(0, tagsString.length-1);
						var authors = $('#selectedAuthors').children();
						var authorsString="";
						authors.length--;
						for (i=0;i<authors.length;i++){
							authorsString+=authors[i].id+" ";
						}
						if ((genres.length==0) ||(tags.length==0) ||(authors.length==0) ||($('#bookName').val()=="")){
							alert("Error.Missing data");
							return;
						}
						authorsString=authorsString.substring(0, authorsString.length-1);
						if ($('#photo1img').attr('src') ==''){
							alert("Need 3 pictures");
							return;
						}
						if ($('#photo2img').attr('src') ==''){
							alert("Need 3 pictures");
							return;
						}
						if ($('#photo3img').attr('src') ==''){
							alert("Need 3 pictures");
							return;
						}
		
						$.post("admin",{action : "addDetailBook",name : $('#bookName').val(), genres : genresString , tags : tagsString, authors :  authorsString },cancelAddBookDetailButton);	
					}
					
					function cancelAddBookDetailButton(e){
						var trsh;
						$('#bookEditDetail').modal('hide');
						hideListBooks(trsh);
						showListBooks(trsh);
					}
					
					function cancelEditBookDetailButton(e){
						$('#bookEditDetail').modal('hide');
					}

					function deleteBooks(e) {
						$.post("admin?action=deleteBook&id="+e.currentTarget.id,cancelAddBookDetailButton);
					}
					
		//USERSSSSSSS
					
					function showListUsers(e) {
						$.post("admin?action=showListUsers", ajaxShowUsers);
					}
					;

					function hideListUsers(e) {
						$('#users-body').empty();
					}
					;
					
					function ajaxShowUsers(data){
						var arrayOfUsers = data.split('_-_');
						var i, k = 0;
						var newElem = '<table id="headTableUsers" class="table table-bordered"><thead><tr><th>Id</th><th>Mail</th><th>Name</th><th>Privileged</th><th>Books</th></tr></thead></table>';
						$('#users-body').append(newElem);
						newElem = '<tbody id="tableUsers"></tbody>';
						$('#headTableUsers').append(newElem);
						var str;
						for (i = 0; i < arrayOfUsers.length; i++) {
							str = arrayOfUsers[i].split(" ")[2].split("_")[0]+" "+arrayOfUsers[i].split(" ")[2].split("_")[1];
							newElem = '<tr><td>'
									+ (i+1)
									+ '</td><td style="width:35%; padding-bottom:0px; padding-top:5px" id="'
									+ arrayOfUsers[i].split(" ")[0]
									+ '">'
									+ arrayOfUsers[i].split(" ")[1]
									+ '</td><td style="width:50%; padding-bottom:0px; padding-top:5px" id="'
									+ arrayOfUsers[i].split(" ")[0]
									+ '">'
									+ str
									+ '</td><td><button id="'
									+ arrayOfUsers[i].split(" ")[0]
									+ '"name="editPrivButton" class="btn btn-info">Edit</button></td><td><button id="'
									+ arrayOfUsers[i].split(" ")[0]
									+ '" name="lookBooksButton" class="btn btn-info">Look</button></td></tr>';
							$('#tableUsers').append(newElem);
						}
						$("button[name*='editPrivButton']").bind("click",editPrivilegion);
						$("button[name*='lookBooksButton']").bind("click",lookTakedBooks);
						
					};
					
					function editPrivilegion(e){
						$.post("admin?action=showDetailUser&id="+e.currentTarget.id, ajaxEditUser);
					};
					
					function hideListDetailUsers() {
						$('#userEditDetail-header').empty();
						$('#userEditDetail-body').empty();
						$("button[name*='editPrivButton']").removeAttr('disabled');
						$("button[name*='lookBooksButton']").removeAttr('disabled');

					}
					
					function ajaxEditUser(data){
						var arr = data.split(" ");
						var newElem = '<div id="'+arr[0]+'"><h2>Edit '+ arr[1]+'</h2><div>';
						$('#userEditDetail-header').append(newElem);
						newElem='<button class="btn btn-danger" id="'+arr[0]+'" name="BlockUser">Block';
						$('#userEditDetail-body').append(newElem);
						newElem='<button class="btn btn-info" id="'+arr[0]+'" name="JustUser">JustUser';
						$('#userEditDetail-body').append(newElem);
						newElem='<button class="btn btn-success" id="'+arr[0]+'" name="AdminUser">Admin';
						$('#userEditDetail-body').append(newElem);
						$("button[name*='BlockUser']").bind("click",ChangePrivilegion);
						$("button[name*='JustUser']").bind("click",ChangePrivilegion);
						$("button[name*='AdminUser']").bind("click",ChangePrivilegion);
						if (arr[2]==0){
							$("button[name*='AdminUser']").attr('disabled', true);
						}
						if (arr[2]==1){
							$("button[name*='JustUser']").attr('disabled', true);
						}
						if (arr[2]==2){
							$("button[name*='BlockUser']").attr('disabled', true);
						}
						$("button[name*='editPrivButton']").attr('disabled', true);
						$("button[name*='lookBooksButton']").attr('disabled', true);
						$('#userEditDetail').modal('show');
					}
					
					function ChangePrivilegion(e){
						var priv;
						if (e.currentTarget.name=="BlockUser")
							priv=2;
						if (e.currentTarget.name=="JustUser")
							priv=1;
						if (e.currentTarget.name=="AdminUser")
							priv=0;
						$.post("admin?action=changePrivilegion&id="+e.currentTarget.id+"&level="+priv, ajaxCloseUserDetail);
					}
					
					function ajaxCloseUserDetail(data){
						$('#userEditDetail').modal('hide');
					};
					
					function hideListDetailUserBooks() {
						$('#userbooksDetail-header').empty();
						$('#userbooksDetail-body').empty();
						$("button[name*='editPrivButton']").removeAttr('disabled');
						$("button[name*='lookBooksButton']").removeAttr('disabled');

					}
					
					function lookTakedBooks(e){
						$("button[name*='editPrivButton']").attr('disabled', true);
						$("button[name*='lookBooksButton']").attr('disabled', true);
						$.post("admin?action=showBooksUser&id="+e.currentTarget.id, ajaxEditBooksUser);
					};
				
					function ajaxEditBooksUser(data){
						var newElem = '<div><h2>Taked Books</h2><div>';
						var arrayOfBooks = data.split('_-_');
						var i;
						$('#userbooksDetail-header').append(newElem);
						newElem = '<table id="headTableBooksUser" class="table table-bordered"><thead><tr><th>Number</th><th>Date</th><th>Name</th><th>Days Ago</th></tr></thead></table>';
						$('#userbooksDetail-body').append(newElem);
						newElem = '<tbody id="tableBooksUser"></tbody>';
						$('#headTableBooksUser').append(newElem);
						for (i=0;i<arrayOfBooks.length;i++){
							var name = arrayOfBooks[i].split("   ")[0];
							var time = arrayOfBooks[i].split("   ")[1];
							var days = arrayOfBooks[i].split("   ")[2];
							newElem = '<tr><td>'
								+ (i+1)
								+ '</td><td style="width:35%; padding-bottom:0px; padding-top:5px">'
								+ time
								+ '</td><td style="width:50%; padding-bottom:0px; padding-top:5px">'
								+ name
								+ '</td><td style="width:50%; padding-bottom:0px; padding-top:5px">'
								+ days
								+'</td></tr>';
						$('#tableBooksUser').append(newElem);
						}
						$('#userbooksDetail').modal('show');
					};
				});
