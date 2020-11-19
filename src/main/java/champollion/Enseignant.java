package champollion;

import java.util.*;

public class Enseignant extends Personne {
    
    private final List<ServicePrevu> servicesPrevus = new LinkedList<>();
    private final List<Intervention> interventionsPlanifiees = new LinkedList<>();

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    public Enseignant(String nom, String email) {
        super(nom, email);
    }
    
    public void ajouteIntervention(Intervention e) {
        this.interventionsPlanifiees.add(e);
    }
    
    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        int volumeTotalCM = 0;
        int volumeTotalTD = 0;
        int volumeTotalTP = 0;
        for (ServicePrevu s : servicesPrevus) {
            volumeTotalCM += 1.5*s.getVolumeCM();
            volumeTotalTD += s.getVolumeTD();
            volumeTotalTP += 0.75*s.getVolumeTP();
        }
        int result = Math.round(volumeTotalCM + volumeTotalTD + volumeTotalTP);
        return result;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        int equivalentTD = 0;
        int volumeCM = 0;
        int volumeTD = 0;
        int volumeTP = 0;
        for (ServicePrevu s : servicesPrevus) {
            if (ue.equals(s.getUE())) {
                volumeCM += 1.5*s.getVolumeCM();
                volumeTD += s.getVolumeTD();
                volumeTP += 0.75*s.getVolumeTP();
            }
        }
        int result = Math.round(volumeCM + volumeTD + volumeTP);
        return result;
    }
    
    
    
    //lier à l'intervention
    public int heuresPlanifiees() {
        int volumeCM = 0;
        int volumeTD = 0;
        int volumeTP = 0;
        for (ServicePrevu s : servicesPrevus) {
            for (Intervention i : interventionsPlanifiees) {
                if (i.getCM() != s.getVolumeCM()) {
                    volumeCM += 1.5*s.getVolumeCM() - 1.5*i.getCM();
                }
                if (i.getCM() == s.getVolumeCM()) {
                    volumeCM += 1.5*i.getCM();
                }
                if (i.getTD() != s.getVolumeTD()) {
                    volumeTD += s.getVolumeTD() - i.getTD();
                }
                if (i.getTD() == s.getVolumeTD()) {
                    volumeTD += i.getTD();
                }
                if (i.getTP() != s.getVolumeTP()) {
                    volumeTP += 0.75*s.getVolumeTP() - 0.75*i.getTP();
                }
                if (i.getTP() == s.getVolumeTP()) {
                    volumeTP += 0.75*i.getTP();
                }
            }
        }
        return Math.round(volumeCM + volumeTD + volumeTP);
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        ServicePrevu sp = new ServicePrevu(this, ue, volumeCM, volumeTD, volumeTP);
        this.servicesPrevus.add(sp);
    }

    public boolean enSousService() {
        if (this.heuresPrevues() < 192) {
            return true;
        }
        return false;
    }
}
