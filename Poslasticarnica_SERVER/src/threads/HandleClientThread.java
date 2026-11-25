/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import controller.Controller;
import model.*;
import model.communication.*;

public class HandleClientThread extends Thread {

    private Socket socket;
    
    private Poslasticar prijavljeniPoslasticar;

    public Poslasticar getPrijavljeniPoslasticar() {
        return prijavljeniPoslasticar;
    }

    public HandleClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            try {
                Request request = (Request) new Receiver(socket).receive();
                Response response = handleRequest(request);
                new Sender(socket).send(response);
            } catch (Exception ex) {
                System.out.println("Klijent se odvezao ili je doslo do greske");
                break;
            }
        }
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(HandleClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServerThread.getClients().remove(this);  
    }

    public Socket getSocket() {
        return socket;
    }

    private Response handleRequest(Request request) {
        switch (request.getOperation()) {
            case LOGIN: return login(request);

            case KREIRAJ_KATEGORIJA_KUPCA: return kreirajKategorijaKupca(request);
            case LISTA_SVI_KATEGORIJA_KUPCA: return vratiListaSviKategorijaKupca(request);
            case LISTA_NEKI_KATEGORIJA_KUPCA: return vratiListaNekiKategorijaKupca(request);
            case OBRISI_KATEGORIJA_KUPCA: return obrisiKategorijaKupca(request);
            case PROMENI_KATEGORIJA_KUPCA: return promeniKategorijaKupca(request);

            case KREIRAJ_POSLASTICA: return kreirajPoslastica(request);
            case LISTA_SVI_POSLASTICA: return vratiListaSviPoslastica(request);
            case LISTA_NEKI_POSLASTICA: return vratiListaNekiPoslastica(request);
            case OBRISI_POSLASTICA: return obrisiPoslastica(request);
            case PROMENI_POSLASTICA: return promeniPoslastica(request);

            case KREIRAJ_POSLASTICAR: return kreirajPoslasticar(request);
            case LISTA_SVI_POSLASTICAR: return vratiListaSviPoslasticar(request);
            case LISTA_NEKI_POSLASTICAR: return vratiListaNekiPoslasticar(request);
            case OBRISI_POSLASTICAR: return obrisiPoslasticar(request);
            case PROMENI_POSLASTICAR: return promeniPoslasticar(request);

            case UBACI_KVALIFIKACIJA: return ubaciKvalifikaciju(request);
            case LISTA_SVI_KVALIFIKACIJA: return vratiListaSviKvalifikaciju(request);
            case LISTA_NEKI_KVALIFIKACIJA: return vratiListaNekiKvalifikaciju(request);
            case OBRISI_KVALIFIKACIJA: return obrisiKvalifikaciju(request);
            case PROMENI_KVALIFIKACIJA: return promeniKvalifikaciju(request);

            case KREIRAJ_KUPAC: return kreirajKupac(request);
            case LISTA_SVI_KUPAC: return vratiListaSviKupac(request);
            case LISTA_NEKI_KUPAC: return vratiListaNekiKupac(request);
            case OBRISI_KUPAC: return obrisiKupac(request);
            case PROMENI_KUPAC: return promeniKupac(request);

            case KREIRAJ_RACUN: return kreirajRacun(request);
            case PRETRAZI_RACUN: return pretraziRacun(request);
            case LISTA_SVI_RACUN: return vratiListaSviRacun(request);
            case LISTA_NEKI_RACUN: return vratiListaNekiRacun(request);
            case PROMENI_RACUN: return promeniRacun(request);

            default: return null;
        }
    }

    private Response login(Request request) {
        Response response = new Response();
        Poslasticar poslasticar = (Poslasticar) request.getArgument();
        try {
            // Provera duplog logovanja 
            for (HandleClientThread client : ServerThread.getClients()) {
                if (client != this && client.getPrijavljeniPoslasticar() != null &&
                    client.getPrijavljeniPoslasticar().getKorisnickoIme().equals(poslasticar.getKorisnickoIme())) {
                    throw new Exception("Poslastičar je već ulogovan na sistemu!");
                }
            }
            poslasticar = Controller.getInstance().prijaviPoslasticar(poslasticar);
            this.prijavljeniPoslasticar = poslasticar;  
            
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(poslasticar);
            
        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response kreirajKategorijaKupca(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().kreirajKategorijaKupca((KategorijaKupca) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaSviKategorijaKupca(Request request) {
        Response response = new Response();
        try {
            ArrayList<KategorijaKupca> lista = Controller.getInstance().vratiListuSviKategorijaKupca((KategorijaKupca) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(lista);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaNekiKategorijaKupca(Request request) {
        Response response = new Response();
        try {
            ArrayList<KategorijaKupca> lista = Controller.getInstance().vratiListuNekiKategorijaKupca((KategorijaKupca) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(lista);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response obrisiKategorijaKupca(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().obrisiKategorijaKupca((KategorijaKupca) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response promeniKategorijaKupca(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().promeniKategorijaKupca((KategorijaKupca) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    // --- POSLASTICA METODE ---
    private Response kreirajPoslastica(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().kreirajPoslastica((Poslastica) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaSviPoslastica(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuSviPoslastica((Poslastica) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaNekiPoslastica(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuNekiPoslastica((Poslastica) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response obrisiPoslastica(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().obrisiPoslastica((Poslastica) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response promeniPoslastica(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().promeniPoslastica((Poslastica) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    // --- POSLASTICAR METODE ---
    private Response kreirajPoslasticar(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().kreirajPoslasticar((Poslasticar) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaSviPoslasticar(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuSviPoslasticar((Poslasticar) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaNekiPoslasticar(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuNekiPoslasticar((Poslasticar) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response obrisiPoslasticar(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().obrisiPoslasticar((Poslasticar) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response promeniPoslasticar(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().promeniPoslasticar((Poslasticar) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    // --- KVALIFIKACIJA METODE ---
    private Response ubaciKvalifikaciju(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().ubaciKvalifikaciju((Kvalifikacija) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaSviKvalifikaciju(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuSviKvalifikaciju((Kvalifikacija) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaNekiKvalifikaciju(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuNekiKvalifikaciju((Kvalifikacija) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response obrisiKvalifikaciju(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().obrisiKvalifikaciju((Kvalifikacija) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response promeniKvalifikaciju(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().promeniKvalifikaciju((Kvalifikacija) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response kreirajKupac(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().kreirajKupac((Kupac) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaSviKupac(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuSviKupac((Kupac) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaNekiKupac(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuNekiKupac((Kupac) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response obrisiKupac(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().obrisiKupac((Kupac) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response promeniKupac(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().promeniKupac((Kupac) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response kreirajRacun(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().kreirajRacun((Racun) request.getArgument());
            System.out.println("Uspesno kreiran racun!");
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaSviRacun(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuSviRacun((Racun) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response vratiListaNekiRacun(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().vratiListuNekiRacun((Racun) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response promeniRacun(Request request) {
        Response response = new Response();
        try {
            Controller.getInstance().promeniRacun((Racun) request.getArgument());
            response.setResponseType(ResponseType.SUCCESS); response.setResult(null);
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }

    private Response pretraziRacun(Request request) {
        Response response = new Response();
        try {
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(Controller.getInstance().pretraziRacun((Racun) request.getArgument()));
        } catch (Exception ex) { response.setResponseType(ResponseType.ERROR); response.setException(ex); }
        return response;
    }
}