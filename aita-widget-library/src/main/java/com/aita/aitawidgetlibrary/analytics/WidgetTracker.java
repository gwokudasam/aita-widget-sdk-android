package com.aita.aitawidgetlibrary.analytics;

public interface WidgetTracker {
    void sendEvent(String action, String label);
}
