package ru.bender.dartsapi;

/**
 * Created by bender on 28.09.2016.
 */
public class HomerGame extends Game {

    //------------------- Constants ------------------------------//

    public static short defaultPointsToEnd = 300;

    //------------------- Constructors ---------------------------//

    public HomerGame(short pointsToEnd) {
        super(pointsToEnd);
    }

    public HomerGame() {
        this(defaultPointsToEnd);
    }


    //------------------- open methods ---------------------------//

    /**
     * Игрок выполняет ход
     *
     * @param player - игрок
     * @param points - количество выбитых очков
     * @param countOfShots - количество бросков дротика
     * @return - игрок закончил игру?
     */
    @Override
    public boolean step(PlayerInGame player, short points, short countOfShots) {
        if(player.isEnd())
            return player.isEnd();
        short currentPointsToEnd = player.getPointsToEnd();
        currentPointsToEnd -= points;
        if (currentPointsToEnd < 0) {
            currentPointsToEnd = (short)-currentPointsToEnd;
        }
        //TODO: isCompletedWithDoubling - добавить закрытие удвоением
        player.setPointsToEnd(currentPointsToEnd);
        player.addShotsCount(countOfShots);
        //TODO: подумать может ли использоваться в другом месте. Если да, то может быть стоит перенести в сеттер игрока? Наверное не стоит... ещё будет вызываться в сбросе очков для новой игры (наверное не надо там вызывать)
        playersList.refreshPositions();
        return player.isEnd();
    }
}
