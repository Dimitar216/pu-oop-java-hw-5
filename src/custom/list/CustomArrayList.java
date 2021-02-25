package custom.list;

public class CustomArrayList<T>{

    private int placeholderPointer=0;
    private final Object[] collection;

    /**
     * Constructor that initializes the array
     */
    public CustomArrayList(){
        this.collection = new Object[6];
    }

    /**
     * Method which adds a string to the array
     * @param str Added string
     */
    public void add(String str){
        this.collection[placeholderPointer++] = str;
    }

    /**
     * Method which displays all the array elements in the console
     */
    public void display(){
        for (Object i : collection) {
            if (i != null) {
                System.out.println(i);
            }
        }
    }
}
