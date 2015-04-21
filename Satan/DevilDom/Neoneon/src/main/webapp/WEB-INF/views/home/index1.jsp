<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="resourcesPath" value="${pageContext.request.contextPath}/resources" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Orthanc</title>
<script src="${resourcesPath}/libs/phaser.js"></script>
<script src="${resourcesPath}/libs/p2.js"></script>
<script src="${resourcesPath}/libs/underscore-min.js"></script>
<script>
	if(!window.orthanc) {
		window['neoneon'] = {
			ctxOpt : {
				contextPath : '${contextPath}',
				resourcesPath : '${resourcesPath}'
			}
		}
	}
	
	var game = new Phaser.Game(800, 600, Phaser.CANVAS, 'phaser-example', { preload: preload, create: create, update: update });

	function preload() {
		this.game.load.image('test', neoneon.ctxOpt.resourcesPath+'/images/test.png');
		
	    game.load.image('vu', neoneon.ctxOpt.resourcesPath + '/images/vu.png');
	    game.load.image('ball', neoneon.ctxOpt.resourcesPath + '/images/arrow.png');
		game.load.image('sky', neoneon.ctxOpt.resourcesPath + '/images/cavern2.png');
	}

	var sprite;
	var cursors;
	var bullet_group;

	function create() {
		test();
		test1();
	}

	function update() {
		game.physics.arcade.overlap(sprite, bullet_group, collectMissile, null, this);
		
	    if (cursors.left.isDown)
	    {
	    	sprite.body.rotateLeft(50);
	    }
	    else if (cursors.right.isDown)
	    {
	    	sprite.body.rotateRight(50);
	    }
	}
	
	function test() {
		game.add.image(0, 0, 'sky');	//sky 배치

		//p2 물리 엔진 초기화
		game.physics.startSystem(Phaser.Physics.P2JS);

	    // sprite, vu1 배치
	    sprite = game.add.sprite(400, 300, 'ball');
	    var vu1 = game.add.sprite(400, 300, 'vu');
	    //this.game.physics.enable(sprite, Phaser.Physics.ARCADE);

	    //sprite, vu1 물리엔진 적용
		game.physics.p2.enable([sprite, vu1]);

	    // 충돌 판정 제거
	    sprite.body.clearCollision(true, true);
	    vu1.body.clearCollision(true, true);

	    var constraint = game.physics.p2.createRevoluteConstraint(sprite, [ 50, 100 ], vu1, [ 0, 0 ]);

	    text = game.add.text(20, 20, 'rotate with arrow keys', { fill: '#ffffff' });

	    cursors = game.input.keyboard.createCursorKeys();
	    
	    
	    game.physics.p2.setPostBroadphaseCallback(checkOverlap, this)
	}
	
	function test1() {
		this.game.physics.startSystem(Phaser.Physics.ARCADE);
		
		function addBullets(this_state, bullet_group){ 
           var test, dir;
           dir = Math.floor((Math.random() * 4) + 1) ; 
            switch( dir ){
                case 1:
                    test = this_state.game.add.sprite(0, Math.floor((Math.random() * this_state.game.world.height) + 1) , 'test');
                    break;
                case 2:
                    test = this_state.game.add.sprite(this_state.game.world.width, Math.floor((Math.random() * this_state.game.world.height) + 1), 'test');
                    break;
                case 3:
                    test = this_state.game.add.sprite(Math.floor((Math.random() * this_state.game.world.width) + 1), 0, 'test');
                    break;
                case 4:
                    test = this_state.game.add.sprite(Math.floor((Math.random() * this_state.game.world.width) + 1), this_state.game.world.height, 'test');
                    break;
                default:
                    break;
            } 
            /*이것이 네온효과. 포토샵의 필터와 같은데 뒤에 ADD 외에 스크린, 어둡게하기 등등많음 */
            test.blendMode = PIXI.blendModes.ADD;
            test.anchor.set(0.5); 
            
            var tw = this_state.game.add.tween(test).to( { y: this_state.game.world.centerY, x:this_state.game.world.centerX}, 2000, Phaser.Easing.Linear.None, true);
            game.physics.p2.enable(test);
            bullet_group.add(test);
            tw.onComplete.add(function(){
                test.destroy();
            } ,this);
        }
		
		var this_state = this;
        var this_bullet_group = game.add.group(); 
        bullet_group = this_bullet_group;
        console.log(this.bullet_group);
        this.bullet_group.enableBody = true;
        

        
        setInterval(function(){
            addBullets(this_state, bullet_group);
        }, 500);
        
	}
	
	function collectMissile(ball, missile) {
    	console.log("D");
    	missile.kill();
    }
	
	function checkOverlap(body1, body2) {
	    console.log("DDD");
	    
	}

</script>
</head>
<body style="margin:0px;" bgcolor="#000000">



</body>
</html>