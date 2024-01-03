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

};

Prefab.form_field7Select = function($event, widget, selectedValue) {
    let placeId = selectedValue.place_id
    Prefab.Variables.svGetPlaceById.setInput("place_id", placeId);
    Prefab.Variables.svGetPlaceById.invoke();
};

Prefab.svGetPlaceByIdonSuccess = function(variable, data) {
    var streetAddr = "";
    Prefab.Widgets.AddressDetailsForm1.formWidgets.postalCode.datavalue = "";
    Prefab.Widgets.AddressDetailsForm1.formWidgets.country.datavalue = "";
    Prefab.Widgets.AddressDetailsForm1.formWidgets.city.datavalue = "";
    Prefab.Widgets.AddressDetailsForm1.formWidgets.state.datavalue = "";
    Prefab.Widgets.AddressDetailsForm1.formWidgets.buildingOrAddressLine2.datavalue = "";
    Prefab.Widgets.AddressDetailsForm1.formWidgets.street.datavalue = "";
    if (data.result.address_components) {
        for (var i = 0; i < data.result.address_components.length; i++) {

            var addr = data.result.address_components[i];

            if (addr.types.includes("postal_code")) {
                Prefab.Widgets.AddressDetailsForm1.formWidgets.postalCode.datavalue = addr.short_name;
            }

            if (addr.types.includes("country")) {
                Prefab.Widgets.AddressDetailsForm1.formWidgets.country.datavalue = addr.short_name;
            }

            if (addr.types.includes("locality") || addr.types.includes("postal_town")) {
                Prefab.Widgets.AddressDetailsForm1.formWidgets.city.datavalue = addr.short_name;
            }

            if (addr.types.includes("administrative_area_level_1")) {
                Prefab.Widgets.AddressDetailsForm1.formWidgets.state.datavalue = addr.long_name;
            }
            if (addr.types.includes("street_number")) {
                streetAddr = streetAddr == "" ? streetAddr + addr.short_name : streetAddr + ', ' + addr.short_name;
                Prefab.Widgets.AddressDetailsForm1.formWidgets.buildingOrAddressLine2.datavalue = addr.short_name;
            }
            if (addr.types.includes("route")) {
                streetAddr = streetAddr == "" ? streetAddr + addr.short_name : streetAddr + ', ' + addr.short_name;
            }
            if (addr.types.includes("sublocality_level_1")) {
                streetAddr = streetAddr == "" ? streetAddr + addr.short_name : streetAddr + ', ' + addr.short_name;
            }
            if (addr.types.includes("sublocality_level_2")) {
                streetAddr = streetAddr == "" ? streetAddr + addr.short_name : streetAddr + ', ' + addr.short_name;
            }
            if (addr.types.includes("sublocality_level_3")) {
                streetAddr = streetAddr == "" ? streetAddr + addr.short_name : streetAddr + ', ' + addr.short_name;
            }

            Prefab.Widgets.AddressDetailsForm1.formWidgets.street.datavalue = streetAddr;
        }
    }
};
