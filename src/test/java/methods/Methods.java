package methods;

import io.restassured.http.ContentType;
import org.json.JSONObject;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Methods {
    public static void getAllbooks(String url) {
        String body = given()
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();
        System.out.println(body);
    }

    public static void getAllBooksByFilter(String url, Map<String, String> filters) {

        String body = given()
                .params(filters)
                .when()
                .log().all()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .body()
                .asString();
        System.out.println(body);
    }


    public static void getBookById(String url, String id) {
        String body = given()
                .pathParam("id", id)
                .when()
                .log().all()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .body()
                .asString();
        System.out.println(body);
    }

    public static void getBooksByISBN(String url, String isbn) {
        String body = given()
                .pathParam("isbn", isbn)
                .when()
                .log().all()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .body()
                .asString();
        System.out.println(body);
    }

    public static JSONObject getBooksByISBN2(String url, String isbn) {
        String body = given()
                .pathParam("isbn", isbn)
                .when()
                .log().all()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .body()
                .asString();
        JSONObject book = new JSONObject(body);
        System.out.println(body);
        return book;
    }

    public static void addBook(String url, String newBook) {

        String body = given()
                .when()
                .header("X-API-Key", "bookstore-2026-secret")
                .contentType(ContentType.JSON)
                .body(newBook)
                .log().all()
                .post(url)
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .body()
                .asString();
        System.out.println(body);
//        JSONObject resp = new JSONObject(body);
//        String id = resp.get("id").toString();
//        return id;
    }

    public static void foolUpdate(String url, String updatedBook, String id) {
        String body = given()
                .pathParam("id", id)
                .when()
                .header("X-API-Key", "bookstore-2026-secret")
                .contentType(ContentType.JSON)
                .body(updatedBook)
                .log().all()
                .put(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .body()
                .asString();

        System.out.println(body);
    }

    public static void partialUpdate(String url, String updatedBook, String id) {
        String body = given()
                .pathParam("id", id)
                .when()
                .header("X-API-Key", "bookstore-2026-secret")
                .contentType(ContentType.JSON)
                .body(updatedBook)
                .log().all()
                .patch(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .body()
                .asString();

        System.out.println(body);
    }

    public static void deleteBook(String url, String id) {
        String body = given()
                .pathParam("id", id)
                .when()
                .header("X-API-Key", "bookstore-2026-secret")
                .log().all()
                .delete(url)
                .then()
                .log().all()
                .statusCode(204)
                .extract()
                .asString();
    }

    public static void addReview(String url, String newReview, String id) {
        String body = given()
                .pathParam("id", id)
                .when()
                .header("X-API-Key", "bookstore-2026-secret")
                .contentType(ContentType.JSON)
                .body(newReview)
                .log().all()
                .post(url)
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .body()
                .asString();
        System.out.println(body);

    }

    public static void getReviews(String url, String id) {
        String body = given()
                .pathParam("id", id)
                .when()
                .log().all()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .body()
                .asString();
        System.out.println(body);
    }
}
//DELETE /books/{id}
