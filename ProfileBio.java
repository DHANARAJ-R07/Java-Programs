class ProfileBio {
    public static void main(String[] args) {
        String firstName = "Arun";
        String city = "Chennai";
        String hobby = "Cricket";

        StringBuilder sb = new StringBuilder();

        sb.append(firstName)
          .append(" from ")
          .append(city)
          .append(" loves ")
          .append(hobby);

        String result = sb.toString().toUpperCase();

        System.out.println(result);
    }
}