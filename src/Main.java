import model.Customer;
import service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner inTxt = new Scanner(System.in);
    static Scanner inNum = new Scanner(System.in);
    static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("------------------ MIJOZLAR RO'YXATLOVCHI DASTURGA XUSH KELIBSIZ ----------------");
        while (true) {
            System.out.print(
                    "1. Mijozlar ro'yxati\n" +
                            "2. Mijoz qo'shish\n" +
                            "3. Mijozni o'chirish\n" +
                            "4. Mijozni ishonchliligini tasdiqlash\n" +
                            "5. Mijozga qarzdorlik qo'shish\n" +
                            "6. Mijozdan qarzdorlik o'chirish\n" +
                            "7. Qarzdor mijozlarni topish\n" +
                            "8. Ishonchli mijozlarni topish\n" +
                            "9. Dasturdan chiqish\n" +
                            "-----kiritish---------> "
            );
            int choice = inNum.nextInt();
            switch (choice) {
                case 1:
                    // Mijozlar ro'yxati
                    CustomerService.printCustomer(customers);
                    break;
                case 2:

                    System.out.print("Yangi mijozni ism familiyasini kiriitng : ");
                    String fullName = inTxt.nextLine();

                    System.out.print("Yangi mijozni raqamini kiriting +998 : ");
                    String phoneNumber = inTxt.nextLine();

                    System.out.print("Yangi mijozni qarzini kiriting : ");
                    double debt = inNum.nextDouble();

                    System.out.print("Bu mijoz ishonchlimi ? y/n :");
                    boolean identified = false;
                    String choiceCus = inTxt.nextLine();

                    if (choiceCus.equals("y")) {
                        identified = true;
                    }

                    Customer newCustomer = new Customer(fullName, phoneNumber, debt, identified);
                    customers.add(newCustomer);
                    System.out.println("Mijoz muvaffaqiyatli bazaga qo'shildi !");
                    break;
                case 3:
                    // Mijozni o'chirish
                    CustomerService.printCustomer(customers);
                    System.out.print("O'chirish uchun mijoz ID'sini kiriting: ");
                    int entreID = inNum.nextInt();
                    Customer foundCustomer = CustomerService.getCustomerById(customers, entreID);
                    if (foundCustomer != null) {
                        customers.remove(foundCustomer);
                        System.out.println("Mijoz muvaffaqiyatli o'chirildi !");
                    } else {
                        System.out.println("Bunday ID bilan mijoz topilmadi.");
                    }
                    break;
                case 4:

                    CustomerService.printCustomer(customers);
                    System.out.print("Mijoz ID'sini kiriting: ");
                    int customerId = inNum.nextInt();
                    Customer customer = CustomerService.getCustomerById(customers, customerId);
                    if (customer != null) {
                        System.out.println("Mijozning ishonchliligini tasdiqlaysizmi? y/n: ");
                        String confirmChoice = inTxt.nextLine();
                        if (confirmChoice.equalsIgnoreCase("y")) {
                            customer.setIdentified(true);
                            System.out.println("Mijoz ishonchli hisoblanadi!");
                        } else {
                            System.out.println("Mijoz ishonchli hisoblanmaydi!");
                        }
                    } else {
                        System.out.println("Bunday ID bilan mijoz topilmadi.");
                    }
                    break;
                case 5:

                    System.out.println("Bu funksiya hali yopilmagan.");
                    break;
                case 6:

                    System.out.println("Bu funksiya hali yopilmagan.");
                    break;
                case 7:

                    System.out.println("Bu funksiya hali yopilmagan.");
                    break;
                case 8:

                    System.out.println("Bu funksiya hali yopilmagan.");
                    break;
                case 9:

                    System.out.println("Dastur o'z ishini tugatdi");
                    return;
                default:
                    System.out.println("Noto'g'ri tanlov, iltimos qaytadan kiriting.");
                    break;
            }
        }
    }
}