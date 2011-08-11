<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="qard"%>

<qard:generic-page title="jsp.display.title">

<div class="pregame">
	<a href="#" class="start">Start</a>
	
	Use your phone to scan the QR code or go to <span class="joinLink"></span> to join this game.
</div>

<div class="players">
</div>

<div id="allQards">
	<div class="qard CLUBS 1" style="background-position: 0px 0px;"></div>
	<div class="qard CLUBS 2" style="background-position: -79px 0px;"></div>
	<div class="qard CLUBS 3" style="background-position: -158px 0px;"></div>
	<div class="qard CLUBS 4" style="background-position: -237px 0px;"></div>
	<div class="qard CLUBS 5" style="background-position: -316px 0px;"></div>
	<div class="qard CLUBS 6" style="background-position: -395px 0px;"></div>
	<div class="qard CLUBS 7" style="background-position: -474px 0px;"></div>
	<div class="qard CLUBS 8" style="background-position: -553px 0px;"></div>
	<div class="qard CLUBS 9" style="background-position: -632px 0px;"></div>
	<div class="qard CLUBS 10" style="background-position: -711px 0px;"></div>
	<div class="qard CLUBS 11" style="background-position: -790px 0px;"></div>
	<div class="qard CLUBS 12" style="background-position: -869px 0px;"></div>
	<div class="qard CLUBS 13" style="background-position: -948px 0px;"></div>
	<div class="qard DIAMONDS 1" style="background-position: 0px -123px;"></div>
	<div class="qard DIAMONDS 2" style="background-position: -79px -123px;"></div>
	<div class="qard DIAMONDS 3" style="background-position: -158px -123px;"></div>
	<div class="qard DIAMONDS 4" style="background-position: -237px -123px;"></div>
	<div class="qard DIAMONDS 5" style="background-position: -316px -123px;"></div>
	<div class="qard DIAMONDS 6" style="background-position: -395px -123px;"></div>
	<div class="qard DIAMONDS 7" style="background-position: -474px -123px;"></div>
	<div class="qard DIAMONDS 8" style="background-position: -553px -123px;"></div>
	<div class="qard DIAMONDS 9" style="background-position: -632px -123px;"></div>
	<div class="qard DIAMONDS 10" style="background-position: -711px -123px;"></div>
	<div class="qard DIAMONDS 11" style="background-position: -790px -123px;"></div>
	<div class="qard DIAMONDS 12" style="background-position: -869px -123px;"></div>
	<div class="qard DIAMONDS 13" style="background-position: -948px -123px;"></div>
	<div class="qard HEARTS 1" style="background-position: 0px -246px;"></div>
	<div class="qard HEARTS 2" style="background-position: -79px -246px;"></div>
	<div class="qard HEARTS 3" style="background-position: -158px -246px;"></div>
	<div class="qard HEARTS 4" style="background-position: -237px -246px;"></div>
	<div class="qard HEARTS 5" style="background-position: -316px -246px;"></div>
	<div class="qard HEARTS 6" style="background-position: -395px -246px;"></div>
	<div class="qard HEARTS 7" style="background-position: -474px -246px;"></div>
	<div class="qard HEARTS 8" style="background-position: -553px -246px;"></div>
	<div class="qard HEARTS 9" style="background-position: -632px -246px;"></div>
	<div class="qard HEARTS 10" style="background-position: -711px -246px;"></div>
	<div class="qard HEARTS 11" style="background-position: -790px -246px;"></div>
	<div class="qard HEARTS 12" style="background-position: -869px -246px;"></div>
	<div class="qard HEARTS 13" style="background-position: -948px -246px;"></div>
	<div class="qard SPADES 1" style="background-position: 0px -369px;"></div>
	<div class="qard SPADES 2" style="background-position: -79px -369px;"></div>
	<div class="qard SPADES 3" style="background-position: -158px -369px;"></div>
	<div class="qard SPADES 4" style="background-position: -237px -369px;"></div>
	<div class="qard SPADES 5" style="background-position: -316px -369px;"></div>
	<div class="qard SPADES 6" style="background-position: -395px -369px;"></div>
	<div class="qard SPADES 7" style="background-position: -474px -369px;"></div>
	<div class="qard SPADES 8" style="background-position: -553px -369px;"></div>
	<div class="qard SPADES 9" style="background-position: -632px -369px;"></div>
	<div class="qard SPADES 10" style="background-position: -711px -369px;"></div>
	<div class="qard SPADES 11" style="background-position: -790px -369px;"></div>
	<div class="qard SPADES 12" style="background-position: -869px -369px;"></div>
	<div class="qard SPADES 13" style="background-position: -948px -369px;"></div>
</div>

<script src="/js/jquery.min.js"></script>
<script>

$('.start').click(function(e) {
	$.post('start'); // TODO send adminId along
	e.preventDefault();
});

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
		
		if(data.started) {
			$('.qard').hide();
			var suit = data.openCard.suit;
			var number = data.openCard.number;
			$('.qard.'+suit+'.'+number).show();
		}
		
		gameState = data;
		setTimeout(poll, 2000);
	});
}

poll();
</script>


</qard:generic-page>
