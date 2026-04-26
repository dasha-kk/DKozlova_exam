package tests;

import methods.Methods;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Case1 {

    static String id = "";

    @Test
    @DisplayName("Создать новую книгу")
//----------------------Создание новой книги------------------------
    void addBook() {
        String newBook = new JSONObject()
                .put("isbn", "978-3315678900001")
                .put("title", "Dasha Book")
                .put("author", "Me")
                .put("genre", "Fiction")
                .put("year", "2026")
                .put("price", "799")
                .put("stock", "10")
                .put("pages", 200).toString();
        Methods.addBook("http://localhost:8085/books", newBook);
        JSONObject book = Methods.getBooksByISBN2("http://localhost:8085/books/isbn/{isbn}", "978-3315678900001");
        id = book.get("id").toString();

    }

//----------------------Получение книги по ID------------------------
    @Test
    @DisplayName("Получить книги по ID")

    void getBookOnId() {
        Methods.getBookById("http://localhost:8085/books/{id}", id);
    }

//-------------------Обновление цены----------------------------------
    @Test
    @DisplayName("Частично обновить книгу")

    void partialUpdate() {
        String updatedBook = new JSONObject()
                .put("price", "800").toString();

        Methods.partialUpdate("http://localhost:8085/books/{id}", updatedBook, id);
    }

//-----------------Проверка наличия------------------------------------
    @Test
    @DisplayName("Проверить наличие книги на складе")

    void checkBook() {
        Methods.getBookById("http://localhost:8085/books/{id}/stock", id);
    }

//-------------------Удаление книги-------------------------------------
    @Test
    @DisplayName("Удалить книгу")

    void deleteBook() {
        Methods.deleteBook("http://localhost:8085/books/{id}", id);
    }
}

