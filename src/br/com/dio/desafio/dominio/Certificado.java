package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Certificado {
    
    private String dev;
    private LocalDate dataConclusao = LocalDate.now();
    private String titulo;
    private int cargaHoraria;
    
    public String getDev() {
        return dev;
    }
    public void setDev(String dev) {
        this.dev = dev;
    }
    public LocalDate getDataConclusao() {
        return dataConclusao;
    }
    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Certificado [dev=" + dev + ", dataConclusao=" + dataConclusao + ", titulo=" + titulo + ", cargaHoraria="
                + cargaHoraria + "]";
    }
    
}
