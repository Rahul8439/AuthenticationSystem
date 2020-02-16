Ext.define('MyApp.view.main.Test', {
	extend : 'Ext.panel.Panel',
	xtype : 'test',
	title : 'Layouts',
	
	items : [ {

		layout : 'border',
		width : 1000,
		height : 600,
		border : 1,
		margin : '20 0 50 0 ',
		items : [ {
			itemId : 'nav',
			title : 'Navigation',
			region : 'west',
			collapsible : true,
			border : 1,
			width : 300
		}, {
			title : 'Main',
			region : 'center',
			collapsible : false,
			border : 1,
			items : [ {
				xtype : 'button',
				text : 'Hide nav',
				handler : function(cmp) {
					var hide = cmp.up().prev('#nav');
					hide.toggleCollapse();
				}
			}, {
				xtype : 'button',
				text : 'card1'
			}, {
				xtype : 'button',
				text : 'card2'
			} ]
		}, {
			title : 'Header',
			region : 'north',
			collapsible : true,
			border : 1,
			height : 200
		}, {
			title : 'Footer',
			region : 'south',
			collapsible : true,
			border : 1,
			height : 200,
		} ]
	} ]

});