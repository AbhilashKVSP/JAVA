package com.myjava;

class Patterns {
    public void Rectangle(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void Hollow(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void HalfPyramid(int row) {
        for (int i = 1; i < row; i++) {
            for (int j = 1; i >= j; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public void InvHalfPyramid(int row) {
        for (int i = row; i >= 1; i--) {
            for (int j = 1; i >= j; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public void Pyramid180Deg(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public void InvPyramid180Deg(int row) {
        for (int i = row; i >= 1; i--) {
            for (int j = 1; j <= row - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public void FloydTriangle(int row) {
        int k = 1;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(k + " ");
                k++;
            }
            System.out.println("");
        }
    }

    public void ZeroOne(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println("");
        }
    }

    public void Rhombus(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= row; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public void NumberPyramid(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    public void PalindromicPyramid(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(i - j);
            }
            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println("");
        }
    }

    public void Butterfly(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= 2 * (row - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (int i = row; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= 2 * (row - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public void Diamond(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (int i = row; i >= 1; i--) {
            for (int j = 1; j <= row - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public void HollowButterfly(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            for (int j = 2 * (row - i); j >= 1; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        for (int i = row; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            for (int j = 2 * (row - i); j >= 1; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    private int fact(int i) {
        int num = 1;
        if (i > 1) {
            for (int j = 1; j <= i; j++) {
                num = num * j;
            }
        }
        return num;
    }

    private int getCoef(int i, int j) {
        int num = 1;
        if (i > j && i >= 1 && j >= 1) {
            num = fact(i) / (fact(i - j) * (fact(j)));
        }
        return num;
    }

    public void PascalTriangle(int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(getCoef(i, j) + " ");
            }
            System.out.println("");
        }
    }

    public void HollowRhombus(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= row; j++) {
                if (i == 1 || i == row) {
                    System.out.print("*");
                } else {
                    if (j == 1 || j == row) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("");
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Patterns pt = new Patterns();
        pt.Rectangle(4, 5);
        System.out.println("\n==========================");
        pt.Hollow(4, 5);
        System.out.println("\n==========================");
        pt.HalfPyramid(5);
        System.out.println("\n==========================");
        pt.InvHalfPyramid(4);
        System.out.println("\n==========================");
        pt.Pyramid180Deg(5);
        System.out.println("\n==========================");
        pt.InvPyramid180Deg(5);
        System.out.println("\n==========================");
        pt.FloydTriangle(5);
        System.out.println("\n==========================");
        pt.ZeroOne(5);
        System.out.println("\n==========================");
        pt.Rhombus(5);
        System.out.println("\n==========================");
        pt.NumberPyramid(5);
        System.out.println("\n==========================");
        pt.Butterfly(4);
        System.out.println("\n==========================");
        pt.PalindromicPyramid(4);
        System.out.println("\n==========================");
        pt.Diamond(4);
        System.out.println("\n==========================");
        pt.HollowButterfly(5);
        System.out.println("\n==========================");
        pt.HollowRhombus(5);
        System.out.println("\n==========================");
        pt.PascalTriangle(5);
    }
}
