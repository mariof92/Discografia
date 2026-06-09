# Discografia API

REST API per la gestione di una discografia, con relazione tra gruppi e album, sviluppata con Spring Boot e MySQL.

## Tecnologie
- Java 21
- Spring Boot 3.5
- Spring Data JPA
- MySQL
- Lombok

## Prerequisiti
- Java 21 installato
- MySQL installato e in esecuzione
- Postman per testare gli endpoint

## Configurazione
Crea un file `application.properties` in `src/main/resources/` con questo contenuto:

```properties
spring.application.name=Discografia
spring.datasource.url=jdbc:mysql://localhost:3306/nomeDatabase
spring.datasource.username=root
spring.datasource.password=tuaPassword
spring.jpa.hibernate.ddl-auto=update
```

Crea il database su MySQL:
```sql
CREATE DATABASE nomeDatabase;
```

## Struttura
Un **Gruppo** può avere molti **Album**. Ogni **Album** appartiene a un solo **Gruppo**.

## Endpoint Gruppo

| Metodo | URL | Descrizione |
|--------|-----|-------------|
| GET | `/gruppo` | Restituisce tutti i gruppi |
| POST | `/gruppo` | Aggiunge un gruppo |
| PUT | `/gruppo/{id}` | Modifica un gruppo |
| DELETE | `/gruppo/{id}` | Elimina un gruppo |

## Endpoint Album

| Metodo | URL | Descrizione |
|--------|-----|-------------|
| GET | `/album` | Restituisce tutti gli album |
| POST | `/album` | Aggiunge un album |
| PUT | `/album/{id}` | Modifica un album |
| DELETE | `/album/{id}` | Elimina un album |

## Esempio POST Gruppo

```json
{
    "nome": "Deftones",
    "genere": "Rock",
    "nazione": "USA"
}
```

## Esempio POST Album

```json
{
    "titolo": "Adrenaline",
    "anno": 1995,
    "numeroTracce": 11,
    "gruppo": {
        "id": 1
    }
}
```
