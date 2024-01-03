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

    // switch (key) {
    //     case "id":
    //         
    //         if (Prefab.transactionlisttype == "Managed Account") {
    //             
    //             Prefab.Widgets.containerTransactions.Widgets.customerList1.isDataChanged = true;
    //             Prefab.Widgets.containerTransactions.Widgets.customerList1.dataset = Prefab.Widgets.containerTransactions.Variables.JS_getAccountTransactions.dataSet[0].entry;
    //         }
    //         break;
    // }
};

Prefab.onReady = function() {
    // this method will be triggered post initialization of the prefab.
};


Prefab.getAccountNumber = function(value) {
    if (value != undefined) {
        return "XXXX-" + value.slice(value.length - 4);
    }
};

Prefab.maskAccountNumber = function(accountNumber) {
    if (accountNumber != undefined) {
        var num = accountNumber.substring(0, 10);
        return num.replace(new RegExp("[0-9]{0,1}", "g"), "X") + '-' + accountNumber.substring(14, 18);
    }
};

Prefab.getCurrencyAmount = function(item) {
    if (item != undefined) {
        var amount = Math.abs(item.amount).toFixed(2);
        if (Prefab.transactiontype == "CR/DR") {
            if (item.currency == 'GBP') {
                return "£ " + amount;
            } else {
                if (item.currency == 'USD') {
                    return "$ " + amount;
                } else {
                    return "€ " + amount;
                }
            }
        } else {
            if (item.currency == 'GBP') {
                return item.transactionType == "TRANSFER" ? "-" + amount + " £" : "+" + amount + " £";
            } else {
                if (item.currency == 'USD') {
                    return item.transactionType == "TRANSFER" ? "($ " + amount + ")" : "$ " + amount;
                } else {
                    return item.transactionType == "TRANSFER" ? "-" + amount + " €" : "+" + amount + " €";
                }
            }
        }
    }
    // var amount = Math.abs(item.transactionAmount.amount);
};

/*
 * Refresh the transactions list when invoked when any transactions made on card or account
 */
Prefab.refreshTransactions = function() {
    debugger
    // if (Prefab.transactionlisttype == "Managed Account") {
    Prefab.Variables.JS_getAccountTransactions.invoke({
        inputFields: {
            "hostName": Prefab.servicehost,
            "authorization": Prefab.authtoken,
            "accountOrCardId": Prefab.id,
            "itemsPerPage": Prefab.itemsperpage,
            "transactionsType": Prefab.transactionlisttype
        }
    }, function(data) {
        // data = data[0].entry;
        // Prefab.Widgets.containerTransactions.Variables.AccountTransactions.dataSet = data[0].entry;
        // Prefab.Widgets.containerTransactions.Widgets.customerList1.dataset = [];
        // Prefab.Widgets.containerTransactions.Widgets.customerList1.dataset = data[0].entry;
    });
    // } else {
    //     Prefab.Variables.getAllTransactionsOfManagedCardById.invoke();
    // }
};

Prefab.getTransactionId = function(transactionId) {
    if (transactionId) {
        var id = transactionId.match(/.{1,4}/g);
        return id.join(' ');
    } else {
        return transactionId;
    }
};

//Below script is used for generating an avatar
var profileColors = [
    "6b40b2",
    "0047b2",
    "926053",
    "5e5c5c",
    "291c50",
    "552920",
    "0e8e9d",
    "c33439",
    "6e1c77",
    "193661",
    "e6820d",
    "edac00",
    "0b7171",
    "7aa623",
    "255F7b",
    "4668c5",
    "198047",
    "48626a",
    "dd808a",
    'a18e27',
    '97820f',
    'c4635e',
    '3a93ad',
    'af4985'
];


/*****************get the  numerical hash code for any string ***************/
function generateHashCode(email) {

    if (!email) {
        return 0;
    }
    var hash = 0,
        index,
        charCode;

    for (index = 0; index < email.length; index++) {
        charCode = email.charCodeAt(index);
        hash = ((hash << 5) - hash) + charCode;
    }
    return Math.abs(hash);
}


/*************Generate font color compatible to the background color************/
function getPseudoRandomColor(email) {
    var uniqueId = generateHashCode(email);
    // Get a random color for bg from the array of web safe colors
    return profileColors[uniqueId % profileColors.length];
}

function generateCompatibleColors(email) {
    var fontColor = 'white',
        bgColor = getPseudoRandomColor(email);
    return {
        'bg': '#' + bgColor,
        'font': fontColor
    };
}

Prefab.getNameInitials = function(fullName, anchorEle) {
    if (!fullName) {
        fullName = "Self";
    }
    var compatibleColors = generateCompatibleColors(fullName);
    anchorEle.$element.css({
        "background-color": compatibleColors.bg,
        "border-radius": "16px",
        "width": "32px",
        "heigth": "32px !important",
        "font-size": "20px",
        "text-align": "center",
    });
    anchorEle.$element.find('.anchor-caption').css({
        "color": compatibleColors.font,
        "text-transform": "uppercase",
        "font-size": "15px"
    });
    if (fullName.includes(' ')) {
        var name = fullName.split(' ');
        return name[0][0] + name[1][0];
    } else {
        return fullName[0] + fullName[1];
    }
};

/*
 * Filter transactions by date
 */
Prefab.setFilter = function(dateinput) {
    Prefab.Variables.JS_getAccountTransactions.setInput("fromDate", dateinput);
    Prefab.Variables.JS_getAccountTransactions.invoke();
};

Prefab.camelize = function(name) {
    if (name) {
        if (name.includes(" ")) {
            return name.split(' ')
                .map(a => a.trim())
                .map(a => a[0].toUpperCase() + a.substring(1))
                .join(" ");
        } else {
            return (" " + name).toLowerCase().replace(/[^a-zA-Z0-9]+(.)/, function(match, chr) {
                return chr.toUpperCase();
            });
        }
    }
};

Prefab.JS_getAccountTransactionsonError = function(variable, data) {
    //Adding this to hide the error toaster
};

Prefab.JS_getAccountTransactionsonSuccess = function(variable, data) {
    Prefab.onTransactioncount(data.length);
};
