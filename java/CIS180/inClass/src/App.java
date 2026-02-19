
public class App {
    public static void main(String[] args) throws Exception {
        Rectangle r1 = new Rectangle(5, 10);
        System.out.println(r1.getArea());
        r1.setLength(7);
        System.out.println(r1.getArea());
    }
}
