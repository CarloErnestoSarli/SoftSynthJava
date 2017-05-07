/**
 * @file Main.java
 * @author Carlo Sarli 
 * 
 * This class is used to create the Synthesiser and start the synthesis process
 * It creates the GUI, sets its theme, creates and instance of the synthesizer class, initialises it and starts the program
 **/
import javax.swing.UIManager;

import net.beadsproject.beads.*;

import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.BiquadFilter;
import net.beadsproject.beads.ugens.Envelope;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.Noise;
import net.beadsproject.beads.ugens.WavePlayer;
import views.*;
import source.*;



/**
 * The Class Main.
 */
public class Main {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// sets the UI look and feel
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//Creates an instance of the synthesizer
		Synthesizer synth = new Synthesizer();
		//initialises the synth
		synth.initSynth();
		//initialises objects
		synth.initComponents();
		//starts the synthesis process
		synth.Synthesize();
				
	}
	
}
