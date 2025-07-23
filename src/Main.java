import java.time.LocalDate;

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

class Bootcamp{}

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
