package com.colltest.colltest1;

/***
 * 电影
 */
public class Movie {

    /***
     * 名称
     */
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Movie(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                '}';

//        return "Movie[title="+title+"]";
    }
}
