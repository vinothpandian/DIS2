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
		view.labelColor = Color.white;

		RATbutton btn7 = new RATbutton(0.13, 0.33, 0.29, 0.44, "7", 0.2);
		RATbutton btn4 = new RATbutton(0.13, 0.49, 0.29, 0.60, "4", 0.2);
		RATbutton btn1 = new RATbutton(0.13, 0.64, 0.29, 0.74, "1", 0.2);
		RATbutton btn0 = new RATbutton(0.13, 0.80, 0.29, 0.92, "0", 0.2);

		RATbutton btn8 = new RATbutton(0.32, 0.33, 0.48, 0.44, "8", 0.2);
		RATbutton btn5 = new RATbutton(0.32, 0.49, 0.48, 0.60, "5", 0.2);
		RATbutton btn2 = new RATbutton(0.32, 0.64, 0.48, 0.74, "2", 0.2);
		RATbutton btnDecimal = new RATbutton(0.32, 0.80, 0.48, 0.92, ".", 0.2);

		RATbutton btn9 = new RATbutton(0.52, 0.33, 0.67, 0.44, "9", 0.2);
		RATbutton btn6 = new RATbutton(0.52, 0.49, 0.67, 0.60, "6", 0.2);
		RATbutton btn3 = new RATbutton(0.52, 0.64, 0.67, 0.74, "3", 0.2);
		RATbutton btnEquals = new RATbutton(0.52, 0.80, 0.67, 0.92, "=", 0.2);

		RATbutton btnDivide = new RATbutton(0.71, 0.33, 0.86, 0.44, "/", 0.2);
		RATbutton btnMultiply = new RATbutton(0.71, 0.49, 0.86, 0.60, "*", 0.2);
		RATbutton btnMinus = new RATbutton(0.71, 0.64, 0.86, 0.74, "-", 0.2);
		RATbutton btnPlus = new RATbutton(0.71, 0.80, 0.86, 0.92, "+", 0.2);

		btn7.addListener(new RATmouseAdaptor(btn7) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "7";
				view.title = numbers;
			}
		});
		btn4.addListener(new RATmouseAdaptor(btn4) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "4";
				view.title = numbers;
			}
		});
		btn1.addListener(new RATmouseAdaptor(btn1) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "1";
				view.title = numbers;
			}
		});
		btn0.addListener(new RATmouseAdaptor(btn0) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "0";
				view.title = numbers;
			}
		});

		btn8.addListener(new RATmouseAdaptor(btn8) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "8";
				view.title = numbers;
			}
		});
		btn5.addListener(new RATmouseAdaptor(btn5) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "5";
				view.title = numbers;
			}
		});
		btn2.addListener(new RATmouseAdaptor(btn2) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "2";
				view.title = numbers;
			}
		});
		btnDecimal.addListener(new RATmouseAdaptor(btnDecimal) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += ".";
				view.title = numbers;
			}
		});

		btn9.addListener(new RATmouseAdaptor(btn9) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "9";
				view.title = numbers;
			}
		});
		btn6.addListener(new RATmouseAdaptor(btn6) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "6";
				view.title = numbers;
			}
		});
		btn3.addListener(new RATmouseAdaptor(btn3) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += "3";
				view.title = numbers;
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
						view.title = "Don't mess arround with me!!";
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
					view.title = Float.toString(result);
				}
			}
		});

		btnDivide.addListener(new RATmouseAdaptor(btnDivide) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += ";";
				view.title = numbers;
				operators += "/;";
			}
		});
		btnMultiply.addListener(new RATmouseAdaptor(btnMultiply) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += ";";
				view.title = numbers;
				operators += "*;";
			}
		});
		btnMinus.addListener(new RATmouseAdaptor(btnMinus) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += ";";
				view.title = numbers;
				operators += "-;";
			}
		});
		btnPlus.addListener(new RATmouseAdaptor(btnPlus) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				numbers += ";";
				view.title = numbers;
				operators += "+;";
			}
		});

		btn7.color = Color.GRAY;
		btn7.labelColor = Color.PINK;
		btn4.color = Color.GRAY;
		btn4.labelColor = Color.PINK;
		btn1.color = Color.GRAY;
		btn1.labelColor = Color.PINK;
		btn0.color = Color.GRAY;
		btn0.labelColor = Color.PINK;

		btn8.color = Color.GRAY;
		btn8.labelColor = Color.PINK;
		btn5.color = Color.GRAY;
		btn5.labelColor = Color.PINK;
		btn2.color = Color.GRAY;
		btn2.labelColor = Color.PINK;
		btnDecimal.color = Color.GRAY;
		btnDecimal.labelColor = Color.PINK;

		btn9.color = Color.GRAY;
		btn9.labelColor = Color.PINK;
		btn6.color = Color.GRAY;
		btn6.labelColor = Color.PINK;
		btn3.color = Color.GRAY;
		btn3.labelColor = Color.PINK;
		btnEquals.color = Color.GRAY;
		btnEquals.labelColor = Color.PINK;

		btnDivide.color = Color.GRAY;
		btnDivide.labelColor = Color.PINK;
		btnMultiply.color = Color.GRAY;
		btnMultiply.labelColor = Color.PINK;
		btnMinus.color = Color.GRAY;
		btnMinus.labelColor = Color.PINK;
		btnPlus.color = Color.GRAY;
		btnPlus.labelColor = Color.PINK;

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
		view.title = "";
		operators = "";
	}
}
