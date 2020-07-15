package project.classes;

import java.util.ArrayList;

public class App {
    private static ArrayList<Room> roomsList = new ArrayList<>();
    private static ArrayList<Reservation> reservationsList = new ArrayList<>();
    private static ArrayList<Visitor> visitorsList = new ArrayList<>();
    private static ArrayList<History> historyList = new ArrayList<>();

    public static void addRoom(Room room){
        roomsList.add(room);
    }

    public static ArrayList<Room> getRoomsList(){
        return roomsList;
    }

    public static void addReservation(Reservation reservation){
        reservationsList.add(reservation);
    }

    public static ArrayList<Reservation> getReservationsList(){
        return reservationsList;
    }

    public static void addVisitor(Visitor visitor){
        visitorsList.add(visitor);
    }

    public static ArrayList<Visitor> getVisitorsList(){
        return visitorsList;
    }

    public static void addHistory(History history){
        historyList.add(history);
    }
    public static ArrayList<History> getHistoryList(){
        return historyList;
    }

    public static void deleteFromReservationList(Reservation r){
        reservationsList.remove(r);
    }





}
