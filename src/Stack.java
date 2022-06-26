import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Stack {

    private String type;
    public int pointer;
    public ArrayList<String> stack;

    public Stack(String type){
        this.type = type;
        this.pointer = -1;
        this.stack = new ArrayList<>();
    }

    //adds item to the end and moves pointer one step forward
    public void push(String s){
        this.pointer++;
        this.stack.add(s);
    }

    //removes the last item and moves pointer one step back
    public void pop(){
        this.stack.remove(this.pointer);
        this.pointer--;
    }

    //gets the last item
    public String peek(){
        return this.stack.get(this.pointer);
    }

    //checks if stack is empty
    public boolean isEmpty(){
        return this.pointer == -1;
    }

    //prints the values of stack to the output file
    public void print(){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));
            br.write(this.type + ":\n");
            if (!isEmpty()) {
                for (int i = this.pointer; i > -1; i--) {
                    br.write(this.stack.get(i) + "\n");
                }
            }
            else {
                br.write("\n");
            }
            br.write("---------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
