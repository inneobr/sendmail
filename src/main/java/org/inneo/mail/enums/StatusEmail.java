package org.inneo.mail.enums;

public enum StatusEmail {

	SEND("Send"),
    NOTSEND("NotSend");

    private String descricao;

    private StatusEmail(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
