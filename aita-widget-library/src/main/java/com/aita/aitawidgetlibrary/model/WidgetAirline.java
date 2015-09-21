package com.aita.aitawidgetlibrary.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

/**
 * The {@code WidgetAirline} is a representation of an airline.
 */
public class WidgetAirline implements Parcelable {

    private String iata;
    private String icao;
    private String name;
    private String nameTranslated;
    private String twitter;
    private String email;
    private String phone;
    private String website;
    private String code;
    private String webCheckin;
    private String mobileCheckin;

    private boolean checkinAvailable;
    private boolean isNameTranslated = false;

    public WidgetAirline(String iata,
                         String icao,
                         String name,
                         String nameTranslated,
                         String twitter,
                         String email,
                         String phone,
                         String website,
                         String code,
                         String webCheckin,
                         String mobileCheckin,
                         boolean checkinAvailable,
                         boolean isNameTranslated) {
        this.iata = iata;
        this.icao = icao;
        this.name = name;
        this.nameTranslated = nameTranslated;
        this.twitter = twitter;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.code = code;
        this.webCheckin = webCheckin;
        this.mobileCheckin = mobileCheckin;
        this.checkinAvailable = checkinAvailable;
        this.isNameTranslated = isNameTranslated;
    }

    public WidgetAirline(Parcel parcel) {
        iata = parcel.readString();
        icao = parcel.readString();
        name = parcel.readString();
        nameTranslated = parcel.readString();
        twitter = parcel.readString();
        email = parcel.readString();
        phone = parcel.readString();
        website = parcel.readString();
        code = parcel.readString();
        webCheckin = parcel.readString();
        mobileCheckin = parcel.readString();

        boolean[] boolArray = new boolean[2];
        parcel.readBooleanArray(boolArray);
        checkinAvailable = boolArray[0];
        isNameTranslated = boolArray[1];
    }

    public static final Parcelable.Creator<WidgetAirline> CREATOR = new Creator<WidgetAirline>() {
        public WidgetAirline createFromParcel(Parcel source) {
            return new WidgetAirline(source);
        }

        public WidgetAirline[] newArray(int size) {
            return new WidgetAirline[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(iata);
        parcel.writeString(icao);
        parcel.writeString(name);
        parcel.writeString(nameTranslated);
        parcel.writeString(twitter);
        parcel.writeString(email);
        parcel.writeString(phone);
        parcel.writeString(website);
        parcel.writeString(code);
        parcel.writeString(webCheckin);
        parcel.writeString(mobileCheckin);

        parcel.writeBooleanArray(new boolean[]{checkinAvailable, isNameTranslated});
    }

    /**
     * @return The IATA airline code (e.g. "VX"). <u>May be null<u/>.
     */
    @Nullable
    public String getIata() {
        return iata;
    }

    /**
     * @param iata code to set (e.g. "VX").
     */
    public void setIata(String iata) {
        this.iata = iata;
    }

    /**
     * @return The ICAO airline code (e.g. "AAL"). <u>May be null<u/>.
     */
    @Nullable
    public String getIcao() {
        return icao;
    }

    /**
     * @param icao code to set (e.g. "AAL").
     */
    public void setIcao(String icao) {
        this.icao = icao;
    }

    /**
     * @return The airline name (e.g. "Virgin America"). <u>May be null<u/>.
     */
    @Nullable
    public String getName() {
        return name;
    }

    /**
     * @param name of the airline to set (e.g. "Virgin America").
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The translated airline name (e.g. "Трансаеро"). <u>May be null<u/>.
     */
    @Nullable
    public String getNameTranslated() {
        return nameTranslated;
    }

    /**
     * @param nameTranslated translated name of the airline to set (e.g. "Трансаеро").
     */
    public void setNameTranslated(String nameTranslated) {
        this.nameTranslated = nameTranslated;
    }

    /**
     * @return The airline twitter login (e.g. "klm"). <u>May be null<u/>.
     */
    @Nullable
    public String getTwitter() {
        return twitter;
    }

    /**
     * @param twitter login of the airline to set (e.g. "klm").
     */
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    /**
     * @return The airline email. <u>May be null<u/>.
     */
    @Nullable
    public String getEmail() {
        return email;
    }

    /**
     * @param email of the airline to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The airline phone number. <u>May be null<u/>.
     */
    @Nullable
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone of the airline to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return The airline website. <u>May be null<u/>.
     */
    @Nullable
    public String getWebsite() {
        return website;
    }

    /**
     * @param website desktop version of airline website url to set.
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @return The airline IATA code (e.g. "VX"). <u>May be null<u/>.
     */
    @Nullable
    public String getCode() {
        return code;
    }

    /**
     * @param code of the airline (IATA) to set.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return The airline desktop checkin url. <u>May be null<u/>.
     */
    @Nullable
    public String getWebCheckin() {
        return webCheckin;
    }

    /**
     * @param webCheckin url of online checkin (desktop version) to set.
     */
    public void setWebCheckin(String webCheckin) {
        this.webCheckin = webCheckin;
    }

    /**
     * @return The airline mobile checkin url. <u>May be null<u/>.
     */
    @Nullable
    public String getMobileCheckin() {
        return mobileCheckin;
    }

    /**
     * @param mobileCheckin url of online checkin (mobile version) to set.
     */
    public void setMobileCheckin(String mobileCheckin) {
        this.mobileCheckin = mobileCheckin;
    }

    /**
     * @return Flag - is there at least one (mobile or web) checkin url.
     */
    public boolean isCheckinAvailable() {
        return checkinAvailable;
    }

    /**
     * @param checkinAvailable flag (is there at least one checkin url) to set.
     */
    public void setCheckinAvailable(boolean checkinAvailable) {
        this.checkinAvailable = checkinAvailable;
    }

    /**
     * @return Flag - is airline name translated.
     */
    public boolean isNameTranslated() {
        return isNameTranslated;
    }

    /**
     * @param isNameTranslated flag (is airline name translated) to set.
     */
    public void setIsNameTranslated(boolean isNameTranslated) {
        this.isNameTranslated = isNameTranslated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WidgetAirline that = (WidgetAirline) o;

        if (checkinAvailable != that.checkinAvailable) return false;
        if (isNameTranslated != that.isNameTranslated) return false;
        if (iata != null ? !iata.equals(that.iata) : that.iata != null) return false;
        if (icao != null ? !icao.equals(that.icao) : that.icao != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (nameTranslated != null ? !nameTranslated.equals(that.nameTranslated) :
                that.nameTranslated != null)
            return false;
        if (twitter != null ? !twitter.equals(that.twitter) : that.twitter != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (website != null ? !website.equals(that.website) : that.website != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (webCheckin != null ? !webCheckin.equals(that.webCheckin) : that.webCheckin != null)
            return false;
        return !(mobileCheckin != null ? !mobileCheckin.equals(that.mobileCheckin) :
                that.mobileCheckin != null);

    }

    @Override
    public int hashCode() {
        int result = iata != null ? iata.hashCode() : 0;
        result = 31 * result + (icao != null ? icao.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nameTranslated != null ? nameTranslated.hashCode() : 0);
        result = 31 * result + (twitter != null ? twitter.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (webCheckin != null ? webCheckin.hashCode() : 0);
        result = 31 * result + (mobileCheckin != null ? mobileCheckin.hashCode() : 0);
        result = 31 * result + (checkinAvailable ? 1 : 0);
        result = 31 * result + (isNameTranslated ? 1 : 0);
        return result;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

}
