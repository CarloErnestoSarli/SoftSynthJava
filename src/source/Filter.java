/**
 * @file Filter.java
 * @author Carlo Sarli 
 * 
 */
package source;

import net.beadsproject.beads.core.UGen;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.AllpassFilter;
import net.beadsproject.beads.ugens.BiquadFilter;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.LPRezFilter;
import net.beadsproject.beads.ugens.WavePlayer;

// TODO: Auto-generated Javadoc
/**
 * The Class Filter.
 */
public class Filter {
	
	/** The audio. */
	Audio audio =  Audio.getAudio();
	
	/** The filter frequency glide. */
	Glide filterFrequencyGlide  = new Glide(audio.getAudioContext(), 0.0f, 500.0f);
	
	/** The filter resonance glide. */
	Glide filterResonanceGlide = new Glide(audio.getAudioContext(), 0.0F, 500.0f);
	
	/** The lprf. */
	LPRezFilter lprf;
	
	/** The apf. */
	BiquadFilter.Type lpf,hpf,apf;
	
	//AllpassFilter allPass;
	
	
	
	/**
	 * Instantiates a new filter.
	 */
	public Filter(){
		
		 lprf = new LPRezFilter(audio.getAudioContext(), filterFrequencyGlide, 0.95f);
		 hpf =  BiquadFilter.BUTTERWORTH_HP;
		 lpf =  BiquadFilter.BUTTERWORTH_LP;
		 apf =  BiquadFilter.AP;
	
	}
	
	
	/**
	 * Select filter.
	 *
	 * @param filter the filter
	 * @return the biquad filter. type
	 */
	public BiquadFilter.Type SelectFilter(String filter){
		
		if(filter.equals("LowPass")){
			return lpf;
		}else if(filter.equals("HighPass")){
			return hpf;
		}else if(filter.equals("AllPass")){
			return apf;
		}else{
			return lpf;
		}
	}
	
	/**
	 * Adds the to filter 1.
	 *
	 * @param filterWave1 the filter wave 1
	 * @param containsWave the contains wave
	 * @param filter1 the filter 1
	 * @param osc1Wave the osc 1 wave
	 */
	public void addToFilter1(boolean filterWave1, boolean containsWave, BiquadFilter filter1, WavePlayer osc1Wave){
		
		if(filterWave1 && !containsWave){
			filter1.addInput(osc1Wave);
		}else if(filterWave1 && containsWave){
			//do nothing
		}else{
			filter1.removeAllConnections(osc1Wave);
		}
	}
	
	/**
	 * Adds the to filter 2.
	 *
	 * @param filterWave2 the filter wave 2
	 * @param containsWave the contains wave
	 * @param filter2 the filter 2
	 * @param osc2Wave the osc 2 wave
	 */
	public void addToFilter2(boolean filterWave2, boolean containsWave, BiquadFilter filter2, WavePlayer osc2Wave){
		
		if(filterWave2 && !containsWave){
			filter2.addInput(osc2Wave);
		}else if(filterWave2 && containsWave){
			//do nothing
		}else{
			filter2.removeAllConnections(osc2Wave);
		}
	}
	
	/**
	 * Gets the low rez pass.
	 *
	 * @return the low rez pass
	 */
	public LPRezFilter getLowRezPass(){
		return lprf;
	}
	
	
	/**
	 * Adds the to filter.
	 *
	 * @param filter the filter
	 * @param gen the gen
	 */
	public void addToFilter(BiquadFilter filter, UGen gen){
		filter.addInput(gen);
		
	}

	
	/**
	 * Removes the from low rez pass.
	 *
	 * @param gen the gen
	 */
	public void removeFromLowRezPass(UGen gen){
		lprf.clearInputConnections();
	}
	
	/**
	 * Removes the from filter.
	 *
	 * @param filter the filter
	 * @param gen the gen
	 */
	public void removeFromFilter(BiquadFilter filter, UGen gen){
		filter.clearInputConnections();
	}
	
	
	
}
