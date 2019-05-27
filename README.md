# Payment API | WireApi

Esta API destina-se a suportar o fluxo de pagamento (cartão de crédito ou boleto) e receber informações de comprador, cliente e pagamento.
Desenvolvida em linguagem de programação Java implantando princípios REST, e MySQL como banco de dados.

•	Banco de dados: MySQL;
•	Conexão com MySQL: Hibernate;
•	Framework: Spring Boot
•	Ferramenta de testes: Postman

## Buyer / Comprador | Methods:
-	POST/buyers
-	GET/buyers
-	GET/buyers/id
-	PUT/buyers/id
-	DELETE/buyers/id

###  POST / BUYERS
Este método destina-se a inserir um novo comprador.

>URL: http://localhost:8080/buyers 

**Header:**  
"Content-Type": "application/json"

**Body:**
```
{
    "nameBuyer": "string", 
    "emailBuyer": "string",
    "cpfCnpjBuyer": "string"

}
```
Onde,
- nameBuyer: nome do comprador
- emailBuyer: e-mail do comprador
- cpfBuyer: CPF do comprador

**nameBuyer:** 
Preenchimento obrigatório;
Tamanho (mínimo = 3, máximo = 50)

**emailBuyer:**
Preenchimento opcional;
Tamanho (máximo = 50)

**cpfBuyer:**
Preenchimento obrigatório;
Tamanho (mínimo = 11, máximo = 11)

****
## Requisição POST enviada:

![Buyer_Post](https://user-images.githubusercontent.com/45856882/58394447-aa3a5c80-8019-11e9-8883-d8d3b92924ae.png)

## Retorno com sucesso | [Code Response 201 – Created]

![Buyer_Post201](https://user-images.githubusercontent.com/45856882/58394521-13ba6b00-801a-11e9-9b64-2d0b4a3eddf5.png)

## Retorno com erro | Tratamento de exceção [Code Response 400 – Bad Request]
Causa: enviado propriedade desconhecida “outro: “teste”

![Buyer_Post400_1](https://user-images.githubusercontent.com/45856882/58394598-73b11180-801a-11e9-9c0a-0dade2d7e105.png)

## Retorno com erro | Tratamento de exceção [Code Response 400 – Bad Request]
Causa: enviado como nulo os campos de preenchimento obrigatório nas propriedades **nameBuyer** e **cpfBuyer**.

![Buyer_Post400_2](https://user-images.githubusercontent.com/45856882/58394612-8a576880-801a-11e9-9d8c-f0f0c981602b.png)

## Retorno com erro | Tratamento de exceção [Code Response 400 – Bad Request]
Causa: quantidade de caracteres (02) abaixo do esperado (mín. 03, máx. 50) na propriedade **nameBuyer**.
![Buyer_Post400_3](https://user-images.githubusercontent.com/45856882/58394671-d3a7b800-801a-11e9-9117-fe924fab5f98.png)

## Retorno com erro | Tratamento de exceção [Code Response 400 – Bad Request]
Causa: quantidade de caracteres (59) acima do esperado (mín. 03, máx. 50) na propriedade **nameBuyer**.
![Buyer_Post400_4](https://user-images.githubusercontent.com/45856882/58394724-0e115500-801b-11e9-8601-1512fa56b652.png)

## Retorno com erro | Tratamento de exceção [Code Response 400 – Bad Request]
Causa: quantidade de caracteres (05) abaixo do esperado (mín. 11, máx. 11) na propriedade **cpfBuyer**.
![Buyer_Post400_6](https://user-images.githubusercontent.com/45856882/58394797-6ea09200-801b-11e9-8ba1-1da0efb7e625.png)

## Retorno com erro | Tratamento de exceção [Code Response 400 – Bad Request]
Causa: quantidade de caracteres (19) acima do esperado (mín. 11, máx. 11) na propriedade **cpfBuyer**.
![Buyer_Post400_5](https://user-images.githubusercontent.com/45856882/58394753-3c8f3000-801b-11e9-9a38-a00db741347f.png)

****

###  GET / BUYERS
Este método destina-se a consultar lista de compradores cadastrados.

>URL: http://localhost:8080/buyers 

## Retorno com sucesso | [Code Response 200 – OK]
![bget1](https://user-images.githubusercontent.com/45856882/58394980-59783300-801c-11e9-8e68-c295860c551f.png)

###  GET / BUYERS / ID
Este método destina-se a consultar um determinado comprador cadastrado passando seu número de id.

>URL: http://localhost:8080/buyers/id

## Retorno com sucesso | [Code Response 200 – OK]
![bget2](https://user-images.githubusercontent.com/45856882/58394981-59783300-801c-11e9-80f5-f3f72e8fd29b.png)

****

###  PUT/ BUYERS / ID
Este método destina-se a atualizar o registro de um determinado comprador passando seu número de id.

>URL: http://localhost:8080/buyers 

Consultando ID de número 2 antes requisitar a atualização:
![b_put1](https://user-images.githubusercontent.com/45856882/58395163-30a46d80-801d-11e9-98b1-7ef7fb736648.png)

## Retorno com sucesso | [Code Response 200 – OK]
ID de número 2 após requisitar a atualização na propriedade **emailBuyer**:
![b_put2](https://user-images.githubusercontent.com/45856882/58395164-313d0400-801d-11e9-87f6-08beec2bdb90.png)

****

###  DELETE/ BUYERS / ID
Este método destina-se a deletar o registro de determinado comprador passando seu id.

>URL: http://localhost:8080/buyers 

Consultando o ID número 12 antes requisitar sua exclusão:
![b_del1](https://user-images.githubusercontent.com/45856882/58395309-e1127180-801d-11e9-861a-3d9237522ecb.png)

## Retorno com sucesso | [Code Response 204 – NO CONTENT]
Após requisitar a exclusão do registro de ID número 12:
![b_del2](https://user-images.githubusercontent.com/45856882/58395310-e1127180-801d-11e9-9474-22a09794b59c.png)

## Retorno com erro | Tratamento de exceção [Code Response 404 – NOT FOUND]
Causa: Foi requisitado a exclusão de um registro inexistente ou já deletado anteriormente. Neste caso usei o id de número 12 para teste.
![b_del3](https://user-images.githubusercontent.com/45856882/58395311-e1127180-801d-11e9-969f-1c227809e0b6.png)

****

## Cards / Cartão | Methods:

-	POST/cards
-	GET/cards
-	GET/cards/id
-	PUT/cards/id
-	DELETE/cards/id

###  POST / CARDS
Este método destina-se a inserir um novo registro de cartão.

>URL: http://localhost:8080/cards

**Header:**  
"Content-Type": "application/json"

**Body:**
```
{
   "cardholdername": "string",
    "cardnumber": "string",
    "cardexpirationdate": "string",   
    "cardcvv": "string"
}
```
Onde,
- cardholdername: Nome do titular impresso no cartão. Ex.: "Judite Marques".
- cardnumber: Número impresso no cartão. Ex.: “5338045395041232”.
- cardexpirationdate:  Data de expiração do cartão. Ex.: "20190812".
- cardcvv: Numero do CVV (Codigo de verificação do cartão). Ex.: “283”.

**cardholdername:** 
Preenchimento obrigatório;
Tamanho (mínimo = 3, máximo = 50)

**cardnumber:**
Preenchimento obrigatório;
Tamanho (mínimo = 13, máximo = 16)

**cardexpirationdate:**
Preenchimento obrigatório;
Tamanho (mínimo = 8, máximo = 8)

**cardcvv:**
Preenchimento obrigatório;
Tamanho (mínimo = 3, máximo = 3)

****
## Requisição POST enviada:

![c_post1](https://user-images.githubusercontent.com/45856882/58395808-4ff0ca00-8020-11e9-9847-c9132ed8229f.png)

## Retorno com sucesso | [Code Response 201 – Created]
![c_post2](https://user-images.githubusercontent.com/45856882/58395704-ec669c80-801f-11e9-8c26-68ba99ba6d67.png)

## Retorno com erro | Tratamento de exceção [Code Response 400 – Bad Request]
Causa: enviado propriedade desconhecida “outro”: “teste1”.
![c_post3](https://user-images.githubusercontent.com/45856882/58395705-ec669c80-801f-11e9-8bf1-9a8bcfc4afd7.png)

## Retorno com erro | Tratamento de exceção [Code Response 400 – Bad Request]
Causa: enviado como nulo os campos de preenchimento obrigatório nas propriedades **cardholdername**, **cardnumber**, **cardexpirationdate** e **cardcvv**.
![c_post4](https://user-images.githubusercontent.com/45856882/58395706-ecff3300-801f-11e9-83fe-42732659f477.png)

## Retorno com erro | Tratamento de exceção [Code Response 400 – Bad Request]
Causa: quantidade de caracteres abaixo do esperado:
- cardholdername: mínimo = 3, enviado 2
- cardnumber: mínimo = 13, enviado 9
- cardexpirationdate: mínimo = 8, enviado 2
- cardcvv: mínimo = 3, enviado = 2
![c_post5](https://user-images.githubusercontent.com/45856882/58395707-ecff3300-801f-11e9-9889-30d0c4f798f9.png)

## Retorno com erro | Tratamento de exceção [Code Response 400 – Bad Request]
Causa: quantidade de caracteres acima do esperado:

- cardholdername: máximo = 50, enviado 59
- cardnumber: máximo = 16, enviado 18
- cardexpirationdate: máximo = 8, enviado 10
- cardcvv: máximo = 3, enviado = 4

![c_post6](https://user-images.githubusercontent.com/45856882/58395708-ecff3300-801f-11e9-91e3-b74480b4c1f4.png)

****

###  GET / CARDS
Este método destina-se a consultar lista de cartões cadastrados.

>URL: http://localhost:8080/cards

## Retorno com sucesso | [Code Response 200 – OK]
![c_get1](https://user-images.githubusercontent.com/45856882/58396081-80853380-8021-11e9-8687-e1883d548746.png)

###  GET / CARDS / ID
Este método destina-se a consultar um determinado cartão cadastrado passando seu número de id.

>URL: http://localhost:8080/cards/id

## Retorno com sucesso | [Code Response 200 – OK]
![c_get2](https://user-images.githubusercontent.com/45856882/58396083-80853380-8021-11e9-8826-1641f69a7d54.png)

****

###  PUT/ CARDS / ID
Este método destina-se a atualizar o registro de um determinado cartão passando seu número de id.

>URL: http://localhost:8080/cards/id

**Header:**  
"Content-Type": "application/json"

Consultando ID de número 1 antes requisitar a atualização:
![c_get2](https://user-images.githubusercontent.com/45856882/58396083-80853380-8021-11e9-8826-1641f69a7d54.png)

## Retorno com sucesso | [Code Response 200 – OK]
ID de número 1 após requisitar a atualização na propriedade **cardexpirationdate**:
![c_put2](https://user-images.githubusercontent.com/45856882/58396263-4c5e4280-8022-11e9-90c8-cc0e13a92d37.png)

****

###  DELETE/CARDS/ID
Este método destina-se a deletar um registro de determinado cartão passando seu id.

>URL: http://localhost:8080/cards/id 

Consultando o ID número 2 antes requisitar sua exclusão:
![del_1](https://user-images.githubusercontent.com/45856882/58396398-d1495c00-8022-11e9-8135-552ad43b123a.png)

## Retorno com sucesso | [Code Response 204 – NO CONTENT]
Após requisitar a exclusão do registro de ID número 2:
![del_2](https://user-images.githubusercontent.com/45856882/58396399-d1495c00-8022-11e9-82c1-7e268f8741f0.png)

## Retorno com erro | Tratamento de exceção [Code Response 404 – NOT FOUND]
Causa: Foi requisitado a exclusão de um registro inexistente ou já deletado anteriormente. Neste caso usei o id de número 2 para teste.
![del_3](https://user-images.githubusercontent.com/45856882/58396400-d1e1f280-8022-11e9-883c-937e93b1d8f1.png)

****
