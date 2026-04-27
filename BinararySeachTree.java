public class BinararySeachTree {
     Node root;

    public BinararySeachTree() {
        this.root = null;
    }



    
    public void insert(Player j){
        this.root = insert(this.root, j , 0);
    }

    public boolean search(String name){
        return search(this.root, name) != null;
    }

     public Player searchNames(String name){
        if (search(name)) {
            Player n = search(this.root, name).player;
            return n;
        }
        return null;
    }

    public Player remove(String name){
        if (search(name)) {
            Player n = search(this.root, name).player;
            this.root = remove(this.root, name);
            return n;
        }
        return null;
    }


    public ArrayListEu<Player> InorderList(){
        ArrayListEu<Player> l = new ArrayListEu<>();
        inOrder(this.root, l);
        return l ; 
    }












    private Node insert(Node current, Player j , int prof)
    {
        if (current == null) {

            return new Node(j, 0, 0);
        }

        if (j.getRanking() < current.player.getRanking()) {
            current.esq = insert(current.esq, j , current.profundidade+1);
        } else  {
            current.dir = insert(current.dir, j , current.profundidade+1);
        }
        current.altura = 1 + Math.max(getAltura(current.esq), getAltura(current.dir));
        return current;
    }

    private Node search(Node current, String name)
    {
        if (current == null) {
            return null;
        }

        if (current.player.getNickname().equals(name)) {
            return current;
        }

        Node Procura = search(current.esq, name);
        if (Procura != null) {
            return Procura;
        }

        return search(current.dir, name);
    }

    private Node remove(Node current, String name)
    {
        if(current == null){ 
            return null;
        }

       if(current.player.nickname.equals(name))
       {
        if (current.esq == null && current.dir == null) {
            return null; 
        }

        if(current.esq == null) 
        {
            return current.dir;
        }
        if(current.dir == null) 
        {
            return current.esq;
        }

        Node n = menorDir(current.dir) ;
        current.player = n.player;
        current.dir = remove(current.dir, n.player.nickname);

       }
       else
       {
        current.esq = remove(current.esq, name);
        current.dir = remove(current.dir, name);
       }


        current.altura = 1 + Math.max(getAltura(current.esq), getAltura(current.dir));
        return current;

        
    }

    
   private void inOrder(Node current, ArrayListEu<Player> lista) {
    if (current == null) return;

    inOrder(current.esq, lista);

    lista.ADD(current.player);

    inOrder(current.dir, lista);
   }


    private int getAltura(Node n) {
    if (n == null) {
        return -1; 
    }
    return n.altura; 
    }

    private Node menorDir(Node current)
    {
        if (current.esq == null) {
            return current ;
        }
        return menorDir(current.esq) ; 
    }
  
   
    
}
