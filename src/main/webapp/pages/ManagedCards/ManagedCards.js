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

    Page.containsCards = true;
};

Page.ManagedCards1Cardscount = function($event, $data) {
    if ($event > 0) {
        Page.containsCards = true;
    } else Page.containsCards = false;
};



Page.ApplyManagedCard1Cardtypeselect = function($event, $data) {

    // $('[name="dialogApplyCard"]').css('width', '600px');
    // $('[name="wizard1"]').css('margin-top', '-1em');
    // $('[name="container3"]').css('margin-top', '-1em');
    // $('[name="cardholderMobileNumber_formWidget"]').css('margin-right', '2em')
    Page.Widgets.buttonCloseDialog.show = false;
    Page.Widgets.label2.show = false;
};
Page.ApplyManagedCard1Cardadd = function($event, $data) {

    // $('[name="dialogApplyCard"]').css('width', '510px');
    Page.Widgets.ManagedCards1.refreshCards();
    // $('[name="dialog2"]').css('width', '468px');
};
