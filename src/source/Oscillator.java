package source;
import org.jaudiolibs.jnajack.examples.SineAudioSource;

import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.Envelope;
import net.beadsproject.beads.ugens.WavePlayer;

public class Oscillator {
	
	Settings settings = new Settings();
	Audio audio = Audio.getAudio();

	WavePlayer sine,square,saw,triangle,noise;
	
	
	
	public Oscillator()
	{
		sine = new WavePlayer(audio.getAudioContext(),settings.START_FREQ,Buffer.SINE);
		square = new WavePlayer(audio.getAudioContext(),settings.START_FREQ,Buffer.SQUARE);
		saw = new WavePlayer(audio.getAudioContext(),settings.START_FREQ,Buffer.SAW);
		triangle = new WavePlayer(audio.getAudioContext(),settings.START_FREQ,Buffer.TRIANGLE);
		noise = new WavePlayer(audio.getAudioContext(),settings.START_FREQ,Buffer.NOISE);
		
		
	}
	
	
	public WavePlayer SelectWave(String wave){
		
		if(wave.equals("sine")){
			return sine;
		}else if(wave.equals("square")){
			return square;
		}else if(wave.equals("saw")){
			return saw;
		}else if(wave.equals("triangle")){
			return triangle;
		}else if(wave.equals("noise")){
			return noise;
		}else{
			return sine;
		}
	}
	
	//might not need all this
	public WavePlayer getSine(){
		return sine;
	}
	
	public WavePlayer getSquare(){
		return square;
	}
	
	public WavePlayer getSaw(){
		return saw;
	}
	
	public WavePlayer getTriangle(){
		return triangle;
	}
	
	public WavePlayer getNoise(){
		return noise;
	}
}
