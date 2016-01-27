# App in the Air Android SDK
AitA Android SDK designed to simplify the interaction with App in the Air internal widget API. It will allow you to design a widget that is appear on our feed screen.

![Screenshot 100](https://habrastorage.org/files/fa9/065/091/fa90650919134af0a6746fe549ea0cb6.png)

Basically, you are now allowed to design your own widgets that could be integrated with our application easily.

Learn more about  [distribution](#distribution).

## Usage
1) Clone this repository

```shell
git clone https://github.com/appintheair/aita-widget-sdk-android.git
```

2) Open project from the template folder

![Screenshot 200](https://habrastorage.org/files/b65/380/1ee/b653801eeb39447084cf21a6ec3e11e0.png)

![Screenshot 300](https://habrastorage.org/files/032/d1e/e97/032d1ee975514cf096d235bb76d4df46.png)

3) Your widget should be created as a library module.

![Screenshot 400](https://habrastorage.org/files/788/d2f/99e/788d2f99edff4698b7065acd9bb81965.png)
    
4) To include our SDK in your projects add gradle dependency to your library module

```gradle
compile 'com.github.appintheair:aita-android-widget-sdk:1.0.0'
```

Don't forget to add your module as a dependency for the template project of the app module.

5) Extend `WidgetView` class and implement all necessary methods

```java
public class MyWidget extends WidgetView {
    public MyWidget(Context context) {
        super(context);
    }

    public MyWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void init(WidgetFlight flight) {
        // Called when the widget appears in the feed after inflating
    }

    @Override
    public void update(WidgetFlight flight) {
        // Called at least once a minute or when the flight was updated.
        // Use it to update your widget's content if needed. Don't put slow operations here.
    }

    @Override
    public String getWidgetTitleText() {
        return "My widget title";
    }

    @Override
    public String getWidgetSubtitleText() {
        return "My widget subtitle";
    }

    @Override
    public int getWidgetIconId() {
        return R.drawable.ic_widget_icon;
    }

    @Override
    public int getWidgetViewId() {
        return R.layout.view_my_widget;
    }

    @Override
    public OnClickListener getOnCardClickListener() {
        return new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Winter is coming", Toast.LENGTH_LONG).show();
            }
        };
    }

    @Override
    public boolean isCardClickable() {
        return true;
    }
}
```
    
6) Flight example object. Feel free to edit any of those values.

```java
final WidgetFlight flight = new WidgetFlight(
    3973.3806f, // distance
    "Scheduled", // status
    "31B", //seat
    "Economy", //seat zone
    "MKF6HE", // booking reference
    "737", // equipment
    "1", // flight number
    "AA", // airline IATA code
    22200L, // duration in seconds
    1442912400L, // checkin time
    1442916200L, // boarding time
    1442920000L, // take off time
    1442923800L, // landing time
    arrivalAirport, // arrival airport
    departureAirport, // departure airport
    airline // airline
);
```

See full version with airport and airline objects [here](https://github.com/appintheair/aita-widget-sdk-android/blob/master/template/app/src/main/java/com/aita/widgettemplate/ContentFragment.java)

7) Create your awesome widget and test it with the template project. 

## Widget lifecycle
![Lifecycle image](https://habrastorage.org/files/b9a/850/694/b9a8506942fb4e098e3514a9f764cd0d.png)

## Notes
* Don't forget to implement each of three default constructors.
* Don't use fragments in your widget.
* Widget icon has 40x40 dp. size. It must be round and flat.
* We use ProGuard to obfuscate code, so, please, provide proguard rules for your widget.
* And don't forget to give us a list of your gradle dependencies :)
* If you have nothing to show for the current flight, use ```WidgetView.hideWidget()``` to make it invisible. Use ```WidgetView.showWidget()``` to make it visible.

## Margins and padding
You don't need extra margins or padding - on the screenshot below you can see widget's content area

![Screenshot 500](https://habrastorage.org/files/f37/a3c/33c/f37a3c33cf5b425cb5f1cc3649cd7663.png)

## Opening activities
If you want to open activities from your widget, make them look similar with other activities of the App in the Air. Follow the Material Design principles for consistent UX. You can use following colors:
```xml
<color name="primary">#3295ba</color>
<color name="primary_dark">#1785AA</color>
<color name="primary_light">#C5CAE9</color>
<color name="accent">#1eaaf1</color>
<color name="primary_text">#212121</color>
<color name="secondary_text">#727272</color>
```

![Screenshot 600](https://habrastorage.org/files/a67/fef/92e/a67fef92e43a4a9b92c23f118c8cb727.png)

## See also
[Sample app](https://github.com/appintheair/aita-widget-sdk-android/tree/master/sample) with weather widget.
![Screenshot 700](https://habrastorage.org/files/e37/d47/8af/e37d478afb094b07a645183af8833925.png)

## Distribution
1) Find `.aar` file in 

```shell
<your-library-module-name>/build/outputs/aar/<your-library-module-name>-release.aar
```

folder.

2) Write us on [opensource@appintheair.mobi](mailto:opensource@appintheair.mobi). Attach full description of your widget, list of Gradle dependencies, ProGuard rules, screenshots and `.aar` file.

3) Feel free to contact us and ask any questions.

## License
    The MIT License (MIT)
    
    Copyright (c) 2015 App in the Air
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software. 
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
