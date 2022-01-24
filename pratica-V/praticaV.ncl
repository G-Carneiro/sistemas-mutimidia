<ncl id="myNCLDocID" xmlns="http://www.ncl.org.br/NCL3.0/EDTVProfile">
	<head>
		<connectorBase id="connBaseId">
			<causalConnector id="onEndStart">
				<simpleCondition role="onEnd">
				</simpleCondition>
				<simpleAction max="unbounded" role="start">
				</simpleAction>
			</causalConnector>
		</connectorBase>
		<regionBase id="regionBase0">
			<region height="100.00%" id="rgTV" left="0.00%" top="0.00%" width="100.00%" zIndex="1">
				<region height="10.00%" id="regionL" left="0.00%" top="20.00%" width="100.00%" zIndex="1">
				</region>
				<region height="65.00%" id="regionR1" left="0.00%" top="35.00%" width="49.00%" zIndex="1">
				</region>
				<region height="65.00%" id="regionR2" left="51.00%" top="35.00%" width="49.00%" zIndex="1">
				</region>
			</region>
		</regionBase>
		<descriptorBase id="descriptorBase1">
			<descriptor explicitDur="5s" id="descriptorImagem2" region="regionR2">
			</descriptor>
			<descriptor explicitDur="5s" id="descriptorVideo2" region="regionR1">
			</descriptor>
			<descriptor explicitDur="5s" id="descriptorVideo1" region="regionR1">
			</descriptor>
			<descriptor explicitDur="5s" id="descriptorImagem1" region="regionR1">
			</descriptor>
			<descriptor explicitDur="12s" id="descriptorLegenda2" region="regionL">
				<descriptorParam name="fit" value="fill">
				</descriptorParam>
				<descriptorParam name="fontColor" value="white">
				</descriptorParam>
			</descriptor>
			<descriptor explicitDur="8s" id="descriptorLegenda1" region="regionL">
				<descriptorParam name="fit" value="fill">
				</descriptorParam>
				<descriptorParam name="fontColor" value="white">
				</descriptorParam>
			</descriptor>
			<descriptor explicitDur="10s" id="descriptorAudio2">
			</descriptor>
			<descriptor explicitDur="8s" id="descriptorAudio1">
			</descriptor>
		</descriptorBase>
	</head>
	<body id="myBodyID">
		<media descriptor="descriptorImagem1" id="imagem1" src="media/imagem1.jpg" type="image/jpeg">
		</media>
		<media descriptor="descriptorImagem2" id="imagem2" src="media/imagem2.gif" type="image/gif">
		</media>
		<media descriptor="descriptorVideo1" id="video1" src="media/video1.mpg" type="video/mpeg">
		</media>
		<media descriptor="descriptorVideo2" id="video2" src="media/video2.mpg" type="video/mpeg">
		</media>
		<media descriptor="descriptorAudio1" id="audio1" src="media/audio1.mpg" type="audio/mp3">
		</media>
		<media descriptor="descriptorAudio2" id="audio2" src="media/audio2.mpg" type="audio/mp3">
		</media>
		<media descriptor="descriptorLegenda1" id="legenda1" src="media/legenda1.txt" type="text/plain">
		</media>
		<media descriptor="descriptorLegenda2" id="legenda2" src="media/legenda2.txt" type="text/plain">
		</media>
		<port component="video1" id="port1">
		</port>
		<port component="audio1" id="port2">
		</port>
		<port component="legenda1" id="port3">
		</port>
		<link id="link1" xconnector="onEndStart">
			<bind component="video1" role="onEnd">
			</bind>
			<bind component="imagem1" role="start">
			</bind>
		</link>
		<link id="link2" xconnector="onEndStart">
			<bind component="imagem1" role="onEnd">
			</bind>
			<bind component="imagem2" role="start">
			</bind>
			<bind component="audio2" role="start">
			</bind>
		</link>
		<link id="link3" xconnector="onEndStart">
			<bind component="legenda1" role="onEnd">
			</bind>
			<bind component="legenda2" role="start">
			</bind>
		</link>
		<link id="link4" xconnector="onEndStart">
			<bind component="imagem2" role="onEnd">
			</bind>
			<bind component="video2" role="start">
			</bind>
		</link>
	</body>
</ncl>
