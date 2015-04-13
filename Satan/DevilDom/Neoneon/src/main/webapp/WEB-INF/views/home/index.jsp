<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="resourcesPath" value="${pageContext.request.contextPath}/resources" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
	if(!window.orthanc) {
		window['neoneon'] = {
			ctxOpt : {
				contextPath : '${contextPath}',
				resourcesPath : '${resourcesPath}'
			}
		}
	}
	
	// onload
	window.onload = function() {
		var game = new Phaser.Game(640, 360, Phaser.AUTO, 'neoneon');
		
		game.state.add('boot', neoneon.Boot);
		game.state.add('preloader', neoneon.Preloader);
		game.state.add('mainMenu', neoneon.MainMenu);
		game.state.add('game', neoneon.Game);
		
		game.state.start('boot');
	};
	
</script>
<title>Orthanc</title>
</head>
<body>
<script src="${resourcesPath}/js/phaser.js"></script>

<!-- Setup game Neoneon -->
<script src="${resourcesPath}/js/setup/boot.js"></script>
<script src="${resourcesPath}/js/setup/preloader.js"></script>
<script src="${resourcesPath}/js/setup/mainMenu.js"></script>

<!-- Develop game Neoneon -->
<script src="${resourcesPath}/js/game/game.js"></script>
</body>
</html>