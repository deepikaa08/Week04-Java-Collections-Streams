import java.util.*;
class Stacking{
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public Stacking(){
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }

    public void push(int x){
        q1.add(x);
    }

    public int pop(){
        while(q1.size()>1){
            q2.add(q1.remove());
        }

        int poppedElement=q1.remove();
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;

        return poppedElement;
    }

    public int top(){
        while(q1.size()>1){
            q2.add(q1.remove());
        }
        int topElement=q1.peek();
        q2.add(q1.remove());
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        return topElement;
    }
    
    public boolean empty(){
        return q1.isEmpty();
    }

}
public class StackUsingQueue {
    public static void main(String[] args) {
        Stacking stack=new Stacking();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Pop: "+stack.pop());
        System.out.println("Top: "+stack.top());
        System.out.println("Pop: "+stack.pop());
        System.out.println("Is stack empty? "+stack.empty());
        System.out.println("Pop: "+stack.pop());
        System.out.println("IS stack empty? "+stack.empty());
    }
}
