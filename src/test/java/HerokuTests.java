import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HerokuTests {

    SelenideElement columnA = $("#column-a");
    SelenideElement columnB = $("#column-b");

    @BeforeAll
    static void beforeAll(){
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void moveActionsTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().clickAndHold(columnA).moveToElement(columnB).release().perform();
        columnA.shouldHave(text("B"));
        columnB.shouldHave(text("A"));
    }

    @Test
    void dragAndDropTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        columnA.shouldHave(text("A"));
        columnB.shouldHave(text("B"));
        columnA.dragAndDrop(DragAndDropOptions.to(columnB));
        columnA.shouldHave(text("B"));
        columnB.shouldHave(text("A"));
    }
}