package com.saviour23.book.addressbook;

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
        mvc.perform(get("/addressbook/contacts/").
                contentType(MediaType.APPLICATION_JSON_VALUE)).
                andExpect(status().isOk()).andReturn();
    }


    @Test
    public void testGetContact() throws Exception {
        mvc.perform(get("/addressbook/contacts/1").
                contentType(MediaType.APPLICATION_JSON_VALUE)).
                andExpect(status().isOk()).andExpect(content().string(Matchers.containsString("Neeraj")));
    }

    @Test
    public void testDeleteContact() throws Exception {
        mvc.perform(delete("/addressbook/contacts/2").
                contentType(MediaType.APPLICATION_JSON_VALUE)).
                andExpect(status().isOk()).andReturn();
    }


    @Test
    public void testAddContact() throws Exception {

        String content = "{\"id\":\"3\",\"name\":\"Neeraj\",\"telephone\":[{\"mobileNumber\":\"12345\"},{\"mobileNumber\":\"123\"}]}";
        mvc.perform(post("/addressbook/contacts/addcontact").
                contentType(MediaType.APPLICATION_JSON_VALUE).content(content)).
                andExpect(status().isOk()).andReturn();
        mvc.perform(get("/addressbook/contacts/3").
                contentType(MediaType.APPLICATION_JSON_VALUE)).
                andExpect(status().isOk()).andExpect(content().string(Matchers.containsString("Neeraj")));
    }

}
