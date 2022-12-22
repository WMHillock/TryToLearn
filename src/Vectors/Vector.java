package Vectors;

public interface Vector {
    //Фабричный метод  кста
    static Vector of(double x, double y, double z) {
        if (x == 0 && y == 0 && z == 0) {
            return ZeroVector.INSTANCE;
        }
        return new AnotherVector(x, y, z);
    }
}