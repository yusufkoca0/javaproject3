public class Buy {

    public static String[] task;
    public static String[] items;

    //starts buy task
    public static void executeBuy(String s){

        //splits the task according to "\t"
        task = s.split("\t");

        //starts executing each buy operation
        for (int i = 1; i < task.length; i++){
            buyItems(task[i]);
        }
    }

    //executes buying
    public static void buyItems(String s){

        //splits the operation according to ","
        items = s.split(",");

        //removes the correct amount of items from the correct stack
        for (Stack stack: Main.stackList){
            if (stack.getType().equals(items[0])){
                for (int i = 0; i < Integer.parseInt(items[1]); i++){
                    stack.pop();
                }
            }
        }

        //calls this method to use tokens
        useToken();
    }

    //executes using tokens operation
    public static void useToken(){

        //gets the token with the highest priority with the type of operation
        Token token = Main.queue.remove(items[0]);

        //if tokens value is greater than the buying amount, it decreases the "amount" attribute of token and inserts it back
        if (Integer.parseInt(items[1]) < token.getAmount()){
            token.setAmount(token.getAmount() - Integer.parseInt(items[1]));
            Main.queue.insert(token);
        }
        //if they are equal it does not insert the token back
        else if (Integer.parseInt(items[1]) == token.getAmount()){
            return;
        }
        //if buying amount is greater than tokens value, it decreases the buying amount and calls this function again until
        //the operation is finished
        else {
            items[1] = String.valueOf(Integer.parseInt(items[1]) - token.getAmount());
            useToken();
        }
    }

}
