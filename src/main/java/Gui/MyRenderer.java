package Gui;

import javax.media.opengl.GL2;

import static com.jogamp.opengl.util.ImmModeSink.GL_QUADS;

/**
 * Created by teacher on 10.02.17.
 */
public class MyRenderer {
    // рисование сцены
    public static void drawScene(GL2 gl) {
       
        gl.glBegin(GL_QUADS);

            gl.glVertex2d(-0.5, -0.5);
            gl.glVertex2d(0.5, -0.5);
            gl.glVertex2d(0.5, 0.5);
            gl.glVertex2d(-0.5, 0.5);

        gl.glEnd();
    }

}
