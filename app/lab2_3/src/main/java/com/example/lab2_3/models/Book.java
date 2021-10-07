package com.example.lab2_3.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.time.OffsetTime;
import java.util.ArrayList;

public class Book implements Parcelable {
    private String id;
    private String name;
    private String author;
    private String publisher;
    private String publishYear;
    private int pages;
    private int price;
    private String boundType;

    protected Book(Parcel in) {
        id = in.readString();
        name = in.readString();
        author = in.readString();
        publisher = in.readString();
        publishYear = in.readString();
        pages = in.readInt();
        price = in.readInt();
        boundType = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(author);
        dest.writeString(publisher);
        dest.writeString(publishYear);
        dest.writeInt(pages);
        dest.writeInt(price);
        dest.writeString(boundType);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @NonNull
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", publisher='").append(publisher).append('\'');
        sb.append(", publishYear='").append(publishYear).append('\'');
        sb.append(", pages=").append(pages);
        sb.append(", price=").append(price);
        sb.append(", boundType='").append(boundType).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBoundType() {
        return boundType;
    }

    public void setBoundType(String boundType) {
        this.boundType = boundType;
    }

    public Book(String id, String name, String author, String publisher, String publishYear, int pages, int price, String boundType) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.pages = pages;
        this.price = price;
        this.boundType = boundType;
    }
}
