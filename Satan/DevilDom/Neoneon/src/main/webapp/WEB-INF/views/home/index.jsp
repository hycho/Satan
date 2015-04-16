<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="resourcesPath" value="${pageContext.request.contextPath}/resources" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Orthanc</title>
<script>
	if(!window.orthanc) {
		window['neoneon'] = {
			ctxOpt : {
				contextPath : '${contextPath}',
				resourcesPath : '${resourcesPath}'
			}
		}
	}
</script>
</head>
<body style="margin:0px;" bgcolor="#000000">

<div id="gameContainer"></div>

<script type="text/javascript">
	window.onload = function() { 
	var game = new Phaser.Game(640, 480, Phaser.AUTO, 'gameContainer'); 
	game.state.add('Boot', BasicGame.Boot);
	//game.state.add('Preloader', BasicGame.Preloader);
	//game.state.add('MainMenu', BasicGame.MainMenu);
	game.state.add('Game', BasicGame.Game);
	//game.state.add('EndScreen',BasicGame.EndScreen); 
	game.state.start('Boot');
};

</script>
<script src="${resourcesPath}/libs/phaser.js"></script>
<script src="${resourcesPath}/libs/underscore-min.js"></script>

<!-- Setup game Neoneon -->
<script src="${resourcesPath}/js/Boot.js"></script>
<script src="${resourcesPath}/js/Preloader.js"></script>
<script src="${resourcesPath}/js/Game.js"></script>

</body>
</html>