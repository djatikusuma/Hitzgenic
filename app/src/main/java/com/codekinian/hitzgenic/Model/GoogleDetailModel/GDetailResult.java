
package com.codekinian.hitzgenic.Model.GoogleDetailModel;

import android.database.Cursor;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import static android.provider.BaseColumns._ID;
import static com.codekinian.hitzgenic.Helpers.DatabaseContract.getColumnDouble;
import static com.codekinian.hitzgenic.Helpers.DatabaseContract.getColumnInt;
import static com.codekinian.hitzgenic.Helpers.DatabaseContract.getColumnString;
import static com.codekinian.hitzgenic.Helpers.FavoriteColumn.COLUMN_LATITUDE;
import static com.codekinian.hitzgenic.Helpers.FavoriteColumn.COLUMN_LONGITUDE;
import static com.codekinian.hitzgenic.Helpers.FavoriteColumn.COLUMN_PHOTO;
import static com.codekinian.hitzgenic.Helpers.FavoriteColumn.COLUMN_PLACE_ID;
import static com.codekinian.hitzgenic.Helpers.FavoriteColumn.COLUMN_RATING;
import static com.codekinian.hitzgenic.Helpers.FavoriteColumn.COLUMN_TITLE;
import static com.codekinian.hitzgenic.Helpers.FavoriteColumn.COLUMN_VICINITY;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class GDetailResult {

    @SerializedName("address_components")
    private List<AddressComponent> mAddressComponents;
    @SerializedName("adr_address")
    private String mAdrAddress;
    @SerializedName("formatted_address")
    private String mFormattedAddress;
    @SerializedName("formatted_phone_number")
    private String mFormattedPhoneNumber;
    @SerializedName("geometry")
    private Geometry mGeometry;
    @SerializedName("icon")
    private String mIcon;
    @SerializedName("id")
    private String mId;
    @SerializedName("international_phone_number")
    private String mInternationalPhoneNumber;
    @SerializedName("name")
    private String mName;
    @SerializedName("opening_hours")
    private OpeningHours mOpeningHours;
    @SerializedName("photos")
    private List<Photo> mPhotos;
    @SerializedName("place_id")
    private String mPlaceId;
    @SerializedName("plus_code")
    private PlusCode mPlusCode;
    @SerializedName("rating")
    private Double mRating;
    @SerializedName("reference")
    private String mReference;
    @SerializedName("reviews")
    private List<Review> mReviews;
    @SerializedName("scope")
    private String mScope;
    @SerializedName("types")
    private List<String> mTypes;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("utc_offset")
    private Long mUtcOffset;
    @SerializedName("vicinity")
    private String mVicinity;
    @SerializedName("website")
    private String mWebsite;

    public GDetailResult(Cursor list) {
        this.mPlaceId = getColumnString(list, COLUMN_PLACE_ID);
        this.mName = getColumnString(list, COLUMN_TITLE);
        this.mVicinity = getColumnString(list, COLUMN_VICINITY);
        this.mRating = getColumnDouble(list, COLUMN_RATING);
    }

    public List<AddressComponent> getAddressComponents() {
        return mAddressComponents;
    }

    public void setAddressComponents(List<AddressComponent> addressComponents) {
        mAddressComponents = addressComponents;
    }

    public String getAdrAddress() {
        return mAdrAddress;
    }

    public void setAdrAddress(String adrAddress) {
        mAdrAddress = adrAddress;
    }

    public String getFormattedAddress() {
        return mFormattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        mFormattedAddress = formattedAddress;
    }

    public String getFormattedPhoneNumber() {
        return mFormattedPhoneNumber;
    }

    public void setFormattedPhoneNumber(String formattedPhoneNumber) {
        mFormattedPhoneNumber = formattedPhoneNumber;
    }

    public Geometry getGeometry() {
        return mGeometry;
    }

    public void setGeometry(Geometry geometry) {
        mGeometry = geometry;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getInternationalPhoneNumber() {
        return mInternationalPhoneNumber;
    }

    public void setInternationalPhoneNumber(String internationalPhoneNumber) {
        mInternationalPhoneNumber = internationalPhoneNumber;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public OpeningHours getOpeningHours() {
        return mOpeningHours;
    }

    public void setOpeningHours(OpeningHours openingHours) {
        mOpeningHours = openingHours;
    }

    public List<Photo> getPhotos() {
        return mPhotos;
    }

    public void setPhotos(List<Photo> photos) {
        mPhotos = photos;
    }

    public String getPlaceId() {
        return mPlaceId;
    }

    public void setPlaceId(String placeId) {
        mPlaceId = placeId;
    }

    public PlusCode getPlusCode() {
        return mPlusCode;
    }

    public void setPlusCode(PlusCode plusCode) {
        mPlusCode = plusCode;
    }

    public Double getRating() {
        return mRating;
    }

    public void setRating(Double rating) {
        mRating = rating;
    }

    public String getReference() {
        return mReference;
    }

    public void setReference(String reference) {
        mReference = reference;
    }

    public List<Review> getReviews() {
        return mReviews;
    }

    public void setReviews(List<Review> reviews) {
        mReviews = reviews;
    }

    public String getScope() {
        return mScope;
    }

    public void setScope(String scope) {
        mScope = scope;
    }

    public List<String> getTypes() {
        return mTypes;
    }

    public void setTypes(List<String> types) {
        mTypes = types;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public Long getUtcOffset() {
        return mUtcOffset;
    }

    public void setUtcOffset(Long utcOffset) {
        mUtcOffset = utcOffset;
    }

    public String getVicinity() {
        return mVicinity;
    }

    public void setVicinity(String vicinity) {
        mVicinity = vicinity;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public void setWebsite(String website) {
        mWebsite = website;
    }

}
