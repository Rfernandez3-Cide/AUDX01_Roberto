package audx01;

// TODO ESTO POR AHORA ES UNA PRUEBA
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        EscribeFicheroTexto(); // Llamamos al método para escribir el archivo
    }

    public static void EscribeFicheroTexto() {
        // Crea el String con la cadena XML
        String texto = "Prueba";
        // Guarda en nombre el nombre del archivo que se creará.
        String nombre = "prueba.xml";
        try {
            // Se crea un nuevo objeto FileWriter
            FileWriter fichero = new FileWriter(nombre);
            // Se escribe el fichero
            fichero.write(texto + "\r\n");
            // Se cierra el fichero
            fichero.close();
        } catch (IOException ex) {
            System.out.println("Error al acceder al fichero");
        }
    }
}