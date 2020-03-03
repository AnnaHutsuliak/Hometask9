package come.epam.hometask;

import org.junit.Assert;
import org.junit.Test;

public class VerifyBooks {
    Books books;

    @Test
    public void testPrintBooks() {
        Book[] books = {
                new Book(101, "Java", "Ivanhoe", "Kiev", 2010, 700, 250),
                new Book(102, "PHP", "Ivanhoe", "London", 2017, 250, 200),
                new Book(103, "JavaScript", "Ivanov", "New York", 2012, 280, 400),
                new Book(104, "C#", "Kolesnik", "Berlin", 2013, 450, 500),
                new Book(105, "SQL", "Davidova", "Milan", 2019, 300, 700),
                new Book(106, "C++", "Kovalov", "Lviv", 2020, 500, 350)};
        this.books = new Books(books);

    }

    @Test
    public void checkPriceAfterSorting() {
        testPrintBooks();
        books.sortByPrice();
        Book[] bookNew = books.getBooks();
        Assert.assertEquals(250, bookNew[0].getPrice());
        Assert.assertEquals(200, bookNew[1].getPrice());
        Assert.assertEquals(400, bookNew[2].getPrice());
        Assert.assertEquals(500, bookNew[3].getPrice());
        Assert.assertEquals(700, bookNew[4].getPrice());
        Assert.assertEquals(350, bookNew[5].getPrice());
    }

    @Test
    public void checkPublishing_HouseAfterSorting() {
        testPrintBooks();
        books.sortByPublishing_House();
        Book[] bookNew = books.getBooks();
        Assert.assertEquals("Kiev", bookNew[0].getPublishing_house());
        Assert.assertEquals("London", bookNew[1].getPublishing_house());
        Assert.assertEquals("New York", bookNew[2].getPublishing_house());
        Assert.assertEquals("Berlin", bookNew[3].getPublishing_house());
        Assert.assertEquals("Milan", bookNew[4].getPublishing_house());
        Assert.assertEquals("Lviv", bookNew[5].getPublishing_house());
    }

    @Test
    public void checkAuthorAfterSorting() {
        testPrintBooks();
        books.sortByAuthor();
        Book[] bookNew = books.getBooks();
        Assert.assertEquals("Ivanhoe", bookNew[0].getAuthor());
        Assert.assertEquals("Ivanhoe", bookNew[1].getAuthor());
        Assert.assertEquals("Ivanov", bookNew[2].getAuthor());
        Assert.assertEquals("Kolesnik", bookNew[3].getAuthor());
        Assert.assertEquals("Davidova", bookNew[4].getAuthor());
        Assert.assertEquals("Ivanhoe", bookNew[5].getAuthor());
    }

    @Test
    public void checkInvalidPriceAfterSorting() {
        testPrintBooks();
        books.sortByPrice();
        Book[] bookNew = books.getBooks();
        Assert.assertEquals(20, bookNew[0].getPrice());
        Assert.assertEquals(20, bookNew[1].getPrice());
        Assert.assertEquals(40, bookNew[2].getPrice());
        Assert.assertEquals(50, bookNew[3].getPrice());
        Assert.assertEquals(70, bookNew[4].getPrice());
        Assert.assertEquals(30, bookNew[5].getPrice());
    }

}
