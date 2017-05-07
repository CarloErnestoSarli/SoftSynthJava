/**
 * @file UserSettings.java
 * @author Carlo Sarli 
 *	@brief this class is responsible for saving and loadin user settings or preset into the synth.
 * 
 */
package source;

import java.util.prefs.Preferences;

// TODO: Auto-generated Javadoc
/**
 * The Class UserSettings.
 */
public class UserSettings {

	/** The user settings. */
	Preferences userSettings;

	/** The master. */
	Master master = Master.getMaster();

	/** The adsr. */
	ADSR adsr = ADSR.getADSR();

	/** The lfo. */
	LFO lfo = LFO.getLfo();

	/** The eq. */
	EQ eq = EQ.getEQ();

	/** The osc settings. */
	OscillatorSettings oscSettings = OscillatorSettings.getOscillatorSettings();

	/** The fil settings. */
	FilterSettings filSettings = FilterSettings.getFilterSettings();

	CompressorComponent comp = CompressorComponent.getCompressorComponent();

	ReverbComponent rev = ReverbComponent.getReverbComponent();

	Settings settings = Settings.getSettings();
	/** The osc 1 wave. */
	// ---------OSC
	private final String OSC_1_WAVE = "OSC_1_WAVE";

	/** The osc 2 wave. */
	private final String OSC_2_WAVE = "OSC_2_WAVE";

	/** The osc 1 phase. */
	private final String OSC_1_PHASE = "OSC_1_PHASE";

	/** The osc 2 phase. */
	private final String OSC_2_PHASE = "OSC_2_PHASE";

	/** The add filter 1. */
	// ---------FILTER
	private final String ADD_FILTER_1 = "ADD_FILTER_1";

	/** The add filter 2. */
	private final String ADD_FILTER_2 = "ADD_FILTER_2";

	/** The filter 1 freq. */
	private final String FILTER_1_FREQ = "FILTER_1_FREQ";

	/** The filter 2 freq. */
	private final String FILTER_2_FREQ = "FILTER_2_FREQ";

	/** The filter 1 type. */
	private final String FILTER_1_TYPE = "FILTER_1_TYPE";

	/** The filter 2 type. */
	private final String FILTER_2_TYPE = "FILTER_2_TYPE";

	/** The lfo freq. */
	// ---------LFO
	private final String LFO_FREQ = "LFO_FREQ";

	/** The lfo ampl. */
	private final String LFO_AMPL = "LFO_AMPL";

	/** The lfo wave. */
	private final String LFO_WAVE = "LFO_WAVE";
	// private final String LFO_ACTION;
	/** The a time. */
	// ---------ADSR
	private final String A_TIME = "A_TIME";

	/** The d time. */
	private final String D_TIME = "D_TIME";

	/** The s time. */
	private final String S_TIME = "S_TIME";

	/** The r time. */
	private final String R_TIME = "R_TIME";

	/** The high freq. */
	// ---------EQ
	private final String HIGH_FREQ = "HIGH_FREQ";

	/** The high gain. */
	private final String HIGH_GAIN = "HIGH_GAIN";

	/** The low freq. */
	private final String LOW_FREQ = "LOW_FREQ";

	/** The low gain. */
	private final String LOW_GAIN = "LOW_GAIN";

	/** The osc mix volume. */
	// ---------MASTER
	private final String OSC_MIX_VOLUME = "OSC_MIX_VOLUME";

	/** The osc 1 volume. */
	private final String OSC_1_VOLUME = "OSC_1_VOLUME";

	/** The osc 2 volume. */
	private final String OSC_2_VOLUME = "OSC_2_VOLUME";

	/** The filter mix volume. */
	private final String FILTER_MIX_VOLUME = "FILTER_MIX_VOLUME";

	/** The filter 1 volume. */
	private final String FILTER_1_VOLUME = "FILTER_1_VOLUME";

	/** The filter 2 volume. */
	private final String FILTER_2_VOLUME = "FILTER_2_VOLUME";

	/** The master volume. */
	private final String MASTER_VOLUME = "MASTER_VOLUME";

	/** The panner pos. */
	// ---------PANNER
	private final String PANNER_POS = "PANNER_POS";

	private final String LATE = "LATE";
	private final String EARLY = "EARLY";
	private final String ROOM = "ROOM";
	private final String DAMP = "DAMP";
	private final String REVERB_ON = "REVERB_ON";
	private final String RATIO = "RATIO";
	private final String THRESHOLD = "THRESHOLD";
	private final String COMP_DECAY = "COMP_DECAY";
	private final String COMP_ATTACK = "COMP_ATTACK";
	private final String COMP_ON = "COMP_ON";
	private final String FINE_TUNING1 = "FINE_TUNING1";
	private final String FINE_TUNING2 = "FINE_TUNING2";
	private final String TRANSPOSE1 = "TRANSPOSE1";
	private final String TRANSPOSE2 = "TRANSPOSE2";

	/**
	 * Instantiates a new user settings.
	 */
	public UserSettings() {
		userSettings = Preferences.userRoot();

	}

	/**
	 * Save settings.
	 */
	public void saveSettings() {

		// ---------OSC
		userSettings.putInt(TRANSPOSE1, oscSettings.getTranspose1());
		userSettings.putInt(TRANSPOSE2, oscSettings.getTranspose2());
		userSettings.putInt(FINE_TUNING1, oscSettings.getFineTuning1());
		userSettings.putInt(FINE_TUNING2, oscSettings.getFineTuning2());
		userSettings.put(OSC_1_WAVE, oscSettings.getWave1Sel());
		userSettings.put(OSC_2_WAVE, oscSettings.getWave2Sel());
		userSettings.putFloat(OSC_1_PHASE, oscSettings.getDelayIn1Time());
		userSettings.putFloat(OSC_2_PHASE, oscSettings.getDelayIn2Time());
		// ---------FILTER
		userSettings.putBoolean(ADD_FILTER_1, filSettings.getFilterWave1());
		userSettings.putBoolean(ADD_FILTER_2, filSettings.getFilterWave2());
		userSettings.putFloat(FILTER_1_FREQ, filSettings.getFilter1Freq());
		userSettings.putFloat(FILTER_2_FREQ, filSettings.getFilter2Freq());
		userSettings.put(FILTER_1_TYPE, filSettings.getFilter1Sel());
		userSettings.put(FILTER_2_TYPE, filSettings.getFilter2Sel());
		// ---------LFO
		userSettings.putFloat(LFO_FREQ, lfo.getLfoFrq());
		userSettings.putFloat(LFO_AMPL, lfo.getLfoAmplitude());
		userSettings.put(LFO_WAVE, lfo.getLfoWaveSel());
		// ---------ADSR
		userSettings.putFloat(A_TIME, adsr.getAttackTime());
		userSettings.putFloat(D_TIME, adsr.getDecayTime());
		userSettings.putFloat(S_TIME, adsr.getSustainTime());
		userSettings.putFloat(R_TIME, adsr.getReleaseTime());
		// ---------EQ
		userSettings.putFloat(HIGH_FREQ, eq.getHighFreq());
		userSettings.putFloat(HIGH_GAIN, eq.getHighGain());
		userSettings.putFloat(LOW_FREQ, eq.getLowFreq());
		userSettings.putFloat(LOW_GAIN, eq.getLowGain());
		// ---------MASTER
		userSettings.putFloat(OSC_MIX_VOLUME, master.getOscMix());
		userSettings.putFloat(OSC_1_VOLUME, master.getOsc1Gain());
		userSettings.putFloat(OSC_2_VOLUME, master.getOsc2Gain());
		userSettings.putFloat(FILTER_MIX_VOLUME, master.getFilMix());
		userSettings.putFloat(FILTER_1_VOLUME, master.getFil1Gain());
		userSettings.putFloat(FILTER_2_VOLUME, master.getFil2Gain());
		userSettings.putFloat(MASTER_VOLUME, master.getMasterVolume());
		// ---------PANNER
		userSettings.putFloat(PANNER_POS, master.getPannerPosition());
		// ----------COMPRESSOR
		userSettings.putFloat(RATIO, comp.getRatio());
		userSettings.putFloat(THRESHOLD, comp.getThreshold());
		userSettings.putFloat(COMP_DECAY, comp.getDecay());
		userSettings.putFloat(COMP_ATTACK, comp.getAttack());
		userSettings.putBoolean(COMP_ON, settings.isCompressorOn());
		// ----------REVERB
		userSettings.putFloat(LATE, rev.getLateReflection());
		userSettings.putFloat(EARLY, rev.getEarlyReflection());
		userSettings.putFloat(ROOM, rev.getSize());
		userSettings.putFloat(DAMP, rev.getDamping());
		userSettings.putBoolean(REVERB_ON, settings.isReverbOn());
	}

	/**
	 * Load settings.
	 */
	public void loadSettings() {

		// ---------OSC
		oscSettings.setTranspose1(userSettings.getInt(TRANSPOSE1, oscSettings.getTranspose1()));
		oscSettings.setTranspose2(userSettings.getInt(TRANSPOSE2, oscSettings.getTranspose2()));
		oscSettings.setFineTuning1(userSettings.getInt(FINE_TUNING1, oscSettings.getFineTuning1()));
		oscSettings.setFineTuning2(userSettings.getInt(FINE_TUNING2, oscSettings.getFineTuning2()));
		oscSettings.setWave1Sel(userSettings.get(OSC_1_WAVE, oscSettings.getWave1Sel()));
		oscSettings.setWave2Sel(userSettings.get(OSC_2_WAVE, oscSettings.getWave2Sel()));
		oscSettings.setDelayIn1Time(userSettings.getFloat(OSC_1_PHASE, oscSettings.getDelayIn1Time()));
		oscSettings.setDelayIn2Time(userSettings.getFloat(OSC_2_PHASE, oscSettings.getDelayIn2Time()));
		// ---------FILTER
		filSettings.setFilterWave1(userSettings.getBoolean(ADD_FILTER_1, filSettings.getFilterWave1()));
		filSettings.setFilterWave2(userSettings.getBoolean(ADD_FILTER_2, filSettings.getFilterWave2()));
		filSettings.setFilter1Freq(userSettings.getFloat(FILTER_1_FREQ, filSettings.getFilter1Freq()));
		filSettings.setFilter2Freq(userSettings.getFloat(FILTER_2_FREQ, filSettings.getFilter2Freq()));
		filSettings.setFilter1Sel(userSettings.get(FILTER_1_TYPE, filSettings.getFilter1Sel()));
		filSettings.setFilter2Sel(userSettings.get(FILTER_2_TYPE, filSettings.getFilter2Sel()));
		// ---------LFO
		lfo.setLfoFreq(userSettings.getFloat(LFO_FREQ, lfo.getLfoFrq()));
		lfo.setLfoAmplitude(userSettings.getFloat(LFO_AMPL, lfo.getLfoAmplitude()));
		lfo.setLfoWaveSel(userSettings.get(LFO_WAVE, lfo.getLfoWaveSel()));
		// ---------ADSR
		adsr.setAttackTime(userSettings.getFloat(A_TIME, adsr.getAttackTime()));
		adsr.setDecayTime(userSettings.getFloat(D_TIME, adsr.getDecayTime()));
		adsr.setSustainTime(userSettings.getFloat(S_TIME, adsr.getSustainTime()));
		adsr.setReleaseTime(userSettings.getFloat(R_TIME, adsr.getReleaseTime()));
		// ---------EQ
		eq.setHighFreq(userSettings.getFloat(HIGH_FREQ, eq.getHighFreq()));
		eq.setHighGain(userSettings.getFloat(HIGH_GAIN, eq.getHighGain()));
		eq.setLowFreq(userSettings.getFloat(LOW_FREQ, eq.getLowFreq()));
		eq.setLowGain(userSettings.getFloat(LOW_GAIN, eq.getLowGain()));
		// ---------MASTER
		master.setOscMix(userSettings.getFloat(OSC_MIX_VOLUME, master.getOscMix()));
		master.setOsc1Gain(userSettings.getFloat(OSC_1_VOLUME, master.getOsc1Gain()));
		master.setOsc2Gain(userSettings.getFloat(OSC_2_VOLUME, master.getOsc2Gain()));
		master.setFilMix(userSettings.getFloat(FILTER_MIX_VOLUME, master.getFilMix()));
		master.setFil1Gain(userSettings.getFloat(FILTER_1_VOLUME, master.getFil1Gain()));
		master.setFil2Gain(userSettings.getFloat(FILTER_2_VOLUME, master.getFil2Gain()));
		master.setMasterVolume(userSettings.getFloat(MASTER_VOLUME, master.getMasterVolume()));
		// ---------PANNER
		master.setPannerPosition(userSettings.getFloat(PANNER_POS, master.getPannerPosition()));
		// ----------COMPRESSOR
		comp.setRatio(userSettings.getFloat(RATIO, comp.getRatio()));
		comp.setThreshold(userSettings.getFloat(THRESHOLD, comp.getThreshold()));
		comp.setDecay(userSettings.getFloat(COMP_DECAY, comp.getDecay()));
		comp.setAttack(userSettings.getFloat(COMP_ATTACK, comp.getAttack()));
		settings.setCompressorOn(userSettings.getBoolean(COMP_ON, settings.isCompressorOn()));
		// ----------REVERB
		rev.setLateReflection(userSettings.getFloat(LATE, rev.getLateReflection()));
		rev.setEarlyReflection(userSettings.getFloat(EARLY, rev.getEarlyReflection()));
		rev.setSize(userSettings.getFloat(ROOM, rev.getSize()));
		rev.setDamping(userSettings.getFloat(DAMP, rev.getDamping()));
		settings.setReverbOn(userSettings.getBoolean(REVERB_ON, settings.isReverbOn()));
	}
}
