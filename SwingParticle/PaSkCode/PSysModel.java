package PaSkCode;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class PSysModel {
    // ArrayList or similar of particles
    // each particle: x, y, velX, velY, radius

    ArrayList<BallParticles> particles = new ArrayList<>();

    int radius;
    int x;
    int y;
    int velX;
    int velY;
    PSysModel() {
	// instantiate list of particles
        
    }

        // add a particle to list
    void add(int rad, int x, int y, int vx, int vy) {
       
        this.radius = rad;
        this.x = x;
        this.y = y;
        this.velX = vx;
        this.velY = vy;
        
        particles.add(new BallParticles(rad, x, y, vx, vy));
        
        System.out.println("Added: " + rad + " " + x + " " + y + " " + vx + " " + vy);
    }


    // update state of each particle in list
    void update(int bw, int bh) {
        Iterator it =  particles.iterator();
        while(it.hasNext()) {
            BallParticles ball = (BallParticles) it.next();
            
            ball.x += ball.velX;
            ball.y += ball.velY;
            
            if (ball.x >= bw-ball.radius && ball.velX > 0) {
        	ball.velX = -ball.velX;
            }
            else if (ball.x < ball.radius && ball.velX < 0) {
        	ball.velX = -ball.velX;
            }
            if (ball.y >= bh-ball.radius && ball.velY > 0) {
        	ball.velY = -ball.velY;
            }
            else if (ball.y < ball.radius && ball.velY < 0) {
        	ball.velY = -ball.velY;
            }

        }
        
    }
}
