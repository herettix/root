<?php 

session_start(); 
require_once __DIR__ . '/facebook45sdk/src/Facebook/autoload.php';
$_SESSION['page_name1']=$_REQUEST['page_name'];
$fb = new Facebook\Facebook([
  'app_id' => '758698427589222',
  'app_secret' => '74266e4d2130000f63f57b6a391c376a',
  'default_graph_version' => 'v2.4',
  ]);

$helper = $fb->getRedirectLoginHelper();

try {
  $accessToken = $helper->getAccessToken();
} catch(Facebook\Exceptions\FacebookResponseException $e) {
  // When Graph returns an error
  echo 'Graph returned an error: ' . $e->getMessage();
  exit;
} catch(Facebook\Exceptions\FacebookSDKException $e) {
  // When validation fails or other local issues
  echo 'Facebook SDK returned an error: ' . $e->getMessage();
  exit;
}

if (! isset($accessToken)) {
  if ($helper->getError()) {
    header('HTTP/1.0 401 Unauthorized');
    echo "Error: " . $helper->getError() . "\n";
    echo "Error Code: " . $helper->getErrorCode() . "\n";
    echo "Error Reason: " . $helper->getErrorReason() . "\n";
    echo "Error Description: " . $helper->getErrorDescription() . "\n";
  } else {
    header('HTTP/1.0 400 Bad Request');
    echo 'Bad request';
  }
  exit;
}

// Logged in
//echo '<h3>Access Token</h3>';
//var_dump($accessToken->getValue());


// The OAuth 2.0 client handler helps us manage access tokens
$oAuth2Client = $fb->getOAuth2Client();

// Get the access token metadata from /debug_token
$tokenMetadata = $oAuth2Client->debugToken($accessToken);
//echo '<h3>Metadata</h3>';
//var_dump($tokenMetadata);

// Validation (these will throw FacebookSDKException's when they fail)
$tokenMetadata->validateAppId('758698427589222');
// If you know the user ID this access token belongs to, you can validate it here
//$tokenMetadata->validateUserId('123');
$tokenMetadata->validateExpiration();

if (! $accessToken->isLongLived()) {
  // Exchanges a short-lived access token for a long-lived one
  try {
    $accessToken = $oAuth2Client->getLongLivedAccessToken($accessToken);
  } catch (Facebook\Exceptions\FacebookSDKException $e) {
    echo "<p>Error getting long-lived access token: " . $helper->getMessage() . "</p>\n\n";
    exit;
  }

  echo '<h3>Long-lived</h3>';
  var_dump($accessToken->getValue());
}

$_SESSION['fb_access_token_person'] = (string) $accessToken;
 $grafstr='https://graph.facebook.com/v2.4/me/accounts?access_token='.$_SESSION['fb_access_token'];
 $podatak = file_get_contents($grafstr);
 $polje=(json_decode($podatak, true));
  foreach($polje['data'] as $i => $row) 
 { /*if (!empty($_SESSION['page_name1']))
	 { if($_SESSION['page_name1']==$row['name']) $_SESSION['fb_access_token']=$row['access_token']; }
   else */
	   $_SESSION['fb_access_token']=$row['access_token'];
 }	 
// User is logged in with a long-lived access token.
// You can redirect them to a members-only page.  http://localhost/fbevent/index.php
header('Location: http://fbevent–exporter.rhcloud.com/index.php')//
?>