package estudos.maya.CatFlix.service;
//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
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        final String KEY = "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";
        OpenAiService service = new OpenAiService(KEY);

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}