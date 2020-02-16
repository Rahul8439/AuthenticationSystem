/**
 * This class is the controller for the main view for the application. It is specified as
 * the "controller" of the Main view class.
 */
Ext.define('MyApp.view.main.MainController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.main',

    onItemSelected: function (sender, record) {
        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
    },
    getJsonData:function(cmp){
    	json={};
    	name=cmp.up('login').down('#user').getValue();
    	password=cmp.up('login').down('#pass').getValue();
    	json.name=name;
    	json.password=password;
    	
    	return json;
    },
    onRegister:function(cmp){
    	var me=this,
    	json=me.getJsonData(cmp);
    	url=window.location.href+'webapi/myresource';
    	url=(cmp.text=="Register")?url:url+'/login';
    	 Ext.Ajax.request({
    		 method:'POST',
    	     url: url,
    	     headers: { 'Content-Type': 'application/json; charset=utf-8' },
    	     jsonData:json,
    	     success: function(res) {
    	         alert(res.responseText);
    	     },
    	     failure: function(response, opts) {
    	         console.log('server-side failure with status code ' + response.status);
    	     }
    	 });
    	console.log(cmp);
    },
    onLogin:function(cmp){
    	var me=this;
    	me.onRegister(cmp)
    },
    onConfirm: function (choice) {
        if (choice === 'yes') {
            //
        }
    }
});
