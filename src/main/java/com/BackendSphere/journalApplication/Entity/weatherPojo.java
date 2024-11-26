package com.BackendSphere.journalApplication.Entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class weatherPojo {
	

	
	public class Current{
	    public int getTemperature() {
			return temperature;
		}
		public void setTemperature(int temperature) {
			this.temperature = temperature;
		}
		public ArrayList<String> getWeatherDescriptions() {
			return weatherDescriptions;
		}
		public void setWeatherDescriptions(ArrayList<String> weatherDescriptions) {
			this.weatherDescriptions = weatherDescriptions;
		}
		public int getFeelslike() {
			return feelslike;
		}
		public void setFeelslike(int feelslike) {
			this.feelslike = feelslike;
		}
		public int temperature;
	    @JsonProperty("weather_descriptions")
	    public ArrayList<String> weatherDescriptions;
	    public int feelslike;
	}

	    public Current getCurrent() {
			return current;
		}

		public void setCurrent(Current current) {
			this.current = current;
		}

		public Current current;
	
	
	

	


}
