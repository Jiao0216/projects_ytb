import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class PlayMusic {
    public static void main(String[] args) {
        String filePath = "src/grown.wav";
        File file = new File(filePath);
        try(AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Scanner scanner = new Scanner(System.in)){
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            String response = "";
            while(!response.equals("Q")){
            System.out.println("P=Play");
            System.out.println("S=Stop");
            System.out.println("R=Restart");
            System.out.println("Q=Qiut");
            System.out.print("Enter your choice: ");
            response = scanner.nextLine().toUpperCase();
                switch(response){
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.stop();
                    default -> System.out.println("Invalid choice");
                }
            }
            System.out.println("Bye");
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(UnsupportedAudioFileException e){
            System.out.println("Unsupported audio file");
        }
        catch (LineUnavailableException e) {
            System.out.println("Line unavailable");
        }
        catch(IOException e){
            System.out.println("Something went wrong");
        }
    }
}
