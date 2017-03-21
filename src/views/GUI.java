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

public class GUI extends JFrame {
	
	Audio audio = Audio.getAudio();
	Settings settings = Settings.getSettings();
	//Settings settings = new Settings();
	//Oscillator oscillator1;

	private JPanel contentPane;

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
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		//OSC1 slider
		JSlider Osc1FreqSlider = new JSlider(SwingConstants.HORIZONTAL,0, 1000, 440);
		Osc1FreqSlider.setMajorTickSpacing(500);
		Osc1FreqSlider.setMinorTickSpacing(50);
		Osc1FreqSlider.setPaintLabels(true);
		
		JSlider slider_4 = new JSlider();
		slider_4.setOrientation(SwingConstants.VERTICAL);
		
		JSlider slider_1 = new JSlider();
		
		JSlider Osc2FreqSlider = new JSlider(SwingConstants.HORIZONTAL,0, 1000, 440);
		Osc1FreqSlider.setMajorTickSpacing(500);
		Osc1FreqSlider.setMinorTickSpacing(50);
		Osc1FreqSlider.setPaintLabels(true);
		Osc2FreqSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				settings.setOsc2Freq((float)source.getValue());
			}
		});
		
		
		JSlider slider_3 = new JSlider();
		
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
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(Osc1FreqSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(Osc2FreqSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(slider_1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
						.addComponent(slider_3, 0, 0, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(Osc2WvSel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Osc1WvSel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(slider_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(slider_4, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(Osc1FreqSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(slider_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(Osc1WvSel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(Osc2FreqSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(Osc2WvSel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(slider_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(30))
		);
		panel_2.setLayout(gl_panel_2);
		Osc1FreqSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				settings.setOsc1Freq((float)source.getValue());
				
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("AddOsc1ToFilter");
		
		JSlider slider_2 = new JSlider();
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("AddOsc2ToFilter");
		
		JSlider slider = new JSlider();
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Low Pass", "High Pass", "AllPass"}));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(rdbtnNewRadioButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(rdbtnNewRadioButton_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(slider_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(160, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap(375, Short.MAX_VALUE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(slider_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnNewRadioButton_1))
					.addGap(36)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(rdbtnNewRadioButton))
					.addGap(38))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		JPanel MasterPanel = new JPanel();
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
		contentPane.setLayout(gl_contentPane);
	}
}
