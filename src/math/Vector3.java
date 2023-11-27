package math;

import java.util.Objects;

public class Vector3{
    public float x;
    public float y;
    public float z;

    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vector3() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3 vector3 = (Vector3) o;
        return Float.compare(x, vector3.x) == 0 && Float.compare(y, vector3.y) == 0 && Float.compare(z, vector3.z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "Vector3(" + x + ", " + y + ", " + z + ")";
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

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void add(Vector3 that) {
        this.x += that.x;
        this.y += that.y;
        this.z += that.z;
    }

    public void subtract(Vector3 that) {
        this.x -= that.x;
        this.y -= that.y;
        this.z -= that.z;
    }

    public float dotProduct(Vector3 that) {
        return this.x * that.x + this.y * that.y + this.z* that.z;
    }

    public Vector3 crossProduct(Vector3 that) {
        return new Vector3(
            this.y * that.z - this.z * that.y,
            this.z * that.x - this.x * that.z,
            this.x * that.y - this.y * that.x
        );
    }

    public void multiply(float that) {
        this.x *= that;
        this.y *= that;
        this.z *= that;
    }
    public float magnitude(){
        return (float) Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }
}
