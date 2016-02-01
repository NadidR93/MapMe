package me.MapMe;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MapMe{
	
	private String myLoc="Fairfax, VA";
	private int countVal=0;
	private String other="Herndon, VA";
	private double latOrig;
	private double lngOrig;
	private double latDest;
	private double lngDest;
	private double distance=0;
	ArrayList<LocationValues> locations=new ArrayList<LocationValues>();
	
	
	
	/*protected void doGet(HttpServletRequest request, 
    HttpServletResponse response) throws ServletException, IOException {
		latOrig=request.getParameter("latO");
		lngOrig=request.getParameter("lngO");
		latDest=request.getParameter("latD");
		lngDest=request.getParameter("lngD");
		request.getSession().removeAttribute("errorMessage");
		System.out.println("lat: --" + latOrig);
		
		
		//request.setAttribute("latOrig", latOrig);
		
		PrintWriter out = response.getWriter();
		out.write("result: " + latOrig);
		//response.sendRedirect("/NewWorld.jsp?latOrig=bbar");
		
		
        //request.getRequestDispatcher("/NewWorld.jsp").forward(request, response);
	}*/
	
	public double getDistance() {
		return distance;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public double getLatOrig(){
		return latOrig;
	}
	public void setLatOrig(double latOrig){
		this.latOrig=latOrig;
	}

	
	public double getLngOrig(){
		return lngOrig;
	}
	public void setLngOrig(double lngOrig){
		this.lngOrig=lngOrig;
	}
	
	public double getLatDest(){
		return latDest;
	}
	public void setLatDest(double latDest){
		this.latDest=latDest;
	}
	
	public double getLngDest(){
		return lngDest;
	}
	public void setLngDest(double lngDest){
		this.lngDest=lngDest;
	}
	
	public String getMyLoc(){
		System.out.println("My Loc is: "+myLoc);
		return myLoc;
	}
	
	public void getMyLoc(String loc){
		System.out.println("My Loc is: "+myLoc);
		myLoc=loc;
	}
	
	public int getCountVal(){
		return countVal;
	}
	
	public void incCountVal(){
		countVal=countVal+1;
		locations.add(new LocationValues(latOrig, latDest, lngOrig, lngDest));
		System.out.println("Lat origin is: "+latOrig);
	}
	
	public String getOther(){
		return other;
	}
	
	
	public void haversineCalc() {
		
		Worker[] workers = new Worker[locations.size()];
		
		for (int i = 0; i < locations.size(); i++) {
			
			workers[i] = new Worker(i, locations.get(i));
			
			System.out.println("new thread started:"+workers[i].id);
			
			workers[i].start();
			distance=workers[i].getDistance();
			
		}
		
		try {
			for (Worker w: workers) {
				w.join();
				distance=w.getDistance();
				System.out.println("Thread " + w.id+": "+ w.getDistance());
				
			}
		} catch (InterruptedException e) { }
	}
    
    
	public static void main(String [] args){
		
		MapMe me=new MapMe();
		me.locations.add(new LocationValues(0,50.2,100,20.3));
		me.locations.add(new LocationValues(0,50.2,100,20.3));
		me.haversineCalc();
		System.out.println("Hello");
		//System.out.println(haversine(0,50.2,100,20.3));
		

	}

}
