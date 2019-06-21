# Como contribuir com o furb-basico

## Montando o ambiente				
descrever como configurar o ambiente de desenvolvimento do projeto. 

## Release				
A construção do produto furb-basico é realizada com MAVEN.

### Prerequisitos
Para a construção do produto furb-basico funcionar, devem ser respeitados os seguintes requisitos:
1. Maven instalado e configurado.
2. Docker instalado e configurado.
3. Servidores Configurados: Os servidores do [Artifactory](http://maven.senior.com.br:8081/artifactory) e [Hub Docker](http://hub.docker.com) devem estar configurados no MAVEN. Estas configurações são realizadas no arquivo settings.xml. No Linux, a sua localização é em ```~/.m2/setings.xml```. No windows a localização é  ```%HOME%\.m2\setings.xml```.A configuração deve ser realizada como o modelo seguinte substituindo-se as informações ```#marcadas#``` pelas dados correspondentes.
```
    ...
	<servers>
	    ...
	       <!-- DOCKER -->
	    <server>
			<id>docker-hub</id>
			<username>seniorsistemas</username>
			<password>s3n10rs1st3m4s</password>
			<configuration>
				<email>giscard.faria@senior.com.br</email>
			</configuration>
		</server>
		<!-- artifactory para publicação dos artefados da Senior -->
		<server>
			<id>senior-release</id>
			<username>#maven_user_name#</username>
			<password>#maven_password#</password>
		</server>
			<server>
			<id>senior-snapshot</id>
			<username>#maven_user_name#</username>
			<password>#maven_password#</password>
		</server>
		...
	</servers>
	...
```

### Integração com Artifactory
A integração com o [Artifactory interno da Senior](http://maven.senior.com.br:8081/artifactory) está configurada no pom.xml do projeto furb-basico-parent.
Ao executar o _goal_ __package__, são gerados dentro da pasta _target_ de cada módulo, além do jar executável, um jar com os fontes do produto.
Ao executar o _goal_ __deploy__, são publicados os arquivos jars executáveis e de fonte no [snapshot](http://maven.senior.com.br:8081/artifactory/webapp/#/artifacts/browse/tree/General/libs-snapshot-local/br/com/senior/furb-basico-impl) ou [release](http://maven.senior.com.br:8081/artifactory/webapp/#/artifacts/browse/tree/General/libs-release-local/br/com/senior/furb-basico-impl) no artifactory.

### Integração com Docker/DockerHub
A integração com o docker e com o [Hub Docker](http://hub.docker.com) está configurada no pom.xml do projeto furb-basico-impl. Ao executar o _goal_ __package__, são gerados, dentro da pasta _target/docker_ de módulo furb-basico-impl, os seguintes artefatos adicionais:
1. arquivo __furb-basico-#version#-assembled.jar__: gerado a partir do jar executável do produto(__furb-basico-impl-#version#.jar__) e de todas as suas dependências;
2. arquivo __waitrabbitmqagent.jar__: copiado da sua respectiva localização do [artifactory](http://maven.senior.com.br:8081/artifactory).
3. arquivo __dockerfile__: gerado a partir do arquivo modelo __dockerfile-pattern__ presente na pasta raiz do módulo furb-basico-impl.
4. arquivo __launch-appteste.sh__: gerado a partir do arquivo modelo __launch-pattern.sh__ presente na pasta raiz do módulo furb-basico-impl.
5. arquivo __supervisord.conf__ :gerado a partir do arquivo modelo __supervisord-pattern.conf__ presente na pasta raiz do módulo furb-basico-impl.

Ao executar o _goal_ __install__, é gerada localmente a imagem docker do furb-basico com o nome __seniorsistemas/furb-basico__ e com tag igual a __versão do produto__ obedecendo a configuração definida pelo arquivo __dockerfile__ e com o conteúdo da pasta _target/docker_ do módulo furb-basico-impl. Para visualizar a imagem gerada execute o comando abaixo.
```bash
$ docker images -a
```
Ao executar o _goal_ __deploy__, é publicada no [Hub Docker](http://hub.docker.com) a imagem docker do furb-basico. Para visualizar a imagem publicada, acesse a [imagem do furb-basico no Hub Docker](https://hub.docker.com/r/seniorsistemas/furb-basico/tags/).
