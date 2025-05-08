package TrelloRestAPIsTestcases;

import org.testng.annotations.Test;

public class E2ETestCoordinator {
    BoardTest board = new BoardTest();
    ListTest list = new ListTest();
    CardTest card = new CardTest();
    ChecklistTest checklist = new ChecklistTest();

    @Test(priority = 1)
    public void CreateBoard(){
        board.ShouldBeAbleToCreateABoard();
    }

    @Test(priority = 2)
    public void CreateList(){
        list.ShouldBeAbleToCreateAList();
    }

    @Test(priority = 3)
    public void CreateCard(){
        card.ShouldBeAbleToCreateACard();
    }

    @Test(priority = 4)
    public void UpdateBoard(){
        board.ShouldBeAbleToUpdateABoard();
    }

    @Test(priority = 5)
    public void UpdateList(){
        list.ShouldBeAbleToUpdateAList();
    }

    @Test(priority = 6)
    public void UpdateCard(){
        card.ShouldBeAbleToUpdateACard();
    }

    @Test(priority = 7)
    public void GetBoard(){
        board.ShouldBeAbleToGetABoard();
    }

    @Test(priority = 8)
    public void GetList(){
        list.ShouldBeAbleToGetAList();
    }

    @Test(priority = 9)
    public void GetCard(){
        card.ShouldBeAbleToGetACard();
    }

    @Test(priority = 10)
    public void CreateChecklist(){
        checklist.ShouldBeAbleToCreateAChecklist();
    }

    @Test(priority = 11)
    public void UpdateChecklist(){
        checklist.ShouldBeAbleToUpdateAChecklist();
    }

    @Test(priority = 12)
    public void GetChecklist(){
        checklist.ShouldBeAbleToGetAChecklist();
    }

    @Test(priority = 13)
    public void DeleteChecklist(){
        checklist.ShouldBeAbleToDeleteAChecklist();
    }

    @Test(priority = 14)
    public void DeleteCard(){
        card.ShouldBeAbleToDeleteACard();
    }

    @Test(priority = 15)
    public void DeleteBoard(){
        board.ShouldBeAbleToDeleteABoard();
    }
}
