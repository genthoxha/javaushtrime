package afate.allinone.libri;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bibloteka {

    private String emri;
    private ArrayList<Libri> libra;

    public Bibloteka(String emri) throws LibriException {
        if (emri == null || emri.trim().isEmpty()) {
            throw new LibriException("Emri nuk duhet te jete null");
        }
        this.emri = emri;
        libra = new ArrayList<>();
    }

    public void shtoLibrin(Libri libri) throws LibriException {
        if (libri == null) {
            throw new LibriException("Libri eshte i pa inicializuar");
        }
        if (libra.contains(libri)) {
            throw new LibriException("Libri gjendet ne varg");
        }
        libra.add(libri);
    }

    public Enumeration<Libri> titulliEnumeration(String t) throws LibriException {
        if (t == null || t.trim().isEmpty()) {
            throw new LibriException("Titulli i librit nuk mund te filloj si i zbrazet!");
        }
        if (libra.isEmpty()) {
            throw new LibriException("Nuk ka asnje liber ne bibloteke!");
        }
        return new Enumeration<Libri>() {

            private int index = 0;


            @Override
            public boolean hasMoreElements() {
                return index < libra.size();
            }

            @Override
            public Libri nextElement() {
                if (index < libra.size()) {
                    Libri l = libra.get(index++);
                    if (l.getTitulli().startsWith(t)) {
                        return l;
                    }
                    if (hasMoreElements()) {
                        return nextElement();
                    }
                }
                throw new NoSuchElementException();
            }
        };
    }

    public Iterator<Libri> minVitiIterator(int v) throws LibriException {

        if (v <= 0) {
            throw new LibriException("Viti nuk duhet te jete negativ");
        }
        if (libra.isEmpty()) {
            throw new LibriException("Nuk ka asnje liber ne bibloteke!");
        }

        class MinVitiIterator implements Iterator<Libri> {
            private int index = 0;

            public boolean hasNext() {
                return index < libra.size();
            }
            public Libri next() {
                if (index < libra.size()) {
                    Libri l = libra.get(index++);
                    if (l.getVitiPublikimit() < v) {
                        return l;
                    }
                    if (hasNext()) {
                        return next();
                    }
                }
                return null;
//                throw new NoSuchElementException();
            }
        }
        return new MinVitiIterator();

    }

}
