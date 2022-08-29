# Buying train tickets
At each station in the Netherlands there is a machine with which you can buy train tickets. With these train tickets you 
can then board the train and travel to other cities. In this assignment you are going to program a simplified ticket 
machine yourself.

We will focus on the following functionality:
1. Adding a destination to the ticket machine.
2. Being able to retrieve the cost to get to a destination.
3. Buying a ticket.
4. Displaying all tickets issued.

(Note options 1 and 4 are actually "admin" functions, but for this assignment you will also implement these functions
to check that your solution works properly).

We have already implemented almost all user interaction in the `Application` class. Here `//TODO` blocks are
included at the locations where you still need to add code. We have also provided the public interface of the 
`TicketMachine` class. There should be no reason for you to change the provided code, but you may of course add code 
where you deem it necessary. Naturally, you will use the techniques learned in the module for this assignment.

To better explain the assignment we will give a short description and example for each part.

## Menu option 1 - Adding a destination
Each vending machine has an internal list of destinations for which you can buy a ticket. You can add destinations
by calling the `registerDestination(String destination, double price)` method. Of each destination only the name and 
the price (to get to that location) are stored. Once a destination is stored in the system it cannot be changed or 
deleted. (Thus, if you make a mistake here, you must restart the program.)

When adding destinations, two checks must be made:
- The name of the destination must not already exist in the machine.
- The price to get to the destination must never be € 0.00 or less.

You need to implement these checks using your own defined exception(s).

In the output, this looks like this:
```text
Please enter a destination: Apeldoorn
Please enter a price for a ticket to Apeldoorn: 3.8

Destination Apeldoorn added!
```
(Note that you have to add the last sentence. What the error message should look like is up to you).

## Menu option 2 - Requesting the cost to get to a destination
The ticket machine can provide for any known destination what the cost is to get from the location where the machine is
to the destination. It is best to think of this option as retrieving the data that you put into the machine using menu 
option 1.

To retrieve the cost to get to a destination, a destination has to be specified by the user and given as an argument to 
the `getPrice(String destination)` method. The machine will then check whether this destination is known and if so, 
returns the price. In case of a non-existent destination an exception must be thrown.

In the output this looks like this:
```text
Please enter an option: Apeldoorn
A ticket to Apeldoorn would cost €3.8
```
(Note that you have to add the last sentence. What the error message looks like is up to you).

## Menu option 3 - Buying a ticket
Buying a ticket works similarly as option 2: You have to enter a destination and if it does not exist an exception 
needs to be thrown.

If you enter an existing destination the system will create a ticket and store it within the machine. (So we store all 
issued tickets in the program.) Each ticket that is created contains the following information: the location of 
departure (where the vending machine is located), the location of destination, and the price of the trip. In addition, 
each ticket receives a _unique identification number_. This number is returned by the `buyTicket(String destination)` 
method. This number is sufficient to board the train, so we are bothered with printing physical tickets.

```text
Please enter an option: Apeldoorn
Ticket booked with id: 1
```
(Note that you have to add the last sentence. What the error message looks like is up to you).

## Menu option 4 - Displaying all issued tickets
Finally, the device must be able to show an overview of all tickets sold. For this you need to implement the `toString` 
method of the class `TicketMachine`. After showing all tickets sold, the machine must also be able to show the total sales
of the tickets sold. This can be easily calculated by adding the sales price of all issued tickets together.

```text
Tickets issued by this machine: 
	Ticket 1: Deventer --> Apeldoorn [€3.8]
	Ticket 2: Deventer --> Zwolle [€6.8].
	Ticket 3: Deventer --> Enschede [€12.2]

Total sales: € 22.79
```