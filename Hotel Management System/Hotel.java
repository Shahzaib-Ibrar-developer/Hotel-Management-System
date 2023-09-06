import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hotel {
    Scanner sc = new Scanner(System.in);
    HashMap<String, String> details = new HashMap<>();
    int rooms = 10;
    String customerName;
    String Id;
    String mobileNumber;
    int roomPricePerDay = 1500;
    int serviceCharges = 500;
    int perDayFoodCharges = 2000;
    String orderFood;
    int count = 0;
    int bill;
    String inputUser;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public static void display() {
        System.out.println("Hotel Management System");
        System.out.println("1: Room Bookings");
        System.out.println("2: Check Rooms Availability");
        System.out.println("3: All Customers Details ");
        System.out.println("4: Customer detail by Id");
        System.out.println("5: Exit");
    }

    public void roomBookings() {
        System.out.println("Welcome to Hotel");
        System.out.println("Name: ");
        customerName = sc.nextLine();
        System.out.println("Id: ");
        Id = sc.nextLine();
        System.out.println("Number: ");
        mobileNumber = sc.nextLine();

        System.out.println("Please confirm booking room (y/n)");
        inputUser = sc.nextLine();
        System.out.println("Can you take food from Hotel: ");
        orderFood = sc.nextLine();

        details.put(Id, customerName); // Fix: Swap key-value pairs
    }

    public void generateBill() {
        if (inputUser.equals("y")) {
            count++;
            if (orderFood.equals("n")) {
                System.out.println("----Hotel Slip----");
                System.out.println("Your Room Number is: " + count);
                bill = roomPricePerDay + serviceCharges;
                System.out.println("Total bill is: " + bill);

            } else if (orderFood.equals("y")) {
                System.out.println("----Hotel Slip----");
                System.out.println("Your Room Number is: " + count);
                bill = roomPricePerDay + serviceCharges + perDayFoodCharges;
                System.out.println("Total bill is: " + bill);
            } else {
                System.out.println("System is in Default Warning. Re-enter All details ..!");
            }
        } else if (count++ == 10) {
            System.out.println("Room not Available");
        } else {
            System.out.println("Default");
        }
    }

    public void checkRoomAvailability() {
        if (count <= 10) {
            int room = 10 - count;
            System.out.println("Rooms Available = " + room);
        } else {
            System.out.println("Not Available");
        }
    }

    public void savedUserData() {
        if (details.isEmpty()) {
            System.out.println("No Customers yet!!");
        } else {
            for (Map.Entry<String, String>entry : details.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                System.out.println("Id : " + key + ", Name : " + value);
            }
        }
    }

    public void checkDetailById() {
        System.out.println("Enter the ID to search: ");
        String checkingId = sc.nextLine();
        boolean idFound = false;
        for (Map.Entry<String, String> entry : details.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.equals(checkingId)) {
                System.out.println("Id : " + key + ", Name : " + value);
                idFound = true;
                break;
            }
        }
        if (!idFound) {
            System.out.println("Id not Found ...");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();
        while (true) {
            display();
            int key = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            switch (key) {
                case 1:
                    hotel.roomBookings();
                    hotel.generateBill();
                    break;
                case 2:
                    hotel.checkRoomAvailability();
                    break;
                case 3:
                    hotel.savedUserData();
                    break;
                case 4:
                    hotel.checkDetailById();
                    break;
                case 5:
                    System.out.println("Exiting from Program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("System is in default");
                    break;
            }
        }
    }
}
