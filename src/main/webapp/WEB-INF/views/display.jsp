<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Qardgame</title>
	<link rel="stylesheet" href="/css/default.css" type="text/css">
</head>
<body>
TODO display the public game state<br />
gameId: ${gameId}

<div id="debug">
</div>

<script src="/js/jquery.min.js"></script>
<script>
// TODO poll the server:
$.getJSON('displaystate', function(data) {
	$('#debug').html(data);
});
</script>
</body>
</html>
