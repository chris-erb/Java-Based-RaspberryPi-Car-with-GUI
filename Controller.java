import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.pi4j.io.gpio.*;

public class Controller {
    private GUI gui;
    
    // Create GPIO Controller
    final GpioController gpio = GpioFactory.getInstance();
 
    GpioPinDigitalOutput MOTORS[] = {
	gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "Front L", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "Front R", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "Back L", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "Back R", PinState.LOW)
	};

    private Controller(GUI gui) {
        this.gui = gui;
        final GpioController gpio = GpioFactory.getInstance();
        
        gui.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char key = e.getKeyChar();
                switch (key) {
                    case 'w':
                        moveForward();
                        System.err.println("Moving forward.");
                        break;
                    case 's':
                        moveBackward();
                        System.err.println("Moving backward.");
                        break;
                    case 'a':
                        turnLeft();
                        System.err.println("Moving left.");
                        break;
                    case 'd':
                        turnRight();
                        System.err.println("Moving right.");
                        break;
                    default:
                    // Set all pins to low if any other key than 'WASD' is pressed.
                    	MOTORS[0].low();
			MOTORS[1].low();
			MOTORS[2].low();
			MOTORS[3].low();
                    
                }
            }
        });
    }

    private void moveForward() {
        MOTORS[0].high();
        MOTORS[1].high();
        MOTORS[2].low();
        MOTORS[3].low();
    }

    private void moveBackward() {
        MOTORS[0].low();
        MOTORS[1].low();
        MOTORS[2].high();
        MOTORS[3].high();
    }

    private void turnLeft() {
        MOTORS[0].high();
        MOTORS[1].low();
        MOTORS[2].high();
        MOTORS[3].low();
    }

    private void turnRight() {
        MOTORS[0].low();
        MOTORS[1].high();
        MOTORS[2].low();
        MOTORS[3].high();
    }

    public static void main(String[] args) {
	// Create a GUI object and a Controller object (utilizing GUI object)
        GUI gui = new GUI();
        Controller controller = new Controller(gui);

        // Display the GUI
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Robot Controller");
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(gui);
        frame.setVisible(true);
    }
}
