package bookSorter;


import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> booksSortedName = new TreeSet<>();
        booksSortedName.add(new Book("Mai ve Siyah",322,"Halit Ziya",1897));
        booksSortedName.add(new Book("Dönüşüm",80,"Kafka",1915));
        booksSortedName.add(new Book("Calıkuşu",123,"Resat Nuri",1940));
        booksSortedName.add(new Book("1984",288,"George Orwell",1949));
        booksSortedName.add(new Book("Suç ve Ceza",256,"Fyodor Dostoyevski",1866));

        TreeSet<Book> booksSortedPageNumber= new TreeSet<>(Comparator.comparingInt(Book::getNumberOfPages));
        booksSortedPageNumber.addAll(booksSortedName);
        System.out.println("----------List of books sorted by name----------");
        System.out.println("------------------------------------------------");
        for (Book book: booksSortedName
             ) {
            System.out.println(book.getBookName());
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("----------List of books sorted by number of pages----------");
        System.out.println("-----------------------------------------------------------");
        for (Book book: booksSortedPageNumber
        ) {
            System.out.println(book.getBookName()+" page number: "+book.getNumberOfPages());
        }
    }
}
