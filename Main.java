import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choose;
        boolean exit = false;
        BookManager bookManagerManager = new BookManager();
        List<Book> bl = new ArrayList<>();
        while (true) {
            try {
                Menu();
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        bookManagerManager.printBooks(bookManagerManager.getBooks());
                        break;
                    case 2:
                        bookManagerManager.getInfo();
                        break;
                    case 3:
                        System.out.print("Enter book id: ");
                        Scanner sc = new Scanner(System.in);
                        int id1 = sc.nextInt();
                        Book bookmana = bookManagerManager.getBookById(id1);
                        if (bookmana == null) {
                            break;
                        } else {
                            System.out.print("Enter book name: ");
                            Scanner sc1 = new Scanner(System.in);
                            String newname = sc1.nextLine();
                            bookmana.setName(newname);
                            System.out.print("Enter book price: ");
                            Scanner sc2 = new Scanner(System.in);
                            double newprice = sc2.nextDouble();
                            double n = 0;
                            bookmana.setPrice(Math.max(newprice, n));
                            System.out.println("Updated successfully.");
                            break;
                        }
//                    id = bookManagerManager.getBookById();
//                    bookManagerManager.getBookById(id);
//                    break;
                    case 4: //delete a book
                        System.out.print("Enter book id: ");
                        Scanner sc3 = new Scanner(System.in);
                        int idv = sc3.nextInt();
                        Book bb = bookManagerManager.getBookById(idv);
                        if (bb != null) {
                            bookManagerManager.remove(bb);
                            System.out.println("Deleted successfully!");
                        }
                        break;
                    case 5: // Sort by name
                        System.out.print("Enter keyword: ");
                        Scanner sc7 = new Scanner(System.in);
                        String keyword = sc7.nextLine().toLowerCase();
                        bookManagerManager.searchByName(keyword);
                        break;
                    case 6: // sort by price
                        bookManagerManager.sortDescByPrice();
                        break;
                    case 0: //save and exit
                        System.out.println("Saving to file...");
                        System.out.println("Bye!");
                        bookManagerManager.saveToFile();
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option!");
                        break;
                }
                if (exit) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid!");
            }
            // show menu
        }
    }

    public static void Menu() {
        System.out.println("-----------------------------------");
        System.out.println("1. list all books");
        System.out.println("2. add a new book");
        System.out.println("3. edit book");
        System.out.println("4. delete a book");
        System.out.println("5. search books by name");
        System.out.println("6. sort books descending by price");
        System.out.println(" ");
        System.out.println("0. save & exit");
        System.out.println("-----------------------------------");
        System.out.print("Your option: ");
    }
}
