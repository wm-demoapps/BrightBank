/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/* perform any action on widgets/variables within this block */
Page.onReady = function() {
    /*
     * variables can be accessed through 'Page.Variables' property here
     * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
     * Page.Variables.loggedInUser.getData()
     *
     * widgets can be accessed through 'Page.Widgets' property here
     * e.g. to get value of text widget named 'username' use following script
     * 'Page.Widgets.username.datavalue'
     */
    var VALIDATOR = App.getDependency('CONSTANTS').VALIDATOR;
    Page.Widgets.UserCredentialsForm1.formfields.confirmPassword.setValidators([confirmPasswordEval]);
    Page.Widgets.UserCredentialsForm1.formfields.confirmPassword.observeOn(['password.value']);
};

function confirmPasswordEval(field, form) {
    if (field.value && form.formfields['password.value'].value != field.value) {
        return {
            errorMessage: "Password & ConfirmPassword are not same"
        };
    }
}

Page.password_valueChange = function($event, widget, newVal, oldVal) {
    var regEx = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*\)\(+=._-])/;
    if (regEx.test(newVal)) {
        Page.Widgets.progress_bar1.datavalue = "100";
        Page.Widgets.progress_bar1.type = "success";
        // Page.Widgets.label1.caption = "Password Strong";
    } else if (/(?=.*[a-z]){4}(?=.*[0-9])(?=.{4,})/.test(newVal)) {
        Page.Widgets.progress_bar1.datavalue = "80";
        Page.Widgets.progress_bar1.type = "success";
        // Page.Widgets.label1.caption = "Password Good";
    } else if (/[A-Z](?=.*[a-z])[0-9](?=.{4,})/.test(newVal)) {
        Page.Widgets.progress_bar1.datavalue = "60";
        Page.Widgets.progress_bar1.type = "warning";
        // Page.Widgets.label1.caption = "Password Medium";
    } else if (/[A-Z]{1}(?=.*[a-z])/.test(newVal)) {
        Page.Widgets.progress_bar1.datavalue = "40";
        Page.Widgets.progress_bar1.type = "info";
        // Page.Widgets.label1.caption = "Password Medium";
    } else if (/[a-z]{4}(?=.*[A-Z])/.test(newVal)) {
        Page.Widgets.progress_bar1.datavalue = "20";
        Page.Widgets.progress_bar1.type = "danger";
        // Page.Widgets.label1.caption = "Password Weak";
    } else if (/(?=.*[a-z])/.test(newVal)) {
        Page.Widgets.progress_bar1.datavalue = "10";
        Page.Widgets.progress_bar1.type = "danger";
        // Page.Widgets.label1.caption = "Password Weak";
    } else {
        Page.Widgets.progress_bar1.datavalue = "0";
        // Page.Widgets.label1.caption = "Enter Password";
    }
};
Page.button1Click = function($event, widget) {
    debugger
    Page.Widgets.spinner1.show = true;
    var output = Page.Widgets.UserCredentialsForm1.dataoutput;
    App.Actions.loginAction.dataBinding = {
        "j_username": output.email,
        "j_password": output.password.value,
        "j_rememberme": false
    };
    App.Actions.loginAction.invoke();
};
