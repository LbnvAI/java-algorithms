package org.anton.hexlet.module1;

public class App {
    //**************************************************************************************************************|
    //                                               Last word length                                               |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    public static int getLastWordLength(String line) {
        line = line.trim();
        char[] charLine = line.toCharArray();
        int counter = 0;
        for (int i = charLine.length - 1; i >= 0; i--) {
            if (charLine[i] != ' ') counter++;
            else break;
        }
        return counter;
    }

    //______________________________________________________________________________________________________________|
    //                                             Hexlet Solution                                                  |
    public static int HEXLET_getLastWordLength(String text) {

        var words = text.trim().split(" ");
        var lastWord = words[words.length - 1];

        return lastWord.length();
    }

    //**************************************************************************************************************|
    //                                                 Sea battle                                                   |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    public static int calcShipsCount(int[][] field) {
        if (isValidField(field)) return getHorizontalShipsCount(field) + getVerticalShipsCount(field);
        else return 0;
    }

    public static boolean isValidField(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                // Угловые (дмагональные) проверки
                try {
                    if (field[i][j] == 1 && field[i - 1][j - 1] == 1) return false;
                } catch (Exception ignored) {
                }
                try {
                    if (field[i][j] == 1 && field[i + 1][j + 1] == 1) return false;
                } catch (Exception ignored) {
                }
                try {
                    if (field[i][j] == 1 && field[i - 1][j + 1] == 1) return false;
                } catch (Exception ignored) {
                }
                try {
                    if (field[i][j] == 1 && field[i + 1][j - 1] == 1) return false;
                } catch (Exception ignored) {
                }
                // Вертикально - Горизонтальные проверки
                try {
                    if (field[i][j] == 1 && field[i - 1][j] == 1 && field[i][j + 1] == 1) return false;
                } catch (Exception ignored) {
                }
                try {
                    if (field[i][j] == 1 && field[i + 1][j] == 1 && field[i][j + 1] == 1) return false;
                } catch (Exception ignored) {
                }
                try {
                    if (field[i][j] == 1 && field[i + 1][j] == 1 && field[i][j - 1] == 1) return false;
                } catch (Exception ignored) {
                }
                try {
                    if (field[i][j] == 1 && field[i - 1][j] == 1 && field[i][j - 1] == 1) return false;
                } catch (Exception ignored) {
                }
            }
        }
        return true;
    }

    public static int getHorizontalShipsCount(int[][] field) {
        int horisontalShips = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 1) {
                    if (isOneCellShip(field, i, j)) {
                        horisontalShips++;
                        continue;
                    }
                    if (isVerticalShip(field, i, j)) continue;
                    j = getEndOfHorizontalShip(field[i], j);
                    horisontalShips++;
                }
            }
        }
        return horisontalShips;
    }

    public static int getVerticalShipsCount(int[][] field) {
        int verticalShips = 0;
        for (int j = 0; j < field.length; j++) {
            for (int i = 0; i < field.length; i++) {
                if (field[i][j] == 1) {
                    if (isOneCellShip(field, i, j)) continue;
                    if (isHorizontalShip(field, i, j)) continue;
                    i = getEndOfVerticalShip(field, i, j);
                    verticalShips++;
                }
            }
        }
        return verticalShips;
    }

    public static boolean isOneCellShip(int[][] field, int str, int col) {
        try {
            if (field[str + 1][col] == 1) return false;
        } catch (Exception ignore) {
        }
        try {
            if (field[str - 1][col] == 1) return false;
        } catch (Exception ignore) {
        }
        try {
            if (field[str][col + 1] == 1) return false;
        } catch (Exception ignore) {
        }
        try {
            if (field[str][col - 1] == 1) return false;
        } catch (Exception ignore) {
        }
        return true;
    }

    public static boolean isVerticalShip(int[][] field, int str, int col) {
        try {
            if (field[str + 1][col] == 1) return true;
        } catch (Exception ignore) {
        }
        try {
            if (field[str - 1][col] == 1) return true;
        } catch (Exception ignore) {
        }
        return false;
    }

    public static boolean isHorizontalShip(int[][] field, int str, int col) {
        try {
            if (field[str][col + 1] == 1) return true;
        } catch (Exception ignore) {
        }
        try {
            if (field[str][col - 1] == 1) return true;
        } catch (Exception ignore) {
        }
        return false;
    }

    public static int getEndOfHorizontalShip(int[] line, int pos) {
        int result = pos;
        for (int i = result; i < line.length; i++) {
            if (line[result] == 1) result++;
        }
        return result - 1;
    }

    public static int getEndOfVerticalShip(int[][] field, int strPos, int colPos) {
        int result = strPos;
        for (int i = result; i < field.length; i++) {
            if (field[result][colPos] == 1) result++;
        }
        return result - 1;
    }

    //______________________________________________________________________________________________________________|
    //                                             Hexlet Solution                                                  |
    public static int HEXLET_calcShipsCount(int[][] battleField) {
        var shipsCount = 0;
        var fieldSize = battleField.length;

        for (var row = 0; row < fieldSize; row++) {
            for (var col = 0; col < fieldSize; col++) {
                if (battleField[row][col] == 1 && (col == 0 || battleField[row][col - 1] == 0)) {
                    if (row == 0 || battleField[row - 1][col] == 0) {
                        shipsCount++;
                    }
                }
            }
        }

        return shipsCount;
    }

    public static boolean HEXLET_isValidField(int[][] battleField) {
        var fieldSize = battleField.length;

        for (var col = 0; col < fieldSize; col++) {
            for (var row = 1; row < fieldSize; row++) {
                if (battleField[row][col] == 1) {
                    if (col < fieldSize - 1 && battleField[row - 1][col + 1] == 1
                            || (col != 0 && battleField[row - 1][col - 1] == 1)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    //**************************************************************************************************************|
    //                                               Pascal Triangle                                                |
    //______________________________________________________________________________________________________________|
    //                                          My Solution same as Hexlet                                          |
    public static int[] generate(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = combination(n, i);
        }
        return result;
    }

    public static int fact(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int combination(int n, int k) {
        return fact(n) / (fact(k) * fact(n - k));
    }

    //**************************************************************************************************************|
    //                                                    Snail                                                     |
    //______________________________________________________________________________________________________________|
    //                                                 My Solution                                                  |
    public static int[] buildSnailPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int snailPathPos = 0;
        int pathLength;
        int[] snailPath = new int[matrix.length * matrix[0].length];
        int[][] workMatrix = matrix;
        while (workMatrix.length != 1) {
            pathLength = workMatrix[0].length;
            workMatrix = cutTopLine(workMatrix, snailPath, snailPathPos);
            snailPathPos += pathLength;
            workMatrix = rotateLeft(workMatrix);
        }
        System.arraycopy(workMatrix[0], 0, snailPath, snailPathPos, workMatrix[0].length);
        return snailPath;
    }

    public static int[][] cutTopLine(int[][] matrix, int[] snailPath, int snailPathPos) {
        int[][] cutMatrix = new int[matrix.length - 1][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            snailPath[snailPathPos++] = matrix[0][i];
        }
        for (int i = 0; i < cutMatrix.length; i++) {
            System.arraycopy(matrix[i + 1], 0, cutMatrix[i], 0, cutMatrix[i].length);
        }
        return cutMatrix;
    }

    public static int[][] rotateLeft(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[result.length - 1 - j][i] = matrix[i][j];
            }
        }
        return result;
    }

    //______________________________________________________________________________________________________________|
    //                                             Hexlet Solution                                                  |
    public static int[][] rotate(int[][] matrix) {
        var rowsCount = matrix.length;

        if (rowsCount == 0) {
            return new int[0][0];
        }

        var columnsCount = matrix[0].length;
        var rotatedMatrix = new int[columnsCount][rowsCount];

        for (var row = 0; row < columnsCount; row++) {
            rotatedMatrix[row] = new int[rowsCount];
            for (var column = 0; column < rowsCount; column++) {
                rotatedMatrix[row][column] = matrix[column][columnsCount - row - 1];
            }
        }
        return rotatedMatrix;
    }

    /*
    public static int[] HEXLET_buildSnailPath(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        var head = matrix[0];
        var tail = Arrays.copyOfRange(matrix, 1, matrix.length);

        int[][] result = {
                head,
                buildSnailPath(rotate(tail)),
        };

        // flatten is method, created by hexlet
        //return flatten(result);
    }

     */
    //**************************************************************************************************************|
    //                                                    Snail                                                     |
    //______________________________________________________________________________________________________________|
    //                                          My Solution same as Hexlet                                          |
    public static boolean isContinuousSequence(int[] sequence) {
        if (sequence.length <= 2) return false;
        for (int i = 0; i < sequence.length - 1; i++) {
            if (sequence[i + 1] - sequence[i] != 1) return false;
        }
        return true;
    }
}
