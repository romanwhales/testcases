package com.eppress.demo.controllers;

import com.eppress.demo.entities.Todo;
import com.eppress.demo.repositories.TodoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;


import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TodoController.class, secure = false)
public class TodoControllerTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TodoRepository todoRepository;

    @Test
    public void testShowAllTodos() throws Exception{
        Todo todo1 = new Todo(1,"Todo1",false);
        Todo todo2 = new Todo(2,"Todo2",true);

        given(this.todoRepository.findAll()).willReturn(Arrays.asList(todo1,
                todo2));
        this.mvc.perform(get("/todolist").accept(MediaType.TEXT_HTML)).andExpect(status().isOk())
                .andExpect(view().name("todos"))
                .andExpect(MockMvcResultMatchers.model().attribute("todos",
                        hasSize(2)));


    }
}
