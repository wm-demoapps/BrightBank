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
    Partial.containsGoals = true;
    //Partial.containsSpendingTrns = true;
};
Partial.UpcomingGoalPayments1Goalslength = function($event, $data) {
    if ($event > 0) {
        Partial.containsGoals = true;
    } else Partial.containsGoals = false;
};
/*Partial.CardSpendAnalysis1Spendtarnasactionscount = function($event, $data) {
    if ($event > 0) {
        Partial.containsSpendingTrns = true;
    } else Partial.containsSpendingTrns = false;
};*/
