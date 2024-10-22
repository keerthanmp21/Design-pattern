public class AdapterPatternEx1 {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "mp3_1.mp3");
        audioPlayer.play("mp4", "mp4_1.mp4");
        audioPlayer.play("vlc", "vlc_1.vlc");
        audioPlayer.play("avi", "avi_1.avi");
    }
}


// Target
interface MediaPlayer{
    void play(String audioType, String filename);
}

// Adaptee
interface AdvancedMediaPlayer{
    void playVlc(String fileName);
    void playMp4(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName){
        System.out.println("Playing vlc file. Name : " + fileName);
    }

    @Override
    public void playMp4(String fileName){}
}

class Mp4Player implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName){}

    @Override
    public void playMp4(String fileName){
        System.out.println("Playing Mp4 file. Name : " + fileName);
    }
}

// Adapter
class MediaAdapter implements MediaPlayer{
    AdvancedMediaPlayer advancedMediaPlayer;
    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer = new VlcPlayer();
        }
        else if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName){
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVlc(fileName);
        }
        else if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}

class AudioPlayer implements MediaPlayer{
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName){
        // Inbuilt support to play mp3 music files
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing mp3 file. Name : " + fileName);
        }
        else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        else{
            System.out.println("Invalid media. " + audioType + " format not supported.");
        }
    }
}