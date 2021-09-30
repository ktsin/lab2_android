package com.example.lab2_3.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Seat implements Parcelable {
    private SeatType seatType;
    private int count;

    protected Seat(Parcel in) {
        count = in.readInt();
        seatType = SeatType.valueOf(in.readString());
    }

    public static final Creator<Seat> CREATOR = new Creator<Seat>() {
        @Override
        public Seat createFromParcel(Parcel in) {
            return new Seat(in);
        }

        @Override
        public Seat[] newArray(int size) {
            return new Seat[size];
        }
    };

    @NonNull
    @Override
    public String toString() {
        return String.format("%s;%d;", seatType.getName(), count);
    }

    public Seat(SeatType seatType, int count) {
        this.seatType = seatType;
        this.count = count;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count < 0)
            throw new RuntimeException(String.format("%d must be >= 0", count));
        this.count = count;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(count);
        parcel.writeString(seatType.name());
    }
}
