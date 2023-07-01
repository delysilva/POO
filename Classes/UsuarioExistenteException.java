package Classes;

class UsuarioExistenteException extends Exception  /* RuntimeException */{
    /**
     * importante caso a exceção seja serializada
     */
    private static final long serialVersionUID = 1149241039409861914L;

    // constrói um objeto UsuarioExistenteException com a mensagem passada por parâmetro
    public UsuarioExistenteException(String msg){
        super(msg);
    }

    // contrói um objeto UsuarioExistenteException com mensagem e a causa dessa exceção, utilizado para encadear exceptions
    public UsuarioExistenteException(String msg, Throwable cause){
        super(msg, cause);
    }
}