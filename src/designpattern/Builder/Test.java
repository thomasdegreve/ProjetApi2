package designpattern.Builder;

public class Test {

    public static void main(String[] args) {

        Employe employe1 = new Employe.Builder("001", "Dupont", "Jean")
                .tel("0123456789")
                .mail("jean.dupont@mail.com")
                .build();

        Employe employe2 = new Employe.Builder("002", "Martin", "Sophie")
                .tel("9876543210")
                .mail("sophie.martin@mail.com")
                .build();

        System.out.println(employe1);
        System.out.println(employe2);
    }
}
