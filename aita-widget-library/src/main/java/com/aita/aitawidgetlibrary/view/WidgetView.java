package com.aita.aitawidgetlibrary.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.aita.aitawidgetlibrary.analytics.WidgetTracker;
import com.aita.aitawidgetlibrary.model.WidgetFlight;

/**
 * The {@code WidgetView} is a base view class for an App in the Air feed widget.
 */
public abstract class WidgetView extends RelativeLayout {

    protected Context mContext;
    protected WidgetFlight mFlight;
    protected WidgetTracker mTracker;

    public WidgetView(final Context context) {
        super(context);
        mContext = context;
    }

    public WidgetView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public WidgetView(final Context context, final AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    /**
     * Sets the flight. Called when the widget appears in the feed after inflating
     *
     * @param flight The flight to set. It cannot be null.
     */
    public void setFlight(final WidgetFlight flight) {
        mFlight = flight;
        inflate(mContext, getWidgetViewId(), this);
        setUpWidget();
    }

    /**
     * Sets the analytics tracker.
     *
     * @param tracker The {@link WidgetTracker} to set. It cannot be null.
     */
    public void setTracker(final WidgetTracker tracker) {
        mTracker = tracker;
    }

    /**
     * Called every 1-5 minutes or when the flight updated. It calls {@link #update()} inside.
     *
     * @param flight The flight to set. It cannot be null.
     */
    public void update(final WidgetFlight flight) {
        mFlight = flight;
        update();
    }

    /**
     * Send analytics event.
     *
     * @param action The action title, e.g. "my_widget_button_click".
     */
    protected void sendEvent(String action) {
        sendEvent(action, null);
    }

    /**
     * Send analytics event with label.
     *
     * @param action The action title, e.g. "my_widget_button_click".
     * @param label  The label for the action, e.g. "done_button".
     */
    protected void sendEvent(String action, String label) {
        if (mTracker != null)
            mTracker.sendEvent(action, label);
    }

    /**
     * Called at least once a minute. Use it to update your widget's content if needed. Don't
     * put hard or slow operations here.
     */
    public abstract void update();

    /**
     * Called once after the {@link #setFlight(WidgetFlight)} method. Use it to initialize and
     * set up your widget. For updating your widget use the {@link #update()} method.
     */
    protected abstract void setUpWidget();

    /**
     * This method is called in {@link #setUpWidget()} to set up your widget's title.
     *
     * @return The title for your widget. It cannot be null.
     */

    public abstract String getWidgetTitleText();

    /**
     * This method is called in {@link #setUpWidget()} to set up your widget's subtitle.
     *
     * @return The subtitle for your widget. It cannot be null.
     */

    public abstract String getWidgetSubtitleText();

    /**
     * This method is called in {@link #setUpWidget()} to set up your widget's circle icon.
     *
     * @return The image resource id for your widget's circle icon.
     */
    public abstract int getWidgetIconId();

    /**
     * This method is called in {@link #setUpWidget()} to set up your widget's layout.
     *
     * @return The layout resource id for your widget's content.
     */
    public abstract int getWidgetViewId();

}
