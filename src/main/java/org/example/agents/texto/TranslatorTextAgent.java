package org.example.agents.texto;

import org.example.agents.IAgent;
import org.example.client.LlmClient;
import org.example.prompts.texto.TranslatorTextPrompt;

public class TranslatorTextAgent implements IAgent {

    private final LlmClient llmClient;

    public TranslatorTextAgent(LlmClient llmClient) {
        this.llmClient = llmClient;
    }

    @Override
    public String execute(String text) throws Exception {
        return llmClient.generate(
                TranslatorTextPrompt.build(text)
        );
    }
}
