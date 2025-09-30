package br.com.fiapchallenge.cadastro_challenge.business;

import br.com.fiapchallenge.cadastro_challenge.infrastructure.entity.EmojiEntity;
import br.com.fiapchallenge.cadastro_challenge.infrastructure.repository.EmojiRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmojiService {

    private final EmojiRepository emojiRepository;

    public EmojiService(EmojiRepository emojiRepository) {
        this.emojiRepository = emojiRepository;
    }

    // Mapeamento emoji -> emoção
    private static final Map<String, String> emojiToEmotion = Map.of(
            "😄", "Alegria",
            "🙂", "Feliz",
            "😐", "Neutro",
            "😔", "Tristeza",
            "😭", "Tristeza intensa"
    );

    public EmojiEntity saveEmoji(String emoji) {
        EmojiEntity entity = EmojiEntity.builder()
                .emoji(emoji)
                .build();
        return emojiRepository.save(entity);
    }

    public String getMostCommonEmotion() {
        List<EmojiEntity> emojis = emojiRepository.findAll();

        Map<String, Integer> emotionCounts = new HashMap<>();

        for (EmojiEntity e : emojis) {
            String emotion = emojiToEmotion.get(e.getEmoji());
            if (emotion != null) {
                emotionCounts.put(emotion, emotionCounts.getOrDefault(emotion, 0) + 1);
            }
        }

        if (emotionCounts.isEmpty()) {
            return "Nenhuma emoção registrada";
        }

        // Retorna a emoção com maior contagem
        return emotionCounts.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }
}
