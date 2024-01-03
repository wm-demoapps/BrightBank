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
    /*
    switch (key) {
        case "prop1":
            // do something with newVal for property 'prop1'
            break;
        case "prop2":
            // do something with newVal for property 'prop2'
            break;
    }
    */
};

Prefab.onReady = function() {
    // this method will be triggered post initialization of the prefab.
    Prefab.Widgets.list1.pagesize = Prefab.itemsperpage;
};

Prefab.button3Click = function($event, widget, item, currentItemWidgets) {
    Prefab.onTransferfundsclick(widget, item);
};

/*
 * on adding a ledger, invoke this method to view latest ledger info in the list
 */
Prefab.refreshLedgers = function () {
    Prefab.Variables.JS_getManagedAccounts.invoke();
};

Prefab.maskAccountNumber = function(accountNumber) {
    var num = accountNumber.substring(0, 10);
    return num.replace(new RegExp("[0-9]{0,1}", "g"), "X") + '-' + accountNumber.substring(14, 18);
};

Prefab.getAccountNumber = function(accountNumber) {
    lastDigitsOfAccount = accountNumber.slice(accountNumber.length - 4);
    return "XXXX-XXXX" + lastDigitsOfAccount;
};
Prefab.list1Select = function(widget, $data) {
    Prefab.onLedgerselect(widget, $data);
};


Prefab.JS_getManagedAccountsonSuccess = function(variable, data) {
    Prefab.onAccountscount(data.length);
};
