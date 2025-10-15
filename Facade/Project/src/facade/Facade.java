
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import subsystem.FileReader;
import subsystem.FileWriter;
import subsystem.FileEncryptor;

public class Facade {
    private FileReader fileReader;
    private FileWriter fileWriter;
    private FileEncryptor fileEncryptor;

    // Instancia estática de la fachada, inicializada de manera perezosa (Lazy Initialization)
    private static Facade instance;

    // Constructor privado para evitar instanciación externa
    private Facade() {
        fileReader = new FileReader();
        fileWriter = new FileWriter();
        fileEncryptor = new FileEncryptor();
    }

    // Método público para obtener la instancia única de la fachada
    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    public void writeEncryptedFile(String fileName, String content) {
        String encryptedContent = fileEncryptor.encrypt(content);
        fileWriter.write(fileName, encryptedContent);
    }

    public String readDecryptedFile(String fileName) {
        String encryptedContent = fileReader.read(fileName);
        return fileEncryptor.decrypt(encryptedContent);
    }
}

