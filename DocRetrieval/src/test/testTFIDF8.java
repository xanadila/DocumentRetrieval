/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import model.Document;
import model.InvertedIndex;
import model.Posting;
import model.Term;

/**
 *
 * @author admin
 */
public class testTFIDF8 {

    public static void main(String[] args) {
        // seting dokumen
        Document doc1 = new Document(1, "shipment of gold damaged in a fire");
        Document doc2 = new Document(2, "delivery of silver arrived in a silver truck");
        Document doc3 = new Document(3, "shipment of gold arrived in a truck");

        // buat object invertedIndex
        InvertedIndex index = new InvertedIndex();
        // tmbahkan document ke index
        index.addNewDocument(doc1);
        index.addNewDocument(doc2);
        index.addNewDocument(doc3);

        // panggil fungsi search
        index.makeDictionaryWithTermNumber();

        String query = "gold silver truck";

        ArrayList<Posting> p1 = index.makeQueryTFIDF(query);
        ArrayList<Posting> p2 = index.makeTFIDF(2);

        System.out.println(index.getInnerProduct(p1, p2));
    }
}
