package Code;
/*
*
* Really Awesome Calculator !
* Performs simple arithmetic in style using Really Awesome Toolkit
*
*
* */
import java.awt.Color;

public class ExpertApp {

	public static String numbers;
	public static String operators;

	private static String display;
	private static String input;
	private static Boolean reset;
	private static Boolean afterEquals;

	public static void main(String[] args) {

		display = "";
		input = "";
		reset = false;
		afterEquals = false;

		WindowSystem windowSystem = WindowSystem.getInstance();

		SimpleWindow ratulator = windowSystem.createSimpleWindow(0.1, 0.1, 0.4,
				0.6, "RATulator");
		ratulator.color = Color.white;
		RATlabel view = new RATlabel(0.13, 0.17, 0.8, 0.8, "");
		view.labelColor = Color.black;

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
				if (reset || afterEquals) {
					reset = false;
					afterEquals = false;
					
					input = "7";
					display = "7";
				} else {
					input += "7";
					display += "7";
				}
				view.text = display;
			}
		});
		btn4.addListener(new RATmouseAdaptor(btn4) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				if (reset || afterEquals) {
					reset = false;
					afterEquals = false;
					
					input = "4";
					display = "4";
				} else {
					input += "4";
					display += "4";
				}
				view.text = display;
			}
		});
		btn1.addListener(new RATmouseAdaptor(btn1) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				if (reset || afterEquals) {
					reset = false;
					afterEquals = false;
					
					input = "1";
					display = "1";
				} else {
					input += "1";
					display += "1";
				}
				view.text = display;
			}
		});
		btn0.addListener(new RATmouseAdaptor(btn0) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				if (reset || afterEquals) {
					reset = false;
					afterEquals = false;
					
					input = "0";
					display = "0";
				} else {
					input += "0";
					display += "0";
				}
				view.text = display;
			}
		});

		btn8.addListener(new RATmouseAdaptor(btn8) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				if (reset || afterEquals) {
					reset = false;
					afterEquals = false;
					
					input = "8";
					display = "8";
				} else {
					input += "8";
					display += "8";
				}
				view.text = display;
			}
		});
		btn5.addListener(new RATmouseAdaptor(btn5) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				if (reset || afterEquals) {
					reset = false;
					afterEquals = false;
					
					input = "5";
					display = "5";
				} else {
					input += "5";
					display += "5";
				}
				view.text = display;
			}
		});
		btn2.addListener(new RATmouseAdaptor(btn2) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				if (reset || afterEquals) {
					reset = false;
					afterEquals = false;
					
					input = "2";
					display = "2";
				} else {
					input += "2";
					display += "2";
				}
				view.text = display;
			}
		});
		btnDecimal.addListener(new RATmouseAdaptor(btnDecimal) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				if (reset || afterEquals) {
					reset = false;
					afterEquals = false;
					
					input = ".";
					display = ".";
				} else {
					input += ".";
					display += ".";
				}
				view.text = display;
			}
		});

		btn9.addListener(new RATmouseAdaptor(btn9) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				if (reset || afterEquals) {
					reset = false;
					afterEquals = false;
					
					input = "9";
					display = "9";
				} else {
					input += "9";
					display += "9";
				}
				view.text = display;
			}
		});
		btn6.addListener(new RATmouseAdaptor(btn6) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				if (reset || afterEquals) {
					reset = false;
					afterEquals = false;
					
					input = "6";
					display = "6";
				} else {
					input += "6";
					display += "6";
				}
				view.text = display;
			}
		});
		btn3.addListener(new RATmouseAdaptor(btn3) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				if (reset || afterEquals) {
					reset = false;
					afterEquals = false;
					
					input = "3";
					display = "3";
				} else {
					input += "3";
					display += "3";
				}
				view.text = display;
			}
		});
		btnEquals.addListener(new RATmouseAdaptor(btnEquals) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				String[] splittedInput = input.split(";");

				if (splittedInput.length > 1) {
					// do calculation
					float operand1 = 0.0f;
					float operand2 = 0.0f;

					try {
						operand1 = Float.parseFloat(splittedInput[0]);
						operand2 = Float.parseFloat(splittedInput[2]);

						input = "";
						display = "";

						if (splittedInput[1].equalsIgnoreCase("/")) {
							input = Float.toString(operand1 / operand2);
						} else if (splittedInput[1].equalsIgnoreCase("*")) {
							input = Float.toString(operand1 * operand2);
						} else if (splittedInput[1].equalsIgnoreCase("-")) {
							input = Float.toString(operand1 - operand2);
						} else if (splittedInput[1].equalsIgnoreCase("+")) {
							input = Float.toString(operand1 + operand2);
						}
						display = input;
						view.text = display;
						afterEquals = true;
					} catch (Exception e) {
						view.text = "Syntax error!!";
						reset = true;
					}
				} else {
					view.text = display;
				}
			}
		});

		btnDivide.addListener(new RATmouseAdaptor(btnDivide) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				String[] splittedInput = input.split(";");

				if (splittedInput.length > 1) {
					// do calculation
					float operand1 = 0.0f;
					float operand2 = 0.0f;

					try {
						operand1 = Float.parseFloat(splittedInput[0]);
						operand2 = Float.parseFloat(splittedInput[2]);

						input = "";
						display = "";

						if (splittedInput[1].equalsIgnoreCase("/")) {
							input = Float.toString(operand1 / operand2);
						} else if (splittedInput[1].equalsIgnoreCase("*")) {
							input = Float.toString(operand1 * operand2);
						} else if (splittedInput[1].equalsIgnoreCase("-")) {
							input = Float.toString(operand1 - operand2);
						} else if (splittedInput[1].equalsIgnoreCase("+")) {
							input = Float.toString(operand1 + operand2);
						}
						display = input;
						view.text = display;
					} catch (Exception e) {
						view.text = "Syntax error!!";
						reset = true;
					}
				} else {
					input += ";/;";
					display += "/";
					view.text = display;
				}
				afterEquals = false;				
			}
		});
		btnMultiply.addListener(new RATmouseAdaptor(btnMultiply) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {

				String[] splittedInput = input.split(";");

				if (splittedInput.length > 1) {
					// do calculation
					float operand1 = 0.0f;
					float operand2 = 0.0f;

					try {
						operand1 = Float.parseFloat(splittedInput[0]);
						operand2 = Float.parseFloat(splittedInput[2]);

						input = "";
						display = "";

						if (splittedInput[1].equalsIgnoreCase("/")) {
							input = Float.toString(operand1 / operand2);
						} else if (splittedInput[1].equalsIgnoreCase("*")) {
							input = Float.toString(operand1 * operand2);
						} else if (splittedInput[1].equalsIgnoreCase("-")) {
							input = Float.toString(operand1 - operand2);
						} else if (splittedInput[1].equalsIgnoreCase("+")) {
							input = Float.toString(operand1 + operand2);
						}
						display = input;
						view.text = display;
					} catch (Exception e) {
						view.text = "Syntax error!!";
						reset = true;
					}
				} else {
					input += ";*;";
					display += "*";
					view.text = display;
				}
				afterEquals = false;
			}
		});
		btnMinus.addListener(new RATmouseAdaptor(btnMinus) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				String[] splittedInput = input.split(";");

				if (splittedInput.length > 1) {
					// do calculation
					float operand1 = 0.0f;
					float operand2 = 0.0f;

					try {
						operand1 = Float.parseFloat(splittedInput[0]);
						operand2 = Float.parseFloat(splittedInput[2]);

						input = "";
						display = "";

						if (splittedInput[1].equalsIgnoreCase("/")) {
							input = Float.toString(operand1 / operand2);
						} else if (splittedInput[1].equalsIgnoreCase("*")) {
							input = Float.toString(operand1 * operand2);
						} else if (splittedInput[1].equalsIgnoreCase("-")) {
							input = Float.toString(operand1 - operand2);
						} else if (splittedInput[1].equalsIgnoreCase("+")) {
							input = Float.toString(operand1 + operand2);
						}
						display = input;
						view.text = display;
					} catch (Exception e) {
						view.text = "Syntax error!!";
						reset = true;
					}
				} else {
					input += ";-;";
					display += "-";
					view.text = display;
				}
				afterEquals = false;
			}
		});
		btnPlus.addListener(new RATmouseAdaptor(btnPlus) {
			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				String[] splittedInput = input.split(";");

				if (splittedInput.length > 1) {
					// do calculation
					float operand1 = 0.0f;
					float operand2 = 0.0f;

					try {
						operand1 = Float.parseFloat(splittedInput[0]);
						operand2 = Float.parseFloat(splittedInput[2]);

						input = "";
						display = "";

						if (splittedInput[1].equalsIgnoreCase("/")) {
							input = Float.toString(operand1 / operand2);
						} else if (splittedInput[1].equalsIgnoreCase("*")) {
							input = Float.toString(operand1 * operand2);
						} else if (splittedInput[1].equalsIgnoreCase("-")) {
							input = Float.toString(operand1 - operand2);
						} else if (splittedInput[1].equalsIgnoreCase("+")) {
							input = Float.toString(operand1 + operand2);
						}
						display = input;
						view.text = display;
					} catch (Exception e) {
						view.text = "Syntax error!!";
						reset = true;
					}
				} else {
					input += ";+;";
					display += "+";
					view.text = display;
				}
				afterEquals = false;
			}
		});

		btn7.buttonColor = new Color(0.9f,0.9f,0.9f);
		btn7.labelColor = Color.black;
		btn4.buttonColor  = new Color(0.9f,0.9f,0.9f);
		btn4.labelColor = Color.black;
		btn1.buttonColor  = new Color(0.9f,0.9f,0.9f);
		btn1.labelColor = Color.black;
		btn0.buttonColor  = new Color(0.9f,0.9f,0.9f);
		btn0.labelColor = Color.black;

		btn8.buttonColor  = new Color(0.9f,0.9f,0.9f);
		btn8.labelColor = Color.black;
		btn5.buttonColor  = new Color(0.9f,0.9f,0.9f);
		btn5.labelColor = Color.black;
		btn2.buttonColor  = new Color(0.9f,0.9f,0.9f);
		btn2.labelColor = Color.black;
		btnDecimal.buttonColor  = new Color(0.9f,0.9f,0.9f);
		btnDecimal.labelColor = Color.black;

		btn9.buttonColor  = new Color(0.9f,0.9f,0.9f);
		btn9.labelColor = Color.black;
		btn6.buttonColor  = new Color(0.9f,0.9f,0.9f);
		btn6.labelColor = Color.black;
		btn3.buttonColor  = new Color(0.9f,0.9f,0.9f);
		btn3.labelColor = Color.black;
		btnEquals.buttonColor  = new Color(0.9f,0.9f,0.9f);
		btnEquals.labelColor = Color.black;

		btnDivide.buttonColor  = new Color(0.9f,0.9f,0.9f);
		btnDivide.labelColor = Color.black;
		btnMultiply.buttonColor  = new Color(0.9f,0.9f,0.9f);
		btnMultiply.labelColor = Color.black;
		btnMinus.buttonColor  = new Color(0.9f,0.9f,0.9f);
		btnMinus.labelColor = Color.black;
		btnPlus.buttonColor  = new Color(0.9f,0.9f,0.9f);
		btnPlus.labelColor = Color.black;

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
	}
}
