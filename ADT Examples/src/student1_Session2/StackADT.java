package student1_Session2;

/**
 * A basic Stack ADT
 * 
 * @author 
 *
 * @param <E> The Objects that this stack will contain 
 */
public interface StackADT<E> {
	
	/**
	 * Checks if the stack is empty
	 * 
	 * Precondition: A valid StackADT object exists 
	 * 
	 * Postcondition: A boolean is returned indicating if the stack is empty
	 * 
	 * @return true if the stack is empty, false otherwise.
	 */
	public boolean isEmpty();
	
	public void push(E item);
	
	public E pop();
	
	public E peek();
	
	public void clear();
}
