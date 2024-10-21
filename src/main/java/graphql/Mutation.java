
package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

public class Mutation implements GraphQLRootResolver {
    private final RendezVousRepository rdvRepository;
    private final LogementRepository logRepository;

    public Mutation(RendezVousRepository rdvRepository, LogementRepository logRepository) {
        this.rdvRepository = rdvRepository;
        this.logRepository = logRepository;
    }

     public boolean createRendezVous(int id, String date, String heure, int refLog, String numTel) {
        RendezVous rendezVous = new RendezVous(id, date, heure, logRepository.getLogementsByReference(refLog), numTel);
        return rdvRepository.addRendezVous(rendezVous);
    }

    public boolean updateRendezVous(int id, String date, String heure, String numTel) {
        RendezVous rendezVous = new RendezVous(id, date, heure, rdvRepository.getLogementByRDV(id), numTel);
        return rdvRepository.updateRendezVous(rendezVous);
    }
    public boolean deleteRendezVous(int id) {
        return rdvRepository.deleteRendezVous(id);
    }

}