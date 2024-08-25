package Models;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    private int idCompra;
    private boolean hasLeite;
    private boolean hasCafe;
    private boolean hasCerveja;
    private boolean hasPao;
    private boolean hasManteiga;
    private boolean hasArroz;
    private boolean hasFeijao;

    public Compra() {}


    private Compra(Builder builder){
        this.idCompra = builder.idCompra;
        this.hasLeite = builder.hasLeite;
        this.hasCafe = builder.hasCafe;
        this.hasCerveja = builder.hasCerveja;
        this.hasPao = builder.hasPao;
        this.hasManteiga = builder.hasManteiga;
        this.hasArroz = builder.hasArroz;
        this.hasFeijao = builder.hasFeijao;

    }

    public List<String> toList(){
        List<String> list = new ArrayList<>();
        if(hasLeite) list.add("Leite");
        if(hasCafe) list.add("Cafe");
        if(hasCerveja) list.add("Cerveja");
        if(hasPao) list.add("Pao");
        if(hasManteiga) list.add("Manteiga");
        if(hasArroz) list.add("Arroz");
        if(hasFeijao) list.add("Feijao");
        return list;
    }

    public static class Builder{
        private int idCompra;
        private boolean hasLeite = false;
        private boolean hasCafe = false;
        private boolean hasCerveja = false;
        private boolean hasPao = false;
        private boolean hasManteiga = false;
        private boolean hasArroz = false;
        private boolean hasFeijao = false;

        public Builder idCompra(int idCompra){
            this.idCompra = idCompra;
            return this;
        }

        public Builder hasLeite(){
            this.hasLeite = true;
            return this;
        }

        public Builder hasCafe(){
            this.hasCafe = true;
            return this;
        }

        public Builder hasCerveja(){
            this.hasCerveja = true;
            return this;
        }

        public Builder hasPao(){
            this.hasPao = true;
            return this;
        }

        public Builder hasManteiga(){
            this.hasManteiga = true;
            return this;
        }

        public Builder hasArroz(){
            this.hasArroz = true;
            return this;
        }

        public Builder hasFeijao(){
            this.hasFeijao = true;
            return this;
        }

        public Compra build(){
            return new Compra(this);
        }
    }


}
