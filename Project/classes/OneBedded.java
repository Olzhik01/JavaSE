package project.classes;

public class OneBedded extends Room {
    private int roomsCapacity;
    private boolean isFamilyRoom;

    @Override
    public String toString() {
        return ""+getRoomNumber();
    }

    public int getRoomsCapacity() {
        return roomsCapacity;
    }

    public void setRoomsCapacity(int roomsCapacity) {
        this.roomsCapacity = roomsCapacity;
    }

    public boolean isFamilyRoom() {
        return isFamilyRoom;
    }

    public void setFamilyRoom(boolean familyRoom) {
        isFamilyRoom = familyRoom;
    }
}
