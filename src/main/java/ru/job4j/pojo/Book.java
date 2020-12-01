package ru.job4j.pojo;

public class Book {
    private String bookName;
    private int pageQuantity;

    public Book(String bookName, int pageQuantity) {
        this.bookName = bookName;
        this.pageQuantity = pageQuantity;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageQuantity() {
        return pageQuantity;
    }

    public void setPageQuantity(int pageQuantity) {
        this.pageQuantity = pageQuantity;
    }
}
