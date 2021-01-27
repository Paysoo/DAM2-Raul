package M3.UF5.NF4.Activitat16.Interficies.Clases;

import M3.UF5.NF4.Activitat16.Interficies.Interficies.Valida;

public class Email implements Comparable, Valida {

    private String email; // (---@---.---)

    public Email(String email) {
        this.email = email;
    }

    @Override
    public boolean check() {
        String estructuraEmail = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        return this.email.matches(estructuraEmail);
    }

    @Override
    public int compareTo(Object o) {

        int devuelve;
        Email otro = (Email) o;

        if (this.email.equals(otro.email)){
            devuelve = 0;
        } else {
            devuelve = this.email.compareTo(otro.email);
        }

        return devuelve;
    }

    @Override
    public String toString() {
        return "Email: " + email;
    }
}
