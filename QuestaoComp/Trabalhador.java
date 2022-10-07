package QuetaoComp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
public class Trabalhador {
    private String nome;
    private WorkLevel level;
    private Double salarioBase;

    private Departamento departamento;
    private List<HoraDeContrato> contratos = new ArrayList<>();

    public Trabalhador() {
    }

    public Trabalhador(String nome, WorkLevel level, Double salarioBase, Departamento departamento) {
        this.nome = nome;
        this.level = level;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public WorkLevel getLevel() {
        return level;
    }

    public void setLevel(WorkLevel level) {
        this.level = level;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<HoraDeContrato> getContratos() {
        return contratos;
    }

    public void addContract(HoraDeContrato contrato){
        contratos.add(contrato);
    }

    public void removeContract(HoraDeContrato contrato){
        contratos.remove(contrato);
    }

    public double income(int year,int month){
        double sum = salarioBase;
        Calendar cal = Calendar.getInstance();
        for (HoraDeContrato x : contratos){
            cal.setTime(x.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);
            if(year == c_year && month == c_month){
                sum += x.valorTotal();
            }
        }
        return sum;
    }


}
