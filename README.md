# 🌿 BioSim-Java

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![VS Code](https://img.shields.io/badge/VS%20Code-007ACC?style=for-the-badge&logo=visual-studio-code&logoColor=white)

O **BioSim-Java** é um simulador de ecossistema interativo desenvolvido em Java. O projeto simula o comportamento, ciclo de vida e a interação de diferentes agentes (como predadores, presas e elementos ambientais) dentro de um ambiente dinâmico com recursos limitados.

Este projeto foi idealizado como um desafio prático focado na aplicação dos pilares da **Programação Orientada a Objetos (POO)**, padrões de projeto e escrita de código limpo (*Clean Code*).

**OBS:** A simulação roda inteiramente através do Terminal integrado do VS Code, onde você poderá acompanhar as atualizações do ecossistema a cada ciclo.

---

## 🎯 Objetivos do Projeto

- **Prática de POO:** Aplicar de forma real os conceitos de Herança, Polimorfismo, Abstração e Encapsulamento.
- **Domínio de Lógica:** Gerenciar regras como movimentação em matrizes/coordenadas e cadeias alimentares.
- **Boas Práticas:** Escrever códigos legíveis e fáceis de estender.

---

## 🧠 Conceitos de POO Aplicados

- **Abstração:** Criação de classes para representar agentes de um ecossistema (ex: `Herbivore` `Carnivore`), definindo métodos comuns como `move()`, `eat()` e `decayHunger()`.
- **Polimorfismo:** Permite que o laço principal de simulação interaja com qualquer agente de forma genérica, executando comportamentos específicos em tempo de execução de acordo com a espécie.
- **Herança:** Reutilização de atributos e métodos compartilhados por agentes da mesma categoria, reduzindo a duplicação de código.
- **Encapsulamento:** Proteção do estado interno dos agentes (como energia, posição), garantindo que modificações de status passem por validações lógicas e seguras.

---

## 🚀 Tecnologias e Ferramentas

- **Linguagem:** Java (OpenJDK)
- **IDE Recomendada:** Visual Studio Code (VS Code)
- **Extensões do VS Code Úteis:** *Extension Pack for Java* (Microsoft)

---

## 💻 Como Rodar o Projeto no VS Code

Siga os passos abaixo para clonar, abrir e executar o projeto em sua máquina local utilizando o VS Code.

### Pré-requisitos
Certifique-se de ter instalado em sua máquina:
1. [Git](https://git-scm.com/)
2. [Java JDK](https://www.oracle.com/java/technologies/downloads/) (Versão 11 ou superior recomendada)
3. [Visual Studio Code](https://code.visualstudio.com/) com o pacote de extensões para Java instalado.

### Passo a Passo

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/RobsonBSF/BioSim-Java.git](https://github.com/RobsonBSF/BioSim-Java.git)

2. **Abra o VS Code e carregue o projeto**

3. **Abra o arquivo e pressione F5.**