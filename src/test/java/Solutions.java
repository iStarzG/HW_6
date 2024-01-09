import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Solutions {

    @BeforeAll
    static void beforeAll (){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
        System.out.println("\n\n### @BeforeAll\n");
    }

    @Test
    void SolutionsHoverTest () {
        open("https://github.com"); //Открытие гита
        $$(".HeaderMenu-item").get(1).shouldHave(text("Solutions")).hover(); //Наведение мыши на кнопку "Solutions"
        $("a[href='/enterprise']").click(); //Нажатие на раздел "Enterprise"
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform.")); //Проверка открытия нужной страницы
    }
}

