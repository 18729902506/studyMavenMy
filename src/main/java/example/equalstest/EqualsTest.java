package example.equalstest;

import java.util.Objects;

public class EqualsTest {

    private int x;
    private int y;

    public EqualsTest() {
    }

    public EqualsTest(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualsTest that = (EqualsTest) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
