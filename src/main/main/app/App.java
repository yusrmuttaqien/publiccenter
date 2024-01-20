package main.app;

import func.method.Method;
import java.util.InputMismatchException;
import ui.menus.Menus;

public class App {

  public static void main(String[] args) {
    Method method = new Method();
    Menus menus = new Menus();

    try {
      menus.boot(method);
    } catch (InputMismatchException e) {
      System.out.println("\nTelah terjadi Exception " + e + " pada aplikasi.");
      System.out.println("\nMe-reboot aplikasi...");
      main(args);
    }
  }
}
