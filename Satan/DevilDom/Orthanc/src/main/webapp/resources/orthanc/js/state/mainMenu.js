/**
 * Orthanc의 메인 메뉴 State
 */

orthanc.mainMenu = function (game) {
	this.main;
	this.main_down_anim;
	this.main_text1;
	this.button;
};

orthanc.mainMenu.prototype = {
	preload: function () {
		console.log(window.orthanc)
		this.game.load.image('main', window.orthanc.ctxOpt.resourcesPath + '/images/tower/main2.PNG');
		this.game.load.spritesheet('button', window.orthanc.ctxOpt.resourcesPath + '/images/tower/button_sprite_sheet.png', 193, 71);
	},
	create: function () {
		this.game.world.setBounds(0, 0, 1920, 1200);
		this.main = this.game.add.image(0, 0, 'main');
		this.main_down_anim = this.main.animations.add('down');
	    
		this.main_down_anim.play(1, true);
		this.main_down_anim.onLoop.add(this.animationLooped, this);
		this.main_down_anim.onComplete.add(this.animationStopped, this);
		
		//차후 제거 아래 주석
		this.button = this.game.add.button(230, 250, 'button', this.start, this, 2, 1, 0);
	},
	update: function () {

	},
	start: function() {
		this.game.state.start('mainPage');
	}, 
	update: function() {
		 if (this.main_down_anim.isPlaying) {
			 this.main.y -= 1;
	    }
	},
	animationLooped: function(sprite, animation) {
	    if (animation.loopCount === 7) {
	    	animation.loop = false;
	    }
	},
	animationStopped: function(sprite, animation) {
		this.main_text1 = this.game.add.text(260, 50, '- 신의 탑 -', { fill: 'white' });
		//this.button = this.game.add.button(230, 250, 'button', this.start, this, 2, 1, 0);
	}
};
