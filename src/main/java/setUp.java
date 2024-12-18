import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class setUp {
    public static void main(String[] args) {
        try {
            // Vérification et création de la base de données si elle n'existe pas
            // System.out.println("Vérification et création de la base de données...");
            // Process process1 = Runtime.getRuntime().exec("java dao.CreateBD");
            // process1.waitFor();
            // afficherSortie(process1);

            // Exécution de dao/inputData.java
            System.out.println("Exécution de dao/inputData.java...");
            Process process2 = Runtime.getRuntime().exec("java dao.InputData");
            process2.waitFor();
            afficherSortie(process2);

            // Exécution de vue/IHMAccueil.java
            System.out.println("Exécution de vue/IHMAccueil.java...");
            Process process3 = Runtime.getRuntime().exec("java vue.IHMAccueil");
            process3.waitFor();
            afficherSortie(process3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void afficherSortie(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String ligne;
        while ((ligne = reader.readLine()) != null) {
            System.out.println(ligne);
        }
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        while ((ligne = errorReader.readLine()) != null) {
            System.err.println(ligne);
        }
    }
}
