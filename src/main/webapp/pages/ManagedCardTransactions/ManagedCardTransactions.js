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

};
//Added on before submit
// Page.buttonMakePaymentClick = function($event, widget) {
//     debugger
//     Page.Widgets.spinnerFundAccount.show = true;
//     Page.Variables.SV_wvrCardPurchaseAtMerchant.invoke();
// };


Page.buttonSpendLimitClick = function($event, widget) {
    Page.Widgets.spinnerSpendLimit.show = true;
    //Page.Variables.SV_AddSpendRules.invoke();
    Page.Variables.SV_GetCardSpendRules.invoke();
};

Page.tabpane2Select = function($event, widget) {
    Page.Widgets.selectBaseCurrency.datavalue = "USD";
};

Page.SV_GetCardSpendRulesonSuccess = function(variable, data) {
    if (data.maxTransactionAmount > 0) {
        Page.Variables.SV_UpdateCardSpendRules.invoke();
    } else Page.Variables.SV_AddSpendRules.invoke();
};

Page.dialogFundAccountOpened = function($event, widget) {
    Page.Widgets.Md_CardPurchaseForm2.formfields['transactionAmount.amount'].setValidators([transactionAmount]);
};

function transactionAmount(field, form) {
    //debugger
    var managedCardBalance = parseFloat(Page.pageParams.managedCardBalance);
    var transactionAmount = parseFloat(Page.Widgets.transactionAmount_amount.datavalue);

    if (!isNaN(managedCardBalance) && !isNaN(transactionAmount) && managedCardBalance < transactionAmount) {
        return {
            errorMessage: "Insufficient funds."
        };
    } else if (!transactionAmount) {
        return {
            errorMessage: "Amount cannot be null/empty"
        };
    }
}

Page.Md_CardPurchaseForm2Beforesubmit = function($event, widget, $data) {
    //debugger
    Page.Widgets.spinnerFundAccount.show = true;
    Page.Variables.SV_wvrCardPurchaseAtMerchant.invoke();
    return false;
};

Page.SV_wvrCardPurchaseAtMerchantonError = function(variable, data) {
    Page.Widgets.spinnerFundAccount.show = false;
};
