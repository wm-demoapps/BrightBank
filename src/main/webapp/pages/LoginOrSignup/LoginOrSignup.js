/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/* perform any action on widgets/variables within this block */
Page.onReady = function() {
    /*
     * variables can be accessed through 'Page.Variables' property here
     * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
     * Page.Variables.loggedInUser.getData()
     *
     * widgets can be accessed through 'Page.Widgets' property here
     * e.g. to get value of text widget named 'username' use following script
     * 'Page.Widgets.username.datavalue'
     */
    autoFillDemoUser();
};

// To support Demo Studio LaunchUp login
function autoFillDemoUser() {
    if (Page.pageParams.persona !== undefined) {
        switch (Page.pageParams.persona) {
            case 'User':
                Page.Widgets.j_username.datavalue = 'wmuser@wm.com';
                Page.Widgets.j_password.datavalue = 'Wavemaker@123';
                break;
            case 'PowerUser':
                Page.Widgets.j_username.datavalue = 'john.vick@wm.com';
                Page.Widgets.j_password.datavalue = 'Wavemaker@123';
                break;
            case 'Admin':
                Page.Widgets.j_username.datavalue = 'joe.root@gmail.com';
                Page.Widgets.j_password.datavalue = 'Wavemaker@123';
                break;
            default:
                // code
        }
    }
}
