var BasicGame = {}; 

BasicGame.Boot = function (game) {
	this.spaceShip;	//가장 주측이 될 모함 (이것을 최종 방어를 해야한다.)
	this.missileGroup;	// 사방에서 날라오는 공을 그룹화 할 bullet
	this.gundam;
	
	this.cursors;
	this.wasd;
};

BasicGame.Boot.prototype = {
    preload: function () { 
    	// 리소스 로드
    	this.game.load.image('spaceShip', neoneon.ctxOpt.resourcesPath+'/images/shinyball.png');	//모선
    	this.game.load.image('missile', neoneon.ctxOpt.resourcesPath+'/images/test.png');			//미사일
        this.game.load.image('gundam', neoneon.ctxOpt.resourcesPath+'/images/arrow.png');			//미사일을 막는 건담
    },
    create: function () { 
    	this.game.physics.startSystem(Phaser.Physics.ARCADE);	//물리엔진 초기화

    	// 최초 디바이스 위치 설정
        if (this.game.device.desktop) {
            this.scale.scaleMode = Phaser.ScaleManager.SHOW_ALL;
            this.scale.pageAlignHorizontally = true;
        }
        else {
            this.scale.scaleMode = Phaser.ScaleManager.SHOW_ALL;
            this.scale.minWidth = 150;
            this.scale.minHeight = 250;
            this.scale.maxWidth = 600;
            this.scale.maxHeight = 1000;
            this.scale.forceLandscape = false;
            this.scale.pageAlignHorizontally = true; 
            this.scale.setScreenSize(true); 
        } 

        // 미사일 생성 로직
        function addMissile(thisObj, missileGroup) {
        	var missile;
        	var startAreaFlag = Math.floor((Math.random() * 4) + 1); 
           
        	switch(startAreaFlag) {
           		case 1:
           			missile = thisObj.game.add.sprite(0, Math.floor((Math.random() * thisObj.game.world.height) + 1) , 'missile');
                    break;
                case 2:
                	missile = thisObj.game.add.sprite(thisObj.game.world.width, Math.floor((Math.random() * thisObj.game.world.height) + 1), 'missile');
                    break;
                case 3:
                	missile = thisObj.game.add.sprite(Math.floor((Math.random() * thisObj.game.world.width) + 1), 0, 'missile');
                    break;
                case 4:
                	missile = thisObj.game.add.sprite(Math.floor((Math.random() * thisObj.game.world.width) + 1), thisObj.game.world.height, 'missile');
                    break;
                default:
                    break;
            } 
        	
            /*이것이 네온효과. 포토샵의 필터와 같은데 뒤에 ADD 외에 스크린, 어둡게하기 등등많음 */
        	missile.blendMode = PIXI.blendModes.ADD;
        	missile.anchor.set(0.5); 
            
            var tw = thisObj.game.add.tween(missile).to({ y: thisObj.game.world.centerY, x:thisObj.game.world.centerX}, 2000, Phaser.Easing.Linear.None, true);
            missileGroup.add(missile);
            
            tw.onComplete.add(function() {
            	missile.destroy();
            } ,this);
        }

        var thisObj = this;
        var virMissileGroup = this.game.add.group(); 
        this.missileGroup = virMissileGroup;
        this.missileGroup.enableBody = true;
        
        setInterval(function(){
            addMissile(thisObj, virMissileGroup);
        }, 1000);

        //center좌표 저장
        var centerX = this.game.world.centerX;
    	var centerY = this.game.world.centerY;
        
    	//spaceShip, 방어막등 리소스 최초 위치 설정
    	this.spaceShip = this.game.add.sprite(centerX, centerY, 'spaceShip');
        this.gundam = this.game.add.sprite(centerX-10, centerY-10, 'gundam');
		
        // gundam에 ARCADE 물리엔진 적용 (충돌을 위해서)
	    this.game.physics.enable(this.gundam, Phaser.Physics.ARCADE);
	    
	    this.cursors = this.game.input.keyboard.createCursorKeys();
        this.wasd = {
            up: this.game.input.keyboard.addKey(Phaser.Keyboard.W),
            down: this.game.input.keyboard.addKey(Phaser.Keyboard.S),
            left: this.game.input.keyboard.addKey(Phaser.Keyboard.A),
            right: this.game.input.keyboard.addKey(Phaser.Keyboard.D),
        };
    },
    update: function() {
    	this.game.physics.arcade.moveToPointer(this.gundam, 200);
    	this.game.physics.arcade.overlap(this.gundam, this.missileGroup, this.collectMissile, null, this);
    	
    //  Reset the players velocity (movement)
    
        if (this.wasd.up.isDown) {
        	this.spaceShip.y -= 1;
        } 
        
        if (this.wasd.down.isDown) {
        	this.spaceShip.y += 1;
        } 
        
        if (this.wasd.left.isDown) {
        	this.spaceShip.x -= 1;
        } 
        
        if (this.wasd.right.isDown) {
        	this.spaceShip.x += 1;
        }
        
    },
    collectMissileTo: function(spaceShip, missile) {
    	console.log("D");
    	missile.kill();

        // Add and update the score
        //score += 10;
        //scoreText.text = 'Score: ' + score;

    }
    
};


 