package days

import days.model.EyeColour
import days.model.Passport
import java.util.ArrayList

class Day4 : Day<Long>(4) {
    override fun partOne(): Long {
        var foundFields = arrayListOf<String>()
        var countValid = 0L

//        inputString
//                .replace("\n\n", "|")
//                .replace("\n", "*")
//                .split("|")
//                .map { passportString ->
//                    passportString.trim()
//                            .split("*")
//                            .associate { f -> f.split(":")[0] to f.split(":")[1] }
//                            .let {
//                                Passport(
//                                        birthYear = it["byr"]?.toInt(),
//                                        issueYear = it["iyr"]?.toInt(),
//                                        expiryYear = it["eyr"]?.toInt(),
//                                        height = it["hgt"],
//                                        hairColour = it["hcl"],
//                                        eyeColour = EyeColour.valueOf(it["ecl"]!!),
//                                        passportId = it["pid"],
//                                        countryId = it["cid"],
//                                )
//                            }
//                }
        for (i in inputList.indices) {
            val it = inputList[i]
            if (i == inputList.indices.last) {
                val foundPattern = Regex("([a-z])+:[^ ]*").findAll(it)
                for (pattern in foundPattern.asIterable()) {
                    val elements = pattern.groupValues
                    for (group in elements) {
                        if (group.contains(':')) {
                            foundFields.add(group.substring(0, group.indexOf(':')))
                        }
                    }
                }
                if (foundFields.containsAll(Passport.requiredFields)) countValid++
                break;
            }

            if (it.isEmpty()) {
                if (foundFields.containsAll(Passport.requiredFields)) countValid++
                foundFields.clear()
                continue
            }
            val foundPattern = Regex("([a-z])+:[^ ]*").findAll(it)
            for (pattern in foundPattern.asIterable()) {
                val elements = pattern.groupValues
                for (group in elements) {
                    if (group.contains(':')) {
                        foundFields.add(group.substring(0, group.indexOf(':')))
                    }
                }
            }

        }
        return countValid
    }

    override fun partTwo(): Long {
        var foundFields = arrayListOf<String>()
        var countValid = 0L
        for (i in inputList.indices) {
            val it = inputList[i]
            if (i == inputList.indices.last) {
                val foundPattern = Regex("([a-z])+:[^ ]*").findAll(it)
                for (pattern in foundPattern.asIterable()) {
                    val elements = pattern.groupValues
                    for (group in elements) {
                        if (group.contains(':')) foundFields.add(group)
                    }
                }
                if (fieldsAreValid(foundFields) &&
                        foundFields.map { it.substringBefore(':') }.containsAll(Passport.requiredFields)) countValid++
                break;
            }

            if (it.isEmpty()) {
                if (fieldsAreValid(foundFields) &&
                        foundFields.map { it.substringBefore(':') }.containsAll(Passport.requiredFields)) countValid++
                foundFields.clear()
                continue
            }
            val foundPattern = Regex("([a-z])+:[^ ]*").findAll(it)
            for (pattern in foundPattern.asIterable()) {
                val elements = pattern.groupValues
                for (group in elements) {
                    if (group.contains(':')) foundFields.add(group)
                }
            }

        }
        return countValid
    }

    private fun fieldsAreValid(fieldsToValidate: ArrayList<String>): Boolean {
        var valid = true
        for (field in fieldsToValidate) {
            val fieldName = field.substring(0, field.indexOf(':'))
            val valueAsString = field.substring(field.indexOf(':') + 1)
            when (fieldName) {
                "cid" -> valid = true && valid
                "byr" -> valid = valueAsString.toInt() in 1920..2002 && valid
                "iyr" -> valid = valueAsString.toInt() in 2010..2020 && valid
                "eyr" -> valid = valueAsString.toInt() in 2020..2030 && valid
                "hgt" -> valid = validateHeight(valueAsString) && valid
                "hcl" -> valid = valueAsString.matches("#[0-9a-f]{6}".toRegex()) && valid
                "ecl" -> valid = valueAsString.matches("amb|blu|brn|gry|grn|hzl|oth".toRegex()) && valid
                "pid" -> valid = valueAsString.matches("[0-9]{9}".toRegex()) && valid
            }
        }
        return valid
    }

    private fun validateHeight(valueAsString: String): Boolean {
        val (value, unit) = Regex("(\\d+)(\\w{2})").find(valueAsString)
                ?.let { matchResult -> matchResult.groupValues[1] to matchResult.groupValues[2] }
                ?: "" to ""
        return when (unit) {
            "in" -> value.toInt() in 59..76
            "cm" -> value.toInt() in 150..193
            else -> false
        }
    }
}