package ar.utn.frbb.tup.TrabajoFinal;

import ar.utn.frbb.tup.TrabajoFinal.model.Categoria;
import ar.utn.frbb.tup.TrabajoFinal.model.Producto;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CategoriaSortingTest {

        // Para comparar numeros de punto flotante (Precios)
        private static final double DELTA = 1e-15;

        public Categoria catTest1(){
                Categoria catTest = new Categoria();
                catTest.agregarProducto(new Producto("Xiaomi",15000));
                catTest.agregarProducto(new Producto("Samsung",20000));
                catTest.agregarProducto(new Producto("LG",17000));
                return catTest;
        }


        @Test
        void sortMayorMenor() {
                Categoria catToCompare = new Categoria();
                catToCompare.agregarProducto(new Producto("Samsung",20000));
                catToCompare.agregarProducto(new Producto("LG",17000));
                catToCompare.agregarProducto(new Producto("Xiaomi",15000));

                Categoria catToSort = catTest1();
                catToSort.OrdenarPrecioDescendente();

                Assert.assertEquals(catToSort.getListaProductos().get(0).getPrecioLista(), catToCompare.getListaProductos().get(0).getPrecioLista(),DELTA);
                Assert.assertEquals(catToSort.getListaProductos().get(1).getPrecioLista(), catToCompare.getListaProductos().get(1).getPrecioLista(),DELTA);
                Assert.assertEquals(catToSort.getListaProductos().get(2).getPrecioLista(), catToCompare.getListaProductos().get(2).getPrecioLista(),DELTA);
        }

        @Test
        void sortMenorMayor() {
                Categoria catToCompare = new Categoria();
                catToCompare.agregarProducto(new Producto("Xiaomi",15000));
                catToCompare.agregarProducto(new Producto("LG",17000));
                catToCompare.agregarProducto(new Producto("Samsung",20000));

                Categoria catToSort = catTest1();
                catToSort.OrdenarPrecioAscendente();

                Assert.assertEquals(catToSort.getListaProductos().get(0).getPrecioLista(), catToCompare.getListaProductos().get(0).getPrecioLista(),DELTA);
                Assert.assertEquals(catToSort.getListaProductos().get(1).getPrecioLista(), catToCompare.getListaProductos().get(1).getPrecioLista(),DELTA);
                Assert.assertEquals(catToSort.getListaProductos().get(2).getPrecioLista(), catToCompare.getListaProductos().get(2).getPrecioLista(),DELTA);

        }

        @Test
        void sortPorMarca() {
                Categoria catToCompare = new Categoria();
                catToCompare.agregarProducto(new Producto("Samsung",20000));
                catToCompare.agregarProducto(new Producto("Samsung",10000));

                Categoria catToSort = catTest1();
                catToSort.agregarProducto(new Producto("Samsung",20000));
                catToSort.OrdenarPorMarca("Samsung");
                catToSort.listarProductos();

        }

        @Test
        void sortPorRangoPrecio() {
                Categoria catToCompare = new Categoria();
                catToCompare.agregarProducto(new Producto("Xiaomi",15000));
                catToCompare.agregarProducto(new Producto("LG",17000));

                Categoria catToSort = catTest1();
                catToSort.OrdenarPorRango(14500,18000);

                Assert.assertEquals(catToSort.getListaProductos().get(0).getMarca(),catToCompare.getListaProductos().get(0).getMarca());
                Assert.assertEquals(catToSort.getListaProductos().get(1).getMarca(),catToCompare.getListaProductos().get(1).getMarca());



        }



}
