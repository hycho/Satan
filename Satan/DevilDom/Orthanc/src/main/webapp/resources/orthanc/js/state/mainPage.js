orthanc.mainPage = function (game) {
	this.pageBodyImg;
};

orthanc.mainPage.prototype = {
	preload: function () {
		this.game.load.image('pageBodyImg', window.orthanc.ctxOpt.resourcesPath + '/images/tower/TowerMain.PNG');
		
	},
	create: function () {
		this.pageBodyImg = this.game.add.image(0, 0, 'pageBodyImg');
	},
	update: function () {

	}
};