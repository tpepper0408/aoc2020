package days.model

data class Passport(
        val birthYear: Int?,
        val issueYear: Int?,
        val expiryYear: Int?,
        val height: String?,
        val hairColour: String?,
        val eyeColour: EyeColour?,
        val passportId: String?,
        val countryId: String?
) {
    companion object {
        val requiredFields by lazy {
            arrayListOf<String>(
                    "byr", // (Birth Year)
                    "iyr", // (Issue Year)
                    "eyr", // (Expiration Year)
                    "hgt", // (Height)
                    "hcl", // (Hair Color)
                    "ecl", // (Eye Color)
                    "pid", // (Passport ID)
    //            "cid" // (Country ID)

            )
        }
    }
}