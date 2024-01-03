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
    switch (key) {
        case "basecurrency":
            if (Prefab.Variables.svGetAllCards) {
                calcualteCardsTotal(Prefab.Variables.svGetAllCards.dataSet)
            }
            break;
    }
};

Prefab.onReady = function() {
    // this method will be triggered post initialization of the prefab.
};

function convertCurrency(sourceCurrency, targetCurrency, amount) {
    const exchangeRates = new Map([
        ['USD', 1.0], // 1 USD = 1 USD
        ['EUR', 0.84], // 1 USD = 0.84 EUR
        ['GBP', 0.72], // 1 USD = 0.72 GBP
    ]);

    const exchangeRate = exchangeRates.get(targetCurrency) / exchangeRates.get(sourceCurrency);
    const convertedAmount = amount * exchangeRate;
    return convertedAmount;
}

Prefab.svGetAllCardsonSuccess = function(variable, data) {
    calcualteCardsTotal(data);
};

function calcualteCardsTotal(data) {
    data = data ? data : {}
    let cards = data.cards && data.cards.length > 0 ? data.cards : [];
    let balance = 0;
    cards.forEach(card => {
        balance += convertCurrency(card.currency, Prefab.basecurrency, card.balances.actualBalance)
    })
    Prefab.balance = balance;
}
