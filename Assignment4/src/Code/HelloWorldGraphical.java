package Code;


/*
 * Really Awesome Hello World program!
 * Now using Really Awesome Toolkit.
 *
 */


import java.awt.Color;

public class HelloWorldGraphical {

	public static void main(String args[]) {
		WindowSystem windowSystem = WindowSystem.getInstance();

		SimpleWindow helloWorld = windowSystem.createSimpleWindow(0.1, 0.1,
				0.4, 0.6, "Window A");

		RATbutton english = new RATbutton(0.26, 0.1, 0.73, 0.18, "English");
		RATbutton deutsch = new RATbutton(0.26, 0.25, 0.73, 0.32, "Deutsch");
		RATbutton francais = new RATbutton(0.26, 0.38, 0.73, 0.46, "Francais");
		RATbutton end = new RATbutton(0.56, 0.87, 0.93, 0.95, "Beenden");
		
		RATlabel message = new RATlabel(0.43, 0.63, 0.8, 0.8, "Message");

		english.buttonColor = Color.GRAY;
		english.labelColor = Color.white;
		english.addListener(new RATmouseAdaptor(english) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				message.text = "Good Day!";
			}
		});
		helloWorld.add(english);

		deutsch.buttonColor = Color.GRAY;
		deutsch.labelColor = Color.white;
		deutsch.addListener(new RATmouseAdaptor(deutsch) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				message.text = "Guten Tag!";
			}
		});
		helloWorld.add(deutsch);

		francais.buttonColor = Color.GRAY;
		francais.labelColor = Color.white;
		francais.addListener(new RATmouseAdaptor(francais) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				message.text = "Bonne journée!";
			}
		});
		helloWorld.add(francais);

		end.buttonColor = Color.GRAY;
		end.labelColor = Color.white;
		end.addListener(new RATmouseAdaptor(end) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				windowSystem.closeWindow(helloWorld);
			}
		});
		helloWorld.add(end);

		message.labelColor = Color.BLUE;
		helloWorld.add(message);

	}
}
