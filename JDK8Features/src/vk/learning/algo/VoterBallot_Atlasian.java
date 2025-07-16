package vk.learning.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VoterBallot_Atlasian {

	/*
	 * voters - n candidates - m return the candidates by max votes
	 */
	class Ballot {
		Integer voterId;

		List<Vote> votes;

		public Ballot(Integer voterId, List<Vote> votes) {
			this.voterId = voterId;
			this.votes = votes;
		}

		public Integer getVoterId() {
			return voterId;
		}

		public void setVoterId(Integer voterId) {
			this.voterId = voterId;
		}

		public List<Vote> getVotes() {
			return votes;
		}

		public void setVotes(List<Vote> votes) {
			this.votes = votes;
		}
	}

	class Vote {
		Candidate candidate;
		Integer points;

		public Vote(Candidate candidate, Integer points) {
			this.candidate = candidate;
			this.points = points;
		}

		public Candidate getCandidate() {
			return candidate;
		}

		public void setCandidate(Candidate candidate) {
			this.candidate = candidate;
		}

		public Integer getPoints() {
			return points;
		}

		public void setPoints(Integer points) {
			this.points = points;
		}
	}

	class Candidate {
		Integer candidateId;
		String name;

		public Candidate(Integer candidateId, String name) {
			this.candidateId = candidateId;
			this.name = name;
		}

		public Integer getCandidateId() {
			return candidateId;
		}

		public void setCandidateId(Integer candidateId) {
			this.candidateId = candidateId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public String hello() {
		return "Hello";
	}

	public static void main(String[] args) {
		VoterBallot_Atlasian assignment = new VoterBallot_Atlasian();
		List<Ballot> ballots = assignment.demoData();
		List<String> result = assignment.getResults(ballots);
		System.out.println("Candidate : ");
		result.forEach(System.out::println);
	}

	private List<Ballot> demoData() {
		List<Ballot> ballots = new ArrayList<>();

		List<Vote> votes = new ArrayList<>();
		Candidate candidate1 = new Candidate(1, "John");
		Vote vote1 = new Vote(candidate1, 3);
		Vote vote2 = new Vote(candidate1, 2);
		Vote vote3 = new Vote(candidate1, 1);
		votes.add(vote1);
		votes.add(vote2);
		votes.add(vote3);
		Ballot ballot1 = new Ballot(1, votes);
		ballots.add(ballot1);

		Candidate candidate2 = new Candidate(2, "Doe");
		votes = new ArrayList<>();
		vote2 = new Vote(candidate2, 2);
		vote3 = new Vote(candidate2, 1);
		votes.add(vote2);
		votes.add(vote3);
		Ballot ballot2 = new Ballot(2, votes);
		ballots.add(ballot2);

		return ballots;
	}

	/**
	 * Process a list of ballots, and return all candidates sorted in descending
	 * order by their total number of points.
	 */
	List<String> getResults(List<Ballot> ballots) {
		List<String> result = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();

		for (Ballot ballot : ballots) {
			for (Vote vote : ballot.getVotes()) {
				if (map.containsKey(vote.getCandidate().getName())) {
					map.put(vote.getCandidate().getName(),
							map.get(vote.getCandidate().getName()) + vote.getPoints());
				} else {
					map.put(vote.getCandidate().getName(), vote.getPoints());
				}
			}
		}
//
		/*
		 * Map<String, Integer> map1 = ballots.stream().flatMap(ballot ->
		 * ballot.getVotes().stream()) .collect(Collectors.toMap(vote ->
		 * vote.getCandidate().getName(), Vote::getPoints, Integer::sum));
		 */

		return sortByValue(map);
	}

	public List<String> sortByValue(Map<String, Integer> candidatesMap) {

		List<String> sortedCandidates = candidatesMap.entrySet().stream()
				.sorted((i1, i2) -> i1.getValue().compareTo(i2.getValue()))
				.map(entry -> entry.getKey()).collect(Collectors.toList());
		return sortedCandidates;
	}
}
