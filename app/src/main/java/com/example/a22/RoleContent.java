package com.example.a22;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RoleContent{


    private static final ArrayList<String> ROLES = new ArrayList<String>() {{
        add("Top");
        add("Jungle");
        add("Mid");
        add("Bot");
        add("Support");
    }};

    public static final List<RoleItem> ROLE_ITEMS = new ArrayList<RoleItem>();

    public static final Map<String, RoleItem> ROLE_MAP = new HashMap<String, RoleItem>();

    static {
        // Add some sample items.
        for (int i = 0; i < ROLES.size(); i++) {
            addItem(createRoleItem(i));
        }
    }

    private static void addItem(RoleItem item) {
        ROLE_ITEMS.add(item);
        ROLE_MAP.put(item.id, item);
    }

    private static RoleItem createRoleItem(int position) {
        return new RoleItem(String.valueOf(position), ROLES.get(position), makeDetails(ROLES.get(position)));
    }

    private static String makeDetails(String role) {
        StringBuilder builder = new StringBuilder();
        builder.append( role + " lane champions \n");

        switch (role) {
            case "Top":
                // Enter League of legends top lane Champions
                builder.append("Shen\nGaren\nRiven\nDarius\nFiora\n");
                break;
            case "Jungle":
                builder.append("Warwick\nLee Sin\nElise\nNidalee\nXin Zhao\n");
                break;
            case "Mid":
                builder.append("Ahri\nZed\nSyndra\nGriddygodyasuo\nYasuo\n");
                break;
            case "Bot":
                builder.append("Caitlyn\nAshe\nJhin\nDraven\nSivir\n");
                break;
            case "Support":
                builder.append("Braum\nLeona\nThresh\nMorgana\nSoraka\n");
                break;
        }

        return builder.toString();
    }


    public static class RoleItem {
        public final String id;
        public final String content;
        public final String details;

        public RoleItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}