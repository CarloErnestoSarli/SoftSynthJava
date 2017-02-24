package views;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import net.beadsproject.beads.ugens.OscillatorBank;

import javax.swing.event.ChangeEvent;

import source.*;

public class GUI extends JFrame {
	
	Audio audio = Audio.getAudio();
	Settings settings = Settings.getSettings();
	//Settings settings = new Settings();
	//Oscillator oscillator1;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//OSC1 slider
		JSlider slider = new JSlider(0, 1000, 440);
		slider.setMajorTickSpacing(500);
		slider.setMinorTickSpacing(50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				settings.setOsc1Freq((float)source.getValue());
				
			}
		});
		contentPane.add(slider, BorderLayout.WEST);
	}

}
