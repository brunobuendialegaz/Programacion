package org.example.bibliotecaterror.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javafx.collections.ObservableList;
import lombok.Data;

import java.util.List;

@Data
public class Libro {
//region pepito
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("Year")
    @Expose
    private Integer year;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("handle")
    @Expose
    private String handle;
    @SerializedName("Publisher")
    @Expose
    private String publisher;
    @SerializedName("ISBN")
    @Expose
    private String isbn;
    @SerializedName("Pages")
    @Expose
    private Integer pages;
    @SerializedName("Notes")
    @Expose
    private List<String> notes;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("villains")
    @Expose
    private List<Villain> villains;
    //endregion
}
