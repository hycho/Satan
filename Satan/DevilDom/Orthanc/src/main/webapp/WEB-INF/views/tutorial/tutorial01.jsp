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
	    game.load.image('ground', window.orthanc.ctxOpt.resourcesPath + '/images/assets/platform.png');
	    game.load.image('star', window.orthanc.ctxOpt.resourcesPath + '/images/assets/star.png');
	    game.load.spritesheet('dude', window.orthanc.ctxOpt.resourcesPath + '/images/assets/dude.png', 32, 48);
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
	    
	    // platforms의 create를 통해 땅을 뜻할 ground객체를 만든다.
	    var ground = platforms.create(0, game.world.height - 64, 'ground');
	    
	    //그라운드의 크기를 조절한다. width2배  height2배
	    ground.scale.setTo(2, 2);
	    
	    //점프할때 멀리떨어지는것을 중지한다 (?)
	    ground.body.immovable = true;
	    
		//두번째 다리를 생성한다.
	    var ledge = platforms.create(400, 400, 'ground');
		
	    ledge.body.immovable = true;

	    ledge = platforms.create(-150, 250, 'ground');

	    ledge.body.immovable = true;
	    
	 	// 플레이어를 세팅한다.(배치를 한다.);
	    player = game.add.sprite(32, game.world.height - 150, 'dude');

	    //  플레이어에 물리적용을 한다.
	    game.physics.arcade.enable(player);

	    // 플레이어의 물리 속성을 준다 바운스, 중력, collideWorldBounds는 먼지..
	    player.body.bounce.y = 0.2; //튕겨내는 정도
	    player.body.gravity.y = 1000; //높을수록 빨리 떨어진다.
	    player.body.collideWorldBounds = true; //world에서의 충돌여브 설정, 만약 false일 경우 땅으로 가라 앉아 버린다.

	    // 왼쪽, 오른쪽으로 움직이는 애니메이션 설정
	    player.animations.add('left', [0, 1, 2, 3], 10, true); //frame 0,1,2,3 반복 10이라는 속도로 
	    player.animations.add('right', [5, 6, 7, 8], 10, true); //frame 5,6,7,8 반복 10이라는 속도로
	    
	    // starts라는 그룹 생성
	    stars = game.add.group();
	    
	    // starts 에도 물리학 적용
	    stars.enableBody = true;
	    
	    for (var i = 0; i < 12; i++) {
	    	//  stars그룹을 통해 star를 생성한다. for문 안이니까 12개가 생성되겟지.
	        var star = stars.create(i * 70, 0, 'star');
	        star.body.gravity.y = 100;
	        star.body.bounce.y = 0.7 + Math.random() * 0.2;
	    }
	   
	    //Score를 위한 Text 객체 생성
	    scoreText = game.add.text(16, 16, 'score: 0', { fontSize: '32px', fill: '#000' });
	}
	
	function update() {
		//player객체와 platforms으로 생성한 모든 객체와의 충돌 물리 관련 설정을 해준다.
		//만약하지 않는다면 player는 모든 객체를 뚫어버린다.
		game.physics.arcade.collide(player, platforms);
		
		// game의 키를 제어하기 위한 객체를 생성
		cursors = game.input.keyboard.createCursorKeys();
		
		// 현재 플레이어를 기준으로 x값을 0으로 세팅 (초기화)
		player.body.velocity.x = 0;
		
		 // platforms와의 충돌 설정
	    game.physics.arcade.collide(stars, platforms);
	    
		// 플레이어와의 오버랩(겹칠때) collectStart를 실행
	    game.physics.arcade.overlap(player, stars, collectStar, null, this);
        
		if (cursors.left.isDown) { // left키를 눌럿을때(Down)
	        player.body.velocity.x = -150;
	        player.animations.play('left');
	    } else if (cursors.right.isDown) { // Right 키를 눌럿을때(Down)
	        player.body.velocity.x = 150;
	        player.animations.play('right');
	    } else { //cursors이벤트가 암것도 없을때? 아니 up을 하는 경우
	        player.animations.stop();
	        player.frame = 4;
	    }
		
		// up키를 누르거나, 캐릭이 땅에 닿아 있을때 쩜프 가능
	    if (cursors.up.isDown && player.body.touching.down) {
	        player.body.velocity.y = -700;
	    }
		
	    
	}
	
	function collectStar (player, star) {
		score += 10;
	    scoreText.text = 'Score: ' + score;
		//star가 제거 된다
	    star.kill();
	}
	
	
</script>
<title>Insert title here</title>
</head>
<body>
	Welcome to Orthanc.
</body>
</html>