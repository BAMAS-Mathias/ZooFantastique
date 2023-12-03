package ZooFantastique.models.creatures.vivipares.lycanthrope;

public class CoupleAlpha {

    private Lycanthrope maleAlpha;
    private Lycanthrope femelleAlpha;

    public CoupleAlpha(Lycanthrope maleAlpha, Lycanthrope femelleAlpha) {
        this.maleAlpha = maleAlpha;
        this.femelleAlpha = femelleAlpha;
    }

    public Lycanthrope getMaleAlpha() {
        return maleAlpha;
    }

    public void setMaleAlpha(Lycanthrope maleAlpha) {
        this.maleAlpha = maleAlpha;
    }

    public Lycanthrope getFemelleAlpha() {
        return femelleAlpha;
    }

    public void setFemelleAlpha(Lycanthrope femelleAlpha) {
        this.femelleAlpha = femelleAlpha;
    }
}
