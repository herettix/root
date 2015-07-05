<?php
	#error_reporting (E_ALL);
	$data='';
	mb_strtolower($data, "UTF-8");
	function ispisi($lista) { print_r($lista); }
	function getFirstElementByTagName($node, $elementName)
	{ return $node->getElementsByTagName($elementName)->item(0); }	

	function toLower($string)
	{ return	"translate(". $string. ", 'ABCČĆDĐEFGHIJKLMNOPQRSŠTUVWXYZŽ@/\.', 'abcčćdđefghijklmnopqrsštuvwxyzž@/\.')"; }
	
		function generirajUpit()	
	{
		$listaUpit = array();

		if (!empty($_REQUEST['oib']))
		{ $listaUpit[] = 'contains(oib, "' . $_REQUEST['oib'] . '")'; }
		if (!empty($_REQUEST['naziv']))
		{ $listaUpit[] = 'contains(' . toLower('naziv') . ', "' . mb_strtolower($_REQUEST['naziv']) . '")'; }
		if (!empty($_REQUEST['kategorija']))
		{ $kategorijaUpit = array();
			foreach ($_REQUEST['kategorija'] as $kategorija)
			{ $kategorijaUpit[] = '@kategorija="' . $kategorija . '"'; }
			if (!empty($kategorijaUpit))
			{ $listaUpit[] = '(' . implode(' or ', $kategorijaUpit) . ')'; } }
		
		$telefonUpit = array();
		if (!empty($_REQUEST['broj']))
		{ $telefonUpit[] = 'contains(broj, "' . $_REQUEST['broj'] . '")'; }
		if (!empty($_REQUEST['pozivni']))
		{ $telefonUpit[] = '@pozivni="' . $_REQUEST['pozivni'] . '"'; }
		if (!empty($telefonUpit))
		{ $listaUpit[] = 'telefon[' . implode(' and ', $telefonUpit) . ']'; }
		
		$adresaUpit = array();
		if (!empty($_REQUEST['ulica']))
		{ $adresaUpit[] = 'contains(' . toLower('ulica') . ', "' . mb_strtolower($_REQUEST['ulica']) . '")'; }
		if (!empty($_REQUEST['kucnibr']))
		{ $adresaUpit[] = 'contains(kucnibr, "' . $_REQUEST['kucnibr'] . '")'; }
		if (!empty($_REQUEST['mjesto']))
		{ $adresaUpit[] = 'contains(' . toLower('mjesto') . ', "' . mb_strtolower($_REQUEST['mjesto']) . '")'; }
		if (!empty($_REQUEST['postbr']))
		{ $adresaUpit[] = 'mjesto[contains(@postbr, "' . $_REQUEST['postbr'] . '")]'; }
		if (!empty($_REQUEST['drzava']))
		{ $adresaUpit[] = 'contains(' . toLower('drzava') . ', "' . mb_strtolower($_REQUEST['drzava']) . '")'; }
		if (!empty($adresaUpit))
		{ $listaUpit[] = 'adresa[' . implode(' and ', $adresaUpit) . ']'; }
	
		$otvorenoUpit1 = array();
		#$otvorenoUpit2 = array();
		#$pom = 24;
		
		if (!empty($_REQUEST['dan']) and !empty($_REQUEST['radvr'])) {
			
			$otvorenoUpit1[] = '@dan="' . $_REQUEST['dan'] . '" and ('. $_REQUEST['radvr'] . ' >= radp and ' .$_REQUEST['radvr'] . ' < radk)';
			if (!empty($otvorenoUpit1)) { $listaUpit[] = 'radvr[' . implode(' and ', $otvorenoUpit1) . ']'; }
#$otvorenoUpit1[] = '@dan="' . $_REQUEST['dan'] . '" and (('. $_REQUEST['radvr'] . ' >= radp and ' .$_REQUEST['radvr'] . ' < radk) and 
#(/podaci/mjesta[@kategorija="izletiste"] or /podaci/mjesta[@kategorija="kafic"] or /podaci/mjesta[@kategorija="restoran"]))'; 
#		if (!empty($otvorenoUpit1)) { $listaUpit[] = 'radvr[' . implode(' or ', $otvorenoUpit1) . ']'; }
#$otvorenoUpit2[] = '@dan="' . $_REQUEST['dan'] . '" and ((( '.$_REQUEST['radvr'] . ' >= radp and ' .$_REQUEST['radvr'] . ' < sum(radk;24))) 
#and (/podaci/mjesta[@kategorija="nocniklub"]))'; 
		#if (!empty($otvorenoUpit2)) { $listaUpit[] = 'radvr[' . implode(' or ', $otvorenoUpit2) . ']'; } 
		}
		
		if(!empty($_REQUEST['email']))
		{ $listaUpit[] = 'contains('. toLower('email') . ', "'. mb_strtolower($_REQUEST['email']). '")';	}
		if(!empty($_REQUEST['webstr']))
		{ $listaUpit[] = 'contains('. toLower('webstr') . ', "'. mb_strtolower($_REQUEST['webstr']). '")';	}
		if (!empty($_REQUEST['tipprivatsnoti']))
		{ $listaUpit[] = '@tipprivatsnoti="' . $_REQUEST['tipprivatsnoti'] . '"'; }
		if (!empty($_REQUEST['parking']))
		{ $listaUpit[] = '@parking="' . $_REQUEST['parking'] . '"'; }
	
		$strUpit = implode(' and ', $listaUpit);
		if (empty($strUpit))
		{ return '/podaci/mjesta'; }
		else
		{ return '/podaci/mjesta[' . $strUpit . ']'; }
	}
?>	