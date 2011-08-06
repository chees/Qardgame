<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="qard"%>

<qard:generic-page title="jsp.play.title">

<div>
	TODO show hand
</div>

<script src="/js/jquery.min.js"></script>
<script>
var gameState = {};

function poll() {
	$.getJSON('/game/${gameId}/state', function(data) {
		console.log(data);
		// TODO
		gameState = data;
	});
	setTimeout(poll, 2000);
}

poll();
</script>

</qard:generic-page>
