/**
 *
 * @author Ouda
 */

//importing the libraries that will be needed in this program

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//the class with button and main method
public class SortGUI {

	// import javax.swing.JFrame;
	public int delayTime = 0;

	//a variable that holds the amount of time for the selection sort takes to execute
	public static double selectionTime = 0.0;
	//a variable that holds the amount of time for the recursive merge sort takes to execute
	public static double rmergeTime = 0.0;
	//a variable that holds the amount of time for the radix sort takes to execute
	public static double radixTime = 0.0;
	//a variable that holds the amount of time for the iterative merge sort takes to execute
	public static double imergeTime = 0.0;
	//a variable that holds the amount of time for the bubble sort takes to execute
	public static double bubbleTime = 0.0;
	//a variable that holds the amount of time for the insertion sort takes to execute
	public static double insertionTime = 0.0;
	public static double shellsortTime = 0.0;
	public static double qsortTime = 0.0;
	//Boolean variable that is made to keep track whether or not the selection sort has already been used
	public boolean Selection_Done = false;
	//Boolean variable that is made to keep track whether or not the recursive merge sort has already been used
	public boolean Recersive_Merge_Done = false;
	//Boolean variable that is made to keep track whether or not the radix sort has already been used
	public boolean Radix_Sort_Done = false;
	//Boolean variable that is made to keep track whether or not the iterative merge sort has already been used
	public boolean Iterative_Merge_Done = false;
	//Boolean variable that is made to keep track whether or not the bubble sort has already been used
	public boolean Bubble_Sort_Done  = false;
	//Boolean variable that is made to keep track whether or not the insertion sort has already been used
	public boolean Insertion_Sort_Done = false;
	//Boolean variable that is made to keep track whether or not the shell sort has already been used
	public boolean Shell_Sort_Done = false;
	//Boolean variable that is made to keep track whether or not the quick sort has already been used
	public boolean Quick_Sort_Done = false;
	//Making an object from the class SortShow
	SortShow sortArea = new SortShow();
	
	//Default constructor for SortGUI
	public SortGUI() {
		//making a MyScreen object

		// You need to adjust the following values to your Screen dimensions

		MyScreen screen = new MyScreen();
		//Setting a title to the GUI window
		screen.setTitle("Assignment-1 by Group13");
		//setting the size of the window 
		screen.setSize(1300+sortArea.total_number_of_lines, 750);
		//the operation when the frame is closed
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//is set to true to display the frame
		screen.setVisible(true);
	}
	//A public class that extends JFrame
	public class MyScreen extends JFrame {
		//making a scramble button with a text "Scramble Lines" on it
		JButton scramble_button = new JButton("Scramble Lines");
		//making a selection button with a text "Selection" on it
		JRadioButton selection = new JRadioButton("Selection");
		//making a recursive merge button with a text "Scramble Lines" on it
		JRadioButton rmerge = new JRadioButton("Merge Recursive");
		//making a radix button with a text "Radix Sort" on it
		JRadioButton radix = new JRadioButton("Radix Sort");
		//making a iterative merge button with a text "Selection" on it
		JRadioButton imerge = new JRadioButton("Merge Iterative");
		//making a bubble sort button with a text "Bubble Sort" on it
		JRadioButton bubble = new JRadioButton("Bubble Sort");
		//making a insertion sort button with a text "Insertion Sort" on it
		JRadioButton insertion = new JRadioButton("Insertion Sort");
		//making a shell sort button with a text "Shell Sort" on it
		JRadioButton shellsort = new JRadioButton("Shell Sort");
		//making a quick sort button with a text "Quick Sort" on it
		JRadioButton qsort = new JRadioButton("Quick Sort");
		//making a reset button with a text "Reset" on it
		JButton reset = new JButton("Reset");
		//A label that displays the time it took for the Selection sort took to execute 
		JLabel selection_time_label = new JLabel("Selection Time");
		JLabel selection_time_taken = new JLabel(""); 
		//A label that displays the time it took for the recursive merge sort took to execute 
		JLabel rmerge_time_label = new JLabel("Merge-Rec Time");
		JLabel rmerge_time_taken = new JLabel("");
		//A label that displays the time it took for the radix sort sort took to execute
		JLabel radix_time_label = new JLabel("Radix Time");
		JLabel radix_time_taken = new JLabel("");
		//A label that displays the time it took for the iterative merge sort took to execute
		JLabel imerge_time_label = new JLabel("Merge-Ita Time");
		JLabel imerge_time_taken = new JLabel("");
		//A label that displays the time it took for the bubble sort took to execute
		JLabel bubble_time_label = new JLabel("Bubble Time");
		JLabel bubble_time_taken = new JLabel("");
		//A label that displays the time it took for the insertion sort took to execute
		JLabel insertion_time_label = new JLabel("Insertion Time");
		JLabel insertion_time_taken = new JLabel("");
		//A label that displays the time it took for the shell sort took to execute
		JLabel shellsort_time_label = new JLabel("Shell-Sort Time");
		JLabel shellsort_time_taken = new JLabel("");
		//A label that displays the time it took for the quick sort took to execute
		JLabel qsort_time_label = new JLabel("Quick-Sort Time");
		JLabel qsort_time_taken = new JLabel("");

		//the default constructor for the class MyScreen
		public MyScreen() {
			JTextField delay = new JTextField("0");
			delay.setSize(new Dimension(6,50));
			delay.setPreferredSize(new Dimension(3,50));
			JPanel delayPanel = new JPanel(new BorderLayout(0,0));
			delayPanel.add(delay, BorderLayout.NORTH);
			delayPanel.setSize(new Dimension(3, 50));
			delayPanel.setPreferredSize(new Dimension(3,50));
			delayPanel.setBorder(new javax.swing.border.TitledBorder("Set Delay"));

			// Panel where sorted lines_lengths will displayed
			//The time displayed for selection sort will be the colour red
			selection_time_taken.setForeground(Color.RED);
			//The time displayed for recursive merge sort will be the colour red
			rmerge_time_taken.setForeground(Color.RED);
			//The time displayed for radix merge sort will be the colour red
			radix_time_taken.setForeground(Color.RED);
			//The time displayed for iterative merge sort will be the colour red
			imerge_time_taken.setForeground(Color.RED);
			//The time displayed for bubble sort will be the colour red
			bubble_time_taken.setForeground(Color.RED);
			//The time displayed for insertion sort will be the colour red
			insertion_time_taken.setForeground(Color.RED);
			//The time displayed for shell sort will be the colour red
			shellsort_time_taken.setForeground(Color.RED);
			//The time displayed for quick sort will be the colour red
			qsort_time_taken.setForeground(Color.RED);
			//The selection button text will be the colour blue
			selection.setForeground(Color.BLUE);
			//The recursive merge button text will be the colour blue
			rmerge.setForeground(Color.BLUE);
			//The radix sort button text will be the colour blue
			radix.setForeground(Color.BLUE);
			//The iterative merge button text will be the colour blue
			imerge.setForeground(Color.BLUE);
			//The bubble sort button text will be the colour blue
			bubble.setForeground(Color.BLUE);
			//The insertion sort button text will be the colour blue
			insertion.setForeground(Color.BLUE);
			//The shell sort button text will be the colour blue
			shellsort.setForeground(Color.BLUE);
			//The quick sort button text will be the colour blue
			qsort.setForeground(Color.BLUE);
			//The scramble button's text will be blue
			scramble_button.setForeground(Color.BLUE);
			//setting the font of scramble button
			scramble_button.setFont(new Font("Arial", Font.BOLD, 15));
			//A Panel to hold the radio_button_selection and set the GridLayout
			JPanel radio_button_selection_Panel = new JPanel(new GridLayout(4, 1, 3, 3));


			//Adding the selection button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(selection);
			//Adding the recursive merge button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(rmerge);
			//Adding the radix sort button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(radix);
			//Adding the iterative merge button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(imerge);
			//Adding the bubble sort button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(bubble);
			//Adding the insertion sort button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(insertion);
			//Adding the shell sort button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(shellsort);
			//Adding the quick sort button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(qsort);
			//Adding the reset button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(reset);
			//giving the radio_button_selection_Panel a border with a title 
			radio_button_selection_Panel.setBorder(new javax.swing.border.TitledBorder("Sort Algorithms"));

			//A Panel to hold the time_Panel and set the GridLayout
			JPanel time_Panel = new JPanel(new GridLayout(8, 2, 5, 1));
			//Adding the selection_time_label to the time_Panel
			time_Panel.add(selection_time_label);
			//Adding the selection_time_taken to the time_Panel
			time_Panel.add(selection_time_taken);
			//Adding the rmerge_time_label to the time_Panel
			time_Panel.add(rmerge_time_label); 
			//Adding the rmerge_time_taken to the time_Panel
			time_Panel.add(rmerge_time_taken);
			//Adding the radix_time_label to the time_Panel
			time_Panel.add(radix_time_label);
			//Adding the radix_time_taken to the time_Panel
			time_Panel.add(radix_time_taken);
			//Adding the imerge_time_label to the time_Panel
			time_Panel.add(imerge_time_label);
			//Adding the imerge_time_taken to the time_Panel
			time_Panel.add(imerge_time_taken);
			//Adding the bubble_time_label to the time_Panel
			time_Panel.add(bubble_time_label);
			//Adding the bubble_time_taken to the time_Panel
			time_Panel.add(bubble_time_taken);
			//Adding the insertion_time_label to the time_Panel
			time_Panel.add(insertion_time_label);
			//Adding the insertion_time_taken to the time_Panel
			time_Panel.add(insertion_time_taken);
			//Adding the shellsort_time_label to the time_Panel
			time_Panel.add(shellsort_time_label);
			//Adding the shellsort_time_taken to the time_Panel
			time_Panel.add(shellsort_time_taken);
			//Adding the qsort_time_label to the time_Panel
			time_Panel.add(qsort_time_label);
			//Adding the qsort_time_taken to the time_Panel
			time_Panel.add(qsort_time_taken);

			//A Panel to hold the buttons_area_Panel and set the GridLayout
			//This buttons_area_Panel will hold scrambleButton, radio_button_selection and the time_Panel
			JPanel buttons_area_Panel = new JPanel(new GridLayout(5, 1, 5, 5));
			//adding scramble_button to the buttons_area_Panel
			buttons_area_Panel.add(scramble_button);
			buttons_area_Panel.add(delayPanel);
			//adding radio_button_selection_Panel to the buttons_area_Panel
			buttons_area_Panel.add(radio_button_selection_Panel);
			//adding time_Panel to the buttons_area_Panel
			buttons_area_Panel.add(time_Panel);

			//placing the buttons_area_Panel to the east side of the window
			add(buttons_area_Panel, BorderLayout.EAST);
			//placing the sortArea object in the center of the window
			add(sortArea, BorderLayout.CENTER);
			//setting all booleans to false
			Set_Available_Chooses(false, false, false, false, false, false, false,false,false);

			//The following code is for creating a listener for each GUI element 

			//Creating an action listener for scramble button
			//This button will be used to scramble the lines in a random way
			//this same scrambled lines will be used for all threes sort methods used in this program
			scramble_button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Scrambling the lines_lengths array
					sortArea.scramble_the_lines(); 
					//Since it has already been clicked, it will no longer be enabled
					scramble_button.setEnabled(false); 
					//setting all booleans true except for reset
					Set_Available_Chooses(true, true, true, true, true, true, true, true,false );
					selection.setSelected(false);
					insertion.setSelected(false);
					rmerge.setSelected(false);
					imerge.setSelected(false);
					bubble.setSelected(false);
					qsort.setSelected(false);
					radix.setSelected(false);
					shellsort.setSelected(false);
					reset.setSelected(false);
				}
			});

			//Creating an action listener for selection button
			selection.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the selection sort method
					delayTime = Integer.parseInt(delay.getText());
					sortArea.SelectionSort(delayTime);
					//Selection sort has finished/been clicked
					Selection_Done = true;
					//The amount of time taken for selection sort took
					selection_time_taken.setText(selectionTime / 1000 + " Seconds");
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false,false,true);
				}
			});

			//Creating an action listener for recursive merge button
			rmerge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the recursive merge sort method
					delayTime = Integer.parseInt(delay.getText());
					sortArea.R_MergeSort(delayTime);
					//The amount of time taken for recursive merge sort took
					rmerge_time_taken.setText((rmergeTime / 1000) + " Seconds");
					//recursive merge sort has finished/been clicked
					Recersive_Merge_Done = true;
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, false,true);
				}
			});

			//Creating an action listener for recursive merge button
			radix.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the recursive merge sort method
					delayTime = Integer.parseInt(delay.getText());
					sortArea.RadixSort(delayTime);
					//The amount of time taken for recursive merge sort took
					radix_time_taken.setText((radixTime / 1000) + " Seconds");
					//recursive merge sort has finished/been clicked
					Radix_Sort_Done = true;
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false,false,true);
				}
			});
			
			//Creating an action listener for iterative merge button
			imerge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the iterative merge sort method
					delayTime = Integer.parseInt(delay.getText());
					sortArea.I_MergeSort(delayTime);
					//The amount of time taken for iterative merge sort took
					imerge_time_taken.setText((imergeTime / 1000) + " Seconds");
					//iterative merge sort has finished/been clicked
					Iterative_Merge_Done = true;
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, false,true);
				}
			});

			shellsort.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Calling shell sort
					delayTime = Integer.parseInt(delay.getText());
					sortArea.shellSortCall(delayTime);
					//Display amount of time taken for shell sort
					shellsort_time_taken.setText((shellsortTime / 1000) + " Seconds");
					//Set to true to indicate completion of the sort
					Shell_Sort_Done = true;
					//Set all choice options to false besides reset
					Set_Available_Chooses(false, false, false, false, false, false, false, false,true);
				}
			});

			qsort.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Calling quick sort
					delayTime = Integer.parseInt(delay.getText());
					sortArea.quickSortCall(delayTime);
					//Display amount of time taken by quick sort
					qsort_time_taken.setText((qsortTime / 1000) + " Seconds");
					//Set to true to indicate completion of the sort
					Quick_Sort_Done = true;
					//Set all choice options to false besides reset
					Set_Available_Chooses(false, false, false, false, false, false, false, false,true);
				}
			});

			//Creating an action listener for bubble sort button
			bubble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)	{
					//Sorting the array in the bubble sort method
					delayTime = Integer.parseInt(delay.getText());
					sortArea.BubbleSort(delayTime);
					//The amount of time taken for iterative merge sort took
					bubble_time_taken.setText((bubbleTime / 1000) + " Seconds");
					//Bubble sort has finished/been clicked
					Bubble_Sort_Done = true;
					//setting all booleans false except for
					Set_Available_Chooses(false, false, false, false, false, false, false, false, true);
				}
			});

			//Creating an action listener for bubble sort button
			insertion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)	{
					//Sorting the array in the bubble sort method
					delayTime = Integer.parseInt(delay.getText());
					sortArea.InsertionSort(delayTime);
					//The amount of time taken for iterative merge sort took
					insertion_time_taken.setText((insertionTime / 1000) + " Seconds");
					//Bubble sort has finished/been clicked
					Insertion_Sort_Done = true;
					//setting all booleans false except for
					Set_Available_Chooses(false, false, false, false, false, false, false, false,true);

				}
			});
			//Creating an action listener for reset button
			reset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//disabling reset since it was clicked
					reset.setEnabled(false);
					//reseting the lines_lengths to its scrambled lines
					sortArea.reset();

					//There are many different combinations of what could be clicked 
					//The following code below covers all possibilities
					//FOr the following use the same comments as above 
					if (Selection_Done && Recersive_Merge_Done && Iterative_Merge_Done && Bubble_Sort_Done && Insertion_Sort_Done && Shell_Sort_Done && Quick_Sort_Done) {
						//
						scramble_button.setEnabled(true);
						Recersive_Merge_Done = false;
						Radix_Sort_Done = false;
						Iterative_Merge_Done = false;
						Shell_Sort_Done = false;
						Quick_Sort_Done = false;
						Selection_Done = false;
						Bubble_Sort_Done = false;
						Insertion_Sort_Done = false;
						Set_Available_Chooses(false, false, false, false, false, false, false, false,false);
						selection_time_taken.setText("");
						rmerge_time_taken.setText("");
						radix_time_taken.setText("");
						imerge_time_taken.setText("");
						bubble_time_taken.setText("");
						insertion_time_taken.setText("");
						shellsort_time_taken.setText("");
						qsort_time_taken.setText("");

					} else {
						boolean oppSel = !Selection_Done;
						boolean oppRMerge = !Recersive_Merge_Done;
						boolean oppIMerge = !Iterative_Merge_Done;
						boolean oppBubble = !Bubble_Sort_Done;
						boolean oppInsertion = !Insertion_Sort_Done;
						boolean oppShell = !Shell_Sort_Done;
						boolean oppQuick = !Quick_Sort_Done;
						boolean oppRadix = !Radix_Sort_Done;
						Set_Available_Chooses(oppSel, oppRMerge, oppIMerge, oppBubble, oppInsertion, oppShell, oppQuick, oppRadix, false);
					}
				}
			});

		}

		//A method that sets if the button are enabled or disabled
		public void Set_Available_Chooses(boolean selection_state, boolean rmerge_state, boolean imerge_state, boolean bubble_state, boolean insertion_state, boolean shellsort_state, boolean quicksort_state, boolean radix_state,
				boolean reset_state) {
			this.selection.setEnabled(selection_state);
			this.rmerge.setEnabled(rmerge_state);
			this.radix.setEnabled(radix_state);
			this.imerge.setEnabled(imerge_state);
			this.bubble.setEnabled(bubble_state);
			this.insertion.setEnabled(insertion_state);
			this.shellsort.setEnabled(shellsort_state);
			this.qsort.setEnabled(quicksort_state);
			this.reset.setEnabled(reset_state);
			//this.reset.repaint();
		}
	}

	//The main method
	public static void main(String[] args) {
		//initialize the class
		SortGUI sort_GUI = new SortGUI();

	}

}







