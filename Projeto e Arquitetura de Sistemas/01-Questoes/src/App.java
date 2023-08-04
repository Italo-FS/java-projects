public class App {
    public static void main(String[] args) throws Exception {
		Prova prova = new Prova( new Questao[] {
			new Questao(
				"O que é encapsulamento em programação orientada a objetos?",
				"Um mecanismo que permite esconder os detalhes internos de uma classe.",
				"A habilidade de criar novas classes a partir de uma classe existente.",
				"A capacidade de estender uma classe para criar subclasses.",
				"Um recurso que permite que objetos sejam passados como parâmetros.",
				1
			),
			new Questao(
				"Qual é o conceito principal da herança em programação orientada a objetos?",
				"Polimorfismo.",
				"Abstração.",
				"Encapsulamento.",
				"Reutilização de código.",
				4
			),
			new Questao(
				"O que é polimorfismo em programação orientada a objetos?",
				"A capacidade de uma classe ser derivada por várias classes.",
				"A habilidade de esconder a implementação de uma classe.",
				"A capacidade de uma classe ser instanciada várias vezes.",
				"A capacidade de objetos de diferentes classes serem tratados como objetos de uma mesma classe genérica.",
				4
			),
			new Questao(
				"Qual é a finalidade do construtor em uma classe?",
				"Definir variáveis locais.",
				"Declarar métodos estáticos.",
				"Realizar tarefas de inicialização.",
				"Gerar exceções durante a execução.",
				3
			),
			new Questao(
				"O que é um método estático em programação orientada a objetos?",
				"Um método que só pode ser acessado por classes filhas.",
				"Um método que pode ser invocado sem a necessidade de uma instância da classe.",
				"Um método que só pode ser acessado dentro da mesma classe.",
				"Um método que é declarado com a palavra-chave 'static'.",
				2
			),
			new Questao(
				"Em programação orientada a objetos, o que é uma interface?",
				"Um arquivo que contém código executável.",
				"Um conjunto de métodos abstratos que uma classe deve implementar.",
				"Uma classe que não pode ser instanciada.",
				"Uma área da memória onde objetos são armazenados.",
				2
			),
			new Questao(
				"Qual é a diferença entre uma classe abstrata e uma interface?",
				"As interfaces podem conter implementações de métodos, enquanto as classes abstratas não.",
				"As classes abstratas podem ser instanciadas, enquanto as interfaces não podem.",
				"As interfaces podem ter atributos, enquanto as classes abstratas não.",
				"As classes abstratas podem implementar múltiplas interfaces, mas as interfaces não podem herdar de outras classes.",
				3
			),
			new Questao(
				"O que é sobrecarga de métodos em programação orientada a objetos?",
				"A capacidade de uma classe herdar de várias classes.",
				"A capacidade de um método ter múltiplas implementações com assinaturas diferentes.",
				"A capacidade de uma classe ser instanciada mais de uma vez.",
				"A capacidade de uma classe ser encapsulada por outras classes.",
				2
			),
			new Questao(
				"Em programação orientada a objetos, o que é o conceito de composição?",
				"A criação de múltiplos objetos a partir de uma classe.",
				"A habilidade de uma classe herdar de várias classes.",
				"A inclusão de objetos de outras classes como membros da classe atual.",
				"A capacidade de um método chamar outro método dentro da mesma classe.",
				3
			),
			new Questao(
				"O que é o polimorfismo de sobrecarga (ou sobrecarga de operadores)?",
				"A capacidade de uma classe herdar de várias classes.",
				"A capacidade de uma classe conter vários construtores.",
				"A capacidade de um operador ter diferentes significados dependendo dos tipos de operandos.",
				"A capacidade de um método ter múltiplas implementações com a mesma assinatura.",
				3
			),
		});

		prova.realizarProva();
		prova.corrigirProva();
		prova.apresentarResultado();
    }
}
