package se.umu.cs.labyrinth.labyrinth.model;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;

import se.umu.cs.labyrinth.labyrinth.controller.Game;
import se.umu.cs.labyrinth.labyrinth.model.player.PlayerData;

/**
 * Created by timmy on 07/08/17.
 */
public class Parser {
    private static final int NUMB_TILES_WIDTH = 20;
    private static final int NUMB_TILES_HEIGHT = 30;
    private static final int[] levelTimes={100,200,300};

    /**
     * @return Parsed map, based upon what level the player currently is at.
     */
    public static Level parseLevel() throws IOException, XmlPullParserException {
        int levelNr = PlayerData.getLevelStatus();
        XmlPullParser  parser = setupParser();
        return parseXML(parser);
    }

    private static XmlPullParser setupParser() throws XmlPullParserException, IOException {

        InputStream inStream = null;
        int crntLevel = PlayerData.getLevelStatus();
        inStream = Game.getActivity().getApplication().getAssets().open("level_"+crntLevel+".tmx");

        XmlPullParserFactory factory = null;
        factory = XmlPullParserFactory.newInstance();
        XmlPullParser xmlParser = factory.newPullParser();
        xmlParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
        xmlParser.setInput(inStream,null);

        return xmlParser;
    }

    private static Level parseXML(XmlPullParser parser) throws XmlPullParserException, IOException {

        int eventType = parser.getEventType();
        Tile[][] tiles = new Tile[NUMB_TILES_WIDTH][NUMB_TILES_HEIGHT];
        //Split string by \0 to get rows
        //Split string by , to get columns
        String tag;
        String value = null;
        while(eventType != XmlPullParser.END_DOCUMENT) {
            tag = parser.getName();
            if(eventType == XmlPullParser.TEXT) {
                value = parser.getText();
            } else if(eventType == XmlPullParser.END_TAG) {
                if(tag.equalsIgnoreCase("data")) {
                    String[] rows =value.split("\n");
                    for(int i = 1; i < rows.length; i++) {
                        String[] row = rows[i].split(",");
                        for(int j = 0; j < row.length; j++) {
                            tiles[j][i-1] = new Tile(new Integer(row[j]));
                        }
                    }
                }
            }
            eventType = parser.next();
        }

        return new Level(tiles);
    }
}
