// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

// Enum para nivel de dificuldade
enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO } 

// Classe Matricula
data class Matricula(val usuario: Usuario, val formacao: Formacao)

// Classe Usuario
data class Usuario(
    val nomeCompleto: String, 
    val idade: Int, 
    val sexo: String
) 

// Classe ConteudoEducacional
data class ConteudoEducacional(val nome: String, val descricao: String, val duracao: Int = 60) 

// Classe formacao
data class Formacao(
    val nome: String, 
    val nivel: Nivel, 
    var conteudos: MutableList<ConteudoEducacional> = mutableListOf()
) {
    
    fun adicionarConteudoEducacional(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }
}

// Classe GestorDeUsuarios
class GestorDeUsuarios {
    val usuarios = mutableListOf<Usuario>()
    val formacoes = mutableListOf<Formacao>()
    val matriculas = mutableListOf<Matricula>()

    fun adicionarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
    }

    fun adicionarFormacao(formacao: Formacao) {
        formacoes.add(formacao)
    }

    fun matricularUsuario(usuario: Usuario, formacao: Formacao) {
        val matricula = Matricula(usuario, formacao)
        matriculas.add(matricula)
    }

    fun imprimirUsuarios() {
        usuarios.forEach { println(it) }
    }

    fun imprimirFormacoes() {
        formacoes.forEach { println(it) }
    }

    fun imprimirMatriculas() {
        matriculas.forEach { println(it) }
    }
}
fun main() {
    val gestor = GestorDeUsuarios()

    // Adicionar usuarios
    gestor.adicionarUsuario(Usuario("João Silva", 25, "Masculino"))
    gestor.adicionarUsuario(Usuario("Maria Oliveira", 30, "Feminino"))
    
     // Adicionar cursos
    val cursoKotlin = Formacao("Kotlin", Nivel.BASICO)
    cursoKotlin.adicionarConteudoEducacional(ConteudoEducacional("Introdução ao Kotlin", "Aprenda os conceitos básicos do Kotlin"))
    cursoKotlin.adicionarConteudoEducacional(ConteudoEducacional("Desenvolvimento de Aplicativos", "Aprenda a desenvolver aplicativos com Kotlin"))
    gestor.adicionarFormacao(cursoKotlin)

    val cursoJava = Formacao("Java", Nivel.INTERMEDIARIO)
    cursoJava.adicionarConteudoEducacional(ConteudoEducacional("Introdução ao Java", "Aprenda os conceitos básicos do Java"))
    cursoJava.adicionarConteudoEducacional(ConteudoEducacional("Desenvolvimento de Aplicativos", "Aprenda a desenvolver aplicativos com Java"))
    gestor.adicionarFormacao(cursoJava)

    // Matricular usuarios
    gestor.matricularUsuario(Usuario("João Silva", 25, "Masculino"), cursoKotlin)
    gestor.matricularUsuario(Usuario("Maria Oliveira", 30, "Feminino"), cursoJava)

    // Imprimir usuarios, formcaoes e matriculas
    println("Usuarios:")
    gestor.imprimirUsuarios()

    println("\nFormacoes:")
    gestor.imprimirFormacoes()

    println("\nMatriculas:")
    gestor.imprimirMatriculas()
    
    
    
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

}