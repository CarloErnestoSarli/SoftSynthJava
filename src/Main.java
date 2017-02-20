import net.beadsproject.beads.*;
import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.WavePlayer;
import views.SoftSynthGUI;


public class Main {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SoftSynthGUI gui = new SoftSynthGUI();
		gui.setVisible(true);
		// Hello_Sine.pde
		// import the beads library
		// create our AudioContext
		AudioContext ac;

		// initialize our AudioContext
		ac = new AudioContext();

		// create a WavePlayer
		// WavePlayer objects generate a waveform
		WavePlayer wp = new WavePlayer(ac, 440, Buffer.SINE);

		// connect the WavePlayer to the AudioContext
		ac.out.addInput(wp);

		// start audio processing
		//ac.start();


	}

}
