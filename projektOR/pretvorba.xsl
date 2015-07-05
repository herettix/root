<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output method="xml" indent="yes"
				doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
				doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" />

<xsl:template match="/">
  <html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  
  	<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
   <link rel="stylesheet" href="dizajn.css" type="text/css" />  
  </head>
  <body>
  <div id="header">
	<h1 class="titleG">
	<a href="index.html">izlasci.sib.hr</a>
	</h1>
		<a href="index.html">
			<img src="images/b2.jpg" alt="banner"/>
		</a>
</div>	

<div id="navigation">
	<ul class="n">
		<li class="n"> <a href="index.html" class="n">Pocetna</a> </li>
		<li class="n"> <a href="obrazac.html" class="n">Pretraga</a> </li>
		<li class="n"> <a href="http://www.fer.hr/predmet/or" class="n">Otvoreno racunarstvo</a> </li>
		<li class="n"> <a href="http://www.fer.unizg.hr" target="_new" class="n">FERweb pocetna</a> </li>	 
		<li class="n"> <a href="mailto:kresimir.ostovic@fer.hr" class="n">Kontakt</a> </li>
		<li class="n"> <a href="podaci.xml" class="n">Baza podataka</a> </li>		
	</ul>	
</div>
<div id="pretraga">
    <h3>Popis svih mjesta u bazi</h3>
    <table class="x">
      <tr class="x">
        <th>Naziv</th>
        <th>Adresa</th>
        <th>Radno vrijeme</th>
		<th>Kontakt</th>
		<th>WEB stranica</th>
		<th>Parking</th>
		<th>Privatnost</th>
      </tr>
      <xsl:for-each select="podaci/mjesta">
      <tr class="xx">
        <td><xsl:value-of select="naziv" /> <br/>
		<a target="_new"><xsl:attribute name="href">http://www.facebook.com/<xsl:value-of select="@id" />
			</xsl:attribute>www.facebook.com/<xsl:value-of select="@id" /></a>
		</td>
        <td><xsl:value-of select="adresa/ulica" /> 
			<xsl:value-of select="adresa/kucnibr" />, <xsl:value-of select="adresa/mjesto"/></td>
		<td><xsl:for-each select="radvr">
			<xsl:value-of select="@dan" />: <xsl:value-of select="radp"/>-<xsl:value-of select="radk"/>
			<br/> </xsl:for-each>	</td>
        <td> <xsl:value-of select="email" /> 
			<br/> <xsl:value-of select="telefon/@pozivni"/> <xsl:value-of select="telefon/broj"/> </td>
		<td><xsl:choose> 
		<xsl:when test="webstr=''">NEMA </xsl:when>
		<xsl:otherwise>
		<a target="new"><xsl:attribute name="href"><xsl:value-of select="webstr" />
			</xsl:attribute><xsl:value-of select="webstr" /></a>
		</xsl:otherwise></xsl:choose>	
			</td>
		<td><xsl:value-of select="@parking" /></td>
		<xsl:choose>
			<xsl:when test="@tipprivatsnoti='DA'"><td class="xxx">
				<xsl:value-of select="@tipprivatsnoti" /></td></xsl:when>
			<xsl:otherwise><td>
				<xsl:value-of select="@tipprivatsnoti" /></td></xsl:otherwise>
		</xsl:choose>
      </tr>
      </xsl:for-each>
    </table>
</div>	
<div id="footer">
	 2015 Kresimir Ostovic - <a href="index.html">izlasci.sib.hr</a>
</div>		
</body>
</html>
</xsl:template>
</xsl:stylesheet>