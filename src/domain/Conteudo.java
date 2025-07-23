package domain;

abstract class Conteudo<T extends Conteudo<T>> {
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
        return (T) this;
    }
}
