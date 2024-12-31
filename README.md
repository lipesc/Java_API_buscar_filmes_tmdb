Estudos backend API usando Spring webflux, openapi, esse projeto é para consumir a API tmdb para procurar por filmes e listar o top 10 filmes do dia.

## Como Executar
criar uma conta e gerar uma key no tmdb\
criar um arquivo e inserir sua key:\
src\main\resources\application.properties - tmdb.api.token=sua_key
```

O Swagger (http://localhost:5000/webjars/swagger-ui/index.html)


- Procurar filmes 
```

exemplo da resposta do filme procurado
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

exemplo da resposta pagina 1 dos top filmes do dia
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
