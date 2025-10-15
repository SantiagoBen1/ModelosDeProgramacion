package client;

import facade.Facade;

public class Client {
    public static void main(String[] args) {
        // Obtener la única instancia de FileFacade utilizando el Singleton
        Facade facade = Facade.getInstance();

        String originalContent = "Este es el contenido original que se cifrará y luego se descifrará.";

        // Escribir archivo cifrado
        String filePath = "file.txt";
        facade.writeEncryptedFile(filePath, originalContent);

        // Leer y descifrar el archivo
        String decryptedContent = facade.readDecryptedFile(filePath);
        System.out.println("Contenido descifrado: " + decryptedContent);
    }
}

