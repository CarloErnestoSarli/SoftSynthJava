package source;
import net.beadsproject.beads.*;

import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.core.UGen;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.WavePlayer;
//singleton
public class Settings {
	
	private static Settings settings = null;
	
	private float m_Osc1Freq;
	private float m_Osc2Freq;
	
	
	protected Settings()
	{
		
	}
	
	public static Settings getSettings()
	{
		if(settings == null){
			settings = new Settings();
		}
		return settings;
	}
	
	public void setOsc1Freq(float freq)
	{
		m_Osc1Freq = freq;
	}
	
	public void setOsc2Freq(float freq)
	{
		m_Osc2Freq = freq;
	}
	
	public float getOsc1Freq()
	{
		
		return m_Osc1Freq;
	}
	
	public float getOsc2Freq()
	{
		
		return m_Osc2Freq;
	}
	
}
