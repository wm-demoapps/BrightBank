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
    Page.containsAccounts = true;
};

Page.Managed_Accounts1Accountscount = function($event, $data) {
    if ($event > 0) {
        Page.containsAccounts = true;
    } else Page.containsAccounts = false;
};
// var accountId = "";
// Page.Create_Account1Ledgeradd = function($event, $data) {
//     debugger
//     accountId = $data.id;
//     if ($data.state == "ACTIVE") {
//         Page.Widgets.Managed_Accounts1.refreshLedgers();
//         Page.Widgets.dialogAddAccount.close();
//         Page.Widgets.dialogAccountSuccess.open();
//     } else {
//         Page.Actions.managedAccountActiveStateTimer.invoke();
//     }
// };

// Page.managedAccountActiveStateTimeronTimerFire = function(variable, data) {
//     debugger
//     Page.Variables.GetAccountDetailsById.invoke({
//         inputFields: {
//             id: accountId
//         }
//     }, function(data) {
//         if (data.state.state == "ACTIVE") {
//             Page.Widgets.Managed_Accounts1.refreshLedgers();
//             Page.Widgets.dialogAddAccount.close();
//             Page.Widgets.dialogAccountSuccess.open();
//         } else {
//             Page.Actions.managedAccountActiveStateTimer.invoke();
//         }
//     });
// };
