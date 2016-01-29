package me.MapMe;

public class LocationValues {
	private double latOrig=0;
	private double lngOrig=0;
	private double latDest=0;
	private double lngDest=0;
	
	public LocationValues(double latO, double lngO, double latD, double lngD){
		this.latOrig=latO;
		this.lngOrig=lngO;
		this.latDest=latD;
		this.lngDest=lngD;
	}
	
	public double getLatOrig(){
		return latOrig;
	}
	
	public double getLngOrig(){
		return lngOrig;
	}
	
	public double getLatDest(){
		return latDest;
	}
	
	public double getLngDest(){
		return lngDest;
	}
}
