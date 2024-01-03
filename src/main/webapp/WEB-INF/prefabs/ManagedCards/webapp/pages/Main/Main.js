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
    // handlePropertyChangeInStudioMode(key, newVal, oldVal);
    // switch (key) {
    //     case "authtoken":
    //         console.log("onproperty change" + Prefab.cardtype);
    //         Prefab.Widgets.container1.content = Prefab.cardtype;
    //         break;
    // }

};

Prefab.onReady = function() {
    // this method will be triggered post initialization of the prefab.
    // window.OpcUxSecureClient.init(Prefab.uikey);
    // console.log("onready" + Prefab.cardtype);
    // Prefab.Widgets.container1.content = Prefab.cardtype;
};

Prefab.calculateExpiryDate = function(expiryDate) {
    if (expiryDate) {
        return expiryDate.substring(0, 2) + '/' + expiryDate.substring(2, 4);
    }
};

/*
 * Refresh Managed Cards
 */
Prefab.refreshCards = function () {
    Prefab.Widgets.container1.Variables.JS_getAllManagedCards.invoke();
};

/*
 * Total Available Balance present in all the cards
 */
Prefab.totalBalance = function () {
    var totalBalance = 0;
    var data = Prefab.Widgets.container1.Widgets.list1.dataset;
    for (var i = 0; i < data.length; i++) {
        totalBalance = totalBalance + data[i].balances.availableBalance;
    }
    return (data[0].currency == "EUR" ? "€ " : data[0].currency == "USD" ? "$" : "£") + (totalBalance / 100).toFixed(2);
};
