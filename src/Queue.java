import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Queue {

    public int pointer;
    public ArrayList<Token> queue;

    public Queue() {
        this.pointer = -1;
        this.queue = new ArrayList<>();
    }

    //inserts the item according to its priority
    public void insert(Token t){

        //first checks if queue is empty, if it is empty it adds the item to the queue
        if(isEmpty()){
            this.queue.add(t);

        }

        //if it is not it continues from here
        else {

            for (int i = this.pointer; i > -1; i--){

                //if the value of item is greater than the value of the item "i" points it continues here
                if (t.getAmount() > this.queue.get(i).getAmount()) {

                    //if the i is equal to the pointer it adds the same item to and of the queue
                    if (i == this.pointer) {
                        this.queue.add(this.queue.get(i));

                    }
                    //if not it makes the item one index above the same item
                    else {
                        this.queue.set(i + 1, this.queue.get(i));

                    }

                    //if i is equal to 0 that means the item we inserted has the highest value so it makes the 0th index that item.
                    if (i == 0){
                        this.queue.set(i, t);
                        break;
                    }
                }

                //if not it continues here
                else {

                    //if i equals to the pointer it adds the item to the end
                    if (i == this.pointer){
                        this.queue.add(t);
                    }

                    //else it changes the 1 index above to the according item
                    else {
                        this.queue.set(i + 1, t);
                    }
                    break;
                }
            }
        }

        //increases the pointer at the end
        this.pointer++;
    }

    //removes the item according the its priorty and returns that item
    public Token remove(String s){

        Token token = new Token();

        for (int i = 0; i < this.pointer+1; i++){
            if (this.queue.get(i).getType().equals(s)){
                token = this.queue.get(i);
                this.queue.remove(i);
                break;
            }
        }
        this.pointer--;
        return token;
    }

    //returns the item according to its priority
    public Token peek(String s){
        for (Token t: this.queue){
            if (t.getType().equals(s)){
                return t;
            }
        }
        return null;
    }

    //checks if it is empty
    public boolean isEmpty(){
        return this.pointer == -1;
    }

    //prints the values of tokens in the queue
    public void print(){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));
            br.write("Token Box:\n");
            for (int i = this.pointer; i > -1; i--){
                if (i == 0){
                    br.write(this.queue.get(i).getId() + " " + this.queue.get(i).getType() + " " +
                            this.queue.get(i).getAmount());
                }
                else {
                    br.write(this.queue.get(i).getId() + " " + this.queue.get(i).getType() + " " +
                            this.queue.get(i).getAmount() + "\n");
                }
            }
            br.close();
        } catch (Exception ex) {
            return;
        }
    }

}
