package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открываем главную страницу {baseUrl}")
    public void openMainPage(String baseUrl) {
        open(baseUrl);
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").val(repository).pressEnter();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Открываем таб Issue в репозитории")
    public void openIssueTab() {
        $(withText("Issues")).click();
    }

    @Step("Проверяем что Issue с номером {number} существует")
    public void shouldBeVisibleWithNumber(int number) {
        $(withText("#" + number)).shouldBe(Condition.visible);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return screenshot(OutputType.BYTES);
    }
}
