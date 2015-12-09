package com.aita.aitawidgetlibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * The {@code WidgetAirport} is a representation of an airport.
 */
public class WidgetAirport implements Parcelable {

    private String airportName;
    private String airportNameTranslated;
    private String city;
    private String cityTranslated;
    private String countryFull;
    private String code;
    private String url;
    private String countryCode;
    private String phone;

    private int tipsCount;
    private int reportsCount;

    private double offset;
    private double latitude;
    private double longitude;

    private float checkinTime;
    private float securityTime;
    private float passportTime;
    private float rating;

    private boolean isNameTranslated = false;
    private boolean isCityTranslated = false;

    public WidgetAirport(String airportName,
                         String airportNameTranslated,
                         String city,
                         String cityTranslated,
                         String countryFull,
                         String code,
                         String url,
                         String countryCode,
                         String phone,
                         int tipsCount,
                         int reportsCount,
                         double offset,
                         double latitude,
                         double longitude,
                         float checkinTime,
                         float securityTime,
                         float passportTime,
                         float rating,
                         boolean isNameTranslated,
                         boolean isCityTranslated) {
        this.airportName = airportName;
        this.airportNameTranslated = airportNameTranslated;
        this.city = city;
        this.cityTranslated = cityTranslated;
        this.countryFull = countryFull;
        this.code = code;
        this.url = url;
        this.countryCode = countryCode;
        this.phone = phone;
        this.tipsCount = tipsCount;
        this.reportsCount = reportsCount;
        this.offset = offset;
        this.latitude = latitude;
        this.longitude = longitude;
        this.checkinTime = checkinTime;
        this.securityTime = securityTime;
        this.passportTime = passportTime;
        this.rating = rating;
        this.isNameTranslated = isNameTranslated;
        this.isCityTranslated = isCityTranslated;
    }

    public WidgetAirport(Parcel parcel) {
        airportName = parcel.readString();
        airportNameTranslated = parcel.readString();
        city = parcel.readString();
        cityTranslated = parcel.readString();
        countryFull = parcel.readString();
        code = parcel.readString();
        url = parcel.readString();
        countryCode = parcel.readString();
        phone = parcel.readString();

        tipsCount = parcel.readInt();
        reportsCount = parcel.readInt();

        offset = parcel.readDouble();
        latitude = parcel.readDouble();
        longitude = parcel.readDouble();

        checkinTime = parcel.readFloat();
        securityTime = parcel.readFloat();
        passportTime = parcel.readFloat();
        rating = parcel.readFloat();

        boolean[] boolArray = new boolean[2];
        parcel.readBooleanArray(boolArray);
        isNameTranslated = boolArray[0];
        isCityTranslated = boolArray[1];
    }

    public static final Parcelable.Creator<WidgetAirport> CREATOR = new Creator<WidgetAirport>() {
        public WidgetAirport createFromParcel(Parcel source) {
            return new WidgetAirport(source);
        }

        public WidgetAirport[] newArray(int size) {
            return new WidgetAirport[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(airportName);
        parcel.writeString(airportNameTranslated);
        parcel.writeString(city);
        parcel.writeString(cityTranslated);
        parcel.writeString(countryFull);
        parcel.writeString(code);
        parcel.writeString(url);
        parcel.writeString(countryCode);
        parcel.writeString(phone);

        parcel.writeInt(tipsCount);
        parcel.writeInt(reportsCount);

        parcel.writeDouble(offset);
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);

        parcel.writeFloat(checkinTime);
        parcel.writeFloat(securityTime);
        parcel.writeFloat(passportTime);
        parcel.writeFloat(rating);

        parcel.writeBooleanArray(new boolean[]{isNameTranslated, isCityTranslated});
    }

    /**
     * @return The airport name (e.g. "Los Angeles International Airport"). <u>May be null<u/>.
     */
    public String getAirportName() {
        return airportName;
    }

    /**
     * @param airportName to set (e.g. "Los Angeles International Airport").
     */
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    /**
     * @return The airport name (e.g. "Международный аэропорт Лос-Анджелеса")
     * translated to current locale. <u>May be null<u/>.
     */
    public String getAirportNameTranslated() {
        return airportNameTranslated;
    }

    /**
     * @param airportNameTranslated to set (e.g. "Международный аэропорт Лос-Анджелеса").
     */
    public void setAirportNameTranslated(String airportNameTranslated) {
        this.airportNameTranslated = airportNameTranslated;
    }

    /**
     * @return The airport city (e.g. "Los Angeles"). <u>May be null<u/>.
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city to set (e.g. "Los Angeles").
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return The airport city (e.g. "Лос-Анджелес") translated to current locale.
     * <u>May be null<u/>.
     */
    public String getCityTranslated() {
        return cityTranslated;
    }

    /**
     * @param cityTranslated to set (e.g. "Лос-Анджелес").
     */
    public void setCityTranslated(String cityTranslated) {
        this.cityTranslated = cityTranslated;
    }

    /**
     * @return The airport country (e.g. "United States"). <u>May be null<u/>.
     */
    public String getCountryFull() {
        return countryFull;
    }

    /**
     * @param countryFull to set (e.g. "United States").
     */
    public void setCountryFull(String countryFull) {
        this.countryFull = countryFull;
    }

    /**
     * @return The IATA airport code (e.g. "LAX"). <u>May be null<u/>.
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code to set (IATA, e.g. "LAX").
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return The airport website url. <u>May be null<u/>.
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url to set.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The airport country code (e.g. "US"). <u>May be null<u/>.
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode to set (e.g. "US").
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @return The airport phone number. <u>May be null<u/>.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone of the airport to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return The tips count for the airport.
     */
    public int getTipsCount() {
        return tipsCount;
    }

    /**
     * @param tipsCount to set.
     */
    public void setTipsCount(int tipsCount) {
        this.tipsCount = tipsCount;
    }

    /**
     * @return The reports count for the airport.
     */
    public int getReportsCount() {
        return reportsCount;
    }

    /**
     * @param reportsCount to set.
     */
    public void setReportsCount(int reportsCount) {
        this.reportsCount = reportsCount;
    }

    /**
     * @return The offset in <u>hours</u> from UTC for this airport time zone.
     */
    public double getOffset() {
        return offset;
    }

    /**
     * @param offset in <u>hours</u> from UTC for this airport time zone to set.
     */
    public void setOffset(double offset) {
        this.offset = offset;
    }

    /**
     * @return The latitude of the airport.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude of the airport to set.
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return The longitude of the airport.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude of the airport to set.
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return The time spent on checkin in <u>minutes</u>.
     */
    public float getCheckinTime() {
        return checkinTime;
    }

    /**
     * @param checkinTime (time spent on checkin) to set in <u>minutes</u>.
     */
    public void setCheckinTime(float checkinTime) {
        this.checkinTime = checkinTime;
    }

    /**
     * @return The time spent on security control in <u>minutes</u>.
     */
    public float getSecurityTime() {
        return securityTime;
    }

    /**
     * @param securityTime (time spent on security control) to set in <u>minutes</u>.
     */
    public void setSecurityTime(float securityTime) {
        this.securityTime = securityTime;
    }

    /**
     * @return The time spent on passport control in <u>minutes</u>.
     */
    public float getPassportTime() {
        return passportTime;
    }

    /**
     * @param passportTime (time spent on passport control) to set in <u>minutes</u>.
     */
    public void setPassportTime(float passportTime) {
        this.passportTime = passportTime;
    }

    /**
     * @return The rating of the airport (1 to 5).
     */
    public float getRating() {
        return rating;
    }

    /**
     * @param rating in range 1 to 5 to set.
     */
    public void setRating(float rating) {
        this.rating = rating;
    }

    /**
     * @return The flag - is there translated airport name.
     */
    public boolean isNameTranslated() {
        return isNameTranslated;
    }

    /**
     * @param isNameTranslated flag to set.
     */
    public void setIsNameTranslated(boolean isNameTranslated) {
        this.isNameTranslated = isNameTranslated;
    }

    /**
     * @return The flag - is there translated airport city.
     */
    public boolean isCityTranslated() {
        return isCityTranslated;
    }

    /**
     * @param isCityTranslated flag to set.
     */
    public void setIsCityTranslated(boolean isCityTranslated) {
        this.isCityTranslated = isCityTranslated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WidgetAirport that = (WidgetAirport) o;

        if (tipsCount != that.tipsCount) return false;
        if (reportsCount != that.reportsCount) return false;
        if (Double.compare(that.offset, offset) != 0) return false;
        if (Double.compare(that.latitude, latitude) != 0) return false;
        if (Double.compare(that.longitude, longitude) != 0) return false;
        if (Float.compare(that.checkinTime, checkinTime) != 0) return false;
        if (Float.compare(that.securityTime, securityTime) != 0) return false;
        if (Float.compare(that.passportTime, passportTime) != 0) return false;
        if (Float.compare(that.rating, rating) != 0) return false;
        if (isNameTranslated != that.isNameTranslated) return false;
        if (isCityTranslated != that.isCityTranslated) return false;
        if (airportName != null ? !airportName.equals(that.airportName) : that.airportName != null)
            return false;
        if (airportNameTranslated != null ? !airportNameTranslated.equals(that.airportNameTranslated) : that.airportNameTranslated != null)
            return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (cityTranslated != null ? !cityTranslated.equals(that.cityTranslated) : that.cityTranslated != null)
            return false;
        if (countryFull != null ? !countryFull.equals(that.countryFull) : that.countryFull != null)
            return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null)
            return false;
        return !(phone != null ? !phone.equals(that.phone) : that.phone != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = airportName != null ? airportName.hashCode() : 0;
        result = 31 * result + (airportNameTranslated != null ? airportNameTranslated.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (cityTranslated != null ? cityTranslated.hashCode() : 0);
        result = 31 * result + (countryFull != null ? countryFull.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + tipsCount;
        result = 31 * result + reportsCount;
        temp = Double.doubleToLongBits(offset);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (checkinTime != +0.0f ? Float.floatToIntBits(checkinTime) : 0);
        result = 31 * result + (securityTime != +0.0f ? Float.floatToIntBits(securityTime) : 0);
        result = 31 * result + (passportTime != +0.0f ? Float.floatToIntBits(passportTime) : 0);
        result = 31 * result + (rating != +0.0f ? Float.floatToIntBits(rating) : 0);
        result = 31 * result + (isNameTranslated ? 1 : 0);
        result = 31 * result + (isCityTranslated ? 1 : 0);
        return result;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }
}
