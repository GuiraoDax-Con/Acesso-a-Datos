package Funionalidades;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private File currentDirectory = new File(".");

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
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    showDirectories();
                    break;
                case 2:
                    changeDirectory();
                    break;
                case 3:
                    createNewFile();
                    break;
                case 4:
                    showFileContent();
                    break;
                case 5:
                    addLineToFile();
                    break;
                case 6:
                    deleteFile();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void showDirectories() {
        File[] files = currentDirectory.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No se pudo listar los archivos.");
        }
    }

    private void changeDirectory() {
        System.out.print("Ingrese el nombre del subdirectorio o '..' para el directorio padre: ");
        String dirName = scanner.nextLine();
        File newDir = new File(currentDirectory, dirName);
        if (newDir.exists() && newDir.isDirectory()) {
            currentDirectory = newDir;
            System.out.println("Directorio cambiado a: " + currentDirectory.getAbsolutePath());
        } else {
            System.out.println("Directorio no válido.");
        }
    }

    private void createNewFile() {
        System.out.print("Ingrese el nombre del nuevo archivo: ");
        String fileName = scanner.nextLine();
        File newFile = new File(currentDirectory, fileName);
        try {
            if (newFile.createNewFile()) {
                System.out.println("Archivo creado: " + newFile.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo.");
            e.printStackTrace();
        }
    }

    private void showFileContent() {
        System.out.print("Ingrese el nombre del archivo: ");
        String fileName = scanner.nextLine();
        File file = new File(currentDirectory, fileName);
        if (file.exists() && file.isFile()) {
            try {
                String content = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
                System.out.println("Contenido del archivo:\n" + content);
            } catch (IOException e) {
                System.out.println("Ocurrió un error al leer el archivo.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Archivo no encontrado.");
        }
    }

    private void addLineToFile() {
        System.out.print("Ingrese el nombre del archivo: ");
        String fileName = scanner.nextLine();
        File file = new File(currentDirectory, fileName);
        if (file.exists() && file.isFile()) {
            System.out.print("Ingrese la línea de texto a añadir: ");
            String line = scanner.nextLine();
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(line + System.lineSeparator());
                System.out.println("Línea añadida al archivo.");
            } catch (IOException e) {
                System.out.println("Ocurrió un error al escribir en el archivo.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Archivo no encontrado.");
        }
    }

    private void deleteFile() {
        System.out.print("Ingrese el nombre del archivo a eliminar: ");
        String fileName = scanner.nextLine();
        File file = new File(currentDirectory, fileName);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("Archivo eliminado.");
            } else {
                System.out.println("No se pudo eliminar el archivo.");
            }
        } else {
            System.out.println("Archivo no encontrado.");
        }
	}
}
