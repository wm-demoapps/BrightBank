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
    Page.containsTransaction = true;
};

Page.List_Transactions1Transactioncount = function($event, $data) {
    if ($event > 0) {
        Page.containsTransaction = true;
    } else Page.containsTransaction = false;
};


Page.weavrFundAccountonBeforeUpdate = function(variable, inputData, options) {

};

Page.weavrFundAccountonSuccess = function(variable, data) {

    if (data.code == "COMPLETED") {
        setTimeout(function() {
            // Page.Widgets.Account_Details1.refreshLedgerInfo();
            // Page.Widgets.List_Transactions1.refreshTransactions();
            Page.Widgets.dialogFundAccount.close();
            Page.Widgets.Account_Details1.refreshLedgerInfo();
            Page.Widgets.List_Transactions1.refreshTransactions();
        }, 5000);
    }
};
Page.button4_1Click = function($event, widget) {
    Page.Widgets.spinnerFundAccount.show = true;
    Page.Variables.weavrFundAccount.invoke();
};
// Page.date1Change = function($event, widget, newVal, oldVal) {
//     Page.Widgets.List_Transactions1.setFilter(newVal);
// };
