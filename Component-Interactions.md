
![Picture3](https://github.com/user-attachments/assets/625a25ed-87a6-4ad5-bbd3-7ebaea55a15d)

**Components and Their Interactions**

1. Raspberry Pi

●	Role:
  -	Acts as the central control unit, running the operating system and software that controls other hardware components. It processes input from the distance sensor and translates it into output commands for the motor driver. 

 ● Communication:

  -	Communicates with the motor driver via GPIO pins.
  
  -	Uses I2C to interact with the distance sensor if the sensor is digital.

  -	Power is supplied through its dedicated input from a Polymer Lithium Ion Battery, ensuring that the Raspberry Pi has a stable and isolated power source.


2. Motor Driver (H-Bridge)
 
 ● Role: 
  
  -	Controls the direction and speed of motors based on commands from the Raspberry Pi. It can control multiple motors independently and is crucial for executing precise movements.

●	Communication:
  
  -	Receives control signals from the Raspberry Pi through multiple GPIO pins. These signals determine the logic levels that control the motor directions and speeds.
  
  -	Connected directly to the motors via output pins.

 ● Power:
   
  -	Powered by a separate battery pack (AA Battery x4), which provides the necessary current and voltage without burdening the Raspberry Pi’s power source.


3. Motors

●	Role:
  
  - Execute mechanical movements to drive the robot's wheels.

●	Communication:
  
  - Controlled by the motor driver. Each motor’s operation is influenced by the motor driver's output, which changes based on the control logic received from the Raspberry Pi.

●	Power:
  
  - Powered through the motor driver, allowing for changes in polarity which control the direction and speed.


4. Distance Sensor

●	Role: 
  
  -	Measures the distance to objects in front of the robot, using infrared sensors.

●	Communication:
    
  -	Connects to the Raspberry Pi GPIO.

●	Power:
  
  - Powered from the Raspberry Pi GPIO.


5. Batteries

  ●	USB-C Lithium Ion Battery to power the Raspberry Pi.
  

  ●	AA Batteries to power the motor driver.

  

**System Communication Flow**

1.	Input Processing:

  ●	The distance sensor detects objects and sends the data to the Raspberry Pi. This data is processed to determine necessary movements.

2.	Decision Making:

  ●	The Raspberry Pi processes the input data, applying logic to decide the motor outputs required to avoid obstacles or to follow a path.

3.	Output Execution:

  ●	Commands are sent from the Raspberry Pi to the motor driver, specifying which motors to activate and the direction/speed for each.
  
  ●	The motor driver executes these commands, applying power to the motors accordingly.

4.	Feedback Loop (not explicitly shown but implied):

  ●	Sensors provide feedback on motor status or position back to the Raspberry Pi to confirm movements or adjust commands dynamically
