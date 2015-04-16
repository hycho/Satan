BasicGame.Game = function (game) {
	this.ball;
	this.shield;
	this.graphics;
	this.arc2 = 1;
};


BasicGame.Game.prototype = {

    preload: function () { 
        this.game.load.image('ball', neoneon.ctxOpt.resourcesPath+'/images/shinyball.png');
        this.game.load.image('shild', neoneon.ctxOpt.resourcesPath+'/images/shinyball.png');
    },

    create: function () { 
    	var centerX = this.game.world.centerX;
    	var centerY = this.game.world.centerY;
        this.ball = this.game.add.sprite(centerX, centerY, 'ball');
        this.shield = this.game.add.sprite(centerX+15, centerY+15, 'shild');

        this.game.physics.enable(this.ball, Phaser.Physics.ARCADE);
        this.shield.anchor.set(1.5,1.5);

		this.graphics = this.game.add.graphics(this.game.world.centerX, this.game.world.centerY);
        this.graphics.lineStyle(10, 0xffd900);
	    this.graphics.arc(0, 0, 100, 0, this.arc2, false);
    },

    update: function () {
    	if (this.game.input.mousePointer.isDown) {
    		this.arc2 += 0.1;
    		this.graphics.arc(0, 0, 100, 0, this.arc2, false);
    	}
    	
    	this.graphics.rotation = this.game.physics.arcade.angleToPointer(this.shield) + Math.PI*1.9;
    	this.shield.rotation = this.game.physics.arcade.angleToPointer(this.shield) + Math.PI/1.3;
    }

};


 