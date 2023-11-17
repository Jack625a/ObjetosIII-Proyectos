//Sistema de cajero automatico
public class Cuenta {
    private String usuario;
    private String contrasena;
    private double saldo;

    //CONTRUCTOR
    public Cuenta(String usuario, String contrasena, double saldo) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.saldo = saldo;
    }

    //Metodos del cajero
    //Verificacion del usuario:
    public boolean verificar(String usuario, String contrasena) {
        return this.usuario.equals(usuario) && this.contrasena.equals(contrasena);
    }

    //metodo ver saldo
    public double verSaldo() {
        return saldo;
    }

    //metodo de Depositar
    public void depositar(double monto) {
        //saldo=saldo+monto;
        saldo += monto;
    }

    //Metodo de Retirar
    public boolean retirar(double monto) {
        if (saldo >= monto) {
            //saldo=saldo-monto;
            saldo -= monto;
            return true;
        }
        return false;
    }

}
