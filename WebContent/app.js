
var geocoder;
var map;
function initialize() {
  geocoder = new google.maps.Geocoder();
  var latlng = new google.maps.LatLng(-34.397, 150.644);
  var mapOptions = {
    zoom: 8,
    center: latlng,
    styles: [{featureType:"administrative",stylers:[{visibility:"off"}]},{featureType:"poi",stylers:[{visibility:"simplified"}]},{featureType:"road",elementType:"labels",stylers:[{visibility:"simplified"}]},{featureType:"water",stylers:[{visibility:"simplified"}]},{featureType:"transit",stylers:[{visibility:"simplified"}]},{featureType:"landscape",stylers:[{visibility:"simplified"}]},{featureType:"road.highway",stylers:[{visibility:"off"}]},{featureType:"road.local",stylers:[{visibility:"on"}]},{featureType:"road.highway",elementType:"geometry",stylers:[{visibility:"on"}]},{featureType:"water",stylers:[{color:"#84afa3"},{lightness:52}]},{stylers:[{saturation:-17},{gamma:0.36}]},{featureType:"transit.line",elementType:"geometry",stylers:[{color:"#3f518c"}]}]
  }
  map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
}

function codeAddress() {
  var address = document.getElementById('address').value;
  geocoder.geocode( { 'address': address}, function(results, status) {
    if (status == google.maps.GeocoderStatus.OK) {
      map.setCenter(results[0].geometry.location);
      var marker = new google.maps.Marker({
          map: map,
          position: results[0].geometry.location
      });
    } else {
      alert('Geocode was not successful for the following reason: ' + status);
    }
  });
}

function getCoord(){
codeAddress();
var address1 = document.getElementById('address').value;
var address2 = document.getElementById('address2').value;
var mygc = new google.maps.Geocoder();
var locationOrigem;
var locationDestino;
var latOrigem  = 0;
var longOrigem = 0;
var latDestino  = 0;
var longDestino = 0;

mygc.geocode({'address' : address1}, function(results, status){


    locationOrigem = results[0].geometry.location;
    latOrigem   = results[0].geometry.location.lat();
    longOrigem  = results[0].geometry.location.lng();

    console.log("entering geocode");
    mygc.geocode({'address' : address2}, function(results, status){

        locationDestino = results[0].geometry.location;
        latDestino  = results[0].geometry.location.lat();
        longDestino = results[0].geometry.location.lng();

        console.log("lat 1: " + latOrigem);
        console.log("long 1: "+ longOrigem);
        
        document.getElementById("latO").value=latOrigem;
        document.getElementById("lngO").value=longOrigem;
        document.getElementById("latD").value=latDestino;
        document.getElementById("lngD").value=longDestino;
        
        
//        var line = new google.maps.Polyline({
//            path: [new google.maps.LatLng(37.4419, -122.1419), new google.maps.LatLng(37.4519, -122.1519)],
//            strokeColor: "#FF0000",
//            strokeOpacity: 1.0,
//            strokeWeight: 10,
//            map: map
//        });

        alert("Google Maps: "+google.maps.geometry.spherical.computeDistanceBetween (locationDestino, locationOrigem)+"Meters");
        //line.setMap(map);
        //alert("Haversine: "+ getDistance(locationDestino, locationOrigem));
    });
});
}

var rad = function(x) {
  return x * Math.PI / 180;
};

var getDistance = function(p1, p2) {
  var R = 6378137; // Earth’s mean radius in meter
  var dLat = rad(p2.lat() - p1.lat());
  var dLong = rad(p2.lng() - p1.lng());
  var a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
    Math.cos(rad(p1.lat())) * Math.cos(rad(p2.lat())) *
    Math.sin(dLong / 2) * Math.sin(dLong / 2);
  var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
  var d = R * c;
  return d; // returns the distance in meter
};

google.maps.event.addDomListener(window, 'load', initialize);
