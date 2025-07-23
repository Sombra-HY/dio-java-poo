package domain;

import java.time.LocalDate;

class Mentoria extends Conteudo<Mentoria> {

    public LocalDate getDate() {
        return date;
    }


    public Mentoria setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    @Override
    public String toString() {
        return "domain.Mentoria{" +
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
