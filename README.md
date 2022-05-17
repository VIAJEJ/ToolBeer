# AndroidAflevering

#### Kort beskrivelse af applikationen: ####
En parkerings applikation, hvor man kan oprette sig som bruger, sen en liste med parkeringsmuligheder, se timeprisen for parkeringsmuligheden, register sin parkering. Derudover skal det være muligt for brugeren at se en historik over sine parkeringer og finde information om udbyderen.

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

#### Test af applikation: ####

Gennem hele udarbejdelsen af appen, har der været systematiske tests med 15 minutters intervaller, som skulle gøre det lettere for os at fejlfinde eventuelle problemer samt teste applikationens funktionalitet. Ydermere hjalp de systematiske test til at optimere kvaliteten af appen. 

#### Gennemgang af requirements: ####
    
1. Jeg vil gerne kunne oprette og logge ind som bruger
- Her er der blevet benyttet firebase, hvortil der bliver gjort brug af firebase's egen login system, hvor der bruges networking så brugeren har muligheden for at logge ind med sin personlige Google-konto.   
  
2. Jeg vil gerne kunne se en liste med SmartParks samarbejdspartnere

4. Jeg vil gerne kunne ændre sprog
- 

6. Jeg vil gerne kunne se parkeringsmuligheder tæt på min lokation

8. Jeg vil gerne kunne se en liste med min historik over parkeringer 

10. Jeg vil gerne kunne finde information om SmartPark
- For at kunne se information om Smartpark er der gjort brug af strings som gør det muligt at skrive på mindre plads.

10. Jeg vil gerne kunne kunne logge ud og evt. logge ind på en anden bruger


12. Jeg vil gerne kunne lukke appen og stadig være logget ind, når jeg åbner den igen.
- Hertil er der benyttet firebase, hvortil der gøres brug af firebase's eget system, som gør det muligt for appen at gemme brugerens id
