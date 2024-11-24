# Java - Busca Automática de CEP com Integração de Web Service e Parsing XML

Este projeto Java demonstra a implementação técnica de uma busca automática de endereço por CEP, consumindo um Web Service externo e realizando o parsing da resposta em formato XML.  Desenvolvido no Eclipse IDE, o projeto utiliza a biblioteca *dom4j* para manipulação eficiente de documentos XML, proporcionando uma solução robusta e programática para a obtenção de informações de endereço.

## Funcionalidades

* **Busca precisa de endereço:** Consulta um Web Service externo para recuperar informações de endereço com base no CEP fornecido.
* **Parsing XML com dom4j:**  Utiliza a biblioteca *dom4j* para analisar a resposta XML do Web Service e extrair os dados de endereço relevantes.
* **Interface gráfica com Swing:**  Oferece uma interface gráfica amigável, construída com Swing, para interação com o usuário.
* **Validação de entrada:**  Implementa validação de entrada para garantir que apenas CEPs válidos sejam processados.
* **Tratamento de erros:** Lida com situações de CEP não encontrado e outros erros potenciais durante a consulta ao Web Service.
* **Indicador de status:**  Fornece feedback visual ao usuário sobre o status da busca (sucesso ou falha).
* **Limpeza de campos:**  Permite limpar os campos de entrada para realizar novas buscas.
* **Informações sobre o projeto:**  Inclui uma janela "Sobre" com detalhes do projeto, autoria e links relevantes.

## Tecnologias Utilizadas

* **Java:** Linguagem de programação principal do projeto.
* **Swing:**  Framework Java para a criação da interface gráfica.
* **dom4j:** Biblioteca Java para parsing de documentos XML.
* **Atxy2k:** Biblioteca para restrição de input em campos de texto.
* **Web Service de CEP (Republica Virtual):** Serviço externo utilizado para consultar informações de endereço por CEP.  _(Recomenda-se a migração para o ViaCEP para maior confiabilidade)._
* **Eclipse IDE:** Ambiente de desenvolvimento integrado utilizado para o desenvolvimento do projeto.

## Como Executar

1. **Pré-requisitos:** Java Development Kit (JDK) instalado e configurado no Eclipse IDE.
2. **Bibliotecas:**  As bibliotecas `dom4j` e `Atxy2k` são necessárias.  Gerencie as dependências utilizando um sistema de build como o Maven, adicionando as dependências necessárias ao arquivo `pom.xml`. Os arquivos de imagem devem estar localizados na pasta `resources/img` dentro da estrutura do projeto no Eclipse.
3. **Compilação:**  Compile o projeto no Eclipse IDE (Project > Clean... > Build Project).
4. **Execução:** Execute o arquivo JAR gerado através do comando: `java -jar nome_do_seu_jar.jar`.

## Uso

1. **Insira o CEP:** Digite o CEP desejado no campo de texto designado.  Certifique-se de inserir apenas números, sem hífen ou outros caracteres.
   ![cep1](https://github.com/user-attachments/assets/e9882702-00bc-437a-822c-b68a4a7da44e)

2. **Pesquise o endereço:** Clique no botão "Pesquisar". O aplicativo consultará o Web Service e processará a resposta.  Caso ocorra algum erro durante a consulta (CEP inválido, serviço indisponível, etc.), uma mensagem de erro será exibida.
   ![ceperror](https://github.com/user-attachments/assets/d5c1ea8d-79a8-431b-a976-66277821e2bf)

3. **Visualize o endereço:** Se o CEP for encontrado, as informações de endereço (logradouro, bairro, cidade e UF) serão preenchidas automaticamente nos campos correspondentes.
   
   ![cepresul](https://github.com/user-attachments/assets/b8acad4a-0029-4bdc-b6d7-9b950ad9ce82)

4. **Verifique o status:** Um ícone de status ao lado do campo de CEP indicará o resultado da busca. Um ícone verde indica sucesso, enquanto a ausência de ícone ou um ícone diferente pode indicar um erro.

5. **Limpe os campos:** Para realizar uma nova busca, clique no botão "Limpar".  Todos os campos serão limpos, e o foco retornará ao campo de CEP.

6. **Sobre o projeto:** Para obter informações sobre o projeto, a versão, o autor e links para repositórios online (como GitHub e LinkedIn), clique no botão "Sobre".
 
   ![cepsobre](https://github.com/user-attachments/assets/fe09bf9c-f9c2-458f-926f-931905da313f)
## Limitações

* O Web Service da República Virtual pode apresentar instabilidade. Recomenda-se a migração para o ViaCEP.
* O layout da interface gráfica é absoluto, podendo apresentar problemas de adaptação em diferentes resoluções.


## Autor

Nicolas França Castro Rosa




