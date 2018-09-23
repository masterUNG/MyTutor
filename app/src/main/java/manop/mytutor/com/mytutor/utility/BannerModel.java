package manop.mytutor.com.mytutor.utility;

import android.os.Parcel;
import android.os.Parcelable;

public class BannerModel implements Parcelable{
    private String Image;
    private String uidString;

    public BannerModel() {
    }

    public BannerModel(String image, String uidString) {
        Image = image;
        this.uidString = uidString;
    }

    protected BannerModel(Parcel in) {
        Image = in.readString();
        uidString = in.readString();
    }

    public static final Creator<BannerModel> CREATOR = new Creator<BannerModel>() {
        @Override
        public BannerModel createFromParcel(Parcel in) {
            return new BannerModel(in);
        }

        @Override
        public BannerModel[] newArray(int size) {
            return new BannerModel[size];
        }
    };

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getUidString() {
        return uidString;
    }

    public void setUidString(String uidString) {
        this.uidString = uidString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Image);
        dest.writeString(uidString);
    }
}