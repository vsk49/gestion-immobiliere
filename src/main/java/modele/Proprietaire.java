package modele;

public record Proprietaire(String idProprietaire, String motDePasse) {

    @Override
    public String toString() {
        return "Proprietaire{" + "idProprietaire=" + idProprietaire + ", motDePasse=" + motDePasse + '}';
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Proprietaire proprietaire = (Proprietaire) other;
        return idProprietaire.equals(proprietaire.idProprietaire) && motDePasse.equals(proprietaire.motDePasse);
    }

}
