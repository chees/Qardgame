<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="qard"%>

<qard:generic-page title="jsp.join.title">

<form method="post" action="join">
	What is your name?
	<input name="name" id="name" /><br />
	<input type="submit" value="Join" />
</form>

<script>
document.getElementById('name').focus();
</script>

</qard:generic-page>
