package preverifica1;

public class Docente {

    private String cognome;
    private String giornoRicevimento;
    private String oraRicevimento;
    private String note;
    
    public Docente() {
        cognome="";
        giornoRicevimento="";
        oraRicevimento="";
        note="";
        
    }

    public Docente(String cognome, String giornoRicevimento, String oraRicevimento,String note) {
        this.cognome=cognome;
        this.giornoRicevimento=giornoRicevimento;
        this.oraRicevimento=oraRicevimento;
        this.note=note;
    }

    public Docente(Docente docente) {
        this.cognome = docente.cognome;
        this.giornoRicevimento = docente.giornoRicevimento;
        this.oraRicevimento = docente.oraRicevimento;
        this.note = docente.note;
    }

    public String getNome() {
        return cognome;
    }

    public void setNome(String cognome) {
        this.cognome = cognome;
    }

    public String getCognome() {
        return giornoRicevimento;
    }

    public void setCognome(String giornoRicevimento) {
        this.giornoRicevimento = giornoRicevimento;
    }

    public String getMateria() {
        return oraRicevimento;
    }

    public void setMateria(String oraRicevimento) {
        this.oraRicevimento = oraRicevimento;
    }
    
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Docente{" + "cognome=" + cognome + ", giornoRicevimento=" + giornoRicevimento + ", oraRicevimento=" + oraRicevimento + ", note=" + note + '}';
    }


}
