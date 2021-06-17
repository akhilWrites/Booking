package com.booking.Booking.Exception;

public class HotelsNotFoundExceptionResponse {

    private String hotelsNotFound;

    public HotelsNotFoundExceptionResponse(String hotelsNotFound) {
        this.hotelsNotFound=hotelsNotFound;
    }

    public String getHotelsNotFound() {
        return hotelsNotFound;
    }

    public void setHotelsNotFound(String hotelsNotFound) {
        this.hotelsNotFound = hotelsNotFound;
    }
}
