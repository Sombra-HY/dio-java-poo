package domain;

class Curso extends Conteudo<Curso> {

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
        return "domain.Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargahoraria=" + cargahoraria +
                '}';
    }


    public int getCargahoraria() {
        return cargahoraria;
    }
}
