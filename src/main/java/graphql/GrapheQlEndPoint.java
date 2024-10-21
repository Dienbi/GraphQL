package graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.LogementRepository;
import repository.RendezVousRepository;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class GrapheQlEndPoint extends SimpleGraphQLServlet {

    public GrapheQlEndPoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        RendezVousRepository rdvRepository = new RendezVousRepository();
        LogementRepository lrRepository = new LogementRepository();

        // Créer une instance de Mutation
        Mutation mutation = new Mutation(rdvRepository,lrRepository);

        return SchemaParser.newParser()
                .file("schema.graphqls")  // Assurez-vous que ce fichier contient bien la définition de vos types
                .resolvers(new Querries(rdvRepository,lrRepository), mutation) // Inclure le résolveur de mutation
                .build()
                .makeExecutableSchema();
    }
}
