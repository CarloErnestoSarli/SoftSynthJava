package views;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import net.beadsproject.beads.core.UGen;
import net.beadsproject.beads.ugens.OscillatorBank;

import javax.swing.event.ChangeEvent;

import source.*;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.ComponentOrientation;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.border.TitledBorder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Rectangle;
import javax.swing.JLayeredPane;

public class GUI extends JFrame {

	Audio audio = Audio.getAudio();
	Settings settings = Settings.getSettings();
	OscillatorSettings oscSettings = OscillatorSettings.getOscillatorSettings();
	FilterSettings filSettings = FilterSettings.getFilterSettings();
	ADSR adsr = ADSR.getADSR();
	Master master = Master.getMaster();
	LFO lfo = LFO.getLfo();
	EQ eq = EQ.getEQ();
	UserSettings userSettings = new UserSettings();
	Components comp = new Components();
	VirtualKeyboard key;
	ReverbComponent rev = ReverbComponent.getReverbComponent();
	CompressorComponent compressor = CompressorComponent.getCompressorComponent();

	private final int MIN_OSC_FREQ = 1635;
	private final int MAX_OSC_FREQ = 100000;
	private final int NOTE_A_FREQ = 44000;
	private final int LFO_MIN_FREQ = 2;
	private final int LFO_MAX_FREQ = 2000;
	private final int MIN_VOLUME = 0;
	private final int MAX_VOLUME = 100;
	private final int LEFT = -10;
	private final int RIGHT = 10;
	private final int START_VOLUME = 50;
	private final int START_POSITION = 0;

	private JPanel SynthPane;
	private JRadioButton AddOsc1ToFilter;
	private JRadioButton AddOsc2ToFilter;
	private JComboBox Osc1WvSel;
	private JComboBox Osc2WvSel;
	private JComboBox Filter2Combo;
	private JComboBox LfoWaveCombo;
	private JComboBox ApplyLfoCombo;
	private JComboBox Filter1Combo;
	private JProgressBar VolumeLeftBar;
	private JProgressBar VolumeRightBar;
	private JSlider Osc1FreqSlider;
	private JSlider Osc1PhaseSlider;
	private JSlider Osc2FreqSlider;
	private JSlider Osc2PhaseSlider;
	private JSlider Filter1FreqSlider;
	private JSlider Filter2FreqSlider;
	private JSlider LfoFrequencySlider;
	private JSlider LfoAmplitudeSlider;
	private JSlider PanningSlider;
	private JSlider FilterMixSlider;
	private JSlider OscMixSlider;
	private JSlider OscGainSlider;
	private JSlider MasterVolumeSlider;
	private JSlider FilterGainSlider;
	private JSlider AttackSlider;
	private JSlider ReleaseSlider;
	private JSlider SustainSlider;
	private JSlider DecaySlider;
	private JSlider EqHighSlider;
	private JSlider EqHighGainSlider;
	private JSlider EqLowSlider;
	private JSlider EqLowGainSlider;
	private JLabel lblBackground;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setResizable(false);
		
		setBackground(Color.WHITE);
		setTitle("Marbles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 643);
		getContentPane().setLayout(new BorderLayout());

		// -----------------------------------------MENU--------------------------

		JMenuBar SynthMenuBar = new JMenuBar();
		setJMenuBar(SynthMenuBar);

		JMenu mnFile = new JMenu("File");
		SynthMenuBar.add(mnFile);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userSettings.saveSettings();
			}
		});

		mnFile.add(mntmSave);

		JMenuItem mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userSettings.loadSettings();
				comp.updateComponents();
			}
		});

		mnFile.add(mntmLoad);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnWindow = new JMenu("Window");
		SynthMenuBar.add(mnWindow);
		
		JMenuItem mntmOpenVirtualKeyboard = new JMenuItem("Open Virtual Keyboard");
		mntmOpenVirtualKeyboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				key = new VirtualKeyboard();
				key.setVisible(true);
				
			}
		});
		mnWindow.add(mntmOpenVirtualKeyboard);
		
		JMenu mnOptions = new JMenu("Options");
		SynthMenuBar.add(mnOptions);
		
		JMenuItem mntmSwitchBackgroundOff = new JMenuItem("Switch background off");
		mntmSwitchBackgroundOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!lblBackground.isEnabled()){
					lblBackground.setEnabled(true);
				}else if(lblBackground.isEnabled()){
					lblBackground.setEnabled(false);
				}
			}
		});
		mnOptions.add(mntmSwitchBackgroundOff);

		// ---------------------------------\MENU----------------------

		// ---------------------------------PANELS-----------------------
		SynthPane = new JPanel();
		SynthPane.setBackground(Color.WHITE);
		SynthPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(SynthPane);

		JPanel TopPanel = new JPanel();
		TopPanel.setBounds(5, 6, 1142, 219);
		TopPanel.setOpaque(false);

		JPanel OscPanel = new JPanel();
		OscPanel.setOpaque(false);
		OscPanel.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), "Oscillator 1&2", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JPanel FilterPanel = new JPanel();
		FilterPanel.setOpaque(false);
		FilterPanel.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), "Filters", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));

		JPanel BottomPanel = new JPanel();
		BottomPanel.setBounds(5, 233, 1142, 178);
		BottomPanel.setOpaque(false);

		JPanel LFOPanel = new JPanel();
		LFOPanel.setOpaque(false);
		LFOPanel.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), "LFO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JPanel ADSRPanel = new JPanel();
		ADSRPanel.setForeground(Color.BLACK);
		ADSRPanel.setOpaque(false);
		ADSRPanel.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), "ADSR Envelope", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));

		JPanel MasterPanel = new JPanel();
		MasterPanel.setBounds(5, 417, 673, 161);
		MasterPanel.setOpaque(false);
		MasterPanel.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), "Master Controls", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));

		JPanel EqPanel = new JPanel();
		EqPanel.setBounds(1153, 6, 126, 221);
		EqPanel.setOpaque(false);
		EqPanel.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), "Eq", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JPanel PannerPanel = new JPanel();
		PannerPanel.setBounds(1153, 233, 126, 178);
		PannerPanel.setOpaque(false);
		PannerPanel.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), "Panner", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JPanel VolumeBarsPanel = new JPanel();
		VolumeBarsPanel.setBounds(1153, 417, 126, 161);
		VolumeBarsPanel.setOpaque(false);
		VolumeBarsPanel.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), "Volume", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		// -----------------------------------\PANELS--------------------

		// ------------------------------------COMPONENTS-----------------

		// OSC1 slider
		/*
		Osc1FreqSlider = comp.getOsc1FreqSlider();
		Osc1PhaseSlider = comp.getOsc1PhaseSlider();
		Osc2FreqSlider = comp.getOsc2FreqSlider();
		Osc2PhaseSlider = comp.getOsc2PhaseSlider();
		Osc1WvSel = comp.getOsc1WvSel();
		Osc2WvSel = comp.getOsc2WvSel();
		Filter1FreqSlider = comp.getFilter1FreqSlider();
		Filter2FreqSlider = comp.getFilter2FreqSlider();
		AddOsc2ToFilter = comp.getAddOsc2ToFilter();
		AddOsc1ToFilter = comp.getAddOsc1ToFilter();
		Filter1Combo = comp.getFilter1Combo();
		Filter2Combo = comp.getFilter2Combo();
		LfoWaveCombo = comp.getLfoWaveCombo();
		ApplyLfoCombo = comp.getApplyLfoCombo();
		LfoFrequencySlider = comp.getLfoFrequencySlider();
		LfoAmplitudeSlider = comp.getLfoAmplitudeSlider();
		PanningSlider = comp.getPanningSlider();
		FilterMixSlider = comp.getFilterMixSlider();
		OscMixSlider = comp.getOscMixSlider();
		OscGainSlider = comp.getOscGainSlider();
		MasterVolumeSlider = comp.getMasterVolumeSlider();
		FilterGainSlider = comp.getFilterGainSlider();
		AttackSlider = comp.getAttackSlider();
		ReleaseSlider = comp.getReleaseSlider();
		SustainSlider = comp.getSustainSlider();
		DecaySlider = comp.getDecaySlider();
		EqHighSlider = comp.getEqHighSlider();
		EqHighGainSlider = comp.getEqHighGainSlider();
		EqLowSlider = comp.getEqLowSlider();
		EqLowGainSlider = comp.getEqLowGainSlider();
		*/
		Osc1FreqSlider = new JSlider(SwingConstants.HORIZONTAL, MIN_OSC_FREQ, MAX_OSC_FREQ, NOTE_A_FREQ);
		Osc1PhaseSlider = new JSlider(0, 300, 150);
		Osc2FreqSlider = new JSlider(SwingConstants.HORIZONTAL, MIN_OSC_FREQ, MAX_OSC_FREQ, NOTE_A_FREQ);
		Osc2PhaseSlider = new JSlider(0, 300, 150);
		Osc1WvSel = new JComboBox();
		Osc2WvSel = new JComboBox();
		Filter1FreqSlider = new JSlider(MIN_OSC_FREQ, MAX_OSC_FREQ, NOTE_A_FREQ);
		AddOsc2ToFilter = new JRadioButton("AddOsc2ToFilter");
		AddOsc2ToFilter.setFont(new Font("Tahoma", Font.BOLD, 12));
		AddOsc1ToFilter = new JRadioButton("AddOsc1ToFilter");
		AddOsc1ToFilter.setFont(new Font("Tahoma", Font.BOLD, 12));
		Filter2FreqSlider = new JSlider(MIN_OSC_FREQ, MAX_OSC_FREQ, NOTE_A_FREQ);
		Filter1Combo = new JComboBox();
		Filter2Combo = new JComboBox();
		LfoWaveCombo = new JComboBox();
		ApplyLfoCombo = new JComboBox();
		LfoFrequencySlider = new JSlider(LFO_MIN_FREQ, LFO_MAX_FREQ);
		LfoAmplitudeSlider = new JSlider();
		PanningSlider = new JSlider(LEFT, RIGHT, START_POSITION);
		FilterMixSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
		OscMixSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
		OscGainSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
		MasterVolumeSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
		FilterGainSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
		AttackSlider = new JSlider(0, 1000, 500);
		ReleaseSlider = new JSlider(0, 1000, 500);
		SustainSlider = new JSlider(0, 1000, 500);
		DecaySlider = new JSlider(0, 1000, 500);
		EqHighSlider = new JSlider(MIN_OSC_FREQ, MAX_OSC_FREQ, NOTE_A_FREQ);
		EqHighGainSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
		EqLowSlider = new JSlider(MIN_OSC_FREQ, MAX_OSC_FREQ, NOTE_A_FREQ);
		EqLowGainSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
		Osc1FreqSlider.setOpaque(false);
		Osc1FreqSlider.setMajorTickSpacing(50000);
		Osc1FreqSlider.setMinorTickSpacing(50);

		Osc1PhaseSlider.setOpaque(false);
		Osc1PhaseSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				oscSettings.setDelayIn1Time(source.getValue());
			}
		});

		Osc2FreqSlider.setOpaque(false);
		Osc2FreqSlider.setMinorTickSpacing(50);
		Osc2FreqSlider.setMajorTickSpacing(50000);
		Osc1FreqSlider.setMajorTickSpacing(500);
		Osc1FreqSlider.setMinorTickSpacing(50);
		Osc2FreqSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				oscSettings.setOsc2Freq((float) source.getValue() / 100);
			}
		});

		Osc2PhaseSlider.setOpaque(false);
		Osc2PhaseSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				oscSettings.setDelayIn2Time(source.getValue());
			}
		});

		Osc1WvSel.setOpaque(false);
		Osc1WvSel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				oscSettings.setWave1Sel(cb.getSelectedItem().toString());
				System.out.println(cb.getSelectedItem().toString());
			}
		});

		Osc1WvSel.setModel(new DefaultComboBoxModel(new String[] { "Sine", "Square", "Saw", "Triangle", "Noise" }));
		Osc1WvSel.setToolTipText("");

		Osc2WvSel.setOpaque(false);
		Osc2WvSel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				oscSettings.setWave2Sel(cb.getSelectedItem().toString());
				System.out.println(cb.getSelectedItem().toString());
			}
		});

		Osc2WvSel.setModel(new DefaultComboBoxModel(new String[] { "Sine", "Square", "Saw", "Triangle", "Noise" }));

		Osc1FreqSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				oscSettings.setOsc1Freq((float) source.getValue() / 100);

			}
		});

		AddOsc1ToFilter.setOpaque(false);
		AddOsc1ToFilter.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JRadioButton source = (JRadioButton) e.getSource();
				if (source.isSelected()) {
					filSettings.setFilterWave1(true);
				} else {
					filSettings.setFilterWave1(false);
				}
			}
		});

		Filter1FreqSlider.setOpaque(false);
		Filter1FreqSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				// set filter frequency
				filSettings.setFilter1Freq((float) source.getValue() / 100);
			}
		});

		AddOsc2ToFilter.setOpaque(false);
		AddOsc2ToFilter.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JRadioButton source = (JRadioButton) e.getSource();
				if (source.isSelected()) {
					filSettings.setFilterWave2(true);
				} else {
					filSettings.setFilterWave2(false);
				}
			}
		});

		Filter2FreqSlider.setOpaque(false);
		Filter2FreqSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				// set filter gain
				filSettings.setFilter2Freq((float) source.getValue() / 100);
			}
		});

		Filter1Combo.setOpaque(false);
		Filter1Combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				// set filter type
				filSettings.setFilter1Sel(cb.getSelectedItem().toString());
				// System.out.println(cb.getSelectedItem().toString());
			}
		});

		Filter1Combo.setModel(new DefaultComboBoxModel(new String[] { "LowPass", "HighPass", "AllPass" }));

		Filter2Combo.setOpaque(false);
		Filter2Combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				// set filter type
				filSettings.setFilter2Sel(cb.getSelectedItem().toString());
				// System.out.println(cb.getSelectedItem().toString());
			}
		});

		Filter2Combo.setModel(new DefaultComboBoxModel(new String[] { "LowPass", "HighPass", "AllPass" }));

		LfoWaveCombo.setOpaque(false);
		LfoWaveCombo.setModel(new DefaultComboBoxModel(new String[] { "Sine", "Square", "Saw", "Triangle" }));
		LfoWaveCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				lfo.setLfoWaveSel(cb.getSelectedItem().toString());
			}
		});

		ApplyLfoCombo.setOpaque(false);
		ApplyLfoCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				lfo.setLfoWaveSel(cb.getSelectedItem().toString());
			}
		});

		ApplyLfoCombo.setModel(new DefaultComboBoxModel(new String[] { "Oscillator1Frequency", "Oscillator2Frequency",
				"Filter1Frequency", "Filter2Frequency", "MasterVolume", "PannerPosition" }));

		LfoFrequencySlider.setOpaque(false);
		LfoFrequencySlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				// set lfo frequency
				lfo.setLfoFreq((float) (source.getValue()) / 100);
			}
		});

		LfoAmplitudeSlider.setOpaque(false);

		PanningSlider.setOpaque(false);

		JLabel lblL = new JLabel("L");
		lblL.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblL.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblR = new JLabel("R");
		lblR.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblR.setHorizontalAlignment(SwingConstants.RIGHT);

		PanningSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				master.setPannerPosition(source.getValue() / 10.0f);
			}
		});

		FilterMixSlider.setOpaque(false);
		FilterMixSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				float value = source.getValue();
				master.setFil1Gain(value / 100.0f);
				master.setFil2Gain((MAX_VOLUME - value) / 100.0f);
			}
		});

		OscMixSlider.setOpaque(false);
		OscMixSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				float value = source.getValue();
				master.setOsc1Gain(value / 100.0f);
				master.setOsc2Gain((MAX_VOLUME - value) / 100.0f);
			}
		});

		OscMixSlider.setOrientation(SwingConstants.VERTICAL);

		OscGainSlider.setOpaque(false);
		OscGainSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				master.setOscMix(source.getValue() / 100.0f);
			}
		});

		OscGainSlider.setOrientation(SwingConstants.VERTICAL);
		FilterMixSlider.setOrientation(SwingConstants.VERTICAL);

		MasterVolumeSlider.setOpaque(false);
		MasterVolumeSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				master.setMasterVolume(source.getValue() / 100.0f);
			}
		});

		FilterGainSlider.setOpaque(false);
		FilterGainSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				master.setFilMix(source.getValue() / 100.0f);
			}
		});

		FilterGainSlider.setOrientation(SwingConstants.VERTICAL);
		MasterVolumeSlider.setOrientation(SwingConstants.VERTICAL);

		JLabel lblFilterMix = new JLabel("Filter Mix");
		lblFilterMix.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblOscVolume = new JLabel("Osc Volume");
		lblOscVolume.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel OscMixLabel = new JLabel("Osc Mix");
		OscMixLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		OscMixLabel.setLabelFor(SynthPane);

		JLabel lblFilterVolume = new JLabel("Filter Volume");
		lblFilterVolume.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblMasterVolume = new JLabel("Master Volume");
		lblMasterVolume.setFont(new Font("Tahoma", Font.BOLD, 12));

		AttackSlider.setOpaque(false);
		AttackSlider.setToolTipText("");
		AttackSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				// set attack time
				adsr.setAttackTime(source.getValue());
			}
		});

		ReleaseSlider.setOpaque(false);
		ReleaseSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				// set release time

				adsr.setReleaseTime(source.getValue());
			}
		});

		SustainSlider.setOpaque(false);
		SustainSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				// set sustain time

				adsr.setSustainTime(source.getValue());
			}
		});

		DecaySlider.setOpaque(false);
		DecaySlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				// set decay time

				adsr.setDecayTime(source.getValue());
			}
		});

		JLabel lblAttack = new JLabel("A");
		lblAttack.setForeground(Color.WHITE);
		lblAttack.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAttack.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblDecay = new JLabel("D");
		lblDecay.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDecay.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblSustain = new JLabel("S");
		lblSustain.setForeground(Color.WHITE);
		lblSustain.setHorizontalAlignment(SwingConstants.CENTER);
		lblSustain.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblRelease = new JLabel("R");
		lblRelease.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRelease.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblHigh = new JLabel("High");
		lblHigh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHigh.setHorizontalAlignment(SwingConstants.CENTER);

		EqHighSlider.setOpaque(false);
		EqHighSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				eq.setHighFreq((float) source.getValue() / 100);
			}
		});

		JLabel lblMid = new JLabel("Gain");
		lblMid.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMid.setHorizontalAlignment(SwingConstants.CENTER);

		EqHighGainSlider.setOpaque(false);
		EqHighGainSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				eq.setHighGain((float) source.getValue() / 10);
			}
		});

		JLabel lblLow = new JLabel("Low ");
		lblLow.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLow.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel = new JLabel("Gain");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		EqLowSlider.setOpaque(false);
		EqLowSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				eq.setLowFreq((float) source.getValue() / 100);
			}
		});

		EqLowGainSlider.setOpaque(false);
		EqLowGainSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				eq.setLowGain((float) source.getValue() / 10);
			}
		});

		VolumeRightBar = new JProgressBar();
		VolumeRightBar.setStringPainted(true);
		VolumeRightBar.setOrientation(SwingConstants.VERTICAL);

		VolumeLeftBar = new JProgressBar();
		VolumeLeftBar.setStringPainted(true);
		VolumeLeftBar.setOrientation(SwingConstants.VERTICAL);
		
		JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 1635, 100000, 44000);
		slider.setOpaque(false);
		slider.setMinorTickSpacing(50);
		slider.setMajorTickSpacing(50000);
		
		JSlider slider_1 = new JSlider(SwingConstants.HORIZONTAL, 1635, 100000, 44000);
		slider_1.setOpaque(false);
		slider_1.setMinorTickSpacing(50);
		slider_1.setMajorTickSpacing(50000);
		
		JLabel lblWaveShape_1 = new JLabel("Wave Shape");
		lblWaveShape_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblPhase = new JLabel("Phase");
		lblPhase.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblFineTuning = new JLabel("Fine Tuning");
		lblFineTuning.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblTranspose = new JLabel("Transpose");
		lblTranspose.setFont(new Font("Tahoma", Font.BOLD, 12));

		// -----------------------------------\COMPONENTS---------------

		// -----------------------------------LAYOUT---------------------

		GroupLayout gl_OscPanel = new GroupLayout(OscPanel);
		gl_OscPanel.setHorizontalGroup(
			gl_OscPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_OscPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_OscPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_OscPanel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(Osc2FreqSlider, 0, 0, Short.MAX_VALUE)
							.addComponent(Osc1FreqSlider, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
						.addComponent(lblTranspose))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_OscPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(slider, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFineTuning))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_OscPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(Osc1PhaseSlider, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
						.addComponent(Osc2PhaseSlider, 0, 0, Short.MAX_VALUE)
						.addComponent(lblPhase))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_OscPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblWaveShape_1)
						.addComponent(Osc2WvSel, Alignment.TRAILING, 0, 97, Short.MAX_VALUE)
						.addComponent(Osc1WvSel, Alignment.TRAILING, 0, 97, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_OscPanel.setVerticalGroup(
			gl_OscPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_OscPanel.createSequentialGroup()
					.addGroup(gl_OscPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_OscPanel.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_OscPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(Osc1PhaseSlider, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(Osc1WvSel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(Osc1FreqSlider, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_OscPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWaveShape_1)
						.addComponent(lblPhase)
						.addComponent(lblFineTuning)
						.addComponent(lblTranspose))
					.addGap(55)
					.addGroup(gl_OscPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(Osc2WvSel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(Osc2PhaseSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Osc2FreqSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39))
		);

		GroupLayout gl_MasterPanel = new GroupLayout(MasterPanel);
		gl_MasterPanel.setHorizontalGroup(
			gl_MasterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MasterPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(OscMixLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(OscMixSlider, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblOscVolume)
					.addGap(18)
					.addComponent(OscGainSlider, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblFilterMix, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(FilterMixSlider, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFilterVolume, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(FilterGainSlider, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMasterVolume, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(MasterVolumeSlider, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_MasterPanel.setVerticalGroup(
			gl_MasterPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_MasterPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_MasterPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFilterVolume, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(lblMasterVolume, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(lblFilterMix, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(MasterVolumeSlider, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(FilterGainSlider, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(FilterMixSlider, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(OscGainSlider, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(lblOscVolume, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(OscMixSlider, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(OscMixLabel, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
					.addContainerGap())
		);

		GroupLayout gl_TopPanel = new GroupLayout(TopPanel);
		gl_TopPanel.setHorizontalGroup(
			gl_TopPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TopPanel.createSequentialGroup()
					.addGap(2)
					.addComponent(OscPanel, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(FilterPanel, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE))
		);
		gl_TopPanel.setVerticalGroup(
			gl_TopPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TopPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(OscPanel, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
					.addComponent(FilterPanel, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
		);

		GroupLayout gl_PannerPanel = new GroupLayout(PannerPanel);

		gl_PannerPanel.setHorizontalGroup(gl_PannerPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PannerPanel.createSequentialGroup().addGap(7)
						.addComponent(lblL, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE).addGap(18)
						.addComponent(lblR, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE).addGap(7))
				.addGroup(gl_PannerPanel.createSequentialGroup().addContainerGap()
						.addComponent(PanningSlider, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE).addContainerGap()));

		gl_PannerPanel.setVerticalGroup(gl_PannerPanel.createParallelGroup(Alignment.TRAILING).addGroup(gl_PannerPanel
				.createSequentialGroup().addGap(65)
				.addComponent(PanningSlider, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE).addGap(4)
				.addGroup(gl_PannerPanel.createParallelGroup(Alignment.LEADING).addComponent(lblL).addComponent(lblR))
				.addGap(56)));

		GroupLayout gl_FilterPanel = new GroupLayout(FilterPanel);

		gl_FilterPanel
				.setHorizontalGroup(gl_FilterPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_FilterPanel.createSequentialGroup().addContainerGap()
								.addGroup(gl_FilterPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(AddOsc1ToFilter, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
										.addGroup(
												gl_FilterPanel.createSequentialGroup()
														.addComponent(AddOsc2ToFilter, GroupLayout.DEFAULT_SIZE, 106,
																Short.MAX_VALUE)
														.addGap(2)))
								.addGap(18)
								.addGroup(gl_FilterPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_FilterPanel.createSequentialGroup()
												.addComponent(Filter2FreqSlider, GroupLayout.DEFAULT_SIZE, 230,
														Short.MAX_VALUE)
												.addGap(8))
										.addGroup(gl_FilterPanel.createSequentialGroup()
												.addComponent(Filter1FreqSlider, GroupLayout.DEFAULT_SIZE, 234,
														Short.MAX_VALUE)
												.addGap(4)))
								.addGap(2)
								.addGroup(gl_FilterPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(Filter1Combo, 0, 112, Short.MAX_VALUE)
										.addComponent(Filter2Combo, 0, 112, Short.MAX_VALUE))
								.addGap(24)));

		gl_FilterPanel
				.setVerticalGroup(
						gl_FilterPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_FilterPanel
								.createSequentialGroup().addGap(14).addGroup(gl_FilterPanel
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_FilterPanel.createSequentialGroup().addComponent(AddOsc1ToFilter)
												.addPreferredGap(ComponentPlacement.RELATED, 3, Short.MAX_VALUE))
										.addComponent(Filter1FreqSlider, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_FilterPanel.createSequentialGroup()
												.addComponent(Filter1Combo,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)))
								.addGap(97)
								.addGroup(gl_FilterPanel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_FilterPanel.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
												.addComponent(AddOsc2ToFilter))
										.addComponent(Filter2FreqSlider, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_FilterPanel.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
												.addComponent(Filter2Combo, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(38)));

		GroupLayout gl_VolumeBarsPanel = new GroupLayout(VolumeBarsPanel);

		gl_VolumeBarsPanel.setHorizontalGroup(gl_VolumeBarsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_VolumeBarsPanel.createSequentialGroup().addContainerGap()
						.addComponent(VolumeRightBar, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(VolumeLeftBar, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE).addContainerGap()));

		gl_VolumeBarsPanel
				.setVerticalGroup(gl_VolumeBarsPanel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_VolumeBarsPanel.createSequentialGroup().addGap(7)
								.addGroup(gl_VolumeBarsPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(VolumeLeftBar, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
										.addComponent(VolumeRightBar, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
								.addContainerGap()));
		
		JLabel lblFrequency = new JLabel("Frequency");
		lblFrequency.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblAmplitude = new JLabel("Amplitude");
		lblAmplitude.setForeground(Color.WHITE);
		lblAmplitude.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblWaveShape = new JLabel("Wave Shape");
		lblWaveShape.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblApplyLfoTo = new JLabel("Apply LFO to");
		lblApplyLfoTo.setFont(new Font("Tahoma", Font.BOLD, 12));

		GroupLayout gl_LFOPanel = new GroupLayout(LFOPanel);
		gl_LFOPanel.setHorizontalGroup(
			gl_LFOPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_LFOPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_LFOPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(LfoAmplitudeSlider, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
						.addComponent(LfoFrequencySlider, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_LFOPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFrequency)
						.addComponent(lblAmplitude))
					.addGap(91)
					.addGroup(gl_LFOPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblApplyLfoTo)
						.addComponent(lblWaveShape)
						.addGroup(gl_LFOPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(LfoWaveCombo, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addComponent(ApplyLfoCombo, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_LFOPanel.setVerticalGroup(
			gl_LFOPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LFOPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_LFOPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_LFOPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(LfoWaveCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblFrequency))
						.addComponent(LfoFrequencySlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblWaveShape)
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addComponent(lblApplyLfoTo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_LFOPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_LFOPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(ApplyLfoCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblAmplitude))
						.addComponent(LfoAmplitudeSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);

		GroupLayout gl_ADSRPanel = new GroupLayout(ADSRPanel);

		gl_ADSRPanel.setHorizontalGroup(
				gl_ADSRPanel.createParallelGroup(Alignment.TRAILING).addGroup(gl_ADSRPanel.createSequentialGroup()
						.addContainerGap().addGroup(gl_ADSRPanel
								.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
										gl_ADSRPanel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(AttackSlider, GroupLayout.DEFAULT_SIZE, 244,
														Short.MAX_VALUE)
												.addComponent(lblAttack, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
												.addComponent(SustainSlider, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblSustain, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
						.addGroup(gl_ADSRPanel
								.createParallelGroup(Alignment.LEADING).addComponent(lblRelease, Alignment.TRAILING,
										GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING,
										gl_ADSRPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_ADSRPanel.createParallelGroup(Alignment.TRAILING)
														.addComponent(DecaySlider, GroupLayout.PREFERRED_SIZE, 250,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblDecay, GroupLayout.PREFERRED_SIZE, 250,
																GroupLayout.PREFERRED_SIZE))
												.addComponent(ReleaseSlider, GroupLayout.PREFERRED_SIZE, 250,
														GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));

		gl_ADSRPanel.setVerticalGroup(gl_ADSRPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ADSRPanel.createSequentialGroup()
						.addGroup(gl_ADSRPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_ADSRPanel.createSequentialGroup().addGap(4)
										.addComponent(AttackSlider, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblAttack))
								.addGroup(gl_ADSRPanel.createSequentialGroup()
										.addComponent(DecaySlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblDecay)))
						.addGap(18)
						.addGroup(gl_ADSRPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblSustain)
								.addComponent(lblRelease))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(
								gl_ADSRPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(ReleaseSlider, GroupLayout.PREFERRED_SIZE, 36,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(SustainSlider, GroupLayout.PREFERRED_SIZE, 36,
												GroupLayout.PREFERRED_SIZE))
						.addGap(13)));

		GroupLayout gl_EqPanel = new GroupLayout(EqPanel);

		gl_EqPanel
				.setHorizontalGroup(
						gl_EqPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_EqPanel.createSequentialGroup().addContainerGap().addGroup(gl_EqPanel
										.createParallelGroup(Alignment.LEADING).addGroup(
												gl_EqPanel
														.createSequentialGroup().addGroup(gl_EqPanel
																.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(EqLowGainSlider, Alignment.LEADING, 0, 0,
																		Short.MAX_VALUE)
																.addComponent(lblNewLabel, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(EqLowSlider,
																		Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 97,
																		Short.MAX_VALUE))
														.addContainerGap())
										.addGroup(gl_EqPanel.createSequentialGroup().addGroup(gl_EqPanel
												.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblHigh, GroupLayout.PREFERRED_SIZE, 100,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(Alignment.LEADING,
														gl_EqPanel.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(lblLow, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(EqHighSlider, Alignment.LEADING, 0, 0,
																		Short.MAX_VALUE)
																.addComponent(lblMid,
																		Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(EqHighGainSlider, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE, 100,
																		Short.MAX_VALUE)))
												.addContainerGap(58, Short.MAX_VALUE)))));

		gl_EqPanel
				.setVerticalGroup(
						gl_EqPanel
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_EqPanel.createSequentialGroup()
										.addComponent(lblHigh, GroupLayout.PREFERRED_SIZE, 14,
												GroupLayout.PREFERRED_SIZE)
										.addGap(4)
										.addComponent(EqHighSlider, GroupLayout.PREFERRED_SIZE, 19,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblMid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(EqHighGainSlider, GroupLayout.PREFERRED_SIZE, 21,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblLow, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(EqLowSlider, GroupLayout.PREFERRED_SIZE, 21,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
										.addGap(7).addComponent(EqLowGainSlider, GroupLayout.PREFERRED_SIZE, 21,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));

		GroupLayout gl_BottomPanel = new GroupLayout(BottomPanel);
		gl_BottomPanel.setHorizontalGroup(
			gl_BottomPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_BottomPanel.createSequentialGroup()
					.addComponent(LFOPanel, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ADSRPanel, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
		);
		gl_BottomPanel.setVerticalGroup(
			gl_BottomPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_BottomPanel.createSequentialGroup()
					.addGroup(gl_BottomPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(ADSRPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
						.addComponent(LFOPanel, GroupLayout.PREFERRED_SIZE, 173, Short.MAX_VALUE))
					.addContainerGap())
		);

		MasterPanel.setLayout(gl_MasterPanel);
		FilterPanel.setLayout(gl_FilterPanel);
		OscPanel.setLayout(gl_OscPanel);
		FilterPanel.setLayout(gl_FilterPanel);
		PannerPanel.setLayout(gl_PannerPanel);
		TopPanel.setLayout(gl_TopPanel);
		LFOPanel.setLayout(gl_LFOPanel);
		ADSRPanel.setLayout(gl_ADSRPanel);
		BottomPanel.setLayout(gl_BottomPanel);
		EqPanel.setLayout(gl_EqPanel);
		VolumeBarsPanel.setLayout(gl_VolumeBarsPanel);
		SynthPane.setLayout(null);
		SynthPane.add(TopPanel);
		SynthPane.add(BottomPanel);
		SynthPane.add(MasterPanel);
		SynthPane.add(VolumeBarsPanel);
		SynthPane.add(PannerPanel);
		SynthPane.add(EqPanel);
		
		JPanel ReverbPanel = new JPanel();
		ReverbPanel.setOpaque(false);
		ReverbPanel.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), "Reverb", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		ReverbPanel.setBounds(688, 417, 225, 161);
		SynthPane.add(ReverbPanel);
		
		JSlider DampSlider = new JSlider(0,10,5);
		DampSlider.setOpaque(false);
		DampSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				rev.setDamping(source.getValue()/10);
			}
		});
		
		JSlider RoomSlider = new JSlider(0,10,5);
		RoomSlider.setOpaque(false);
		RoomSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				rev.setSize(source.getValue()/10);
			}
		});
		
		JSlider EarlySlider = new JSlider(0,10,10);
		EarlySlider.setOpaque(false);
		EarlySlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				rev.setEarlyReflection((source.getValue()));
			}
		});
		
		JSlider LateSlider = new JSlider(0,10,10);
		LateSlider.setOpaque(false);
		LateSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				rev.setLateReflection((source.getValue()));
			}
		});
		
		JLabel lblDamping = new JLabel("Damping");
		lblDamping.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblRoomSize = new JLabel("Room Size");
		lblRoomSize.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblEarlyReflection = new JLabel("Early Refl");
		lblEarlyReflection.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblLateRefl = new JLabel("Late Refl");
		lblLateRefl.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JRadioButton rdbtnReverbOn = new JRadioButton("ON");
		rdbtnReverbOn.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnReverbOn.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JRadioButton source = (JRadioButton) e.getSource();
				if (source.isSelected()) {
					settings.setReverbOn(true);
				} else {
					settings.setReverbOn(false);
				}
			}
		});
		rdbtnReverbOn.setOpaque(false);
		GroupLayout gl_ReverbPanel = new GroupLayout(ReverbPanel);
		gl_ReverbPanel.setHorizontalGroup(
			gl_ReverbPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ReverbPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ReverbPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ReverbPanel.createSequentialGroup()
							.addComponent(DampSlider, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(RoomSlider, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_ReverbPanel.createSequentialGroup()
							.addComponent(EarlySlider, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LateSlider, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(gl_ReverbPanel.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_ReverbPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDamping)
						.addComponent(lblEarlyReflection))
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addGroup(gl_ReverbPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLateRefl)
						.addComponent(lblRoomSize))
					.addGap(33))
				.addGroup(gl_ReverbPanel.createSequentialGroup()
					.addGap(88)
					.addComponent(rdbtnReverbOn)
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_ReverbPanel.setVerticalGroup(
			gl_ReverbPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ReverbPanel.createSequentialGroup()
					.addComponent(rdbtnReverbOn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ReverbPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(DampSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(RoomSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ReverbPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDamping)
						.addComponent(lblRoomSize))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_ReverbPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEarlyReflection)
						.addComponent(lblLateRefl))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ReverbPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(EarlySlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(LateSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		ReverbPanel.setLayout(gl_ReverbPanel);
		
		JPanel CompressorPanel = new JPanel();
		CompressorPanel.setOpaque(false);
		CompressorPanel.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), "Compressor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		CompressorPanel.setBounds(923, 417, 224, 161);
		SynthPane.add(CompressorPanel);
		
		JSlider ThresholdSlider = new JSlider(0, 10, 5);
		ThresholdSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				compressor.setThreshold(source.getValue()/10);
			}
		});
		ThresholdSlider.setOpaque(false);
		
		JSlider RatioSlider = new JSlider(2, 10, 4);
		RatioSlider.setMajorTickSpacing(2);
		RatioSlider.setSnapToTicks(true);
		RatioSlider.setMinorTickSpacing(1);
		RatioSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				compressor.setRatio(source.getValue());
			}
		});
		RatioSlider.setOpaque(false);
		
		JLabel lblThreshold = new JLabel("Threshold");
		lblThreshold.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblRatio = new JLabel("Ratio");
		lblRatio.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblAttackComp = new JLabel("Attack");
		lblAttackComp.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblDecayComp = new JLabel("Decay");
		lblDecayComp.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JSlider CompAttackSlider = new JSlider(0, 1000, 500);
		CompAttackSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				compressor.setAttack(source.getValue());
			}
		});
		CompAttackSlider.setOpaque(false);
		
		JSlider CompDecaySlider = new JSlider(0, 1000, 500);
		CompDecaySlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				compressor.setDecay(source.getValue());
			}
		});
		CompDecaySlider.setOpaque(false);
		
		JRadioButton radioCompressorOn = new JRadioButton("ON");
		radioCompressorOn.setFont(new Font("Tahoma", Font.BOLD, 12));
		radioCompressorOn.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JRadioButton source = (JRadioButton) e.getSource();
				if (source.isSelected()) {
					settings.setCompressorOn(true);
				} else {
					settings.setCompressorOn(false);
				}
			}
		});
		radioCompressorOn.setOpaque(false);
		
		GroupLayout gl_CompressorPanel = new GroupLayout(CompressorPanel);
		gl_CompressorPanel.setHorizontalGroup(
			gl_CompressorPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CompressorPanel.createSequentialGroup()
					.addGroup(gl_CompressorPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_CompressorPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_CompressorPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_CompressorPanel.createSequentialGroup()
									.addComponent(ThresholdSlider, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(RatioSlider, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_CompressorPanel.createSequentialGroup()
									.addComponent(CompAttackSlider, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(CompDecaySlider, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_CompressorPanel.createSequentialGroup()
									.addGap(27)
									.addGroup(gl_CompressorPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblThreshold)
										.addComponent(lblAttackComp))
									.addGap(56)
									.addGroup(gl_CompressorPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDecayComp, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblRatio, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_CompressorPanel.createSequentialGroup()
							.addGap(91)
							.addComponent(radioCompressorOn)))
					.addContainerGap())
		);
		gl_CompressorPanel.setVerticalGroup(
			gl_CompressorPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_CompressorPanel.createSequentialGroup()
					.addComponent(radioCompressorOn)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_CompressorPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(ThresholdSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(RatioSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_CompressorPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRatio)
						.addComponent(lblThreshold))
					.addGap(18)
					.addGroup(gl_CompressorPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDecayComp)
						.addComponent(lblAttackComp))
					.addGap(6)
					.addGroup(gl_CompressorPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(CompAttackSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(CompDecaySlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		CompressorPanel.setLayout(gl_CompressorPanel);
		lblBackground = new JLabel("Background");
		
		
		lblBackground.setEnabled(true);
		lblBackground.setBounds(0, 0, 1294, 593);
		lblBackground.setIcon(new ImageIcon(new ImageIcon (GUI.class.getResource("/Pics/background.jpg")).getImage().getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(), Image.SCALE_DEFAULT)));
		SynthPane.add(lblBackground);
		
		

		
		// ----------------------------------\LAYOUT---------------------

	}

	public void volumeBars(float v, float pan) {

		float volume = v * 100.0f;
		System.out.println("volume: " + volume);
		System.out.println("pan: " + pan);
		if (pan == 0) {
			VolumeLeftBar.setValue((int) volume / 2);
			VolumeRightBar.setValue((int) volume / 2);
		} else if (pan < 0) {
			int leftVolume = (int) Math.abs((pan * volume) + volume / 2);
			int rightVolume = (int) (volume / 2 -  Math.abs((pan * volume)));
			VolumeLeftBar.setValue(leftVolume);
			VolumeRightBar.setValue(rightVolume);
		} else if (pan > 0) {
			int rightVolume = (int) ((pan * volume) + volume / 2);
			int leftVolume = (int) ((volume / 2) - (pan * volume));
			VolumeLeftBar.setValue(leftVolume);
			VolumeRightBar.setValue(rightVolume);
		}
	}

	public void volumeBarsReset() {
		VolumeLeftBar.setValue(MIN_VOLUME);
		VolumeRightBar.setValue(MIN_VOLUME);
	}
}


