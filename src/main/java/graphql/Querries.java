package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.RendezVous;
import repository.RendezVousRepository;

import java.util.List;

public class Querries implements GraphQLRootResolver {
    public RendezVousRepository rdv;

    public Querries(RendezVousRepository rdv) {
        this.rdv = rdv;
    }

    public List<RendezVous>allrendezvous(){
        return rdv.getListeRendezVous();
}


}
