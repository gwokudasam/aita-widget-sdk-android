# App in the Air Android widget SDK
Android library for working with App in the Air widget API.

## Usage
1) Clone this repository

```shell
git clone https://github.com/appintheair/aita-android-widget-sdk.git
```

2) Open project from the template folder

![Screenshot 1](https://habrastorage.org/files/b65/380/1ee/b653801eeb39447084cf21a6ec3e11e0.png)
![Screenshot 2](https://habrastorage.org/files/032/d1e/e97/032d1ee975514cf096d235bb76d4df46.png)

3) Add new library module - it will contain your widget.

![Screenshot 3](https://habrastorage.org/files/788/d2f/99e/788d2f99edff4698b7065acd9bb81965.png)
    
4) Add gradle dependency to your library module

```gradle
compile 'com.github.appintheair:aita-android-widget-sdk:0.9.0'
```

and add your library module as a dependency for the template project app module.

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
	
	@NonNull
	@Override
	protected String getWidgetTitleText() {
		return "Widget title";
	}
	
	@NonNull
	@Override
	protected String getWidgetSubtitleText() {
		return "Widget subtitile";
	}
	
	@Override
	protected int getWidgetIconId() {
		return R.drawable.widget_icon;
	}
	
	@Override
	protected int getWidgetViewId() {
		return R.layout.view_widget;
	}
}
```
    
6) Fake flight, airport and airline data for your needs

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

See full version [here](https://github.com/appintheair/aita-android-widget-sdk/blob/master/sample/app/src/main/java/com/aita/aitawidgetsample/MainActivity.java)

7) Create your awesome widget and test it with the template project. 

## See also
[Sample app](https://github.com/appintheair/aita-android-widget-sdk/tree/master/sample) with weather widget.
![Screenshot 4](https://habrastorage.org/files/879/4d3/2ee/8794d32ee4154b6c8e34788f6d4d2a36.png)

## Distribution
1) Find `.aar` file in 

```shell
<your-library-module-name>/build/outputs/aar/<your-library-module-name>-release.aar
```

folder.

2) Write us on [opensource@appintheair.mobi](mailto:opensource@appintheair.mobi). Attach full description of your widget, screenshots and `.aar` file.

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
