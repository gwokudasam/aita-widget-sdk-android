package com.aita.aitawidgetlibrary.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aita.aitawidgetlibrary.R;
import com.aita.aitawidgetlibrary.analytics.WidgetTracker;
import com.aita.aitawidgetlibrary.model.WidgetFlight;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * The {@code WidgetView} is a base view class for an App in the Air feed widget.
 */
public abstract class WidgetView extends RelativeLayout {

    protected Context mContext;
    protected CardView mWidgetCardView;
    protected TextView mWidgetTitle;
    protected TextView mWidgetSubtitle;
    protected ViewStub mWidgetViewStub;
    protected CircleImageView mWidgetIcon;
    protected WidgetFlight mFlight;
    protected WidgetTracker mTracker;

    public WidgetView(final Context context) {
        super(context);
        inflate(context, R.layout.view_feed_card, this);
        init();
    }

    public WidgetView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.view_feed_card, this);
        init();
    }

    public WidgetView(final Context context, final AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.view_feed_card, this);
        init();
    }

    /**
     * Sets the flight. Called when the widget appears in the feed after the {@link #init()}
     * method called.
     *
     * @param flight The flight to set. It cannot be null.
     */
    public void setFlight(@NonNull final WidgetFlight flight) {
        mFlight = flight;
        setUpWidget();
    }

    /**
     * Sets the analytics tracker.
     *
     * @param tracker The {@link WidgetTracker} to set. It cannot be null.
     */
    public void setTracker(@NonNull final WidgetTracker tracker) {
        mTracker = tracker;
    }

    /**
     * Called every 1-5 minutes or when the flight updated. It calls {@link #update()} inside.
     *
     * @param flight The flight to set. It cannot be null.
     */
    public void update(@NonNull final WidgetFlight flight) {
        mFlight = flight;
        update();
    }

    private void init() {
        mWidgetCardView = (CardView) findViewById(R.id.widget_card_view);
        mWidgetTitle = (TextView) findViewById(R.id.widget_title);
        mWidgetSubtitle = (TextView) findViewById(R.id.widget_subtitle);
        mWidgetViewStub = (ViewStub) findViewById(R.id.widget_viewstub);
        mWidgetIcon = (CircleImageView) findViewById(R.id.widget_icon);

        mContext = getContext();
        if (mContext != null) {
            final AssetManager assets = mContext.getAssets();
            if (assets != null) {
                final Typeface robotoLightTypeface = Typeface.createFromAsset(
                        assets,
                        "fonts/Roboto-Light.ttf");
                mWidgetTitle.setTypeface(robotoLightTypeface);
                mWidgetSubtitle.setTypeface(robotoLightTypeface);
            }
        }

        mWidgetTitle.setText(getWidgetTitleText());
        mWidgetSubtitle.setText(getWidgetSubtitleText());
        mWidgetIcon.setImageResource(getWidgetIconId());
        mWidgetViewStub.setLayoutResource(getWidgetViewId());
        mWidgetViewStub.inflate();
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
    @NonNull
    protected abstract String getWidgetTitleText();

    /**
     * This method is called in {@link #setUpWidget()} to set up your widget's subtitle.
     *
     * @return The subtitle for your widget. It cannot be null.
     */
    @NonNull
    protected abstract String getWidgetSubtitleText();

    /**
     * This method is called in {@link #setUpWidget()} to set up your widget's circle icon.
     *
     * @return The image resource id for your widget's circle icon.
     */
    protected abstract int getWidgetIconId();

    /**
     * This method is called in {@link #setUpWidget()} to set up your widget's layout.
     *
     * @return The layout resource id for your widget's content.
     */
    protected abstract int getWidgetViewId();

}
