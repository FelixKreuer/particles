import math.Vector3;
import particle.Particle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ParticleVisualization extends JPanel {
    private static final int WIDTH = 1400;
    private static final int HEIGHT = 1000;
    private static final Vector3 GRAVITY = new Vector3(0,1,0);
    private int total = 100;  // Adjust the number of particles as needed
    private ArrayList<Particle> particleList = new ArrayList<>();

    public ParticleVisualization() {
        for (int i = 0; i < total; i++) {
            Particle p = new Particle(new Vector3((float) WIDTH /2, (float) HEIGHT /2, 0));
            applyExternalForces(p,GRAVITY);
            particleList.add(p);
        }
    }

    public void updateParticles() {
        Iterator<Particle> it = particleList.iterator();
        while (it.hasNext()) {
            Particle p = it.next();
            p.updateParticle();
            if (p.isDead()) {
                it.remove();
            }
        }
    }
    private void applyExternalForces(Particle particle, Vector3 external) {
        // Gravity affects the particle by adding it to the y-component of acceleration
        particle.acceleration.add(external);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Particle particle : particleList) {
            Color particleColor = particle.calculateColor();
            g.setColor(particleColor);
            g.fillOval((int) particle.getPosition().getX(), (int) particle.getPosition().getY(), 10, 10);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Particle Visualization");
            ParticleVisualization particleVisualization = new ParticleVisualization();
            frame.add(particleVisualization);
            frame.setSize(WIDTH, HEIGHT);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            Timer timer = new Timer(16, e -> {
                particleVisualization.updateParticles();
                particleVisualization.repaint();
            });
            timer.start();
        });
    }
}
