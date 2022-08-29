# Treinkaartjes kopen
Op elk station in Nederland staat tegenwoordig een automaat waar je treinkaartjes mee kan kopen. Met deze treinkaartjes
kan je vervolgens in de trein stappen en naar andere steden reizen. In deze opdracht ga je zelf een vereenvoudigde automaat 
programmeren.

Wij richten ons daarbij op de volgende functionaliteit:
1. Het toevoegen van een bestemming in de automaat.
2. Het kunnen opvragen van de kosten om naar een bestemming te komen.
3. Het kopen van een kaartje.
4. Het tonen van alle uitgegeven kaartjes.

(Merk op opties 1 en 4 natuurlijk eigenlijk "admin" functies zijn, maar voor het gemak van de opdracht bouw je deze gelijk
ook om te controleren of je oplossing goed werkt.)

Wij hebben nagenoeg alle gebruikersinteractie reeds geimplementeerd in de `Application` klasse. Hier zijn `//TODO` blokken
opgenomen op de locaties waar jij nog code moet toevoegen. Ook hebben wij de publieke interface van de `TicketMachine` 
reeds gegeven. Het is niet nodig dat je onze opzet aanpast, maar je mag uiteraard wel op alle plekken code toevoegen
waar jij dit nodig acht. Uiteraard maak je voor deze opdracht gebruik van de geleerde technieken binnen de module.

Om de opdracht beter uit te leggen geven we per onderdeel een korte beschrijving en een voorbeeld.

## Menuoptie 1 - Het toevoegen van een bestemming
Elke automaat heeft een intern overzicht van bestemmingen waar je een kaartje voor kan kopen. Je kan bestemmingen toevoegen
door de `registerDestination(String destination, double price)` methode aan te roepen. Van elke bestemming wordt
uitsluitend de naam en de prijs (om er te komen) opgeslagen. Zodra een bestemming eenmaal in het systeem opgeslagen is
kan deze niet meer gewijzigd of verwijderd worden. (Als je hier dus een fout maakt moet je het programma stoppen en 
opnieuw opstarten.)

Bij het toevoegen van bestemmingen moeten twee controles worden uitgevoerd:
- De naam van de bestemming mag niet al reeds voorkomen in de machine.
- De prijs om naar de bestemming te komen mag nooit € 0,00 zijn (of lager).

Je dient deze controles te implementeren met behulp van je eigen gedefinieerde exception(s).

In de uitvoer ziet dit er als volgt uit:
```text
Please enter a destination: Apeldoorn
Please enter a price for a ticket to Apeldoorn: 3.8

Destination Apeldoorn added!
```
(Let op dat je de laatste zin nog moet toevoegen. Hoe de foutmelding eruitziet, mag je zelf bepalen.)

## Menuoptie 2 - Het opvragen van de kosten om naar een bestemming te komen
De ticketmachine kan voor alle bekende bestemmingen opleveren wat de kosten zijn om vanaf de locatie waar de automaat staat
naar de bestemming te komen. Je kan deze optie het beste zien als het opvragen van de data die je bij menuoptie 1 in de 
automaat hebt gezet.

Om de kosten op te vragen om naar een bestemming te komen dient een bestemming ingetypt te worden en als argument aan
de methode `getPrice(String destination)` meegegeven te worden. De automaat zal vervolgens controleren of deze bestemming 
bestaat en zo ja, de prijs opleveren. In het geval dat een niet bestaande bestemming moet een exception gegooid worden.

In de uitvoer ziet dit er als volgt uit:
```text
Please enter an option: Apeldoorn
A ticket to Apeldoorn would cost €3.8
```
(Let op dat je de laatste zin nog moet toevoegen. Hoe de foutmelding eruitziet, mag je zelf bepalen.)

## Menuoptie 3 - Het kopen van een kaartje
Het kopen van een kaartje werkt op een vergelijkbare manier als optie 2: Je moet een bestemming invoeren en als deze niet
bestaat zal er een exception gegooid moeten worden.

Als je een bestaande bestemming ingeeft zal het systeem een kaartje aanmaken en deze binnen de automaat bewaren. (We 
slaan dus alle uitgegeven kaartjes op in het programma.) Elk kaartje dat gemaakt wordt bevat de volgende informatie: de 
locatie van vertrek (waar de automaat staat), de plek van bestemming en de prijs van de rit. Daarnaast krijgt elk kaartje 
een _uniek identificatienummer_. Dit nummer wordt opgeleverd door een aanroep naar de `buyTicket(String destination)` 
methode. Dit nummer is voldoende om in de trein te stappen, we printen dus geen fysieke kaartjes.

```text
Please enter an option: Apeldoorn
Ticket booked with id: 1
```
(Let op dat je de laatste zin nog moet toevoegen. Hoe de foutmelding eruitziet, mag je zelf bepalen.)

## Menuoptie 4 - Het tonen van alle uitgegeven kaartjes
Tenslotte moet het apparaat een overzicht kunnen tonen van alle verkochte kaartjes. Hiervoor dien je de `toString` methode 
te implementeren voor de klasse `TicketMachine`. Na het tonen van alle verkochte kaartjes moet het apparaat ook de omzet 
kunnen tonen van de verkochte kaartjes. Dit kan berekend worden door de verkoopprijs van alle uitgegeven tickets
bij elkaar op te tellen.

```text
Tickets issued by this machine: 
	Ticket 1: Deventer --> Apeldoorn [€3.8]
	Ticket 2: Deventer --> Zwolle [€6.8]
	Ticket 3: Deventer --> Enschede [€12.2]

Total sales: € 22.79
```