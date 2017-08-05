import com.kasun.app.FractalWindow;
import com.kasun.fractal.AbstractFractal;
import com.kasun.fractal.Julia;
import com.kasun.fractal.Mandelbrot;
import com.kasun.math.Complex;

import javax.swing.*;

public class Fractal {


    public static void main(String[] args) {
        final String MANDELBROT = "Mandelbrot";
        final String JULIA = "Julia";

        String selectedFractal = MANDELBROT; // default
        AbstractFractal fractal = null;
        int iterations = 1000;
        double[] complexPlane = {-1d, 1d, -1d, 1d};
        double realC = -0.4d, imagC = 0.6d;

        // process arguments
        if (args.length > 0) {
            // select fractal type
            switch (args[0].toLowerCase()) {
                case "mandelbrot":
                    selectedFractal = MANDELBROT;
                    break;

                case "julia":
                    selectedFractal = JULIA;
                    break;

                default:
                    System.out.println("Unrecognized fractal type.");
                    showHelp();
                    System.exit(100);
                    break;
            }
        }

        if (selectedFractal == MANDELBROT) {
            // see if no args provided, then this is the default case
            if (args.length == 1) {
                Mandelbrot mandelbrot = new Mandelbrot(complexPlane[0], complexPlane[1], complexPlane[2], complexPlane[3], iterations);
                fractal = mandelbrot;
            } else { // well we have more
                // check there are enough arguments
                if (args.length == 6) { // we have iteration, lets check it out
                    try {
                        iterations = Integer.parseInt(args[5]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number for iterations");
                        System.exit(100);
                    }
                }

                if (args.length <= 6 && args.length > 1) { // we have region of interest
                    for (int i = 1; i <= 4; i++) {
                        try {
                            complexPlane[i - 1] = Double.parseDouble(args[i]);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number for region of interest at index " + i);
                            System.exit(100);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Invalid number of arguments entered.");
                            System.exit(100);
                        }
                    }

                    if (complexPlane[0] < -1d || complexPlane[0] >= complexPlane[1] || complexPlane[1] > 1d
                            || complexPlane[1] <= complexPlane[0] || complexPlane[2] < -1d || complexPlane[2] >= complexPlane[3]
                            || complexPlane[3] > 1d || complexPlane[3] <= complexPlane[2]) {
                        System.out.println("Region of interest must lie between -1 and 1 for real and complex axis.");
                        System.exit(100);
                    }

                    fractal = new Mandelbrot(complexPlane[0], complexPlane[1], complexPlane[2], complexPlane[3], iterations);//set fractal
                }
            }
        }

        if (selectedFractal == JULIA) {
            if (args.length == 1) {
                fractal = new Julia(new Complex(realC, imagC), iterations);
            } else { // we have more data
                if (args.length == 4) {
                    // we have an iteration
                    try {
                        iterations = Integer.parseInt(args[3]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number for iterations");
                        System.exit(100);
                    }
                }

                // we have real and imaginary parts
                if (args.length >= 1 && args.length <= 4) {
                    try {
                        realC = Double.parseDouble(args[1]);
                        imagC = Double.parseDouble(args[2]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number for Complex C in julia");
                        System.exit(100);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Not enough arguments provided");
                        System.exit(100);
                    }
                }

                fractal = new Julia(new Complex(realC, imagC), iterations);
            }
        }

        FractalWindow fractalWindow = new FractalWindow(1200, 800, fractal);
        fractalWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fractalWindow.setLocationRelativeTo(null);
        fractalWindow.setVisible(true);
        fractalWindow.setResizable(false);
    }

    public static void showHelp() {
        System.out.println("Usage :");
        System.out.println("\tjava Fractal");
        System.out.println("\tjava Fractal Mandelbrot|Julia");
        System.out.println("\tjava Fractal Mandelbrot realMin realMax ImagMin ImagMax");
        System.out.println("\tjava Fractal Mandelbrot [realMin realMax ImagMin ImagMax] [Iteration]");
        System.out.println("\tjava Fractal Julia [real imag] [iteration]");
    }
}
