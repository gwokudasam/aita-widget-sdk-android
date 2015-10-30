# App in the Air Android SDK
AitA Android SDK designed to simplify the iteraction with App in the Air internal widget API. It will allow you to design a widget that is appear on our feed screen (there would be a screenshot with example here). Basically you are now allowed to design your own widgets that could be integrated with our application easily.

Learn more about  [distribution](#distribution).

## Usage
1) Clone this repository

```shell
git clone https://github.com/appintheair/aita-android-widget-sdk.git
```

2) Open project from the template folder

![Screenshot 1](https://habrastorage.org/files/b65/380/1ee/b653801eeb39447084cf21a6ec3e11e0.png)
![Screenshot 2](https://habrastorage.org/files/032/d1e/e97/032d1ee975514cf096d235bb76d4df46.png)

3) Your widget should be created as a library module.

![Screenshot 3](https://habrastorage.org/files/788/d2f/99e/788d2f99edff4698b7065acd9bb81965.png)
    
4) To include our SDK in your projects add gradle dependency to your library module

```gradle
compile 'com.github.appintheair:aita-android-widget-sdk:0.9.3-beta-2'
```

Don't forget to add your module as a dependency for the template project of the app module.

5) Extend `WidgetView` class and implement all necessary methods

```java
public class MyAwesomeWidget extends WidgetView {
	@Override
	protected void setUpWidget() {
		// set up
	}
	
	@Override
	public void update() {
		// update
	}
	
	@Override
	public String getWidgetTitleText() {
		return "Widget title";
	}
	
	@Override
	public String getWidgetSubtitleText() {
		return "Widget subtitile";
	}
	
	@Override
	public int getWidgetIconId() {
		return R.drawable.widget_icon;
	}
	
	@Override
	public int getWidgetViewId() {
		return R.layout.view_widget;
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

See full version with airport and airline objects [here](https://github.com/appintheair/aita-android-widget-sdk/blob/master/sample/app/src/main/java/com/aita/aitawidgetsample/MainActivity.java)

7) Create your awesome widget and test it with the template project. 

## Widget lifecycle
![Lifecycle image](https://habrastorage.org/files/893/bd2/149/893bd21493ae4372bf1e06dd994ad6f3.png)

## Notes
* Don't forget to implement each of three default constructors.
* Don't use fragments in your widget.
* Widget icon has 40x40 dp. size. It must be round and flat.
* We use ProGuard to obfuscate code, so, please, provide proguard rules for your widget.
* And don't forget to give us a list of your gradle dependencies :)

## See also
[Sample app](https://github.com/appintheair/aita-android-widget-sdk/tree/master/sample) with weather widget.
![Screenshot 4](https://habrastorage.org/files/555/1fd/e95/5551fde9577c4812a74c3f5fc93fa2bf.png)

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
