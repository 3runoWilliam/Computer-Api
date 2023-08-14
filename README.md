# API de Venda de Computadores usando Spring Boot

Bem-vindo ao repositório da **API de Venda de Computadores**! Esta API foi desenvolvida usando o framework **Spring Boot** para facilitar a gestão de vendas, cadastros, atualizações e exclusões de informações relacionadas à venda de computadores. Com ela, você poderá criar um sistema eficiente e integrado para gerenciar seu negócio de venda de computadores.

## Funcionalidades Principais

A API de Venda de Computadores oferece as seguintes funcionalidades principais:

1. **Listar Computadores**: Recupere uma lista de todos os computadores disponíveis para venda.

2. **Detalhes de um Computador**: Obtenha informações detalhadas sobre um computador específico a partir do seu ID.

3. **Cadastrar Computador**: Adicione um novo computador ao catálogo de venda.

4. **Atualizar Computador**: Atualize as informações de um computador existente no catálogo.

5. **Deletar Computador**: Remova um computador do catálogo de venda.

## Uso

1. Inicie o servidor da API:

2. Acesse a API em `http://localhost:8080`.

3. Utilize as rotas disponíveis para realizar as operações necessárias, como:

- **GET /computadores**: Retorna a lista de computadores disponíveis.
- **GET /computadores/:id**: Retorna os detalhes de um computador específico.
- **POST /computadores**: Cadastra um novo computador.
- **PUT /computadores/:id**: Atualiza as informações de um computador.
- **DELETE /computadores/:id**: Deleta um computador do catálogo.

## Exemplos de Requisições

Aqui estão alguns exemplos de como realizar requisições para a API utilizando o cURL:

1. Listar Computadores:
curl http://localhost:8080/computadores

2. Detalhes de um Computador:
curl http://localhost:8080/computadores

3. Cadastrar Computador:
curl -X POST -H "Content-Type: application/json" -d '{"marca": "Dell", "modelo": "Inspiron 5000", "preco": 1200}' http://localhost:8080/computadores

4. Atualizar Computador:
curl -X PUT -H "Content-Type: application/json" -d '{"preco": 1300}' http://localhost:8080/computadores/{id}

5. Deletar Computador:
curl -X DELETE http://localhost:8080/computadores/{id}


Certifique-se de substituir os valores de exemplo pelos dados reais que você deseja utilizar.

## Contribuição

Contribuições são bem-vindas! Se você encontrar bugs, tiver sugestões ou quiser adicionar novas funcionalidades, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Licença

Este projeto está licenciado.

---

Esperamos que esta API seja útil para a gestão eficiente das vendas de computadores. Sinta-se à vontade para personalizar e adaptar de acordo com suas necessidades específicas. Se tiver alguma dúvida, consulte a documentação ou entre em contato com a equipe de desenvolvimento.


