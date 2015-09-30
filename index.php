<?php 

session_start(); 
?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<title>Guest list exporter</title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<meta name="description" content="Facebook tool for exporting guest lists from events usimg facebook api and graph api">
	<META NAME="ROBOTS" CONTENT="INDEX, FOLLOW">
	<!-- -->
	<link rel="stylesheet" type="text/css" href="dizajn.css">
</head>

<body>
	
<div id="header">
	<h1 class="titleG">
	Facebook event exporter
	</h1>

</div>	

<div id="pretraga">	
	<form name="obrazacT" action="pretraga.php" method="get">
		<!--<h3>Event exporting tool</h3> -->
		<p> <b> Usage: </b> If event is public you can export your list without logging in into your Facebook account, 
		however if Facebook event is set to private and you can see the list (or your page on which you need to login with right link), 
		you will have to log on into your Facebook account. Otherwise if you can't see guest list even not from your 
		Facebook account, tool will return you empty data. </p> <p> To get the data you can paste whole address or just id of the 
		event in appropriate box. Exporting may take some time, up to half a minute if guest number is really high. XML data is best to open in Firefox</p>
		<table>  
		<tr> 
		  <td> Paste web address of event </td> 
		  <td> Paste event id </td> 
		 </tr> 
		 <tr>
		 <td> <input type="text" name="web_adresa"> </td>
		 <td> <input type="text" name="id_adresa"> </td>
		</tr> 
		<tr> <td colspan="2">
			<input type="radio" name="tipprivatsnoti" value="loginmoj"> Without facebook login
			<input type="radio" name="tipprivatsnoti" value="loginau"> With facebook login </td>
		</tr>
		<tr> <td colspan="2">
			<input type="radio" name="tippodataka" value="xmlp"> Xml database
			<input type="radio" name="tippodataka" value="excelp"> Excel database </td>
		</tr>

	
<?php 
//login part of the script 

require_once __DIR__ . '/facebook45sdk/src/Facebook/autoload.php';

$fb = new Facebook\Facebook([
  'app_id' => '1584509565102980',
  'app_secret' => '06d322970b288dbc8203562da7a4fc2d',
  'default_graph_version' => 'v2.4',
  ]);

$helper = $fb->getRedirectLoginHelper();
// http://fbevent-exporter.rhcloud.com/index.php
//callback functions to manage and get tokens https://localhost/fbevent/fb-callback.php
$permissions = ['user_events']; // optional
$loginUrl = $helper->getLoginUrl("http://fbevent-exporter.rhcloud.com/fb-callback.php",$permissions);//
$permissions2 = ['user_events','manage_pages']; // optional
$loginUrl2 = $helper->getLoginUrl("http://fbevent-exporter.rhcloud.com/fb-callbackP.php",$permissions2);//
?>
		<tr> <td colspan="2"> 
		<?php echo '<a href="' . $loginUrl . '">To use with Facebook user login!</a> '; 
		echo '<a href="' . $loginUrl2 . '">To use with Facebook page login!</a></tr>';  ?>
	    </td>
		</tr>  
		<tr>
			<td> <input type="submit" value="Submit">  </td>
			<td> <input type="reset" value="Reset"> </td>
		</tr> </table>  
	</form>
</div>
<div id="footer">

<a href="mailto:ostacro.jug2@hotmail.com" class="n">© 2015 K.O. - Facebook event exporter</a>
	
</div>	
</body>
</html>