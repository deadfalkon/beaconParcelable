package beacon;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

public class PassBeacon implements Parcelable {
    public UUID proximityUUID;
    public int major;
    public int minor;
    public String relevantText;
    public String title;
    public String callbackActionString;


    public PassBeacon() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.proximityUUID.toString());
        dest.writeInt(this.major);
        dest.writeInt(this.minor);
        dest.writeString(this.relevantText);
        dest.writeString(this.title);
        dest.writeString(this.callbackActionString);
    }

    public PassBeacon(Parcel in) {
        this.proximityUUID = UUID.fromString(in.readString());
        this.major = in.readInt();
        this.minor = in.readInt();
        this.relevantText = in.readString();
        this.title = in.readString();
        this.callbackActionString = in.readString();
    }

    public static Creator<PassBeacon> CREATOR = new Creator<PassBeacon>() {
        public PassBeacon createFromParcel(Parcel source) {
            return new PassBeacon(source);
        }

        public PassBeacon[] newArray(int size) {
            return new PassBeacon[size];
        }
    };
}