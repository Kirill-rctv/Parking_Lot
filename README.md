# ParkinLot

A parking lot management program that keeps track of vacant spots and parked cars, can search for cars by color, number.

## How to run
```
$ java -jar main.jar
```
## Example
```
> create 4 
Created a parking lot with 4 spots. 
> park KA-01-HH-3672 White
White car parked in spot 2.
> reg_by_color WHITE
KA-01-HH-9999
> status
1 KA-01-HH-9999 White
> leave 2
Spot 2 is free.
> exit
```
