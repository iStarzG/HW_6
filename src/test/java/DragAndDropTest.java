import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @BeforeAll
    static void beforeAll (){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
        System.out.println("\n\n### @BeforeAll\n");
    }
    @Test
    void DragAndDrop () {
        open("https://the-internet.herokuapp.com/drag_and_drop"); //Открытие "https://the-internet.herokuapp.com/drag_and_drop"
        $("#column-a").shouldHave(text("A")); //Проверка нахождения прямоугольника А на своем месте
        actions().dragAndDrop($("#column-a"), $("#column-b")).perform(); //Замена местами прямоугольники А и В
        $("#column-a").shouldHave(text("B")); //Проверка нахождения прямоугольника В на месте прямоугольника А
        sleep(4000); //Ожидание 4 секунды
        $("#column-b").dragAndDrop(to($("#column-a"))); //Проверка dragAndDrop на Selenide, замена местами прямоугольники В и А
        $("#column-a").shouldHave(text("A")); //Проверка нахождения прямоугольника А на своем месте

    }
}
