import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestQueues {
    private Queue<String> prueba = null;

    @Before
    public void SetUp() throws ColaLlenaException { //Común a todos los @Test's que se hagan

        prueba = new QueueImpl<String>(5);
        prueba.push("Hola");
        prueba.push("Que");
        prueba.push("Tal");
    }

    @Test
    public void pushTest() throws ColaLlenaException {
        Assert.assertEquals(3, prueba.size()); //Comprobamos que los 3 push se han hecho correctamente

        //Comprobamos que al hacer un nuevo push sigue funcionando
        prueba.push("Te");
        Assert.assertEquals(4, prueba.size());
    }

    @Test
    public void popTest() throws ColaVaciaException {
        Assert.assertEquals("Hola", prueba.pop());
        Assert.assertEquals(2, prueba.size());
    }

    @Test(expected = ColaLlenaException.class)
    public void colallenaTest() throws ColaLlenaException{
        Assert.assertEquals(3, prueba.size()); //Comprobamos que los 3 push se han hecho correctamente

        //Comprobamos que al introducir más de 5 objetos la cola desborda
        prueba.push("Te");
        prueba.push("Va");
        Assert.assertEquals(5, prueba.size());
        prueba.push("Bien");
    }
}
