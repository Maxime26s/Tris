import java.util.*;

/**
 * Created by simma1733207 on 2018-03-26.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Livre> liste1 = new ArrayList<>();
        ArrayList<Livre> liste2 = new ArrayList<>();
        ArrayList<Livre> liste3 = new ArrayList<>();
        TreeSet<Livre> liste4 = new TreeSet<>();
        TreeSet<Livre> liste5 = new TreeSet<>(new ComparateurParEtapes());

        bookCreator(liste1);
        bookCreator(liste2);
        bookCreator(liste3);
        bookCreator(liste4);
        bookCreator(liste5);

        tri(liste1);
        Collections.sort(liste2);
        Collections.sort(liste3,new ComparateurParEtapes());

        System.out.println("----------Par Année----------");
        affichageAnnee(liste1);
        System.out.println("----------Par Année----------");
        affichageAnnee(liste2);
        System.out.println("----------Par Étapes----------");
        affichageEtape(liste3);
        System.out.println("----------Par Année----------");
        affichageAnnee(liste4);
        System.out.println("----------Par Étapes----------");
        affichageEtape(liste5);
    }

    public static void tri(ArrayList<Livre> liste){
        int smallest;
        Livre temp1;
        for(int i=0;i<liste.size();i++){
            smallest=i;
            temp1=liste.get(i);
            for(int j=i;j<liste.size();j++){
                if(temp1.compareTo(liste.get(j))>0){
                    temp1=liste.get(j);
                    smallest=j;
                }
            }
            liste.remove(smallest);
            liste.add(i,temp1);
        }
    }

    public static void bookCreator(Collection<Livre> liste){
        liste.add(new Livre(1900, "Charles en foret", "Pas content", "Ibar", "Les Grenouilles","1234"));
        liste.add(new Livre(57, "Simon le traillant", "Angery", "Ibar", "Les Grenouilles","8383"));
        liste.add(new Livre(2010,"Simon le travaillant","Remastered","Charles","Les Grenouilles","43828"));
        liste.add(new Livre(2011,"Simon le travaillant 2","Original","Nic","Les Grenouilles","43828"));
        liste.add(new Livre(1954, "Les chevals", "Première édition", "Max", "Les Animaux De La Ferme","4321"));
        liste.add(new Livre(1955, "Les chevaux", "Version corrigée", "Max", "Les Animaux De La Ferme","4322"));
        liste.add(new Livre(2016, "Java pour les nuls", "C'est pas si compliqué","Kim", "Les Codeurs Qui Codent","8432"));
        liste.add(new Livre(2017, "Java pour les nuls 2", "C'est pas si compliqué 2", "Kim", "Les Codeurs Qui Codent","7574"));
        liste.add(new Livre(2006, "L'ile des défis extrêmes", "Fou", "Raph", "Les Éditions SH","57473"));
        liste.add(new Livre(2007, "L'ile des défis extrêmes 2", "Encore plus fou", "Raph", "Les Éditions SH","789432"));
    }

    public static void affichageAnnee(Collection<Livre> liste){
        for (Livre livre : liste) {
            System.out.println("-"+livre.getAnnee()+", "+livre.getTitre()+", "+livre.getSousTitre()+", "+livre.getAuteur()+", "+livre.getMaisonEdition()+", "+livre.getIsbn());
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    public static void affichageEtape(Collection<Livre> liste){
        for (Livre livre : liste) {
            System.out.println("-"+livre.getMaisonEdition()+", "+livre.getAuteur()+", "+livre.getTitre()+", "+livre.getSousTitre()+", "+livre.getAnnee()+", "+livre.getIsbn());
        }
        System.out.println("-------------------------------------------------------------------------");
    }
}
