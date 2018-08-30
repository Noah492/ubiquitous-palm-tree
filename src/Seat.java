// Noah Drew - 8/22/18
// Seat class contains methods for turning on and off its call light

public class Seat {
	// Starting variable
	private boolean isCallLightOn = false;

	// Turns on light
	public void turnOnCallLight() {
		this.isCallLightOn = true;
	}
	
	// Turns off light
	public void turnOffCallLight() {
		this.isCallLightOn = false;
	}
	
	// Gets the light's current state
	public boolean getCallLightState() {
		return this.isCallLightOn;
	}
}
