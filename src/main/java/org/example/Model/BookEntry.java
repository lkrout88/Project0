package org.example.Model;

public class BookEntry {

    private String title;
    private String author;
    private int rating;



    public BookEntry(String title,String author,int rating) {
        this.title = title;
        this.author = author;
        this.rating = rating;

    }
//  get and set Title
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    // get and set Author
    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }


 // get and set Rating
    public int getRating(){
        return rating;
    }

    public void setRating(int rating){
        this.rating = rating;
    }


    //need toString
  // @Override

    @Override
    public String toString() {
        return "BookEntry{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", rating=" + rating +
                '}';
    }



    }

