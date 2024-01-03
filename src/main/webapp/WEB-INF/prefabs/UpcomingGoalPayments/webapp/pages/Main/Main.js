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
};

Prefab.accountHide = function(input) {
    //use slice to remove first 12 elements
    if (input && input.toLowerCase() !== 'n/a' && input.toLowerCase() !== null) {
        return '****' + input.substring(input.length - 4);
    } else {
        return '';
    }
};

Prefab.convertCurrency = function(sourceCurrency, targetCurrency, amount) {
    const exchangeRates = new Map([
        ['USD', 1.0], // 1 USD = 1 USD
        ['EUR', 0.84], // 1 USD = 0.84 EUR
        ['GBP', 0.72], // 1 USD = 0.72 GBP
    ]);

    const exchangeRate = exchangeRates.get(targetCurrency) / exchangeRates.get(sourceCurrency);
    const convertedAmount = amount * exchangeRate;
    return convertedAmount;
}

Prefab.getGoalsWithUpcomingDatesonSuccess = function(variable, data) {
    Prefab.onGoalslength(data.length);
};
