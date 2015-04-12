orthanc.mainPage = function (game) {
	this.pageBodyImg;
	this.topBar;
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
		topBar = this.game.add.tileSprite(0, 0, 640, 50, 'skin01', 'title.png');
		topBar.tileScale.x = 1.25;
		topBar.tileScale.y = 0.95;
		
	},
	update: function () {

	}
};