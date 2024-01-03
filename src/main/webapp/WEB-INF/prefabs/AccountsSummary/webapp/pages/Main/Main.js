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
            if (Prefab.Variables.svGetAllAccounts) {
                calcualteAccountsTotal(Prefab.Variables.svGetAllAccounts.dataSet);
            }
            break;
    }
};

Prefab.onReady = function() {
    // this method will be triggered post initialization of the prefab.
};

Prefab.svGetAllAccountsonSuccess = function(variable, data) {
    calcualteAccountsTotal(data)
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

function calcualteAccountsTotal(data) {
    data = data ? data : {}
    let accounts = data.accounts && data.accounts.length > 0 ? data.accounts : [];
    let balance = 0;
    accounts.forEach(account => {
        balance += convertCurrency(account.currency, Prefab.basecurrency, account.balances.actualBalance)
    })
    Prefab.balance = balance;
}
