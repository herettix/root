<?php
	include ('funkcije.php');  
	#include ('detalji.php'); 
	#error_reporting (E_ERROR);
	$xmlDoc = new DOMDocument();
	$xmlDoc->load('podaci.xml');
	#echo $xmlDoc->saveXML();
	$xmlDoc->saveXML();
	$xp = new DOMXPath($xmlDoc);
	$upit = generirajUpit();
	#$rezultat = $xp->query('mjesta');
	#echo "ovo je upit ".$upit;
	$rezultat = $xp->query($upit);


?>

	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<title>obrazac</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<link rel="stylesheet" type="text/css" href="dizajn.css">
		 <link rel="stylesheet" type="text/css" href="http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.css" />
<script type="text/javascript" src="http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.js">
</script>
<script type="text/javascript" src="detalji.js"></script>
<!--<-->
</head>

<body>
	

	
<div id="header">
	<h1 class="titleG">
	<a href="index.html">izlasci.sib.hr</a>
	</h1>
		<a href="index.html">
			<img src="images/b2.jpg" alt="banner">
		</a>
</div>	

<div id="navigation">
	<ul class="n">
		<li class="n"> <a href="index.html" class="n">Početna</a> </li>
		<li class="n"> <a href="obrazac.html" class="n">Pretraga</a> </li>
		<li class="n"> <a href="http://www.fer.hr/predmet/or" class="n">Otvoreno računarstvo</a> </li>
		<li class="n"> <a href="http://www.fer.unizg.hr" target="_new" class="n">FERweb početna</a> </li>	 
		<li class="n"> <a href="mailto:kresimir.ostovic@fer.hr" class="n">Kontakt</a> </li>
		<li class="n"> <a href="podaci.xml" class="n">Baza podataka</a> </li>		
	</ul>	
</div>


<div id="pretraga">	
			<h2>
				Rezultati Pretrage
			</h2>
<table class="x">
      <tr class="x">
		<th>Banner</th>
        <th>Naziv</th>
        <th>Adresa</th>
        <th>Radno vrijeme</th>
		<th>Kontakt</th>
		<th>Akcija</th>
      </tr>
<?php

	foreach ($rezultat as $mjesta)
	{ 	$grafstr='http://graph.facebook.com/'.$mjesta->getAttribute('id').'?fields=picture,location,website';
	
		$podatak = file_get_contents($grafstr);
		$polje=(json_decode($podatak, true));
		if(!isset($polje['picture']) or !isset($polje['location']) or !isset($polje['id']))
		{ $ulicaf='error'; $gradf=' error '; $countryf='error'; $strweb='error'; $lat=0; $lon=0;}
		else{
		
		$slikaf=$polje['picture']['data']['url']; 
		$ulicaf=$polje['location']['street']; 
		$gradf=$polje['location']['city']; 
		$countryf=$polje['location']['country'];


		if(isset($polje['website'])==true)
		$strweb=$polje['website']; 	
	    else $strweb='';
		
		$nomupit='http://nominatim.openstreetmap.org/search?q='.$ulicaf.', '.$gradf.'&format=xml';
		$nomupit = str_replace(" ", "+", $nomupit);
		$sxml = simplexml_load_file($nomupit);
		if ($sxml->place["lat"]!=null)
		{$lat=$sxml->place["lat"];  
		$lon=$sxml->place["lon"];  }
		else
		{$nomupit='http://nominatim.openstreetmap.org/search?q='.$gradf.', Osijek-Baranja&format=xml';
		$nomupit = str_replace(" ", "+", $nomupit);
		$sxml = simplexml_load_file($nomupit);
		if($sxml->place["lat"]!=null)
		{ $lat=$sxml->place["lat"]; 
		$lon=$sxml->place["lon"]; }
		else
		{$nomupit='http://nominatim.openstreetmap.org/search?q='.$countryf.'&format=xml';
		$nomupit = str_replace(" ", "+", $nomupit);
		$sxml = simplexml_load_file($nomupit);
		$lat=$sxml->place["lat"]; 
		$lon=$sxml->place["lon"]; }
		} }
		?>

		
		
      <tr id="xx" name="trxx" onmouseover="promijeniBoju1(this)" onmouseout="promijeniBoju2(this)" >
        <td> <img src="<?php echo $slikaf;?>" alt="profilna"> </td> 
		<td> <?php echo getFirstElementByTagName($mjesta, 'naziv')->nodeValue; ?> </td>
        <td> <?php  
		echo $ulicaf. ", ".$gradf.'<br>lat='.$lat.'<br> lon='.$lon;   ?>
		</td>
		<td><?php $i=0; foreach ($mjesta->getElementsByTagName('radvr') as $radvr)
		{ 
				if($mjesta->getAttribute('kategorija')=='nocniklub')
				{ if($i%2==0)
					{ echo $radvr->getAttribute('dan'); echo ': '. getFirstElementByTagName($radvr, 'radp')->nodeValue; }
				  if($i%2==1)
					{ echo ' - '. getFirstElementByTagName($radvr, 'radk')->nodeValue;  echo '<br>'; }
				 $i++;} 
		else { 
		echo $radvr->getAttribute('dan');
		echo ': '. getFirstElementByTagName($radvr, 'radp')->nodeValue;
		echo ' - '. getFirstElementByTagName($radvr, 'radk')->nodeValue; 
		echo '<br>';
		}
		} ?> </td>
        <td> <?php foreach ($mjesta->getElementsByTagName('telefon') as $telefon)
						{	echo $telefon->getAttribute('pozivni') . ' ';
							echo getFirstElementByTagName($telefon, 'broj')->nodeValue;
							echo '<br>';
						} 
						echo getFirstElementByTagName($mjesta, 'email')->nodeValue; ?> </td>

		<td id="akcija" ><p onclick="ispisidetalje(this,<?php echo $mjesta->getAttribute('id'); ?>,<?php echo $lat; ?>,<?php echo $lon; ?>,'<?php echo getFirstElementByTagName($mjesta, "naziv")->nodeValue; ?>','<?php echo $ulicaf; ?>','<?php echo $strweb; ?>')">Više o..</p></td>
      </tr>
	   
      <?php } ?>
    </table>			
					
		</div>

<div id="dodatno">	

</div>
<div id="dodatno2">	

</div>
		
<div id="footer">
	 2015 Krešimir Ostović - <a href="index.html">izlasci.sib.hr</a>
</div>	

	
		

	</body>
</html>					