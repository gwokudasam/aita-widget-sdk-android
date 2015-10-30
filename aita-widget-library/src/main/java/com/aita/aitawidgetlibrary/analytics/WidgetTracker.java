package com.aita.aitawidgetlibrary.analytics;

/**
 * An interface that represents an analytics tracker
 */
public interface WidgetTracker {

    /**
     * @param action to send. It cannot be null.
     * @param label  to send. <u>May be null<u/>.
     */
    void sendEvent(String action,String label);

}
