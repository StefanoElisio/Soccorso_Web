# Soccorso_Web
Progetto di Sviluppo Web avanzato
- link del codice su [GitHub](https://github.com/StefanoElisio/Soccorso_Web)
- Puoi trovare altre specifiche e considerazioni sul progetto in fase di progettazione [qui](Doc/doc_progettazione.md)

## Dipendenze Principali

### Specifiche Jakarta EE
| Dipendenza | Versione | Scope | Descrizione |
|------------|---------|-------|-------------|
| `jakarta.servlet:jakarta.servlet-api` | 6.0.0 | provided | API Jakarta Servlet |
| `jakarta.ws.rs:jakarta.ws.rs-api` | 3.1.0 | compile | API JAX-RS |
| `jakarta.annotation:jakarta.annotation-api` | 2.1.1 | compile | Annotazioni comuni |
| `jakarta.validation:jakarta.validation-api` | 3.0.2 | compile | API per la validazione |
| `jakarta.inject:jakarta.inject-api` | 2.0.1 | compile | Dependency Injection |

### Framework Jersey

| Dipendenza | Versione | Scope | Descrizione |
|------------|---------|-------|-------------|
| `org.glassfish.jersey.containers:jersey-container-servlet` | 3.1.8 | compile | Container Servlet Jersey |
| `org.glassfish.jersey.core:jersey-common` | 3.1.8 | compile | Utility comuni Jersey |
| `org.glassfish.jersey.core:jersey-server` | 3.1.8 | compile | Implementazione server Jersey |
| `org.glassfish.jersey.core:jersey-client` | 3.1.8 | compile | Implementazione client Jersey |

### Dependency Injection (HK2)

| Dipendenza | Versione | Scope | Descrizione |
|------------|---------|-------|-------------|
| `org.glassfish.jersey.inject:jersey-hk2` | 3.1.8 | compile | Integrazione HK2-Jersey |
| `org.glassfish.hk2:hk2-locator` | 3.0.6 | compile | Service locator HK2 |
| `org.glassfish.hk2:hk2-api` | 3.0.6 | compile | API core HK2 |
| `org.javassist:javassist` | 3.30.2-GA | compile | Manipolazione bytecode |

### Elaborazione JSON

| Dipendenza | Versione | Scope | Descrizione |
|------------|---------|-------|-------------|
| `com.fasterxml.jackson.jakarta.rs:jackson-jakarta-rs-json-provider` | 2.17.2 | compile | Provider JSON Jackson per JAX-RS |
| `com.fasterxml.jackson.core:jackson-databind` | 2.17.2 | compile | Data binding Jackson |
| `com.fasterxml.jackson.core:jackson-core` | 2.17.2 | compile | Core Jackson |
| `com.fasterxml.jackson.datatype:jackson-datatype-jsr310` | 2.17.2 | compile | Supporto Date/Time Java 8 |

### XML Binding (per l'elaborazione JSON)

| Dipendenza | Versione | Scope | Descrizione |
|------------|---------|-------|-------------|
| `jakarta.xml.bind:jakarta.xml.bind-api` | 3.0.1 | compile | API Jakarta XML Binding |
| `jakarta.activation:jakarta.activation-api` | 2.1.0 | compile | API Jakarta Activation |

### JSON Web Tokens (JWT)

| Dipendenza | Versione | Scope | Descrizione |
|------------|---------|-------|-------------|
| `io.jsonwebtoken:jjwt-jackson` | 0.12.6 | compile | Supporto Jackson per JJWT |
| `io.jsonwebtoken:jjwt-api` | 0.12.6 | compile | API JJWT |
| `io.jsonwebtoken:jjwt-impl` | 0.12.6 | compile | Implementazione JJWT |

### Requisiti di Runtime
- Un server compatibile con Jakarta EE 9+ (Tomcat 10+, Jetty 11+, ecc.)

Per progetti Maven, queste dipendenze verranno risolte automaticamente. Per altri sistemi di build, assicurarsi di includere tutte le dipendenze elencate.

## Funzionalità
Il progetto è stato progettato per soddisfare tutte e 13 le richieste evidenziate nella specifica.
- 3 Classi definite (Richiesta, Missione e Operatore)
- Logica di business (prototipale) implementata per soddisfare tutte le richieste necessarie
- Serializzatori e deserializzatori per ogniuna delle 3 classi e per ogniuno dei campi

### Mancanze
- Mancano alcuni campi nei deserializzatori (liste di oggetti)
- Parte di autenticazione (e le eccezzioni) è stata ripresa dal progetto di esempio (fatto in classe) ma non è stata ulteriormente implementata, particolarmente andrebbe distinto l'accesso fra l'admin e gli operatori
- Resources purtroppo implementate solo per le richieste, mancano opatori e missioni

## Specifica API
- la specifica in formato OpenAPI è consultabile con il seguente [file.yaml](Doc/Specifica_OpenAPI.yaml) tramite il tool di *Swagger*(<https://swagger.io/tools>)
