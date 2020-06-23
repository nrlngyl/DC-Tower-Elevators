# DC-Tower-Elevators
DC Tower Elevator Challenge

The task:
The DC Tower in Vienna has 7 elevators, and 55 floors.
There are two options for calling an elevator:
It is either when entering the building (through floor #0) to go to an office,
or when leaving an office to exit the building (again, through floor #0).
At arrival, the elevator takes the user to the office automatically, based on the entrance data,
during leaving, a button can be pushed to order an elevator.
The input for the system are the current floor, the destination floor and the direction of the travel.

My solution:
I have modelled the problem in a rather easy way.
In my uploaded solution, I did not consider the time,
and the elevators cannot stop between the starting and the destination floors.
I did not use the direction as a possible input for the system either.

What I have build is a webapplication-like project.
To request an elevator a PUT method can be used with: "/transport/{startingFloor}/{destinationFloor}". ((0 <= startingFloor <= 55) && (0 <= destinationFloor <= 55)).
To get the state of all elevators a GET method can be used with: "/getState".
My system calculates that always the closest elevator is called to the starting destination,
and validates the given floor numbers.

Further ideas for improvements:
As a next step I think it would make sense to implement the passing time, and within the same feature, to give the possibility for the elevators to stop between the starting and the destination floor. Then I would go in the suggested direction of java threads, or since I was using Spring, I could also add a @Scheduled annotation to the getState method, that gives a regular update on all the elevators, and further calculations and commands would be based on that. So if an elevator would pass a floor, where an other elevator is called, and would go in the same direction, it could pick up the additional user.

