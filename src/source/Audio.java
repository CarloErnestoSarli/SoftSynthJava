package source;
import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.ugens.Static;

//singleton pattern

public class Audio {

	private static Audio audio = null;
	AudioContext ac;
	
	
	protected Audio()
	{
		ac = new AudioContext();
	}
	
	public static Audio getAudio()
	{
		if(audio == null){
			audio = new Audio();
		}
		return audio;
	}
	
	public AudioContext getAudioContext()
	{
		return ac;
	}
	
}
