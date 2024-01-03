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


Prefab.button4Click = function($event, widget) {
    Prefab.onClose();
};

Prefab.CreateCardRailsBankForm1_customAction = function($event) {
    Prefab.onClose();
};

Prefab.CreateCardRailsBankForm1_saveAction = function($event) {
    Prefab.Widgets.spinner1.show = true;
    var data = Prefab.Widgets.CreateCardRailsBankForm1.dataoutput;

    Prefab.Variables.JS_createManagedCards.invoke({
        inputFields: {
            "hostName": Prefab.servicehost,
            "authorization": Prefab.authtoken,
            "Map": data
        }
    });
};

Prefab.JS_createManagedCardsonSuccess = function(variable, data) {
    debugger
    Prefab.Widgets.spinner1.show = false;
    Prefab.Widgets.container3.show = false;
    Prefab.Widgets.container5_1.show = true;
    if (Prefab.servicehost == 'APIVendor(R)' && Prefab.Variables.selectedCardType.dataSet.dataValue == 'Virtual') {
        Prefab.Widgets.CreateCardRailsBankForm1.show = false;
    }
    Prefab.onCardadd(variable, data);
};

Prefab.CardsTypeDataList1Mouseenter = function($event, widget) {
    var source = Prefab.Widgets.CardsTypeDataList1.getWidgets('Picture', Prefab.Widgets.CardsTypeDataList1.getIndex(widget.item)[0]);
    // 
    if (widget.item.name == 'Physical Card') {
        source[0].picturesource = "resources/images/imagelists/physical-card-active.svg";
    } else {
        source[1].picturesource = "resources/images/imagelists/virtual-card-active.svg";
    }

    Prefab.onCardselectmouseenter($event, widget);
};
Prefab.CardsTypeDataList1Mouseleave = function($event, widget) {
    var source = Prefab.Widgets.CardsTypeDataList1.getWidgets('Picture', Prefab.Widgets.CardsTypeDataList1.getIndex(widget.item)[0]);
    // 
    if (widget.item.name == 'Physical Card') {
        source[0].picturesource = "resources/images/imagelists/physical-card-inactive.svg";
    } else {
        source[1].picturesource = "resources/images/imagelists/virtual-card-inactive.svg";
    }
    Prefab.onCardselectmouseleave($event, widget);
};

Prefab.CardsTypeDataList1Click = function($event, widget) {

    if (widget.item.name == 'Physical Card') {
        Prefab.Variables.selectedCardType.dataSet.dataValue = 'Physical';
        Prefab.Widgets.container4_1.show = false;
        Prefab.Widgets.container3.show = true;
    } else {
        Prefab.Variables.selectedCardType.dataSet.dataValue = 'Virtual';
        Prefab.Widgets.container4_1.show = false;
        if (Prefab.servicehost == 'APIVendor(R)') {
            Prefab.Widgets.CreateCardRailsBankForm1.show = true;
        } else {
            Prefab.Widgets.container3.show = true;
        }
    }
    Prefab.onCardtypeselect();
};
Prefab.CreateManagedCardForm1Success = function($event, widget, $data) {
    Prefab.onCardadd();
};

Prefab.button3Click = function($event, widget) {
    Prefab.onFundcard();
};
