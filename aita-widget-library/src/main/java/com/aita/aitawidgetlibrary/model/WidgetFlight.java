package com.aita.aitawidgetlibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * The {@code WidgetFlight} is a representation of a flight.
 */
public class WidgetFlight implements Parcelable {

    /**
     * The {@code WidgetFlightStatus} is a convenient representation of flight status field.
     */
    public enum WidgetFlightStatus {
        EN_ROUTE,
        CANCELED,
        DIVERTED,
        DATA_SOURCE_NEEDED,
        LANDED,
        NOT_OPERATIONAL,
        REDIRECTED,
        SCHEDULED,
        UNKNOWN;
    }

    private WidgetFlightStatus statusEnum;

    private float distance;

    private String status;
    private String seat;
    private String seatZone;
    private String bookingReference;
    private String equipment;
    private String number;
    private String airlineCode;

    private long duration;
    private long checkinTime;
    private long boardingTime;
    private long takeOffTime;
    private long landingTime;

    private WidgetAirport arrivalAirport;
    private WidgetAirport departureAirport;

    private WidgetAirline airline;

    public WidgetFlight(float distance,
                        String status,
                        String seat,
                        String seatZone,
                        String bookingReference,
                        String equipment,
                        String number,
                        String airlineCode,
                        long duration,
                        long checkinTime,
                        long boardingTime,
                        long takeOffTime,
                        long landingTime,
                        WidgetAirport arrivalAirport,
                        WidgetAirport departureAirport,
                        WidgetAirline airline) {
        this.distance = distance;
        this.status = status;
        this.seat = seat;
        this.seatZone = seatZone;
        this.bookingReference = bookingReference;
        this.equipment = equipment;
        this.number = number;
        this.airlineCode = airlineCode;
        this.duration = duration;
        this.checkinTime = checkinTime;
        this.boardingTime = boardingTime;
        this.takeOffTime = takeOffTime;
        this.landingTime = landingTime;
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
        this.airline = airline;
    }

    public WidgetFlight(Parcel parcel) {
        distance = parcel.readFloat();

        status = parcel.readString();
        seat = parcel.readString();
        seatZone = parcel.readString();
        bookingReference = parcel.readString();
        equipment = parcel.readString();
        number = parcel.readString();
        airlineCode = parcel.readString();

        duration = parcel.readLong();
        checkinTime = parcel.readLong();
        boardingTime = parcel.readLong();
        takeOffTime = parcel.readLong();
        landingTime = parcel.readLong();

        arrivalAirport = parcel.readParcelable(WidgetAirport.class.getClassLoader());
        departureAirport = parcel.readParcelable(WidgetAirport.class.getClassLoader());

        airline = parcel.readParcelable(WidgetAirline.class.getClassLoader());
    }

    public static final Parcelable.Creator<WidgetFlight> CREATOR =
            new Parcelable.Creator<WidgetFlight>() {
                public WidgetFlight createFromParcel(Parcel in) {
                    return new WidgetFlight(in);
                }

                public WidgetFlight[] newArray(int size) {
                    return new WidgetFlight[size];
                }
            };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(distance);

        parcel.writeString(status);
        parcel.writeString(seat);
        parcel.writeString(seatZone);
        parcel.writeString(bookingReference);
        parcel.writeString(equipment);
        parcel.writeString(number);
        parcel.writeString(airlineCode);

        parcel.writeLong(duration);
        parcel.writeLong(checkinTime);
        parcel.writeLong(boardingTime);
        parcel.writeLong(takeOffTime);
        parcel.writeLong(landingTime);

        parcel.writeParcelable(arrivalAirport, 0);
        parcel.writeParcelable(departureAirport, 0);

        parcel.writeParcelable(airline, 0);
    }

    /**
     * @return The distance of the flight in kilometres. <u>May be null<u/>.
     */
    public float getDistance() {
        return distance;
    }

    /**
     * @param distance to set in kilometres.
     */
    public void setDistance(float distance) {
        this.distance = distance;
    }

    /**
     * @return The status of the flight, e.g. "Active", "Scheduled",
     * "Cancelled", etc. <u>May be null<u/>.
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status to set, e.g. "Active", "Scheduled", "Cancelled", etc.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return flight status in convenient enum format.
     */
    public WidgetFlightStatus getStatusEnum() {
        if (status == null) {
            return WidgetFlightStatus.UNKNOWN;
        } else {
            switch (status.toLowerCase()) {
                case "a":
                case "en route":
                    return WidgetFlightStatus.EN_ROUTE;
                case "c":
                case "canceled":
                case "cancelled":
                    return WidgetFlightStatus.CANCELED;
                case "d":
                case "diverted":
                    return WidgetFlightStatus.DIVERTED;
                case "dn":
                case "data source needed":
                    return WidgetFlightStatus.DATA_SOURCE_NEEDED;
                case "l":
                case "landed":
                    return WidgetFlightStatus.LANDED;
                case "no":
                case "not operational":
                    return WidgetFlightStatus.NOT_OPERATIONAL;
                case "r":
                case "redirected":
                    return WidgetFlightStatus.REDIRECTED;
                case "s":
                case "scheduled":
                    return WidgetFlightStatus.SCHEDULED;
                default:
                    return WidgetFlightStatus.UNKNOWN;
            }
        }
    }

    /**
     * @param statusEnum flight status in convenient enum format.
     */
    public void setStatusEnum(WidgetFlightStatus statusEnum) {
        switch (statusEnum) {
            case EN_ROUTE:
                status = "En route";
                break;
            case CANCELED:
                status = "Canceled";
                break;
            case DIVERTED:
                status = "Diverted";
                break;
            case DATA_SOURCE_NEEDED:
                status = "Data source needed";
                break;
            case LANDED:
                status = "Landed";
                break;
            case NOT_OPERATIONAL:
                status = "Not operational";
                break;
            case REDIRECTED:
                status = "Redirected";
                break;
            case SCHEDULED:
                status = "Scheduled";
                break;
            case UNKNOWN:
                status = "Unknown";
                break;
        }
    }

    /**
     * @return The seat number if present (e.g. "31B"). <u>May be null<u/>.
     */
    public String getSeat() {
        return seat;
    }

    /**
     * @param seat to set, e.g. "31B".
     */
    public void setSeat(String seat) {
        this.seat = seat;
    }

    /**
     * @return The class (seat zone) if present (e.g. "Economy"). <u>May be null<u/>.
     */
    public String getSeatZone() {
        return seatZone;
    }

    /**
     * @param seatZone to set, e.g. "Economy".
     */
    public void setSeatZone(String seatZone) {
        this.seatZone = seatZone;
    }

    /**
     * @return The booking reference if present (e.g. "MKF6HE"). <u>May be null<u/>.
     */
    public String getBookingReference() {
        return bookingReference;
    }

    /**
     * @param bookingReference to set, e.g. "MKF6HE".
     */
    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    /**
     * @return The aircraft type if present (e.g. "737"). <u>May be null<u/>.
     */
    public String getEquipment() {
        return equipment;
    }

    /**
     * @param equipment to set, e.g. "737".
     */
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    /**
     * @return The flight number if present (e.g. "179"). <u>May be null<u/>.
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number to set, e.g. "179".
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return The IATA airline code if present (e.g. "VX"). <u>May be null<u/>.
     */
    public String getAirlineCode() {
        return airlineCode;
    }

    /**
     * @param airlineCode to set, e.g. "VX".
     */
    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    /**
     * @return The duration of the flight in <u>seconds</u>.
     */
    public long getDuration() {
        return duration;
    }

    /**
     * @param duration to set in <u>seconds</u>.
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }

    /**
     * @return The checkin time in <u>seconds</u> in departure airport timezone
     * since January 1, 1970 00:00:00.0 UTC.
     */
    public long getCheckinTime() {
        return checkinTime;
    }

    /**
     * @param checkinTime to set in <u>seconds</u> in departure airport timezone
     *                    since January 1, 1970 00:00:00.0 UTC.
     */
    public void setCheckinTime(long checkinTime) {
        this.checkinTime = checkinTime;
    }

    /**
     * @return The boarding time in <u>seconds</u> in departure airport timezone
     * since January 1, 1970 00:00:00.0 UTC.
     */
    public long getBoardingTime() {
        return boardingTime;
    }

    /**
     * @param boardingTime to set in <u>seconds</u> in departure airport timezone
     *                     since January 1, 1970 00:00:00.0 UTC.
     */
    public void setBoardingTime(long boardingTime) {
        this.boardingTime = boardingTime;
    }

    /**
     * @return The take off time in <u>seconds</u> in departure airport timezone
     * since January 1, 1970 00:00:00.0 UTC.
     */
    public long getTakeOffTime() {
        return takeOffTime;
    }

    /**
     * @param takeOffTime to set in <u>seconds</u> in departure airport timezone
     *                    since January 1, 1970 00:00:00.0 UTC.
     */
    public void setTakeOffTime(long takeOffTime) {
        this.takeOffTime = takeOffTime;
    }

    /**
     * @return The landing time in <u>seconds</u> in arrival airport timezone
     * since January 1, 1970 00:00:00.0 UTC.
     */
    public long getLandingTime() {
        return landingTime;
    }

    /**
     * @param landingTime to set in <u>seconds</u> in arrival airport timezone
     *                    since January 1, 1970 00:00:00.0 UTC.
     */
    public void setLandingTime(long landingTime) {
        this.landingTime = landingTime;
    }

    /**
     * @return The arrival {@link WidgetAirport} object of the flight. <u>May be null</u>.
     */
    public WidgetAirport getArrivalAirport() {
        return arrivalAirport;
    }

    /**
     * @param arrivalAirport an {@link WidgetAirport} object to set.
     */
    public void setArrivalAirport(WidgetAirport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    /**
     * @return The departure {@link WidgetAirport} object of the flight. <u>May be null</u>.
     */
    public WidgetAirport getDepartureAirport() {
        return departureAirport;
    }

    /**
     * @param departureAirport {@link WidgetAirport} object to set.
     */
    public void setDepartureAirport(WidgetAirport departureAirport) {
        this.departureAirport = departureAirport;
    }

    /**
     * @return The {@link WidgetAirline} object of the flight. <u>May be null</u>.
     */
    public WidgetAirline getAirline() {
        return airline;
    }

    /**
     * @param airline {@link WidgetAirline} object to set.
     */
    public void setAirline(WidgetAirline airline) {
        this.airline = airline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WidgetFlight that = (WidgetFlight) o;

        if (Float.compare(that.distance, distance) != 0) return false;
        if (duration != that.duration) return false;
        if (checkinTime != that.checkinTime) return false;
        if (boardingTime != that.boardingTime) return false;
        if (takeOffTime != that.takeOffTime) return false;
        if (landingTime != that.landingTime) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (seat != null ? !seat.equals(that.seat) : that.seat != null) return false;
        if (seatZone != null ? !seatZone.equals(that.seatZone) : that.seatZone != null)
            return false;
        if (bookingReference != null ? !bookingReference.equals(that.bookingReference) :
                that.bookingReference != null)
            return false;
        if (equipment != null ? !equipment.equals(that.equipment) : that.equipment != null)
            return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (airlineCode != null ? !airlineCode.equals(that.airlineCode) : that.airlineCode != null)
            return false;
        if (arrivalAirport != null ? !arrivalAirport.equals(that.arrivalAirport) :
                that.arrivalAirport != null)
            return false;
        if (departureAirport != null ? !departureAirport.equals(that.departureAirport) :
                that.departureAirport != null)
            return false;
        return !(airline != null ? !airline.equals(that.airline) : that.airline != null);

    }

    @Override
    public int hashCode() {
        int result = (distance != +0.0f ? Float.floatToIntBits(distance) : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (seat != null ? seat.hashCode() : 0);
        result = 31 * result + (seatZone != null ? seatZone.hashCode() : 0);
        result = 31 * result + (bookingReference != null ? bookingReference.hashCode() : 0);
        result = 31 * result + (equipment != null ? equipment.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (airlineCode != null ? airlineCode.hashCode() : 0);
        result = 31 * result + (int) (duration ^ (duration >>> 32));
        result = 31 * result + (int) (checkinTime ^ (checkinTime >>> 32));
        result = 31 * result + (int) (boardingTime ^ (boardingTime >>> 32));
        result = 31 * result + (int) (takeOffTime ^ (takeOffTime >>> 32));
        result = 31 * result + (int) (landingTime ^ (landingTime >>> 32));
        result = 31 * result + (arrivalAirport != null ? arrivalAirport.hashCode() : 0);
        result = 31 * result + (departureAirport != null ? departureAirport.hashCode() : 0);
        result = 31 * result + (airline != null ? airline.hashCode() : 0);
        return result;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }
}
