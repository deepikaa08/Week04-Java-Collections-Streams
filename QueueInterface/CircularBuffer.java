public class CircularBuffer {
    private int[] buffer;
    private int size;
    private int start=0;
    private int end=0;
    private boolean isFull=false;

    public CircularBuffer(int capacity){
        buffer=new int[capacity];
        size=capacity;
    }

    public void add(int value){
        buffer[end]=value;
        end=(end+1)%size;

        if(isFull){
            start=(start+1)%size;
        }

        if(end==start){
            isFull=true;
        }
    }

    public void printBuffer(){
        System.out.print("Buffer: [");
        int i=start;
        int count=0;
        while(count<size&&(i!=end||(isFull&&count==0))){
            System.out.print(buffer[i]);
            i=(i+1)%size;
            count++;
            if(count<size&&(i!=end||isFull)) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb=new CircularBuffer(3);
        cb.add(1);
        cb.add(2);
        cb.add(3);
        cb.printBuffer();
        cb.add(4);
        cb.printBuffer();
        cb.add(5);
        cb.printBuffer();
    }
}
