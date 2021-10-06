package com.memer.memeapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Meme {
    @Id
    private String id;
    private String meme_name;
    private String meme_url;
    private DateTime date_time;

    public Meme(String meme_name, String meme_url, DateTime date_time) {
        this.meme_name = meme_name;
        this.meme_url = meme_url;
        this.date_time = date_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMeme_name() {
        return meme_name;
    }

    public void setMeme_name(String meme_name) {
        this.meme_name = meme_name;
    }

    public String getMeme_url() {
        return meme_url;
    }

    public void setMeme_url(String meme_url) {
        this.meme_url = meme_url;
    }

    public DateTime getDate_time() {
        return date_time;
    }

    public void setDate_time(DateTime date_time) {
        this.date_time = date_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meme meme = (Meme) o;
        return Objects.equals(id, meme.id) && Objects.equals(meme_name, meme.meme_name) && Objects.equals(meme_url, meme.meme_url) && Objects.equals(date_time, meme.date_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, meme_name, meme_url, date_time);
    }

    @Override
    public String toString() {
        return "Meme{" +
                "id='" + id + '\'' +
                ", meme_name='" + meme_name + '\'' +
                ", meme_url='" + meme_url + '\'' +
                ", date_time=" + date_time +
                '}';
    }
}
