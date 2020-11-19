package champollion;

public class ServicePrevu {
	// TODO : implémenter cette classe
    private int volumeCM;
    private int volumeTD;
    private int volumeTP;
    
    private final Enseignant enseignant;
    private final UE ue;
    
    public ServicePrevu(Enseignant enseignant, UE ue, int volumeCM, int volumeTD, int volumeTP) {
        this.enseignant = enseignant;
        this.ue = ue;
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
    }
    
    
    public Enseignant getEnseignant() {
        return this.enseignant;
    }
    
    public UE getUE() {
        return this.ue;
    }
    
    public int getVolumeCM() {
        return this.volumeCM;
    }
    
    public int getVolumeTD() {
        return this.volumeTD;
    }
    
    public int getVolumeTP() {
        return this.volumeTP;
    }
}
