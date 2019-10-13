public interface Queue<E> {

    public void push(E e) throws ColaLlenaException;
    public E pop() throws ColaVaciaException;
    public int size();

}
