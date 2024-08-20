Branch Coverage Analysis:

1.	IR Sensor State Handling: This critical branch of the system's functionality deals with input from the IR sensor. If the sensor detects an object (IR Sensor Value = High), the system executes a series of commands to halt motor functions and reset the user interface. This path logs the event and indicates to the user that movement has been stopped due to detected obstacles.

2.	Default Operation (No Obstacle Detected): When no obstacle is detected (IR Sensor Value = Low), the system continues regular operations, allowing for user input to direct the robot’s movement.

3-6. Directional Control: Depending on the user input ('w', 's', 'a', 'd'), the system directs the robot to move forward, backward, left, or right.

7.	Non-Directional Input Handling: Any input other than the defined directional controls results in all motors being turned off, ensuring the system remains in a safe state when receiving unexpected inputs.

![Picture2](https://github.com/user-attachments/assets/fc5ebaf9-c56f-41c7-8f5e-368b38b8f04e)


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


Branch Coverage Testing:

![Picture1](https://github.com/user-attachments/assets/ae6c37f1-d08a-4b96-b28f-060f716c096f)
