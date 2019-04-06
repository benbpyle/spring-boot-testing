package com.binaryheap.testing.events;

public class IntegrationEvent {
    private String type;
    private EventDetail detail;

    public EventDetail getDetail() {
        return detail;
    }

    public void setDetail(EventDetail detail) {
        this.detail = detail;
        setType(detail.getClass().getName());
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }
}
