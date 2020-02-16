Ext.define('MyApp.view.main.CardLayout', {
	extend : 'Ext.panel.Panel',
	xtype : 'cardLayout',
	title : 'Layouts',
	items : [ {
		itemId:'button1',
		xtype : 'button',
		text : 'button1',
		handler:function(cmp){
			debugger;
			cmp.next('#layout').setActiveItem('absolute1');
		}
	}, {
		itemId:'button2',
		xtype : 'button',
		text : 'button2',
		handler:function(cmp){
			debugger;
			cmp.next('#layout').setActiveItem('absolute2');
		}
	},{
		itemId:'layout',
		layout : 'card',
		width : 1000,
		height : 600,
		border : 1,
		margin : '20 0 50 0 ',
		items : [ {
			itemId:'absolute1',
			layout : 'absolute',
			width : 400,
			height : 600,
			items : [ {
				title : 'Absolute Layout1',
				x : 0,
				y : 0,
				width : 300,
				height : 200,
				border : 1
			} ]
		}, {
			itemId:'absolute2',
			layout : 'absolute',
			width : 400,
			height : 600,
			items : [ {
				title : 'Absolute Layout2',
				x : 0,
				y : 0,
				width : 300,
				height : 200,
				border : 1
			} ]
		} ]

	} ]

});