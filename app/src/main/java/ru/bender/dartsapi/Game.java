package ru.bender.dartsapi;

/**
 * Created by bender on 27.09.2016.
 */
abstract class Game {

    //------------------- Constants ------------------------------//

    final static short defaultDartsCount = 3;

    //------------------- Constructors ---------------------------//

    public Game(short pointsToEnd) {
        this.pointsToEnd = pointsToEnd;
        this.dartsCount = defaultDartsCount;
        playersList = new PlayersInGameList();
    }


    //------------------- Fields ---------------------------------//

    // Список игроков
    PlayersInGameList playersList;
    // Количество дротиков
    protected short dartsCount;
    // Количество очков для победы
    protected short pointsToEnd;

    //-------------------- Open methods ---------------------------//

    //TODO
    public void play() {

        playersList.resetListToNewGame();
        while (true) {
            PlayerInGame player = playersList.getNextPlayerForStep();
            if (player == null) {
                break;
            }
            this.step(player, Helper.getUserInputShort("Бросает " + player.getName() + ". Введи результат: "), (short)3);
        }

    }

    /**
     * Выполнить ход игрока
     *
     * @param player - игрок
     * @param points - количество выбитых очков
     * @param countOfShots - количество бросков дротика
     * @return - игрок закончил игру?
     */
    public abstract boolean step(PlayerInGame player, short points, short countOfShots);

    //-------------------- Getters/Setters ------------------------//


    short getPointsToEnd() {
        return pointsToEnd;
    }
}
