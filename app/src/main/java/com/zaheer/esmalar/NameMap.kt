package com.zaheer.esmalar

object NameMap {
    val items = mapOf(
        "ا" to "Allah",
        "ب" to "Baki",
        "ج" to "Cebbar" ,
        "د" to "Deyan",
        "ہ" to "Hadi",
        "و" to "Vadud",
        "ز" to "Zeki",
        "ح" to "Hasib",
        "ط" to "Tahir",
        "ی" to "Yahuvah",
        "ک" to "Kerim",
        "ك" to "Kerim",
        "ل" to "Latif",
        "م" to "Melik",
        "ن" to "Nur",
        "س" to "Selam",
        "ع" to "Aziz",
        "ف" to "Fetah",
        "ص" to "Samed",
        "ق" to "Kadir",
        "ر" to "Rehman",
        "ش" to "Şekur",
        "ت" to "Tevab",
        "ث" to "Sabit",
        "خ" to "Khaliq",
        "ذ" to "Zülcelali vel ikram",
        "ض" to "Dar",
        "ظ" to "Zahir",
        "غ" to "Gani",
    )
// ذ
    /**
     * Looks up a key (case-insensitive) and returns the corresponding name,
     * or the fallback text if no match is found.
     */
    fun getMappedName(input: String): String {
        val trimmed = input.trim()

        if (trimmed.isEmpty()) return ""

        // Process each character entered by the user
        val mappedWords = trimmed.mapNotNull { char ->
            items[char.toString()]
        }

        return when {
            // Multiple mapped characters found (e.g., "اب" -> ["Allah", "Bari"])
            mappedWords.isNotEmpty() -> {
                mappedWords.joinToString(
                    separator = " ya ",
                    prefix = "Ya ",
                    transform = { it.lowercase() }
                ).replaceFirstChar { it.uppercase() }
                // Result: "Ya Allah ya bari"
            }

            // Single character match (e.g., "ا" -> "Allah")
            //mappedWords.size == 1 -> mappedWords.first()

            // Unmapped input fallback
            else -> input
        }
    }
}
