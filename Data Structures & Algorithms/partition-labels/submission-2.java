class Solution {
    private record Coordinates(List<Coordinate> values) {

    public Coordinates mergeNonDisjoint() {
      int start = this.values().getFirst().start();
      int end = this.values().getFirst().end();
      var newCoordinates = new ArrayList<Coordinate>(this.values.size());
      for (int i = 1; i < this.values().size(); i++) {
       var value = this.values().get(i);
        if (value.start() < end) {
          end = Math.max(value.end(), end);
        } else {
          newCoordinates.add(new Coordinate(start, end));
          start = value.start();
          end = value.end();
        }
      }
      newCoordinates.add(new Coordinate(start, end));
      return new Coordinates(newCoordinates);
    }

    public List<Integer> asListOfLengthOfEach() {
      return this.values().stream()
                 .map(Coordinate::asLength)
                 .toList();
    }
  }

  private record Coordinate(int start, int end) {

    public int asLength() {
      return end - start + 1;
    }
  }

  public List<Integer> partitionLabels(String s) {
    if(s.isEmpty()) {
      return List.of();
    }
    var alphabetCoordinates = new LinkedHashMap<Character, Coordinate>();
    for (int i = 0; i < s.length(); i++) {
      char alphabet = s.charAt(i);
      int idx = i;
      alphabetCoordinates.compute(alphabet, (key, value) ->
          value == null ? new Coordinate(idx, idx) : new Coordinate(value.start(), idx)
      );
    }
    return new Coordinates(new ArrayList<>(alphabetCoordinates.values()))
        .mergeNonDisjoint().asListOfLengthOfEach();
  }
}
