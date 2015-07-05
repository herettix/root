<?php
	include ('funkcije.php');  
	#include ('pretraga.php'); 
	#error_reporting (E_ERROR);
	$xmlDoc1 = new DOMDocument();
	$xmlDoc1->load('podaci.xml');
	//echo $xmlDoc->saveXML();
	$xmlDoc1->saveXML();
	$xp = new DOMXPath($xmlDoc1);
	$idt=$_REQUEST['id'];
	$upit = "/podaci/mjesta[@id=".$idt."]"; 
	$rezultat = $xp->query('mjesta');
	#echo "ovo je upit ".$upit;
	$rezultat = $xp->query($upit);
	#print_r($rezultat );


foreach ($rezultat as $mjesta)
	{
echo '<b>Dodatno o izabranom:</b><br>';
echo '<b>Parking</b> <br>';
echo $mjesta->getAttribute('parking'); 
echo '<br>';
echo '<b>Privatnost</b> <br>';
echo $mjesta->getAttribute('tipprivatsnoti'); 
echo '<br>';
	}
		sleep(2);
?>