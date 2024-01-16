// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun exibeInformacoesFormacao(formacao: Formacao) {
    println("Formação ${formacao.nome} - ${formacao.nivel}")
    println("Conteúdos:")
    for (conteudo in formacao.conteudos) {
        println(conteudo.nome)
    }
    
    println("Alunos matriculados:")
    for (inscrito in formacao.inscritos) {
        println(inscrito.nome)
    }
    
    println("")
}

fun main() {
    val usuario1 = Usuario("Maria")
    val usuario2 = Usuario("João")
    val usuario3 = Usuario("Fulano")
    val usuario4 = Usuario("Ciclano")
    
    val kotlin = ConteudoEducacional("Kotlin")
    val java = ConteudoEducacional("Java")
    val poo = ConteudoEducacional("Programação Orientada a Objetos")
    val logicaProgramacao = ConteudoEducacional("Lógica de programação")
    
    
    // Formação java
    val listConteudoJava = mutableListOf<ConteudoEducacional>()
    listConteudoJava.add(poo)
    listConteudoJava.add(java)
    val formacaoJava = Formacao("Programação em Java", listConteudoJava, Nivel.INTERMEDIARIO)
    formacaoJava.matricular(usuario1)
    formacaoJava.matricular(usuario2)    
    
    // Formação kotlin
    val listConteudoKotlin = mutableListOf<ConteudoEducacional>()
    listConteudoKotlin.add(logicaProgramacao)
    listConteudoKotlin.add(kotlin)
    val formacaoKotlin = Formacao("Programação em Kotlin", listConteudoKotlin, Nivel.BASICO)
    formacaoKotlin.matricular(usuario3)
    formacaoKotlin.matricular(usuario4)
    
    
    // Exibindo informações das formações
    exibeInformacoesFormacao(formacaoJava)
    exibeInformacoesFormacao(formacaoKotlin)
    
}
