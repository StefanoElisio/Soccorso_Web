package org.univaq.swa.soccorsowebrest;

import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.univaq.swa.soccorsowebrest.jackson.ObjectMapperContextResolver;
import org.univaq.swa.soccorsowebrest.resources.OperatorsResource;
import org.univaq.swa.soccorsowebrest.resources.RequestsResource;
import org.univaq.swa.soccorsowebrest.resources.TestResource;
import org.univaq.swa.soccorsowebrest.security.AuthLoggedFilter;
import org.univaq.swa.soccorsowebrest.security.AuthenticationRes;
import org.univaq.swa.soccorsowebrest.security.CORSFilter;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("rest")
public class RESTApp extends Application {

    private final Set<Class<?>> classes;

    public RESTApp() {
        HashSet<Class<?>> c = new HashSet<>();
        // aggiungiamo tutte le *root resurces* (cioè quelle
        // con l'annotazione Path) che vogliamo pubblicare
        c.add(RequestsResource.class);
        c.add(OperatorsResource.class);
        c.add(TestResource.class);
        c.add(AuthenticationRes.class);

        // aggiungiamo il provider Jackson per poter
        // usare i suoi servizi di serializzazione e
        // deserializzazione JSON
        c.add(JacksonJsonProvider.class);

        // necessario se vogliamo una (de)serializzazione custom di qualche classe
        c.add(ObjectMapperContextResolver.class);

        // esempio di autenticazione
        c.add(AuthLoggedFilter.class);

        // aggiungiamo il filtro che gestisce gli header CORS
        c.add(CORSFilter.class);

        classes = Collections.unmodifiableSet(c);
    }

    // l'override di questo metodo deve restituire il set
    // di classi che Jersey utilizzerà per pubblicare il
    // servizio. Tutte le altre, anche se annotate, verranno
    // IGNORATE
    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
