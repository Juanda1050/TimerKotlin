import java.text.DecimalFormat
import kotlin.system.exitProcess

fun main() {
    inputValues()
}

fun inputValues() {
    print("Segundos: ")
    val seconds: Int = readLine()!!.toInt()
    print("Minutos: ")
    val minutes: Int = readLine()!!.toInt()
    print("Horas: ")
    val hours: Int = readLine()!!.toInt()
    timerCountdown(seconds, minutes, hours)
}

fun timerCountdown(seconds: Int, minutes: Int, hours: Int) {
    var m = 0
    var h = 0
    var s = 0

    val df = DecimalFormat("00")
    var ddSecond: String
    var ddMinute: String
    var ddHour: String

    if(seconds >= 60 || minutes >= 60 || hours >= 24){
        println("Verifique los datos ingresados. Solo se admite 24 horas, 59 minutos y 59 segundos")
        print("\r")
        inputValues()
    }
    else if(seconds < 0 && minutes < 0 && hours < 0){
        println("Verifique los datos ingresados. Solo se admite 24 horas, 59 minutos y 59 segundos")
        print("\r")
        inputValues()
    }
    else {
        while(s < 60){
            ddSecond = df.format(s)
            ddMinute = df.format(m)
            ddHour = df.format(h)
            println("$ddHour:$ddMinute:$ddSecond")
            Thread.sleep(10)
            if (s == 59){
                s = -1
                m++
            }
            if (m == 60){
                m = 0
                h++
            }
            if (h == 24){
                exitProcess(0)
            }
            else if (s == seconds && m == minutes && h == hours){
                break

            }
            s++
        }
    }
}