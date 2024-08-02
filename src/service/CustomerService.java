
package service;

import model.Customer;
import java.util.List;
import java.util.Scanner;

public class CustomerService {

    public static void printCustomer(List<Customer> customers) {
        if (customers.isEmpty()) {
            System.out.println("Sizda hali mijozlar mavjud emas!");
        } else {
            System.out.println("------------------ Mijozlar ro'yxati ------------------");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
            System.out.println("-------------------------------------------------------");
        }
    }

    public static Customer getCustomerById(List<Customer> customers, int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
    public static void addDebt(List<Customer> customers, Scanner inNum) {
        System.out.println("Mijozni id sini kriting: ");
        int id = inNum.nextInt();
        Customer customer = CustomerService.getCustomerById(customers, id);
        if (customer != null) {
            System.out.println(" Mijo'zni qarzdorligini kriting: ");
            double debt = inNum.nextDouble() + inNum.nextDouble();
            customer.setDebt(debt);

        }
        System.out.println(" Bajarildi");
    }
}