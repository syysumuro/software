
public class Edge {
    private double A;
    private double B;
    private double C;

    public Edge(Point point1,Point point2){
        this.A=point2.getY()-point1.getY(); 
        this.B=point1.getX()-point2.getX(); 
        this.C=point2.getX()*point1.getY()-point1.getX()*point2.getY(); 
    }

    public double getA(){
        return this.A;
    }

    public double getB(){
        return this.B;
    }

    public double getC(){
        return this.C;
    }
}
