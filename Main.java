import java.util.Scanner;

public class Main {

    public static void main(String[] args) 
    { 
        int o = 0 ; 
        Scanner scanner = new Scanner(System.in);

        BinararySeachTree bst = new BinararySeachTree();

        while (o != 5) {
            System.out.println("Escolha uma opcao:");
            System.out.println("1. Ler CSV");
            System.out.println("2. Inserir jogador");
            System.out.println("3. Buscar jogador");
            System.out.println("4. Remover jogador");
            System.out.println("5. Sair");

            o = scanner.nextInt();
            scanner.nextLine();

            switch (o) {
                case 1:
                    LeitorCSV leitor = new LeitorCSV();
                    leitor.lerCSV("players.csv");

                    for (int i = 0; i < leitor.dados.size; i++) {
                        bst.insert(leitor.dados.get(i));
                    }

                    System.out.println("CSV lido com sucesso.");
                    break;
                case 2:
                    System.out.println("Digite o nickname do jogador:");
                    String nick = scanner.nextLine();
                    System.out.println("Digite o ranking do jogador:");
                    int ranking = scanner.nextInt();
                    scanner.nextLine();

                    Player p = new Player(nick, ranking);

                    bst.insert(p);
                    

                    System.out.println("Inserindo jogador...");
                    break;
                case 3:
                    System.out.println("Digite o nickname do jogador a ser buscado:");
                    String Snick = scanner.nextLine();

                    if (bst.search(Snick)) {
                        Player Sname = bst.searchNames(Snick);
                        System.out.println("Jogador encontrado: " + Sname.getNickname() + " com ranking " + Sname.getRanking());
                    } else 
                    {
                        System.out.println("Jogador nao encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o nickname do jogador a ser removido:");
                    String Dnick = scanner.nextLine();

                    Player removido = bst.remove(Dnick);
                    if (removido != null) {
                        System.out.println("Jogador " + removido.getNickname() + " removido.");
                    } else {
                        System.out.println("Jogador nao encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }

        scanner.close();
    }
   
}
