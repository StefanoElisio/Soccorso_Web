# Soccorso_Web
 Progetto di Sviluppo Web avanzato

### Considerazioni

- "L'email" del segnalatore è stata sostituita da un più generico "contatto"
- Il segnalatore è stato rimosso e ingoblato nella richiesta di soccorso dato che l'unica sua presenza del sistema deriva dalla relazione con la richiesta, per quanto sia un attore principale nella base non ci è di acluna utilità avere una lista dei segnalatori senza l'associazione alle proprie richieste, e nella richiesta non è un problema avere le informazione del segnalatore data la mancaza di dati personali sensibili
- Dopo aver considerato l'idea di aggiungere l'entità "Patente" da associare all'operatore e ai veicoli, questa è stata scartata dato che: 
    1. Un operatore può avere una patente che è associata ad un veicolo ma essere in una zona diversa da quella in cui il veicolo è situato
    2. Un operatore può avere una patente che è associata ad un veicolo ma per scelta personale o dell'azienda non si occupa dell'utilizzo di quel determinato veicolo
    3. Risulta molto più comodo per questo scopo associare direttamente il singolo operatore ai veicoli da lui guidabili (ovviamente deve comunque avere una patente adeguata al veicolo)

### Bozza Modello ER

<img src="Bozza_ER.jpg">

### Traduzione modello ER nel modello relazionale

* **Amministratore**(**<ins>ID</ins>**, username, password)
* **Operatore**(**<ins>ID</ins>**, username, password, anagrafica, patenti, abilità, disponibilità)
* **Segnalatore**(**<ins>ID</ins>**,email, nome)
* **Richiesta_di_soccorso**(**<ins>ID</ins>**,  **<ins>ID_Amministratore</ins>**, descrizione, posizione, foto, stato, nome, contatto)
* **Missione**(**<ins>ID</ins>**, **<ins>ID_richiesta</ins>**, obiettivo, t_inizio, t_fine, lvl_successo)
* **Attrezzatura**(**<ins>ID</ins>**, nome, descrizione)
* **Veicolo**(**<ins>ID</ins>**, nome, descrizione)
* **Aggiornamento**(**<ins>ID</ins>**, **<ins>ID_Missione</ins>**, **<ins>ID_Amministratore</ins>**, **<ins>Timestamp</ins>**, descrizione)
* **Veicolo_Missione**(**<ins>ID</ins>**, **<ins>ID_Missione</ins>**, **<ins>ID_Veicolo</ins>**)
* **Veicolo_Operatore**(**<ins>ID</ins>**, **<ins>ID_Operatore</ins>**, **<ins>ID_veicolo</ins>**)
* **Attrezzatura_Missione**(**<ins>ID</ins>**, **<ins>ID_Missione</ins>**, **<ins>ID_Attrezzatura</ins>**)
* **Attrezzatura_Missione**(**<ins>ID</ins>**, **<ins>ID_Missione</ins>**, **<ins>ID_Attrezzatura</ins>**)

- **<ins>ID</ins>** e/o **<ins>attributo</ins>** è la chiave
- **<ins>ID_entità</ins>** è la chiave esterna
- alcuni dei nomi presenti sul diagramma sono stati abbreviati per semplicità

