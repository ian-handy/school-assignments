public class MainClass {
    public static void main(String[] args) throws Exception {
        RunningTotal numbers = new RunningTotal();
        numbers.getNumbersFromUser();
        System.out.println(numbers.getAverage());
        System.out.println(numbers.getProduct());
        System.out.println(numbers.getSum());
    }
}
