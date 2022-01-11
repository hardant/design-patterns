package com.brandon.designPattern._7_adapter;

/**
 * 适配器将两个不同的接口的处理能里组合到一起。对外屏蔽了逻辑的具体处理细节。
 */

public class AdapterDemo {
    public static void main(String[] args) {
        MediaPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
    }
}

interface MediaPlayer {
    void play(String audioType, String fileName);
}

interface VlcPlayer {
    void playVlc(String fileName);
}

class VlcPlayerImpl implements VlcPlayer{
    public void playVlc(String fileName) {
        System.out.println(String.format("Playing vlc file, Name: %s", fileName));
    }
}

interface Mp4Player {
    void playMp4(String fileName);
}

class Mp4PlayerImpl implements Mp4Player {
    public void playMp4(String fileName) {
        System.out.println(String.format("Playing mp4 file, name: %s", fileName));
    }
}

class MediaAdapter implements MediaPlayer {
    VlcPlayer vlcPlayer = new VlcPlayerImpl();
    Mp4Player mp4Player = new Mp4PlayerImpl();

    public void play(String audioType, String fileName) {
        if (audioType.equals("vlc")) {
            vlcPlayer.playVlc(fileName);
        } else if (audioType.equals("mp4")) {
            mp4Player.playMp4(fileName);
        }
    }
}

class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter = new MediaAdapter();
    public void play(String audioType, String fileName) {
        if (audioType.equals("mp3")) {
            System.out.println(String.format("Playing mp3 file. Name: %s", fileName));
        } else if (audioType.equals("vlc") || audioType.equals("mp4")) {
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println(String.format("autoType: %s is not supported", audioType));
        }
    }
}
