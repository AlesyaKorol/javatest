package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    yoda("Harry Potter");
    yoda("Yoda");

    Square s = new Square(9);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(5, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
  }

  public static void yoda(String somebody) {
    System.out.println("Do or do not, there is no try, said " + somebody);
  }


}
