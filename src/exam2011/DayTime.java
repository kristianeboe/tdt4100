package exam2011;

/**
 * Created by Kristian on 17/05/15.
 */
public class DayTime {

    public final int hours, minutes;

    public DayTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }


    public String toString() {
        return hours + ":" + minutes;
    }
}

/*a) Hva betyr final-nøkkelordet slik det er brukt her? På hva slags måte(r) ivaretar denne klassen formålet med innkapsling og på hva slags måte(r) ikke?
        Final gjør at feltet ikke kan endres etter at det er initalisert. Det ivaretar inkapsling med tanke på at man ikke kan endre feltet til en
        ugyldig verdi senere, men det gjør også at man må opprette et helt nytt objekt for å få nye verdier. Det er viktig å sikre at feltene blir satt til
        gyldige verdier i konstruktøren, noe det ikke blir gjort her.
  b) Beskriv den generelle teknikken og navnekonvensjonen(e) for å representere og kapsle inn en enkel verdi, f.eks. tall eller objektreferanse,
     som skal kunne endres etter at objektet er opprettet.
        Her er det vanlig å bruke getters and setters. Da sikrer du at metoder som trenger veriden kan få den ved å kalle en getter, og du kan også
        endre den senere i tid. Det genial med en setter er at du kan validere både argumentet som kommer inn og hvilken state objektet kommer i når
        den nye verdien er satt. Hvis en av de er ulovlige kan man kaste en exception.
  c) I hva slags metode(r) brukes unntak ifm. innkapsling, og hvordan? Vis gjerne med et eksempel!
        Gjerne i settere som sagt. Her er et eksempel

        private void setHours(int hours){
            if(hours < 0 ||hours >23){
                throw new IllegalArgumentException();
                }
            this.hours = hours;
            }


  d) Mange klasser inneholder et List<X>-felt og definerer addX, removeX og andre metoder som tilsvarer og bruker metodene i List-grensesnittet.
     En alternativ løsning kunne vært å arve fra en List<X>-implementasjon, f.eks. ArrayList<X>. Hvorfor brukes aldri denne løsningen i praksis?
        Fordi du kan ikke bestemme hva du arver og ikke arver, man får alt eller ingen ting. Hvis vi hadde arvet fra List<X> hadde vi fått addX osv, men
        vi hadde også fått veldig mye mer vi ikke trengte. I tillegg hadde det gjort at vi ikke kunne arvet fra andre klasser.
*/