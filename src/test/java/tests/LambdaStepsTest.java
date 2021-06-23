package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 65;

    @Test
    public void checkIssueByNumber() {

        step("Открываем главную страницу", (s) -> {
            s.parameter("Url", BASE_URL);
            open(BASE_URL);
        });

        step("Ищем репозиторий", (s) -> {
            s.parameter("repository", REPOSITORY);
            $(".header-search-input").val(REPOSITORY).pressEnter();
        });

        step("Переходим в репозиторий", (s) -> {
            $(By.linkText(REPOSITORY)).click();
        });

        step("Открываем таб Issue в репозитории", (s) -> {
            $(withText("Issues")).click();
        });

        step("Проверяем что Issue с номером " + ISSUE_NUMBER + " существует", (s) -> {
            s.parameter("number", ISSUE_NUMBER);
            $(withText("#" + ISSUE_NUMBER)).shouldBe(Condition.visible);
        });

    }
}
