/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/*
 * This function will be invoked when any of this prefab's property is changed
 * @key: property name
 * @newVal: new value of the property
 * @oldVal: old value of the property
 */
Prefab.onPropertyChange = function(key, newVal, oldVal) {
    // switch (key) {
    //     case "prop1":
    // do something with newVal for property 'prop1'
    // break;
    // }
};

Prefab.onReady = function() {
    // this method will be triggered post initialization of the prefab.
};

/*
 * this method will refresh the ledger info when any amount is funded to the ledger
 */
Prefab.refreshLedgerInfo = function () {
    Prefab.Variables.JS_getManagedAccountById.invoke({
        inputFields: {
            "hostName": Prefab.servicehost,
            "authorization": Prefab.authtoken,
            "accountId": Prefab.ledgerid
        }
    });
};

Prefab.maskAccountNumber = function(accountNumber) {
    var num = accountNumber.substring(0, 10);
    return num.replace(new RegExp("[0-9]{0,1}", "g"), "X") + '-' + accountNumber.substring(14, 18);
};

Prefab.buttonTransferFundsClick = function($event, widget) {
    Prefab.onTransferfundsclick();
};
Prefab.buttonFundAccountClick = function($event, widget) {
    Prefab.onFundaccountclick();
};
