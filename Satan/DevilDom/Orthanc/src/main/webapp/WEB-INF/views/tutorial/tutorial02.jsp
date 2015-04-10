<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="resourcesPath" value="${pageContext.request.contextPath}/resources" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${resourcesPath}/js/phaser.js"></script>
<script>
	if(!window.orthanc) {
		window['orthanc'] = {
			ctxOpt : {
				contextPath : '${contextPath}',
				resourcesPath : '${resourcesPath}'
			}
		}
	}
	
	var game = new Phaser.Game(800, 600, Phaser.AUTO, '', { preload: preload, create: create, update: update });
	
	var platforms;
	var player;
	
	var cursors;
	var stars;
	var scoreText;
	var score = 0;
	
	function preload() {
	    game.load.image('sky', window.orthanc.ctxOpt.resourcesPath + '/images/assets/sky.png');
	    game.load.image('tower', window.orthanc.ctxOpt.resourcesPath + '/images/town1/transparent-bg-tiles.png');
	}
	
	function create() {
		// 물리엔진을 사용하겟다
	    game.physics.startSystem(Phaser.Physics.ARCADE);
		
	    // 0,0 좌표에 sky를 넣겟다.
	    game.add.sprite(0, 0, 'sky');

	    // patforms group 생성
	    platforms = game.add.group();
	    
	    // platforms객체를 통해 생성되는 모든 오브젝트는 물리학이 적용되도록 한다.
	    platforms.enableBody = true;
	    
		game.add.tilemap(32, game.world.height - 150, 'tower');
	}
	
	function update() {
		
	    
	}
	
	
</script>
<title>Tower of God</title>
</head>
<body>
	Welcome to Tower of God.
</body>
</html>