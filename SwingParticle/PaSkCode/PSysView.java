package PaSkCode;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Iterator;

public class PSysView {

    PSysView() {
    }

    // draw all particles in psm
    void draw(PSysModel psm, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHints(
            new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        g2d.setColor(Color.RED);
        /**
        for(int i = 0; i <= psm.particles.size() - 1; i++) {
            if(i == 0) {
                g2d.fillOval(psm.particles.get(i+4) - psm.particles.get(i), psm.particles.get(i+3) - psm.particles.get(i), psm.particles.get(i)*2, psm.particles.get(i)*2);
            }
            else if(i % 5 == 0) {
                g2d.fillOval(psm.particles.get(i) - psm.particles.get(i), psm.particles.get(i-3) - psm.particles.get(i), psm.particles.get(i)*2, psm.particles.get(i)*2);
            }
        }
        **/
        Iterator it =  psm.particles.iterator();
		while(it.hasNext()){
			BallParticles ball = (BallParticles) it.next();
			g2d.fillOval(ball.x - ball.radius, ball.y - ball.radius, ball.radius*2, ball.radius*2);
		}
    }

    // dump information on all particles in psm
    void dump(PSysModel psm, int lc) {
        System.out.println("Frame " + lc);
        Iterator it = psm.particles.iterator();
        
        while(it.hasNext()) {
            BallParticles ball = (BallParticles) it.next();
            System.out.println(ball.radius + " " + ball.x + " " + ball.y + " " + ball.velX + " " + ball.velY);   
        }
        
        /**for(int i = 0; i <= psm.particles.size(); i++) {
            if(i % 5 == 0) {
                System.out.println(psm.particles.get(i) + "\n");
            }
            else {
                System.out.println(psm.particles.get(i));
            }
        } **/
    }
}
