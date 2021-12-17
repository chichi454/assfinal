import java.io.*;
import java.util.*;

public class BookManager {
    // attribute books
    int id;
    String name;
    double price;
    Scanner scanner;
    static ArrayList<Book> bookss = new ArrayList<>();
    public Object keyword;

    public BookManager() {
        loadFromFile();
    }

    public ArrayList<Book> getBooks() {
        return bookss;
    }

    /**
     * update this.books by reading books from file books.txt
     */
    public void loadFromFile() {
        System.out.println("Loading books...");
//        Read file "books.txt"
        try {
            File booklist = new File("books.txt");
            scanner = new Scanner(booklist);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            System.out.println("An error occurred.");
        }
//        scanner.close();

        //split
        while (scanner.hasNextLine()) {
            String li = scanner.nextLine();
            if (li.isEmpty()) continue;
            int id = Integer.parseInt(li.substring(0, 5).trim());
            double price = Double.parseDouble(li.substring(51).trim());
            String name = li.substring(6, 51);
            bookss.add(new Book(id, name, price));
        }
    }

    /**
     * print books (one/line) in required format
     *
     * @param books
     */
    public void printBooks(ArrayList<Book> books) {
        if (bookss.isEmpty()) {
            System.out.println("(empty)");
        } else {
            System.out.printf("%-5s %-45s %-10s", "ID", "Name", "Price");
            System.out.println();
            for (int i = 0; i < books.size(); i++) {
                int id4 = books.get(i).getId();
                String name4 = books.get(i).getName();
                double price4 = books.get(i).getPrice();
                System.out.format("%5d %-45s %10.2f \n", id4, name4, price4);
            }
        }
    }

    /**
     * if book.id is not duplicated, add book to this.books
     * return whether added or not
     */
    public boolean add(Book book) {
//        int id = (books.size() > 0) ? (books.size() + 1) : 1;
//        System.out.println(id);
//        String name;
//        Double price;
//        Book newbook = new Book(id, name, price);
//        books.add(newbook);
        int id2 = book.id;
        if (id2 > 0) {
            for (int i = 0; i < bookss.size(); i++) {
                if (id2 == bookss.get(i).getId()) {
                    System.out.println("Duplicated ID!");
                    return false;
                }
            }
            if (true) {
                bookss.add(book);
                System.out.println("Added successfully.");
            }
        } else {
            System.out.println("Invalid ID! Please input a positive ID.");
        }
        return false;
    }

    public void getInfo() {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        System.out.print("Enter book id: ");
        id = scanner1.nextInt();
        if (id < 0) {
            System.out.println("Invalid ID! Please input a positive ID.");
        } else {
            System.out.print("Enter book name: ");
            name = scanner2.nextLine();
            System.out.print("Enter book price: ");
            price = scanner3.nextDouble();
            Book book = new Book(id, name, price);
            add(book);
        }
    }
    /**
     * return book specified by id, null if not found
     */
    public Book getBookById(int id) {
        for (Book i : bookss) {
            if (i.id == id) {
                return i;
            }
        }
        System.out.println("Invalid ID!");

        return null;
    }

    /*
      remove book from this.books
     */
    public void remove(Book book) {
        // TODO: your code here
//        Scanner sc3 = new Scanner(System.in);
//        int idv = sc3.nextInt();
//        System.out.println("Enter book id: ");
        Book books = null;
//        getBookById(idv);
        int size = bookss.size();
        for (int i = 0; i < size; i++) {
            if (bookss.get(i).getId() == id) {
                books = bookss.get(i);
                break;
            }
        }
        if (bookss != null) {
            bookss.remove(book);
        } else {
            System.out.println("Invalid ID!");
        }
    }
    /*
     * update this.books to be sorted by price from high -> low
     */

    public void sortDescByPrice() {
//        // TODO: your code here
        boolean hbs;
        double[] book = new double[bookss.size()];
        //hbs means has been sorted
        // One by one move boundary of unsorted sub array (Bubble Sort)
        hbs = true;
        while (hbs) {
            hbs = false;
            for (int i = 0; i < bookss.size() - 1; i++) {
                // Find the minimum element in unsorted array
//                int min = i;
//                for (int j = i + 1; j < book.length; j++)
//                    if (book[i] < book[min]) {
//                        min = j;
//                    }
                if (bookss.get(i).price < bookss.get(i + 1).price) {
                    hbs = true;
                    Book temparature = bookss.get(i);
                    bookss.set(i, bookss.get(i + 1));
                    bookss.set(i + 1, temparature);
                }
            }
        }
        // Swap the found minimum element with the first
        // element
        if (getBooks().isEmpty()) {
            System.out.println("(empty)");
        } else {
            System.out.println("After sorting:");
            System.out.format("%-5s %-45s %-10s\n", "ID", "Name", "Price");
            for (int i = 0; i< bookss.size(); i++) {
                System.out.println(bookss.get(i));
            }
        }
    }

    //         Prints the array that is available in list
    //        public void printArray ( double[] book){
    //Driver code to test


//            hbs = true;
//            for (int j = book.length - 1; j > 1; j--) {
//                // Swap the found minimum element with the first
//                if (book[j] < book[j - 1]) {
//                    double temp = book[j - 1];
//                    book[j - 1] = book[j];
//                    book[j] = temp;
//                    hbs = false;
//                }
//                if (hbs)
//                    System.out.println("After sorting");
//                printBooks(bookss);
//                break;
//            }
//        }

    /*
      return all books having name contains keyword (case in-sensitive)
     */
    public List<Book> searchByName(String keyword) {
        //Get keyword from user
        ArrayList<Book> matches = new ArrayList<>();

        for (int i = 0; i < bookss.size(); i++) {
            if (bookss.get(i).name.toLowerCase().contains(keyword.toLowerCase())) {
                matches.add(bookss.get(i));
            }
        }
        if (matches.isEmpty()) {
            System.out.println("(empty)");
        } else if (!matches.isEmpty()){
            System.out.printf("%-5s %-45s %-10s\n", "ID", "Name", "Price");
            for (int j = 0; j < matches.size(); j++) {
                System.out.println(matches.get(j));
            }
        }

//    *//**
//     * write this.books to file books.txt in required format
//     *//*

        return null;
    }

    /* use outputstream + printwriter to save file
     */
    public void saveToFile() {
        // TODO: your code here //para

        try {
            FileOutputStream file = new FileOutputStream("books.txt");

            PrintWriter pfw = new PrintWriter(new OutputStreamWriter(file));
            for (int b= 0; b < bookss.size(); b++) {
                pfw.write(bookss.get(b).toString() + "\n");
            }
            pfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/* Todo: người dùng nhập chữ trong khi nhập option ( done )
todo: khi người dùng thêm sách hc edit sách, người dùng nhập âm => giá bằng 0 ( dùng if/ Math.max ) (done)
todo: khi nhập chữ trong id => hiện invalid (done)
todo: khi nhập id <= 0 => invalid id (done )
todo: chỉnh saveToFile (done)
 */