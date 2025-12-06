Estudos backend API usando Spring webflux, swagger, esse projeto é para consumir a API tmdb para procurar por filmes e listar o top 10 filmes do dia.

deploy no gcp cloud Run:
https://javaapibuscarfilmestmdb-602934601850.us-central1.run.app


deploy heroku: *desativado devido ao preço
https://shielded-caverns-02756-2f19742a8e28.herokuapp.com/

## Como Executar
criar uma conta e gerar uma key no tmdb\
criar um arquivo e inserir sua key:\
src\main\resources\application.properties - tmdb.api.token=sua_key
```

O Swagger (http://localhost:5000/webjars/swagger-ui/index.html)


- Pesquisa de filmes pelos seus títulos originais, traduzidos e alternativos.

```

exemplo dos valores que vão retornar, é possivel retornar várias dezenas de valores diferentes
escolhi só esses por simplicidade

![image](https://github.com/user-attachments/assets/9a007e7f-ee6d-4d87-b334-852904c3f80f)

exemplo de pesquisa:
![image](https://github.com/user-attachments/assets/1bbcc28e-6ece-4440-844e-e9500268243b)

![image](https://github.com/user-attachments/assets/f113c475-a664-405d-bf90-8ace5c7f5c7c)

exemplo do frontend desenvolvido com puro html, css, javascript
![image](https://github.com/user-attachments/assets/5ffc7507-9cce-4c7d-9ec7-f58d75aa0663)

exemplo de busca

![image](https://github.com/user-attachments/assets/17a2554e-f012-4f11-8560-8f58fb99e1ac)

