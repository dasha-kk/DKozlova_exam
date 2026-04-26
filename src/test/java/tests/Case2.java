package tests;

import methods.Methods;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Case2 {
//----------------------Проверка книги------------------------------------------
    @Test
    @DisplayName("Проверить наличие книги на складе")

    void checkBook() {
        Methods.getBookById("http://localhost:8085/books/{id}/stock", "1");
    }

//----------------------Добавление отзыва--------------------------------------

    @Test
    @DisplayName("Добавление комментария")

    void addReview() {

        String newReview = new JSONObject()
                .put("rating", "5")
                .put("comment", "the best book")
                .put("reviewerName", "AAA").toString();

        Methods.addReview("http://localhost:8085/books/{id}/reviews", newReview, "1");
    }
}
