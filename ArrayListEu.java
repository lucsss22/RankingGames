
import java.util.NoSuchElementException;

public class ArrayListEu<T>
    {
        T[] data;
        int capacidade;
        int size;
        
        public ArrayListEu()
        {
            capacidade = 10;
            size = 0;
            data = (T[]) new Object[capacidade];
        }

        public ArrayListEu(int capacidade)
        {
            this.capacidade = capacidade;
            this.size = 0;
            this.data = (T[]) new Object[this.capacidade];
        }
        
        public void resize(int index)
        {
            T[] n = data;
            this.capacidade++;

            data = (T[]) new Object[this.capacidade];
            System.arraycopy(n, 0, data, 0, index);
            System.arraycopy(n, index , data, index +1, this.size-index);
            
        }

        public void ADD(T elemento)
        {
            if(size == this.capacidade)
            {
                resize(size);
            }

                data[size] = elemento;
                size++;
                return;
        }

        

        public void ADD(int index , T elemento)
        {
            if(index < 0 || index > size)
            {
                System.out.println("Index OUT OF BOUNDS");
                return;
            }

            if(size == capacidade)
                {
                resize(index);
            }
            else
            {
                for(int i = size-1; i >= index ; i--)
                {
                    data[i+1] = data[i];
                }
            }

                
                data[index] = elemento;
                size++;
                return;
                
        }

        public void REMOVE_EXP(int index)
        {
            if (index < 0 || index >= size)
            {
                System.out.println("Index OUT OF BOUNDS");
                return;
            }
            else
            {
                data[index]=null;
                for(int i = index ; i < size -1 ; i++)
                {
                    data[i] = data[i+1];
                    data[i+1] = null;
                }
                size--;
                return;
            }
        }

        public void remove()
        {
            if(size == 0)
            {
                System.out.println("Array UNDERFLOW");
                return;
            }
            else
            {
                data[size-1] = null;
                size--;
                return;
            }
        }

        public void set(int index , T elemento)
        {
            if (index < 0 || index >= size)
            {
                System.out.println("Index OUT OF BOUNDS");
                return;
            }
            else 
            {
                data[index] = elemento;
                return;
            }
        }

        public T get(int index)
        {
            if(index < 0 || index >= size){
                throw new NoSuchElementException("Índice inválido: " + index);
            }
            else
            {
                return data[index];
            }
        }

        public boolean contains(T e)
        {
            for(int i = 0 ; i <= size -1 ; i++)
            {
                if(data[i] == e)
                {
                    return true;
                }
            }
            return false ;
        }
        
        public int indexOf(T e )
        {
            if(contains(e))
            {
                for(int i = 0 ; i <= size -1 ; i++)
                {
                    if(data[i].equals(e))
                    {
                        return i;
                    }
                
                }
                
            }
            throw new NoSuchElementException("Elemento nao encontrado!");
        }


    }

