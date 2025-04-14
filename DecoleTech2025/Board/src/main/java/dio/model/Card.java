package dio.model;

public class Card {
    private int id;
    private String nome;
    private String descricao;
    private String status; // "pendente", "concluido", "cancelado"
    private boolean bloqueado;
    private int boardId;

    public Card() {}

    public Card(int id, String nome, String descricao, String status, boolean bloqueado, int boardId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.bloqueado = bloqueado;
        this.boardId = boardId;
    }

    // Getters e setters
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    @Override
    public String toString() {
        return "Card{id=" + id +
               ", nome='" + nome + '\'' +
               ", descricao='" + descricao + '\'' +
               ", status='" + status + '\'' +
               ", bloqueado=" + bloqueado +
               ", boardId=" + boardId + '}';
    }
}
