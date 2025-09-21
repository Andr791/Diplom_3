package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.TestDataRegister;
import pojo.TestDataLogin;

import static constante.Const.*;
import static constante.Const.RUKA_LOGIN;
import static io.restassured.RestAssured.given;

public class StepsApi {

    @Step("Создание пользователя")
    public static Response userCreate(String email, String password, String name) {
        TestDataRegister register = new TestDataRegister(email, password, name);
        return given()
                .baseUri(BASE_URI)
                .header("Content-type", "application/json")
                .and()
                .body(register)
                .when()
                .post(RUKA_REGISTER);
    }

    @Step("Залогиниться пользователем")
    public static Response login(String email, String password) {
        TestDataLogin testDataLogin = new TestDataLogin(email, password);
        return given()
                .baseUri(BASE_URI)
                .header("Content-type", "application/json")
                .and()
                .body(testDataLogin)
                .when()
                .post(RUKA_LOGIN);
    }
    @Step("Удаление пользователя")
    public static void deleteUser(String authorization) {
                given()
                        .baseUri(BASE_URI)
                        .header("Authorization", authorization)
                        .delete(RUKA_USER);

    }

}
