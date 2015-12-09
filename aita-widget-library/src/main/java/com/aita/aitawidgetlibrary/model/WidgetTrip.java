package com.aita.aitawidgetlibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class WidgetTrip implements Parcelable {

    private long departureDate;
    private String departureAirportCode;
    private long arrivalDate;
    private String arrivalAirportCode;
    private ArrayList<WidgetFlight> flights;

    public WidgetTrip(String id,
                      long departureDate,
                      String departureAirportCode,
                      long arrivalDate,
                      String arrivalAirportCode,
                      ArrayList<WidgetFlight> flights) {
        this.departureDate = departureDate;
        this.departureAirportCode = departureAirportCode;
        this.arrivalDate = arrivalDate;
        this.arrivalAirportCode = arrivalAirportCode;
        this.flights = flights;
    }

    protected WidgetTrip(Parcel parcel) {
        departureDate = parcel.readLong();
        departureAirportCode = parcel.readString();
        arrivalDate = parcel.readLong();
        arrivalAirportCode = parcel.readString();
        flights = parcel.createTypedArrayList(WidgetFlight.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeLong(departureDate);
        parcel.writeString(departureAirportCode);
        parcel.writeLong(arrivalDate);
        parcel.writeString(arrivalAirportCode);
        parcel.writeTypedList(flights);
    }

    /**
     * @return The departure time in seconds in the departure airport timezone.
     */
    public long getDepartureDate() {
        return departureDate;
    }

    /**
     * @param departureDate the departure time in seconds in the departure airport timezone to set.
     */
    public void setDepartureDate(long departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * @return The departure airport code. <u>May be null<u/>.
     */
    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    /**
     * @param departureAirportCode the departure airport code to set.
     */
    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    /**
     * @return The arrival time in seconds in the arrival airport timezone.
     */
    public long getArrivalDate() {
        return arrivalDate;
    }

    /**
     * @param arrivalDate the arrival time in seconds in the arrival airport timezone to set.
     */
    public void setArrivalDate(long arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * @return The arrival airport code. <u>May be null<u/>.
     */
    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    /**
     * @param arrivalAirportCode the arrival airport code to set.
     */
    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    /**
     * @return The list of flights of the trip. <u>May be null<u/>.
     */
    public ArrayList<WidgetFlight> getFlights() {
        return flights;
    }

    /**
     * @param flights the list of flights for the trip.
     */
    public void setFlights(ArrayList<WidgetFlight> flights) {
        this.flights = flights;
    }

    public static final Creator<WidgetTrip> CREATOR = new Creator<WidgetTrip>() {
        @Override
        public WidgetTrip createFromParcel(Parcel in) {
            return new WidgetTrip(in);
        }

        @Override
        public WidgetTrip[] newArray(int size) {
            return new WidgetTrip[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WidgetTrip that = (WidgetTrip) o;

        if (departureDate != that.departureDate) return false;
        if (arrivalDate != that.arrivalDate) return false;
        if (departureAirportCode != null ? !departureAirportCode.equals(that.departureAirportCode) : that.departureAirportCode != null)
            return false;
        if (arrivalAirportCode != null ? !arrivalAirportCode.equals(that.arrivalAirportCode) : that.arrivalAirportCode != null)
            return false;
        return !(flights != null ? !flights.equals(that.flights) : that.flights != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (departureDate ^ (departureDate >>> 32));
        result = 31 * result + (departureAirportCode != null ? departureAirportCode.hashCode() : 0);
        result = 31 * result + (int) (arrivalDate ^ (arrivalDate >>> 32));
        result = 31 * result + (arrivalAirportCode != null ? arrivalAirportCode.hashCode() : 0);
        result = 31 * result + (flights != null ? flights.hashCode() : 0);
        return result;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

}
