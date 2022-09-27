package homework15;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class Steps {

    @Step("Открываем URL: {url}")
    public void openUrl(String url) {
        open(url);
    }

    @Step("Переходим в репозиторий \"{repoName}\"")
    public void openRepoWithName(String repoName) {
        $(linkText(repoName)).click();
    }

    @Step("Переходим в пулреквесты")
    public void goToPullRequests() {
        $("#pull-requests-tab").click();
    }

    @Step("Ищем пулреквест \"{name}\"")
    public void searchForPullRequestWithName(String name) {
        $(withText(name)).should(exist);
    }
}
