package tests;

import methods.Methods;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Case3 {
//---------------Получение с фильтром по жанру-------------------------------
    @Test
    @DisplayName("Получить все книги с фильтрацией")

    void getAllBooksByFilter() {
        Map<String, String> filters = new HashMap<>();
        filters.put("genre", "Fiction");
        Methods.getAllBooksByFilter("http://localhost:8085/books", filters);

    }

//---------------Получение книги с пагинацией------------------------------
    @Test
    @DisplayName("Получить все книги с фильтрацией")

    void getAllBooksByFilter2() {
        Map<String, String> filters = new HashMap<>();
        filters.put("pages", "500");
        Methods.getAllBooksByFilter("http://localhost:8085/books", filters);

    }

//---------------Получение книг с фильтром по цене--------------------------
    @Test
    @DisplayName("Получить все книги с фильтрацией")

    void getAllBooksByFilter3() {
        Map<String, String> filters = new HashMap<>();
        filters.put("minPrice", "500");
        filters.put("maxPrice", "1000");
        Methods.getAllBooksByFilter("http://localhost:8085/books", filters);

    }
}
