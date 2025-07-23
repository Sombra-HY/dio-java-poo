package domain;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

class Dev {
    private String nome;
    private Set<Conteudo> conteudoInscrito = new LinkedHashSet<>();
    private Set<Conteudo> conteudoConcluido = new LinkedHashSet<>();

    public double calcularXP() {
        return this.conteudoConcluido.stream()
                .mapToDouble(Conteudo::calcularXP)
                .sum();
    }


    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudoInscrito.addAll(bootcamp.getConteudos());
        bootcamp.getDevsinscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudoConcluido.stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudoConcluido.add(conteudo.get());
            this.conteudoConcluido.remove(conteudo.get());
        } else {
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
