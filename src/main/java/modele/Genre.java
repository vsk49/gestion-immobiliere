package modele;

public enum Genre {

    MASCULIN("M"), FEMININ("F");

    private final String genre;

    Genre(String s) {
        this.genre = s;
    }

    public String getLibelle() {
        return genre;
    }

}
