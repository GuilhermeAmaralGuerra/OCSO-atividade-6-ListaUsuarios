import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListUsers {
    public static void main(String[] args) {
        String[] command = {"powershell", "-Command", "Get-LocalUser | Format-List"};
        try{
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process processo = processBuilder.start();

            BufferedReader ler = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String linha;
            while ((linha = ler.readLine()) != null) {
                System.out.println(linha);
            }

            processo.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
