import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {

    public static ArrayList<String> partsList;
    public static ArrayList<String> itemsList;
    public static ArrayList<String> tokensList;
    public static ArrayList<String> tasksList;
    public static ArrayList<Stack> stackList;
    public static Queue queue;
    public static String output;

    public static void main(String[] args) {
        partsList = new ArrayList<>();
        itemsList = new ArrayList<>();
        tokensList = new ArrayList<>();
        tasksList = new ArrayList<>();
        stackList = new ArrayList<>();
        output = args[4];

        //reading the files and resetting the output file
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(output));
            br.close();
        } catch (Exception ex) {
            return;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String s;
            while ((s = br.readLine()) != null) {
                partsList.add(s);
            }
            br.close();

        } catch (Exception ex) {
            return;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(args[1]));
            String s;
            while ((s = br.readLine()) != null) {
                itemsList.add(s);
            }
            br.close();

        } catch (Exception ex) {
            return;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(args[2]));
            String s;
            while ((s = br.readLine()) != null) {
                tokensList.add(s);
            }
            br.close();

        } catch (Exception ex) {
            return;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(args[3]));
            String s;
            while ((s = br.readLine()) != null) {
                tasksList.add(s);
            }
            br.close();

        } catch (Exception ex) {
            return;
        }
        //reading the files and resetting the output file

        partConstructor();
        addItems();
        tokenConstructor();
        executeTasks();
        print();

    }

    //this method creates stack objects according to the type of item
    public static void partConstructor(){
        for (String s: partsList){
            stackList.add(new Stack(s));
        }
    }

    //this method adds items to stacks
    public static void addItems(){
        for (String s: itemsList){
            String[] items = s.split(" ");
            for (Stack stack: stackList){
                if (stack.getType().equals(items[1])){
                    stack.push(items[0]);
                }
            }
        }

    }

    //this method creates token objects and inserts them into priority queue
    public static void tokenConstructor(){

        queue = new Queue();

        for (String s: tokensList){
            String[] token = s.split(" ");
            queue.insert(new Token(token[0], token[1], Integer.parseInt(token[2])));
        }

    }

    //this method calls the task methos depending on the task
    public static void executeTasks(){
        for (String s: tasksList){
            if (s.startsWith("BUY")){
                Buy.executeBuy(s);
            }
            else if (s.startsWith("PUT")){
                Put.executePut(s);
            }
        }
    }

    //this method prints the output into output file
    public static void print(){
        for (Stack s: stackList){
            s.print();
        }
        queue.print();
    }
}
