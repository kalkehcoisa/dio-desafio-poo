# README.md

````md
# Desafio: Aprendendo na Prática Programação Orientada a Objetos

Projeto desenvolvido em Java para praticar os quatro pilares da Programação Orientada a Objetos:

- Abstração
- Encapsulamento
- Herança
- Polimorfismo

O projeto simula uma plataforma de bootcamps onde desenvolvedores podem:

- se inscrever em bootcamps
- concluir cursos e mentorias
- acumular XP
- participar de múltiplos bootcamps

Além da estrutura original do desafio da DIO, o projeto foi expandido para permitir múltiplos cursos, mentorias, bootcamps e um fluxo configurável de ações por desenvolvedor.

## Estrutura do Projeto

```text
src/
└── br/
    └── com/
        └── dio/
            └── desafio/
                ├── Main.java
                └── dominio/
                    ├── Bootcamp.java
                    ├── Conteudo.java
                    ├── Curso.java
                    ├── Dev.java
                    └── Mentoria.java
````

## Tecnologias Utilizadas

* Java 11+
* IntelliJ IDEA
* Git

## Funcionalidades

### Conteúdos

O sistema possui dois tipos de conteúdo:

* `Curso`
* `Mentoria`

Ambos herdam da classe abstrata `Conteudo`.

### Bootcamps

Foram criados 3 bootcamps:

* Bootcamp Java Developer
* Bootcamp Data Developer
* Bootcamp JS Developer

Cada bootcamp possui:

* 1 curso
* 1 mentoria

### Desenvolvedores

Os desenvolvedores são executados a partir de um mapa de ações:

```java
Map<String, List<Object[]>> acoes
```

Cada entrada representa um desenvolvedor e a sequência de ações que ele executará.

Exemplo:

```java
acoes.put("Camila", new ArrayList<>(List.of(
    new Object[]{"inscrever", bootcamps.get("java")},
    new Object[]{"progredir", null},
    new Object[]{"progredir", null}
)));
```

## Fluxo Executado

O `Main.java` percorre todas as ações de cada desenvolvedor:

* `inscrever` → inscreve o dev em um bootcamp
* `progredir` → conclui o próximo conteúdo disponível

Ao final, o sistema exibe:

* conteúdos ainda inscritos
* conteúdos concluídos
* XP total

## Exemplo de Saída

```text
Ações de Camila:
    Inscreveu-se em: Bootcamp Java Developer
    Concluiu: Curso{titulo='curso java', descricao='descricao curso java', cargaHoraria=8}
    Concluiu: Mentoria{titulo='mentoria de Java', descricao='descricao mentoria Java', data=2026-04-18}
    Inscreveu-se em: Bootcamp Data Developer
    Concluiu: Curso{titulo='curso data', descricao='descricao curso data', cargaHoraria=16}
    Concluiu: Mentoria{titulo='mentoria de Data', descricao='descricao mentoria Java', data=2026-04-18}
    Tentou progredir, mas não tem mais conteúdos para estudar!

Conteúdos Concluídos:
    ...
XP:280.0
```

## Como Executar

1. Clone o repositório
2. Abra na IDE
3. Execute a classe `Main`

```bash
git clone <url-do-repositorio>
cd dio-desafio-poo
```

## .gitignore

Recomenda-se adicionar:

```text
*.class
target/
.idea/
*.iml
```

## Conceitos de POO Aplicados

* Abstração: `Conteudo` representa qualquer conteúdo do bootcamp.
* Encapsulamento: atributos privados e acesso por getters/setters.
* Herança: `Curso` e `Mentoria` herdam de `Conteudo`.
* Polimorfismo: cada tipo de conteúdo implementa `calcularXp()` de forma diferente.

```
```
