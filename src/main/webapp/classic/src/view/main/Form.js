Ext.define('MyApp.view.main.Form', {
    extend: 'Ext.form.Panel',
    xtype: 'login',

    title: 'Login',
    frame:true,
    width: 320,
    bodyPadding: 10,

    defaultType: 'textfield',

    items: [{
        allowBlank: false,
        fieldLabel: 'User ID',
        itemId:'user',
        name: 'user',
        emptyText: 'user id'
    }, {
        allowBlank: false,
        fieldLabel: 'Password',
        name: 'pass',
        itemId:'pass',
        emptyText: 'password',
        inputType: 'password'
    }, {
        xtype:'checkbox',
        fieldLabel: 'Remember me',
        name: 'remember'
    }],

    buttons: [
        { text:'Register',
        	listeners: {
                click: 'onRegister'
            } },
        { text:'Login',listeners: {
            click: 'onLogin'
        } }
    ],

    defaults: {
        anchor: '100%',
        labelWidth: 120
    }
});