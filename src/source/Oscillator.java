package source;
import org.jaudiolibs.jnajack.examples.SineAudioSource;

import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.Envelope;
import net.beadsproject.beads.ugens.WavePlayer;

public class Oscillator {
	
	Settings settings = new Settings();
	Audio audio = Audio.getAudio();

	Buffer sine,square,saw,triangle,noise;
	
	
	
	public Oscillator()
	{
		sine = Buffer.SINE;
		square = Buffer.SQUARE;
		saw = Buffer.SAW;
		triangle = Buffer.TRIANGLE;
		noise = Buffer.NOISE;
		
		
	}
	
	
	public Buffer SelectWave(String wave){
		
		if(wave.equals("Sine")){
			return sine;
		}else if(wave.equals("Square")){
			return square;
		}else if(wave.equals("Saw")){
			return saw;
		}else if(wave.equals("Triangle")){
			return triangle;
		}else if(wave.equals("Noise")){
			return noise;
		}else{
			return sine;
		}
	}
	
	//might not need all this
	public Buffer getSine(){
		return sine;
	}
	
	public Buffer getSquare(){
		return square;
	}
	
	public Buffer getSaw(){
		return saw;
	}
	
	public Buffer getTriangle(){
		return triangle;
	}
	
	public Buffer getNoise(){
		return noise;
	}
}
