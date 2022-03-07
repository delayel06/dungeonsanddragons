public class Salle {
    // Monstre unMonstre ;
    int numSalle;
    int autour [] = new int [4];
    public Salle (int num, int haut, int droite, int bas, int gauche){
        numSalle= num;
        autour[0]=haut;
        autour[1]= droite;
        autour[2]= bas;
        autour[3]=gauche;
    }
    public String toString(){
        String s = "Salle n° "+ numSalle;
        return(s);
    }
}
