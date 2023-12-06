package ZooFantastique.models.enclos;

public enum Proprete {

    MAUVAIS, CORRECT, BON;

    public Proprete getPrevious(){
        if(this != Proprete.MAUVAIS){
            return Proprete.values()[this.ordinal() - 1];
        }return Proprete.MAUVAIS;
    }
}
