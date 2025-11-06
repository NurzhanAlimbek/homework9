package HomeTheaterFacade;


class TV {
    public void on() {
        System.out.println("TV включен");
    }
    public void off() {
        System.out.println("TV выключен");
    }
    public void setChannel(String channel) {
        System.out.println("Выбран канал: " + channel);
    }
}

class AudioSystem {
    public void on() {
        System.out.println("Аудиосистема включена");
    }
    public void off() {
        System.out.println("Аудиосистема выключена");
    }
    public void setVolume(int level) {
        System.out.println("Громкость установлена на: " + level);
    }
}

class DVDPlayer {
    public void play(String movie) {
        System.out.println("Воспроизведение фильма: " + movie);
    }
    public void pause() {
        System.out.println("Пауза DVD");
    }
    public void stop() {
        System.out.println("DVD остановлен");
    }
}

class GameConsole {
    public void on() {
        System.out.println("Игровая консоль включена");
    }
    public void playGame(String game) {
        System.out.println("Запуск игры: " + game);
    }
}


class HomeTheaterFacade {
    private TV tv;
    private AudioSystem audio;
    private DVDPlayer dvd;
    private GameConsole game;

    public HomeTheaterFacade(TV tv, AudioSystem audio, DVDPlayer dvd, GameConsole game) {
        this.tv = tv;
        this.audio = audio;
        this.dvd = dvd;
        this.game = game;
    }

    public void watchMovie(String movie) {
        System.out.println("=== Включение системы для просмотра фильма ===");
        tv.on();
        tv.setChannel("HD Movie Channel");
        audio.on();
        audio.setVolume(20);
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("=== Выключение системы ===");
        dvd.stop();
        tv.off();
        audio.off();
    }

    public void listenMusic() {
        System.out.println("=== Включение системы для прослушивания музыки ===");
        tv.on();
        audio.on();
        audio.setVolume(15);
        System.out.println("Аудиовход установлен на TV");
    }

    public void playGame(String gameName) {
        System.out.println("=== Включение игровой системы ===");
        game.on();
        game.playGame(gameName);
    }

    public void setVolume(int level) {
        audio.setVolume(level);
    }
}


class FacadePattern {
    public static void main(String[] args) {
        TV tv = new TV();
        AudioSystem audio = new AudioSystem();
        DVDPlayer dvd = new DVDPlayer();
        GameConsole game = new GameConsole();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, audio, dvd, game);

        homeTheater.watchMovie("Interstellar");
        homeTheater.endMovie();
        homeTheater.listenMusic();
        homeTheater.setVolume(25);
        homeTheater.playGame("FIFA 2025");
    }
}
