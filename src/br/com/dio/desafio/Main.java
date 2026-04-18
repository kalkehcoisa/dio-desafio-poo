package br.com.dio.desafio;

import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Curso> cursos = new HashMap<>();
        cursos.put("java", new Curso("curso java", "descricao curso java", 8));
        cursos.put("data", new Curso("curso data", "descricao curso data", 16));
        cursos.put("js", new Curso("curso JS", "descricao curso JS", 4));
        
        Map<String, Mentoria> mentorias = new HashMap<>();
        mentorias.put("java", new Mentoria("mentoria de Java", "descricao mentoria Java", LocalDate.now()));
        mentorias.put("data", new Mentoria("mentoria de Data", "descricao mentoria Java", LocalDate.now()));
        mentorias.put("js", new Mentoria("mentoria de JS", "descricao mentoria Java", LocalDate.now()));

        Map<String, Bootcamp> bootcamps = new HashMap<>();
        bootcamps.put("java", new Bootcamp("Bootcamp Java Developer", "Descricao Bootcamp Java Developer"));
        bootcamps.get("java").addConteudo(cursos.get("java"));
        bootcamps.get("java").addConteudo(mentorias.get("java"));
        bootcamps.put("data", new Bootcamp("Bootcamp Data Developer", "Descricao Bootcamp Data Developer"));
        bootcamps.get("data").addConteudo(cursos.get("data"));
        bootcamps.get("data").addConteudo(mentorias.get("data"));
        bootcamps.put("js", new Bootcamp("Bootcamp JS Developer", "Descricao Bootcamp JS Developer"));
        bootcamps.get("js").addConteudo(cursos.get("js"));
        bootcamps.get("js").addConteudo(mentorias.get("js"));


        Map<String, List<Object[]>> acoes = new HashMap<>();
        acoes.put("Camila", new ArrayList<>());
        acoes.get("Camila").addAll(List.of(
                new Object[]{"inscrever", bootcamps.get("java")},
                new Object[]{"progredir", null},
                new Object[]{"progredir", null},
                new Object[]{"inscrever", bootcamps.get("data")},
                new Object[]{"progredir", null},
                new Object[]{"progredir", null},
                new Object[]{"progredir", null},
                new Object[]{"progredir", null}
        ));
        acoes.put("João", new ArrayList<>());
        acoes.get("João").addAll(List.of(
                new Object[]{"inscrever", bootcamps.get("java")},
                new Object[]{"progredir", null},
                new Object[]{"progredir", null},
                new Object[]{"progredir", null},
                new Object[]{"inscrever", bootcamps.get("data")},
                new Object[]{"progredir", null},
                new Object[]{"progredir", null}
        ));
        acoes.put("Carol", new ArrayList<>());
        acoes.get("Carol").addAll(List.of(
                new Object[]{"inscrever", bootcamps.get("java")},
                new Object[]{"progredir", null},
                new Object[]{"progredir", null},
                new Object[]{"progredir", null},
                new Object[]{"progredir", null},
                new Object[]{"progredir", null},
                new Object[]{"inscrever", bootcamps.get("data")},
                new Object[]{"progredir", null},
                new Object[]{"progredir", null},
                new Object[]{"progredir", null},
                new Object[]{"progredir", null},
                new Object[]{"progredir", null},
                new Object[]{"inscrever", bootcamps.get("js")},
                new Object[]{"progredir", null},
                new Object[]{"progredir", null}
        ));

        for (Map.Entry<String, List<Object[]>> entry : acoes.entrySet()) {
            String nomeDev = entry.getKey();
            List<Object[]> listaAcoes = entry.getValue();
            Dev dev = new Dev(nomeDev);

            System.out.println("Ações de " + dev.getNome() + ": ");
            for (Object[] acao : listaAcoes) {
                String tipo = (String) acao[0];
                Bootcamp bootcamp = (Bootcamp) acao[1];
                if (bootcamp != null) {
                    System.out.println(bootcamp.getNome());
                }

                switch (tipo) {
                    case "inscrever":
                        dev.inscreverBootcamp(bootcamp);
                        break;
                    case "progredir":
                        dev.progredir();
                        break;
                }
            }
            System.out.println("-");
            if(!dev.getConteudosInscritos().isEmpty()) {
                System.out.println("Conteúdos Inscritos: ");
                dev.printConteudosInscritos();
            }
            if(!dev.getConteudosConcluidos().isEmpty()) {
                System.out.println("Conteúdos Concluídos: ");
                dev.printConteudosConcluidos();
            }
            System.out.println("XP:" + dev.calcularTotalXp());

            System.out.println("\n=======================================\n");
        }

    }
}