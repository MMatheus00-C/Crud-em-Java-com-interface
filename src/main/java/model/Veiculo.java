package model;

public class Veiculo {
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private String cor;
    private String placa;
    private int quilometragem;
    private double precoDiaria;
    private boolean disponivel;
    private String categoria;
    private String descricao;

    public Veiculo() {
    }

    public Veiculo(int id, String marca, String modelo, int ano, String cor, String placa, int quilometragem, double precoDiaria, boolean disponivel, String categoria, String descricao) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
        this.quilometragem = quilometragem;
        this.precoDiaria = precoDiaria;
        this.disponivel = disponivel;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public Veiculo(String marca, String modelo, int ano, String cor, String placa, int quilometragem, double precoDiaria, boolean disponivel, String categoria, String descricao) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
        this.quilometragem = quilometragem;
        this.precoDiaria = precoDiaria;
        this.disponivel = disponivel;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public int getQuilometragem() { return quilometragem; }
    public void setQuilometragem(int quilometragem) { this.quilometragem = quilometragem; }
    public double getPrecoDiaria() { return precoDiaria; }
    public void setPrecoDiaria(double precoDiaria) { this.precoDiaria = precoDiaria; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
