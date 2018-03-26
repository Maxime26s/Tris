import java.util.Comparator;

/**
 * Created by simma1733207 on 2018-03-26.
 */
public class ComparateurParEtapes implements Comparator<Livre>{

    @Override
    public int compare(Livre o1, Livre o2) {
        int maisonEditionCompare = o1.getMaisonEdition().compareTo(o2.getMaisonEdition());
        if(maisonEditionCompare==0){
            int auteurCompare = o1.getAuteur().compareTo(o2.getAuteur());
            if(auteurCompare==0){
                int titreCompare = o1.getTitre().compareTo(o2.getTitre());
                if(titreCompare==0){
                    return o1.getAnnee()-o2.getAnnee();
                }
                return titreCompare;
            }
            return auteurCompare;
        }
        return maisonEditionCompare;
    }
}
