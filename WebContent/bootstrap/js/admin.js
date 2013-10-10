$(document).ready(function () {
	$('#genres').on('show',showListGenres);
	$('#genres').on('hidden',hideListGenres);
	
	function showListGenres(e){
		$.post("admin?action=showListGenres",ajaxShowGenres);
	};
	
	function hideListGenres(e){
		$('#genres-body').empty();
	};
	
	function ajaxShowGenres(data){
		var arrayOfGenres=data.split(' ');
		var i;
		var newElem = '<table id="headTableGenre" class="table table-bordered"><thead><tr><th>Id</th><th>Genre</th><th>Edit</th></tr></thead></table>';
		$('#genres-body').append(newElem);
		newElem='<tbody id="tableGenre"></tbody>';
		$('#headTableGenre').append(newElem);
		for (i=0;i<arrayOfGenres.length;i++){
			newElem='<tr><td>'+(i+1)+'</td><td>'+arrayOfGenres[i]+'</td><td></td></tr>';
			$('#tableGenre').append(newElem);
		}
	};
	
});
