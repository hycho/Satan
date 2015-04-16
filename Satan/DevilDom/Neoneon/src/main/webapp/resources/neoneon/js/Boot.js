var BasicGame = {}; 

BasicGame.Boot = function (game) {
	this.ball;
	this.graphics;
	this.arc2 = 1;
	this.bullet_group;
};

BasicGame.Boot.prototype = {
    preload: function () { 
        this.game.load.image('test', neoneon.ctxOpt.resourcesPath+'/images/test.png');
        
//hycho 추가
        this.game.load.image('ball', neoneon.ctxOpt.resourcesPath+'/images/shinyball.png');
    },

    create: function () { 
    	this.game.physics.startSystem(Phaser.Physics.ARCADE);

        if (this.game.device.desktop)
        {
            this.scale.scaleMode = Phaser.ScaleManager.SHOW_ALL;
            this.scale.pageAlignHorizontally = true;
        }
        else
        {
            this.scale.scaleMode = Phaser.ScaleManager.SHOW_ALL;
            this.scale.minWidth = 150;
            this.scale.minHeight = 250;
            this.scale.maxWidth = 600;
            this.scale.maxHeight = 1000;
            this.scale.forceLandscape = false;
            this.scale.pageAlignHorizontally = true; 
            this.scale.setScreenSize(true); 
        } 

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
            bullet_group.add(test);
            tw.onComplete.add(function(){
                test.destroy();
            } ,this);
        } 


        var this_state = this;
        var this_bullet_group = this.game.add.group(); 
        this.bullet_group = this_bullet_group;
        console.log(this.bullet_group);
        this.bullet_group.enableBody = true;
        
        setInterval(function(){
            addBullets(this_state, this_bullet_group);
        }, 500);

// hycho 추가
        var centerX = this.game.world.centerX;
    	var centerY = this.game.world.centerY;
        this.ball = this.game.add.sprite(centerX, centerY, 'ball');

		this.graphics = this.game.add.graphics(this.game.world.centerX+15, this.game.world.centerY+15);
        this.graphics.lineStyle(15, 0xffd900);
	    this.graphics.arc(0, 0, 50, 0, this.arc2, false);
	    
	    this.sprite = this.game.add.sprite(this.game.world.centerX+15, this.game.world.centerY+15, this.graphics.generateTexture());
	    this.sprite.anchor.setTo(1.5, 1.5);
	    this.game.physics.enable(this.sprite, Phaser.Physics.ARCADE);
	    
    },
    update: function(){
    	//this.graphics.rotation = this.game.physics.arcade.angleToPointer(this.graphics) + Math.PI*1.9;
    	this.sprite.rotation = this.game.physics.arcade.angleToPointer(this.sprite) + Math.PI*1.9;
       	//console.log(this.game.physics.arcade.angleToPointer(this.sprite) + Math.PI*1.9);
    	//this.game.physics.arcade.overlap(this.sprite, this.bullet_group, this.collectMissile, null, this);
    	//hycho 추가
    	//if (this.game.input.mousePointer.isDown) {
    		//this.arc2 += 0.1;
    		//this.graphics.arc(0, 0, 100, 0, this.arc2, false);
    		//this.sprite.body.velocity.x = 10;
    		//this.game.physics.arcade.accelerationFromRotation(this.sprite.rotation, 1000, this.sprite.body.acceleration);
    	//} else {
    		//this.sprite.body.acceleration.set(0);
    	//}
    		
    	
    },
    collectMissile: function(ball, missile) {
    	console.log("D");
        // Removes the star from the screen1
    	missile.kill();

        // Add and update the score
        //score += 10;
        //scoreText.text = 'Score: ' + score;

    },
    render: function() {
    	

  	    this.game.debug.spriteInfo(this.sprite, 32, 32);
    	
    }

};


 