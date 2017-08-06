package com.ttstudios.kalah;

import com.ttstudios.kalah.persistence.model.KalahGame;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static io.restassured.RestAssured.preemptive;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class }, webEnvironment = WebEnvironment.DEFINED_PORT)
public class GamePlayLiveTest {

    @Before
    public void setUp() {
        RestAssured.authentication = preemptive().basic("john", "123");
    }

    private static final String API_ROOT = "http://localhost:8081/api/kalah-games";
    private static final String API_ROUTE = "api/kalah-games/";

    @Test
    public void whenGetAllGames_thenOK() {
        final Response response = RestAssured.get(API_ROOT);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void whenGetGamesByTitle_thenOK() {
        final KalahGame game = createRandomKalahGame();
        createGameAsUri(game);

        final Response response = RestAssured.get(API_ROOT + "/title/" + game.getTitle());
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertTrue(response.as(List.class)
            .size() > 0);
    }

    @Test
    public void whenGetCreatedGameById_thenOK() {
        final KalahGame game = createRandomKalahGame();
        final String location = createGameAsUri(game);

        final Response response = RestAssured.get(location);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(game.getTitle(), response.jsonPath()
            .get("title"));
    }

    @Test
    public void whenGetNotExistGameById_thenNotFound() {
        final Response response = RestAssured.get(API_ROOT + "/" + randomNumeric(4));
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }

    // POST
    @Test
    public void whenCreateNewGame_thenCreated() {
        final KalahGame game = createRandomKalahGame();

        final Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(game)
            .post(API_ROOT);
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }

    @Test
    public void whenInvalidGame_thenError() {
        final KalahGame game = createRandomKalahGame();
        game.setTitle(null);

        final Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(game)
            .post(API_ROOT);
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
    }

    @Test
    public void whenUpdateCreatedGame_thenUpdated() {
        final KalahGame game = createRandomKalahGame();
        final String location = createGameAsUri(game);
        String newId = location.split(API_ROUTE)[1];
        game.setId(newId);
        game.setTitle("newTitle");
        Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(game)
            .put(location);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        response = RestAssured.get(location);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals("newTitle", response.jsonPath()
            .get("title"));

    }

    @Test
    public void whenDeleteCreatedGame_thenOk() {
        final KalahGame game = createRandomKalahGame();
        final String location = createGameAsUri(game);

        Response response = RestAssured.delete(location);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        response = RestAssured.get(location);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }

    // ===============================

    private KalahGame createRandomKalahGame() {
        final KalahGame game = new KalahGame();
        game.setTitle(randomAlphabetic(10));
        game.setPlayer1(randomAlphabetic(15));
        game.setPlayer2(randomAlphabetic(15));
        return game;
    }

    private String createGameAsUri(KalahGame game) {
        final Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(game)
            .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath()
            .get("id");
    }

}