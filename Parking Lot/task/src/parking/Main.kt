package parking
import java.util.*
fun main() {
    val scanner = Scanner(System.`in`)
    val parking = Parking()
    do {
        val input: Array<String> = scanner.nextLine().split(" ").toTypedArray()
        when (input[0]) {
            "create" -> {
                parking.spots = createParking(input[1].toInt())
                parking.created = true
            }
            "park" -> parking.spots = park(parking.spots, input, parking.created)
            "leave" -> parking.spots = leave(parking.spots, input, parking.created)
            "status" -> status(parking.spots, parking.created)
            "reg_by_color" -> regByColor(parking.spots, input, parking.created)
            "spot_by_color" -> spotByColor(parking.spots, input, parking.created)
            "spot_by_reg" -> spotByReg(parking.spots, input, parking.created)
        }
    } while (input[0] != "exit")
}
fun createParking(numOfSpots: Int): Array<ParkingSpot> {
    val parking = Array(numOfSpots) {ParkingSpot()}
    for (i in 0..parking.lastIndex) parking[i].spot = i + 1
    println("Created a parking lot with ${parking.size} spots.")
    return parking
}
fun park(parking: Array<ParkingSpot>, input: Array<String>, parkingCreated: Boolean): Array<ParkingSpot> {
    if (parkingCreated) for (i in 0..parking.lastIndex) {
        if (parking[i].numOfCar == "") {
            parking[i].numOfCar = input[1]
            parking[i].color = input[2]
            println("${parking[i].color} car parked in spot ${parking[i].spot}.")
            break
        }
        if (i == parking.lastIndex) println("Sorry, the parking lot is full.")
    } else println("Sorry, a parking lot has not been created.")
    return parking
}
fun leave(parking: Array<ParkingSpot>, input: Array<String>, parkingCreated: Boolean): Array<ParkingSpot> {
    if (parkingCreated) {
        if (parking[input[1].toInt() - 1].color != "") {
            parking[input[1].toInt() - 1].numOfCar = ""
            parking[input[1].toInt() - 1].color = ""
            println("Spot ${input[1]} is free.")
        } else println("There is no car in spot ${input[1]}.")
    } else println("Sorry, a parking lot has not been created.")
    return parking
}
fun status(parking: Array<ParkingSpot>, parkingCreated: Boolean) {
    if (parkingCreated) {
        var emptyParking = true
        for (i in 0..parking.lastIndex) if (parking[i].numOfCar != "") {
            emptyParking = false
            println("${parking[i].spot} ${parking[i].numOfCar} ${parking[i].color}")
        }
        if (emptyParking) println("Parking lot is empty.")
    } else println("Sorry, a parking lot has not been created.")
}
fun regByColor(parking: Array<ParkingSpot>, input: Array<String>, parkingCreated: Boolean) {
    if (parkingCreated) {
        var hasColor = true
        var regByColor = ""
        for (i in 0..parking.lastIndex) if (parking[i].color.toLowerCase() == input[1].toLowerCase()) {
            hasColor = false
            regByColor += "${parking[i].numOfCar}, "
        }
        if (hasColor) println("No cars with color ${input[1]} were found.")
        else {
            println(regByColor.dropLast(2))
        }
    } else println("Sorry, a parking lot has not been created.")
}
fun spotByColor(parking: Array<ParkingSpot>, input: Array<String>, parkingCreated: Boolean) {
    if (parkingCreated) {
        var hasColor = true
        var spotByColor = ""
        for (i in 0..parking.lastIndex) if (parking[i].color.toLowerCase() == input[1].toLowerCase()) {
            hasColor = false
            spotByColor += "${parking[i].spot}, "
        }
        if (hasColor) println("No cars with color ${input[1]} were found.")
        else {
            println(spotByColor.dropLast(2))
        }
    } else println("Sorry, a parking lot has not been created.")
}
fun spotByReg(parking: Array<ParkingSpot>, input: Array<String>, parkingCreated: Boolean) {
    if (parkingCreated) {
        var hasColor = true
        var spotByReg = ""
        for (i in 0..parking.lastIndex) if (parking[i].numOfCar == input[1]) {
            hasColor = false
            spotByReg += "${parking[i].spot}, "
        }
        if (hasColor) println("No cars with registration number ${input[1]} were found.")
        else {
            println(spotByReg.dropLast(2))
        }
    } else println("Sorry, a parking lot has not been created.")
}
class Parking {
    var spots = emptyArray<ParkingSpot>()
    var created = false
}
class ParkingSpot {
    var spot = 0
    var numOfCar = ""
    var color = ""
}