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
					/*$("#bookEditDetail").css({
					     "width" : 1500,
					     "height" : 1500
					});*/
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
						var newElem='<div id="'+e.currentTarget.id+'" class="btn-group pull-left"><button class="btn btn-success">'+e.currentTarget.id+'</button><button class="btn" id="'+e.currentTarget.id+'" name="DeleteGenreButton">x</button></div>';
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
						var newElem='<div id="'+e.currentTarget.id+'" class="btn-group pull-left"><button class="btn btn-success">'+e.currentTarget.id+'</button><button class="btn" id="'+e.currentTarget.id+'" name="DeleteTagButton">x</button></div>';
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
						var newElem='<div id="'+e.currentTarget.id+'" class="btn-group pull-left"><button class="btn btn-success">'+e.currentTarget.id+'</button><button class="btn" id="'+e.currentTarget.id+'" name="DeleteAuthorButton">x</button></div>';
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
						var newElem = '<h2>Add Book</h2>';
						$('#bookEditDetail-header').append(newElem);
						$('#bookEditDetail').modal('show');
					}

					function editBooks(e) {
						var i;
						$("button[name*='editButton']").attr('disabled', true);
						$("button[name*='deleteButton']")
								.attr('disabled', true);
						createFormBook();
						for (i = 0; i < e.data.length; i++)
							if (e.data[i] == e.currentTarget.id)
								break;
						$.post("admin?action=listAttrofBook&id="+e.currentTarget.id, ajaxLoadAttrs);
						var newElem = '<h2>Edit "'+ e.data[++i]+'"</h2>';
						$('#bookEditDetail-header').append(newElem);
						$('#bookName').val(e.data[i]);
						$('#bookEditDetail').modal('show');
					}
					
					function ajaxLoadAttrs(data){
						
					}

					function deleteBooks(e) {

					}
				});
