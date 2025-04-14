package dio.model;

public class Board {
    private int id;
    private String nome;

    public Board() {}

    public Board(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Board{id=" + id + ", nome='" + nome + "'}";
    }
}
