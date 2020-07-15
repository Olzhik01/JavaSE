package project.classes;

public class Room {
    private int roomNumber;
    private String roomType;
    private int price;
    private String description;
    private boolean isAvailable;
    private boolean hasCleaningServices;
    private boolean hasFreeWifi;
    private boolean petsAllowed;

    @Override
    public String toString() {
        return Integer.toString(roomNumber);
    }

    public String getRoomDetails(){
        String details = "Room Number: "+roomNumber+"\n";
        details+="Room Type: "+roomType+"\n";
        details+="Price: "+price+"KZT\n";
        details+="Description: "+description+"\n";
        if(getIsAvailable()) {
            details += "Available: Yes\n";
        }
        if(!getIsAvailable()){
            details += "Available: No\n";
        }
        if(isHasCleaningServices()){
            details += "Has Cleaning Services: Yes\n";
        }
        if(!isHasCleaningServices()){
            details += "Has Cleaning Services: No\n";
        }
        if(isHasFreeWifi()){
            details += "Has Free Wifi: Yes\n";
        }
        if(isPetsAllowed()){
            details += "Pets Allowed: Yes\n";
        }
        if(!isHasFreeWifi()){
            details += "Has Free Wifi: No\n";
        }
            if(!isPetsAllowed()){
            details += "Pets Allowed: No\n";
        }
        System.out.println(details);
        return details;

    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isHasCleaningServices() {
        return hasCleaningServices;
    }

    public void setHasCleaningServices(boolean hasCleaningServices) {
        this.hasCleaningServices = hasCleaningServices;
    }

    public boolean isHasFreeWifi() {
        return hasFreeWifi;
    }

    public void setHasFreeWifi(boolean hasFreeWifi) {
        this.hasFreeWifi = hasFreeWifi;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }
}
