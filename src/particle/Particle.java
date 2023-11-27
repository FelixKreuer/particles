package particle;

import math.Vector3;

import java.awt.*;
import java.util.Random;

public class Particle {
    private final int maxVelocity = 50;
    public Vector3 position;
    public Vector3 velocity;
    public Vector3 acceleration;

    private static final int LIFESPAN = 120;
    private int lifespan;
    private Color color;

    private static final double MAX_INITIAL_VELOCITY = 5.0; // Adjust the maximum initial velocity as needed

    public Particle(Vector3 velocity, Vector3 acceleration, Vector3 position, int lifespan) {
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.position = position;
        this.lifespan = lifespan;
    }

    public Particle(Vector3 velocity, Vector3 acceleration, Vector3 position) {
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.position = position;
        this.lifespan = 255;
    }

    public Particle(Vector3 position) {
        this.position = position;
        this.velocity = generateRandomVelocity();
        this.acceleration = new Vector3();
        this.lifespan = LIFESPAN;
    }
    public Particle() {
        this.position = new Vector3();
        this.velocity = generateRandomVelocity();
        this.acceleration = new Vector3();
        this.lifespan = LIFESPAN;
    }

    public boolean isDead() {
        return lifespan < 0;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Color calculateColor() {
        int r = map(velocity.getX(), -MAX_INITIAL_VELOCITY, MAX_INITIAL_VELOCITY, 0, 255);
        int g = map(velocity.getY(), -maxVelocity, maxVelocity, 0, 255);
        int b = map(velocity.getZ(), -MAX_INITIAL_VELOCITY, MAX_INITIAL_VELOCITY, 0, 255);
        int a = map(lifespan, 0, LIFESPAN, 0, 255);
        return new Color(r, g, b, a);
    }

    public void updateParticle() {
        if(velocity.magnitude() < maxVelocity - 5){
            velocity.add(acceleration);
        }
        position.add(velocity);
        lifespan--;
    }

    private Vector3 generateRandomVelocity() {
        Random rand = new Random();
        float x = (float) (rand.nextFloat() * 2 * MAX_INITIAL_VELOCITY - MAX_INITIAL_VELOCITY);
        float y = (float) (rand.nextFloat() * 2 * MAX_INITIAL_VELOCITY - MAX_INITIAL_VELOCITY);
        float z = (float) (rand.nextFloat() * 2 * MAX_INITIAL_VELOCITY - MAX_INITIAL_VELOCITY);
        return new Vector3(x, y, z);
    }

    private int map(double value, double start1, double end1, int start2, int end2) {
        return (int) (start2 + ((value - start1) / (end1 - start1)) * (end2 - start2));
    }

    @Override
    public String toString() {
        return "particle(" +
                "position=" + position +
                ", velocity=" + velocity +
                ", acceleration=" + acceleration +
                ")";
    }
}
