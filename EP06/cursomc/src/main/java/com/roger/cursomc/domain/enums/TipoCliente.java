package com.roger.cursomc.domain.enums;

public enum TipoCliente {
    PESSOAFISICA("F", "Pessoa Física"),
    PESSOAJURIDICA("J", "Pessoa Jurídica");

    private String pessoa;
    private String descricao;

    public String getPessoa() {
        return pessoa;
    }

    public String getDescricao() {
        return descricao;
    }

    private TipoCliente(String pessoa, String descricao) {
        this.pessoa = pessoa;
        this.descricao = descricao;
    }

    public static TipoCliente toEnum(String pessoa){
      if(pessoa == null){
          return null;
      }

      for (TipoCliente x : TipoCliente.values()){
         if(pessoa.equals(x.getPessoa())){
             return x;
         }
      }

      throw new IllegalArgumentException("Tipo Pessoa inválida: " + pessoa);
    }
}
