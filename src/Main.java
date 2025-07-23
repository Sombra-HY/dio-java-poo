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
    }
}

class Bootcamp{}

class Curso{
    private String titulo;
    private String descricao;
    private int cargahoraria;

    public Curso setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Curso setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Curso setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
        return this;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", cargahoraria=" + cargahoraria +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCargahoraria() {
        return cargahoraria;
    }
}

class Mentoria{
    private String titulo;
    private String descricao;

    public LocalDate getDate() {
        return date;
    }

    public Mentoria setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Mentoria setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Mentoria setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", date=" + date +
                '}';
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    private LocalDate date;
}
