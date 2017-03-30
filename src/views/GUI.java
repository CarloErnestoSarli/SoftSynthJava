package views;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import net.beadsproject.beads.ugens.OscillatorBank;

import javax.swing.event.ChangeEvent;

import source.*;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
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

public class GUI extends JFrame {
	
	Audio audio = Audio.getAudio();
	Settings settings = Settings.getSettings();
	ADSR adsr = ADSR.getADSR();
	Master master = Master.getMaster();
	
	private final int MIN_VOLUME = 0;
	private final int MAX_VOLUME = 100;
	private final int LEFT = -10;
	private final int RIGHT = 10;
	private  final int START_VOLUME = 50;
	private final int START_POSITION = 0;
	
	private JPanel contentPane;
	private JComboBox Filter1Combo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1052, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel OscPanel = new JPanel();
		OscPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.add(OscPanel);
		
		//OSC1 slider
		JSlider Osc1FreqSlider = new JSlider(SwingConstants.HORIZONTAL,0, 1000, 440);
		Osc1FreqSlider.setMajorTickSpacing(500);
		Osc1FreqSlider.setMinorTickSpacing(50);
		Osc1FreqSlider.setPaintLabels(true);
		
		JSlider Osc1PhaseSlider = new JSlider();
		Osc1PhaseSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				settings.setWave1Phase((float)source.getValue());
			}
		});
		
		JSlider Osc2FreqSlider = new JSlider(SwingConstants.HORIZONTAL,0, 1000, 440);
		Osc2FreqSlider.setMinorTickSpacing(50);
		Osc2FreqSlider.setMajorTickSpacing(500);
		Osc2FreqSlider.setPaintLabels(true);
		Osc1FreqSlider.setMajorTickSpacing(500);
		Osc1FreqSlider.setMinorTickSpacing(50);
		Osc1FreqSlider.setPaintLabels(true);
		Osc2FreqSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				settings.setOsc2Freq((float)source.getValue());
			}
		});
		
		
		JSlider Osc2PhaseSlider = new JSlider();
		Osc2PhaseSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				settings.setWave2Phase((float)source.getValue());
			}
		});
		
		JComboBox Osc1WvSel = new JComboBox();
		Osc1WvSel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				settings.setWave1Sel(cb.getSelectedItem().toString());
				System.out.println(cb.getSelectedItem().toString());
			}
		});
		Osc1WvSel.setModel(new DefaultComboBoxModel(new String[] {"Sine", "Square", "Saw", "Triangle", "Noise"}));
		Osc1WvSel.setToolTipText("");
		
		JComboBox Osc2WvSel = new JComboBox();
		Osc2WvSel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				settings.setWave2Sel(cb.getSelectedItem().toString());
				System.out.println(cb.getSelectedItem().toString());
			}
		});
		Osc2WvSel.setModel(new DefaultComboBoxModel(new String[] {"Sine", "Square", "Saw", "Triangle", "Noise"}));
		GroupLayout gl_OscPanel = new GroupLayout(OscPanel);
		gl_OscPanel.setHorizontalGroup(
			gl_OscPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_OscPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_OscPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(Osc2FreqSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(Osc1FreqSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_OscPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(Osc1PhaseSlider, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
						.addComponent(Osc2PhaseSlider, 0, 0, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_OscPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(Osc2WvSel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(Osc1WvSel, 0, 77, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_OscPanel.setVerticalGroup(
			gl_OscPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_OscPanel.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_OscPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(Osc1PhaseSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Osc1FreqSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Osc1WvSel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
					.addGroup(gl_OscPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(Osc2PhaseSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Osc2FreqSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Osc2WvSel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		OscPanel.setLayout(gl_OscPanel);
		Osc1FreqSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				settings.setOsc1Freq((float)source.getValue());
				
			}
		});
		
		JPanel FilterPanel = new JPanel();
		FilterPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.add(FilterPanel);
		
		JRadioButton AddOsc1ToFilter = new JRadioButton("AddOsc1ToFilter");
		AddOsc1ToFilter.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JRadioButton source = (JRadioButton) e.getSource();
				if(source.isSelected()){
					settings.setFilterWave1(true);
				}else{
					settings.setFilterWave1(false);
				}
			}
		});
		
		JSlider Filter1FreqSlider = new JSlider(0, 1000, 440);
		Filter1FreqSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				//set filter frequency
				settings.setFilter1Freq((float)source.getValue());
			}
		});
		
		JRadioButton AddOsc2ToFilter = new JRadioButton("AddOsc2ToFilter");
		AddOsc2ToFilter.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JRadioButton source = (JRadioButton) e.getSource();
				if(source.isSelected()){
					settings.setFilterWave2(true);
				}else{
					settings.setFilterWave2(false);
				}
			}
		});
		
		JSlider Filter2FreqSlider = new JSlider(0, 10, 3);
		Filter2FreqSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				//set filter gain
				settings.setFilter2Freq((float)source.getValue());
			}
		});
		
		Filter1Combo = new JComboBox();
		Filter1Combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				//set filter type
				settings.setFilter1Sel(cb.getSelectedItem().toString());
				//System.out.println(cb.getSelectedItem().toString());
			}
		});
		Filter1Combo.setModel(new DefaultComboBoxModel(new String[] {"LowPass", "HighPass", "AllPass"}));
		
		JComboBox Filter2Combo = new JComboBox();
		Filter2Combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				//set filter type
				settings.setFilter2Sel(cb.getSelectedItem().toString());
				//System.out.println(cb.getSelectedItem().toString());
			}
		});
		Filter2Combo.setModel(new DefaultComboBoxModel(new String[] {"LowPass", "HighPass", "AllPass"}));
		GroupLayout gl_FilterPanel = new GroupLayout(FilterPanel);
		gl_FilterPanel.setHorizontalGroup(
			gl_FilterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FilterPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_FilterPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(AddOsc1ToFilter)
						.addComponent(AddOsc2ToFilter))
					.addGap(18)
					.addGroup(gl_FilterPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(Filter2FreqSlider, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
						.addComponent(Filter1FreqSlider, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_FilterPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(Filter1Combo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(Filter2Combo, 0, 112, Short.MAX_VALUE))
					.addGap(24))
		);
		gl_FilterPanel.setVerticalGroup(
			gl_FilterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FilterPanel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_FilterPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(AddOsc1ToFilter)
						.addComponent(Filter1FreqSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Filter1Combo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(97)
					.addGroup(gl_FilterPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(AddOsc2ToFilter)
						.addComponent(Filter2FreqSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Filter2Combo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38))
		);
		FilterPanel.setLayout(gl_FilterPanel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel LFOPanel = new JPanel();
		LFOPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.add(LFOPanel);
		GroupLayout gl_LFOPanel = new GroupLayout(LFOPanel);
		gl_LFOPanel.setHorizontalGroup(
			gl_LFOPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 511, Short.MAX_VALUE)
		);
		gl_LFOPanel.setVerticalGroup(
			gl_LFOPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 165, Short.MAX_VALUE)
		);
		LFOPanel.setLayout(gl_LFOPanel);
		
		JPanel ADSRPanel = new JPanel();
		ADSRPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.add(ADSRPanel);
		
		JSlider AttackSlider = new JSlider(0, 1000, 500);
		AttackSlider.setToolTipText("");
		AttackSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				//set attack time
				adsr.setAttackTime((float)source.getValue());
			}
		});
		
		JSlider ReleaseSlider = new JSlider(0, 1000, 500);
		ReleaseSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				//set release time

				adsr.setReleaseTime((float)source.getValue());
			}
		});
		
		JSlider SustainSlider = new JSlider(0, 1000, 500);
		SustainSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				//set sustain time

				adsr.setSustainTime((float)source.getValue());
			}
		});
		
		JSlider DecaySlider = new JSlider(0, 1000, 500);
		DecaySlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				//set decay time

				adsr.setDecayTime((float)source.getValue());
			}
		});
		
		JLabel lblAttack = new JLabel("A");
		lblAttack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAttack.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblDecay = new JLabel("D");
		lblDecay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDecay.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblSustain = new JLabel("S");
		lblSustain.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblRelease = new JLabel("R");
		lblRelease.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRelease.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout gl_ADSRPanel = new GroupLayout(ADSRPanel);
		gl_ADSRPanel.setHorizontalGroup(
			gl_ADSRPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ADSRPanel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_ADSRPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ADSRPanel.createSequentialGroup()
							.addComponent(SustainSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
							.addComponent(ReleaseSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_ADSRPanel.createSequentialGroup()
							.addComponent(AttackSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
							.addComponent(DecaySlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(26))
				.addGroup(gl_ADSRPanel.createSequentialGroup()
					.addGap(127)
					.addGroup(gl_ADSRPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblAttack)
						.addComponent(lblSustain))
					.addPreferredGap(ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
					.addGroup(gl_ADSRPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDecay)
						.addComponent(lblRelease))
					.addGap(122))
		);
		gl_ADSRPanel.setVerticalGroup(
			gl_ADSRPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ADSRPanel.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_ADSRPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(AttackSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(DecaySlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ADSRPanel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_ADSRPanel.createSequentialGroup()
							.addComponent(lblAttack)
							.addGap(35)
							.addComponent(lblSustain)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(SustainSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_ADSRPanel.createSequentialGroup()
							.addComponent(lblDecay)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblRelease)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(ReleaseSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		ADSRPanel.setLayout(gl_ADSRPanel);
		
		JPanel MasterPanel = new JPanel();
		MasterPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1023, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1023, GroupLayout.PREFERRED_SIZE)
				.addComponent(MasterPanel, GroupLayout.PREFERRED_SIZE, 1023, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addComponent(MasterPanel, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
		);
		
		JSlider OscMixSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
		OscMixSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				float value = (float)source.getValue();
				master.setOsc1Gain(value/100.0f);
				master.setOsc2Gain(((float)MAX_VOLUME - value)/100.0f);
			}
		});
		OscMixSlider.setOrientation(SwingConstants.VERTICAL);
		
		JSlider OscGainSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
		OscGainSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				master.setOscMix((float)source.getValue()/100.0f);
			}
		});
		OscGainSlider.setOrientation(SwingConstants.VERTICAL);
		
		JSlider FilterMixSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
		FilterMixSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				float value = (float)source.getValue();
				master.setFil1Gain(value/100.0f);
				master.setFil2Gain(((float)MAX_VOLUME - value)/100.0f);
			}
		});
		FilterMixSlider.setOrientation(SwingConstants.VERTICAL);
		
		JSlider PanningSlider = new JSlider(LEFT, RIGHT, START_POSITION);
		PanningSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				master.setPannerPosition((float)source.getValue()/10.0f);
			}
		});
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setOrientation(SwingConstants.VERTICAL);
		
		JSlider FilterGainSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
		FilterGainSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				master.setFilMix((float)source.getValue()/100.0f);
			}
		});
		FilterGainSlider.setOrientation(SwingConstants.VERTICAL);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setOrientation(SwingConstants.VERTICAL);
		
		JSlider MasterVolumeSlider = new JSlider(MIN_VOLUME, MAX_VOLUME, START_VOLUME);
		MasterVolumeSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				master.setMasterVolume((float)source.getValue()/100.0f);
			}
		});
		MasterVolumeSlider.setOrientation(SwingConstants.VERTICAL);
		GroupLayout gl_MasterPanel = new GroupLayout(MasterPanel);
		gl_MasterPanel.setHorizontalGroup(
			gl_MasterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MasterPanel.createSequentialGroup()
					.addComponent(OscMixSlider, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(OscGainSlider, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(FilterMixSlider, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(FilterGainSlider, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(MasterVolumeSlider, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(PanningSlider, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addComponent(progressBar_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		gl_MasterPanel.setVerticalGroup(
			gl_MasterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MasterPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_MasterPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_MasterPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(OscGainSlider, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(OscMixSlider, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
							.addComponent(FilterGainSlider, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(FilterMixSlider, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
							.addComponent(MasterVolumeSlider, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
							.addComponent(PanningSlider, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
							.addComponent(progressBar_1, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		MasterPanel.setLayout(gl_MasterPanel);
		contentPane.setLayout(gl_contentPane);
	}
}
