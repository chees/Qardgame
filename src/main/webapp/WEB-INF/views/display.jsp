<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="qard"%>

<qard:generic-page title="jsp.display.title">

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


</qard:generic-page>
