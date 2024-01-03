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
         case "servicehost":
             break;
     }*/

};

Prefab.onReady = function() {
    // this method will be triggered post initialization of the prefab.
    if (Prefab.Widgets.customerForm1.formWidgets.ledger_id.datavalue && Prefab.servicehost == "APIVendor(R)") {
        var data = Prefab.Variables.getManagedAccountDetailsById.invoke({
            inputFields: {
                "hostName": Prefab.servicehost,
                "authorization": Prefab.authtoken,
                "managedAccountId": Prefab.Widgets.customerForm1.formWidgets.ledger_id.datavalue
            }
        }, function(data) {
            var currencyType = "$";
            currencyType = data.asset_type == "gbp" ? "£" : (data.asset_type == "usd" ? "$" : "€");
            $('div[name="amount_formWidget"]').find('span').text(currencyType);
        });
    }

    if (Prefab.wizardlayout == "Horizontal Layout") {
        Prefab.Widgets.wizardTransfer.class = "number";
    } else if (Prefab.wizardlayout == "Vertical Layout") {
        Prefab.Widgets.wizardTransfer.class = "number vertical";
    }
};

Prefab.button5Click = function($event, widget) {
    // 
    Prefab.Widgets.spinnerPaymentConfirm.show = true;
    Prefab.Variables.FundManagedCards.invoke({
        inputFields: {
            "Map": Prefab.Widgets.customerForm1.dataoutput,
            "hostName": Prefab.servicehost,
            "authorization": Prefab.authtoken
        }
    }, function(data) {
        Prefab.Widgets.spinnerPaymentConfirm.show = false;
    });

};

Prefab.button4Click = function($event, widget) {
    Prefab.onTransactionsuccess();
    Prefab.onCancel();
};

Prefab.ledger_idChange = function($event, widget, newVal, oldVal) {

    debugger
    var data = Prefab.Variables.getManagedAccountDetailsById.invoke({
        inputFields: {
            "hostName": Prefab.servicehost,
            "authorization": Prefab.authtoken,
            "managedAccountId": newVal
        }
    }, function(data) {
        var currencyType = "$";
        if (Prefab.servicehost == "APIVendor(R)") {
            currencyType = data.asset_type == "gbp" ? "£" : (data.asset_type == "usd" ? "$" : "€");
        } else {
            currencyType = data.currency == "GBP" ? "£" : (data.currency == "USD" ? "$" : "€");
        }
        $('div[name="amount_formWidget"]').find('span').text(currencyType);
    });
};

Prefab.FundManagedCardsonSuccess = function(variable, data) {
    Prefab.Widgets.container2.show = false;
    Prefab.Widgets.container4_1.show = true;
};

Prefab.getAllManagedAccountsOrLedgersonSuccess = function(variable, data) {
    Prefab.Widgets.ledger_id.datafield = "id";
};

Prefab.getAllManagedCardsOrBeneficiariesonSuccess = function(variable, data) {
    Prefab.Widgets.beneficiary_id.datafield = 'id';
};

Prefab.getAccountNumber = function(accountNumber) {
    if (accountNumber) {
        if (Prefab.servicehost == "APIVendor(R)") {
            return "XXXX-" + accountNumber.slice(accountNumber.length - 4);
        } else {
            // var accNumber = Prefab.Variables.transferFormOutput.dataSet.ledgerName.split(' - ')[1];
            var num = accountNumber.substring(0, 10);
            return num.replace(new RegExp("[0-9]{0,1}", "g"), "X") + '-' + accountNumber.substring(14, 18);
        }
    }
};

Prefab.getReceiverName = function(accountNumber) {
    if (accountNumber) {
        accountNumber = accountNumber.split(" - ");
        return accountNumber[0];
    }
};

Prefab.getReceiverAccount = function(accountNumber) {
    // 
    if (accountNumber) {
        if (Prefab.servicehost == "APIVendor(R)") {
            accountNumber = accountNumber.split(" - ");
            return "XXXX-" + accountNumber[1].slice(accountNumber.length - 4);
        } else if (Prefab.servicehost == "APIVendor(W)") {
            // var accNumber = Prefab.Variables.transferFormOutput.dataSet.beneficiaryName.split(' - ')[1];
            var num = accountNumber.substring(0, 10);
            return num.replace(new RegExp("[0-9]{0,1}", "g"), "X") + '-' + accountNumber.substring(14, 18);
        } else if (Prefab.servicehost == "APIVendor(B)") {

        }
    }
};

Prefab.getSenderName = function(accountNumber) {
    if (accountNumber) {
        accountNumber = accountNumber.split(" - ");
        return accountNumber[0];
    }
};

Prefab.wizardTransferCancel = function(widget, steps) {
    Prefab.onCancel();
};
Prefab.wizardTransferDone = function(widget, steps) {
    debugger
    //if (Prefab.Widgets.ledger_id.displayValue.includes(Prefab.Widgets.beneficiary_id.displayValue.split("-").pop())) {
    Prefab.Widgets.spinnerPaymentConfirm.show = true;
    Prefab.Variables.FundManagedCards.invoke({
        inputFields: {
            "Map": Prefab.Widgets.customerForm1.dataoutput,
            "hostName": Prefab.servicehost,
            "authorization": Prefab.authtoken
        }
    }, function(data) {
        Prefab.Widgets.spinnerPaymentConfirm.show = false;

    }, function(error) {
        Prefab.Widgets.spinnerPaymentConfirm.show = false;
        let ledgerDetails = Prefab.Widgets.ledger_id.dataset.filter((ledger) => {
            if (Prefab.Widgets.ledger_id.datavalue == ledger.id) {
                return ledger;
            }
        })
        let beneficiarDetails = Prefab.Widgets.beneficiary_id.dataset.filter((beneficiar) => {
            if (Prefab.Widgets.beneficiary_id.datavalue == beneficiar.id) {
                return beneficiar;
            }
        })
        if (error.includes("409")) {

            if (beneficiarDetails[0].currency != ledgerDetails[0].currency) {
                invokeErroOnFundTransfer("To account and from account currnecy should be same to trasfer the funds");

            } else if (ledgerDetails[0].balance < Prefab.Widgets.customerForm1.dataoutput.amount) {
                invokeErroOnFundTransfer("Insufficient funds");
            } else {
                invokeErroOnFundTransfer(error);
            }
        } else {
            invokeErroOnFundTransfer(error);
        }

    });

};

function invokeErroOnFundTransfer(caption) {
    Prefab.Actions.ErrorMessage.invoke({
        "message": caption
    });
}
