public class Node {
    Player player; 
    int altura;
    int profundidade;
    Node esq; 
    Node dir; 

    
    public Node(Player player , int altura, int profundidade){
        this.player = player;
        this.esq = null;
        this.dir = null;
        this.altura = altura;
        this.profundidade = profundidade;
    }
}


