package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    yoda("Harry Potter");
    yoda("Yoda");

    double l = 9;
    System.out.println("Площадь квадрата со стороной " + l + " = " + area(l));

    double a = 5;
    double b = 6;
    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a, b));
  }

  public static void yoda(String somebody) {
    System.out.println("Do or do not, there is no try, said " + somebody);
  }

  public static double area(double len) {
    return len * len;
  }

  public static double area(double a, double b) {
    return a * b;
  }
}
