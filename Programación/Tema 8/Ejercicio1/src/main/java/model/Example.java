package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import model.Valid;

import javax.xml.transform.Result;
import java.util.List;

@Data
public class Example {

    @SerializedName("response_code")
    @Expose
    public Integer responseCode;
    @SerializedName("results")
    @Expose
    public List<Result> results;

    @Data
    public static class Result {

        @SerializedName("type")
        @Expose
        public String type;
        @SerializedName("difficulty")
        @Expose
        public String difficulty;
        @SerializedName("category")
        @Expose
        public String category;
        @SerializedName("question")
        @Expose
        public String question;
        @SerializedName("correct_answer")
        @Expose
        public String correctAnswer;
        @SerializedName("incorrect_answers")
        @Expose
        public List<String> incorrectAnswers;

    }
}