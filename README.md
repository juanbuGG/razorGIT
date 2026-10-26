# RAZORBS - Testes JUnit
Projeto Java 17 para abrir no NetBeans como **projeto Maven existente**. Reutiliza as classes do RAZORBS Refatorado e inclui quatro testes JUnit 5 independentes de banco de dados.

## Executar
No NetBeans: Arquivo > Abrir Projeto > selecione RAZORBS_Testes_JUnit; clique com o botão direito > Testar. Ou no terminal, dentro da pasta: `mvn test`.

O Maven precisa de acesso à internet na primeira execução para baixar o JUnit. O resultado esperado é **Tests run: 4, Failures: 0, Errors: 0**. Não foi possível executar JUnit neste ambiente sem a dependência instalada; execute no seu computador e capture o resultado.

## GitHub
Copie a pasta RAZORBS_Testes_JUnit para o repositório da etapa anterior, faça `git add .`, `git commit -m "Adiciona testes JUnit e plano de testes"`, `git push` e tire um print da página do repositório mostrando a pasta de testes. Inclua esse print na pasta `Evidencia_GitHub` e compacte novamente a entrega.
