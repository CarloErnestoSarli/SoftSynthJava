package source;
import net.beadsproject.beads.*;

import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.core.UGen;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.WavePlayer;

//singleton pattern
public class Settings {
	
	private static Settings settings = null;
	
	private float m_Osc1Freq;
	private float m_Osc2Freq;
	
	public String m_Wave1Sel, m_Wave2Sel;
	
	public static final float START_FREQ = 440.0f; 
	
	
	protected Settings()
	{
		m_Wave1Sel = "sine";
		m_Wave2Sel = "sine";
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
	
	public void setWave1Sel(String wave)
	{
		m_Wave1Sel = wave;
	}
	
	public void setWave2Sel(String wave)
	{
		m_Wave2Sel = wave;
	}
	
	public String getWave1Sel()
	{
		
		return m_Wave1Sel;
		
	}
	
	public String getWave2Sel()
	{
		
		return m_Wave2Sel;
		
	}
}
