package com.example.lab2_3.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.time.OffsetTime;
import java.util.ArrayList;

public class Train implements Parcelable {
    private String destination;
    private String trainNumber;
    private OffsetTime departureTime;

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    private ArrayList<Seat> seats;

    public Train(String destination, String trainNumber, OffsetTime departureTime, ArrayList<Seat> seats) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.seats = seats;
    }

    protected Train(Parcel in) {
        destination = in.readString();
        trainNumber = in.readString();
        departureTime = OffsetTime.parse(in.readString());
        seats = in.createTypedArrayList(Seat.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(destination);
        dest.writeString(trainNumber);
        dest.writeString(departureTime.toString());
        dest.writeTypedList(seats);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Train> CREATOR = new Creator<Train>() {
        @Override
        public Train createFromParcel(Parcel in) {
            return new Train(in);
        }

        @Override
        public Train[] newArray(int size) {
            return new Train[size];
        }
    };

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public OffsetTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(OffsetTime departureTime) {
        this.departureTime = departureTime;
    }

    @NonNull
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Train{");
        sb.append("destination='").append(destination).append('\'');
        sb.append(", trainNumber='").append(trainNumber).append('\'');
        sb.append(", deaprtureTime=").append(departureTime);
        sb.append(", seats=").append(seats);
        sb.append('}');
        return sb.toString();
    }
}
