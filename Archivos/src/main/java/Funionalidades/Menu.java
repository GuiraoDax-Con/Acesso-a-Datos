package Funionalidades;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Menu {
    Pedir pd = new Pedir();
    Archivo archivo = new Archivo();
    Directorio directorio = new Directorio();

    public void menu() {
        while (true) {
            System.out.println(" --- Menu ---" +
                    "\n1. Mostrar directorios de la carpeta actual" +
                    "\n2. Cambiar a un subdirectorio o al directorio padre" +
                    "\n3. Crear un nuevo archivo de texto en la carpeta actual" +
                    "\n4. Mostrar el contenido de un archivo de texto de la carpeta actual" +
                    "\n5. Añadir una nueva línea de texto a un archivo de la carpeta actual" +
                    "\n6. Eliminar un archivo de la carpeta actual" +
                    "\n7. Salir");
            System.out.print("Seleccione una opción: ");
            int option = pd.numInt();

            switch (option) {
                case 1:
                    directorio.mostrarDirectorios();
                    break;
                case 2:
                    directorio.cambiarDirectorio();
                    break;
                case 3:
                    archivo.crearArchivo();
                    break;
                case 4:
                    archivo.mostrarArchivoEspecifico();
                    break;
                case 5:
                    System.out.print("Ingrese la línea a añadir: ");
                    String linea = pd.textoNoVacio();
                    archivo.anyadirLinea(linea);
                    break;
                case 6:
                    archivo.eliminarArchivo();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
