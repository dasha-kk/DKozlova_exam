package tests;

import methods.Methods;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class Tests {

// -----------------Получение книг с фильтрацией----------------------------------------
    @Test
    @DisplayName("Получить все книги с фильтрацией")

    void getAllBooksByFilter() {
        Map<String, String> filters = new HashMap<>();
        filters.put("minPrice", "500");
        filters.put("maxPrice", "1000");
        Methods.getAllBooksByFilter("http://localhost:8085/books", filters);

    }


//-----------------Получение книги по ID------------------------------------------
//    @Test
//    @DisplayName("Получить книги по ID")
//
//    void getBookOnId() {
//        Methods.getBookById("http://localhost:8085/books/{id}", "86");
//    }

//-------------------Получение книги по ISBN------------------------------
    @Test
    @DisplayName("Получить книгу по ISBN")

    void getBookByISBN() {
        Methods.getBooksByISBN("http://localhost:8085/books/isbn/{isbn}", "978-TEST-1777101606423");
    }


//-------------------Создание новой книги------------------------------------
//    @Test
//    @DisplayName("Создать новую книгу")
//
//    void addBook() {
//        String newBook = new JSONObject()
//                .put("isbn", "978-2311567899")
//                .put("title", "Dasha Book")
//                .put("author", "Me")
//                .put("genre", "Fiction")
//                .put("year", "2026")
//                .put("price", "799")
//                .put("stock", "10")
//                .put("pages", 200).toString();
//        Methods.addBook("http://localhost:8085/books", newBook);
//    }


//---------------------Полное обновление книги-----------------------------------
//    @Test
//    @DisplayName("Полностью обновить книгу")
//
//    void foolUpdate() {
//        String updatedBook = new JSONObject()
//                .put("isbn", "978-1234567899")
//                .put("title", "New Book")
//                .put("author", "Me")
//                .put("genre", "Fiction")
//                .put("year", "2026")
//                .put("price", "799")
//                .put("stock", "10")
//                .put("pages", 200).toString();
//
//        Methods.foolUpdate("http://localhost:8085/books/{id}", updatedBook, "86");
//    }


//----------------Частичное обновление книги--------------------------------------------
    @Test
    @DisplayName("Частично обновить книгу")

    void partialUpdate() {
        String updatedBook = new JSONObject()
                .put("title", "New Book")
                .put("author", "Me")
                .put("genre", "Fiction")
                .put("year", "2027")
                .put("price", "800").toString();

        Methods.partialUpdate("http://localhost:8085/books/{id}", updatedBook, "86");
    }


//---------------------Удаление книги---------------------------------------------------
    @Test
    @DisplayName("Удалить книгу")

    void deleteBook() {
        Methods.deleteBook("http://localhost:8085/books/{id}", "86");
    }


//--------------------Проверка наличия книги на складе-------------------------------
    @Test
    @DisplayName("Проверить наличие книги на складе")

    void checkBook() {
        Methods.getBookById("http://localhost:8085/books/{id}/stock", "86");
    }


//-------------------Добавление комментария-------------------------------------
    @Test
    @DisplayName("Добавление комментария")

    void addReview() {

        String newReview = new JSONObject()
                .put("rating", "5")
                .put("comment", "the best book")
                .put("reviewerName", "AAA").toString();

        Methods.addReview("http://localhost:8085/books/{id}/reviews", newReview, "9");
    }

//---------------------Получение отзывов на книгу----------------------------
    @Test
    @DisplayName("Получить отзывы на книгу")

    void getReviews() {
        Methods.getReviews("http://localhost:8085/books/{id}/reviews", "9");
    }
}
