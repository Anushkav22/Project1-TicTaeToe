package org.example.tictactoe.factories;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.example.tictactoe.Strategies.botplayingstrategy.EasyBotPlayingStrategy;
import org.example.tictactoe.models.BotDifficultyLevel;
import org.example.tictactoe.Strategies.botplayingstrategy.HardBotPlayingStrategy;
import org.example.tictactoe.Strategies.botplayingstrategy.MediumBotPlayingStrategy;
import org.example.tictactoe.Strategies.botplayingstrategy.BotPlayingStrategy;



public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyFactory(BotDifficultyLevel botDifficultyLevel) {
        if(botDifficultyLevel .equals(BotDifficultyLevel.EASY)) {
            return new EasyBotPlayingStrategy();

        } else if (botDifficultyLevel.equals(botDifficultyLevel.HARD)) {
            return new HardBotPlayingStrategy();

        }else {
            return new MediumBotPlayingStrategy();
        }
    }
}
