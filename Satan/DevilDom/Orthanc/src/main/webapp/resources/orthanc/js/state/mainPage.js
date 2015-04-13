orthanc.mainPage = function (game) {
	this.pageBodyImg;
	this.topBar;
	this.keyBar;
	this.goldBar;
	this.robyBar;
	this.honerBar;
	
};

orthanc.mainPage.prototype = {
	preload: function () {
		this.game.load.image('pageBodyImg', window.orthanc.ctxOpt.resourcesPath + '/images/tower/TowerMain.PNG');
		this.load.atlas('skin01'
				, window.orthanc.ctxOpt.resourcesPath + '/images/tower/uc_skin_01.png'
				, window.orthanc.ctxOpt.resourcesPath + '/images/tower/uc_skin_01.json');
		
	},
	create: function () {
		this.pageBodyImg = this.game.add.image(0, 0, 'pageBodyImg');
		
		this.topBar = this.game.add.tileSprite(0, 0, 640, 50, 'skin01', 'title.png');
		this.topBar.tileScale.x = 1.25;
		this.topBar.tileScale.y = 0.95;
		
		this.keyBar = this.game.add.tileSprite(20, 7, 135, 35, 'skin01', 'headerBubble.png');
		this.keyBar.tileScale.x = 2;
		this.keyBar.tileScale.y = 0.7;
		
		this.goldBar = this.game.add.tileSprite(160, 7, 135, 35, 'skin01', 'headerBubble.png');
		this.goldBar.tileScale.x = 2;
		this.goldBar.tileScale.y = 0.7;
		
		this.robyBar = this.game.add.tileSprite(300, 7, 135, 35, 'skin01', 'headerBubble.png');
		this.robyBar.tileScale.x = 2;
		this.robyBar.tileScale.y = 0.7;
		
		this.honerBar = this.game.add.tileSprite(20, 7, 135, 35, 'skin01', 'headerBubble.png');
		this.honerBar.tileScale.x = 2;
		this.honerBar.tileScale.y = 0.7;
		
	},
	update: function () {

	}
};