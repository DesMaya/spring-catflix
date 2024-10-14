package estudos.maya.CatFlix.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
