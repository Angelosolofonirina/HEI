package hei.concours.hei.model;

public class Sujet {
    private int id;
    private String urlSujetMaths;
    private String urlSujetFrançais;
    private int idConcours;

    public Sujet(String urlSujetMaths, String urlSujetFrançais, int idConcours) {
        this.urlSujetMaths = urlSujetMaths;
        this.urlSujetFrançais = urlSujetFrançais;
        this.idConcours = idConcours;
    }

    public Sujet(int id, String urlSujetMaths, String urlSujetFrançais, int idConcours) {
        this.id = id;
        this.urlSujetMaths = urlSujetMaths;
        this.urlSujetFrançais = urlSujetFrançais;
        this.idConcours = idConcours;
    }

    public Sujet(String urlSujetMaths, String urlSujetFrançais) {
        this.urlSujetMaths = urlSujetMaths;
        this.urlSujetFrançais = urlSujetFrançais;
    }
    public Sujet(){}

    public int getId() {
        return id;
    }

    public String getUrlSujetMaths() {
        return urlSujetMaths;
    }

    public String getUrlSujetFrançais() {
        return urlSujetFrançais;
    }

    public int getIdConcours() {
        return idConcours;
    }
}
