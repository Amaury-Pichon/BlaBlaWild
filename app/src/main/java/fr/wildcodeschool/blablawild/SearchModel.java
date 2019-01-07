package fr.wildcodeschool.blablawild;

import android.os.Parcel;
import android.os.Parcelable;

public class SearchModel implements Parcelable {

    private String departure;
    private String destination;
    private String date;

    public SearchModel(String pDeparture, String pDestination, String pDate){
        departure = pDeparture;
        destination = pDestination;
        date = pDate;
    }

    protected SearchModel(Parcel in) {
        departure = in.readString();
        destination = in.readString();
        date = in.readString();
    }

    public static final Creator<SearchModel> CREATOR = new Creator<SearchModel>() {
        @Override
        public SearchModel createFromParcel(Parcel in) {
            return new SearchModel(in);
        }

        @Override
        public SearchModel[] newArray(int size) {
            return new SearchModel[size];
        }
    };

    public String getDeparture(){
        return departure;
    }

    public String getDestination(){
        return destination;
    }

    public String getDate(){
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(departure);
        dest.writeString(destination);
        dest.writeString(date);
    }
}
