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

    /*switch (key) {
        case "formdata":
            Prefab.Variables.formData.dataset = Prefab.formdata;
            break;
    }*/

};


Prefab.onReady = function() {

    // this method will be triggered post initialization of the prefab.
};

var ledgerAssetType;

var ledgerObj;

Prefab.createLedgerForm_resetAction = function($event) {
    Prefab.onCancel();
};

Prefab.timerAction1onTimerFire = function(variable, data) {
    // 
    // if (Prefab.servicehost == "APIVendor(R)") {
    if (ledgerAssetType == 'eur') {
        Prefab.Variables.updateManagedAccountToIBAN.invoke({
            inputFields: {
                "hostName": Prefab.servicehost,
                "authorization": Prefab.authtoken,
                "managedAccountId": Prefab.ledgerid
            }
        });
    }
    // }
    Prefab.onLedgeradd(variable, ledgerObj);
};
Prefab.createLedgerForm_saveAction = function($event) {
    // 
    Prefab.Variables.createManagedAccount.invoke({
        inputFields: {
            "hostName": Prefab.servicehost,
            "authorization": Prefab.authtoken,
            "Map": Prefab.Widgets.createLedgerForm.dataoutput
        }
    }, function(data) {
        if (Prefab.servicehost == "APIVendor(R)") {
            Prefab.ledgerid = data.ledger_id;
            Prefab.Actions.timerAction1.invoke();
        } else if (Prefab.servicehost == "APIVendor(W)") {
            Prefab.ledgerid = data.id;
            console.log(data);
            Prefab.onLedgeradd($event, data);
            //commenting IBAN upgrade as WVR stopped for sandbox env.
            // Prefab.Variables.updateManagedAccountToIBAN.invoke({
            //     inputFields: {
            //         "hostName": Prefab.servicehost,
            //         "authorization": Prefab.authtoken,
            //         "managedAccountId": data.id,
            //         "ManagedAccountModel": data
            //     }
            // }, function(data) {
            //     // 
            //     console.log(data);
            //     Prefab.onLedgeradd($event, ledgerObj);
            // });
        } else {
            Prefab.onLedgeradd($event, ledgerObj);
        }
    });
};

Prefab.createManagedAccountonBeforeUpdate = function(variable, inputData, options) {
    // 
    Prefab.Widgets.spinner1.show = true;
    if (Prefab.servicehost == "APIVendor(R)") {

        inputData.Map.body.ledger_primary_use_types = [inputData.Map.body.ledger_primary_use_types];
        inputData.Map.body.ledger_meta = inputData.Map.body_ledger_meta;
        ledgerAssetType = inputData.Map.body.asset_type;
        inputData = inputData.Map.body;
        ledgerObj = inputData;
    }
};
Prefab.createLedgerFormSuccess = function($event, widget, $data) {
    //added this only to avoid the success inline message for the form
};
