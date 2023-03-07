package adopoo;

import java.security.MessageDigest;
import java.text.Normalizer;

public class estado {
    private String id;
    private String name;
    private Double pib;

    public estado(String id, String name) {
        this.id = id;
        this.name = name;
        this.pib = 0.0;
    }

    public estado(String id, String name, Double pib) {
        this.id = id;
        this.name = name;
        this.pib = pib;
    }

    public String getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Double getPib() {
        return this.pib;
    }

    public void setPib(Double pib) {
        this.pib = pib;
    }

    public static String GenerateID(String name) throws Exception {
        String normalized = Normalizer.normalize(name, Normalizer.Form.NFD).replaceAll("\\p{M}", "")
                .replaceAll("[^\\p{Alpha}]+", "").toLowerCase();

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(normalized.getBytes());
        byte[] hash = md.digest();

        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }
}