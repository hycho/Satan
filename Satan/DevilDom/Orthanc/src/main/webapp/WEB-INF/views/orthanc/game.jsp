<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="resourcesPath" value="${pageContext.request.contextPath}/resources" />

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
	if(!window.orthanc) {
		window['orthanc'] = {
			ctxOpt : {
				contextPath : '${contextPath}',
				resourcesPath : '${resourcesPath}'
			}
		}
	}
	
	// onload
	window.onload = function() {
		
		var game = new Phaser.Game(640, 360, Phaser.AUTO, 'orthanc');
		
		game.state.add('mainMenu', orthanc.mainMenu);
		game.state.add('mainPage', orthanc.mainPage);
		game.state.start('mainMenu');
		
	};
	
</script>
<title>Orthanc</title>
</head>
<body>
<script src="${resourcesPath}/js/phaser.js"></script>
<script src="${resourcesPath}/js/state/mainMenu.js"></script>
<script src="${resourcesPath}/js/state/mainPage.js"></script>
</body>
</html>