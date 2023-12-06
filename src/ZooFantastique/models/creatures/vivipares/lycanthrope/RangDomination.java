package ZooFantastique.models.creatures.vivipares.lycanthrope;

public enum RangDomination {
    α,β,γ,δ,ε,ζ,η,θ,ι,κ,λ,μ,ν,ξ,ο,π,ρ,σ,τ,υ,φ,χ,ψ,ω;

    public RangDomination previousRang(){
        if(this != RangDomination.ω){
            return RangDomination.values()[this.ordinal()+1];
        }else{
            return RangDomination.ω;
        }
    }

    public RangDomination nextRang(){
        if(this != RangDomination.α){
            return RangDomination.values()[this.ordinal()-1];
        }else{
            return RangDomination.α;
        }
    }
}
