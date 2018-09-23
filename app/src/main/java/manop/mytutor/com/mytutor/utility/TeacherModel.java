package manop.mytutor.com.mytutor.utility;

import android.os.Parcel;
import android.os.Parcelable;

public class TeacherModel implements Parcelable{

    private String displayNameString, idCardString,
            uidString, Gender, Avata, Course;

    public TeacherModel() {
    }

    public TeacherModel(String displayNameString, String idCardString, String uidString, String gender, String avata, String course) {
        this.displayNameString = displayNameString;
        this.idCardString = idCardString;
        this.uidString = uidString;
        Gender = gender;
        Avata = avata;
        Course = course;
    }

    protected TeacherModel(Parcel in) {
        displayNameString = in.readString();
        idCardString = in.readString();
        uidString = in.readString();
        Gender = in.readString();
        Avata = in.readString();
        Course = in.readString();
    }

    public static final Creator<TeacherModel> CREATOR = new Creator<TeacherModel>() {
        @Override
        public TeacherModel createFromParcel(Parcel in) {
            return new TeacherModel(in);
        }

        @Override
        public TeacherModel[] newArray(int size) {
            return new TeacherModel[size];
        }
    };

    public String getDisplayNameString() {
        return displayNameString;
    }

    public void setDisplayNameString(String displayNameString) {
        this.displayNameString = displayNameString;
    }

    public String getIdCardString() {
        return idCardString;
    }

    public void setIdCardString(String idCardString) {
        this.idCardString = idCardString;
    }

    public String getUidString() {
        return uidString;
    }

    public void setUidString(String uidString) {
        this.uidString = uidString;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAvata() {
        return Avata;
    }

    public void setAvata(String avata) {
        Avata = avata;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(displayNameString);
        dest.writeString(idCardString);
        dest.writeString(uidString);
        dest.writeString(Gender);
        dest.writeString(Avata);
        dest.writeString(Course);
    }
}