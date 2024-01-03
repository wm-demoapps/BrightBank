/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/* perform any action on widgets/variables within this block */
Partial.onReady = function() {
    /*
     * variables can be accessed through 'Partial.Variables' property here
     * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
     * Partial.Variables.loggedInUser.getData()
     *
     * widgets can be accessed through 'Partial.Widgets' property here
     * e.g. to get value of text widget named 'username' use following script
     * 'Partial.Widgets.username.datavalue'
     */
    App.Variables.consumerGet.invoke();
};

Partial.getGreetingTime = function() {
    var ndate = new Date();
    var hours = ndate.getHours();

    var message = hours < 12 ? 'Good Morning!' : hours < 18 ? 'Good Afternoon!' : 'Good Evening!';
    return message;
};
// Partial.pictureAccountMouseenter = function($event, widget) {
//     widget.picturesource = "resources/images/imagelists/ledger-active.svg";
// };
// Partial.pictureAccountMouseleave = function($event, widget) {
//     widget.picturesource = "resources/images/imagelists/ledger-normal.svg";
// };
// Partial.container1Mouseenter = function($event, widget) {
//     Partial.Widgets.pictureAccount.picturesource = "resources/images/imagelists/ledger-active.svg";
// };

// Partial.container1Mouseleave = function($event, widget) {
//     Partial.Widgets.pictureAccount.picturesource = "resources/images/imagelists/ledger-normal.svg";
// };
// Partial.container4Mouseenter = function($event, widget) {
//     Partial.Widgets.pictureAccount.picturesource = "resources/images/imagelists/ledger-active.svg";
// };

// Partial.container4Mouseleave = function($event, widget) {
//     Partial.Widgets.pictureAccount.picturesource = "resources/images/imagelists/ledger-normal.svg";
// };
Partial.ApplyManagedCard1Cardtypeselect = function($event, $data) {
    Partial.Widgets.buttonCloseDialog.show = false;
    Partial.Widgets.label2.show = false;
};
