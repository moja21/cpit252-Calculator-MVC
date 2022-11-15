package calculator;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

// The Controller coordinates interactions
// between the View and Model
public class CalculatorController implements ActionListener {
    /** 
     * The model of this MVC implementation of a calculator. 
     */
	private CalculatorModel model;
	
	/** 
	 * The view of this MVC implementation of a calculator. 
	 */
	private CalculatorView view;
	
	/**
	 * This saves the model and and view.
	 * 
	 * @param model a CalculatorModel for the functions of the calculator and the values
	 * entered by the user
	 * @param view a CalculatorView for what should be displayed in the GUI
	 */
	public CalculatorController(CalculatorModel model, CalculatorView view) {
		this.model = model;
		this.view = view;
	}
	

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("Exit")) {
			System.exit(0);
		} else if (command.equals("Two Decimal Digits")) {
			view.setDigits(2);
			view.update(model.getValue());
		} else if (command.equals("Any Decimal Digits")) {
			view.setDigits(-1);
			view.update(model.getValue());
		} else {
			model.update(command);
			view.update(model.getValue());
		}
	}
}

