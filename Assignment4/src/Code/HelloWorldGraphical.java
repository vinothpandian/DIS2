package Code;

import java.awt.*;

/**
 * Created by vinot on 5/21/2017.
 */
public class HelloWorldGraphical {

	public static void main(String args[]) {
		WindowSystem windowSystem = WindowSystem.getInstance();

		SimpleWindow helloWorld = windowSystem.createSimpleWindow(0.1, 0.1,
				0.4, 0.6, "Window A");

		RATbutton english = new RATbutton(0.26, 0.1, 0.73, 0.18, "English", 0.2);
		RATbutton deutsch = new RATbutton(0.26, 0.25, 0.73, 0.32, "Deutsch",
				0.2);
		RATbutton francais = new RATbutton(0.26, 0.38, 0.73, 0.46, "Francais",
				0.2);
		RATbutton end = new RATbutton(0.56, 0.87, 0.93, 0.95, "Beenden",
				0.2);
		
		RATlabel message = new RATlabel(0.43, 0.63, 0.8, 0.8, "Message");

		english.color = Color.GRAY;
		english.labelColor = Color.white;
		english.addListener(new RATmouseListener() {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				message.title = "Good Day!";
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

		deutsch.color = Color.GRAY;
		deutsch.labelColor = Color.white;
		deutsch.addListener(new RATmouseListener() {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				message.title = "Guten Tag!";
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
		helloWorld.add(deutsch);

		francais.color = Color.GRAY;
		francais.labelColor = Color.white;
		francais.addListener(new RATmouseListener() {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				message.title = "Bonjour or whatever it is!";
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
		helloWorld.add(francais);
				
		end.color = Color.GRAY;
		end.labelColor = Color.white;
		end.addListener(new RATmouseListener() {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				
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
		helloWorld.add(end);

		message.color = Color.BLUE;
		helloWorld.add(message);

	}
}
