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
    // window.OpcUxSecureClient.init(Prefab.uikey);
};

Prefab.calculateExpiryDate = function(expiryDate) {
    return expiryDate.substring(0, 2) + '/' + expiryDate.substring(2, 4);
};
Prefab.getAllManagedCardsList1Render = function(widget, $data) {
    debugger
};
Prefab.buttonFundCardClick = function($event, widget) {
    Prefab.onFundcardclick();
};
Prefab.buttonTransferFundsClick = function($event, widget) {
    Prefab.onFundcardclick();
};
Prefab.buttonChangeSpendLimitClick = function($event, widget) {
    Prefab.onChangespendlimit();
};

/*
 * Refresh card details after funding the card
 */
Prefab.refreshCards = function() {
    Prefab.Variables.getManagedCardById.invoke();
};
