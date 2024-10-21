package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class Querries implements GraphQLRootResolver {
    public RendezVousRepository rdv;
    public LogementRepository lvr;

    public Querries(RendezVousRepository rdv, LogementRepository lvr) {
        this.rdv = rdv;
        this.lvr = lvr;
    }
    //rendez vous
    public List<RendezVous>allrendezvous(){
        return rdv.getListeRendezVous();
}

    public List<RendezVous>ListeRendezVousByLogementRef(int refLog){
        return rdv.getListeRendezVousByLogementRef(refLog);
    }
    public RendezVous GetRendezVousById(int id) {
        for (RendezVous r : rdv.getListeRendezVous()) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null; // Retourne null si le rendez-vous n'est pas trouvé
    }
    //***********************************************************
    //logement
    public List<Logement>alllogement(){
        return lvr.getAllLogements();
    }
    public Logement GetLogementById(int id) {
        return lvr.getLogementsByReference(id);
    }
    public List<Logement>ListeLogementByLogementType(Logement.Type type){
        return  lvr.getLogementsByType(type);
    }





}
