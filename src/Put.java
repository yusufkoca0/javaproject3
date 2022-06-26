public class Put {

    public static String[] task;
    public static String[] items;

    //starts put task
    public static void executePut(String s){

        //splits the task according to "\t"
        task = s.split("\t");

        //starts executing each put operation
        for (int i = 1; i < task.length; i++){
            putItems(task[i]);
        }
    }

    //executes putting
    public static void putItems(String s){

        //splits the operation according to ","
        items = s.split(",");

        //puts the items into correct stack
        for (Stack stack: Main.stackList){
            if (stack.getType().equals(items[0])){
                for (int i = 1; i < items.length; i++){
                    stack.push(items[i]);
                }
                break;
            }
        }
    }

}
