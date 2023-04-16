package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    private Set<Certificado> certificados = new LinkedHashSet<>();
    private Set<Bootcamp> bootcamps = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
        this.bootcamps.add(bootcamp);
    }

    public Certificado gerarCertificado(Bootcamp bootcamp) {

        Certificado certificado = new Certificado();
        
        if (conteudosConcluidos.containsAll(bootcamp.getConteudos())) {
            certificado.setDev(this.nome);
            certificado.setTitulo(bootcamp.getNome());
            certificado.setCargaHoraria(bootcamp.calcularCargaHoraria());
            this.certificados.add(certificado);

            System.out.println("CERTIFICADO BOOTCAMP FRENTE:\n__________________________________________\n----------------CERTIFICADO---------------\nCertificamos que\n" + certificado.getDev() + "\nem " + certificado.getDataConclusao() + ", concluiu o bootcamp\n" + certificado.getTitulo() + "\ncom carga horária total de " + certificado.getCargaHoraria() + " horas.\n__________________________________________\nCERTIFICADO BOOTCAMP VERSO:\n__________________________________________\nLista de cursos:\n" + bootcamp.getConteudos());
        }

        return certificado;
    }

    //Método agora precisa de parâmetro
    public void progredir(Conteudo conteudo) {
        
        if(conteudo.getClass().getName().contains("Curso")) {
            //Gerando certificado do curso
            Certificado certificado = new Certificado();
            certificado.setDev(this.nome);
            certificado.setTitulo(conteudo.getTitulo());
            //cast para pegar método da classe filha
            certificado.setCargaHoraria(conteudo.getCargaHoraria(((Curso)conteudo)));
            this.certificados.add(certificado);

            System.out.println("__________________________________________\n----------------CERTIFICADO---------------\nCertificamos que\n" + certificado.getDev() + "\nem " + certificado.getDataConclusao() + ", concluiu o curso\n" + certificado.getTitulo() + "\ncom carga horária total de " + certificado.getCargaHoraria() + " horas.\n__________________________________________");
        } 

        this.conteudosConcluidos.add(conteudo);
        this.conteudosInscritos.remove(conteudo);
        
        for (Bootcamp bootcamp : bootcamps) {
            if (conteudosConcluidos.containsAll(bootcamp.getConteudos())) {
                gerarCertificado(bootcamp);
            }
        }

    }

    public double calcularTotalXp() {
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }
        return soma;

        /*return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();*/
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    public Set<Certificado> getCertificados() {
        return certificados;
    }

    public void setCertificados(Set<Certificado> certificados) {
        this.certificados = certificados;
    }    

    public Set<Bootcamp> getBootcamps() {
        return bootcamps;
    }

    public void setBootcamps(Set<Bootcamp> bootcamps) {
        this.bootcamps = bootcamps;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos) && Objects.equals(certificados, dev.certificados) && Objects.equals(bootcamps, dev.bootcamps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos, certificados);
    }

}
