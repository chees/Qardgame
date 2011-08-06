<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="qard"%>

<qard:generic-page title="jsp.display.title">

<div class="players">
</div>

<div class="pregame">
	<div class="start">
		<a href="start">Start</a>
	</div>
	
	User your phone to scan the QR code or go to <span class="joinLink"></span> to join the game.
</div>

<script src="/js/jquery.min.js"></script>
<script>

var joinLink = window.location.href.substring(0, window.location.href.length - 'display'.length) + 'join';
$('.joinLink').html(joinLink);
var qrsrc = 'http://chart.googleapis.com/chart?chs=128x128&cht=qr&chld=M|0&chl=' + encodeURIComponent(joinLink);
$('.pregame').append('<img src="'+qrsrc+'" />');

var gameState = {};

function poll() {
	$.getJSON('displaystate', function(data) {
		console.log(data);
		if(data.started && !gameState.started) {
			$('.pregame').hide('slow');
		}
		$('.players').html('');
		for(var i = 0; i < data.players.length; i++) {
			$('.players').append('<div>'+data.players[i]+'</div>');
		}
		gameState = data;
	});
	setTimeout(poll, 2000);
}

poll();
</script>


</qard:generic-page>
