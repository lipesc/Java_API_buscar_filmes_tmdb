Estudos backend API, esse projeto é para consumir a API tmdb

## Tecnologias usadas
 
[Spring webflux]\
[Spring openapi]\


## Práticas adotadas

- API REST
- WebClient
- Injeção de Dependências
- Geração automática do Swagger com a OpenAPI

## Como Executar
criar uma conta e gerar uma key no tmdb\
inserir criar um arquivo e inserir sua key:\
src\main\resources\application.properties  tmdb.api.token=sua_key\
```
A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger.html)

## API Endpoints

Para testas os endpoints [httpie]:

- Procurar filmes 
```
 http GET :8080/movies/search/digiteOfilmeAqui
exemplo da resposta pagina 1 do filme procurado
```
{
  "page": 0,
  "total_pages": 0,
  "total_results": 0,
  "results": [
    {
      "title": "string",
      "original_title": "string",
      "overview": "string",
      "release_date": "string",
      "vote_average": 0
    }
  ]
}
```
```

- Listar Top filmes
```
 http GET :8080/movies/top/1

exemplo da resposta pagina 1 dos filmes mais votados no momento atual
```
{
  "page": 0,
  "total_pages": 0,
  "total_results": 0,
  "results": [
    {
      "title": "string",
      "original_title": "string",
      "overview": "string",
      "release_date": "string",
      "vote_average": 0
    }
  ]
}
```
```
