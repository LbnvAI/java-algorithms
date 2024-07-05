package org.anton.hexlet.module2.classes;

import lombok.Getter;

@Getter
public class Triangle {
    //**************************************************************************************************************|
    //                                                   Triangle                                                   |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        if (sideA + sideB <= sideC) throw new IllegalArgumentException("illegal side value");
        else if (sideB + sideC <= sideA) throw new IllegalArgumentException("illegal side value");
        else if (sideA + sideC <= sideB) throw new IllegalArgumentException("illegal side value");
        else {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }
    }

    //______________________________________________________________________________________________________________|
    //                                             Hexlet Solution                                                  |

    /*
    @Getter
    public class Triangle {
        private double sideA;
        private double sideB;
        private double sideC;
        Triangle(int sideA, int sideB, int sideC) {
            if (!isValidTriangle(sideA, sideB, sideC)) {
                throw new IllegalArgumentException("Такой треугольник не может существовать");
            }
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }
        private static boolean isValidTriangle(double sideA, double sideB, double sideC) {
            return sideA + sideB > sideC
                    && sideB + sideC > sideA
                    && sideC + sideA > sideB;
        }
    }

     */
}


