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

Partial.button1Click = function($event, widget) {
    Partial.Variables.DirectorsList.dataSet.push(Partial.Widgets.directors.dataoutput);
    Partial.Widgets.directors.show = false;
    Partial.Widgets.DirectorsListList1.show = true;
    Partial.Widgets.addAnotherDirectorButton.show = true;
    Partial.Widgets.button1.show = false;
};

Partial.wizardpersonCancel = function(widget, steps) {
    Partial.Prefab.onWizardcancel();
};

Partial.wizard2_1Cancel = function(widget, steps) {
    Partial.Prefab.onWizardcancel();
};

Partial.wizardpersonDone = function(widget, steps) {
    debugger
    Partial.Widgets.spinner1.show = true;
    Partial.Variables.JS_createNewUserIdentity.invoke({
        inputFields: {
            "hostName": Partial.Prefab.servicehost,
            "identityType": Partial.Prefab.endusertype,
            "Map": Partial.Widgets.customerForm1.dataoutput
        }
    }, function(data) {
        // if (Partial.Prefab.servicehost == "Weavr") {
        Partial.Prefab.userdata = data;
        // } else if (Partial.Prefab.servicehost == "Railsbank") {
        //     Partial.Variables.enduserIdData.dataValue = data.enduser_id;
        //     Partial.enduserid = data.enduser_id;
        // }
        if (Partial.Prefab.servicehost == "APIVendor(W)") {
            Partial.Widgets.customerForm1.show = false;
            Partial.Widgets.dialogOTPVerify.open();
            Partial.Variables.sendOTPForEndUserEmail.invoke({
                inputFields: {
                    "hostName": Partial.Prefab.servicehost,
                    "identityType": Partial.Prefab.endusertype,
                    "email": data.email
                }
            });
        } else {
            Partial.Widgets.spinner1.show = false;
            Partial.Prefab.onEnduseradd(widget, data);
        }
    });
};

Partial.wizard2_1Done = function(widget, steps) {
    debugger
    var companyInfo = Partial.Widgets.customerForm1.dataoutput;
    Partial.Widgets.spinner1.show = true;
    if (Partial.Prefab.servicehost == "APIVendor(R)") {
        companyInfo.company.directors = Partial.Variables.DirectorsList.dataSet;
        for (var i = 0; i < companyInfo.company.directors.length; i++) {
            companyInfo.company.directors[i].person.country_of_residence = [companyInfo.company.directors[i].person.country_of_residence];
        }
    }
    Partial.Variables.JS_createNewUserIdentity.invoke({
        inputFields: {
            "hostName": Partial.Prefab.servicehost,
            "identityType": Partial.Prefab.endusertype,
            "Map": companyInfo
        }
    }, function(data) {
        // if (Partial.enduserid == "Weavr") {
        // Partial.Variables.RootUserEmail.dataSet.dataValue = data.rootUser.email;
        Partial.Prefab.userdata = data;
        // } else if (Partial.enduserid == "Railsbank") {
        //     Partial.Variables.enduserIdData.dataValue = data.enduser_id;
        //     Partial.enduserid = data.enduser_id;
        // }
        if (Partial.Prefab.servicehost == "APIVendor(W)") {
            Partial.Widgets.dialogOTPVerify.open();
            Partial.Variables.sendOTPForEndUserEmail.invoke({
                inputFields: {
                    "hostName": Partial.Prefab.servicehost,
                    "identityType": Partial.Prefab.endusertype,
                    "email": data.email
                }
            });
        } else {
            Partial.Widgets.spinner1.show = false;
            Partial.Prefab.onEnduseradd(widget, data);
        }
    });
};

Partial.editDirectorClick = function($event, widget, item, currentItemWidgets) {
    Partial.Widgets.directors.formdata = item;
    Partial.Widgets.directors.show = true;
    Partial.Widgets.addAnotherDirectorButton.show = false;
    Partial.Widgets.saveChangesButton.show = true;
};

Partial.deleteDirectorClick = function($event, widget, item, currentItemWidgets) {
    var index = _.indexOf(Partial.Variables.DirectorsList.dataSet, item);
    Partial.Variables.DirectorsList.removeItem(index);
    if (Partial.Variables.DirectorsList.dataSet.length == 0) {
        Partial.Widgets.directors.show = true;

        Partial.Widgets.directors.reset();
        Partial.Widgets.directors.formWidgets.country_of_residence.datavalue = 'US';
        Partial.Widgets.button1.show = true;
        Partial.Widgets.addAnotherDirectorButton.show = false;
        if (Partial.Widgets.saveChangesButton.show = true) {
            Partial.Widgets.saveChangesButton.show = false;
        }
    }
};

Partial.addAnotherDirectorButtonClick = function($event, widget) {
    Partial.Widgets.directors.show = true;
    Partial.Widgets.directors.reset();
    Partial.Widgets.directors.formWidgets.country_of_residence.datavalue = 'US';
    Partial.Widgets.button1.show = true;
    Partial.Widgets.addAnotherDirectorButton.show = false;

};

Partial.saveChangesButtonClick = function($event, widget) {
    Partial.Variables.DirectorsList.setItem(Partial.Widgets.DirectorsListList1.getIndex(Partial.Widgets.DirectorsListList1.selecteditem), Partial.Widgets.directors.dataoutput);
    Partial.Widgets.saveChangesButton.show = false;
    Partial.Widgets.addAnotherDirectorButton.show = true;
    Partial.Widgets.directors.show = false;
};

Partial.country_of_residenceChange = function($event, widget, newVal, oldVal) {
    Partial.Widgets.customerForm1.formWidgets.person1.formWidgets.telephone.datavalue = "";
};

Partial.buttonContinueClick = function($event, widget) {
    Partial.Prefab.onEnduseradd(widget, Partial.Prefab.userdata);
};

Partial.text1Change = function($event, widget, newVal, oldVal) {
    Partial.Widgets.text2.focus();
};
Partial.text2Change = function($event, widget, newVal, oldVal) {
    Partial.Widgets.text3.focus();
};
Partial.text3Change = function($event, widget, newVal, oldVal) {
    Partial.Widgets.text4.focus();
};
Partial.text4Change = function($event, widget, newVal, oldVal) {
    Partial.Widgets.text5.focus();
};
Partial.text5Change = function($event, widget, newVal, oldVal) {
    Partial.Widgets.text6.focus();
};
