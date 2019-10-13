public class QueueImpl<E> implements Queue<E>{
    private int p; //Puntero
    private E [] data;

    public QueueImpl(int l){ //Constructor de la cola de objetos de la clase E
        this.data = (E[])new Object [l];
        p = 0;
    }

    private boolean isFull(){
        /*if (this.p >= this.data.length)
            return true;
        else
            return false;
         */
        return (p >= this.data.length);
    }

    private boolean isEmpty(){
        /*if (this.p == 0)
            return true;
        else
            return false;
        */
        return (p==0);
    }

    private void lShift (){ //Mueve todos los elementos del vector
        for (int i = 0; i < (this.p - 1); i++){
            this.data[i] = this.data[i+1];
        }
        p--;
    }

    public void push (E e) throws ColaLlenaException{
        if(this.isFull())
            throw new ColaLlenaException();
        else{
            this.data[p] = e;
            p++;
        }
    }

    public E pop() throws ColaVaciaException{
        if(this.isEmpty())
            throw new ColaVaciaException();
        else{
            E res = this.data[0];
            lShift();
            return res;
        }
    }

    public int size(){
        return p;
    }

}
