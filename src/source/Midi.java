package source;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.midi.ShortMessage;
import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.WavePlayer;



public class Midi {

	WavePlayer sine;
	Gain sineGain;
	Glide gainGlide;

	int lastKeyPressed = -1;

	public static void main(String[] args)
	{
		Midi synth = new Midi();
		synth.setup();
	}

	// construct the synthesizer
	public void setup()
	{
		AudioContext ac = new AudioContext();

		sine = new WavePlayer(ac, 440.0f, Buffer.SINE);

		// set up the Gain and Glide objects and connect them
		gainGlide = new Glide(ac, 0.0f, 50.0f);
		sineGain = new Gain(ac, 1, gainGlide);
		sineGain.addInput(sine);
		ac.out.addInput(sineGain);

		// set up the keyboard input
		MidiKeyboard keys = new MidiKeyboard();
		keys.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// if the event is not null
				if( e != null )
				{
					// if the event is a MIDI event
					if( e.getSource() instanceof ShortMessage )
					{
						// get the MIDI event
						ShortMessage sm = (ShortMessage)e.getSource();

						// if the event is a key down
						if( sm.getCommand() == MidiKeyboard.NOTE_ON && sm.getData2() > 1 )
						{
							keyDown(sm.getData1());
						}
						// if the event is a key up
						else if( sm.getCommand() == MidiKeyboard.NOTE_OFF )
						{
							keyUp(sm.getData1());
						}
					}
				}
			}		
		});

		ac.start();
	}

	private float pitchToFrequency(int midiPitch)
	{
		/*
		 *  MIDI pitch number to frequency conversion equation from
		 *  http://newt.phys.unsw.edu.au/jw/notes.html
		 */
		double exponent = (midiPitch - 69.0) / 12.0;
		return (float)(Math.pow(2, exponent) * 440.0f);
	}

	public void keyDown(int midiPitch)
	{
		if( sine != null && gainGlide != null )
		{
			lastKeyPressed = midiPitch;
			sine.setFrequency(pitchToFrequency(midiPitch));
			gainGlide.setValue(0.9f);
		}
	}

	public void keyUp(int midiPitch)
	{
		if( gainGlide != null && midiPitch == lastKeyPressed )
		{
			gainGlide.setValue(0.0f);
		}
	}
}


