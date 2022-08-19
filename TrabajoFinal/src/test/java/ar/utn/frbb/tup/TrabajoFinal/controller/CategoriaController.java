package ar.utn.frbb.tup.TrabajoFinal.controller;


import ar.utn.frbb.tup.TrabajoFinal.dto.AltaCategoriaDto;
import ar.utn.frbb.tup.TrabajoFinal.dto.AltaProductoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CategoriaController {

    private static ObjectMapper mapper = new ObjectMapper();



    @Autowired
    private MockMvc productoMvc;

    @Test
    public void crearCategoriaTest() throws Exception {

        AltaCategoriaDto categoriaDto = new AltaCategoriaDto("Televisores", "Televisores");
        productoMvc.perform(MockMvcRequestBuilders.post("/empleado")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(categoriaDto))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());

    }
}
