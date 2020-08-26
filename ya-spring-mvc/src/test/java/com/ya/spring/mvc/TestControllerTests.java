package com.ya.spring.mvc;

import com.ya.spring.mvc.service.TestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ya.spring.mvc.conf.MvcConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @Description
 * @Author ROCIA
 * @Date 2020/8/25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class})
@WebAppConfiguration("src/main/webapp")
public class TestControllerTests {

    private MockMvc mvc;

    @Autowired
    private TestService testService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockHttpSession session;

    @Autowired
    private MockHttpServletRequest request;



    //region
//    @Before
    public void setup(){
       this.mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    //endregion

    //region
//    @Test
    public void testNormalController()throws Exception{

        this.mvc.perform(MockMvcRequestBuilders.get("/normal"))
                .andExpect(status().isOk())
                .andExpect(view().name("page"))
                .andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))
                .andExpect(model().attribute("msg",this.testService.saySomething()));
        ;
    }
    //endregion


    //region
//    @Test
    public void testRestController() throws  Exception{
        this.mvc.perform(MockMvcRequestBuilders.get("/testRest"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(this.testService.saySomething()));
    }
    //endregion



}
