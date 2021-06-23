package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Issues")
@Owner("dmitry-kostenko")

public class AnnotatedStepsTest {

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 65;

    private WebSteps steps = new WebSteps();

    @Test
    @Story("Отображение Issue")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Github", url = "https://github.com")
    @DisplayName("Тест на проверку отображения Issue по номеру")
    public void checkIssueByNumber() {

        steps.openMainPage(BASE_URL);
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldBeVisibleWithNumber(ISSUE_NUMBER);
        steps.makeScreenshot();

    }

}
