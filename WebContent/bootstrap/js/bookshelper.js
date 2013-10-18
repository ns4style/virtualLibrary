function createBootstrapCarousel(array) {
	var li = document.createElement('li');

	var carousel = document.createElement('div');
	carousel.setAttribute('class', 'carousel slide');
	carousel.setAttribute('id', 'myCarousel' + array[1]);

	carousel.innerHTML = ' \
                            <div class="carousel-inner"> \
                                    <div class="active item"> \
											<a data-toggle="modal"> \
                                            <img src="' + array[3] + '" width="110" height="70" class="img-polaroid" data-id="' + array[0] + '"> \
                                            </a> \
                                            \
                                            <div class="carousel-caption"> \
                                            	<h4>' + array[2] + '</h4> \
                                            </div> \
                                    </div> \
                                    \
                                    <div class="item"> \
                                            <a data-toggle="modal"> \
                                            <img src="' + array[4] + '" width="110" height="70" class="img-polaroid" data-id="' + array[0] + '"> \
                                            </a> \
                                            \
                                            <div class="carousel-caption"> \
                                            	<h4>' + array[2] + '</h4> \
                                            </div> \
                                    </div> \
                                    \
                                    <div class="item"> \
                                            <a data-toggle="modal"> \
                                            <img src="' + array[5] + '" width="110" height="70" class="img-polaroid" data-id="' + array[0] + '"> \
                                            </a> \
                                            \
                                            <div class="carousel-caption"> \
                                            	<h4>' + array[2] + '</h4> \
                                            </div> \
                                    </div> \
                            </div>';

	li.appendChild(carousel);
	return li;
}

function addPageButtonCollection(element, count) {
	if (count > 0) {
		var prev_button = document.createElement('button');
		prev_button.setAttribute('class', 'prev');
		prev_button.appendChild(document.createTextNode("prev"));
		$(element).append(prev_button);
	}
	
	for(var i=1; i<=count; i++) {
		var button = document.createElement('button');
		button.setAttribute('class', i);
		button.appendChild(document.createTextNode(i));
		$(element).append(button);
	}
	
	if (count > 0) {		
		var next_button = document.createElement('button');
		next_button.setAttribute('class', 'next');
		next_button.appendChild(document.createTextNode("next"));
		$(element).append(next_button);
	}
}

function addPageLiCollection(element, count) {
	for(var i=0; i<count; i++) {
		var li = document.createElement('li');
		li.setAttribute('id', 'li' + i);
		li.setAttribute('style', 'overflow: hidden; float: left; width: 990px; height: 263px;');
		$(element).append(li);
	}
}