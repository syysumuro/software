import java.util.ArrayList;

public class Queue {
    private ArrayList<Surroundings> Q; 
    int len;    

    public Queue(){
        this.Q=new ArrayList<Surroundings>();
        this.len=0;
    }

    public int getLen(){
        return this.len;
    }
    
    public void append(Surroundings surrounding){
        this.Q.add(surrounding);
        this.len++;
    }

    public Surroundings pop(){
        Surroundings s=this.Q.get(0);
        this.Q.remove(0);
        this.len--;
        return s;
    }

    public double getR(int num){
        return this.Q.get(num).getNew_circle().Get_r();
    }

    public void insert(int i,Surroundings s){
        this.Q.add(i,s);
        this.len++;
    }
}
