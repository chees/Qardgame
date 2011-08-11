var gameState = {
	started: false,
	cards: [],
	yourTurn: false
};

$('.qard').click(function(){
	var qardSeperateClass = $(this).attr('class').split(' ');
	
	var data = {
		'cardNumber' : qardSeperateClass[2],
		'cardSuit' : qardSeperateClass[1],
		'userId' : 1 // TODO				
	};
	
	$.post('/game/'+gameId+'/play', data, function(data) {
		// TODO remove card from view?
	});
});


function poll() {
	$.getJSON('/game/'+gameId+'/state', function(data) {
		console.log(data);
		
		$('.qard').hide();
		for(var i = 0; i < data.cards.length; i++) {
			var suit = data.cards[i].suit;
			var number = data.cards[i].number;
			$('.qard.'+suit+'.'+number).show();
		}
		
		gameState = data;
		setTimeout(poll, 2000);
	});
}

poll();
