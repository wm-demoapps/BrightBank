// var VALIDATOR = App.getDependency('CONSTANTS').VALIDATOR;

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
        case "wizardlayout":
            console.log("onPropertychanged called");
            // if (Prefab.wizardlayout == "Horizontal Layout") {
            //     Prefab.Widgets.containerWizard.show = true;
            // } else {
            //     Prefab.Widgets.container2.show = true;
            // }
            break;
    }

};

Prefab.onReady = function() {
    // Prefab.Variables.formData.dataset = Prefab.formdata;
    // this method will be triggered post initialization of the prefab.
    console.log("onReady called");
    // if (Prefab.wizardlayout == "Horizontal Layout") {
    //     Prefab.Widgets.containerWizard.show = true;
    // } else {
    //     Prefab.Widgets.container2.show = true;
    // }
};
