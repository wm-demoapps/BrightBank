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
    console.log("partial onready");
};

Partial.popover1Load = function(widget, item, currentItemWidgets) {
    var token = "Bearer " + Partial.Prefab.authtoken;
    debugger
    window.OpcUxSecureClient.associate(token,
        function() {
            console.log('associate success');
            // Create an instance of a CVV UI component
            // Replace the {{cvv_token}} with the tokenised CVV received using the server-side API call
            var span = window.OpcUxSecureClient.span("cvv", item.cardCVV);

            // Embed the CVV component in the HTML element where you want
            // the CVV to be shown
            span.mount(document.getElementById('cvv'));
        },
        // Handle errors
        function(e) {
            console.error('associate failed ' + e);
        }
    );
};
Partial.labelCardNumberClick = function($event, widget, item, currentItemWidgets) {
    debugger
    Partial.Prefab.selectedcardid = item.id;
    Partial.Prefab.selectedcard = item;
    Partial.Prefab.onCardnumberselect();
};

Partial.getCardId = function(value) {
    if (value) {
        if (value.includes('*')) {
            return value.substring(value.indexOf('*') + 2, value.length);
        } else {
            value = value.toString();
            return "60" + value.substring(value.length, value.length - 2);
        }
    }
};

Partial.pictureFlipCardClick = function($event, widget, item, currentItemWidgets) {

    var index = Partial.Widgets.list1.getIndex(item);
    Partial.Widgets.list1.getWidgets('cardFront')[index].show = false;
    Partial.Widgets.list1.getWidgets('cardBack')[index].show = true;
    Partial.Widgets.list1.getWidgets('card_content2')[index].show = true;
    Partial.Widgets.list1.getWidgets('card_content2')[index].content = "Partial_CVV";
    Partial.Widgets.list1.getWidgets('card_content2')[index].partialParams = {
        "cardNumber": item.cardNumber,
        "cardCVV": item.cardCVV,
        "index": index
    };
};


Partial.JS_getAllManagedCardsonSuccess = function(variable, data) {
    Partial.Prefab.onCardscount(data.length);
};
Partial.container4Click = function($event, widget, item, currentItemWidgets) {

};
