import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LeitorCSV {
    
    ArrayListEu<Player> dados = new ArrayListEu<Player>();

    public void lerCSV(String caminho) 
    {
        try (FileReader fr = new FileReader(caminho);
             BufferedReader br = new BufferedReader(fr)) {

            String linha = br.readLine(); 
            
            
            while ((linha = br.readLine()) != null) { 
                String[] dados = linha.split(","); 
                int ranking = Integer.parseInt(dados[1]) ;

                Player p = new Player(dados[0], ranking);
                this.dados.ADD(p);
            
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}