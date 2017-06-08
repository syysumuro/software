
public class Calculate {

    private double pow(double n){
        return Math.pow(n,2);
    }
    private double sqrt(double n){
        return Math.sqrt(n);
    }

    public Point point_with_2edges(Edge edge1,Edge edge2){
        double A1=edge1.getA();
        double A2=edge2.getA();
        double B1=edge1.getB();
        double B2=edge2.getB();
        double C1=edge1.getC();
        double C2=edge2.getC();

        double x=0.0,y=0.0;
        if((C1*B2-B1*C2)!=0){
            x=(C1*B2-B1*C2)/(A2*B1-A1*B2);
        }
        else x=0;
        if((A1*C2-A2*C1)!=0){
            y=(A1*C2-A2*C1)/(A2*B1-A1*B2);
        }
        else y=0;

        return new Point(x,y);
    }


    public double point_to_point(Point point1,Point point2){
        return Math.hypot((point1.getX()-point2.getX()),(point1.getY()-point2.getY()));
    }

  
    public double point_to_edge(Point point,Edge edge){
        return Math.abs(edge.getA()*point.getX()+edge.getB()*point.getY()+edge.getC())/Math.hypot(edge.getA(),edge.getB());
    }


    public Circle1 twoEdges_oneCircle(Edge edge1,Edge edge2,Circle1 circle){
        Point point1=point_with_2edges(edge1,edge2);
        Point point2=circle.getPoint();
        double r=(point_to_point(point1,point2)-circle.getR())/(1+sqrt(2));
        double x=point1.getX()+(r*(point2.getX()-point1.getX()))/circle.getR();
        double y=point1.getY()+(r*(point2.getY()-point1.getY()))/circle.getR();
        Point point=new Point(x,y);

        return new Circle1(point,r);
    }


    public Circle1 twoCircles_oneEdge(Circle1 circle1,Circle1 circle2,Edge edge){
        double A=edge.getA();
        double B=edge.getB();
        double C=edge.getC();
        double r1=circle1.getR();
        double r2=circle2.getR();
        double x1=circle1.getPoint().getX();
        double x2=circle2.getPoint().getX();
        double y1=circle1.getPoint().getY();
        double y2=circle2.getPoint().getY();

        double r=pow((sqrt(r1*r2)/(sqrt(r1)+sqrt(r2))));
        double theta1=(pow(r1)-pow(r2)+2*r*(r1-r2)-pow(x1)+pow(x2)-pow(y1)+pow(y2))/2;
        double theta2=r*sqrt(pow(A)+pow(B))-C;
        if(C==0&&(B==-1||A==-1)){
            theta1= -theta2;
        }
        double y=(theta2*(x2-x1)-theta1*A)/(B*(x2-x1)-A*(y2-y1));
        double x=(theta1-y*(y2-y1))/(x2-x1);

        return new Circle1(new Point(x,y),r);
    }


    public Circle1 threeCircles(Circle1 circle1,Circle1 circle2,Circle1 circle3){
        double x1=circle1.getPoint().getX();
        double x2=circle2.getPoint().getX();
        double x3=circle3.getPoint().getX();
        double y1=circle1.getPoint().getY();
        double y2=circle2.getPoint().getY();
        double y3=circle3.getPoint().getY();
        double r1=circle1.getR();
        double r2=circle2.getR();
        double r3=circle3.getR();
        double k1=((r2-r3)/(x2-x3)-(r1-r2)/(x1-x2))/((y1-y2)/(x1-x2)-(y2-y3)/(x2-x3));
        double b1=((pow(x1)-pow(x2)+pow(y1)-pow(y2)-pow(r1)+pow(r2))/(2*(x1-x2))-(pow(x2)-pow(x3)+pow(y2)-pow(y3)-pow(r2)-pow(r3))/(2*(x2-x3)))/((y1-y2)/(x1-x2)-(y2-y3)/(x2-x3));
        double k2=(r3-r2)/(x2-x3)-k1*(y2-y3)/(x2-x3);
        double b2=(pow(x2)-pow(x3)+pow(y2)-pow(y3)-pow(r2)+pow(r3))/(2*(x2-x3))-b1*(y2-y3)/(x2-x3);

        double a=pow(k2)+pow(k1)-1;
        double b=2*k2*(b2-x1)+2*k1*(b1-y1)-2*r1;
        double c=pow(b2-x1)+pow(b1-y1)-pow(r1);

        double r=-c/b;
        double x=k2*r+b2;
        double y=k1*r+b1;

        return new Circle1(new Point(x,y),r);

    }





}
