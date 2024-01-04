# About Application and Pefab usage
Bright Bank is a user-friendly banking app that prioritizes your financial well-being. With secure login, a comprehensive dashboard summarizing spend analysis, upcoming payments, net worth, and detailed account/card management, it simplifies your financial life. You can create accounts, access transaction details, add funds, make transactions, manage cards, and set wealth goals - **all in one place. Achieve financial success with Bright Bank.

<a href="https://showcase.onwavemaker.com/BrightBank/" target="_blank">Click Here</a> for more details on Sales Vision app

## Aplication Properties
  ### Email connector
  Add the email server properties to use email connector
  ```
  connector.email.default.email.server.host : smtp.gmail.com
  connector.email.default.email.server.password : 
  connector.email.default.email.server.port : 465
  connector.email.default.email.server.sslenabled : true
  connector.email.default.email.server.username : 
  connector.email.default.email.transport.protocol : smtp
  ```
  ### App environment variables
  Register account with **Weavr (https : //portal.weavr.io/register)** and download/save weavr environment where it contains all the account/card/transaction keys and app tokens. Once registered with weavr, contact support to changes model for our user to use seamliess features of weavr (Account creation, transfer funds...etc). 
  ```
  app.environment.apikey : 
  app.environment.consumer_profile_id : 
  app.environment.managed_account_profile_id : 
  app.environment.transfers_profile_id : 
  ```
  Note : Add all the required tokens to above environment varibles (Settings->Config Profiles-> App environment)

# Prefabs Artifacts & Usage

 ## User_Registration
  #### UI_Properties 
  - **End User Type** : Individual
  - **Country Of Residence Data** : 
  - **Servicehost** : APIVendor(W)
  - **Google Places API Key** : Provide your google maps API key
  - **Wizard Layout** : Select the layout (Vertical Layout)
  #### Server Properties
  - **apikey** : Provide weavr account apikey
  - **profileId** : Provide weavr account consumers_profile_id

## NetWorthDashboard
  #### UI_Properties
  - **Basecurrency** : Bind the selected currnecy
  - **Userid** : Bind the consumer email
  - **Authtoken** : Bind logged in user authtoken
  #### Server Properties
  - **apikey** : Provide weavr account apikey

 ## AccountsSummary
  #### UI_Properties
  - **Basecurrency** : Bind selected Currency
  #### Server Properties
  - **apikey** : Provide weavr account apikey

 ## CardsSummary
  #### UI_Properties
  - **Basecurrency** : Bind selected Currency
  #### Server Properties
  - **apikey** : Provide weavr account apikey

 ## UpcomingGoalPayments
  #### UI_Properties
  - **Userid** : Bind consumer root user email
  - **Basecurrency** : Bind selected Currency
  - **Authtoken** : Bind loggedInUser authtoken
  #### Server Properties
  - **apikey** : Provide weavr account apikey

 ## CardSpendAnalysis
  #### UI_Properties
  - **Card id** : Bind selectCard
  - **Authtoken** : Bind loggedInUser authtoken
  - **Page** : Dashboard
  - **Base currency** : Bind selected Currency
  - **Month** : Bind : App.getCurrentMonth()
  #### Server Properties
  - **apikey** : Provide weavr account apikey

 ## Managed_Accounts
  #### UI_Properties
  - **Enduser Id** : Bind logged in user id
  - **Servicehost** : APIVendor(W)
  - **Authtoken** : Bind loggedInUser authtoken
  - **Itemsperpage** : 
  - **Accounttype** : Bind selectAccountType else  All
  #### Server Properties
  - **apikey** : Provide weavr account apikey
  - **entityid** : SANDBOX

 ## Create_Account 
  #### UI_Properties
  - **End User/Managed Profile Id** : Bind Managed_Accounts profileid
  - **Servicehost** : APIVendor(W)
  - **Authtoken** : Bind loggedInUser authtoken
  #### Server Properties
  - **apikey** : Provide weavr account apikey
  - **managedprofileid** : Provide weavr account_profile_id

 ## Account_Details
  #### UI_Properties
  - **End User Id** : Bind : Variables.consumerGet.dataSet.profileId
  - **Ledger or Account Id** : Bind pageParams.accountId
  - **Servicehost** : APIVendor(W)
  - **Authtoken** : Bind loggedInUser authtoken
  - **Show TransferFunds Button** : true
  - **Show FundAccount button** : true
  #### Server Properties
   - **apikey** : Provide weavr account apikey
   - **entityid** : SANDBOX

 ## List_Transactions
  #### UI_Properties
  - **ServiceHost** : APIVendor(W)
  - **Authtoken** : Bind loggedInUser authtoken
  - **Transaction List(Either Account Or Card)** : Managed Account
  - **AccountID or CardID** : Bind pageParams.accountId
  - **Transaction Type** : CR/DR
  - **Show Search Box** : 
  - **Account /Card Details** : 
  - **Itemsperpage** : 10
  - **Show date Filter** : 
  #### Server Properties
   - **apikey** : Provide weavr account apikey
   - **entityid** : SANDBOX

 ## Transfer_Funds
  #### UI_Properties
  - **End User / Transaction Profile Id** : 
  - **Ledger / Account Id** : Bind Widgets.Account_Details1.selectedledgerdetails.id
  - **Servicehost** : APIVendor(W)
  - **Authtoken** : Bind loggedInUser authtoken
  - **Selected Beneficiary Id** : 
  - **Selected Ledger Id** : Bind Widgets.Account_Details1.selectedledgerdetails.id
  - **Wizard Layout** : Vertical Layout
  #### Server Properties
  - **apikey** : Provide weavr account apikey
  - **transfersprofileid** : Provide weavr transfers_profile_id

 ## ManagedCards
  #### UI_Properties
  - **Servicehost** : APIVendor(W)
  - **Authtoken** : Bind loggedInUser authtoken
  - **Uikey** : Add the ux_key from wear for CVV component
  - **Select Card Type** : CardFlipView
  - **Enduser Id** : 
  #### Server Properties
  - **apikey** : Provide weavr account apikey
  - **entityid** : SANDBOX

 ## ApplyManagedCard1
  #### UI_Properties
  - **Servicehost** : APIVendor(W)
  - **Authtoken** : Bind loggedInUser authtoken
  - **Enduser Id** : 
  - **Default Card Holder Name** : 
  - **Googleplaces apikey** : Provied your maps api key
  - **Wizardlayout** : Vertical Layout
  - **Currency Type** : GBP
  #### Server Properties
  - **apikey** : Provide weavr account apikey
  - **profileid **** : Provide weavr managed_cards_profile_id

 ## Transfer_Funds
  #### UI_Properties
  - **End User / Transaction Profile Id** : 
  - **Ledger / Account Id** : 
  - **Servicehost** : APIVendor(W)
  - **Authtoken** : Bind loggedInUser authtoken
  - **Selected Beneficiary Id** : Bind  Widgets.ApplyManagedCard1.addedcardid
  - **Selected Ledger Id** : 
  - **Wizard Layout** : Vertical Layout
  #### Server Properties
  - **apikey** : Provide weavr account apikey
  - **transfersprofileid** : Provide weavr transfers_profile_id

## ManagedCardDetails
  #### UI_Properties
  - **Servicehost** : APIVendor(W)
  - **Authtoken** : Bind loggedInUser authtoken
  - **ManagedCardId** : Bind : pageParams.managedCardId
  - **UI Key** : Add the ux_key from wear for CVV component 
  - **Show Fund Card Button** : false
  - **Showspendlimit** : true
  - **Showtransfer** : true
  #### Server Properties
  - **apikey** : Provide weavr account apikey
  - **entityid** : SANDBOX

 ## List_Transactions1
  #### UI_Properties
  - **ServiceHost** : APIVendor(W)
  - **Authtoken** : Bind loggedInUser authtoken
  - **Transaction List(Either Account Or Card)** : Managed Card
  - **AccountID or CardID** : Bind pageParams.managedCardId
  - **Transaction Type** : CR/DR
  - **Show Search Box** : 
  - **Account /Card Details** : Bind Widgets.ManagedCardDetails1.selectedcarddetails
  - **Itemsperpage** : 100
  - **Show date Filter** : 
  #### Server Properties
  - **apikey** : Provide weavr account apikey
  - **entityid** : SANDBOX

 ## ListWealthGoals
  #### UI_Properties
  - **user Id** : Bind consumer root user email
  - **Authtoken** : Bind loggedInUser authtoken
  - **Viewtype** : Web
  #### Server Properties
  - **apikey** : Provide weavr account apikey
  - **entityid** : SANDBOX

 ## CreateWealthGoal
  #### UI_Properties
  - **logged_in_user_id** : Bind consumer root user email
  - **Authtoken** : Bind loggedInUser authtoken
  - **Enduser Id** : Bind logged in user id
  #### Server Properties
  - **apikey** : Provide weavr account apikey
  - **entityid** : SANDBOX


Note : 
- Mandatory to provied Databse connection details. <a href="https://github.com/wm-demoapps/BrightBank/blob/main/BrightBankDB_bk_04_jan_2024.sql" target="_blank">Click Here</a> to get DB script
- Update the server properties directly in this path  src/main/webapp/WEB-INF/prefabs/<Prefab_name>/config/prefab-conf/prefabProperties.properties if you are unable to updaet from the Application UI
- For DashBoard and Crads Page value should be **Dashobard** and for SpendAnalasis it should be **FullSpendAnalysis**.
- Adde the apikey for below properties in all the profiles
```
    prefab.ApplyManagedCard.rest.weavr.apikey.header.apikey=
    prefab.ManagedCardTransactions.rest.weavr.apikey.header.apikey=
    prefab.ManagedCards.rest.weavr.apikey.header.apikey=
``` 




# Information about Project Folder Structure and Files

## pom.xml
  Add any maven dependencies to this file. Dependencies declared in this file will be available on the classpath.

## lib
  Add custom jar files to this folder. Files added to this folder will be copied to WEB-INF/lib/ on the classpath.

## services
  All services should be added via studio. Once added, services can be edited via eclipse or other editors, including adding additional classes. 
  Classes in this folder will be compiled when the project is run or deployed.
  Files added to this folder will be copied to WEB-INF/classes/ on the classpath.
  Modifications to imported services can be lost upon re-import.

  To see external updates in studio, use the refresh button in the java editor.
 
## src/main/java
  Add your application sources such as java class files to this folder. 
  Files added to this folder will be copied to WEB-INF/classes/ on the classpath.
  
## src/main/resources
  Add your application resources such as properties and xml files to this folder. 
  Files added to this folder will be copied to WEB-INF/classes/ on the classpath.

## src/main/webapp
  Add web application sources to this folder.
  Files you need to know:
  - **app.css:** Application CSS
  - **index.html:** Can be edited directly to customize, such as including meta, script and other tags.
  - **app.js:** Contains any application owned component definitions and functions.
  - **app.variables.json:** Contains any application variable definition.

## src/test/java
  Add your unit tests specific to the application such as JUnit tests to this folder.

## src/test/resources
  Add your test resources such as properties and xml files to this folder.

## src/main/webapp/WEB-INF/data
  This data directory is for HSQLDB Databases.
  
  By default, it contains some sample databases.
  If your project does not use these sample database, you can delete these files and directory to reduce the size of your project.

  You can also add your own HSQLDB database or other data files to this directory. All HSQLDB databases must be in this directory.

## src/main/webapp/pages
  Each project page creates a folder by the name of the page, i.e Main. 
  All page files in the pages folder are studio managed. 
  Files you need to know:
  - **Page CSS (i.e. Main.css):** Contains custom css added in source, css or by applying custom styles to components.
  - **Page HTML (i.e. Main.html):** Contains any custom markup added in the source, markup editor. Can be edited with the project closed.
  - **Page JS (i.e. Main.js):** Can be edited via the file system. Use the refresh button in the source, script panel if you edit this file outside of studio.
  - **Page Variable (i.e. Main.variable.json):** Can be edited via the file system. Use the refresh button in the source, script panel if you edit this file outside of studio.

## src/main/webapp/services
  Contains service definition files used by studio. These files are not user editable. 

## src/main/webapp/resources
  Created upon first use of the resources panel in studio. These are the folders uses by the resources panel and resources in binding. 

## src/main/webapp/WEB-INF
  web.xml is the Web Application Deployment Descriptor in which you can add custom servlets,filters and listeners.

## src/main/webapp/WEB-INF/classes
  This folder is populated by studio. Do not edit or add any files to this folder. Changes will be lost. Use src/main/resources instead.

## src/main/webapp/WEB-INF/lib
  This folder is populated by studio. Do not edit or add any files to this folder. Changes will be lost. Add jars into lib directory of the project or add dependencies in the pom.xml instead.

## Build and Deploy
  The application contains set of Docker Files which can be used to build and deploy the application. Refer the below link for more information.
  https://docs.wavemaker.com/learn/app-development/deployment/build-with-docker
