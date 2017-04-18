/**
 * @file Audio.java
 * @author Carlo Sarli 
 * 
 * Class to get the unique audioContext for the project
 * @see http://www.beadsproject.net/ for documentation and resources
 */
package source;
import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.ugens.Static;


//singleton pattern

/**
 * The Class Audio is a singleton class
 */
public class Audio {

	/** The audio. */
	private static Audio audio = null;
	
	/** The Unique Audio Context for the project */
	AudioContext ac;
	
	
	/**
	 * Instantiates a new audio and creates the Audio Context.
	 */
	protected Audio()
	{
		ac = new AudioContext();
	}
	
	/**
	 * Gets the audio.
	 *
	 * @return the audio class instance
	 */
	public static Audio getAudio()
	{
		if(audio == null){
			audio = new Audio();
		}
		return audio;
	}
	
	/**
	 * Gets the audio context.
	 *
	 * @return the audio context
	 */
	public AudioContext getAudioContext()
	{
		return ac;
	}
	
}
