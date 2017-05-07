/**
 * @file Keyboard.java
 * @author Carlo Sarli 
 * @brief the keyboard class maps together the name of the notes to their MIDI number and contains a method to convert a midi number to a frequency
 */
package source;

import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class Keyboard.
 */
public class Keyboard {
	
	/** The total notes. */
	private final int TOTAL_NOTES = 119;
	
	/** The last key pressed. */
	int lastKeyPressed = -1;
	
	/** The midi notes. */
	HashMap<String, Integer> midiNotes = new HashMap<String, Integer>();
	
	/** The notes. */
	private String[] notes = {"C","C#","D","D#","E","F","F#","G","G#","A","A#","B","C1","C#1","D1","D#1","E1","F1","F#1","G1","G#1","A1","A#1","B1",
			"C2","C#2","D2","D2#","E2","F2","F#2","G2","G#2","A2","A#2","B2","C3","C#3","D3","D#3","E3","F3","F#3","G3","G#3","A3","A#3","B3",
			"C4","C#4","D4","D#4","E4","F4","F#4","G4","G#4","A4","A#4","B4","C5","C#5","D5","D#5","E5","F5","F#5","G5","G#5","A5","A#5","B5",
			"C6","C#6","D6","D#6","E6","F6","F#6","G6","G#6","A6","A#6","B6","C7","C#7","D7","D#7","E7","F7","F#7","G7","G#7","A7","A#7","B7",
			"C8","C#8","D8","D#8","E8","F8","F#8","G8","G#8","A8","A#8","B9","C9","C#9","D9","D#9","E9","F9","F#9","G9","G#9","A9","A#9","B9"};
	
	/**
	 * Instantiates a new keyboard.
	 */
	public Keyboard(){
		populateMidiNotes();
	}
	
	/**
	 * Populate midi notes.
	 */
	public void populateMidiNotes(){
		for(int i = 0; i <= TOTAL_NOTES; i++){
			String key = notes[i];
			int value = i;
			midiNotes.putIfAbsent(key, value);
		}
		
	}
	
	/**
	 * Gets the note.
	 *
	 * @param index the index
	 * @return the note
	 */
	public String getNote(int index){
		return notes[index];
	}
	
	/**
	 * Gets the midifrom note.
	 *
	 * @param note the note
	 * @return the midifrom note
	 */
	public int getMidifromNote(String note){
		return midiNotes.get(note);
	}
	
	/**
	 * Pitch to frequency.
	 *
	 * @param midiPitch the midi pitch
	 * @return the float
	 */
	/*
	 *  MIDI pitch number to frequency conversion equation from
	 *  http://newt.phys.unsw.edu.au/jw/notes.html
	 *  fn  =  2^(n/12)*440 Hz.
	 */
	public float pitchToFrequency(int midiPitch){
		System.out.println("PITCH" + midiPitch);
		double exp = (midiPitch - 69.0) / 12.0;
		return (float)(Math.pow(2, exp) * 440.0f);
	}
	
	
}
