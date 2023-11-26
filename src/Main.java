import math.Vector3;
import particle.Particle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    int total;
    ArrayList<Particle> particleList = new ArrayList<>();
    void setup() {
        for (int i = 0; i < total; i++) {
            particleList.add(new Particle());
        }
    }
    public static void main(String[] args) {
        Particle x = new Particle();
        System.out.println(x);
    }
    public void draw(){
        Iterator<Particle> it = particleList.iterator();
        while (it.hasNext()) {
            Particle p = it.next();
            p.updateParticle();
            if(p.isDead()){
                it.remove();
            }
        }
    }
}