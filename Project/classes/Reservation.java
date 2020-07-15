package project.classes;

import javafx.scene.control.Button;

import java.util.Date;

public class Reservation {
    private int reservationNumber;
    private Room room;
    private Visitor visitor;
    private Date checkIn;
    private Date checkOut;
    private boolean hasArrived;
    private boolean hasLeaved;
    private boolean paymentStatus;
    private String email;
    private String phone;
    private Button edit = new Button("Edit");
    private Button delete = new Button("Delete");




    @Override
    public String toString() {
        return reservationNumber+" "+visitor.getSurname()+" "+visitor.getName()+" "+checkIn+" "+checkOut+" ";
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public boolean isHasArrived() {
        return hasArrived;
    }

    public void setHasArrived(boolean hasArrived) {
        this.hasArrived = hasArrived;
    }

    public boolean isHasLeaved() {
        return hasLeaved;
    }

    public void setHasLeaved(boolean hasLeaved) {
        this.hasLeaved = hasLeaved;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }




    public String getEmail() {
        return visitor.getEmail();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return visitor.getPhone();
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

}
