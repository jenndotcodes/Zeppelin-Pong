import java.awt.EventQueue;
import sun.audio.*;
import java.io.*;
import java.net.MalformedURLException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.JFrame;


public class PongGame
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
        {
           public void run()
           {
              JFrame frame = new JFrame();
              frame.setTitle("Game of Pong");               
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              frame.setVisible(true);
              Board board = new Board();
              frame.add(board);
              frame.pack();
              music();
           }
        });
	}
	
	public static void music()
	{
		 try {
		        // From file
		        Sequence sequence = MidiSystem.getSequence(new File("WholeLottaLove.mid"));
		    
		        // From URL
		       // sequence = MidiSystem.getSequence(new URL("http://hostname/midiaudiofile"));
		    
		        // Create a sequencer for the sequence
		        Sequencer sequencer = MidiSystem.getSequencer();
		        sequencer.open();
		        sequencer.setSequence(sequence);
		        sequencer.setLoopCount(1000);
		        // Start playing
		        sequencer.start();
		    } catch (MalformedURLException e) {
		    } catch (IOException e) {
		    } catch (MidiUnavailableException e) {
		    } catch (InvalidMidiDataException e) {
		    }
	}
}
