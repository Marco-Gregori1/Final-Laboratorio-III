package ar.utn.frbb.tup.TrabajoFinal.controller;


import ar.utn.frbb.tup.TrabajoFinal.business.CategoriaBusinessImplementation;
import ar.utn.frbb.tup.TrabajoFinal.dto.AltaCategoriaDto;
import ar.utn.frbb.tup.TrabajoFinal.model.Categoria;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
public class CategoriaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoriaBusinessImplementation catBusiness;

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void crearCategoriaTest_OK() throws Exception {

        AltaCategoriaDto categoriaDto = new AltaCategoriaDto("Televisores", "Televisores");


        mockMvc.perform(MockMvcRequestBuilders.post("/categoria/creator")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(categoriaDto))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
                .andDo(print());


    }
}
