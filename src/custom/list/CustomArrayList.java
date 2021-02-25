package custom.list;

public class CustomArrayList{

    private int placeholderPointer=0;
    private String[] collection;

    public CustomArrayList(){
        this.collection = new String[6];
    }
    public void add(String str){
        this.collection[placeholderPointer++] = str;
    }
    public void display(){
        for(int i =0; i<collection.length;i++){
            if(collection[i] !=null){
                System.out.println(collection[i]);
            }
        }
    }
}
