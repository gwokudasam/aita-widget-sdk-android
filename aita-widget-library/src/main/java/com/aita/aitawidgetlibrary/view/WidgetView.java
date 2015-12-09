package com.aita.aitawidgetlibrary.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.aita.aitawidgetlibrary.analytics.WidgetTracker;
import com.aita.aitawidgetlibrary.model.WidgetFlight;
import com.aita.aitawidgetlibrary.other.WidgetViewManager;

/**
 * The {@code WidgetView} is a base view class for an App in the Air feed widget.
 */
public abstract class WidgetView extends RelativeLayout {

    // TODO: Make WidgetView trip-based

    private WidgetTracker mTracker;
    private WidgetViewManager mViewManager;

    public WidgetView(Context context) {
        super(context);
        inflate(context, getWidgetViewId(), this);
    }

    public WidgetView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, getWidgetViewId(), this);
    }

    public WidgetView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, getWidgetViewId(), this);
    }

    /**
     * Sets the flight. Called when the widget appears in the feed after inflating
     *
     * @param flight The flight to set. It cannot be null.
     */
    public abstract void init(WidgetFlight flight);

    /**
     * Called at least once a minute or when the flight was updated.
     * Use it to update your widget's content if needed. Don't put slow operations here.
     *
     * @param flight The flight to set. It cannot be null.
     */
    public abstract void update(WidgetFlight flight);

    /**
     * Sets the analytics tracker.
     *
     * @param tracker The {@link WidgetTracker} to set. It cannot be null.
     */
    public final void setTracker(WidgetTracker tracker) {
        mTracker = tracker;
    }

    /**
     * Sets the view manager.
     *
     * @param viewManager The {@link WidgetViewManager} to set. It cannot be null.
     */
    public final void setViewManager(WidgetViewManager viewManager) {
        mViewManager = viewManager;
    }

    /**
     * Send analytics event.
     *
     * @param action The action title, e.g. "my_widget_button_click".
     */
    protected final void sendEvent(String action) {
        sendEvent(action, null);
    }

    /**
     * Send analytics event with label.
     *
     * @param action The action title, e.g. "my_widget_button_click".
     * @param label  The label for the action, e.g. "done_button".
     */
    protected final void sendEvent(String action, String label) {
        if (mTracker != null) {
            mTracker.sendEvent(action, label);
        }
    }

    /**
     * Makes your widget invisible. Call it when you have nothing to show for the flight.
     */
    protected final void hideWidget() {
        mViewManager.setWidgetViewVisible(false);
    }

    /**
     * Makes your widget visible. Call it when the widget is invisible.
     */
    protected final void showWidget() {
        mViewManager.setWidgetViewVisible(true);
    }

    /**
     * @return The title for your widget. Return null or "" if you want to make title gone.
     */
    public abstract String getWidgetTitleText();

    /**
     * @return The subtitle for your widget. Return null or "" if you want to make subtitle gone.
     */
    public abstract String getWidgetSubtitleText();

    /**
     * @return The image resource id for your widget's circle icon.
     */
    public abstract int getWidgetIconId();

    /**
     * @return The layout resource id for your widget's content.
     */
    public abstract int getWidgetViewId();

    /**
     * @return The OnClickListener for the whole widget card.
     * Return null if your widget card is not clickable.
     */
    public abstract OnClickListener getOnCardClickListener();

    /**
     * @return true if your widget card is clickable, false - otherwise.
     */
    public abstract boolean isCardClickable();

}
