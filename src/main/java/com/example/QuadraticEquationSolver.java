package com.example;

// Classe QuadraticEquationSolver implémentant l'interface EquationSolver
public class QuadraticEquationSolver implements IEquationSolver {
    @Override
    public double[] solve(double a, double b, double c) {
        double tolerance = 1e-5;
        if (Math.abs(a) < tolerance) {
            throw new IllegalArgumentException("Coefficient 'a' must be non-zero for a quadratic equation.");
        }

        // Calcul du discriminant
        double discriminant = b * b - 4 * a * c;
        double[] solutions;

        if (discriminant > 0) {
            // Deux solutions réelles distinctes
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            solutions = new double[] { x1, x2 };
        } else if (discriminant == 0) {
            // Une solution réelle unique
            // envoyer x deux fois
            double x = -b / (2 * a);
            solutions = new double[] { x, x };
        } else {
            // Pas de solution réelle
            solutions = new double[0]; // Tableau vide pour indiquer aucune solution
        }

        return solutions;
    }

    public static void main(String[] args) {
        IEquationSolver solver = new QuadraticEquationSolver();

        // Exemple d'utilisation
        double a = -1.5171410532737735;
        double b = 9.95893810519504E8;
        double c = 1.1416180209259617;

        try {
            double[] solutions = solver.solve(a, b, c);

            if (solutions.length > 0) {
                System.out.print("Solutions : ");
                for (double solution : solutions) {
                    System.out.print(solution + " ");
                }
            } else {
                System.out.println("Pas de solution réelle.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}