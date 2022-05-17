# AndroidAflevering

Link til video: 
(note - Toast blev ikke vist i demonstrationen, men den er med i koden, og virker på andre emulatorer, grundet en emulator fejl)

#### Kort beskrivelse af applikationen: ####
En parkerings applikation, hvor det er muligt at oprette sig og logge ind med sin egen Google-konto, en side hvor man kan søge på en addresse og åbne google maps derved. 
Herudover er det muligt at ændre sproget på appen mellem dansk og engelsk. Derudover vil det være muligt at læse information om udbyderen.

#### Motivation for valg af app: ####
Vi har valgt at lave en parkerings applikation, da den har mulighed for at indeholde en masse forskellige funktioner. Vi kiggede på de krav, som er stillet til vores app projekt. Ud fra det kom vi frem til, at en parkerings app ville kunne dække kravene for hvad appen skal indeholde. Derudover er det noget vi selv gør brug af, når vi er i besiddelse af en bil, og synes er dejlig nemt og tidsbesparende.

#### Prioriteret liste af user stories: ####
- [x] 1. Jeg vil gerne kunne oprette og logge ind som bruger
- [x] 2. Jeg vil gerne kunne se en liste med SmartParks samarbejdspartnere
- [x] 3. Jeg vil gerne kunne ændre sprog
- [x] 4. Jeg vil gerne kunne se parkeringsmuligheder tæt på min lokation
- [ ] 5. Jeg vil gerne kunne se en liste med min historik over parkeringer 
- [x] 6. Jeg vil gerne kunne finde information om SmartPark
- [x] 7. Jeg vil gerne kunne kunne logge ud og evt. logge ind på en anden bruger
- [x] 8. Jeg vil gerne kunne lukke appen og stadig være logget ind, når jeg åbner den igen.
- [x] 9. Jeg vil gerne kunne indtaste en addresse, og derved se parkeringsmuligheder nær den givne addresse.

#### Test af applikation: ####

Gennem hele udarbejdelsen af appen, har der været systematiske tests med 15 minutters intervaller eller efter hver ændring i koden, som skulle gøre det lettere for os at fejlfinde eventuelle problemer samt teste applikationens funktionalitet. Ydermere hjalp de systematiske test til at optimere kvaliteten af appen. 

#### Gennemgang af requirements: ####
    
1. Jeg vil gerne kunne oprette og logge ind som bruger
- Her er der blevet benyttet firebase, hvortil der bliver gjort brug af firebase's egen login system, hvor der bruges networking så brugeren har muligheden for at logge ind med sin personlige Google-konto.   
  
2. Jeg vil gerne kunne se en liste med SmartParks samarbejdspartnere
- Her er der blevet brugt et recyclingView med scroll funktion, der gør det muligt at vise SmartPark's samarbejdspartnere. 

3. Jeg vil gerne kunne ændre sprog
- Her er der blevet oprettet en ny custom engelsk string fil, og så er det gjort muligt for brugeren at skifte mellem de to eksisterende string filer, alt efter hvilket sprog brugeren ønsker.

4. Jeg vil gerne kunne se parkeringsmuligheder tæt på min lokation
- Her er der blevet brugt en Expicit Intent som gør det muligt at åbne Google Maps og vise parkeringsmuligheder tæt på brugerens lokation. Denne funktionalitet er også tilkoblet en floating actionbar. 

5. Jeg vil gerne kunne se en liste med min historik over parkeringer 
- Oprindeligt var planen, at lave en liste hvor det ville være muligt at se brugerens tidligere parkeringer gennem appen. De inputs som brugeren laver i søgefeltet, skulle oprindeligt gennem på et room/shared preferences, derefter vises i en recycled-liste. Grundet tekniske problemer og tidsnød var dette ikke muligt.

6. Jeg vil gerne kunne finde information om SmartPark
- For at kunne se information om Smartpark er der gjort brug af strings som gør det muligt at skrive på mindre plads.

7. Jeg vil gerne kunne kunne logge ud og evt. logge ind på en anden bruger
- Her er der blevet brugt en SignOut metode, som sender brugeren tilbage til vores SignIn aktivitet. Når denne metode udføres, så vises der også en Toast, som siger "logget ud". 

8. Jeg vil gerne kunne lukke appen og stadig være logget ind, når jeg åbner den igen.
- Hertil er der benyttet firebase, hvortil der gøres brug af firebase's eget system, som gør det muligt for appen at gemme brugerens id.# AndroidAflevering.

9. Jeg vil gerne kunne indtaste en addresse, og derved se parkeringsmuligheder nær den givne addresse.
- Her er der lavet et textfield, hvor brugeren har muligheden for at indtaste en addresse og derved bruges der en explicit intent som gør det muligt at se en lokation.

