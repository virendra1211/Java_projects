package org.ask.interview.coding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindPathWithLinkedList {

    public static void main(String[] args) {
	String fromNode = "B";
	String toNode = "E";
	List<FromToDetail> fromToDetails = new ArrayList<>();
	fromToDetails.add(new FromToDetail(1, "A", "B"));
	fromToDetails.add(new FromToDetail(2, "C", "D"));
	fromToDetails.add(new FromToDetail(3, "B", "C"));
	fromToDetails.add(new FromToDetail(4, "D", "E"));

	Map<String, FromToDetail> map = fromToDetails.stream()
		.collect(Collectors.toMap(FromToDetail::getFrom, Function.identity()));

	/*
	 * Map<String, Map<String, FromToDetail> map1= fromToDetails.stream()
	 * .collect(Collectors.toMap(FromToDetail::getFrom, Function.identity()));
	 */
	System.out.println(map);
	FromToDetail key = map.get(fromNode);
	System.out.print(" Path is:  " + key.getFrom() + " ");
	while (key != null) {
	    System.out.print(key.getTo() + " ");

	    if (map.get(key.getTo()) != null && map.get(key.getTo()).getFrom().equals(toNode)) {
		break;
	    }
	    if (map.get(key.getTo()) != null) {
		key = map.get(key.getTo());
	    } else {
		break;
	    }
	}
    }

    static Function<String, String> getFunction(List<String> names, boolean hasDuplicates) {
	// Collections.frequency(names, name) => to get duplicate count
	return hasDuplicates ? name -> name + " (" + Collections.frequency(names, name) + ")" : Function.identity();
    }

}

class FromToDetail {

    int id;
    String from;
    String to;

    public FromToDetail(int id, String from, String to) {
	super();
	this.id = id;
	this.from = from;
	this.to = to;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getFrom() {
	return from;
    }

    public void setFrom(String from) {
	this.from = from;
    }

    public String getTo() {
	return to;
    }

    public void setTo(String to) {
	this.to = to;
    }

    @Override
    public String toString() {
	return "FromToDetail [id=" + id + ", from=" + from + ", to=" + to + "]";
    }

}