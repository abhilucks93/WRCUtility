# WRC_UTILITY
Utility Components : Lets save the efforts for bigger problems.

## Download
Grab library via Gradle
```groovy
compile 'com.wildnet.wrcUtility:wrcUtility:1.0.9'
```
or Maven
```xml
<dependency>
  <groupId>com.wildnet.wrcUtility</groupId>
  <artifactId>wrcUtility</artifactId>
  <version>1.0.9</version>
  <type>pom</type>
</dependency>
```

## Utility classes included

- [WRCCalculationUtility](#binding-of-any-views) - Set of utilities to calculate stuffs like screen width, pixel value, dp to px, format time, etc.
- [WRCDateTimeUtility](Download) - Set of utilities to handle date manipulation.
- [WRCDeviceUtility](Download) - Set of utilities to get device related stuff like Device Unique Key.
- [WRCFileUtility](Download) - Set of utilities to handle File related tasks.
- [WRCImageUtility](Download) - Set of utilities to handle image manipulation.
- [WRCListViewUtility](Download) -Set of utilities to handle tasks on ListView.
- [WRCNetworkUtility](Download) - Set of utilities to handle Internet, GPS and Location related stuff.
- [WRCPreferences](Download) - Set of utilities to handle SharedPreferences abstraction.
- [WRCStrings](Download) - Set of utilities to perform tasks on Strings.
- [WRCUiUtility](Download) - Set of utilities to handle Android Views' related stuff.
- [WRCValidationUtility](Download) - Set of utilities to handle validations on attributes like password, Email, etc.

## Binding of any views
```java
// Basic 
EditText editText = (EditText) context.findViewById(R.id.editText1);
com.example.view.CustomView customView = (com.example.view.CustomView) context.findViewById(R.id.view);

// Shortify
EditText editText = $.bind(R.id.editText1);
com.example.view.CustomView customView = $.bind(R.id.view);
```
