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
    // Page.Widgets.NewEndUserDialog.open();
};

Page.User_Registration1Enduseradd = function($event, $data) {
    debugger
    App.Variables.AddedConsumerInfo.dataSet = $data;
    App.Actions.goToPage_CreateLoginCredentials.invoke({
        data: {
            identityId: App.Variables.AddedConsumerInfo.dataSet.endUserId
        }
    });
};
