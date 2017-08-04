public class TestWork2 {
    public static void main(String[] args) {
        Worker p1 = new Worker("jack", 18, 3000);
        Worker p2 = new Worker("rose", 17, 3000);
        Worker p3 = new Worker("jack", 18, 3000);
        if (p1.equals(p2)) {
            System.out.println("p1.equals p2");
        }
        if (p1.equals(p3)) {
            System.out.println("p1.equals p3");
        }
    }
}
