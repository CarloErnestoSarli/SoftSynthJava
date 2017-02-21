import net.beadsproject.beads.*;

import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.WavePlayer;

public class Settings {
	
	static AudioContext ac = new AudioContext();
	
	private double m_Osc1Freq;
	private double m_Osc2Freq;
	
	
	
	public void setOsc1Freq(double freq){
		m_Osc1Freq = freq;
	}
	
	public void setOsc2Freq(double freq){
		m_Osc1Freq = freq;
	}
	
	public double getOsc1Freq(){
		
		return m_Osc1Freq;
	}
	
	public double getOsc2Freq(){
		
		return m_Osc2Freq;
	}
	
}
