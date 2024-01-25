package dev.djob.id;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

public class QuadraticEquationSolverTest {

  private static void writeResultToCSV(String testName, String x1, String x2, String result, boolean isSuccess) {
    try (PrintWriter writer = new PrintWriter(new FileWriter("test_results.csv", true))) {
      writer.println(testName + ",                                               " + x1 + ",            " + x2
          + ",        " + result + ",      " + (isSuccess ? "Passed" : "Failed"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_Zero_B_TresGrandNegatif_C_TresProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 0.0;
    double b = -5.035501906621727E8;
    double c = 6.746978863400469E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroPositif_B_TresProcheDeZeroPositif_C_TresGrandNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 4.659003203196347E-7;
    double b = 4.325323847416232E-7;
    double c = -2.5995431679380858E8;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroNegatif_B_TresGrandPositif_C_Zero_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -9.178446091339341E-7;
    double b = 7.040061780516717E8;
    double c = 0.0;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroPositif_B_TresProcheDeZeroNegatif_C_TresProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 2.7453301016306106;
    double b = -5.464212385822876E-7;
    double c = -1.8565184919346138E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroNegatif_B_ProcheDeZeroNegatif_C_PositifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -3.3863700479941983;
    double b = -3.874117134618319;
    double c = 161.55426035082417;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_PositifNormal_B_NegatifNormal_C_ProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 453.3179834308922;
    double b = -240.50664763733835;
    double c = -4.825603288929409;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_NegatifNormal_B_Zero_C_TresGrandPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -138.70341413895085;
    double b = 0.0;
    double c = 8.313461808207194E8;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandPositif_B_ProcheDeZeroPositif_C_ProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 6.931484440367728E8;
    double b = 1.3089511359565238;
    double c = 4.6862164319955095;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandNegatif_B_PositifNormal_C_NegatifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -2.3636706160638213E7;
    double b = 81.06247634843702;
    double c = -259.65984107359355;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_Zero_B_Zero_C_TresGrandNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 0.0;
    double b = 0.0;
    double c = -8.079409746668648E8;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroPositif_B_Zero_C_ProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 2.877684876781826E-7;
    double b = 0.0;
    double c = 2.0165996870991774;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroNegatif_B_Zero_C_ProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -7.644018179426074E-7;
    double b = 0.0;
    double c = -2.5307647112366767;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroPositif_B_Zero_C_TresProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 3.5295160409152624;
    double b = 0.0;
    double c = 5.37827811348884E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroNegatif_B_Zero_C_Zero_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -2.77946634466386;
    double b = 0.0;
    double c = 0.0;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_PositifNormal_B_Zero_C_PositifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 497.4882653306386;
    double b = 0.0;
    double c = 477.10481867730505;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_NegatifNormal_B_TresProcheDeZeroPositif_C_NegatifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -170.01423251323484;
    double b = 2.2791560370300694E-7;
    double c = -437.26486531217745;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandPositif_B_Zero_C_TresProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 4.188681016676091E8;
    double b = 0.0;
    double c = -3.626258556941809E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandNegatif_B_Zero_C_PositifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -9605153.898480654;
    double b = 0.0;
    double c = 226.47127210500372;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_Zero_B_TresProcheDeZeroNegatif_C_Zero_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 0.0;
    double b = -7.215766738874395E-7;
    double c = 0.0;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_Zero_B_ProcheDeZeroPositif_C_ProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 0.0;
    double b = 3.8351049501415853;
    double c = -2.541103365161606;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_Zero_B_ProcheDeZeroNegatif_C_ProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 0.0;
    double b = -2.616746558815704;
    double c = 3.5561018312339745;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_Zero_B_PositifNormal_C_TresProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 0.0;
    double b = 355.05586759185087;
    double c = -6.273597405510816E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_Zero_B_NegatifNormal_C_NegatifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 0.0;
    double b = -148.01798192216563;
    double c = -217.53599157944018;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_Zero_B_TresGrandPositif_C_TresGrandPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 0.0;
    double b = 7.029951884269134E8;
    double c = 3.736265011116954E8;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroPositif_B_TresGrandNegatif_C_TresProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 7.915671016615256E-7;
    double b = -3.2464128881120443E8;
    double c = -8.280830212448164E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroNegatif_B_ProcheDeZeroNegatif_C_TresGrandNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -3.678076698844527E-7;
    double b = -3.203019568120345;
    double c = -3.624453632632911E8;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroPositif_B_TresGrandNegatif_C_TresGrandNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 4.141705734788664;
    double b = -6.511771891481194E8;
    double c = -6.460229626883037E8;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroNegatif_B_TresProcheDeZeroNegatif_C_TresGrandNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -4.19716875798362;
    double b = -9.842336238653637E-7;
    double c = -8.832713098924501E8;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_PositifNormal_B_TresGrandPositif_C_TresGrandNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 275.426174804344;
    double b = 2.61650928838992E8;
    double c = -7.152790107271665E8;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_NegatifNormal_B_ProcheDeZeroPositif_C_TresGrandNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -171.99542615051928;
    double b = 2.106841644712235;
    double c = -4.8932885901431906E8;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandPositif_B_PositifNormal_C_TresGrandNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 2.1142754843167818E8;
    double b = 106.91525150749844;
    double c = -3.8508646864537156E8;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandNegatif_B_NegatifNormal_C_TresGrandNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -6.385370885456145E8;
    double b = -271.8942674239975;
    double c = -3.627898287620833E8;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_Zero_B_TresProcheDeZeroPositif_C_PositifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 0.0;
    double b = 5.453235393669755E-7;
    double c = 374.20877726392433;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroPositif_B_ProcheDeZeroPositif_C_TresProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 2.011548602839244E-7;
    double b = 4.660839245838435;
    double c = 2.694660603541932E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroNegatif_B_TresGrandNegatif_C_TresGrandPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -2.898781497532058;
    double b = -6.167381494667563E8;
    double c = 7.680744054140285E8;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroNegatif_B_TresGrandNegatif_C_NegatifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -2.1271960154754713E-7;
    double b = -8.063187640755088E8;
    double c = -289.7572677859083;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroPositif_B_ProcheDeZeroPositif_C_NegatifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 2.3955633955087405;
    double b = 3.6936848559477875;
    double c = -438.14777857358797;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_PositifNormal_B_ProcheDeZeroNegatif_C_NegatifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 42.19744266325501;
    double b = -3.426278533464106;
    double c = -314.5187210505866;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_NegatifNormal_B_TresProcheDeZeroNegatif_C_PositifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -64.55768362584797;
    double b = -3.485768651539604E-7;
    double c = 179.94496826097543;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandPositif_B_TresGrandPositif_C_NegatifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 5.56934461977736E8;
    double b = 1.3522579054423133E8;
    double c = -32.32883069551656;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandNegatif_B_ProcheDeZeroPositif_C_TresGrandPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -1.9588774887265038E8;
    double b = 2.103199693215787;
    double c = 7.368748074394597E8;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroNegatif_B_TresProcheDeZeroPositif_C_ProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -3.0183078252956794;
    double b = 7.91025689790876E-7;
    double c = -4.6249393870983875;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroPositif_B_PositifNormal_C_PositifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 3.672322585898179E-7;
    double b = 252.1859294046939;
    double c = 84.90666116387925;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandPositif_B_NegatifNormal_C_TresGrandPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 2.9474972343950593E8;
    double b = -55.91094795166606;
    double c = 7.517372349680151E7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_PositifNormal_B_PositifNormal_C_Zero_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 224.69147475538065;
    double b = 161.50168507091666;
    double c = 0.0;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroNegatif_B_PositifNormal_C_TresProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -4.910988751290435E-7;
    double b = 159.2430749376191;
    double c = 1.7682563996024969E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroNegatif_B_NegatifNormal_C_ProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -8.029286929009758E-7;
    double b = -168.17886178206498;
    double c = 2.7567849759127108;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroPositif_B_TresGrandPositif_C_ProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 2.0354089992497135;
    double b = 7.997505228794737E8;
    double c = -4.263582315899232;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_NegatifNormal_B_TresGrandPositif_C_ProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -204.3872997889003;
    double b = 1.9385840068546996E8;
    double c = 1.7451514811492395;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandNegatif_B_TresGrandNegatif_C_ProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -6.55568444202956E8;
    double b = -7.878310433647689E8;
    double c = 2.290203391319001;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_PositifNormal_B_TresProcheDeZeroPositif_C_ProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 288.47486220246407;
    double b = 7.867382775161042E-7;
    double c = 4.406240269594512;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroPositif_B_TresProcheDeZeroNegatif_C_NegatifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 7.513550380405727E-7;
    double b = -4.076535768677234E-7;
    double c = -193.77635190186447;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroPositif_B_ProcheDeZeroNegatif_C_TresGrandPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 4.6833636831402384E-7;
    double b = -2.7464580661633287;
    double c = 9.00255973994701E8;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_PositifNormal_B_ProcheDeZeroPositif_C_Zero_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 271.8631339780983;
    double b = 1.648132463097725;
    double c = 0.0;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandNegatif_B_ProcheDeZeroNegatif_C_TresProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -9.491721612641346E8;
    double b = -4.203471701492436;
    double c = 3.279624965219007E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_NegatifNormal_B_NegatifNormal_C_TresProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -344.0661598885649;
    double b = -72.94484891742621;
    double c = -1.6849509868252143E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroPositif_B_TresProcheDeZeroPositif_C_Zero_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 4.952338161823959;
    double b = 1.2198615160372182E-7;
    double c = 0.0;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroNegatif_B_PositifNormal_C_NegatifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -3.9288559686013786;
    double b = 49.04742435512333;
    double c = -362.02165303401125;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandPositif_B_TresGrandNegatif_C_ProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 3.733139547921917E8;
    double b = -7.845713608736076E8;
    double c = -4.495252446550989;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_PositifNormal_B_TresProcheDeZeroNegatif_C_TresProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 165.70580076851414;
    double b = -4.553094921839959E-7;
    double c = 4.191256702751399E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandNegatif_B_TresProcheDeZeroPositif_C_TresProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -2.621000641449306E8;
    double b = 7.996253553230564E-7;
    double c = -2.0275845499216627E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroPositif_B_NegatifNormal_C_Zero_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 8.190443925094469E-7;
    double b = -357.1079459989515;
    double c = 0.0;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroPositif_B_TresGrandPositif_C_PositifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 2.5115012055497377;
    double b = 8.389640133366879E8;
    double c = 377.74329211821816;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroNegatif_B_TresProcheDeZeroPositif_C_TresGrandPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -9.998850063594897E-7;
    double b = 7.258203418741221E-7;
    double c = 9.281628410602746E8;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroNegatif_B_TresGrandPositif_C_ProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -4.660353527103024;
    double b = 4.9253212338579524E8;
    double c = 3.228215548684458;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_NegatifNormal_B_ProcheDeZeroNegatif_C_TresProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -387.290501087223;
    double b = -3.7934241753601907;
    double c = 6.256086428710922E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandPositif_B_ProcheDeZeroNegatif_C_Zero_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 7.986937754949619E8;
    double b = -1.947133117494103;
    double c = 0.0;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandNegatif_B_TresProcheDeZeroNegatif_C_ProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -6.604763989765654E8;
    double b = -1.957726193428569E-7;
    double c = -4.248112004505809;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroNegatif_B_ProcheDeZeroPositif_C_TresProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -7.029292300030449E-7;
    double b = 4.473945918302832;
    double c = -1.0187697299780866E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroPositif_B_PositifNormal_C_TresGrandPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 2.9009134377282537;
    double b = 120.13912789684449;
    double c = 4.6546233249726886E8;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandPositif_B_TresProcheDeZeroPositif_C_TresProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 4.921133773322542E8;
    double b = 5.187483517790418E-7;
    double c = 1.0721404697660779E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandPositif_B_TresGrandNegatif_C_PositifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 1.1175273146817893E8;
    double b = -9.202917518454387E8;
    double c = 17.178271748001563;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroNegatif_B_NegatifNormal_C_TresProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -2.5853067705048076;
    double b = -152.362366260295;
    double c = 7.354465114722695E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_NegatifNormal_B_TresGrandNegatif_C_Zero_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -239.77511491428163;
    double b = -8.696403175935273E8;
    double c = 0.0;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandPositif_B_TresProcheDeZeroNegatif_C_ProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 5.037093330997127E8;
    double b = -9.208569391598671E-7;
    double c = 2.205468530530726;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroPositif_B_TresGrandPositif_C_TresProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 6.950806114270054E-7;
    double b = 7.140517858531628E8;
    double c = -5.85897248856792E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_NegatifNormal_B_PositifNormal_C_ProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -224.8406744984306;
    double b = 247.70872147449714;
    double c = -3.7067490517206303;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroPositif_B_ProcheDeZeroNegatif_C_ProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 4.954497340238843;
    double b = -3.455394176004253;
    double c = -2.1623317426083473;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_PositifNormal_B_TresGrandNegatif_C_TresProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 201.50569927072252;
    double b = -2.2910536049951935E8;
    double c = -4.226288991168461E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroNegatif_B_ProcheDeZeroPositif_C_PositifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -1.78495068578124E-7;
    double b = 4.00760951049113;
    double c = 152.87859853752704;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroPositif_B_NegatifNormal_C_ProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 1.1397613788648697;
    double b = -457.0016810012908;
    double c = 1.365562040217526;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroNegatif_B_ProcheDeZeroPositif_C_TresProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -1.31892417127542;
    double b = 1.7110373369660028;
    double c = -5.543224747540648E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_TresGrandNegatif_B_TresGrandPositif_C_Zero_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -3.142147958180189E7;
    double b = 4.7487205344655883E8;
    double c = 0.0;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroNegatif_B_TresProcheDeZeroNegatif_C_TresGrandPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -5.349744181289166E-7;
    double b = -7.29170288303941E-7;
    double c = 3.962966154395754E8;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroPositif_B_TresProcheDeZeroPositif_C_ProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 5.875021104954715E-7;
    double b = 7.001154315436129E-7;
    double c = -4.263485280331164;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_PositifNormal_B_Zero_C_TresGrandPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 428.2039717365182;
    double b = 0.0;
    double c = 8.257720073034502E8;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_NegatifNormal_B_Zero_C_NegatifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = -486.89844423412376;
    double b = 0.0;
    double c = -73.85203291435994;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroPositif_B_ProcheDeZeroNegatif_C_TresProcheDeZeroNegatif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 1.6911380743332507;
    double b = -3.1496949306525046;
    double c = -6.799296458633156E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test(expected = InvocationTargetException.class)
  public void testSolveA_TresProcheDeZeroPositif_B_PositifNormal_C_ProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 2.641907575630066E-7;
    double b = 399.8696512649825;
    double c = 1.7225197274216577;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a",
          "liniear equation", true);
      dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_PositifNormal_B_NegatifNormal_C_PositifNormal_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 99.67077198479099;
    double b = -242.86956639346477;
    double c = 204.29173294830343;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testSolveA_ProcheDeZeroPositif_B_TresGrandPositif_C_TresProcheDeZeroPositif_()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
      SecurityException, InstantiationException, ClassNotFoundException {
    double a = 3.7688704843453826;
    double b = 1.5467007675425524E8;
    double c = 4.901410144051051E-7;

    Class<?> dynamicClass = Class.forName("com.example.QuadraticEquationSolver");
    Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
    try {
      double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
          .invoke(dynamicObject, a, b, c);
      if (solutions.length > 0) {
        System.out.print("Solutions : ");
        double expected = 0;
        for (double solution : solutions) {
          System.out.print(solution + " ");
          // Use assert for each solution
          expected = (a * (Math.pow(solution, 2))) + (b * solution) + c;
          double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
          double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
          assertEquals(0, expected, delta);
        }
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "" + solutions[0],
            "" + solutions[1], "" + expected, true);
      } else {
        System.out.println("Pas de solution r�elle.");
        // Use assert for the case with no solution
        assertEquals(0, solutions.length);
        writeResultToCSV("(" + a + ")" + "x^2 + " + "(" + b + ")" + "x + " + "(" + c + ")" + " = 0", "N/a", "N/a", " ",
            true);
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

}
