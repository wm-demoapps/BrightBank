/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/* perform any action on widgets/variables within this block */
Partial.onReady = function() {
    /*
     * variables can be accessed through 'Partial.Variables' property here
     * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
     * Partial.Variables.loggedInUser.getData()
     *
     * widgets can be accessed through 'Partial.Widgets' property here
     * e.g. to get value of text widget named 'username' use following script
     * 'Partial.Widgets.username.datavalue'
     */
};

Partial.currencyChange = function($event, widget, newVal, oldVal) {

    var currencyType = (newVal == "GBP") ? "£" : (newVal == "USD" ? "$" : "€");
    $('div[name="spentLimit_formWidget"]').find('span').text(currencyType);
};

Partial.ledgerIdChange = function($event, widget, newVal, oldVal) {
    var currencyType = "$";
    currencyType = newVal.asset_type == "gbp" ? "£" : (newVal.asset_type == "usd" ? "$" : "€");

    $('div[name="spentLimit_formWidget"]').find('span').text(currencyType);
};

Partial.getExpiryDate = function() {
    var expDate = moment().add(4, 'years').calendar();
    return moment(expDate).format("YYYY-MM-DD");
};

Partial.wizardVerticalCard1Cancel = function(widget, steps) {

    Partial.Prefab.onClose();
};

Partial.wizardVerticalCard1Done = function(widget, steps) {

    Partial.Prefab.Widgets.spinner1.show = true;
    var output = Partial.Widgets.CreateManagedCardForm1.dataoutput;
    var format = output.currency == "USD" ? "+1" : "+44";
    output.cardholderMobileNumber = format + output.cardholderMobileNumber;
    if (Partial.Prefab.servicehost == 'APIVendor(R)') {
        output.CardDeliveryAddress = output.billingAddress;
        delete output.billingAddress;
    }

    Partial.Variables.JS_createManagedCards.invoke({
        inputFields: {
            "hostName": Partial.Prefab.servicehost,
            "authorization": Partial.Prefab.authtoken,
            "Map": output
        }
    }, function(data) {
        Partial.Prefab.addedcardid = data.id;
        if (Partial.Prefab.servicehost == 'APIVendor(W)' && Partial.Prefab.Variables.selectedCardType.dataSet.dataValue == "Physical") {
            Partial.Variables.updateManagedCardsToPhysical.invoke({
                inputFields: {
                    "hostName": Partial.Prefab.servicehost,
                    "authorization": Partial.Prefab.authtoken,
                    "managedCardId": data.id,
                    "Map": output
                }
            }, function(physicalCard) {

                console.log(physicalCard);
                Partial.Variables.managedCardPhysicalActivate.invoke({
                    inputFields: {
                        "hostName": Partial.Prefab.servicehost,
                        "authorization": Partial.Prefab.authtoken,
                        "managedCardId": data.id,
                        "Map": {
                            "activationCode": "123456"
                        }
                    }
                }, function(activate) {
                    Partial.Variables.managedCardPhysicalPinGet.invoke({
                        inputFields: {
                            "hostName": Partial.Prefab.servicehost,
                            "authorization": Partial.Prefab.authtoken,
                            "managedCardId": data.id
                        }
                    }, function(pinData) {

                        Partial.Prefab.Widgets.container3.show = false;
                        Partial.Prefab.Widgets.spinner1.show = false;
                        Partial.Prefab.Widgets.container5_1.show = true;
                    });
                });
            });
        } else {
            Partial.Prefab.Widgets.container3.show = false;
            Partial.Prefab.Widgets.spinner1.show = false;
            Partial.Prefab.Widgets.container5_1.show = true;
        }

    });
};
