package source;

import net.beadsproject.beads.core.UGen;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.LPRezFilter;

public class Filter {
	
	Audio audio =  Audio.getAudio();
	
	Glide filterFrequencyGlide  = new Glide(audio.getAudioContext(), 0.0f, 500.0f);
	LPRezFilter lpf;
	
	
	public void LowPass(){
		 lpf = new LPRezFilter(audio.getAudioContext(), filterFrequencyGlide, 0.95f);
	}
	
	public LPRezFilter getLowPass(){
		return lpf;
	}
	
	public void addToLowPass(UGen gen){
		lpf.addInput(gen);
	}
}
