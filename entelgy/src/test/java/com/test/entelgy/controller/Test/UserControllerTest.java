package com.test.entelgy.controller.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.test.entelgy.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @MockBean
    private UserController userController;

    @Autowired
    private MockMvc mvc;

    @Test
    void actionTaskTranformValorFondo() throws Exception {
        mvc.perform(
                post("/user")
        ).andExpect(status().isOk());

        verify(userController, times(1)).findUsers();
    }

}
