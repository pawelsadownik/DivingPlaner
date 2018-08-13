package pl.divingplanner.model;

public class Risk {

    private String etapPrac;
    private String rodzajZagrozenia;
    private String zagrozonaOsoba;
    private String wstepneRyzyko;
    private String przeciwdzialanie;
    private String koncoweRyzyko;


    public String getEtapPrac() {
        return etapPrac;
    }

    public void setEtapPrac(String etapPrac) {
        this.etapPrac = etapPrac;
    }

    public String getRodzajZagrozenia() {
        return rodzajZagrozenia;
    }

    public void setRodzajZagrozenia(String rodzajZagrozenia) {
        this.rodzajZagrozenia = rodzajZagrozenia;
    }

    public String getZagrozonaOsoba() {
        return zagrozonaOsoba;
    }

    public void setZagrozonaOsoba(String zagrozonaOsoba) {
        this.zagrozonaOsoba = zagrozonaOsoba;
    }

    public String getWstepneRyzyko() {
        return wstepneRyzyko;
    }

    public void setWstepneRyzyko(String wstepneRyzyko) {
        this.wstepneRyzyko = wstepneRyzyko;
    }

    public String getPrzeciwdzialanie() {
        return przeciwdzialanie;
    }

    public void setPrzeciwdzialanie(String przeciwdzialanie) {
        this.przeciwdzialanie = przeciwdzialanie;
    }

    public String getKoncoweRyzyko() {
        return koncoweRyzyko;
    }

    public void setKoncoweRyzyko(String koncoweRyzyko) {
        this.koncoweRyzyko = koncoweRyzyko;
    }
}
