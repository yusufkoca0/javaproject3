how to compile and run:

> javac *.java
>java Main parts.txt items.txt tokens.txt tasks.txt output.txt

parts.txt includes the parts vending machine can take.

items.txt includes which item is where in the vending machine. Machine works with stacks. Each part has its own stack.

tokens.txt includes your tokens. tokens are kept in a priority queue. Number after a token show how many of that item u can buy with using that token.

tasks.txt includes the tasks either putting more items into machine or buying from the machine.