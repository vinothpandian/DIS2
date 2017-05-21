package Code;

import java.awt.*;

/**
 * Created by vinot on 5/21/2017.
 */
public class HelloWorldGraphical {

    public static void main(String args[]){
        WindowSystem windowSystem = WindowSystem.getInstance();

        SimpleWindow helloWorld = windowSystem.createSimpleWindow(0.1,0.1,0.4,0.6, "Window A");

        RATbutton english = new RATbutton(0.2,0.2,0.8,0.4,"English", 0.2);
        RATbutton german = new RATbutton(0,0.8,1,1,"German", 0.4);
        RATlabel message = new RATlabel(0.5,0.5,0.8,0.8,"Message");


        english.color = Color.red;
        english.labelColor = Color.white;
        english.addListener(new RATmouseListener() {
            @Override
            public void mouseClicked(Dimension click, RATmouseEvent event) {
                message.title = "English";
            }

            @Override
            public void mousePressed(Dimension click, RATmouseEvent event) {

            }

            @Override
            public void mouseReleased(Dimension click, RATmouseEvent event) {

            }

            @Override
            public void mouseMoved(Dimension click, RATmouseEvent event) {

            }

            @Override
            public void mouseDragged(Dimension click, RATmouseEvent event) {

            }
        });
        helloWorld.add(english);


        german.color = Color.green;
        german.labelColor = Color.black;
        german.addListener(new RATmouseListener() {
            @Override
            public void mouseClicked(Dimension click, RATmouseEvent event) {
                message.title = "German";
            }

            @Override
            public void mousePressed(Dimension click, RATmouseEvent event) {

            }

            @Override
            public void mouseReleased(Dimension click, RATmouseEvent event) {

            }

            @Override
            public void mouseMoved(Dimension click, RATmouseEvent event) {

            }

            @Override
            public void mouseDragged(Dimension click, RATmouseEvent event) {

            }
        });
        helloWorld.add(german);


        message.color = Color.blue;
        helloWorld.add(message);

    }
}
