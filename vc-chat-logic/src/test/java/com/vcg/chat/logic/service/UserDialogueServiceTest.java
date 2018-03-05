package com.vcg.chat.logic.service;

import com.vcg.chat.logic.VcChatLogicApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest(classes = VcChatLogicApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback
public class UserDialogueServiceTest {

    @Autowired
    private UserDialogueService userDialogueService;

    @Test
    public void selectByPrimaryKeyTest() {
//        Long id = null;
//        userDialogueService.selectByPrimaryKey(id);
    }

    @Test
    public void selectByExampleTest() {
//        UserDialogueExample q= new UserDialogueExample();
//        userDialogueService.selectByExample(q);
    }

    @Test
    public void insertTest() {
//        UserDialogue t= new UserDialogue();
//        userDialogueService.insert(t);
    }

    @Test
    public void insertSelectiveTest() {
//        UserDialogue t= new UserDialogue();
//        userDialogueService.insertSelective(t);
    }

    @Test
    public void updateByPrimaryKeySelectiveTest() {
//        UserDialogue t = new UserDialogue();
//        userDialogueService.updateByPrimaryKeySelective(t);
    }

    @Test
    public void updateByExampleSelectiveTest() {
//        UserDialogue t =new  UserDialogue();
//        UserDialogueExample q =new UserDialogueExample();
//        userDialogueService.updateByExampleSelective(t, q);
    }

    @Test
    public void updateByExampleTest() {
//      UserDialogue t =new  UserDialogue();
//      UserDialogueExample q =new UserDialogueExample();
//        userDialogueService.updateByExample(t, q);
    }

    @Test
    public void updateByPrimaryKeyTest() {
//        UserDialogue t = new UserDialogue();
//        userDialogueService.updateByPrimaryKey(t);
    }

    @Test
    public void countByExampleTest() {
//        UserDialogueExample q= new UserDialogueExample();
//        userDialogueService.countByExample(q);
    }

    @Test
    public void deleteByPrimaryKeyTest() {
//        Long id = null;
//        userDialogueService.deleteByPrimaryKey(id);
    }


    @Test
    public void deleteByExampleTest() {
//        UserDialogueExample q = new UserDialogueExample();
//        userDialogueService.deleteByExample(q);
    }


}
