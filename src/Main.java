import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);
        
        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        
        System.out.println("\n-----> Devs inscritos no Bootcamp Fullstack: <-----\n\n" + "1) " + devCamila.getNome() + "\n-----> Cursos a realizar:\n" + devCamila.getConteudosInscritos() + "\n\n" + "2) " + devJoao.getNome() + "\n-----> Cursos a realizar:\n" + devJoao.getConteudosInscritos());

        devCamila.progredir(mentoria);
        devCamila.progredir(curso2);
        devJoao.progredir(mentoria);
        devJoao.progredir(curso2);
        devJoao.progredir(curso1);

        System.out.println("\n-----> Atualizando o progresso dos Devs : <-----\n\n" + "1) " + devCamila.getNome() + "\n-----> Cursos a realizar:\n" + devCamila.getConteudosInscritos() + "\n-----> Cursos concluídos:\n" + devCamila.getConteudosConcluidos() + "\n-----> XP do Aluno: " +devCamila.calcularTotalXp() + "\n\n" + "2) " + devJoao.getNome() + "\n-----> Cursos a realizar:\n" + devJoao.getConteudosInscritos() + "\n-----> Cursos concluídos:\n" + devJoao.getConteudosConcluidos() + "\n-----> XP do Aluno: " + devJoao.calcularTotalXp() + "\n");

        System.out.println(devCamila.getCertificados());
        System.out.println(devJoao.getCertificados());
    }

}
