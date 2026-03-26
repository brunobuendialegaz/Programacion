package org.example.bibliotecaterror.model;

import java.util.List;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

public class Biblioteca {

    @SerializedName("data")
    @Expose
    public List<Libro> libros;


    @Data
    public static class Libro {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("Year")
        @Expose
        public Integer year;
        @SerializedName("Title")
        @Expose
        public String title;
        @SerializedName("handle")
        @Expose
        public String handle;
        @SerializedName("Publisher")
        @Expose
        public String publisher;
        @SerializedName("ISBN")
        @Expose
        public String isbn;
        @SerializedName("Pages")
        @Expose
        public Integer pages;
        @SerializedName("Notes")
        @Expose
        public List<String> notes;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("villains")
        @Expose
        public List<Villain> villains;
    }

    @Data
    public static class Villain {

        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("url")
        @Expose
        public String url;

    }
}


