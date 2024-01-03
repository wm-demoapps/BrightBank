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
    window.OpcUxSecureClient.associate(token,
        function() {
            console.log('associate success');
            // Create an instance of a CVV UI component
            // Replace the {{cvv_token}} with the tokenised CVV received using the server-side API call
            var span = window.OpcUxSecureClient.span("cvv", item.cvv.value);

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
Partial.label9Click = function($event, widget, item, currentItemWidgets) {
    Partial.Prefab.selectedcardid = item.id;
    Partial.Prefab.onCardnumberselect(null, item);
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

Partial.managedCardsGetonSuccess = function(variable, data) {
    Partial.Prefab.onCardscount(data.length);
};
