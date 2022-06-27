# Plataforma-de-Eventos

## Microserviços utilizando Arquitetura Hexagonal, com mensagens síncronas utilizando FeignClient e assíncronas utilizando Apache Kafka.


#### _O Sistema ainda está em construção..._



### Resumo dos microserviços com suas responsabilidades :

- auth-service : Responsável por autenticar o usuário e gerar o token Jwt.
- user-service : Responsável por cadastrar usuários,realizar a chamada síncrona pra o microserviço de auth-service salvar os dados do usuário com sua role em sua base de dados para realizar o processo de autenticação e realiza a produção de mensagens em um tópico Kafka para abertura de uma carteira virtual para o usuário recém cadastrado.
- wallet-service : Responsável por escutar o topico do microserviço user-service e criar a carteira virtual do usuário recem cadastrado além de gerenciar o fluxo de renda do usuário.
- event-service : Responsável por criar eventos e inscrever usuários nesses eventos, além de produzir mensagens para um tópico Kafka com as informações de uma criação de um evento para que os ingressos sejam criados.
- factory-ticket-service : Responsável por escutar a mensagem criada do event-service e fabricar a quantidade de ingressos correspondentes para o evento criado no microserviço de event-service , além de realizar a chamada síncrona para o endpoint de persistência desses ingressos no microserviço ticket-service.
- ticket-service : Responsável por receber os tickets fabricados  pelo microserviço factory-ticket-service e salvá-los em sua base de dados, além de serém responsaveis por gerenciar os ingressos de um determinado evento, podendo assim saber dados como de quem comprou,para quem é o ingresso, valor entre outros..
