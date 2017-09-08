package com.example.alunos.orbit.Modelo;

/**
 * Created by Avell 1513 on 04/09/2017.
 */

public class Denuncia {

        private int ID;
        private int ID_usuario;
        private String Avaliacao;
        private String Texto;
        private Denuncia denuncia;

        public Denuncia(int id, String avaliacao, int ID_usuario,String texto,Denuncia denuncia) {
            this.ID = id;
            this.Avaliacao = avaliacao;
            this.ID_usuario=ID_usuario;
            this.Texto=texto;
            this.denuncia=denuncia;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public int getID_usuario() {
            return ID_usuario;
        }

        public void setID_usuario(int ID_usuario) {
            this.ID_usuario = ID_usuario;
        }

        public void setAvaliacao(String avaliacao) {
            Avaliacao = avaliacao;
        }

        public String getTexto() {
            return Texto;
        }

        public void setTexto(String texto) {
            Texto = texto;
        }

        public Denuncia getDenuncia() {
            return denuncia;
        }

        public void setDenuncia(Denuncia denuncia) {
            this.denuncia = denuncia;
        }

        public String getAvaliacao() {
            return Avaliacao;
        }

    }

