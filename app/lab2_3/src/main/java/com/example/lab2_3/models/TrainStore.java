package com.example.lab2_3.models;

import java.time.OffsetTime;
import java.util.ArrayList;

public class TrainStore {
    private static ArrayList<Train> trains;

    static {
        trains = new ArrayList<>();
        ArrayList<Seat> seats = new ArrayList<Seat>();
        seats.add(new Seat(SeatType.COMMON_TYPE, 100));
        seats.add(new Seat(SeatType.RESERVED_SEATS, 50));
        seats.add(new Seat(SeatType.COUPE, 60));
        seats.add(new Seat(SeatType.LUXURY, 10));


        trains.add(new Train("Minsk", "434A", OffsetTime.parse("10:30+03:00"), seats));
        trains.add(new Train("Polatsk", "678C-1", OffsetTime.parse("20:30+03:00"), seats));
        trains.add(new Train("Pinsk", "334A", OffsetTime.parse("14:30+03:00"), seats));
        trains.add(new Train("Baranavichy", "435-1", OffsetTime.parse("15:19+03:00"), seats));
        trains.add(new Train("Homjel", "634A", OffsetTime.parse("10:30+03:00"), seats));
        trains.add(new Train("Kraucouka", "21332", OffsetTime.parse("10:30+03:00"), seats));
        trains.add(new Train("Fanipal`", "463", OffsetTime.parse("10:30+03:00"), seats));
        trains.add(new Train("Mahiliou", "234A", OffsetTime.parse("10:30+03:00"), seats));
        trains.add(new Train("Orsha", "234B", OffsetTime.parse("10:30+03:00"), seats));
        trains.add(new Train("Dobrysh", "3322", OffsetTime.parse("10:30+03:00"), seats));
    }

    public ArrayList<Train> getTrains(){
        return trains;
    }

    public Train get(int position){
        return trains.get(position);
    }

    public void remove(int position){
        trains.remove(position);
    }
}
