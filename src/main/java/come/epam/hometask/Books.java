package come.epam.hometask;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

public class Books implements Serializable {
    private Book[] books = new Book[]{
            new Book(101, "Java", "Ivanhoe", "Kiev",
                    2010, 700, 250),
            new Book(102, "PHP", "Ivanhoe", "London",
                    2017, 250, 200),
            new Book(103, "JavaScript", "Ivanov", "New York",
                    2012, 280, 400),
            new Book(104, "C#", "Kolesnik", "Berlin",
                    2013, 450, 500),
            new Book(105, "SQL", "Davidova", "Milan",
                    2019, 300, 700),
            new Book(106, "C++", "Kovalov", "Lviv",
                    2020, 500, 350)};

    public Books(Book[] books) {
    }

    public Books() {
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public void printBooks() {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    public Book[] searchBooks(int number_year) {
        Book[] booksUn = new Book[books.length];
        int i = 0;
        for (Book elem : books) {
            if ((elem.getYear_of_publication() >= number_year)) {
                booksUn[i] = elem;
                i++;
            }
        }
        if (i == 0) {
            System.out.println("Указанного года не найдено");
        }
        return Arrays.copyOf(booksUn, i);
    }

    public Book[] searchAuthor(String author) {
        Book[] booksAuthor = new Book[books.length];
        int j = 0;
        for (Book elem : books) {
            if (elem.getAuthor().equals(author)) {
                booksAuthor[j] = elem;
                j++;
            }
        }
        if (j == 0) {
            System.out.println("Выбранного автора не найдено");
        }
        return Arrays.copyOf(booksAuthor, j);
    }

    public <number_percent> void revaluation(int number_percent) {
        for (Book elem : books) {
            elem.setPrice(elem.getPrice() + (elem.getPrice() * number_percent / 100));
        }
    }

    public void printBooksAfterSorting(Book[] booksAfterSorting) {
        for (int i = 0; i < books.length; i++) {
            System.out.println(booksAfterSorting[i]);
        }
    }

    public void sortByAuthor() {
        Book[] booksAfterSorting = Arrays.copyOf(books, books.length);
        Arrays.sort(booksAfterSorting, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return (o1).getAuthor().compareTo((o2).getAuthor());
            }
        });
        printBooksAfterSorting(booksAfterSorting);
    }

    public void sortByPublishing_House() {
        Book[] booksAfterSorting1 = Arrays.copyOf(books, books.length);
        Arrays.sort(booksAfterSorting1, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPublishing_house().compareTo(o2.getPublishing_house());
            }
        });
        printBooksAfterSorting(booksAfterSorting1);
    }

    public void sortByPrice() {
        Book[] booksAfterSorting3 = Arrays.copyOf(books, books.length);
        Arrays.sort(booksAfterSorting3, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return -1;
                } else if (o1.getPrice() < o1.getPrice()) {
                    return 1;
                } else return 0;
            }
        });
        printBooksAfterSorting(booksAfterSorting3);
    }

    @Override
    public String toString() {
        return Arrays.toString(books);
    }

}

