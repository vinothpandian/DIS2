package Code;

import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;

public class ExpertApp {

	public static String numbers;
	public static String operators;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowSystem windowSystem = WindowSystem.getInstance();

		SimpleWindow ratulator = windowSystem.createSimpleWindow(0.1, 0.1, 0.4,
				0.6, "RATulator");
		RATlabel view = new RATlabel(0.13, 0.17, 0.8, 0.8, "");
		view.color = Color.white;

		RATbutton btn7 = new RATbutton(0.13, 0.33, 0.29, 0.44, "7");
		RATbutton btn4 = new RATbutton(0.13, 0.49, 0.29, 0.60, "4");
		RATbutton btn1 = new RATbutton(0.13, 0.64, 0.29, 0.74, "1");
		RATbutton btn0 = new RATbutton(0.13, 0.80, 0.29, 0.92, "0");

		RATbutton btn8 = new RATbutton(0.32, 0.33, 0.48, 0.44, "8");
		RATbutton btn5 = new RATbutton(0.32, 0.49, 0.48, 0.60, "5");
		RATbutton btn2 = new RATbutton(0.32, 0.64, 0.48, 0.74, "2");
		RATbutton btnDecimal = new RATbutton(0.32, 0.80, 0.48, 0.92, ".");

		RATbutton btn9 = new RATbutton(0.52, 0.33, 0.67, 0.44, "9");
		RATbutton btn6 = new RATbutton(0.52, 0.49, 0.67, 0.60, "6");
		RATbutton btn3 = new RATbutton(0.52, 0.64, 0.67, 0.74, "3");
		RATbutton btnEquals = new RATbutton(0.52, 0.80, 0.67, 0.92, "=");

		RATbutton btnDivide = new RATbutton(0.71, 0.33, 0.86, 0.44, "/");
		RATbutton btnMultiply = new RATbutton(0.71, 0.49, 0.86, 0.60, "*");
		RATbutton btnMinus = new RATbutton(0.71, 0.64, 0.86, 0.74, "-");
		RATbutton btnPlus = new RATbutton(0.71, 0.80, 0.86, 0.92, "+");

		btn7.addListener(new RATmouseAdaptor(btn7) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "7";
				view.text = numbers;
			}
		});
		btn4.addListener(new RATmouseAdaptor(btn4) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "4";
				view.text = numbers;
			}
		});
		btn1.addListener(new RATmouseAdaptor(btn1) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "1";
				view.text = numbers;
			}
		});
		btn0.addListener(new RATmouseAdaptor(btn0) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "0";
				view.text = numbers;
			}
		});

		btn8.addListener(new RATmouseAdaptor(btn8) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "8";
				view.text = numbers;
			}
		});
		btn5.addListener(new RATmouseAdaptor(btn5) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "5";
				view.text = numbers;
			}
		});
		btn2.addListener(new RATmouseAdaptor(btn2) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "2";
				view.text = numbers;
			}
		});
		btnDecimal.addListener(new RATmouseAdaptor(btnDecimal) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += ".";
				view.text = numbers;
			}
		});

		btn9.addListener(new RATmouseAdaptor(btn9) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "9";
				view.text = numbers;
			}
		});
		btn6.addListener(new RATmouseAdaptor(btn6) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "6";
				view.text = numbers;
			}
		});
		btn3.addListener(new RATmouseAdaptor(btn3) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "3";
				view.text = numbers;
			}
		});
		btnEquals.addListener(new RATmouseAdaptor(btnEquals) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {

				String[] tempNumbers;
				String[] tempOperators;
				tempNumbers = numbers.split(";");
				tempOperators = operators.split(";");

				float result = 0.0f;
				int counter = 0;
				for (String operator : tempOperators) {
					float number1 = 0.0f;
					float number2 = 0.0f;

					try {
						if (counter == 0) {
							number1 = Float.parseFloat(tempNumbers[counter]);
						} else {
							number1 = result;
						}
						number2 = Float.parseFloat(tempNumbers[counter + 1]);
					} catch (Exception e) {
						view.text = "Don't mess arround with me!!";
						counter = 100000;
						break;
					}

					if (operator.equalsIgnoreCase("/")) {
						result = number1 / number2;
					} else if (operator.equalsIgnoreCase("*")) {
						result = number1 * number2;
					} else if (operator.equalsIgnoreCase("-")) {
						result = number1 - number2;
					} else if (operator.equalsIgnoreCase("+")) {
						result = number1 + number2;
					}
					counter += 1;
				}

				operators = "";
				numbers = "";

				if (counter != 100000) {
					view.text = Float.toString(result);
				}
			}
		});

		btnDivide.addListener(new RATmouseAdaptor(btnDivide) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += ";";
				view.text = numbers;
				operators += "/;";
			}
		});
		btnMultiply.addListener(new RATmouseAdaptor(btnMultiply) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += ";";
				view.text = numbers;
				operators += "*;";
			}
		});
		btnMinus.addListener(new RATmouseAdaptor(btnMinus) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += ";";
				view.text = numbers;
				operators += "-;";
			}
		});
		btnPlus.addListener(new RATmouseAdaptor(btnPlus) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += ";";
				view.text = numbers;
				operators += "+;";
			}
		});

		btn7.buttonColor = Color.white;
		btn7.color = Color.black;
		btn4.buttonColor = Color.white;
		btn4.color = Color.black;
		btn1.buttonColor = Color.white;
		btn1.color = Color.black;
		btn0.buttonColor = Color.white;
		btn0.color = Color.black;

		btn8.buttonColor = Color.white;
		btn8.color = Color.black;
		btn5.buttonColor = Color.white;
		btn5.color = Color.black;
		btn2.buttonColor = Color.white;
		btn2.color = Color.black;
		btnDecimal.buttonColor = Color.white;
		btnDecimal.color = Color.black;

		btn9.buttonColor = Color.white;
		btn9.color = Color.black;
		btn6.buttonColor = Color.white;
		btn6.color = Color.black;
		btn3.buttonColor = Color.white;
		btn3.color = Color.black;
		btnEquals.buttonColor = Color.white;
		btnEquals.color = Color.black;

		btnDivide.buttonColor = Color.white;
		btnDivide.color = Color.black;
		btnMultiply.buttonColor = Color.white;
		btnMultiply.color = Color.black;
		btnMinus.buttonColor = Color.white;
		btnMinus.color = Color.black;
		btnPlus.buttonColor = Color.white;
		btnPlus.color = Color.black;

		ratulator.add(view);
		ratulator.add(btn7);
		ratulator.add(btn4);
		ratulator.add(btn1);
		ratulator.add(btn0);

		ratulator.add(btn8);
		ratulator.add(btn5);
		ratulator.add(btn2);
		ratulator.add(btnDecimal);

		ratulator.add(btn9);
		ratulator.add(btn6);
		ratulator.add(btn3);
		ratulator.add(btnEquals);

		ratulator.add(btnDivide);
		ratulator.add(btnMultiply);
		ratulator.add(btnMinus);
		ratulator.add(btnPlus);

		numbers = "";
		view.text = "";
		operators = "";
	}
}
