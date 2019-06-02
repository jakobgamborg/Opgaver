package opg3_gui_io;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FileIOGUI extends JFrame {
	private JRadioButton txtRadio;
	private JRadioButton objRadio;
	private ButtonGroup bg;

	private JButton writeButton;
	private JButton readButton;
	private JTextField inputText;
	private JTextArea outputText;


	public FileIOGUI(String title) {
		super(title);
		makeComponents();
	}

	private void makeComponents() {
	}

	// Til opgave d)
	private class ButtonListener implements ActionListener {
		private FileIOInterface fileIO;
		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new FileIOGUI("Opg 3 IO og GUI");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);

	}

}
