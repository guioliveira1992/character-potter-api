# character-potter-api

Esse projeto consiste em uma API Rest Java Spring Boot no qual permite criar, ler, consultar e excluir personagens do filme Harry Potter. Foi utilizado o banco de dados relacional em memória H2.

O projeto contém testes unitários utilizando o framework Junit, suas devidas implementações estão contidas no pacote de testes da aplicação (test/java/personspotterapi/personPotterApi)

O projeto contém a documentação do código-fonte (Javadoc), que está contida na pasta "character-potter-api/doc" do repositório.

No repositório do projeto contém o postman colection para que possa testar os recursos da API Rest. (character-potter-api/postman-collection)

Para que seja possível montar o ambiente de execução da aplicação com ambiente docker, execute os seguintes passos:

1- Baixe a imagem da aplicação <br/>
$ docker pull guilhermeoliveira1992/character-potter-api:latest

2 - Execute a aplicação <br/>
$ docker run -d -v /tmp:/tmp -p 3000:3000 guilhermeoliveira1992/character-potter-api:latest

Após executar/rodar a aplicaçao será possível acessar a documentação da API Rest através desse endpoint: http://localhost:3000/swagger-ui.html

A aplicação é executada na porta 3000
