import java.lang.Thread;
public class ConsoleUtils {
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            // Manejo de excepciones
        }
    }
    public static void sleep(){
        try{Thread.sleep(3000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }

    }
    public static void puncarga(){
        for (int i=0;i<3;i++){
        try{Thread.sleep(1000);}
        catch(InterruptedException e){}
        System.out.print(".");
        }
        System.out.println();
    }
    }

