package com.zm.fx_web_admin;

import com.zm.fx_web_admin.service.RefreItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FxWebAdminApplicationTests {

    @Autowired
    RefreItemService refreItemService;

    @Test
    public void contextLoads() {
        String item = refreItemService.findById("1535254874695");
        System.out.println(item);
    }
}

