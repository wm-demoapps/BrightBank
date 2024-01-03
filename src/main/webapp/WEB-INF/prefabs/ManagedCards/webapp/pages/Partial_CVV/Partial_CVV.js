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
    debugger
    var token = "Bearer " + Partial.Prefab.authtoken;

    window.OpcUxSecureClient.init(Partial.Prefab.uikey);
    window.OpcUxSecureClient.associate(token,
        function() {
            console.log('associate success');

            // Create an instance of a card number component
            // Replace the {{cardnumber_token}} with the tokenised card number received using 
            // the server-side API call
            var span = window.OpcUxSecureClient.span("cardNumber", Partial.pageParams.cardNumber, {
                style: {
                    fontSize: '24px',
                    fontFamily: 'monospace',
                    letterSpacing: '3.5px',
                    color: '#ffffff',
                    // overflow: 'hidden',
                    height: '30px'
                    // whiteSpace: 'nowrap',
                    // textOverflow: 'ellipsis'
                }
            });

            // Embed the card number component in the HTML element where you want
            // the card number to be shown
            span.mount(document.getElementById('cardNumber'));
        },

        // Handle errors
        function(e) {
            console.error('associate failed ' + e);
        }
    );

    window.OpcUxSecureClient.associate(token,
        function() {
            console.log('associate success');

            // Create an instance of a CVV UI component
            // Replace the {{cvv_token}} with the tokenised CVV received using the server-side API call
            var span = window.OpcUxSecureClient.span("cvv", Partial.pageParams.cardCVV, {
                style: {
                    fontSize: '13px',
                    fontFamily: 'monospace'
                }
            });

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

Partial.buttonCloseClick = function($event, widget) {
    var index = Partial.pageParams.index;
    Partial.Prefab.Widgets.container1.Widgets.list1.getWidgets('cardBack')[index].show = false;
    Partial.Prefab.Widgets.container1.Widgets.list1.getWidgets('cardFront')[index].show = true;
    Partial.Prefab.Widgets.container1.Widgets.list1.getWidgets('card_content2')[index].content = undefined;
};
