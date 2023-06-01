package com.sivalabs.demo.web;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.security.test.context.support.WithMockUser;

import static io.restassured.RestAssured.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UserRestControllerRestAssuredTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void shouldGetAllUsers() {
        given().get("/api/users").then().statusCode(200);
    }

    @Test
    @WithMockUser(username = "admin@gmail.com")
    void shouldCreateUser() {
        given()
            .contentType(ContentType.JSON)
            .body("""
                {
                    "name": "demo",
                    "email": "demo@gmail.com",
                    "password": "demo",
                    "role": "ROLE_USER"
                }
            """)
            .post("/api/users")
            .then()
            .statusCode(201);
    }
}