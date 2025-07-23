import java.time.LocalDate;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Curso cursojava = new Curso();
        System.out.println(cursojava);
        cursojava
                .setTitulo("Curso Java")
                .setCargahoraria(70)
                .setDescricao("Curso Java");
        System.out.println(cursojava);

        Curso cursojs = new Curso();
        cursojs
                .setTitulo("Curso Javascript")
                .setDescricao("curso js")
                .setCargahoraria(43);

        Mentoria mentoria = new Mentoria();
        mentoria
                .setTitulo("Mentoria Java")
                .setDescricao("mentoria java")
                .setDate(LocalDate.now());

        System.out.println(mentoria);

        Conteudo<Curso> curs = new Curso();
    }
}

class Bootcamp{
    private String nome;
    private String descricao;

    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dateFinal = dataInicial.plusDays(45);

    private Set<Dev> devsinscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) && Objects.equals(descricao, bootcamp.descricao) && Objects.equals(dataInicial, bootcamp.dataInicial) && Objects.equals(dateFinal, bootcamp.dateFinal) && Objects.equals(devsinscritos, bootcamp.devsinscritos) && Objects.equals(conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dateFinal, devsinscritos, conteudos);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDateFinal() {
        return dateFinal;
    }

    public Set<Dev> getDevsinscritos() {
        return devsinscritos;
    }

    public void setDevsinscritos(Set<Dev> devsinscritos) {
        this.devsinscritos = devsinscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }
}

class Dev{
    private String nome;
    private Set<Conteudo> conteudoInscrito = new LinkedHashSet<>();
    private Set<Conteudo> conteudoConcluido= new LinkedHashSet<>();

    public double calcularXP(){
        return this.conteudoConcluido.stream()
                .mapToDouble(Conteudo::calcularXP)
                .sum();
    }


    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudoInscrito.addAll(bootcamp.getConteudos());
        bootcamp.getDevsinscritos().add(this);
    }
    public void progredir(){
        Optional<Conteudo> conteudo =  this.conteudoConcluido.stream().findFirst();
        if(conteudo.isPresent()){
            this.conteudoConcluido.add(conteudo.get());
            this.conteudoConcluido.remove(conteudo.get());
        }else{
            System.out.println("nao esta matricualdo em nenhum conteudo!");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudoInscrito, dev.conteudoInscrito) && Objects.equals(conteudoConcluido, dev.conteudoConcluido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudoInscrito, conteudoConcluido);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudoInscrito() {
        return conteudoInscrito;
    }

    public void setConteudoInscrito(Set<Conteudo> conteudoInscrito) {
        this.conteudoInscrito = conteudoInscrito;
    }

    public Set<Conteudo> getConteudoConcluido() {
        return conteudoConcluido;
    }

    public void setConteudoConcluido(Set<Conteudo> conteudoConcluido) {
        this.conteudoConcluido = conteudoConcluido;
    }
}


abstract class Conteudo<T extends Conteudo<T>>{
    public static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;

    public abstract double calcularXP();

    public String getTitulo() {
        return titulo;
    }
    @SuppressWarnings("unchecked")
    public T setTitulo(String titulo) {
        this.titulo = titulo;
        return (T) this;
    }

    public String getDescricao() {
        return descricao;
    }
    @SuppressWarnings("unchecked")
    public T setDescricao(String descricao) {
        this.descricao = descricao;
        return (T)this;
    }
}

class Curso extends Conteudo<Curso>{

    private int cargahoraria;

    @Override
    public double calcularXP() {
        return cargahoraria * XP_PADRAO;
    }

    public Curso setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
        return this;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargahoraria=" + cargahoraria +
                '}';
    }


    public int getCargahoraria() {
        return cargahoraria;
    }
}

class Mentoria extends Conteudo<Mentoria>{

    public LocalDate getDate() {
        return date;
    }



    public Mentoria setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public double calcularXP() {
        return XP_PADRAO * 3;
    }

    private LocalDate date;
}
