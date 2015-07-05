function promijeniBoju1(obj) {
   obj.style.backgroundColor ="#336699";
   //Math.floor(Math.random()*16777215).toString(16);
}
function promijeniBoju2(obj) {
   obj.style.backgroundColor ="inherit";
}

var req; // deklarirana globalna varijabla
function loadXMLDoc(parametar) 	
{ if (window.XMLHttpRequest) { // FF, Safari, Opera, IE7+
req = new XMLHttpRequest(); // stvaranje novog objekta 
} else if (window.ActiveXObject) { // IE 6+
req = new ActiveXObject("Microsoft.XMLHTTP"); //ActiveX
} if (req) { // uspješno stvoren objekt
req.open("GET", parametar, true); // metoda, URL, asinkroni naèin
req.send(null); //slanje (null za GET, podaci za POST)
//document.getElementById('dodatno').innerHTML = "wait"; 
var img = document.createElement("img");
img.src = "images/spin.gif";

var src = document.getElementById('dodatno');
src.appendChild(img);
req.onreadystatechange = function()
			{
				
				 
				if (req.readyState == 4 && req.status == 200)
				{ document.getElementById('dodatno').innerHTML = req.responseText; }
				else
				{ document.getElementById('dodatno').innerHTML = "Error"; }
			};


} }
 var map = L.map('dodatno2'); 
function ispisidetalje(obj,idt,lat,lon,naziv,adresa,web) {
	if (map != undefined) { map.remove(); }  


	
	obj.style.backgroundColor="#ffffff";
loadXMLDoc("detalji.php?id=" + idt);


map = L.map('dodatno2').setView([lat, lon], 18);

L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

str = web;
L.marker([lat, lon]).addTo(map).bindPopup('<b>' + naziv + '</b><br>' + adresa + '<br>Sirina: ' + lat + '<br>Duzina: ' + lon + '<br>'+str.link(web)).openPopup();

	}
