import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.sound.sampled.*;

public class JuegoMusicalAdivinanzas {
    public static void main(String[] args) {
        // Ruta del archivo de audio local
        String rutaArchivoAudio = "C:\\Users\\Usuario\\Videos\\canciooon.wav";

        // Reproducir canción desde un archivo local
        reproducirCancionDesdeArchivo(rutaArchivoAudio);

        // Definir preguntas y respuestas
        Map<String, String> adivinanzasRespuestas = new HashMap<>();
        adivinanzasRespuestas.put("Blanco por dentro, verde por fuera, si quieres que te lo diga, espera.", "Pera");
        adivinanzasRespuestas.put("Cuatro patas tiene un gato, ¿cuántas patas tiene un pato?", "Ninguna");
        adivinanzasRespuestas.put("¿Cuál es el instrumento que se mete y deja líquido dentro?", " jeringa");
        // Puedes agregar más adivinanzas y respuestas aquí

        // Bucle de adivinanzas
        try (Scanner scanner = new Scanner(System.in)) 
        {
            for (Map.Entry<String, String> entry : adivinanzasRespuestas.entrySet()) {
                String adivinanza = entry.getKey();
                String respuestaCorrecta = entry.getValue();
                
                System.out.println("Adivinanza: " + adivinanza);
                String respuesta = scanner.nextLine().toLowerCase();

                if (respuesta.equals(respuestaCorrecta)) {
                    System.out.println("¡Correcto!");
                } else {
                    System.out.println("Incorrecto. La respuesta correcta es: " + respuestaCorrecta);
                }
            }
        }

        // Detener la reproducción de la canción
        // (Aquí debes implementar tu propia lógica para detener la reproducción de la canción)
    }

    public static void reproducirCancionDesdeArchivo(String rutaArchivo) {
        try {
            File archivoAudio = new File(rutaArchivo);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivoAudio);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
}
