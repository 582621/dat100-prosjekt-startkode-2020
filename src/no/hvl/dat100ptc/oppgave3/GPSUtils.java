package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START
		min = da[0];
		
		for (double m : da) {
			if(m < min) {
				min = m;
			}
		}
		return min;
		// TODO - SLUTT
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double[] latitudes =new double[gpspoints.length];
		for(int i = 0; i < gpspoints.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		return latitudes;
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double[] longitudes =new double[gpspoints.length];
		for(int i = 0; i < gpspoints.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		return longitudes;
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START
		latitude1 = gpspoint1.getLatitude();
		latitude2 = gpspoint2.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		longitude2  = gpspoint2.getLongitude();
		
		double a = pow(sin(toRadians(latitude2 - latitude1)/2.0), 2) + cos(toRadians(latitude1)) * cos(toRadians(latitude2)) 
				* pow(sin(toRadians(longitude2 - longitude1)/2.0), 2);
		
		double c = 2 * atan2(sqrt(a), sqrt(1 - a));
		
		return d = R * c;
		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START
		secs = gpspoint2.getTime() - gpspoint1.getTime();
		speed = (distance(gpspoint1, gpspoint2)/1000.0) / (secs/3600.0);
		return speed;
		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		
		// TODO - START'
		String hh = String.format("%02d", secs/3600);
		String mm = String.format("%02d", secs%3600/60);
		String ss = String.format("%02d", secs%3600%60);
		return timestr = String.format("%10s", hh+TIMESEP+mm+TIMESEP+ss);
		// TODO - SLUTT
	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START
		d = d*100;
		d = Math.round(d);
		d = (d/100);
		String s = Double.toString(d);
		return str = String.format("%10s", s);
		// TODO - SLUTT
		
	}
}
