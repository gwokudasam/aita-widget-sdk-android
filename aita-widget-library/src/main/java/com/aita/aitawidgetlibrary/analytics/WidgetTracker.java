package com.aita.aitawidgetlibrary.analytics;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * An interface that represents an analytics tracker
 */
public interface WidgetTracker {

    /**
     * @param action to send. It cannot be null.
     * @param label  to send. <u>May be null<u/>.
     */
    void sendEvent(@NonNull String action, @Nullable String label);

}
