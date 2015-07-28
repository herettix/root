<?php 
	session_start();
	error_reporting (E_ALL);
	require_once __DIR__ . '/facebook45sdk/src/Facebook/autoload.php';
	$data='';
	$id_address='';

//funkcija za ispisivanje(xml) : trazi podatke od grafa, sprema u polje i zapisuje osobe, takodjer trazi dali postoji dalje i onda ulazi u rekurziju
	function ispisixml($strpredikat,$id_address,$access,$domtree,$predikat,$grafstr=null)
{ 
 if (is_null($grafstr)){ 
	$grafstr='https://graph.facebook.com/v2.4/'.$id_address.'/'.$strpredikat.'?limit=4000&access_token='.$access; echo $grafstr; }
 $podatak = file_get_contents($grafstr);
 $polje=(json_decode($podatak, true));
 $osoba = $domtree->createElement("osoba");
 $osoba = $predikat->appendChild($osoba);
 foreach($polje['data'] as $i => $row)
 {  $osoba->appendChild($domtree->createElement('ime',$row['name']));
    $osoba->appendChild($domtree->createElement('id',$row['id'])); }
 if(isset($polje['paging']['next'])==true)   
 {	$grafstr=$polje['paging']['next'];
	ispisixml($strpredikat,$id_address,$access,$domtree,$predikat,$grafstr); }
}

//funkcija za ispisivanje(excel) : trazi podatke od grafa, sprema u polje i zapisuje osobe, takodjer trazi dali postoji dalje i onda ulazi u rekurziju
	function ispisiexcel($strpredikat,$id_address,$access,$objPHPExcel,$grafstr=null)
{ 
 if (is_null($grafstr)){ 
	$grafstr='https://graph.facebook.com/v2.4/'.$id_address.'/'.$strpredikat.'?limit=4000&access_token='.$access;  }
 $podatak = file_get_contents($grafstr);
 $polje=(json_decode($podatak, true));
 $j=0; $k=2;
 foreach($polje['data'] as $i => $row) //$cell = $column_value.$row_number;
 {  $ids=$row['id']." ";
	$objPHPExcel->getActiveSheet()->setCellValueByColumnAndRow($j,$k, $row['name']);
    $objPHPExcel->getActiveSheet()->setCellValueByColumnAndRow($j+1,$k, $ids); 
	$k++; }
 if(isset($polje['paging']['next'])==true)   
 {	$grafstr=$polje['paging']['next'];
	ispisiexcel($strpredikat,$id_address,$access,$objPHPExcel,$grafstr); }
}

	
//provjerava formu	
if (!empty($_REQUEST['web_adresa']) and !empty($_REQUEST['tipprivatsnoti']) and !empty($_REQUEST['tippodataka'])) 
	{ $pos = mb_strpos($_REQUEST['web_adresa'], '/events/')+8; $id_addresst=substr($_REQUEST['web_adresa'], $pos); 
		$temp=strlen($id_addresst)-1;  $id_address=substr($id_addresst,0,$temp);
		if($_REQUEST['tipprivatsnoti']=='loginmoj') {$access="758698427589222|74266e4d2130000f63f57b6a391c376a"; }
		else if($_REQUEST['tipprivatsnoti']=='loginau'){ if (!empty($_SESSION['fb_access_token'])) {  $access=$_SESSION['fb_access_token']; }
		else { $message = "You said to get data with fb login but you didnt logged on";
		echo "<script type='text/javascript'>alert('$message');</script>"; } }		}
if (!empty($_REQUEST['id_adresa']) and !empty($_REQUEST['tipprivatsnoti']) and !empty($_REQUEST['tippodataka'])) 
		{ $id_address=$_REQUEST['id_adresa']; 
		if($_REQUEST['tipprivatsnoti']=='loginmoj') {$access="758698427589222|74266e4d2130000f63f57b6a391c376a"; }
		else if($_REQUEST['tipprivatsnoti']=='loginau') { if (!empty($_SESSION['fb_access_token'])) {  $access=$_SESSION['fb_access_token']; }  
		else { $message = "You said to get data with fb login but you didnt logged on";
		echo "<script type='text/javascript'>alert('$message');</script>"; } }       }
//provjerava koji način podataka želimo 		
if($_REQUEST['tippodataka']=='xmlp')
{ $xmlexe=0; }
if($_REQUEST['tippodataka']=='excelp')
{ $xmlexe=1; }

//xml dio		
if($xmlexe==0)
{
	//pravi dom dokument i root element
	$domtree = new DOMDocument('1.0', 'UTF-8');
	$xmlRoot = $domtree->createElement("event$id_address");
	$xmlRoot = $domtree->appendChild($xmlRoot);		
	//trazi podatke za svaki moguci i ispisuje ih pomocu funkcije u xml
		$strpredikat="attending";
			$predikat = $domtree->createElement($strpredikat);
			$predikat = $xmlRoot->appendChild($predikat);
			ispisixml($strpredikat,$id_address,$access,$domtree,$predikat);
		$strpredikat="maybe";
			$predikat = $domtree->createElement($strpredikat);
			$predikat = $xmlRoot->appendChild($predikat);
			ispisixml($strpredikat,$id_address,$access,$domtree,$predikat);
		$strpredikat="declined";
			$predikat = $domtree->createElement($strpredikat);
			$predikat = $xmlRoot->appendChild($predikat);		
			ispisixml($strpredikat,$id_address,$access,$domtree,$predikat);
		$strpredikat="noreply";
			$predikat = $domtree->createElement($strpredikat);
			$predikat = $xmlRoot->appendChild($predikat);		
			ispisixml($strpredikat,$id_address,$access,$domtree,$predikat);
		
	//echo $domtree->saveXML();
	$domtree->save('xmlfile.xml');
	$filename="xmlfile.xml";
		header("Content-disposition: attachment;filename=$filename");
		readfile($filename); 
}

//xls dio
if($xmlexe==1)
{
	require_once 'PHPExcel.php';
	require_once 'PHPExcel/IOFactory.php';
	// Create new PHPExcel object
	$objPHPExcel = new PHPExcel();
	//create sheets and main tabs 
	$objPHPExcel->setActiveSheetIndex(0);
		$objPHPExcel->getActiveSheet()->setTitle('Attending');
		$objPHPExcel->getActiveSheet()->setCellValue('A1', 'Name');
		$objPHPExcel->getActiveSheet()->setCellValue('B1', 'Id');
		$objPHPExcel->getActiveSheet()->getStyle('A1:B1')->getFont()->setBold(true);
		$strpredikat="attending";
		ispisiexcel($strpredikat,$id_address,$access,$objPHPExcel);
	$objPHPExcel->createSheet();
		$objPHPExcel->setActiveSheetIndex(1);
		$objPHPExcel->getActiveSheet()->setTitle('Maybe');
		$objPHPExcel->getActiveSheet()->setCellValue('A1', 'Name');
		$objPHPExcel->getActiveSheet()->setCellValue('B1', 'Id');
		$objPHPExcel->getActiveSheet()->getStyle('A1:B1')->getFont()->setBold(true);
		$strpredikat="maybe";
		ispisiexcel($strpredikat,$id_address,$access,$objPHPExcel);
	$objPHPExcel->createSheet();
		$objPHPExcel->setActiveSheetIndex(2);
		$objPHPExcel->getActiveSheet()->setTitle('Declined');
		$objPHPExcel->getActiveSheet()->setCellValue('A1', 'Name');
		$objPHPExcel->getActiveSheet()->setCellValue('B1', 'Id');
		$objPHPExcel->getActiveSheet()->getStyle('A1:B1')->getFont()->setBold(true);
		$strpredikat="declined";
		ispisiexcel($strpredikat,$id_address,$access,$objPHPExcel);
	$objPHPExcel->createSheet();
		$objPHPExcel->setActiveSheetIndex(3);
		$objPHPExcel->getActiveSheet()->setTitle('No reply');
		$objPHPExcel->getActiveSheet()->setCellValue('A1', 'Name');
		$objPHPExcel->getActiveSheet()->setCellValue('B1', 'Id');
		$objPHPExcel->getActiveSheet()->getStyle('A1:B1')->getFont()->setBold(true);
		$strpredikat="noreply"; //
		ispisiexcel($strpredikat,$id_address,$access,$objPHPExcel);        

// send file
	header('Content-Type: application/vnd.ms-excel');
	header('Content-Disposition: attachment;filename="xlsfile.xls"');
	header('Cache-Control: max-age=0');
	$objWriter = PHPExcel_IOFactory::createWriter($objPHPExcel, 'Excel5');
	$objWriter->save('php://output');
}
	
?>