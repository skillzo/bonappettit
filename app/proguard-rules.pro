# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

## Keep application dependencies
# Keep sofptos

# Keep Alcineo BonAppetit classes
-keep class com.alcineo.bonappetit.** { *; }

# Keep application dependencies
-keep class com.neovisionaries.i18n.** { *; }
-keep class com.mitchellbosecke.pebble.** { *; }
-keep class lombok.core.** { *; }
-keep class android.** { *; }
-keep class androidx.** { *; }
-keep class retrofit2.** { *; }
-keep class okhttp3.** { *; }
-keep class com.google.** { *; }
-keep class org.slf4j.** { *; }

#-keep class com.alcineo.** { *; }
-keepattributes Exceptions
-keep class com.alcineo.** {*;}