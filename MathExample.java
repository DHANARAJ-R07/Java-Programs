class MathExample {
    public static void main(String[] args) {
        double num1 = 45.7;
        double num2 = 78.3;

        System.out.println("Max: " + Math.max(num1, num2));
        System.out.println("Min: " + Math.min(num1, num2));

        System.out.println("Rounded num1: " + Math.round(num1));

        System.out.println("Square of num1: " + Math.pow(num1, 2));
        System.out.println("Square root of num2: " + Math.sqrt(num2));

        System.out.println("Absolute Difference: " + Math.abs(num1 - num2));

        System.out.println("Ceil: " + Math.ceil(num1));
        System.out.println("Floor: " + Math.floor(num1));

        System.out.println("Random (0–100): " + (Math.random() * 100));

        System.out.println("Exponential: " + Math.exp(2));
        System.out.println("Logarithm: " + Math.log(10));

        System.out.println("Sin: " + Math.sin(num1));
        System.out.println("Cos: " + Math.cos(num1));

        System.out.println("Cube of num1: " + Math.pow(num1, 3));
    }
}