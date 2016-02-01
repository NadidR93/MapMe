package me.MapMe;

public class Worker extends Thread{
	
	LocationValues loc;
	int id;
	public final double R = 6372.8; // In kilometers
	private double distance=0;
	
	public Worker(int id, LocationValues loc) {
		this.id = id;
		this.loc=loc;
	}
	@Override
	public void run(){
		distance=haversine(loc.getLatOrig(), loc.getLatOrig(), loc.getLngDest(), loc.getLngDest());
		System.out.println("Distance is: "+distance);
	}

    public double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
 
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }

	
	public double getDistance() {
		return distance;
	}
}
