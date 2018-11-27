public class Tarefas {

    private String id;
    private String description;
    private Boolean done;

    @Override
    public String toString(){
        return "Tarefa [ID = "+ id + ", Descrição = " + description + ", Terminado = " + done + "]\n";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return description;
    }

    public void setDescricao(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

}
