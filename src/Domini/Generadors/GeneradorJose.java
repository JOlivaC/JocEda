package Domini.Generadors;

import java.util.*;

public class GeneradorJose {
	

	    private int p = -1;
	    private ArrayList<Set<Integer>> c;
	    private ArrayList<Integer> sc;
	    private ArrayList<String> pn;

	    public static void main(String[] args) {
	        GeneradorJose m = new GeneradorJose();
	        Scanner ui = new Scanner(System.in);
	        m.println("\nGamePlanner for EDA games :D Powered by J&J");
	        int op = -1;
	        do {
	            try {
	                switch (op) {
	                    case 1:
	                        m.change_players(ui);
	                        break;
	                    case 2:
	                        m.add_player_names(ui);
	                        break;
	                    case 3:
	                        m.show_rounds_pnumber();
	                        break;
	                    case 4:
	                        m.show_rounds_pname();
	                        break;
	                }
	            } catch (Exception e){
	                m.println(e.getMessage());
	            }
	            m.show_menu();
	            op = Integer.parseInt(ui.nextLine());
	        }
	        while (op!=5);

	    }

	    void show_menu(){
	        println("\n1. Change number of players.");
	        println("2. Add player names.");
	        println("3. Show rounds(by player number).");
	        println("4. Show rounds(by player name).");
	        println("5. Exit.\n");
	    }
	    
	    public ArrayList<Set<Integer>> Sort(int NPlayers) throws Exception{
	    	p = NPlayers;
	        if (p<4) p = 4;

	        // Compute combinations and sort to create the rounds.
	        c = new ArrayList<>();
	        ArrayList<Integer> v = new ArrayList<>();
	        for(int i=0; i<4; ++i) v.add(0);
	        combinations(v, 0);
	        sort_combinations();

	        return c;
	    }

	    void change_players(Scanner ui) throws Exception {
	        // Change number of players.
	        println("\nNumber of players(min=4): ");
	        String line = ui.nextLine();
	        p = Integer.parseInt(line);
	        if (p<4) p = 4;
	        println("\nPlayers: "+p);

	        // Compute combinations and sort to create the rounds.
	        c = new ArrayList<>();
	        ArrayList<Integer> v = new ArrayList<>();
	        for(int i=0; i<4; ++i) v.add(0);
	        combinations(v, 0);
	        sort_combinations();

	        // New player names list (because we have just changed the # players).
	        pn = new ArrayList<>();
	    }

	    void add_player_names(Scanner ui) throws Exception {
	        if(p==-1) throw new Exception("Number of players has not been set.");
	        println("\nType all " + p + " player names, one per line.");
	        for(int i=0; i<p; ++i) pn.add(ui.nextLine());
	        println("\nPlayer names:");
	        for(int i=0; i<p; ++i) println(i+": "+pn.get(i));
	    }

	    void show_rounds_pnumber() throws Exception {
	        if(p==-1) throw new Exception("Number of players has not been set.");
	        println("\nRounds: " + sc.size());
	        for(int i=0; i<sc.size(); ++i){
	            print("Round " + i + ": [ ");
	            for(int x : c.get(sc.get(i))) print(x+" ");
	            print("]\n");
	        }
	    }

	    void show_rounds_pname() throws Exception {
	        if(p==-1) throw new Exception("Number of players has not been set.");
	        if(pn.isEmpty()) throw new Exception("No player names found. Add them first.");
	        println("\nRounds: " + sc.size());
	        for(int i=0; i<sc.size(); ++i){
	            print("Round " + i + ": [ ");
	            for(int x : c.get(sc.get(i))) print(pn.get(x)+" ");
	            print("]\n");
	        }
	    }

	    void sort_combinations() throws Exception {
	        int[] count = new int[p];
	        boolean[] s = new boolean[c.size()];
	        sc = new ArrayList<>();
	        sc.add(0);
	        inc(count,0);
	        s[0] = true;
	        while(sc.size()<c.size()){
	            int i = find_next_comb(count,s);
	            sc.add(i);
	            inc(count,i);
	        }
	    }

	    int find_next_comb(int[] count, boolean[] s) throws Exception {
	        ArrayList<Integer> vm = vmin(count);
	        int pmax = -1;
	        int max = 0;
	        for(int i=0; i<c.size(); ++i){
	            if(!s[i]){
	                int cnt = 0;
	                for(int x : vm) if(c.get(i).contains(x)) ++cnt;
	                if (cnt>max) {
	                    max = cnt;
	                    pmax = i;
	                    if (max==4){
	                        s[pmax] = true;
	                        return pmax;
	                    }
	                }
	            }
	        }
	        if (pmax==-1) throw new Exception("next comb not found");
	        s[pmax] = true;
	        return pmax;
	    }

	    ArrayList<Integer> vmin(int[] count){
	        ArrayList<Integer> vpmin = new ArrayList<>();
	        int pmin = 0;
	        int min = count[0];
	        vpmin.add(pmin);
	        for(int i=1; i<count.length; ++i){
	            if(count[i]<min){
	                min = count[i];
	                pmin = i;
	                vpmin.clear();
	                vpmin.add(pmin);
	            }
	            else if (count[i]==min){
	                vpmin.add(i);
	            }
	        }
	        return vpmin;
	    }

	    void inc(int[] count, int i){
	        for(int x : c.get(i)) ++count[x];
	    }

	    void combinations(ArrayList<Integer> v, int pos){
	        for(int i=v.get(pos); i< p; ++i){
	            if(pos<3){
	                if(i< p -1) {
	                    v.set(pos + 1, i + 1);
	                    combinations(v,pos+1);
	                }
	            }
	            else c.add(new HashSet<>(v));
	            v.set(pos,i+1);
	        }
	    }

	    void print(String s){
	        System.out.print(s);
	    }

	    void println(String s){
	        System.out.println(s);
	    }

}
