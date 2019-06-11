package UAS_Tes_Klustering;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cluster;
import model.Document;
import model.InvertedIndex;
import model.Posting;

/**
 *
 * @author admin
 */
public class MainCluster {
    public static void main(String[] args) {
        // buat object invertedIndex
        InvertedIndex index = new InvertedIndex();
        File file = new File("LIRIK_UAS");
        index.readDirectory(file);
        JOptionPane.showMessageDialog(null, "Load Document Successfully");
// bikin dictionary
        index.makeDictionaryWithTermNumber();
// bikin preclustering
        index.preClustering();
        for (int i = 0; i < index.getListOfDocument().size(); i++) {
            ArrayList<Posting> listPosting
                    = index.getListOfDocument().get(i).getListOfClusteringPosting();
            System.out.println("IdDoc = " + index.getListOfDocument().get(i).getId());
            for (int j = 0; j < listPosting.size(); j++) {
                System.out.println(listPosting.get(j));
            }

        }
        System.out.println("");
        index.clustering();
        for (int i = 0; i < index.getListOfCluster().size(); i++) {
            Cluster cluster = index.getListOfCluster().get(i);
            System.out.println("Cluster : " + cluster.getIdCluster());
            System.out.println("Member : ");
            for (int j = 0; j < cluster.getMember().size(); j++) {                
                System.out.println(cluster.getMember().get(j).getId()+" "+cluster.getMember().get(j).getNamaDokumen());
            }
            System.out.println("");
        }
    }
}
