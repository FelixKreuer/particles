package math;

public class Vector2 {

    public float x;
    public float y;
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2() {
        this.x = 0;
        this.y = 0;
    }

    public String toString() {
        return "Vector2(" + x + ", " + y + ")";
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void add(Vector2 that) {
        this.x += that.x;
        this.y += that.y;
    }

    public void subtract(Vector2 that) {
        this.x -= that.x;
        this.y -= that.y;
    }
    public float dotProduct(Vector2 that) {
        return this.x * that.x + this.y * that.y;
    }
    public void multiply(float that) {
        this.x *= that;
        this.y *= that;
    }
}
