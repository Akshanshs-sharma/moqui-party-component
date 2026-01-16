\# Party Component (Moqui)



This component implements a basic Party domain model in Moqui.



\## Entities

\- Party

\- Person (Party subtype)

\- PartyGroup (Party subtype)

\- ContactMech

\- PartyContactMech (association with effective dates)



\## Enumerations

\- PartyType (PERSON, PARTY\_GROUP)

\- ContactMechType (EMAIL, TELECOM\_NUMBER)



\## Data Loading

Seed data is provided under `data/` and must be loaded in order.



\### Load command

```bash

gradlew load



