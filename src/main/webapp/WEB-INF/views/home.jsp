<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="qard"%>

<qard:generic-page title="jsp.home.title">

<div>
	Create <a href="/game/create">new game</a>
</div>

<div>
	<ul>
		<c:forEach items="${games}" var="game">
			<li>
				Game ${game.id}
				<a href="/game/${game.id}/display">Display</a>
				<c:if test="${!game.started}">
					<a href="/game/${game.id}/join">Join</a>
				</c:if>
			</li>
		</c:forEach>
	</ul>
</div>

</qard:generic-page>
