package communication;

import java.net.Socket;
import model.communication.*;

public class Communication {
    private static Communication instance;
    private Socket socket;

    private Communication() {
    }

    public static Communication getInstance() {
        if (instance == null) instance = new Communication();
        return instance;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    private Response sendAndReceive(Request request) throws Exception {
        new Sender(socket).send(request);
        return (Response) new Receiver(socket).receive();
    }


    public Response prijaviPoslasticara(Request request) throws Exception {
        System.out.println("Zahtev za prijavom na sistem je poslat...");
        return sendAndReceive(request);
    }

    public Response kreirajKategorijaKupca(Request request) throws Exception {
        System.out.println("Zahtev za kreiranje kategorije kupca poslat...");
        return sendAndReceive(request);
    }

    public Response vratiListuSviKategorijaKupca(Request request) throws Exception {
        System.out.println("Zahtev za svim kategorijama kupca poslat...");
        return sendAndReceive(request);
    }

    public Response obrisiKategorijaKupca(Request request) throws Exception {
        System.out.println("Zahtev za brisanjem kategorije kupca poslat...");
        return sendAndReceive(request);
    }

    public Response promeniKategorijaKupca(Request request) throws Exception {
        System.out.println("Zahtev za promenom kategorije kupca poslat...");
        return sendAndReceive(request);
    }


    public Response kreirajPoslastica(Request request) throws Exception {
        System.out.println("Zahtev za kreiranje poslastice poslat...");
        return sendAndReceive(request);
    }

    public Response vratiListuSviPoslastica(Request request) throws Exception {
        System.out.println("Zahtev za svim poslasticama poslat...");
        return sendAndReceive(request);
    }

    public Response obrisiPoslastica(Request request) throws Exception {
        System.out.println("Zahtev za brisanjem poslastice poslat...");
        return sendAndReceive(request);
    }

    public Response promeniPoslastica(Request request) throws Exception {
        System.out.println("Zahtev za promenom poslastice poslat...");
        return sendAndReceive(request);
    }


    public Response kreirajPoslasticar(Request request) throws Exception {
        System.out.println("Zahtev za kreiranje poslastičara poslat...");
        return sendAndReceive(request);
    }

    public Response vratiListuSviPoslasticar(Request request) throws Exception {
        System.out.println("Zahtev za svim poslastičarima poslat...");
        return sendAndReceive(request);
    }

    public Response obrisiPoslasticar(Request request) throws Exception {
        System.out.println("Zahtev za brisanjem poslastičara poslat...");
        return sendAndReceive(request);
    }

    public Response promeniPoslasticar(Request request) throws Exception {
        System.out.println("Zahtev za promenom poslastičara poslat...");
        return sendAndReceive(request);
    }


    public Response ubaciKvalifikcija(Request request) throws Exception {
        System.out.println("Zahtev za ubacivanje kvalifikacije poslat...");
        return sendAndReceive(request);
    }

    public Response vratiListuSviKvalifikcija(Request request) throws Exception {
        System.out.println("Zahtev za svim kvalifikcijama poslat...");
        return sendAndReceive(request);
    }

    public Response obrisiKvalifikcija(Request request) throws Exception {
        System.out.println("Zahtev za brisanjem kvalifikcije poslat...");
        return sendAndReceive(request);
    }

    public Response promeniKvalifikcija(Request request) throws Exception {
        System.out.println("Zahtev za promenom kvalifikcije poslat...");
        return sendAndReceive(request);
    }


    public Response kreirajKupac(Request request) throws Exception {
        System.out.println("Zahtev za kreiranje kupca poslat...");
        return sendAndReceive(request);
    }

    public Response vratiListuSviKupac(Request request) throws Exception {
        System.out.println("Zahtev za svim kupcima poslat...");
        return sendAndReceive(request);
    }

    public Response obrisiKupac(Request request) throws Exception {
        System.out.println("Zahtev za brisanjem kupca poslat...");
        return sendAndReceive(request);
    }

    public Response promeniKupac(Request request) throws Exception {
        System.out.println("Zahtev za promenom kupca poslat...");
        return sendAndReceive(request);
    }


    public Response kreirajRacun(Request request) throws Exception {
        System.out.println("Zahtev za kreiranje računa poslat...");
        return sendAndReceive(request);
    }

    public Response promeniRacun(Request request) throws Exception {
        System.out.println("Zahtev za promenom računa poslat...");
        return sendAndReceive(request);
    }

    public Response vratiListuSviRacun(Request request) throws Exception {
        System.out.println("Zahtev za svim računima poslat...");
        return sendAndReceive(request);
    }

    public Response pretraziRacun(Request request) throws Exception {
        System.out.println("Zahtev za pretragu racuna poslat...");
        return sendAndReceive(request);
    }


}
