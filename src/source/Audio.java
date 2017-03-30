/*
 * @author Carlo Sarli 
 * 
 */
package source;
import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.ugens.Static;

// TODO: Auto-generated Javadoc
//singleton pattern

/**
 * The Class Audio.
 */
public class Audio {

	/** The audio. */
	private static Audio audio = null;
	
	/** The ac. */
	AudioContext ac;
	
	
	/**
	 * Instantiates a new audio.
	 */
	protected Audio()
	{
		ac = new AudioContext();
	}
	
	/**
	 * Gets the audio.
	 *
	 * @return the audio
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
