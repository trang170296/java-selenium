package todo;

import com.beust.ah.A;
import common.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ToDoMVCPage;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import static common.Browser.launch;

public class CreateNewTodoTest extends BaseTest {
    /**
     * 1. Open browser
     * 2. Navigate to  https://todomvc.com/examples/vanillajs/
     * 3. Input "task1"
     * 4. Press Enter
     * 5. "task1" iss displayed in todo list
     */

    ToDoMVCPage toDoMVCPage = new ToDoMVCPage();

    @Parameters({"browser"})
    @BeforeClass
    void openBrowser(String browser) {
        launch(browser);
        toDoMVCPage.open();}

    @Test
        void createNewTodoSuccessfully(){
        toDoMVCPage.selectAllTaskView();
        int numberOfTaskOld = toDoMVCPage.getItemsLeft();
        toDoMVCPage.createNewTask("task 1");
        int numberOfTaskNew = toDoMVCPage.getItemsLeft();

        Assert.assertEquals(numberOfTaskOld+1,numberOfTaskNew);
        Assert.assertEquals(toDoMVCPage.getLatestTaskName(),"task 1");
    }

    @Test
    void abledMarkCompleteATask(){
        toDoMVCPage.createNewTask("task 2");
        toDoMVCPage.markComplete("task 2");
        toDoMVCPage.selectCompletedTaskView();

        Assert.assertEquals(toDoMVCPage.getLatestTaskName(),"task 2");
    }

    @Test
    void deleteATaskSuccessfully() {
        toDoMVCPage.selectAllTaskView();
        toDoMVCPage.createNewTask("task 3");
        int beforeDelete = toDoMVCPage.getItemsLeft();
        toDoMVCPage.delete("task 3");
        int afterDelete = toDoMVCPage.getItemsLeft();

        Assert.assertEquals(beforeDelete - afterDelete, 1);
    }

    @Test
    void updateTaskNameSuccessfully(){
        toDoMVCPage.createNewTask("task 4");
        toDoMVCPage.updateName("task 4", "task 5");
        Assert.assertEquals(toDoMVCPage.getLatestTaskName(),"task 5");
    }
}


