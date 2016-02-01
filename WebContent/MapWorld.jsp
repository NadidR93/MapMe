<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MapMe!</title>
<style>
      html, body, #map-canvas {
        height: 100%;
        margin: 0px;
        padding: 0px
      }
      #panel {
        position: absolute;
        top: 5px;
        left: 50%;
        margin-left: -180px;
        z-index: 5;
        background-color: #fff;
        padding: 5px;
        border: 1px solid #999;
      }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?libraries=geometry&sensor=false&language=en"></script>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&v=3&libraries=geometry"></script>
    <script src="app.js"></script>
</head>
<body>
<f:view>
<div class="contentcontainer med left" style="float: right">
	  <h:form>
      Origin<br>
      <!--<h:inputText  value="#{mapMe.myLoc}"></h:inputText><br>
      <h:inputText  value="#{mapMe.other}"></h:inputText><br>-->
      <h:inputText  value="#{mapMe.latOrig}"></h:inputText>
  	  <br>
  	  <h:inputText  value="#{mapMe.lngOrig}"></h:inputText>
   	  <br><br>
   	  Destination<br>
   	  <h:inputText  value="#{mapMe.latDest}"></h:inputText>
   	  <br>
   	  <h:inputText  value="#{mapMe.lngDest}"></h:inputText>
   	  <br>

   	  <br>
   	  <h:outputText  value="#{mapMe.lngDest}"></h:outputText>
   	  <br>
   	  
      
      <h:commandButton action ="#{mapMe.incCountVal}" value="Add Location"></h:commandButton>
      <h:commandButton action ="#{mapMe.haversineCalc}" value="Get Distance"></h:commandButton>
      </h:form> 					

      <h3><h:outputText value="Haversine distance is #{mapMe.distance}" /></h3> 
    </div>
    <div id="map-canvas"></div>
</f:view>
	
</body>
</html>