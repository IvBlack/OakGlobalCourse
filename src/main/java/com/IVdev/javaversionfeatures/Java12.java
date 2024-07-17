package com.IVdev.javaversionfeatures;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java12 {
    public static void main(String[] args) {

        //transform ��������� � �������� ��������� lambda, ���������� ������� ����� ���� ������
        var str = "Modify me!";
        var modified = str.transform(s -> s.toUpperCase());

        //++++++++++++++++++++++++++++++++++++++++++++++++
        List<Integer> nums = List.of(5,1,8,7,45,89,14);
//        var sum = nums.stream()
//                .collect(Collectors.summingInt(Integer::intValue));
//        var avg = nums.stream()
//                .collect(Collectors.averagingInt(Integer::intValue));

        /*
            https://habr.com/ru/articles/445622/
            Collectors.teeing ��������� ���������� ��������� ��������� ���� streams.
        */
        var res = nums.stream()
                .collect(Collectors.teeing(
                        Collectors.summingInt(Integer::intValue),
                        Collectors.averagingInt(Integer::intValue),
                        (sum, avg) -> "Sum: " + sum + "Avg: " + avg
                ));
        //+++++++++++++++++++++++++++++++++++++++++++++++++


        /*
            Collectors.teeing ������������ ������ �� ������ ����������
        */
        System.out.println(participantCalculating());
    }

    public static EventParticipation participantCalculating() {
        return Stream.of(
                        // Guest(String name, boolean participating, Integer participantsNumber)
                        new Guest("Marco", true, 3),
                        new Guest("David", false, 2),
                        new Guest("Roger",true, 6))
                .collect(Collectors.teeing(
                        //������ ��, ��� ���������� �������
                        Collectors.filtering(Guest::isParticipating,
                        //������ ���
                        Collectors.mapping(o -> o.name, Collectors.toList())),
                        // ������ ���������, �� ����� ����� ����� ���������� ����������
                        Collectors.summingInt(Guest::getParticipantsNumber),
                        EventParticipation::new //����������� ����������� � ����� ������
                ));
    }
}

@Data
class Guest {
    public String name;
    public boolean participating;
    public Integer participantsNumber;
    public Guest(String name, boolean participating,
                 Integer participantsNumber) {
        this.name = name;
        this.participating = participating;
        this.participantsNumber = participantsNumber;
    }
}

class EventParticipation {
    private List<String> guestNameList;
    private Integer totalNumberOfParticipants;
    public EventParticipation(List<String> guestNameList,
                              Integer totalNumberOfParticipants) {
        this.guestNameList = guestNameList;
        this.totalNumberOfParticipants = totalNumberOfParticipants;
    }

    @Override
    public String toString() {
        return "EventParticipation { " +
                "guests = " + guestNameList +
                ", total number of participants = " + totalNumberOfParticipants +
                " }";
    }
}
