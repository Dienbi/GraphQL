package graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.RendezVousRepository;

import javax.servlet.annotation.WebServlet;
@WebServlet(urlPatterns = "/graphql")
public class GrapheQlEndPoint extends SimpleGraphQLServlet {

   public GrapheQlEndPoint(){
       super(buildSchema());
   }
    private static GraphQLSchema buildSchema() {
        RendezVousRepository rdv=new RendezVousRepository();
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Querries(rdv))
                .build().makeExecutableSchema()  ;
    }
}
