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
    Prefab.containsGoals = true;
};

Prefab.onReady = function() {
    // this method will be triggered post initialization of the prefab.
};

//To mask the card
Prefab.cardHide = function(input) {
    //use slice to remove first 12 elements
    if (input && input.toLowerCase() !== 'n/a' && input.toLowerCase() !== null) {
        return '****' + input.substring(input.length - 4);
    } else {
        return '';
    }
};

Prefab.jsGetWealthGoalsListForUseronBeforeDatasetReady = function(variable, data) {
    if (data.length > 0) {
        Prefab.containsGoals = true;
        if (Prefab.viewtype == 'Web') {
            data.push(Prefab.Variables.stvWealthGoals.dataSet);
        }
    } else if (Prefab.authtoken && Prefab.userid && data.length < 1) {
        Prefab.containsGoals = false;
    }
};
Prefab.containerCreateGoalClick = function($event, widget, item, currentItemWidgets) {
    Prefab.onAddnewgoal();
};
Prefab.buttonCreateGoalAccountClick = function($event, widget) {
    Prefab.onAddnewgoal();
};
