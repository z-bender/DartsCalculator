package ru.bender.dartsapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by bender on 28.09.2016.
 */
public class PlayersInGameList {

    PlayersInGameList(ArrayList<PlayerInGame> players) {
        this.players = players;
        this.queueOfPlayersForStep = new PriorityQueue<>();
        resetListToNewGame();
    }

    PlayersInGameList() {
        this(new ArrayList<PlayerInGame>());
    }



    //----------------------- fields ------------------------------------//

    // Список игроков
    private ArrayList<PlayerInGame> players;
    // Очередь для хода TODO: удалить после реализации UI
    private PriorityQueue<PlayerInGame> queueOfPlayersForStep;


    //--------------------- public methods ------------------------------//
    //-------------------------------------------------------------------//

    /**
     * Добавить игрока
     *
     * @param player - игрок
     */
    public void addPlayer(PlayerInGame player) {
        players.add(player);
        refreshPositions();
        // TODO: добавить в очередь?
    }

    /**
     * Сбросить результаты игроков и выдать рандомные номера
     */
    void resetListToNewGame(){
        resetPlayersResult();
        shufflePlayers();
        addAllPlayersToQueue();
    }

    /*TODO - хранить прошлые состояния players - посмотреть System.arraycopy
    * копируем players после step и храним его в очереди (есть ли в java?)
    * */
    public void rollback(){}

    /**
     * Обновляем места игроков, по их результатам
     */
    void refreshPositions() {
        // TODO: сработает ли compareTo? сделать тест
        Collections.sort(players);
        for (PlayerInGame player : players) {
            player.setPosition(players);
        }
    }

    /**
     * Получить следующего игрока для хода
     *
     * @return
     */
    PlayerInGame getNextPlayerForStep() {
        PlayerInGame nextPlayer = queueOfPlayersForStep.poll();
        if (!nextPlayer.isEnd()) {
            queueOfPlayersForStep.offer(nextPlayer);
        }
        return nextPlayer;
    }



    //-------------------- Getters/Setters ------------------------//

    //-------------------- private methods ---------------------------//

    /**
     * Задаем рандомные номера для игроков
     */
    private void shufflePlayers(){
        Collections.shuffle(players);
        short number = 0;
        for (PlayerInGame player : players) {
            player.setNumber(number++);
        }
    }

    /**
     * Сбросить результаты игроков
     */
    private void resetPlayersResult() {
        for (PlayerInGame player : players) {
            player.resetResults();
        }
    }

    /**
     * Добавить всех игроков в очередь для хода
     */
    private void addAllPlayersToQueue() {
        queueOfPlayersForStep = new PriorityQueue<>();
        for (PlayerInGame player : players) {
            queueOfPlayersForStep.offer(player);
        }
    }

}
