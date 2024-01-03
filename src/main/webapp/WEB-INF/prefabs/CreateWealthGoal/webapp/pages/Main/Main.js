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

//To mask the card
Prefab.cardHide = function(input) {
    //use slice to remove first 12 elements
    if (input && input.toLowerCase() !== 'n/a' && input.toLowerCase() !== null) {
        return '****' + input.substring(input.length - 4);
    } else {
        return '';
    }
};


Prefab.svGetWealthGoalCategoriesonBeforeDatasetReady = function(variable, data) {
    data.push(Prefab.Variables.stvCustomGoal.dataSet);
};

Prefab.goalAmountSliderChange = function($event, widget, newVal, oldVal) {
    Prefab.Widgets.goalAmount.datavalue = newVal;
};
Prefab.goalAmountChange = function($event, widget, newVal, oldVal) {
    //commented as we used RangeSlider Prefab
    //Prefab.Widgets.goalAmountSlider.value = newVal;
    Prefab.Widgets.RangeSliderGoalAmount.end = newVal;
};
Prefab.goalTimeSliderChange = function($event, widget, newVal, oldVal) {
    Prefab.Widgets.goalTime.datavalue = newVal;
};

Prefab.goalTimeChange = function($event, widget, newVal, oldVal) {
    //commented as we used RangeSlider Prefab
    //Prefab.Widgets.goalTimeSlider.value = newVal;
    Prefab.Widgets.RangeSliderGoalTime.end = newVal;
};

Prefab.selectedSavingFrequencyChange = function($event, widget, newVal, oldVal) {
    Prefab.Widgets.savingFrequency.datavalue = Prefab.Widgets.formRecurringDepositDetails.formWidgets.selectedSavingFrequency.datavalue;
};

Prefab.savingFrequencyChange = function($event, widget, newVal, oldVal) {
    Prefab.getAmountToBeSaved();
};

Prefab.getAmountToBeSaved = function() {
    const savingFrequency = (Prefab.Widgets.formCreateGoal.formWidgets.savingFrequency.datavalue ? Prefab.Widgets.formCreateGoal.formWidgets.savingFrequency.datavalue.name : 0);
    const goalAmount = (Prefab.Widgets.formCreateGoal.formWidgets.goalAmount.datavalue ? Prefab.Widgets.formCreateGoal.formWidgets.goalAmount.datavalue : 0);
    const timeToGoal = (Prefab.Widgets.formCreateGoal.formWidgets.goalTime.datavalue ? Prefab.Widgets.formCreateGoal.formWidgets.goalTime.datavalue : 0);

    if (goalAmount > 0 && timeToGoal > 0) {
        if (savingFrequency === 'Fortnightly') {
            return roundNumber(goalAmount / Math.round((timeToGoal * 365) / 15));
        } else if (savingFrequency === 'Monthly') {
            return roundNumber(goalAmount / (timeToGoal * 12));
        } else if (savingFrequency === 'Weekly') {
            return roundNumber(goalAmount / Math.round((timeToGoal * 365) / 7));
        } else return 0;
    } else return 0;

};

function roundNumber(num) {
    return Math.round(num * 100 + Number.EPSILON) / 100;
}

Prefab.wizardCreateGoalDone = function(widget, steps) {
    Prefab.Variables.stvCreateNewGoal.dataSet = [];
    Prefab.Variables.stvCreateNewGoal.dataSet.category = Prefab.Widgets.listGoalCategory.selecteditem;
    Prefab.Variables.stvCreateNewGoal.dataSet.goalDetails = Prefab.Widgets.formCreateGoal.dataoutput;
    Prefab.Variables.stvCreateNewGoal.dataSet.goalDepoiteDeatils = Prefab.Widgets.formRecurringDepositDetails.dataoutput;
    Prefab.Widgets.dialogOTPVerify.open();
};

Prefab.buttonOkayClick = function($event, widget) {
    Prefab.Widgets.dialogSuccessGoal.close();
    Prefab.onNavigatetogoalslist();
};

Prefab.buttonSucessOTPContinueClick = function($event, widget) {
    const requestBody = {
        "name": Prefab.Variables.stvCreateNewGoal.dataSet.goalDetails.goalName,
        "goalCategoryId": Prefab.Variables.stvCreateNewGoal.dataSet.category.id,
        "timeToGoal": Prefab.Variables.stvCreateNewGoal.dataSet.goalDetails.goalTime,
        "savingFrequencyId": Prefab.Variables.stvCreateNewGoal.dataSet.goalDepoiteDeatils.selectedSavingFrequency.id,
        "recurringDay": getRecurringDate(Prefab.Variables.stvCreateNewGoal.dataSet.goalDepoiteDeatils.selectedSavingFrequency.name),
        "recurringDebitAmount": Prefab.Variables.stvCreateNewGoal.dataSet.goalDepoiteDeatils.recurringDebitAmount,
        "isAutoDebitEnabled": Prefab.Variables.stvCreateNewGoal.dataSet.goalDepoiteDeatils.enableAutoDebit,
        "createdOn": moment().format('yyyy-MM-DDThh:mm:ss'),
        "userId": Prefab.userid,
        "recuringDebitAccountId": Prefab.Variables.stvCreateNewGoal.dataSet.goalDepoiteDeatils.recurringDebitAccount.id,
        "amount": Prefab.Variables.stvCreateNewGoal.dataSet.goalDetails.goalAmount,
        "isActive": true,
    };
    Prefab.Variables.wsCreateWealthGoal.setInput("RequestBody", requestBody);
    Prefab.Variables.wsCreateWealthGoal.invoke();
};


function getRecurringDate(recurringFrequency) {
    if (recurringFrequency === 'Monthly') {
        return getFutureMonth(Prefab.Variables.stvCreateNewGoal.dataSet.goalDepoiteDeatils.recurringDebitDay.name);
    } else if (recurringFrequency === 'Weekly') {
        return nextWeekDateByDay(Prefab.Variables.stvCreateNewGoal.dataSet.goalDepoiteDeatils.recurringWeek.key);
    } else return '';
}

//to get comind date of slected day
function nextWeekDateByDay(dayINeed) {
    const today = moment().isoWeekday();
    // if we haven't yet passed the day of the week that I need:
    if (today < dayINeed) {
        // to get this week's instance of that day
        return moment().isoWeekday(dayINeed).format('YYYY-MM-DD');
    } else {
        // to get *next week's* instance of that same day
        return moment().add(1, 'weeks').isoWeekday(dayINeed).format('YYYY-MM-DD');
    }
}

//to get futureMonth date based on day
function getFutureMonth(recurringDay) {
    var currentDate = moment(moment().format('YYYY') + '-' + moment().format('MM') + '-' + moment().format(recurringDay));
    var futureMonth = moment(currentDate);

    if (moment().format('DD') > recurringDay) { //moment().isoWeekday() -->moment().format('DD')
        futureMonth = moment(currentDate).add(1, 'M');
        var futureMonthEnd = moment(futureMonth).endOf('month');

        if (currentDate.date() != futureMonth.date() && futureMonth.isSame(futureMonthEnd.format('YYYY-MM-DD'))) {
            futureMonth = futureMonth.add(1, 'd');
        }
    }
    return futureMonth.format('YYYY-MM-DD');
}

//for opt auto focus
Prefab.text1Change = function($event, widget, newVal, oldVal) {
    Prefab.Widgets.text2.focus();
};
Prefab.text2Change = function($event, widget, newVal, oldVal) {
    Prefab.Widgets.text3.focus();
};
Prefab.text3Change = function($event, widget, newVal, oldVal) {
    Prefab.Widgets.text4.focus();
};
Prefab.text4Change = function($event, widget, newVal, oldVal) {
    Prefab.Widgets.text5.focus();
};
Prefab.text5Change = function($event, widget, newVal, oldVal) {
    Prefab.Widgets.text6.focus();
};

//addinf default value to list
Prefab.listGoalCategoryRender = function(widget, $data) {
    Prefab.Widgets.listGoalCategory.selecteditem = Prefab.Variables.svGetWealthGoalCategories.firstRecord;

};
Prefab.wizardCreateGoalCancel = function(widget, steps) {
    Prefab.onNavigatetogoalslist();
};
