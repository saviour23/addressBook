package com.saviour23.book.addressbook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saviour23.book.addressbook.model.Contact;
import com.saviour23.book.addressbook.util.TestDataPopulation;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AddressBookintegrationTest {
    @Autowired
    private MockMvc mvc;


    @Test
    public void testGetAllContact() throws Exception {
        mvc.perform(get("/addressbook/all/").
                contentType(MediaType.APPLICATION_JSON_VALUE)).
                andExpect(status().isOk()).andReturn();
    }


    @Test
    public void testGetContact() throws Exception {
        mvc.perform(get("/addressbook/Friends").
                contentType(MediaType.APPLICATION_JSON_VALUE)).
                andExpect(status().isOk()).andExpect(content().string(Matchers.containsString("Neeraj")));
    }


    @Test
    public void testAddContact() throws Exception {
        String payload="{\"name\":{\"firstName\":\"Neeraj0\",\"lastName\":\"Negi\"},\"telephone\":[{\"mobileNumber\":\"0123456789\"},{\"mobileNumber\":\"3456723456\"}]}";
        mvc.perform(post("/addressbook/Friends").
                contentType(MediaType.APPLICATION_JSON_VALUE).content(payload)).
                andExpect(status().isOk()).andReturn();
        mvc.perform(get("/addressbook/Friends").
                contentType(MediaType.APPLICATION_JSON_VALUE)).
                andExpect(status().isOk()).andExpect(content().string(Matchers.containsString("Neeraj0")));
    }

}
